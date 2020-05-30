package com.oscars.jaxbxjc;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.oscars.patient.Patient;

public class App {
    
	public static Patient createPatient() {
		Patient patient = new Patient();
		patient.setId(123);
		patient.setName("Oscar");
		return patient;
	}
	
	/* 
	 * Convert to XML
	 */
	public static StringWriter marshallPatient(JAXBContext context) throws JAXBException {
		StringWriter stringWriter = new StringWriter();
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.marshal(createPatient(), stringWriter);
		return stringWriter;
	}
	
	/*
	 * Convert to Java object
	 */
	public static Patient unMarshallPatient(JAXBContext context, StringWriter stringWriter) throws JAXBException {
		Unmarshaller unMarshaller = context.createUnmarshaller();
		return (Patient) unMarshaller.unmarshal(new StringReader(stringWriter.toString()));
	}
	
	public static void main( String[] args ) {
		try {	
			JAXBContext context = JAXBContext.newInstance(Patient.class);
			StringWriter sw = marshallPatient(context);
			System.out.println(sw.toString());
			System.out.println();
			Patient patient = unMarshallPatient(context, sw);
			System.out.println(patient);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
    }
}
