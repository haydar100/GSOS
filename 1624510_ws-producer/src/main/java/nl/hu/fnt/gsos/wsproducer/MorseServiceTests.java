package nl.hu.fnt.gsos.wsproducer;

import static org.junit.Assert.assertTrue;
import nl.hu.fnt.gsos.wsinterface.MorseServiceDecodeRequest;
import nl.hu.fnt.gsos.wsinterface.MorseServiceEncodeRequest;
import nl.hu.fnt.gsos.wsinterface.MorseServiceFaultMessage;
import nl.hu.fnt.gsos.wsinterface.MorseServiceHeader;
import nl.hu.fnt.gsos.wsinterface.MorseServiceResponse;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Haydar Berkan Yilmaz
 *
 */
public class MorseServiceTests {
	private MorseServiceImpl implementation;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		implementation = new MorseServiceImpl();
	}

	@Test(expected = MorseServiceFaultMessage.class)
	public void testEncodeWithNullValue() throws MorseServiceFaultMessage {
		MorseServiceEncodeRequest req = new MorseServiceEncodeRequest();
		req.setMorseCodeSequence(null);
		MorseServiceHeader header = new MorseServiceHeader();
		header.setPostCode("8223AS");
		implementation.encodeMorseCode(header, req);
	}

	@Test
	public void testEncodeForCorrectOutput() throws MorseServiceFaultMessage {
		MorseServiceEncodeRequest req = new MorseServiceEncodeRequest();
		req.setMorseCodeSequence("haydar");
		MorseServiceHeader header = new MorseServiceHeader();
		header.setPostCode("8223AS");
		MorseServiceResponse resp = implementation.encodeMorseCode(header, req);
		//System.out.println(resp.getMorseCodeResult());
		assertTrue(resp.getMorseCodeResult().equals("....,.-,-.--,-..,.-,.-."));
	}

	@Test(expected = MorseServiceFaultMessage.class)
	public void testDecodeNullSeperator() throws MorseServiceFaultMessage {
		MorseServiceDecodeRequest req = new MorseServiceDecodeRequest();
		req.setSeparator(null);
		req.setMorseCodeSequence("test");
		MorseServiceHeader header = new MorseServiceHeader();
		header.setPostCode("8223AS");
		implementation.decodeMorseCode(header, req);
	}

	@Test(expected = MorseServiceFaultMessage.class)
	public void testDecodeNullSeperatorNullCodeSequence()
			throws MorseServiceFaultMessage {
		MorseServiceDecodeRequest req = new MorseServiceDecodeRequest();
		req.setSeparator(null);
		req.setMorseCodeSequence(null);
		MorseServiceHeader header = new MorseServiceHeader();
		header.setPostCode("8223AS");
		implementation.decodeMorseCode(header, req);
	}

	@Test
	public void testDecodeForCorrectOutput() throws MorseServiceFaultMessage {

		MorseServiceDecodeRequest req = new MorseServiceDecodeRequest();
		req.setSeparator(",");
		req.setMorseCodeSequence("....,.-,-.--,-..,.-,.-.");
		MorseServiceHeader header = new MorseServiceHeader();
		header.setPostCode("8223AS");
		MorseServiceResponse resp = implementation.decodeMorseCode(header, req);
		assertTrue(resp.getMorseCodeResult().equals("haydar"));

	}

	@Test(expected = MorseServiceFaultMessage.class)
	public void testDecodeEmptySeperator() throws MorseServiceFaultMessage {
		MorseServiceDecodeRequest req = new MorseServiceDecodeRequest();
		req.setSeparator("");
		req.setMorseCodeSequence("-..,---,");
		MorseServiceHeader header = new MorseServiceHeader();
		header.setPostCode("8223AS");
		implementation.decodeMorseCode(header, req);
	}

	@Test(expected = MorseServiceFaultMessage.class)
	public void testDecodeWithNullMorseCodeValue()
			throws MorseServiceFaultMessage {
		MorseServiceDecodeRequest req = new MorseServiceDecodeRequest();
		req.setMorseCodeSequence(null);
		MorseServiceHeader header = new MorseServiceHeader();
		header.setPostCode("8223AS");
		implementation.decodeMorseCode(header, req);
	}

	@Test(expected = MorseServiceFaultMessage.class)
	public void testDecodeWithNullPostcodeCodeValue()
			throws MorseServiceFaultMessage {
		MorseServiceDecodeRequest req = new MorseServiceDecodeRequest();
		req.setMorseCodeSequence("....,.-,-.--,-..,.-,.-.");
		req.setSeparator(",");
		MorseServiceHeader header = new MorseServiceHeader();
		header.setPostCode(null);
		implementation.decodeMorseCode(header, req);
	}

	@Test(expected = MorseServiceFaultMessage.class)
	public void testDecodeWithEmptyPostcodeCodeValue()
			throws MorseServiceFaultMessage {
		MorseServiceDecodeRequest req = new MorseServiceDecodeRequest();
		req.setMorseCodeSequence("....,.-,-.--,-..,.-,.-.");
		req.setSeparator(",");
		MorseServiceHeader header = new MorseServiceHeader();
		header.setPostCode("");
		implementation.decodeMorseCode(header, req);
	}

	@Test
	public void testDecodeWithValidPostcodeCodeValue()
			throws MorseServiceFaultMessage {
		MorseServiceDecodeRequest req = new MorseServiceDecodeRequest();
		req.setMorseCodeSequence("....,.-,-.--,-..,.-,.-.");
		req.setSeparator(",");
		MorseServiceHeader header = new MorseServiceHeader();
		header.setPostCode("8231AS");
		implementation.decodeMorseCode(header, req);
		assertTrue(header.getPostCode().equals("8231AS"));
	}

	@Test(expected = MorseServiceFaultMessage.class)
	public void testDecodeWithInvalidPostcodeCodeValue()
			throws MorseServiceFaultMessage {
		MorseServiceDecodeRequest req = new MorseServiceDecodeRequest();
		req.setMorseCodeSequence("....,.-,-.--,-..,.-,.-.");
		req.setSeparator(",");
		MorseServiceHeader header = new MorseServiceHeader();
		header.setPostCode("a31AS");
		implementation.decodeMorseCode(header, req);
	}

}
