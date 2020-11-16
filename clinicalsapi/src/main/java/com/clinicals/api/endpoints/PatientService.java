package com.clinicals.api.endpoints;


import com.clinicals.api.model.ClinicalData;
import com.clinicals.api.model.Patient;
import com.clinicals.api.repository.PatientRepository;
import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.List;

@Consumes("application/json")
@Produces("application/json")
@Path("/api")
@CrossOriginResourceSharing(allowAllOrigins = true)
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @POST
    @Path("/patients")
    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @GET
    @Path("/patients/{id}")
    public Patient getPatient(@PathParam("id") int id) {
        return patientRepository.findById(id).get();
    }

    @GET
    @Path("/patients")
    public List<Patient> getPatients() {
        return patientRepository.findAll();
    }

    @GET
    @Path("/patients/analyze/{id}")
    public Patient analyze(@PathParam("id") int id) {
        Patient patient = patientRepository.findById(id).get();
        List<ClinicalData> clinicalDataList = new ArrayList<>(patient.getClinicalData());
        for (ClinicalData clinicalData : clinicalDataList) {
            if (clinicalData.getComponentName().equals("hw")) {
                String[] heightAndWeight = clinicalData.getComponentValue().split("/");
                String height = heightAndWeight[0];
                String weight = heightAndWeight[1];
                float heightInMeters = Float.parseFloat(height) * 0.4536F;
                Float bmi = Float.parseFloat(weight) / (heightInMeters * heightInMeters);
                ClinicalData bmiData = new ClinicalData();
                bmiData.setComponentName("bmi");
                bmiData.setComponentValue(bmi.toString());
                patient.getClinicalData().add(bmiData);
            }
        }
        return patient;
    }
}
