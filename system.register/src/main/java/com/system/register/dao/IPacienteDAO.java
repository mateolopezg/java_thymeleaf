package com.system.register.dao;

import com.system.register.domain.Paciente;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author mate
 */
public interface IPacienteDAO extends CrudRepository<Paciente, Long> {

    Paciente findByNombrePacienteContainingIgnoreCase(String nombre);

   List<Paciente> findByEnfermedadContainingIgnoreCase(String nombre);

}
