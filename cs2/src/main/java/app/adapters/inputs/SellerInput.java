package app.adapters.inputs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.adapters.inputs.utils.InvoiceValidator;
import app.adapters.inputs.utils.OrderValidator;
import app.adapters.inputs.utils.PersonValidator;
import app.adapters.inputs.utils.PetValidator;
import app.adapters.inputs.utils.Utils;
import app.domain.services.SellerService;
import app.ports.InputPort;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Component
public class SellerInput implements InputPort {
    @Autowired
    private PersonValidator personValidator;
    @Autowired
    private PetValidator petValidator;
    @Autowired
    private OrderValidator orderValidator;
    @Autowired
    private InvoiceValidator invoiceValidator;
    @Autowired
    private SellerService sellerService;
    
    private final String MENU = "Ingrese la opción:" +
            " \n 1. Crear Factura." +
            " \n 2. Cerrar sesión.";

    public void menu() {
        boolean sesion = true;
        while (sesion) {
            sesion = options();
        }
    }
    
    private boolean options() {
        try {
            System.out.println(MENU);
            String option = Utils.getReader().nextLine();
            switch (option) {
                case "1":
                    this.createInvoice();
                    return true;
                case "2":
                    System.out.println("Se ha cerrado sesión");
                    return false;
                default:
                    System.out.println("Opción no válida");
                    return true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return true;
        }
    }

    private void createInvoice() throws Exception {
        System.out.println("Ingrese la cédula del dueño de la mascota:");
        long document = personValidator.documentValidator(Utils.getReader().nextLine());
        System.out.println("Ingrese el ID de la mascota:");
        long petId = petValidator.idValidator(Utils.getReader().nextLine());
        System.out.println("Ingrese el ID de la orden:");
        long orderId = orderValidator.idValidator(Utils.getReader().nextLine());
        System.out.println("Ingrese el monto de la factura:");
        double amount = invoiceValidator.amountValidator(Utils.getReader().nextLine());
        System.out.println("Ingrese los items de la factura:");
        String items = invoiceValidator.itemsValidator(Utils.getReader().nextLine());
        
        
        sellerService.createInvoice(document, petId, orderId, amount, items);
    }
}

