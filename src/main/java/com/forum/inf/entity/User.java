/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
@Table(name = "tb_user")
public class User {
    @Id @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id_user")
    private String id;
    
    @Column(nullable = false, name = "nama_user")
    private String nama;
    
    @Column(nullable = false)
    private String pass;

    @Column(nullable = false)
    private String email;
    
    @Column(nullable = false)
    private String status = "user";
}
