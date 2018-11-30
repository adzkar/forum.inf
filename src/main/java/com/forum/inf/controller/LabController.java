package com.forum.inf.controller;

import com.forum.inf.dao.LabDao;
import com.forum.inf.dto.Labdto;
import com.forum.inf.entity.Lab;
import com.forum.inf.entity.Tag;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author tayo
 */
@RestController
@RequestMapping("/api/lab")
public class LabController {
    
    @Autowired
    private LabDao ld;
    
    private ModelMapper mp = new ModelMapper();
    private Labdto ldto = new Labdto();

    @RequestMapping(method = RequestMethod.GET)
    public List<Labdto> getAllLab() {
        List<Labdto> listLab = new ArrayList<>();
        Lab source = new Lab();
        List<Lab> listLabSource = ld.findAll();
        if(ld.count() > 0) {
            for(int i = 0;i < ld.count();i++) {
                source.setNama(listLabSource.get(i).getNama());
                source.setKategori(listLabSource.get(i).getKategori());
                source.setDosen(listLabSource.get(i).getDosen());
                source.setDeskripsi(listLabSource.get(i).getDeskripsi());
                mp.map(source, ldto);
                listLab.add(ldto);
            }
        }
        return listLab;
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Labdto getLabId(@PathVariable("id") int id) {
        List<Labdto> listLab = new ArrayList<>();
        Lab source = new Lab();
        List<Lab> listLabSource = ld.findAll();
        if(ld.count() > 0) {
            for(int i = 0;i < ld.count();i++) {
                source.setNama(listLabSource.get(i).getNama());
                source.setKategori(listLabSource.get(i).getKategori());
                source.setDosen(listLabSource.get(i).getDosen());
                source.setDeskripsi(listLabSource.get(i).getDeskripsi());
                mp.map(source, ldto);
                listLab.add(ldto);
            }
        }
        if(id < 1 | id > listLab.size())
            return new Labdto();
        else
            return listLab.get(id-1);
    }
    
}
