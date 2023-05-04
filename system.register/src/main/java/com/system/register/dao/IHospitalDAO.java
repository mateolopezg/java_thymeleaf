package com.system.register.dao;

import com.system.register.domain.Hospital;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author mate
 */
public interface IHospitalDAO extends CrudRepository<Hospital, Long>{
    
}
