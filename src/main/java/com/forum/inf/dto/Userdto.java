package com.forum.inf.dto;

/**
 *
 * @author tayo
 */
public class Userdto {
    private String nama, email;

    public Userdto() {
    }

    public Userdto(String nama, String email) {
        this.nama = nama;
        this.email = email;
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
