package app.ports;

import java.util.List;

import app.domain.models.Invoice;
import app.domain.models.Person;

public interface InvoicePort {
	public void saveInvoice(Invoice invoice) throws Exception;
	List<Invoice> getAllInvoices();
	List<Invoice> getInvoicesByPerson(Person person);

}
