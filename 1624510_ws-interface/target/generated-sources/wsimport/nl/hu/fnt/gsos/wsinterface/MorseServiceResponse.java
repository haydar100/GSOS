
package nl.hu.fnt.gsos.wsinterface;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="morseCodeResult" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "morseCodeResult"
})
@XmlRootElement(name = "MorseServiceResponse", namespace = "http://schemas.org.haydar/MorseService/MorseServiceResponse")
public class MorseServiceResponse {

    @XmlElement(namespace = "http://schemas.org.haydar/MorseService/MorseServiceResponse", required = true)
    protected String morseCodeResult;

    /**
     * Gets the value of the morseCodeResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMorseCodeResult() {
        return morseCodeResult;
    }

    /**
     * Sets the value of the morseCodeResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMorseCodeResult(String value) {
        this.morseCodeResult = value;
    }

}
