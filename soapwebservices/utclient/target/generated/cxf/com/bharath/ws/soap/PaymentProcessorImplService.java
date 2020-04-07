package com.bharath.ws.soap;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.3.6
 * 2020-04-05T00:03:24.090-06:00
 * Generated source version: 3.3.6
 *
 */
@WebServiceClient(name = "PaymentProcessorImplService",
                  wsdlLocation = "classpath:wsdl/paymentProcessor.wsdl",
                  targetNamespace = "http://soap.ws.bharath.com/")
public class PaymentProcessorImplService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://soap.ws.bharath.com/", "PaymentProcessorImplService");
    public final static QName PaymentProcessorImplPort = new QName("http://soap.ws.bharath.com/", "PaymentProcessorImplPort");
    static {
        URL url = PaymentProcessorImplService.class.getClassLoader().getResource("wsdl/paymentProcessor.wsdl");
        if (url == null) {
            java.util.logging.Logger.getLogger(PaymentProcessorImplService.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "classpath:wsdl/paymentProcessor.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public PaymentProcessorImplService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public PaymentProcessorImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public PaymentProcessorImplService() {
        super(WSDL_LOCATION, SERVICE);
    }

    public PaymentProcessorImplService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public PaymentProcessorImplService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public PaymentProcessorImplService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns PaymentProcessor
     */
    @WebEndpoint(name = "PaymentProcessorImplPort")
    public PaymentProcessor getPaymentProcessorImplPort() {
        return super.getPort(PaymentProcessorImplPort, PaymentProcessor.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns PaymentProcessor
     */
    @WebEndpoint(name = "PaymentProcessorImplPort")
    public PaymentProcessor getPaymentProcessorImplPort(WebServiceFeature... features) {
        return super.getPort(PaymentProcessorImplPort, PaymentProcessor.class, features);
    }

}
