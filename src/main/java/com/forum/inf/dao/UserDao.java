package com.forum.inf.dao;

import com.forum.inf.entity.User;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author tayo
 */
@Repository
public interface UserDao extends JpaRepository<User, String>{
    
    @Query(
           "select x from User x where x.status = (:status)" 
    )
    public List<User> getMembers(@Param("status") String status);

    public List<User> getMemberByEmail(String email);
    
    @Query(
            "select x from User x where x.email = :email and x.pass = :pass"
    )
    public List<User> login(
            @Param("email") String email,
            @Param("pass") String pass
    );
}
