package app.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.models.Invoice;
import app.domain.models.Person;
import app.domain.models.Pet;
import app.domain.models.User;
import app.ports.InvoicePort;
import app.ports.PersonPort;
import app.ports.PetPort;
import app.ports.UserPort;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Service
public class AdminService { 
	@Autowired
    private PersonPort personPort;
    @Autowired
    private UserPort userPort;
    @Autowired	
    private InvoicePort invoicePort;
    @Autowired
    private PetPort petPort;
    public void registerVeterinarian(long document, String name, int age, String userName, String password) {
        // Implementación aquí
    }
    
    // Validar que la operación la haga un administrador
    private void validateAdmin(Person admin) throws Exception {
        admin = personPort.findByDocument(admin.getDocument());
        if (admin == null || !admin.getRole().equals("admin")) {
            throw new Exception("Operación permitida solo para administradores");
        }
    }
   
    public void registerOwner(Person owner) throws Exception {
        if (personPort.existPerson(owner.getDocument())) {
            throw new Exception("Ya existe un dueño con esta cédula");
        }
        owner.setRole("owner");
        personPort.savePerson(owner);
     
    }
    
    
    // Registrar un médico veterinario (solo administrador puede hacerlo)
    public void registerVeterinarian(Person veterinarian, User user, Person admin) throws Exception {
    	validateAdmin(admin);
        if (personPort.existPerson(veterinarian.getDocument())) {
            throw new Exception("Ya existe una persona con esa cédula");
        }
        if (userPort.existsByUserName(user.getUserName())) {
            throw new Exception("Ya existe ese nombre de usuario registrado");
        }
        veterinarian.setRole("veterinarian");
        personPort.savePerson(veterinarian);
        user.setDocument(veterinarian.getDocument());
        user.setRole("veterinarian");
        userPort.saveUser(user);
    }
    
    public List<Invoice> getInvoices(Person person) throws Exception {
        if (person == null) {
            return invoicePort.getAllInvoices();
        }
        person = personPort.findByDocument(person.getDocument());
        if (person == null) {
            throw new Exception("No existe una persona con esa cédula");
        }
        return invoicePort.getInvoicesByPerson(person);
    }
    
 // Cambiar rol de usuario (sólo válido para administradores)
    public void changeUserRole(Person admin, long document, String newRole) throws Exception {
    	validateAdmin(admin);
        Person person = personPort.findByDocument(document);
        if (person == null) {
            throw new Exception("No existe una persona con esa cédula");
        }
        if (!person.getRole().equals("admin")) {
            throw new Exception("Solo los administradores pueden cambiar roles");
        }
        person.setRole(newRole);
        personPort.updatePerson(person);
    }
    
    // Consultar mascotas registradas por un dueño
    public List<Pet> getPetsByOwner(Person owner) throws Exception {
        owner = personPort.findByDocument(owner.getDocument());
        if (owner == null) {
            throw new Exception("No existe una persona con esa cédula");
        }
        return petPort.getPetsByOwner(owner);
    }
    
    // Eliminar un usuario (administrador controla)
    public void deleteUser(Person admin, long document) throws Exception {
    	validateAdmin(admin);
        Person person = personPort.findByDocument(document);
        if (person == null) {
            throw new Exception("No existe una persona con esa cédula");
        }
        if (!person.getRole().equals("owner")) { // Los dueños no tienen usuario
            User user = userPort.findByPersonId(person);
            if (user != null) {
                userPort.deleteUser(user);
            }
        }
        personPort.deletePerson(person);
    }

    
}
