package com.forum.inf.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.forum.inf.entity.Modul;

/**
 *
 * @author tayo
 */
@Repository
public interface ModulDao extends PagingAndSortingRepository<Modul, String>{
    
}
