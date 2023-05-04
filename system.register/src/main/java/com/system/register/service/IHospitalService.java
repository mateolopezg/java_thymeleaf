package com.system.register.service;

import com.system.register.domain.Hospital;
import java.util.List;

/**
 *
 * @author xubuntu
 */
public interface IHospitalService {

    public List<Hospital> listarHospitales();

    public void guardar(Hospital hospital);

    public void eliminar(Hospital hospital);

    public Hospital encontrarHospital(Hospital hospital);
}
