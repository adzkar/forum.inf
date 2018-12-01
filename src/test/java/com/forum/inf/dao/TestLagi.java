package com.forum.inf.dao;

import com.forum.inf.entity.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import junit.framework.Assert;
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
public class TestLagi {
    
    @Autowired
    private UserDao ud;
    
    @Autowired
    private JpaTransactionManager jtm;
    
    @Autowired
    private DataSource ds;
    
    @Test
    public void testLagi() throws Exception {
        String sql = "select count(*) as jumlah from tb_user where nama_user='Test2'";
        ds = jtm.getDataSource();
        try(Connection c = ds.getConnection()) {
            ResultSet rs = c.createStatement().executeQuery(sql);
            Assert.assertTrue(rs.next());
            Assert.assertEquals(1L, rs.getLong("jumlah"));
        }
    }
    
//    @Test
//    public void testInsertUser() throws SQLException {
//        User u = new User();
//        u.setEmail("sukimin@sukimin.com");
//        u.setNama("Sukimin binti Sukaman");
//        u.setPass("asdf");
//        ud.save(u);
////        String sql = "select count(*) as jumlah from tb_user where nama_user='Sukimin binti Sukaman'";
////        ds = jtm.getDataSource();
////        try(Connection c = ds.getConnection()) {
////            ResultSet rs = c.createStatement().executeQuery(sql);
////            Assert.assertTrue(rs.next());
////            Assert.assertEquals(1L, rs.getLong("jumlah"));
////        }
//    }
    
}
