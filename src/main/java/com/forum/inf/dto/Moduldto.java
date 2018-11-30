package com.forum.inf.dto;

import java.util.Date;

/**
 *
 * @author tayo
 */
public class Moduldto {
    private int id;
    private String judul,mk,url;
    private Double size;
    private Date tgl;

    public Moduldto() {
    }

    public Moduldto(int id, String judul, String mk, Double size, Date tgl, String url) {
        this.id = id;
        this.judul = judul;
        this.mk = mk;
        this.url = url;
        this.size = size;
        this.tgl = tgl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getMk() {
        return mk;
    }

    public void setMk(String mk) {
        this.mk = mk;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public Date getTgl() {
        return tgl;
    }

    public void setTgl(Date tgl) {
        this.tgl = tgl;
    }
    
    
    
}
