/**
 * 
 */
package nl.hu.fnt.gsos.wsproducer;

import java.util.HashMap;
import java.util.Map.Entry;

import javax.jws.WebService;

import nl.hu.fnt.gsos.wsinterface.MorseServiceDecodeRequest;
import nl.hu.fnt.gsos.wsinterface.MorseServiceEncodeRequest;
import nl.hu.fnt.gsos.wsinterface.MorseServiceFault;
import nl.hu.fnt.gsos.wsinterface.MorseServiceFaultMessage;
import nl.hu.fnt.gsos.wsinterface.MorseServiceHeader;
import nl.hu.fnt.gsos.wsinterface.MorseServiceResponse;
import nl.hu.fnt.gsos.wsinterface.WSInterface;

/**
 * @author Haydar Berkan Yilmaz
 *
 */
@WebService(endpointInterface = "nl.hu.fnt.gsos.wsinterface.WSInterface")
public class MorseServiceImpl implements WSInterface {
	private HashMap<String, String> characterToMorseMap;

	public MorseServiceImpl() {
		characterToMorseMap = new HashMap<String, String>();
		characterToMorseMap.put("A", ".-");
		characterToMorseMap.put("B", "-...");
		characterToMorseMap.put("C", "-.-.");
		characterToMorseMap.put("D", "-..");
		characterToMorseMap.put("E", ".");
		characterToMorseMap.put("F", "..-.");
		characterToMorseMap.put("G", "--.");
		characterToMorseMap.put("H", "....");
		characterToMorseMap.put("I", "..");
		characterToMorseMap.put("J", ".---");
		characterToMorseMap.put("K", "-.-");
		characterToMorseMap.put("L", ".-..");
		characterToMorseMap.put("M", "--");
		characterToMorseMap.put("N", "-.");
		characterToMorseMap.put("O", "---");
		characterToMorseMap.put("P", ".--.");
		characterToMorseMap.put("Q", "--.-");
		characterToMorseMap.put("R", ".-.");
		characterToMorseMap.put("S", "...");
		characterToMorseMap.put("T", "-");
		characterToMorseMap.put("U", "..-");
		characterToMorseMap.put("V", "...-");
		characterToMorseMap.put("W", ".--");
		characterToMorseMap.put("X", "-..-");
		characterToMorseMap.put("Y", "-.--");
		characterToMorseMap.put("Z", "-");
		characterToMorseMap.put("1", ".----");
		characterToMorseMap.put("2", "..--");
		characterToMorseMap.put("3", "...-.");
		characterToMorseMap.put("4", "....-");
		characterToMorseMap.put("5", ".....");
		characterToMorseMap.put("6", "-...");
		characterToMorseMap.put("7", "--..");
		characterToMorseMap.put("8", "---.");
		characterToMorseMap.put("9", "---.");
		characterToMorseMap.put("0", "---.");

	}

	@Override
	public MorseServiceResponse decodeMorseCode(MorseServiceHeader header,
			MorseServiceDecodeRequest request) throws MorseServiceFaultMessage {
		MorseServiceResponse response = new MorseServiceResponse();

		if (request.getMorseCodeSequence() != null
				&& request.getSeparator() != null
				&& request.getSeparator().trim().length() > 0) {
			if (header.getPostCode() != null
					&& header.getPostCode().trim().length() > 0
					&& header.getPostCode().startsWith("82")) {
				String output = "";
				String morseCode = request.getMorseCodeSequence();
				String seperator = request.getSeparator();
				if (morseCode.isEmpty()) {
					MorseServiceFault error = new MorseServiceFault();
					throw new MorseServiceFaultMessage(
							"The MorseCodeSequence is empty", error);
				}
				if (seperator.equals("|")) { // SOAP ESCAPE
					MorseServiceFault error = new MorseServiceFault();
					throw new MorseServiceFaultMessage(
							"The | is an invalid seperator", error);
				}
				String[] splittedArray = morseCode.split(seperator);
				for (int i = 0; i < splittedArray.length; i++) {
					for (Entry<String, String> entry : characterToMorseMap
							.entrySet()) {
						if (entry.getValue().equals(splittedArray[i])) {
							output = output + entry.getKey();

						}
					}

				}
				response.setMorseCodeResult(output.toLowerCase());

			} else {
				MorseServiceFault error = new MorseServiceFault();
				throw new MorseServiceFaultMessage(
						"Postcode Authentication Failed ", error);

			}
		} else {
			MorseServiceFault error = new MorseServiceFault();
			throw new MorseServiceFaultMessage(
					"Seperator field is empty or MorseCodeSequence is empty please check",
					error);

		}

		return response;
	}

	@Override
	public MorseServiceResponse encodeMorseCode(MorseServiceHeader header,
			MorseServiceEncodeRequest request) throws MorseServiceFaultMessage {
		MorseServiceResponse response = new MorseServiceResponse();

		if (request.getMorseCodeSequence() != null
				&& request.getMorseCodeSequence().trim().length() > 0
				&& !header.getPostCode().isEmpty()
				&& header.getPostCode().startsWith("82")) {
			char[] charArray = request.getMorseCodeSequence().toUpperCase()
					.toCharArray();

			String output = "";

			for (int i = 0; i < charArray.length; i++) {

				if (characterToMorseMap.get(String.valueOf(charArray[i])) != null) {
					output = output
							+ characterToMorseMap.get(String.valueOf(charArray[i]));
				} else {
					output = output + "";
				}
				if (i < charArray.length - 1) {
					output = output + ","; // , is de seperator hardcoded
				}
			
			}
			response.setMorseCodeResult(output);
		} else {
			MorseServiceFault error = new MorseServiceFault();
			error.setMessage("Postcode is null or doesn't start with 82");
			throw new MorseServiceFaultMessage(
					"MorseCodeSequence is null or zipcode is null or does not contain 82",
					error);
		}

		return response;

	}

	public static void main(String[] args) throws MorseServiceFaultMessage {
		MorseServiceImpl implementation = new MorseServiceImpl();
		// MorseServiceEncodeRequest request = new MorseServiceEncodeRequest();
		// request.setMorseCodeSequence("haydar");
		// MorseServiceResponse response =
		// implementation.encodeMorseCode(request);
		MorseServiceDecodeRequest request = new MorseServiceDecodeRequest();
		request.setMorseCodeSequence("....,.-,-.--,-..,.-,.-.");
		request.setSeparator(",");
		MorseServiceHeader header = new MorseServiceHeader();
		header.setPostCode("8223AS");
		MorseServiceResponse response = implementation.decodeMorseCode(header,
				request);

		System.out.println(response.getMorseCodeResult());

	}

}
