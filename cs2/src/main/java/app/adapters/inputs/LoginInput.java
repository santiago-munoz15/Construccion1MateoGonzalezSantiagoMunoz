package app.adapters.inputs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.adapters.inputs.utils.UserValidator;
import app.adapters.inputs.utils.Utils;
import app.domain.models.User;
import app.domain.services.LoginService;
import app.ports.InputPort;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Component
public class LoginInput implements InputPort {
    @Autowired
    private UserValidator userValidator;
    @Autowired
    private LoginService loginService;
    @Autowired
    private AdminInput adminInput;
    @Autowired
    private SellerInput sellerInput;
    @Autowired
    private VeterinarianInput veterinarianInput;
    
    private final String MENU = "Ingrese la opción:" +
            " \n 1. Iniciar sesión." +
            " \n 2. Salir.";

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
                    this.login();
                    return true;
                case "2":
                    System.out.println("Se ha cerrado la aplicación.");
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
    
    private void login() throws Exception {
        System.out.println("Ingrese el nombre de usuario:");
        String userName = Utils.getReader().nextLine();
        userValidator.userNameValidator(userName);
        
        System.out.println("Ingrese la contraseña:");
        String password = Utils.getReader().nextLine();
        userValidator.passwordValidator(password);
        
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        loginService.login(user);
        
        switch (user.getRole().toLowerCase()) {
            case "admin":
                adminInput.menu();
                break;
            case "seller":
                sellerInput.menu();
                break;
            case "veterinarian":
                veterinarianInput.menu();
                break;
            default:
                throw new Exception("Rol inválido");
        }
    }
}

