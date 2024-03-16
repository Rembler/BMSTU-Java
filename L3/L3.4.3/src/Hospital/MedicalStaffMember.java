package Hospital;

import java.util.Arrays;

abstract class MedicalStaffMember {
    public final int Id;

    public MedicalStaffMember(int id) {
        Id = id;
    }
}

class JuniorMedicalStaffMember extends MedicalStaffMember {
    public JuniorMedicalStaffMember(int id) {
        super(id);
    }

    public void performPrescription(Patient patient, int prescriptionId) throws Exception {
        var prescription = patient.getPrescription(prescriptionId);

        prescription.markAsDone();
    }
}

class SeniorMedicalStaffMember extends JuniorMedicalStaffMember {
    public SeniorMedicalStaffMember(int id) {
        super(id);
    }

    public int givePrescription(Patient patient, Prescription.Type prescriptionType) throws Exception {
        var patientPrescriptions = patient.getPrescriptions();

        var newPrescriptionId = Arrays.stream(patientPrescriptions)
                .mapToInt(prescription -> prescription.Id)
                .max().orElse(0) + 1;
        var newPrescription = new Prescription(newPrescriptionId, prescriptionType);

        patient.addPrescription(newPrescription);

        return newPrescriptionId;
    }
}
