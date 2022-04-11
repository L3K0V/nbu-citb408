package exam1.t3;

import exam1.t1.Patient;
import exam1.t2.Doctor;

import java.math.BigDecimal;
import java.util.*;

public class GeneralPractitioner extends Doctor {

    static BigDecimal PRICE_PER_PATIENT = BigDecimal.valueOf(8.60);

    Set<Patient> patients;
    List<Patient> viewedPatients;

    public GeneralPractitioner(String name, UUID uid) {
        super(name, uid);
        patients = new HashSet<>();
        viewedPatients = new ArrayList<>();
    }

    public void addPatient(Patient p) {
        patients.add(p);
    }

    public void markPatientAsViewer(Patient p) {
        viewedPatients.add(p);
    }

    public BigDecimal taxesFromEnrolledPatients() {

        if (patients.isEmpty()) {
            return BigDecimal.ZERO;
        }

        return PRICE_PER_PATIENT.multiply(BigDecimal.valueOf(patients.size()));
    }

    public BigDecimal taxesFromViewedPatients() {
        return viewedPatients.stream().map(Patient::userTax).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public BigDecimal salary() {
        return taxesFromEnrolledPatients().add(taxesFromViewedPatients());
    }
}
