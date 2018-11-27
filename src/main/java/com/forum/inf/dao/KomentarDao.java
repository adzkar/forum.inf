package com.forum.inf.dao;

import com.forum.inf.entity.Komentar;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author tayo
 */
@Repository
public interface KomentarDao extends PagingAndSortingRepository<Komentar, String>{
    
}
