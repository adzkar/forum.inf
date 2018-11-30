package com.forum.inf.controller;

import com.forum.inf.dao.UserDao;
import com.forum.inf.dto.Userdto;
import com.forum.inf.entity.User;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author tayo
 */
@RestController
@RequestMapping(method = RequestMethod.GET, value = "/api/user")
public class UserController {
    
    @Autowired
    private UserDao ud;
    
    @RequestMapping(method = RequestMethod.GET)
    public List<Userdto> getAllUser() {
        List<Userdto> listUser = new ArrayList<>();
        List<User> source = ud.getMembers("user");
        for(int i = 0;i < ud.count();i++) {
            listUser.add(
                    new Userdto(
                            (i+1),
                            source.get(i).getNama(),
                            source.get(i).getEmail()
                        )
                    );
        }
        return listUser;
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Userdto getUserId(@PathVariable("id") int id) {
        List<Userdto> listUser = new ArrayList<>();
        List<User> source = ud.getMembers("user");
        for(int i = 0;i < ud.count();i++) {
            listUser.add(
                    new Userdto(
                            (i+1),
                            source.get(i).getNama(),
                            source.get(i).getEmail()
                        )
                    );
        }
        if(id < 1 | id > listUser.size())
            return new Userdto();
        else
            return listUser.get(id-1);
    }
    
}
