package Hospital;

import java.util.HashMap;

public class HospitalSystem {
    private int _medicalStaffMemberIdSequence;
    private int _patientIdSequence;

    private HashMap<Integer, MedicalStaffMember> _medicalStaff;
    private HashMap<Integer, Patient> _patients;
    private HashMap<Integer, Integer> _patientIdToDoctorIdMap;

    public HospitalSystem() {
        _medicalStaff = new HashMap<>();
        _patients = new HashMap<>();
        _patientIdToDoctorIdMap = new HashMap<>();
        _medicalStaffMemberIdSequence = 1;
        _patientIdSequence = 1;
    }

    public int createPatient(int doctorId) throws Exception {
        var medicalStaffMember = _medicalStaff.get(doctorId);

        if (!(medicalStaffMember instanceof SeniorMedicalStaffMember doctor)) {
            throw new Exception("Не удалось найти врача");
        }

        var patient = new Patient(_patientIdSequence++);

        _patients.put(patient.Id, patient);
        _patientIdToDoctorIdMap.put(patient.Id, doctor.Id);

        return patient.Id;
    }

    public int createDoctor() {
        var doctor = new SeniorMedicalStaffMember(_medicalStaffMemberIdSequence++);

        _medicalStaff.put(doctor.Id, doctor);

        return doctor.Id;
    }

    public int createNurse() {
        var nurse = new JuniorMedicalStaffMember(_medicalStaffMemberIdSequence++);

        _medicalStaff.put(nurse.Id, nurse);

        return nurse.Id;
    }

    public DoctorInterface createDoctorInterface(int doctorId) throws Exception {
        var staffMember = _medicalStaff.get(doctorId);

        if (!(staffMember instanceof SeniorMedicalStaffMember seniorMedicalStaffMember)) {
            throw new Exception("Не удалось найти врача");
        }

        return new DoctorInterface(seniorMedicalStaffMember, this);
    }

    public NurseInterface createNurseInterface(int nurseId) throws Exception {
        var staffMember = _medicalStaff.get(nurseId);

        if (!(staffMember instanceof JuniorMedicalStaffMember juniorMedicalStaffMember)) {
            throw new Exception("Не удалось найти врача");
        }

        return new NurseInterface(juniorMedicalStaffMember, this);
    }

    Patient getPatient(int patientId) throws Exception {
        if (!_patients.containsKey(patientId)) {
            throw new Exception("Не удалось найти пациента");
        }

        return _patients.get(patientId);
    }

    int getDoctorIdByPatientId(int patientId) {
        return _patientIdToDoctorIdMap.get(patientId);
    }
}
