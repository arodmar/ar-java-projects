/**
 * ExecuteMessageHttpGetResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.copaair.webservices;

public class ExecuteMessageHttpGetResponse  implements java.io.Serializable {
    private java.lang.String executeMessageHttpGetResult;

    public ExecuteMessageHttpGetResponse() {
    }

    public ExecuteMessageHttpGetResponse(
           java.lang.String executeMessageHttpGetResult) {
           this.executeMessageHttpGetResult = executeMessageHttpGetResult;
    }


    /**
     * Gets the executeMessageHttpGetResult value for this ExecuteMessageHttpGetResponse.
     * 
     * @return executeMessageHttpGetResult
     */
    public java.lang.String getExecuteMessageHttpGetResult() {
        return executeMessageHttpGetResult;
    }


    /**
     * Sets the executeMessageHttpGetResult value for this ExecuteMessageHttpGetResponse.
     * 
     * @param executeMessageHttpGetResult
     */
    public void setExecuteMessageHttpGetResult(java.lang.String executeMessageHttpGetResult) {
        this.executeMessageHttpGetResult = executeMessageHttpGetResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ExecuteMessageHttpGetResponse)) return false;
        ExecuteMessageHttpGetResponse other = (ExecuteMessageHttpGetResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.executeMessageHttpGetResult==null && other.getExecuteMessageHttpGetResult()==null) || 
             (this.executeMessageHttpGetResult!=null &&
              this.executeMessageHttpGetResult.equals(other.getExecuteMessageHttpGetResult())));
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
        if (getExecuteMessageHttpGetResult() != null) {
            _hashCode += getExecuteMessageHttpGetResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ExecuteMessageHttpGetResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://copaair.com/webservices/", ">ExecuteMessageHttpGetResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("executeMessageHttpGetResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://copaair.com/webservices/", "ExecuteMessageHttpGetResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
