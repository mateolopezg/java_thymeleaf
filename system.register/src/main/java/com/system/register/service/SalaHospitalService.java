package com.system.register.service;

import com.system.register.dao.ISalaHospitalDAO;
import com.system.register.domain.SalaHospital;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author xubuntu
 */
public class SalaHospitalService implements ISalaHospitalService {

    @Autowired
    private ISalaHospitalDAO salahospitaldao;
    
    @Override
    public List<SalaHospital> listarSalaHospital() {
        return (List<SalaHospital>) salahospitaldao.findAll();

    }

    @Override
    public void guardar(SalaHospital salaHospital) {
        salahospitaldao.save(salaHospital);

    }

    @Override
    public void eliminar(SalaHospital salaHospital) {
        salahospitaldao.delete(salaHospital);

    }

    @Override
    public SalaHospital encontrarSalaHospital(SalaHospital salaHospital) {
        return salahospitaldao.findById(salaHospital.getId()).orElse(null);
    }

}
