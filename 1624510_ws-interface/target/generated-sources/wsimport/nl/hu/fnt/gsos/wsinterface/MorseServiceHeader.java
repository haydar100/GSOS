
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
 *         &lt;element name="bedrijfsNaam" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="postCode">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;pattern value="[1\u20109][0\u20109]{3}[A\u2010Z]{2}"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="huisNummer">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;pattern value="[1\u20109][0\u20109]{0,4}"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
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
    "bedrijfsNaam",
    "postCode",
    "huisNummer"
})
@XmlRootElement(name = "MorseServiceHeader")
public class MorseServiceHeader {

    @XmlElement(required = true)
    protected String bedrijfsNaam;
    @XmlElement(required = true)
    protected String postCode;
    @XmlElement(required = true)
    protected String huisNummer;

    /**
     * Gets the value of the bedrijfsNaam property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBedrijfsNaam() {
        return bedrijfsNaam;
    }

    /**
     * Sets the value of the bedrijfsNaam property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBedrijfsNaam(String value) {
        this.bedrijfsNaam = value;
    }

    /**
     * Gets the value of the postCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostCode() {
        return postCode;
    }

    /**
     * Sets the value of the postCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostCode(String value) {
        this.postCode = value;
    }

    /**
     * Gets the value of the huisNummer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHuisNummer() {
        return huisNummer;
    }

    /**
     * Sets the value of the huisNummer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHuisNummer(String value) {
        this.huisNummer = value;
    }

}
