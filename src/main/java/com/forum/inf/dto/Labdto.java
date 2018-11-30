package com.forum.inf.dto;

/**
 *
 * @author tayo
 */
public class Labdto {
    private int id;
    private String nama, kategori, dosen, deskripsi;

    public Labdto() {
    }

    public Labdto(int id, String nama, String kategori, String dosen, String deskripsi) {
        this.id = id;
        this.nama = nama;
        this.kategori = kategori;
        this.dosen = dosen;
        this.deskripsi = deskripsi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getDosen() {
        return dosen;
    }

    public void setDosen(String dosen) {
        this.dosen = dosen;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    
    
}
