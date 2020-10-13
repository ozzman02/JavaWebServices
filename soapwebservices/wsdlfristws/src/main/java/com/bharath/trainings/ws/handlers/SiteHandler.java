package com.bharath.trainings.ws.handlers;


import javax.xml.namespace.QName;
import javax.xml.soap.*;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import java.util.Iterator;
import java.util.Set;

public class SiteHandler implements SOAPHandler<SOAPMessageContext> {

    @Override
    public Set<QName> getHeaders() {
        System.out.println("GetHeaders");
        return null;
    }

    @Override
    public boolean handleMessage(SOAPMessageContext context) {
        System.out.println("HandleMessage");
        Boolean isResponse = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        if (!isResponse) {
            SOAPMessage soapMessage = context.getMessage();
            try {
                SOAPEnvelope soapEnvelope = soapMessage.getSOAPPart().getEnvelope();
                SOAPHeader soapHeader = soapEnvelope.getHeader();
                Iterator childElements = soapHeader.getChildElements();
                while (childElements.hasNext()) {
                    Node eachNode = (Node) childElements.next();
                    String name = eachNode.getLocalName();
                    if (name != null && name.equals("SiteName")) {
                        System.out.println("Site Name is ======> " + eachNode.getValue());
                    }
                }
            } catch (SOAPException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Response on the way");
        }
        return true;
    }

    @Override
    public boolean handleFault(SOAPMessageContext context) {
        System.out.println("HandleFault");
        return false;
    }

    @Override
    public void close(MessageContext context) {
        System.out.println("Close");
    }
}
