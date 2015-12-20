/**
 * DisconnectResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.copaair.webservices;

public class DisconnectResponse  implements java.io.Serializable {
    private com.copaair.webservices.DisconnectResponseDisconnectResult disconnectResult;

    public DisconnectResponse() {
    }

    public DisconnectResponse(
           com.copaair.webservices.DisconnectResponseDisconnectResult disconnectResult) {
           this.disconnectResult = disconnectResult;
    }


    /**
     * Gets the disconnectResult value for this DisconnectResponse.
     * 
     * @return disconnectResult
     */
    public com.copaair.webservices.DisconnectResponseDisconnectResult getDisconnectResult() {
        return disconnectResult;
    }


    /**
     * Sets the disconnectResult value for this DisconnectResponse.
     * 
     * @param disconnectResult
     */
    public void setDisconnectResult(com.copaair.webservices.DisconnectResponseDisconnectResult disconnectResult) {
        this.disconnectResult = disconnectResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DisconnectResponse)) return false;
        DisconnectResponse other = (DisconnectResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.disconnectResult==null && other.getDisconnectResult()==null) || 
             (this.disconnectResult!=null &&
              this.disconnectResult.equals(other.getDisconnectResult())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getDisconnectResult() != null) {
            _hashCode += getDisconnectResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DisconnectResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://copaair.com/webservices/", ">DisconnectResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("disconnectResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://copaair.com/webservices/", "DisconnectResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://copaair.com/webservices/", ">>DisconnectResponse>DisconnectResult"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
