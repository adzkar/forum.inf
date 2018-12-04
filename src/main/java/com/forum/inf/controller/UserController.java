package com.forum.inf.controller;

import com.forum.inf.dao.UserDao;
import com.forum.inf.dto.Userdto;
import com.forum.inf.entity.User;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author tayo
 */
@RestController
@CrossOrigin
@RequestMapping(method = RequestMethod.GET, value = "/api")
public class UserController {
    
    @Autowired
    private UserDao ud;
 
    public UserController() {
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/user")
    public List<Userdto> getAllUser() {
        List<Userdto> listUser = new ArrayList<>();
        List<User> source = ud.findAll();
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
    
    @RequestMapping(method = RequestMethod.GET, value = "/user/{id}")
    public Userdto getUserId(@PathVariable("id") int id) {
        List<Userdto> listUser = new ArrayList<>();
        List<User> source = ud.findAll();
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
    
    @RequestMapping(method = RequestMethod.POST, value = "/user/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody @Valid User u) {
        ud.save(u);
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/user/login")
    public Boolean cekLogin(@RequestBody User u) {
        
    }
    
    @RequestMapping(method = RequestMethod.DELETE, value = "/user/deletebyemail/{email}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@PathVariable("email") String email ) {
        List<User> u = ud.getMemberByEmail(email);
        ud.delete(u.get(0));
    }
    
    @RequestMapping(method = RequestMethod.DELETE, value = "/user/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUserbyId(@PathVariable("id") int id_user) {
//        get data
        List<Userdto> listUser = new ArrayList<>();
        List<User> source = ud.findAll();
        for(int i = 0;i < ud.count();i++) {
            listUser.add(
                    new Userdto(
                            (i+1),
                            source.get(i).getNama(),
                            source.get(i).getEmail()
                        )
                    );
        }
//        delete data
        List<User> u = ud.getMemberByEmail(listUser.get(id_user).getEmail());
        ud.delete(u.get(0));
    }
    
}
