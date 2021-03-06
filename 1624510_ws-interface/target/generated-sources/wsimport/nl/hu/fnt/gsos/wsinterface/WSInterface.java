
package nl.hu.fnt.gsos.wsinterface;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebService(name = "WS-Interface", targetNamespace = "http://schemas.org.haydar/MorseService")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface WSInterface {


    /**
     * 
     * @param morseServiceEncodeRequest
     * @param morseServiceHeader
     * @return
     *     returns nl.hu.fnt.gsos.wsinterface.MorseServiceResponse
     * @throws MorseServiceFaultMessage
     */
    @WebMethod(action = "encodeMorseCode")
    @WebResult(name = "MorseServiceResponse", targetNamespace = "http://schemas.org.haydar/MorseService/MorseServiceResponse", partName = "MorseServiceResponse")
    public MorseServiceResponse encodeMorseCode(
        @WebParam(name = "MorseServiceHeader", targetNamespace = "http://schemas.org.haydar/MorseService/header", header = true, partName = "MorseServiceHeader")
        MorseServiceHeader morseServiceHeader,
        @WebParam(name = "MorseServiceEncodeRequest", targetNamespace = "http://schemas.org.haydar/MorseService/MorseServiceEncodeRequest", partName = "MorseServiceEncodeRequest")
        MorseServiceEncodeRequest morseServiceEncodeRequest)
        throws MorseServiceFaultMessage
    ;

    /**
     * 
     * @param morseServiceDecodeRequest
     * @param morseServiceHeader
     * @return
     *     returns nl.hu.fnt.gsos.wsinterface.MorseServiceResponse
     * @throws MorseServiceFaultMessage
     */
    @WebMethod(action = "decodeMorseCode")
    @WebResult(name = "MorseServiceResponse", targetNamespace = "http://schemas.org.haydar/MorseService/MorseServiceResponse", partName = "MorseServiceResponse")
    public MorseServiceResponse decodeMorseCode(
        @WebParam(name = "MorseServiceHeader", targetNamespace = "http://schemas.org.haydar/MorseService/header", header = true, partName = "MorseServiceHeader")
        MorseServiceHeader morseServiceHeader,
        @WebParam(name = "MorseServiceDecodeRequest", targetNamespace = "http://schemas.org.haydar/MorseService/MorseServiceDecodeRequest", partName = "MorseServiceDecodeRequest")
        MorseServiceDecodeRequest morseServiceDecodeRequest)
        throws MorseServiceFaultMessage
    ;

}
