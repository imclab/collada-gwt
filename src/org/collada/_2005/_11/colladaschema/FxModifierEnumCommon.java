//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.07.29 at 03:55:53 PM CEST 
//


package org.collada._2005._11.colladaschema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for fx_modifier_enum_common.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="fx_modifier_enum_common">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *     &lt;enumeration value="CONST"/>
 *     &lt;enumeration value="UNIFORM"/>
 *     &lt;enumeration value="VARYING"/>
 *     &lt;enumeration value="STATIC"/>
 *     &lt;enumeration value="VOLATILE"/>
 *     &lt;enumeration value="EXTERN"/>
 *     &lt;enumeration value="SHARED"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "fx_modifier_enum_common")
@XmlEnum
public enum FxModifierEnumCommon {

    CONST,
    UNIFORM,
    VARYING,
    STATIC,
    VOLATILE,
    EXTERN,
    SHARED;

    public String value() {
        return name();
    }

    public static FxModifierEnumCommon fromValue(String v) {
        return valueOf(v);
    }

}
