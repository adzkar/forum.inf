package com.forum.inf.dao;

import com.forum.inf.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author tayo
 */
@Repository
public interface UserDao extends PagingAndSortingRepository<User, String>{
    
}
