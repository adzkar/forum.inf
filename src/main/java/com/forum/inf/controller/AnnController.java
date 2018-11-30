package com.forum.inf.controller;

import com.forum.inf.dao.AnnouncementDao;
import com.forum.inf.entity.Announcement;
import com.forum.inf.dto.Anndto;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
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
@RequestMapping("/api/ann")
public class AnnController {
    
    @Autowired
    private AnnouncementDao ad;
    
    private Anndto ldto = new Anndto();
    
    @RequestMapping(method = RequestMethod.GET)
    public List<Anndto> getAllAnn() {
        List<Anndto> listAnn = new ArrayList<>();
        List<Announcement> listLabSource = ad.findAll();
        if(ad.count() > 0) {
            for(int i = 0;i < ad.count();i++) {
                listAnn.add(
                        new Anndto(
                                (i+1),
                                listLabSource.get(i).getJudul(),
                                listLabSource.get(i).getIsi(),
                                listLabSource.get(i).getTgl()
                            )
                        );
            }
        }
        return listAnn;
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Anndto getAnnId(@PathVariable("id") int id) {
        List<Anndto> listAnn = new ArrayList<>();
        List<Announcement> listLabSource = ad.findAll();
        if(ad.count() > 0) {
            for(int i = 0;i < ad.count();i++) {
                listAnn.add(
                        new Anndto(
                                (i+1),
                                listLabSource.get(i).getJudul(),
                                listLabSource.get(i).getIsi(),
                                listLabSource.get(i).getTgl()
                            )
                        );
            }
        }
        if(id < 1 | id > listAnn.size())
            return new Anndto();
        else
            return listAnn.get(id-1);
    }
    
}
