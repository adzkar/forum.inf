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
@Table(name = "tb_komentar")
public class Komentar {
    @Id @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id_komentar")
    private String id;
    
    @Column(name = "judul_komentar", nullable = false)
    private String judul;
    
    @Column(name = "isi_komentar", nullable = false)
    private String isi;
    
    @Column(name = "tgl_komentar", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date tgl;
}
