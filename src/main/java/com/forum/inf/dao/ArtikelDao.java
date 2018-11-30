package com.forum.inf.dao;

import com.forum.inf.entity.Artikel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author tayo
 */
@Repository
public interface ArtikelDao extends JpaRepository<Artikel, String>{
    
}
