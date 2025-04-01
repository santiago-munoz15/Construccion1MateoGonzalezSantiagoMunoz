package app.adapters.inputs.utils;

public class OrderValidator extends SimpleValidator{
	public long idValidator(String value) throws Exception {
        return longValidator(value, "id de la orden ");
    }

    public String medicineValidator(String value) throws Exception {
        return stringValidator(value, "medicamento de la orden ");
    }

    public String doseValidator(String value) throws Exception {
        return stringValidator(value, "dosis de la orden ");
    }

}
