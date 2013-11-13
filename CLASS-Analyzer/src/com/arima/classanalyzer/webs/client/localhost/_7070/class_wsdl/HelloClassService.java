
package com.arima.classanalyzer.webs.client.localhost._7070.class_wsdl;

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
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "HelloClassService", targetNamespace = "http://localhost:7070/class?wsdl", wsdlLocation = "http://localhost:7070/class?wsdl")
public class HelloClassService
    extends Service
{

    private final static URL HELLOCLASSSERVICE_WSDL_LOCATION;
    private final static WebServiceException HELLOCLASSSERVICE_EXCEPTION;
    private final static QName HELLOCLASSSERVICE_QNAME = new QName("http://localhost:7070/class?wsdl", "HelloClassService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:7070/class?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        HELLOCLASSSERVICE_WSDL_LOCATION = url;
        HELLOCLASSSERVICE_EXCEPTION = e;
    }

    public HelloClassService() {
        super(__getWsdlLocation(), HELLOCLASSSERVICE_QNAME);
    }

    public HelloClassService(WebServiceFeature... features) {
        super(__getWsdlLocation(), HELLOCLASSSERVICE_QNAME, features);
    }

    public HelloClassService(URL wsdlLocation) {
        super(wsdlLocation, HELLOCLASSSERVICE_QNAME);
    }

    public HelloClassService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, HELLOCLASSSERVICE_QNAME, features);
    }

    public HelloClassService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public HelloClassService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns Hello
     */
    @WebEndpoint(name = "HelloClassPort")
    public Hello getHelloClassPort() {
        return super.getPort(new QName("http://localhost:7070/class?wsdl", "HelloClassPort"), Hello.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns Hello
     */
    @WebEndpoint(name = "HelloClassPort")
    public Hello getHelloClassPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://localhost:7070/class?wsdl", "HelloClassPort"), Hello.class, features);
    }

    private static URL __getWsdlLocation() {
        if (HELLOCLASSSERVICE_EXCEPTION!= null) {
            throw HELLOCLASSSERVICE_EXCEPTION;
        }
        return HELLOCLASSSERVICE_WSDL_LOCATION;
    }

}