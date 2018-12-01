package com.forum.inf.controller;

import com.forum.inf.dao.ArtikelDao;
import com.forum.inf.dto.Artikeldto;
import com.forum.inf.entity.Artikel;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author tayo
 */
@RestController
@RequestMapping("/api/artikel")
public class ArtikelController {
    
    @Autowired
    private ArtikelDao ad;
    
    private Artikeldto adto = new Artikeldto();
 
    @RequestMapping(method = RequestMethod.GET)
    public List<Artikeldto> getAllArtikel() {
        List<Artikeldto> listArtikel = new ArrayList<>();
        List<Artikel> sources = ad.findAll();
        if(ad.count() > 0) {
            for(int i = 0;i < ad.count();i++) {
                listArtikel.add(new Artikeldto(
                                    (i+1),
                                    sources.get(i).getJudul(),
                                    sources.get(i).getIsi(),
                                    sources.get(i).getUpload(),
                                    sources.get(i).getView(),
                                    sources.get(i).getImage()
                                )
                            );
            }
        }
        return listArtikel;
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Artikeldto getArtikelId(@PathVariable("id") int id) {
        List<Artikeldto> listArtikel = new ArrayList<>();
        List<Artikel> sources = ad.findAll();
        if(ad.count() > 0) {
            for(int i = 0;i < ad.count();i++) {
                listArtikel.add(new Artikeldto(
                                    (i+1),
                                    sources.get(i).getJudul(),
                                    sources.get(i).getIsi(),
                                    sources.get(i).getUpload(),
                                    sources.get(i).getView(),
                                    sources.get(i).getImage()
                                )
                            );
            }
        }
        if(id < 1 | id > listArtikel.size())
            return new Artikeldto();
        else
            return listArtikel.get(id-1);
    }
    
}
