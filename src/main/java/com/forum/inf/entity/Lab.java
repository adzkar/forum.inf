package com.forum.inf.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author tayo
 */
@Entity
@Table(name = "tb_lab")
public class Lab {
    @Id @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id_lab")
    private String id;
    
    @Column(nullable = false)
    private String nama;
    
    @Column(nullable = false)
    private String kategori;
    
    @Column(nullable = false, name = "dosen_pembina")
    private String dosen;
    
    @Column(nullable = false, columnDefinition = "TEXT")
    private String deskripsi;
}