/**
 * ExecuteMessage.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.copaair.webservices;

public class ExecuteMessage  implements java.io.Serializable {
    private java.lang.String transactionName;

    private com.copaair.webservices.ExecuteMessageMessage message;

    private java.lang.String connectionID;

    private int timeOutRetries;

    public ExecuteMessage() {
    }

    public ExecuteMessage(
           java.lang.String transactionName,
           com.copaair.webservices.ExecuteMessageMessage message,
           java.lang.String connectionID,
           int timeOutRetries) {
           this.transactionName = transactionName;
           this.message = message;
           this.connectionID = connectionID;
           this.timeOutRetries = timeOutRetries;
    }


    /**
     * Gets the transactionName value for this ExecuteMessage.
     * 
     * @return transactionName
     */
    public java.lang.String getTransactionName() {
        return transactionName;
    }


    /**
     * Sets the transactionName value for this ExecuteMessage.
     * 
     * @param transactionName
     */
    public void setTransactionName(java.lang.String transactionName) {
        this.transactionName = transactionName;
    }


    /**
     * Gets the message value for this ExecuteMessage.
     * 
     * @return message
     */
    public com.copaair.webservices.ExecuteMessageMessage getMessage() {
        return message;
    }


    /**
     * Sets the message value for this ExecuteMessage.
     * 
     * @param message
     */
    public void setMessage(com.copaair.webservices.ExecuteMessageMessage message) {
        this.message = message;
    }


    /**
     * Gets the connectionID value for this ExecuteMessage.
     * 
     * @return connectionID
     */
    public java.lang.String getConnectionID() {
        return connectionID;
    }


    /**
     * Sets the connectionID value for this ExecuteMessage.
     * 
     * @param connectionID
     */
    public void setConnectionID(java.lang.String connectionID) {
        this.connectionID = connectionID;
    }


    /**
     * Gets the timeOutRetries value for this ExecuteMessage.
     * 
     * @return timeOutRetries
     */
    public int getTimeOutRetries() {
        return timeOutRetries;
    }


    /**
     * Sets the timeOutRetries value for this ExecuteMessage.
     * 
     * @param timeOutRetries
     */
    public void setTimeOutRetries(int timeOutRetries) {
        this.timeOutRetries = timeOutRetries;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ExecuteMessage)) return false;
        ExecuteMessage other = (ExecuteMessage) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.transactionName==null && other.getTransactionName()==null) || 
             (this.transactionName!=null &&
              this.transactionName.equals(other.getTransactionName()))) &&
            ((this.message==null && other.getMessage()==null) || 
             (this.message!=null &&
              this.message.equals(other.getMessage()))) &&
            ((this.connectionID==null && other.getConnectionID()==null) || 
             (this.connectionID!=null &&
              this.connectionID.equals(other.getConnectionID()))) &&
            this.timeOutRetries == other.getTimeOutRetries();
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
        if (getTransactionName() != null) {
            _hashCode += getTransactionName().hashCode();
        }
        if (getMessage() != null) {
            _hashCode += getMessage().hashCode();
        }
        if (getConnectionID() != null) {
            _hashCode += getConnectionID().hashCode();
        }
        _hashCode += getTimeOutRetries();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ExecuteMessage.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://copaair.com/webservices/", ">ExecuteMessage"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("transactionName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://copaair.com/webservices/", "TransactionName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("message");
        elemField.setXmlName(new javax.xml.namespace.QName("http://copaair.com/webservices/", "Message"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://copaair.com/webservices/", ">>ExecuteMessage>Message"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("connectionID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://copaair.com/webservices/", "ConnectionID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("timeOutRetries");
        elemField.setXmlName(new javax.xml.namespace.QName("http://copaair.com/webservices/", "TimeOutRetries"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
