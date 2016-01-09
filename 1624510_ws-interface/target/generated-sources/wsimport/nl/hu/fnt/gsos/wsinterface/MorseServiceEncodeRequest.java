
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
 *         &lt;element name="morseCodeSequence" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "morseCodeSequence"
})
@XmlRootElement(name = "MorseServiceEncodeRequest", namespace = "http://schemas.org.haydar/MorseService/MorseServiceEncodeRequest")
public class MorseServiceEncodeRequest {

    @XmlElement(namespace = "http://schemas.org.haydar/MorseService/MorseServiceEncodeRequest", required = true)
    protected String morseCodeSequence;

    /**
     * Gets the value of the morseCodeSequence property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMorseCodeSequence() {
        return morseCodeSequence;
    }

    /**
     * Sets the value of the morseCodeSequence property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMorseCodeSequence(String value) {
        this.morseCodeSequence = value;
    }

}
