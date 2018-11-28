package com.forum.inf.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "tb_artikel")
public class Artikel {
    @Id @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id_artikel")
    private String id;
    
    @Column(nullable = false, name = "judul_artikel")
    @NotNull @NotEmpty
    private String judul;
    
    @Column(nullable = false, columnDefinition = "TEXT", name = "isi_artikel")
    @NotNull @NotEmpty
    private String isi;
    
    private String image;
    
    @Column(name = "total_view")
    private int view = 0;
    
    @Column(name = "tgl_publish", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date upload = new Date();
    
//    Relation
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "artikel")
    private List<Komentar> daftar_komentar = new ArrayList<>();

    @ManyToMany
    @JoinTable(
        name = "tb_tag_artikel",
        joinColumns = @JoinColumn(name = "id_artikel"),
        inverseJoinColumns = @JoinColumn(name = "id_tag")
    )
    private List<Tag> daftarTag = new ArrayList<>();
    
    @ManyToMany(mappedBy = "daftarArtikel")
    private List<User> daftarUser = new ArrayList<>();
    
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    public Date getUpload() {
        return upload;
    }

    public void setUpload(Date upload) {
        this.upload = upload;
    }

    public List<Komentar> getDaftar_komentar() {
        return daftar_komentar;
    }
    
    
}
