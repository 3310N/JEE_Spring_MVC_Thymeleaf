package ma.emsi.hopital.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity // pour dire que c'est une entité

@Data // pour générer les getters et setters
@NoArgsConstructor // pour générer le constructeur sans argument
@AllArgsConstructor // pour générer le constructeur avec tous les arguments
@Builder // pour générer le design pattern builder

public class Patient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private Date dateNaissance;
    private boolean malade;
    private int score;
}
