package com.forum.inf.dao;

import com.forum.inf.entity.Tag;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author tayo
 */
@Repository
public interface TagDao extends PagingAndSortingRepository<Tag, String>{
    
}
