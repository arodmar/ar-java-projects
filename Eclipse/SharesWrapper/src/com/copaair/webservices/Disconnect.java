/**
 * Disconnect.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.copaair.webservices;

public class Disconnect  implements java.io.Serializable {
    private java.lang.String server;

    private java.lang.String host;

    private java.lang.String connectionID;

    private int timeOutRetries;

    public Disconnect() {
    }

    public Disconnect(
           java.lang.String server,
           java.lang.String host,
           java.lang.String connectionID,
           int timeOutRetries) {
           this.server = server;
           this.host = host;
           this.connectionID = connectionID;
           this.timeOutRetries = timeOutRetries;
    }


    /**
     * Gets the server value for this Disconnect.
     * 
     * @return server
     */
    public java.lang.String getServer() {
        return server;
    }


    /**
     * Sets the server value for this Disconnect.
     * 
     * @param server
     */
    public void setServer(java.lang.String server) {
        this.server = server;
    }


    /**
     * Gets the host value for this Disconnect.
     * 
     * @return host
     */
    public java.lang.String getHost() {
        return host;
    }


    /**
     * Sets the host value for this Disconnect.
     * 
     * @param host
     */
    public void setHost(java.lang.String host) {
        this.host = host;
    }


    /**
     * Gets the connectionID value for this Disconnect.
     * 
     * @return connectionID
     */
    public java.lang.String getConnectionID() {
        return connectionID;
    }


    /**
     * Sets the connectionID value for this Disconnect.
     * 
     * @param connectionID
     */
    public void setConnectionID(java.lang.String connectionID) {
        this.connectionID = connectionID;
    }


    /**
     * Gets the timeOutRetries value for this Disconnect.
     * 
     * @return timeOutRetries
     */
    public int getTimeOutRetries() {
        return timeOutRetries;
    }


    /**
     * Sets the timeOutRetries value for this Disconnect.
     * 
     * @param timeOutRetries
     */
    public void setTimeOutRetries(int timeOutRetries) {
        this.timeOutRetries = timeOutRetries;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Disconnect)) return false;
        Disconnect other = (Disconnect) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.server==null && other.getServer()==null) || 
             (this.server!=null &&
              this.server.equals(other.getServer()))) &&
            ((this.host==null && other.getHost()==null) || 
             (this.host!=null &&
              this.host.equals(other.getHost()))) &&
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
        if (getServer() != null) {
            _hashCode += getServer().hashCode();
        }
        if (getHost() != null) {
            _hashCode += getHost().hashCode();
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
        new org.apache.axis.description.TypeDesc(Disconnect.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://copaair.com/webservices/", ">Disconnect"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("server");
        elemField.setXmlName(new javax.xml.namespace.QName("http://copaair.com/webservices/", "Server"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("host");
        elemField.setXmlName(new javax.xml.namespace.QName("http://copaair.com/webservices/", "Host"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
