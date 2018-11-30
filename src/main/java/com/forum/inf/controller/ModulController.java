package com.forum.inf.controller;

import com.forum.inf.dao.ModulDao;
import com.forum.inf.dto.Moduldto;
import com.forum.inf.entity.Modul;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    
    private ModelMapper mp = new ModelMapper();
    private Moduldto mdto = new Moduldto();
    
    @RequestMapping(method = RequestMethod.GET)
    public List<Moduldto> getAllModul() {
        List<Moduldto> listModul = new ArrayList<>();
        Modul source = new Modul();
        List<Modul> listModulSource = md.findAll();
        if(md.count() > 0) {
            for(int i = 0;i < md.count();i++) {
                source.setJudul(listModulSource.get(i).getJudul());
                source.setMk(listModulSource.get(i).getMk());
                source.setSize(listModulSource.get(i).getSize());
                source.setTgl(listModulSource.get(i).getTgl());
                source.setUrl(listModulSource.get(i).getUrl());
                mp.map(source, mdto);
                listModul.add(mdto);
            }
        }
        return listModul;
    }
    
}
