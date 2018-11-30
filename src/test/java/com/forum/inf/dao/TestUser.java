package com.forum.inf.dao;

import com.forum.inf.entity.Lab;
import com.forum.inf.entity.Modul;
import com.forum.inf.entity.User;
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
public class TestUser {
   @Autowired
   private UserDao ud;
    
   @Autowired
   private DataSource ds;
   
   @Autowired
   private JpaTransactionManager jtm;
   
   @Test
   public void testInsertUser() throws SQLException {
       User u = new User();
       u.setNama("Taek");
       u.setEmail("taek@test.com");
       u.setPass("123456789010");
       ud.save(u);
     
       Modul m = new Modul();
       m.setJudul("TAEK TAEK");
       m.setMk("SA");
       m.setSize(10.0);
       m.setUrl("hasdola");
       m.setUser(u); 
       
       u.getDaftarModul().add(m);
       
       ud.save(u);
       
       ds = jtm.getDataSource();
       
       try(Connection c = ds.getConnection()) {
           String sql = "select count(*) as jumlah from tb_user where nama_user='Taek'";
           ResultSet rs = c.createStatement().executeQuery(sql);
           Assert.assertTrue(rs.next());
           Assert.assertEquals(1L, rs.getLong("jumlah"));
       }
   }
   
   @Test
   public void insertLab() throws SQLException {
       User u = new User();
       u.setNama("Tssakdef");
       u.setEmail("asdf@test.com");
       u.setPass("asadf");
       ud.save(u);
       
       Lab l = new Lab();
       l.setNama("AI");
       l.setDeskripsi("Testing");
       l.setDosen("Andit");
       l.setKategori("ICM");
       l.setUser(u);
       
       u.getDaftarLab().add(l);
       ud.save(u);
       
       ds = jtm.getDataSource();
       
       try(Connection c = ds.getConnection()) {
           String sql = "select count(*) as jumlah from tb_user where nama_user='Tssakdef'";
           ResultSet rs = c.createStatement().executeQuery(sql);
           Assert.assertTrue(rs.next());
           Assert.assertEquals(2L, rs.getLong("jumlah"));
       }
   }
   
}
