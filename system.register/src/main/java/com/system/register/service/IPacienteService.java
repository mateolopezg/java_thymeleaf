package com.system.register.service;

import com.system.register.domain.Paciente;
import java.util.List;

/**
 *
 * @author mate
 */
public interface IPacienteService {

    public List<Paciente> listarPacientes();

    public void guardar(Paciente paciente);

    public void eliminar(Paciente paciente);

    public Paciente encontrarPaciente(Paciente paciente);

    public Paciente encontrarPacientePorNombre(String nombre);

    public List<Paciente> encontrarPacientePorEnfermedad(String enfermedad);
    
    public List<Paciente> listarPacientesAdultos();

}
