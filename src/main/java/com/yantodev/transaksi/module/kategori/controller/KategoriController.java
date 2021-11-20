package com.yantodev.transaksi.module.kategori.controller;

import com.yantodev.transaksi.common.payload.BaseResponse;
import com.yantodev.transaksi.model.Kategori;
import com.yantodev.transaksi.service.kategori.KategoriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kategori")
public class KategoriController {

    @Autowired
    KategoriService kategoriService;

    @PostMapping("/add-kategori")
    public BaseResponse addKategori(@RequestBody Kategori kategori){
        return kategoriService.addKategori(kategori);
    }
}
