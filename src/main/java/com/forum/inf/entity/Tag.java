package com.forum.inf.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
    private String nama;
    
//    Relation
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "tag")
    private List<Artikel> daftarArtikel = new ArrayList<>();
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "tag")
    private List<Announcement> daftarAnn = new ArrayList<>();
}
