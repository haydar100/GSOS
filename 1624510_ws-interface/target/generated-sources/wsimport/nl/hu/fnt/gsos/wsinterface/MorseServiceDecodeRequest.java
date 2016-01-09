
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
 *         &lt;element name="separator" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "separator",
    "morseCodeSequence"
})
@XmlRootElement(name = "MorseServiceDecodeRequest", namespace = "http://schemas.org.haydar/MorseService/MorseServiceDecodeRequest")
public class MorseServiceDecodeRequest {

    @XmlElement(namespace = "http://schemas.org.haydar/MorseService/MorseServiceDecodeRequest", required = true)
    protected String separator;
    @XmlElement(namespace = "http://schemas.org.haydar/MorseService/MorseServiceDecodeRequest", required = true)
    protected String morseCodeSequence;

    /**
     * Gets the value of the separator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSeparator() {
        return separator;
    }

    /**
     * Sets the value of the separator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSeparator(String value) {
        this.separator = value;
    }

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
