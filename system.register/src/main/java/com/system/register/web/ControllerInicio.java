package com.system.register.web;

import com.system.register.domain.Paciente;
import com.system.register.domain.SalaHospital;
import com.system.register.service.IPacienteService;
import com.system.register.utils.Constants;
import com.system.register.utils.Exceptions.PacienteEdadException;
import com.system.register.utils.Exceptions.PacienteExistenteException;
import jakarta.validation.Valid;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author xubuntu
 */
//@RestController
@Controller
@Slf4j
public class ControllerInicio {

    // @Value("${index.mensaje}")                            // Anotación de Spring. Obtener valor desde properties
    // private String mensajeProperties;
    @Autowired                                               // Inyectar en controlador
    private IPacienteService pacienteService;

    @GetMapping("/")
    public String inicio(Model model, @AuthenticationPrincipal User user) {          // @AutenticationPrincipal User Recuperar usuario que hizo Login
        // import org.springframework.security.core.annotation.AuthenticationPrincipal;
        // import org.springframework.security.core.userdetails.User;
        log.info("--> usuario que hizo login: " + user);
        /*    
        var salaHospital = new SalaHospital();
        salaHospital.setNombre("Sala Hospitalización");

        var paciente = new Paciente();
        paciente.setNombrePaciente("Mateo Lopez");
        paciente.setEdad(32);
        paciente.setEnfermedad("Cancer 1");
        paciente.setSala(salaHospital);
        paciente.setSexo(Constants.HOMBRE);
       
        var paciente2 = new Paciente();
        paciente2.setNombrePaciente("Maryorie Canales");
        paciente2.setEdad(23);
        paciente2.setEnfermedad("Tuberculosis 1");
        paciente2.setSala(salaHospital);
        paciente2.setSexo(Constants.MUJER);

        var paciente3 = new Paciente();
        paciente3.setNombrePaciente("Benito Parmez");
        paciente3.setEdad(45);
        paciente3.setEnfermedad("Cancer 3");
        paciente3.setSala(salaHospital);
        paciente3.setSexo(Constants.HOMBRE);

        var paciente4 = new Paciente();
        paciente4.setNombrePaciente("Benito Parmez");
        paciente4.setEdad(45);
        paciente4.setEnfermedad("Cancer 3");
        paciente4.setSala(salaHospital);
        paciente4.setSexo(Constants.HOMBRE);

        var paciente5 = new Paciente();
        paciente5.setNombrePaciente("Benito Parmez");
        paciente5.setEdad(45);
        paciente5.setEnfermedad("Cancer 3");
        paciente5.setSala(salaHospital);
        paciente5.setSexo(Constants.HOMBRE);
        
        var pacientes = Arrays.asList(paciente, paciente2, paciente3, paciente4, paciente5);
         */
//        
//        model.addAttribute("mensaje", mensaje);                     // Será compartida en la vista
//        model.addAttribute("mensajeProperties", mensajeProperties);
//        model.addAttribute("paciente", paciente);

        var pacientes = pacienteService.listarPacientes();

        model.addAttribute("pacientes", pacientes);
        log.info("---> En info rest");
        return "index";                                    // Se retorna html que esta en Template
    }

    @GetMapping("/agregar")
    public String agregar(Paciente paciente) {
        return "modificar";                                // redirecciona a la pag de modificar
    }

    @PostMapping("/guardar")
    public String guardarPaciente(@Valid Paciente paciente, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "modificar";
        }
        try {
            pacienteService.guardar(paciente);
        } catch (PacienteExistenteException | PacienteEdadException e) {
            result.rejectValue("nombrePaciente", "error.paciente", e.getMessage());
            return "modificar";
        }
        return "redirect:/";
    }

    @GetMapping("/editar/{id}")
    public String editar(Paciente paciente, Model model) {
        paciente = pacienteService.encontrarPaciente(paciente);
        model.addAttribute("paciente", paciente);
        return "modificar";
    }

    @GetMapping("/eliminar")
    public String eliminar(Paciente paciente) {
        pacienteService.eliminar(paciente);
        return "redirect:/";
    }

    @GetMapping("/buscarNombre")
    public String buscarNombre(Model model, Paciente nombrePaciente) {
        var paciente = pacienteService.encontrarPacientePorNombre(nombrePaciente.getNombrePaciente());
        model.addAttribute("pacientes", paciente);
        return "find";
    }

    @GetMapping("/buscarEnfermedad")
    public String buscarEnfermedad(Model model, Paciente enfermedad) {
        var paciente = pacienteService.encontrarPacientePorEnfermedad(enfermedad.getEnfermedad());
        model.addAttribute("pacientes", paciente);
        return "find";
    }

    @GetMapping("/listarAdultos")
    public String listarAdultos(Model model) {
        var pacientes = pacienteService.listarPacientesAdultos();
        model.addAttribute("pacientes", pacientes);
        return "find";
    }
}
