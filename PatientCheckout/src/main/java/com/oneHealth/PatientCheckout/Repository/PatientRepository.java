package com.oneHealth.PatientCheckout.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oneHealth.PatientCheckout.Entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
    // Add custom query methods if needed
}

