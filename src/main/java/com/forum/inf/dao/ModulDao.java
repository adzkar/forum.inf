package com.forum.inf.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.forum.inf.entity.Modul;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author tayo
 */
@Repository
public interface ModulDao extends JpaRepository<Modul, String>{
    
}
