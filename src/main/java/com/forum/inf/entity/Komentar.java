package com.forum.inf.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author tayo
 */
@Entity
@Table(name = "tb_komentar")
public class Komentar {
    @Id @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id_komentar")
    private String id;
    
    @Column(name = "judul_komentar", nullable = false)
    @NotNull @NotEmpty
    private String judul;
    
    @Column(name = "isi_komentar", nullable = false)
    @NotNull @NotEmpty
    private String isi;
    
    @Column(name = "tgl_komentar", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date tgl = new Date();
    
//    Relation
    @ManyToOne
    @JoinColumn(name = "id_artikel", nullable = false)
    private Artikel artikel;
    
    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Date getTgl() {
        return tgl;
    }

    public void setTgl(Date tgl) {
        this.tgl = tgl;
    }

    public Artikel getArtikel() {
        return artikel;
    }

    public void setArtikel(Artikel artikel) {
        this.artikel = artikel;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    
}
