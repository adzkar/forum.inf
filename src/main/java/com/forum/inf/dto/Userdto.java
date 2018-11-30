package com.forum.inf.dto;

/**
 *
 * @author tayo
 */
public class Userdto {
    private int id;
    private String nama, email;

    public Userdto() {
    }

    public Userdto(int id, String nama, String email) {
        this.nama = nama;
        this.email = email;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
}
