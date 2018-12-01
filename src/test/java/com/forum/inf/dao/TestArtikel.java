package com.forum.inf.dao;

import com.forum.inf.entity.User;
import com.forum.inf.entity.Artikel;
import com.forum.inf.entity.Komentar;
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
    private TagDao td;
    
    @Autowired
    private UserDao ud;
    
    @Autowired
    private KomentarDao kd;
    
    @Autowired
    private JpaTransactionManager jtm;
    
//    Failed
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
    
//    Sucess
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
    
//    Success
//    @Test
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
    
//    Failed
//    @Test
    public void artikelAndKomentar() throws SQLException {
        Artikel a = new Artikel();
        a.setImage("sdfsda");
        a.setIsi("sad");
        a.setJudul("Ini yang baru");
        
        Komentar e = new Komentar();
        
        e.setJudul("Nais");
        e.setIsi("TY GAN");
        
        User user = new User();
        user.setId("18189a72-8203-4279-8ea2-4708b000cb1b");
        
        e.setUser(user);
        
        kd.save(e);
        
        a.getDaftar_komentar().add(e);
        
        String id = ad.save(a).getId();
        
        ds = jtm.getDataSource();
        
        try(Connection c = ds.getConnection()) {
            String sql = "select count(*) as jumlah from tb_artikel where id_artikel='"+id+"'";
            ResultSet rs = c.createStatement().executeQuery(sql);
            Assert.assertTrue(rs.next());
            Assert.assertEquals(1L, rs.getLong("jumlah"));
        }
    }
    
//    Sucess
//    @Test
    public void insertArtikelandTag() throws SQLException {
        Tag tag = new Tag();
        tag.setNama("Contoh Tag");
        
        String id_tag = td.save(tag).getId();
        
        Artikel a = new Artikel();
        a.setImage("askdf");
        a.setIsi("contennya ceritanya asdfaksjfl");
        a.setJudul("Halo Dunia");
        
        a.getDaftarTag().add(tag);
        
        String id = ad.save(a).getId();
        
        ds = jtm.getDataSource();
        
        try(Connection c = ds.getConnection()) {
            String sql = "select count(*) as jumlah from tb_artikel where id_artikel='"+id+"'";
            ResultSet rs = c.createStatement().executeQuery(sql);
            Assert.assertTrue(rs.next());
            Assert.assertEquals(1L, rs.getLong("jumlah"));
        }
        
    }
    
//    @Test
    public void insertArtikelTagUser() throws SQLException {
        Tag tag = new Tag();
        tag.setNama("Tag KeLima");
        
        String id_tag = td.save(tag).getId();
        
        User u = new User();
        u.setNama("BaruUser");
        u.setEmail("BaruUser@BaruUser.com");
        u.setPass("MasukPakEko");
        
        
        Artikel a = new Artikel();
        a.setImage("Contoh Gambarnya boss");
        a.setIsi("Isinya Ceritanya");
        a.setJudul("Semoga Kali ini relasi artikel dengan user berhasil");
        
        a.getDaftarTag().add(tag);
        
        String id = ad.save(a).getId();
        
        u.getDaftarArtikel().add(a);
        
        ud.save(u);
        
        ds = jtm.getDataSource();
        
        try(Connection c = ds.getConnection()) {
            String sql = "select count(*) as jumlah from tb_artikel where id_artikel='"+id+"'";
            ResultSet rs = c.createStatement().executeQuery(sql);
            Assert.assertTrue(rs.next());
            Assert.assertEquals(1L, rs.getLong("jumlah"));
        }
        
    }
    
//    Failed
    @Test
    public void insertKomentardanArtikel() throws SQLException {
        Artikel artikel = new Artikel();
        artikel.setImage("sad");
        artikel.setIsi("sad");
        artikel.setJudul("sad");
        
        User user = new User();
        user.setNama("BaruUser");
        user.setEmail("BaruUser@BaruUser.com");
        user.setPass("MasukPakEko");
        
        Komentar komentar = new Komentar();
        komentar.setArtikel(artikel);
        komentar.setIsi("Nais Gan");
        komentar.setJudul("OYi2 jos");
        komentar.setUser(user);
        komentar.setArtikel(artikel);
        
        
        String id = kd.save(komentar).getId();
        
        ds = jtm.getDataSource();
        
        try(Connection c = ds.getConnection()) {
            String sql = "select count(*) as jumlah from tb_komentar where id_komentar='"+id+"'";
            ResultSet rs = c.createStatement().executeQuery(sql);
            Assert.assertTrue(rs.next());
            Assert.assertEquals(1L, rs.getLong("jumlah"));
        }
        
    }
    
}
