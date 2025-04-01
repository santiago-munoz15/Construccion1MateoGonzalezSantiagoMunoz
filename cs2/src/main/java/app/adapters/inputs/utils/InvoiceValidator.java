package app.adapters.inputs.utils;

public class InvoiceValidator extends SimpleValidator {
	 public String itemsValidator(String value) throws Exception {
	        return stringValidator(value, "items de la factura ");
	    }

	    public double amountValidator(String value) throws Exception {
	        return doubleValidator(value, "monto de la factura ");
	    }

}
