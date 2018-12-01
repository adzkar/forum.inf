package com.forum.inf.controller;

import com.forum.inf.dao.ModulDao;
import com.forum.inf.dao.UserDao;
import com.forum.inf.dto.Moduldto;
import com.forum.inf.entity.Modul;
import com.forum.inf.entity.User;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
@RequestMapping("/api/modul")
public class ModulController {
    
    @Autowired
    private ModulDao md;
    
    @Autowired
    private UserDao ud;
    
//    private ModelMapper mp = new ModelMapper();
    private Moduldto mdto = new Moduldto();
    
    @RequestMapping(method = RequestMethod.GET)
    public List<Moduldto> getAllModul() {
        List<Moduldto> listModul = new ArrayList<>();
        Modul source = new Modul();
        List<Modul> listModulSource = md.findAll();
        if(md.count() > 0) {
            for(int i = 0;i < md.count();i++) {
                listModul.add(
                        new Moduldto(
                                (i+1),
                                listModulSource.get(i).getJudul(),
                                listModulSource.get(i).getMk(),
                                listModulSource.get(i).getSize(),
                                listModulSource.get(i).getTgl(),
                                listModulSource.get(i).getUrl()
                        )
                );
            }
        }
        return listModul;
    }
 
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Moduldto getModulId(@PathVariable("id") int id) {
        List<Moduldto> listModul = new ArrayList<>();
        Modul source = new Modul();
        List<Modul> listModulSource = md.findAll();
        if(md.count() > 0) {
            for(int i = 0;i < md.count();i++) {
                listModul.add(
                        new Moduldto(
                                (i+1),
                                listModulSource.get(i).getJudul(),
                                listModulSource.get(i).getMk(),
                                listModulSource.get(i).getSize(),
                                listModulSource.get(i).getTgl(),
                                listModulSource.get(i).getUrl()
                        )
                );
            }
        }
        if(id < 1 | id > listModul.size())
            return new Moduldto();
        else
            return listModul.get(id-1);
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createModul(@RequestBody Modul m) {
        List<User> u = ud.getMembers("admin");
        m.setUser(u.get(0));
        md.save(m);
    }
}
