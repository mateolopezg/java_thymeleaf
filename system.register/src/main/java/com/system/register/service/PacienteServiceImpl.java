package com.system.register.service;

import com.system.register.dao.IPacienteDAO;
import com.system.register.domain.Paciente;
import com.system.register.utils.Exceptions.PacienteEdadException;
import com.system.register.utils.Exceptions.PacienteExistenteException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author mate
 */
@Service                                                                     // necesario para que reconozca para inyectar a controlador
public class PacienteServiceImpl implements IPacienteService {

    @Autowired
    private IPacienteDAO pacientedao;

    @Override
    @Transactional(readOnly = true)
    public List<Paciente> listarPacientes() {
        return (List<Paciente>) pacientedao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Paciente paciente) {
        Paciente pacienteExistente = encontrarPacientePorNombre(paciente.getNombrePaciente());
        if (pacienteExistente != null && !pacienteExistente.getId().equals(paciente.getId())) {
            throw new PacienteExistenteException("El nombre del paciente ya existe en la base de datos.");
        }
        if (paciente.getEdad() < 0 || paciente.getEdad() > 100) {
            throw new PacienteEdadException("La edad del paciente debe estar entre 0 y 100 años.");
        }
        pacientedao.save(paciente);
    }

    @Override
    public void eliminar(Paciente paciente) {
        pacientedao.delete(paciente);
    }

    @Override
    @Transactional(readOnly = true)
    public Paciente encontrarPaciente(Paciente paciente) {
        return pacientedao.findById(paciente.getId()).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Paciente encontrarPacientePorNombre(String nombre) {
        if (nombre != null) {
            return pacientedao.findByNombrePacienteContainingIgnoreCase(nombre);
        }
        return null;
    }

    @Override
    public List<Paciente> encontrarPacientePorEnfermedad(String enfermedad) {
        if (enfermedad != null) {
            return pacientedao.findByEnfermedadContainingIgnoreCase(enfermedad);
        }
        return null;
    }

    @Override
    public List<Paciente> listarPacientesAdultos() {
        List<Paciente> adultos = new ArrayList<>(); // inicializamos la lista

        var pacientes = pacientedao.findAll();

        for (Paciente paciente : pacientes) {
            if (paciente.getEdad() > 17 && paciente.getEdad() < 66) {
                adultos.add(paciente);
            }
        }
        return adultos;
    }

}
