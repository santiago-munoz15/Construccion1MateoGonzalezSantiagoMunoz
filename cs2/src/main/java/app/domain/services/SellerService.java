package app.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.models.Invoice;
import app.domain.models.Order;
import app.domain.models.Person;
import app.domain.models.Pet;
import app.ports.InvoicePort;
import app.ports.OrderPort;
import app.ports.PersonPort;
import app.ports.PetPort;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Service
public class SellerService {
	@Autowired
    private PersonPort personPort;
    @Autowired
    private OrderPort orderPort;
    @Autowired
    private InvoicePort invoicePort;
    @Autowired
    private PetPort petPort;
    
 // Validar que la operación la haga un vendedor
    private void validateSeller(Person seller) throws Exception {
        seller = personPort.findByDocument(seller.getDocument());
        if (seller == null || !seller.getRole().equals("seller")) {
            throw new Exception("Operación permitida solo para vendedores");
        }
    }
    
    // Consultar órdenes médicas (para vendedor)
    public List<Order> getOrders(Person seller) throws Exception {
        validateSeller(seller);
        return orderPort.getAllOrders();
    }
    
 // Registrar factura por venta de medicamento (requiere orden médica)
    public void registerInvoiceWithOrder(Person seller, Invoice invoice) throws Exception {
        validateSeller(seller);
        Order order = orderPort.findById(invoice.getOrderId().getId());
        if (order == null) {
            throw new Exception("No existe una orden con ese ID para la venta de medicamento");
        }
        Pet pet = petPort.findById(invoice.getPetId());
        if (pet == null) {
            throw new Exception("No existe una mascota con ese ID");
        }
        invoicePort.saveInvoice(invoice);
    }
    
 // Registrar factura por venta de otro producto (sin necesidad de orden)
    public void registerInvoiceWithoutOrder(Person seller, Invoice invoice) throws Exception {
        validateSeller(seller);
        Pet pet = petPort.findById(invoice.getPetId());
        if (pet == null) {
            throw new Exception("No existe una mascota con ese ID");
        }
        invoicePort.saveInvoice(invoice);
    }

	public void createInvoice(long document, long petId, long orderId, double amount, String items) {
		// TODO Auto-generated method stub
		
	}

}
