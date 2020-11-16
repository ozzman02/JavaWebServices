package com.clinicals.api.endpoints;

import com.clinicals.api.dto.ClinicalDataRequest;
import com.clinicals.api.model.ClinicalData;
import com.clinicals.api.model.Patient;
import com.clinicals.api.repository.ClinicalDataRepository;
import com.clinicals.api.repository.PatientRepository;
import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Consumes("application/json")
@Produces("application/json")
@Path("/api")
@CrossOriginResourceSharing(allowAllOrigins = true)
public class ClinicalDataService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private ClinicalDataRepository clinicalDataRepository;

    @POST
    @Path("/clinicals")
    public ClinicalData saveClinicalData(ClinicalDataRequest request) {
        final Patient patient = patientRepository.findById(request.getPatientId()).get();
        ClinicalData clinicalData = new ClinicalData();
        clinicalData.setPatient(patient);
        clinicalData.setComponentName(request.getComponentName());
        clinicalData.setComponentValue(request.getComponentValue());
        return clinicalDataRepository.save(clinicalData);
    }
}
