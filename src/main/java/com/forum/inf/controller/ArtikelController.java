package com.forum.inf.controller;

import com.forum.inf.dao.ArtikelDao;
import com.forum.inf.dao.KomentarDao;
import com.forum.inf.dao.UserDao;
import com.forum.inf.dto.Artikeldto;
import com.forum.inf.dto.Komentardto;
import com.forum.inf.entity.Artikel;
import com.forum.inf.entity.Komentar;
import com.forum.inf.entity.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author tayo
 */
@RestController
@CrossOrigin
@RequestMapping("/api/artikel")
public class ArtikelController {
    
    @Autowired
    private ArtikelDao ad;
    
    @Autowired
    private UserDao ud;
    
    @Autowired
    private KomentarDao kd;
    
    private Artikeldto adto = new Artikeldto();
 
    @RequestMapping(method = RequestMethod.GET)
    public List<Artikeldto> getAllArtikel() {
        List<Artikeldto> listArtikel = new ArrayList<>();
        List<Artikel> sources = ad.findAll();
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
            List<Komentardto> daftarKomentardto = new ArrayList<>();
            List<Komentar> komentarSource = ad.getArtikelByJudul(sources.get(i).getJudul()).get(i).getDaftar_komentar();
            int banyakKomentar = ad.getArtikelByJudul(sources.get(i).getJudul()).get(i).getDaftar_komentar().size();
            System.out.println("Banyak Komentar: "+banyakKomentar);
            for(int j = 0;j < banyakKomentar;j++) {
                daftarKomentardto.add(new Komentardto(
                                            komentarSource.get(j).getJudul(),
                                            komentarSource.get(j).getIsi()
                                        )
                                );
            }
            listArtikel.get(i).setDaftarKomentar(daftarKomentardto);
        }
        return listArtikel;
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Artikeldto getArtikelId(@PathVariable("id") int id) {
        List<Artikeldto> listArtikel = new ArrayList<>();
        List<Artikel> sources = ad.findAll();
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
            List<Komentardto> daftarKomentardto = new ArrayList<>();
            List<Komentar> komentarSource = ad.getArtikelByJudul(sources.get(i).getJudul()).get(i).getDaftar_komentar();
            int banyakKomentar = ad.getArtikelByJudul(sources.get(i).getJudul()).get(i).getDaftar_komentar().size();
            System.out.println("Banyak Komentar: "+banyakKomentar);
            for(int j = 0;j < banyakKomentar;j++) {
                daftarKomentardto.add(new Komentardto(
                                            komentarSource.get(j).getJudul(),
                                            komentarSource.get(j).getIsi()
                                        )
                                );
            }
            listArtikel.get(i).setDaftarKomentar(daftarKomentardto);
        }
        if(id < 1 | id > listArtikel.size())
            return new Artikeldto();
        else
            return listArtikel.get(id-1);
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createArtikel(@RequestBody @Valid Artikel artikel, HttpSession session) {
        Optional<User> userOptional = ud.findById(session.getAttribute("id_user").toString());
        User user = userOptional.get();
        
        artikel.setUser(user);
        
        ad.save(artikel);
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/{id}/komentar/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void insertKomentar(@PathVariable("id") int id,@RequestBody @Valid Komentar komentar, HttpSession session) {
        Optional<User> userOptional = ud.findById(session.getAttribute("id_user").toString());
        User user = userOptional.get();
        
//        get artikel
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
        List<Artikel> cariArtikel = ad.getArtikelByJudul(listArtikel.get(id-1).getJudul());
    
        komentar.setArtikel(cariArtikel.get(0));
        komentar.setUser(user);
        
        kd.save(komentar);
    }
    
}
