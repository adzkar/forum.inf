package com.forum.inf.dao;

import com.forum.inf.entity.User;
import com.forum.inf.entity.Artikel;
import com.forum.inf.entity.Tag;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author tayo
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestArtikel {
    
    @Autowired
    private DataSource ds;
    
    @Autowired
    private ArtikelDao ad;
    
    @Autowired
    private UserDao ud;
    
    @Autowired
    private JpaTransactionManager jtm;
    
//    @Test
    public void testInsertArtikel() throws SQLException {
        User u = new User();
        u.setNama("Tuyul");
        u.setEmail("adzkarfauzie02@gmail.com");
        u.setPass("12345dksjlkddjflkjf");
        
        Artikel a = new Artikel();
        a.setImage("sadf");
        a.setIsi("sdafgds");
        a.setJudul("sdfsdjlkaj");
        
        Tag t = new Tag();
        t.setNama("Entah");
        a.getDaftarTag().add(t);
        
//        u.getDaftarArtikel().add(a);
        
        a.getDaftarUser().add(u);

        ad.save(a);
        
        ds = jtm.getDataSource();
        
        try(Connection c = ds.getConnection()) {
            String sql = "select count(*) as jumlah from tb_artikel";
            ResultSet rs = c.createStatement().executeQuery(sql);
            Assert.assertTrue(rs.next());
            Assert.assertEquals(1L, rs.getLong("jumlah"));
        }
        
    }
    
//    @Test
    public void testTambahArtikel() throws SQLException {
        Artikel a = new Artikel();
        a.setImage("Gambar boi");
        a.setIsi("contennya ceritanya");
        a.setJudul("Hola Dunia");
        
        ad.save(a);
        
        ds = jtm.getDataSource();
        
        try(Connection c = ds.getConnection()) {
            String sql = "select count(*) as jumlah from tb_artikel where judul_artikel='Hola Dunia'";
            ResultSet rs = c.createStatement().executeQuery(sql);
            Assert.assertTrue(rs.next());
            Assert.assertEquals(1L, rs.getLong("jumlah"));
        }
        
    }
    
    @Test
    public void tambahArtikelId() throws SQLException {
        Artikel a = new Artikel();
        a.setImage("Gambar boi");
        a.setIsi("adfsd");
        a.setJudul("Hola World");
        
        String id = ad.save(a).getId();
        
        ds = jtm.getDataSource();
        
        try(Connection c = ds.getConnection()) {
            String sql = "select count(*) as jumlah from tb_artikel where id_artikel='"+id+"'";
            ResultSet rs = c.createStatement().executeQuery(sql);
            Assert.assertTrue(rs.next());
            Assert.assertEquals(1L, rs.getLong("jumlah"));
        }
    }
    
}
