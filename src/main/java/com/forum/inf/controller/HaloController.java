package com.forum.inf.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author tayo
 */
@RestController
public class HaloController {
    
    @RequestMapping("/halo")
    public Map<String, Object> halo() {
        Map<String, Object> hasil = new HashMap<>();
        hasil.put("waktu", new Date());
        return hasil;
    }

    @RequestMapping("/testList")
    public List daftarNama() {
        List nama = new ArrayList();
        nama.add("Paijo");
        nama.add("Paij");
        nama.add("Pai");
        return nama;
    }
    
    @RequestMapping("/testlistlagi")
    public Map<Integer, Object> daftarNama2() {
        Map<Integer, Object> m = new HashMap<>();
        List nama = new ArrayList();
        nama.add("Paijo");
        nama.add("Paij");
        nama.add("Pai");
        m.put(0, nama);
        return m;
    }
    
}
