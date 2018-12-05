/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.forum.inf.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author tayo
 */
@Entity
@Table(name = "tb_user")
public class User {
    @Id @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id_user")
    private String id;
    
    @Column(nullable = false, name = "nama_user")
    @Size(max = 20)
    private String nama;
    
    @Column(nullable = false)
    @NotNull @NotEmpty
    @Size(min = 8)
    private String pass;

    @Column(nullable = false, unique = true)
    @NotNull @NotEmpty
    @Email
    private String email;
    
    @Column(nullable = false)
    private String status = "user";
    
//    Relation
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "user")
    private List<Komentar> daftarKomentar = new ArrayList<>();
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "user")
    private List<Modul> daftarModul = new ArrayList<>();
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "user")
    private List<Lab> daftarLab = new ArrayList<>();
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "user")
    private List<Announcement> daftarAnn = new ArrayList<>();
    
//    @ManyToMany
//    @JoinTable(
//            name = "tb_daftar_artikel",
//            joinColumns = @JoinColumn(name = "id_user"),
//            inverseJoinColumns = @JoinColumn(name = "id_artikel")
//    )
//    private List<Artikel> daftarArtikel = new ArrayList<>();
    
    @OneToMany(
            mappedBy = "user"
    )
    private List<Artikel> daftarArtikel = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Komentar> getDaftarKomentar() {
        return daftarKomentar;
    }

    public List<Modul> getDaftarModul() {
        return daftarModul;
    }

    public List<Lab> getDaftarLab() {
        return daftarLab;
    }

    public List<Announcement> getDaftarAnn() {
        return daftarAnn;
    }

    public List<Artikel> getDaftarArtikel() {
        return daftarArtikel;
    }
    
    
    
}
