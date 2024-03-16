package Hospital;

public class NurseInterface {
    private final JuniorMedicalStaffMember _staffMember;
    private final HospitalSystem _hospitalSystem;

    NurseInterface(JuniorMedicalStaffMember staffMember, HospitalSystem hospitalSystem) {
        _staffMember = staffMember;
        _hospitalSystem = hospitalSystem;
    }

    public void performPrescription(int patientId, int prescriptionId) throws Exception {
        var patient = _hospitalSystem.getPatient(patientId);

        _staffMember.performPrescription(patient, prescriptionId);
    }
}
