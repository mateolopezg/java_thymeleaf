/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.system.register.dao;

import com.system.register.domain.SalaHospital;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author mate
 */
public interface ISalaHospitalDAO extends CrudRepository<SalaHospital, Long> {
    
}
