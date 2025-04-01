package app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import app.adapters.inputs.AdminInput;

@SpringBootApplication

public class VeterinarianApplication implements CommandLineRunner {

    @Autowired
    private AdminInput adminInput;

    @Override
    public void run(String... args) throws Exception {
        // Ejecuta el método menu() después de que la aplicación arranque
        adminInput.menu();
    }

    public static void main(String[] args) {
        SpringApplication.run(VeterinarianApplication.class, args);
    }
}