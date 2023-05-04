package com.system.register.service;

import com.system.register.domain.SalaHospital;
import java.util.List;

/**
 *
 * @author mate
 */
public interface ISalaHospitalService {
    
    public List<SalaHospital> listarSalaHospital();

    public void guardar(SalaHospital salaHospital);

    public void eliminar(SalaHospital salaHospital);

    public SalaHospital encontrarSalaHospital(SalaHospital salaHospital);
    
}
