package ma.emsi.hopital.repository;

import ma.emsi.hopital.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PatientRepository  extends JpaRepository<Patient, Long> {

    Page<Patient> findByNomContains(String Keyword, Pageable pageable);
    @Query("select p from Patient p where p.nom like :x")
    Page<Patient> chercher(String x, Pageable pageable);
}
