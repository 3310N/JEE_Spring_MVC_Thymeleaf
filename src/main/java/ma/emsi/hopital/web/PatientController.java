package ma.emsi.hopital.web;

import lombok.AllArgsConstructor;
import ma.emsi.hopital.entities.Patient;
import ma.emsi.hopital.repository.PatientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;

import java.util.List;

@Controller // pour dire que c'est un controller
@AllArgsConstructor // pour générer le constructeur avec tous les arguments

public class PatientController {
    private PatientRepository patientRepository;
    @GetMapping("/index") // pour dire que c'est une méthode qui répond à une requête GET
    public String index(Model model, @RequestParam(name = "page" , defaultValue="0") int p , @RequestParam(name="size" , defaultValue = "5") int s,  @RequestParam(name="Keyword" , defaultValue = "")  String kw){
       Page <Patient> pagePatients  = patientRepository.findByNomContains(kw, PageRequest.of(p,s));
        model.addAttribute("ListPatients", pagePatients.getContent());
        model.addAttribute("pages", new int[pagePatients.getTotalPages()]);
        model.addAttribute("currentPage", p);
        model.addAttribute("Keyword", kw);
        return "patients";
    }

    @GetMapping("/delete")
    public String delete(Long id , String Keyword, int page){
        patientRepository.deleteById(id);
        return "redirect:/index?page="+page+"&Keyword="+Keyword;
    }
    @GetMapping("/")
    public String home() {
        return "redirect:/index";
    }
}
