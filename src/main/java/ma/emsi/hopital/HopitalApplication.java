package ma.emsi.hopital;

import ma.emsi.hopital.entities.Patient;
import ma.emsi.hopital.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class HopitalApplication implements CommandLineRunner {
    @Autowired // pour injecter une dépendance
    private PatientRepository patientRepository;

    public static void main(String[] args) {
        SpringApplication.run(HopitalApplication.class, args);
    }


    @Override
    public void run(String... args) {

        patientRepository.save(new Patient(null, "EL Mahdi", new Date(), false, 55));
        patientRepository.save(new Patient(null, "Youssef", new Date(), false, 10));
        patientRepository.save(new Patient(null, "Ayoub", new Date(), true, 45));


    }
}
