package exam1.t2;

import java.math.BigDecimal;
import java.util.UUID;

public class Doctor {

    public static BigDecimal MIN_SALARY = BigDecimal.ZERO;

    final String name;
    final UUID uid;

    DoctorField doctorField;
    boolean workInHospital;

    public Doctor(String name, UUID uid) {
        this.name = name;
        this.uid = uid;
    }

    public BigDecimal salary() {
        BigDecimal tenPercent = MIN_SALARY.divide(BigDecimal.valueOf(20));
        return workInHospital ? MIN_SALARY.add(tenPercent) : MIN_SALARY;
    }

    public boolean isSurgeon() {
        return doctorField == DoctorField.SURGERY;
    }

    public DoctorField getField() {
        return doctorField;
    }

    public void setField(DoctorField doctorField) {
        this.doctorField = doctorField;
    }

    public boolean isWorkInHospital() {
        return workInHospital;
    }

    public void setWorkInHospital(boolean workInHospital) {
        this.workInHospital = workInHospital;
    }

    static int compareSalary(Doctor first, Doctor second) {
        return first.salary().compareTo(second.salary());
    }
}
