package com.forum.inf.dto;

import com.forum.inf.entity.Komentar;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author tayo
 */
public class Artikeldto {
   private int id, total_view;
   private String judul, isi, image;
   private Date tgl_publish;
   private List<Komentardto> daftarKomentar = new ArrayList<>();

    public Artikeldto() {
    }

    public Artikeldto(int id, String judul, String isi, Date tgl_publish,int total_view, String image) {
        this.id = id;
        this.total_view = total_view;
        this.judul = judul;
        this.isi = isi;
        this.image = image;
        this.tgl_publish = tgl_publish;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotal_view() {
        return total_view;
    }

    public void setTotal_view(int total_view) {
        this.total_view = total_view;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getIsi() {
        return isi;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getTgl_publish() {
        return tgl_publish;
    }

    public void setTgl_publish(Date tgl_publish) {
        this.tgl_publish = tgl_publish;
    }

    public List<Komentardto> getDaftarKomentar() {
        return daftarKomentar;
    }

    public void setDaftarKomentar(List<Komentardto> daftarKomentar) {
        this.daftarKomentar = daftarKomentar;
    }
   
    
   
}
