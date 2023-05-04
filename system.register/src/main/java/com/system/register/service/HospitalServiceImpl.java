package com.system.register.service;

import com.system.register.dao.IHospitalDAO;
import com.system.register.domain.Hospital;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author xubuntu
 */
public class HospitalServiceImpl implements IHospitalService {

    @Autowired
    private IHospitalDAO hospitaldao;

    @Override
    public List<Hospital> listarHospitales() {
        return (List<Hospital>) hospitaldao.findAll();
    }

    @Override
    public void guardar(Hospital hospital) {
        hospitaldao.save(hospital);
    }

    @Override
    public void eliminar(Hospital hospital) {
        hospitaldao.delete(hospital);
    }

    @Override
    public Hospital encontrarHospital(Hospital hospital) {
        return hospitaldao.findById(hospital.getId()).orElse(null);
    }
}
