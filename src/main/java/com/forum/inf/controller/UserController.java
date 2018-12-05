package com.forum.inf.controller;

import com.forum.inf.dao.UserDao;
import com.forum.inf.dto.Userdto;
import com.forum.inf.entity.User;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.servlet.http.HttpSession;
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
    public List<Userdto> getAllUser(HttpSession session) {
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
        System.out.println("ID USER: "+session.getAttribute("id_user"));
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
    
    @RequestMapping(method = RequestMethod.GET, value = "/user/session")
    public Userdto getUserLogin(HttpSession session) {
        Userdto userdto = new Userdto();
        if(session.getAttribute("id_user") != null) {
            Optional<User> u = ud.findById(session.getAttribute("id_user").toString());
            User user = u.get();
            userdto.setNama(user.getNama());
            userdto.setEmail(user.getEmail());
        }
        return userdto;
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/user/sessionid")
    public Map<String,String> getSessionId(HttpSession session) {
        Map<String,String> mp = new HashMap<String, String>();
        if(session.getAttribute("id_user") != null)
            mp.put("id_session",session.getAttribute("id_user").toString());
        return mp;
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/user/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody @Valid User u) {
        ud.save(u);
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/user/login")
    public Boolean cekLogin(@RequestBody User u, HttpSession session) {
        List<User> user = ud.login(u.getEmail(), u.getPass());
        if(user.size() > 0) {
            session.setAttribute("id_user", user.get(0).getId());
            System.out.println("Id User: "+session.getAttribute("id_user"));
        }
        return user.size() == 1;
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/user/logout")
    public void removeSession(HttpSession session) {
        session.removeAttribute("id_user");
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
