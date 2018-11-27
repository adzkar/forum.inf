package com.forum.inf.dao;


import com.forum.inf.entity.Lab;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author tayo
 */
@Repository
public interface LabDao extends PagingAndSortingRepository<Lab, String>{
    
}
