package Hospital;

public class DoctorInterface {
    private final SeniorMedicalStaffMember _staffMember;
    private final HospitalSystem _hospitalSystem;

    DoctorInterface(SeniorMedicalStaffMember staffMember, HospitalSystem hospitalSystem) {
        _staffMember = staffMember;
        _hospitalSystem = hospitalSystem;
    }

    public int givePrescription(int patientId, Prescription.Type prescriptionType) throws Exception {
        var assignedDoctorId = _hospitalSystem.getDoctorIdByPatientId(patientId);

        if (_staffMember.Id != assignedDoctorId) {
            throw new Exception("Пациенту назначен другой врач");
        }

        var patient = _hospitalSystem.getPatient(patientId);

        return _staffMember.givePrescription(patient, prescriptionType);
    }

    public void performPrescription(int patientId, int prescriptionId) throws Exception {
        var patient = _hospitalSystem.getPatient(patientId);

        _staffMember.performPrescription(patient, prescriptionId);
    }

    public void dischargePatient(int patientId, DischargeReason reason) throws Exception {
        var assignedDoctorId = _hospitalSystem.getDoctorIdByPatientId(patientId);

        if (_staffMember.Id != assignedDoctorId) {
            throw new Exception("Пациенту назначен другой врач");
        }

        var patient = _hospitalSystem.getPatient(patientId);

        patient.discharge(reason);
    }
}
