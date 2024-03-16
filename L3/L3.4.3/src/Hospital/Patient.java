package Hospital;

import java.util.HashMap;

class Patient {
    private final HashMap<Integer, Prescription> _prescriptions;
    private boolean _discharged;
    private DischargeReason _dischargeReason;

    public final int Id;

    public Patient(int id) {
        Id = id;
        _prescriptions = new HashMap<>();
        _discharged = false;
        _dischargeReason = null;
    }

    public boolean isDischarged() {
        return _discharged;
    }

    public DischargeReason getDischargeReason() throws Exception {
        if (!_discharged) {
            throw new Exception("Пациент не был выписан");
        }

        return _dischargeReason;
    }

    public void discharge(DischargeReason reason) {
        _discharged = true;
        _dischargeReason = reason;
    }

    public Prescription[] getPrescriptions() {
        return _prescriptions.values().toArray(Prescription[]::new);
    }

    public Prescription getPrescription(int prescriptionId) throws Exception {
        if (!_prescriptions.containsKey(prescriptionId)) {
            throw new Exception("У пациента нет такого назначения");
        }

        return _prescriptions.get(prescriptionId);
    }

    public void addPrescription(Prescription prescription) throws Exception {
        if (_discharged) {
            throw new Exception("Пациент был выписан");
        }

        _prescriptions.put(prescription.Id, prescription);
    }
}
