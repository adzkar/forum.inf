package com.forum.inf.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author tayo
 */
@Entity
@Table(name = "tb_modul")
public class Modul {
    @Id @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id_modul")
    private String id;
    
    @Column(nullable = false, name = "judul_modul")
    private String judul;
    
    @Column(nullable = false, name = "matkul")
    private String mk;
    
    @Column(nullable = false, precision = 16, scale = 2)
    private Double size;

    @Column(nullable = false, name = "tgl_upload_modul")
    @Temporal(TemporalType.DATE)
    private Date tgl;
    
    @Column(nullable = false)
    private String url;
    
//    Relation
    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private User user;
}
