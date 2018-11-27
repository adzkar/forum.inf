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
@Table(name = "tb_announcement")
public class Announcement {
    @Id @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id_ann")
    private String id;
    
    @Column(nullable = false)
    private String judul;
    
    @Column(nullable = false, columnDefinition = "TEXT", name = "isi_ann")
    private String isi;
    
    @Column(nullable = false, name = "tgl_ann")
    @Temporal(TemporalType.DATE)
    private Date tgl;
}
