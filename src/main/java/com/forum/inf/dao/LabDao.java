package com.forum.inf.dao;


import com.forum.inf.entity.Lab;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author tayo
 */
@Repository
public interface LabDao extends JpaRepository<Lab, String>{
    
}
