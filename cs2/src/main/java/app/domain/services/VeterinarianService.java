package app.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.models.Order;
import app.domain.models.Person;
import app.domain.models.Pet;
import app.domain.models.User;
import app.domain.models.VeterinarianHistory;
import app.ports.OrderPort;
import app.ports.PersonPort;
import app.ports.PetPort;
import app.ports.UserPort;
import app.ports.VeterinarianHistoryPort;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Service
public class VeterinarianService {
	@Autowired
    private PersonPort personPort;
    @Autowired
    private UserPort userPort;
    @Autowired
    private PetPort petPort;
    @Autowired
    private OrderPort orderPort;
    @Autowired
    private VeterinarianHistoryPort veterinarianHistoryPort; 
    public void saveClinicalHistory(long id, VeterinarianHistory history) {
        // Implementación aquí
    }
    
 // Validar que la operación la haga un veterinario
    private void validateVeterinarian(Person veterinarian) throws Exception {
        veterinarian = personPort.findByDocument(veterinarian.getDocument());
        if (veterinarian == null || !veterinarian.getRole().equals("veterinarian")) {
            throw new Exception("Operación permitida solo para veterinarios");
        }
    }
    
    // Registrar un vendedor (solo administrador puede hacerlo)
    public void registerSeller(Person seller, User user, Person veterinarian) throws Exception {
    	validateVeterinarian(veterinarian);
        if (personPort.existPerson(seller.getDocument())) {
            throw new Exception("Ya existe un vendedor con esta cédula");
        }
        if (userPort.existsByUserName(user.getUserName())) {
            throw new Exception("Ya existe ese nombre de usuario registrado");
        }
        seller.setRole("seller");
        personPort.savePerson(seller);
        user.setDocument(seller.getDocument()); // Relacionamos por la cédula
        user.setRole("seller");
        userPort.saveUser(user);
    }

 // Registrar historia clínica de una mascota
    public void registerVeterinaryHistory(Person veterinarian, long petId, VeterinarianHistory history) throws Exception {
        validateVeterinarian(veterinarian);
        Pet pet = petPort.findById(petId);
        if (pet == null) {
            throw new Exception("No existe una mascota con ese ID");
        }
        veterinarianHistoryPort.saveHistory(pet, history);
    }
    
 // Consultar historia clínica de una mascota
    public List<VeterinarianHistory> getVeterinaryHistory(Person veterinarian, long petId) throws Exception {
        validateVeterinarian(veterinarian);
        Pet pet = petPort.findById(petId);
        if (pet == null) {
            throw new Exception("No existe una mascota con ese ID");
        }
        return veterinarianHistoryPort.getHistoryByPet(pet);
    }
    
    // Crear una orden médica
    public void createOrder(Person veterinarian, Order order) throws Exception {
        validateVeterinarian(veterinarian);
        Pet pet = petPort.findById(order.getPetId());
        if (pet == null) {
            throw new Exception("No existe una mascota con ese ID");
        }
        orderPort.saveOrder(order);
    }
    
 // Anular una orden médica
    public void annulOrder(Person veterinarian, long orderId) throws Exception {
        validateVeterinarian(veterinarian);
        Order order = orderPort.findById(orderId);
        if (order == null) {
            throw new Exception("No existe una orden con ese ID");
        }
        order.setStatus("anulada");
        orderPort.updateOrder(order);
        veterinarianHistoryPort.addOrderAnnulmentRecord(order);
    }
    
    // Consultar órdenes médicas (para veterinario)
    public List<Order> getOrders(Person veterinarian) throws Exception {
        validateVeterinarian(veterinarian);
        return orderPort.getAllOrders();
    }


}
