package exam1.t4;

import exam1.t1.Patient;
import exam1.t2.Doctor;
import exam1.t2.DoctorField;
import exam1.t3.GeneralPractitioner;

import javax.print.Doc;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class Solution {
    public static void main(String[] args) {
        Patient.increaseTax(BigDecimal.valueOf(4.80));
        Doctor.MIN_SALARY = BigDecimal.valueOf(1000);

        Patient p1 = new Patient("F", LocalDate.of(1950, 1, 18), true);
        Patient p2 = new Patient("K", LocalDate.of(2006, 12, 12), false);
        Patient p3 = new Patient("D", LocalDate.of(1974, 1, 8), false);


        Doctor d1 = new Doctor("A", UUID.randomUUID());
        d1.setField(DoctorField.INTERNAL_DISEASES);
        d1.setWorkInHospital(true);

        System.out.println(d1.isSurgeon() + " == false");
        System.out.println(d1.salary() + " == 1050");

        GeneralPractitioner gp = new GeneralPractitioner("BA", UUID.randomUUID());
        gp.addPatient(p1);
        gp.addPatient(p2);
        gp.markPatientAsViewer(p3);

        System.out.println(gp.taxesFromEnrolledPatients() + " == 17.5");
        System.out.println(gp.taxesFromViewedPatients() + " == 4.8");
        System.out.println(gp.salary());
    }
}
