package app.adapters.inputs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.adapters.inputs.utils.PetValidator;
import app.adapters.inputs.utils.Utils;
import app.adapters.inputs.utils.VeterinarianHistoryValidator;
import app.domain.models.VeterinarianHistory;
import app.domain.services.VeterinarianService;
import app.ports.InputPort;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Component
public class VeterinarianInput implements InputPort {
    @Autowired
    private PetValidator petValidator;
    
    @Autowired
    private VeterinarianHistoryValidator veterinarianHistoryValidator;
    
    @Autowired
    private VeterinarianService veterinarianService;
    
    private final String MENU = "Ingrese la opción:" +
            "\n 1. Crear mascota." +
            "\n 2. Crear dueño de mascota." +
            "\n 3. Realizar consulta." +
            "\n 4. Anular orden." +
            "\n 5. Cerrar sesión.";

    public void menu() {
        boolean session = true;
        while (session) {
            session = options();
        }
    }

    private boolean options() {
        try {
            System.out.println(MENU);
            String option = Utils.getReader().nextLine();
            switch (option) {
                case "1":
                    this.createPet();
                    return true;
                case "2":
                    this.createOwner();
                    return true;
                case "3":
                    this.clinicalConsultation();
                    return true;
                case "4":
                    this.cancelOrder();
                    return true;
                case "5":
                    System.out.println("Se ha cerrado sesión.");
                    return false;
                default:
                    System.out.println("Opción no válida.");
                    return true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return true;
        }
    }

    private void createPet() throws Exception {
        // Implementación para crear una mascota
    }

    private void createOwner() throws Exception {
        // Implementación para crear un dueño de mascota
    }

    private void cancelOrder() throws Exception {
        // Implementación para anular una orden
    }

    private void clinicalConsultation() throws Exception {
        System.out.println("Ingrese el ID de la mascota:");
        long id = petValidator.idValidator(Utils.getReader().nextLine());
        
        System.out.println("Ingrese el motivo de consulta:");
        String reason = Utils.getReader().nextLine();
        veterinarianHistoryValidator.reasonValidator(reason);

        System.out.println("Ingrese el diagnóstico:");
        String diagnosis = Utils.getReader().nextLine();
        veterinarianHistoryValidator.diagnosisValidator(diagnosis);

        System.out.println("Ingrese la medicina asignada:");
        String medicine = Utils.getReader().nextLine();
        veterinarianHistoryValidator.medicineValidator(medicine);

        System.out.println("Ingrese la dosis del medicamento:");
        String dose = Utils.getReader().nextLine();
        veterinarianHistoryValidator.doseValidator(dose);

        System.out.println("Ingrese el nombre del procedimiento:");
        String procedureName = Utils.getReader().nextLine();
        veterinarianHistoryValidator.procedureNameValidator(procedureName);

        System.out.println("Ingrese el detalle del procedimiento:");
        String procedureDetail = Utils.getReader().nextLine();
        veterinarianHistoryValidator.procedureDetailValidator(procedureDetail);

        System.out.println("Ingrese el historial de vacunación:");
        String vaccination = Utils.getReader().nextLine();
        veterinarianHistoryValidator.vaccinationValidator(vaccination);

        System.out.println("Ingrese las alergias de la mascota:");
        String allergies = Utils.getReader().nextLine();
        veterinarianHistoryValidator.allergiesValidator(allergies);

        VeterinarianHistory VeterinarianHistory = new VeterinarianHistory();
        VeterinarianHistory.setDate(System.currentTimeMillis());
        VeterinarianHistory.setAlergies(allergies);
        VeterinarianHistory.setDiagnosis(diagnosis);
        VeterinarianHistory.setDose(dose);
        VeterinarianHistory.setMedicine(medicine);
        VeterinarianHistory.setProcedureDetail(procedureDetail);
        VeterinarianHistory.setProcedureName(procedureName);
        VeterinarianHistory.setReason(reason);
        VeterinarianHistory.setStatus("active");
        VeterinarianHistory.setVaccination(vaccination);
        
        veterinarianService.saveClinicalHistory(id, VeterinarianHistory);
        
        System.out.println("Se ha creado la historia clínica.");
    }
}