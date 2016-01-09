
package nl.hu.fnt.gsos.wsinterface;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the nl.hu.fnt.gsos.wsinterface package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: nl.hu.fnt.gsos.wsinterface
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link MorseServiceHeader }
     * 
     */
    public MorseServiceHeader createMorseServiceHeader() {
        return new MorseServiceHeader();
    }

    /**
     * Create an instance of {@link MorseServiceDecodeRequest }
     * 
     */
    public MorseServiceDecodeRequest createMorseServiceDecodeRequest() {
        return new MorseServiceDecodeRequest();
    }

    /**
     * Create an instance of {@link MorseServiceEncodeRequest }
     * 
     */
    public MorseServiceEncodeRequest createMorseServiceEncodeRequest() {
        return new MorseServiceEncodeRequest();
    }

    /**
     * Create an instance of {@link MorseServiceResponse }
     * 
     */
    public MorseServiceResponse createMorseServiceResponse() {
        return new MorseServiceResponse();
    }

    /**
     * Create an instance of {@link MorseServiceFault }
     * 
     */
    public MorseServiceFault createMorseServiceFault() {
        return new MorseServiceFault();
    }

}
