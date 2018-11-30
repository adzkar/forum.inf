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
    
    private Labdto ldto = new Labdto();

    @RequestMapping(method = RequestMethod.GET)
    public List<Labdto> getAllLab() {
        List<Labdto> listLab = new ArrayList<>();
        List<Lab> listLabSource = ld.findAll();
        if(ld.count() > 0) {
            for(int i = 0;i < ld.count();i++) {
                listLab.add(new Labdto(
                                        (i+1), 
                                        listLabSource.get(i).getNama(), 
                                        listLabSource.get(i).getKategori(), 
                                        listLabSource.get(i).getDosen(), 
                                        listLabSource.get(i).getDeskripsi()
                                    )
                            );
            }
        }
        return listLab;
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Labdto getLabId(@PathVariable("id") int id) {
        List<Labdto> listLab = new ArrayList<>();
        List<Lab> listLabSource = ld.findAll();
        if(ld.count() > 0) {
            for(int i = 0;i < ld.count();i++) {
                listLab.add(new Labdto(
                                        (i+1), 
                                        listLabSource.get(i).getNama(), 
                                        listLabSource.get(i).getKategori(), 
                                        listLabSource.get(i).getDosen(), 
                                        listLabSource.get(i).getDeskripsi()
                                    )
                            );
            }
        }
        if(id < 1 | id > listLab.size())
            return new Labdto();
        else
            return listLab.get(id-1);
    }
    
}
