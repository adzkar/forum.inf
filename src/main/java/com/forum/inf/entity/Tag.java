package com.forum.inf.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author tayo
 */
@Entity
@Table(name = "tb_tag")
public class Tag {
    @Id @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id_tag")
    private String id;
    
    @Column(nullable = false, name = "nama_tag")
    @NotNull @NotEmpty
    private String nama;
    
    @ManyToMany(mappedBy = "daftarTag")
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
    
}
