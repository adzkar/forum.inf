package com.forum.inf.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
    private String judul;
    
    @Column(nullable = false, columnDefinition = "TEXT", name = "isi_artikel")
    private String isi;
    
    private String image;
    
    @Column(name = "total_view")
    private int view;
    
    @Column(name = "tgl_publish", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date upload;
}
