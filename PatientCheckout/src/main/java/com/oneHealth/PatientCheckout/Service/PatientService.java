package com.oneHealth.PatientCheckout.Service;

import java.util.List;

import com.oneHealth.PatientCheckout.Entity.Patient;

public interface PatientService {
    List<Patient> getAllPatients();
    Patient getPatientById(Integer patientId);
    Patient createPatient(Patient patient);
    Patient updatePatient(Integer patientId, Patient updatedPatient);
    void deletePatient(Integer patientId);
}
