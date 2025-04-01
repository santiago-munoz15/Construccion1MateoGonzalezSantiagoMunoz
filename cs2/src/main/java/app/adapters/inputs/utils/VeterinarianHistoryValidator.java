package app.adapters.inputs.utils;

public class VeterinarianHistoryValidator extends SimpleValidator {
	public String reasonValidator(String value) throws Exception {
        return stringValidator(value, "razón de consulta ");
    }

    public String diagnosisValidator(String value) throws Exception {
        return stringValidator(value, "diagnóstico de consulta ");
    }

    public String medicineValidator(String value) throws Exception {
        return stringValidator(value, "medicina asignada ");
    }

    public String doseValidator(String value) throws Exception {
        return stringValidator(value, "dosis de la medicina ");
    }

    public String procedureNameValidator(String value) throws Exception {
        return stringValidator(value, "nombre del procedimiento ");
    }

    public String procedureDetailValidator(String value) throws Exception {
        return stringValidator(value, "detalle del procedimiento ");
    }

    public String vaccinationValidator(String value) throws Exception {
        return stringValidator(value, "historial de vacunación ");
    }

    public String allergiesValidator(String value) throws Exception {
        return stringValidator(value, "alergias de la mascota ");
    }

}
