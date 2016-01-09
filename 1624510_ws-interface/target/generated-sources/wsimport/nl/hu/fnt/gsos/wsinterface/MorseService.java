
package nl.hu.fnt.gsos.wsinterface;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "MorseService", targetNamespace = "http://schemas.org.haydar/MorseService", wsdlLocation = "file:/C:/Users/Berkan/Desktop/1624510_ws-parent/1624510_ws-interface/src/main/webapp/wsdl/MorseService.wsdl")
public class MorseService
    extends Service
{

    private final static URL MORSESERVICE_WSDL_LOCATION;
    private final static WebServiceException MORSESERVICE_EXCEPTION;
    private final static QName MORSESERVICE_QNAME = new QName("http://schemas.org.haydar/MorseService", "MorseService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("file:/C:/Users/Berkan/Desktop/1624510_ws-parent/1624510_ws-interface/src/main/webapp/wsdl/MorseService.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        MORSESERVICE_WSDL_LOCATION = url;
        MORSESERVICE_EXCEPTION = e;
    }

    public MorseService() {
        super(__getWsdlLocation(), MORSESERVICE_QNAME);
    }

    public MorseService(WebServiceFeature... features) {
        super(__getWsdlLocation(), MORSESERVICE_QNAME, features);
    }

    public MorseService(URL wsdlLocation) {
        super(wsdlLocation, MORSESERVICE_QNAME);
    }

    public MorseService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, MORSESERVICE_QNAME, features);
    }

    public MorseService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public MorseService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns WSInterface
     */
    @WebEndpoint(name = "WS-Port")
    public WSInterface getWSPort() {
        return super.getPort(new QName("http://schemas.org.haydar/MorseService", "WS-Port"), WSInterface.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns WSInterface
     */
    @WebEndpoint(name = "WS-Port")
    public WSInterface getWSPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://schemas.org.haydar/MorseService", "WS-Port"), WSInterface.class, features);
    }

    private static URL __getWsdlLocation() {
        if (MORSESERVICE_EXCEPTION!= null) {
            throw MORSESERVICE_EXCEPTION;
        }
        return MORSESERVICE_WSDL_LOCATION;
    }

}
