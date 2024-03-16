import Hospital.*;

public class Main {
    public static void main(String[] args) throws Exception {
       var hospitalSystem = new HospitalSystem();

       var doctorId = hospitalSystem.createDoctor();
       var nurseId = hospitalSystem.createNurse();

       // Назначение пациенту лечащего врача
       var patientId = hospitalSystem.createPatient(doctorId);

       DoctorInterface doctorInterface = hospitalSystem.createDoctorInterface(doctorId);

       // Выдача пациенту назначений
       var prescriptionId1 = doctorInterface.givePrescription(patientId, Prescription.Type.Procedure);
       var prescriptionId2 = doctorInterface.givePrescription(patientId, Prescription.Type.Surgery);

       NurseInterface nurseInterface = hospitalSystem.createNurseInterface(nurseId);

       // Выполнение выданных назначений
       nurseInterface.performPrescription(patientId, prescriptionId1);
       doctorInterface.performPrescription(patientId, prescriptionId2);

       // Выписка пациента из больницы
       doctorInterface.dischargePatient(patientId, DischargeReason.EndOfTreatment);
    }
}