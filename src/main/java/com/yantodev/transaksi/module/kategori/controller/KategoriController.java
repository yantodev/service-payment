package com.yantodev.transaksi.module.kategori.controller;
import static com.yantodev.transaksi.common.payload.CommonJWT.PREFIX;
import static com.yantodev.transaksi.common.payload.CommonJWT.SECRET;

import com.yantodev.transaksi.common.payload.BaseResponse;
import com.yantodev.transaksi.model.Kategori;
import com.yantodev.transaksi.module.kategori.payload.KategoriResponse;
import com.yantodev.transaksi.service.kategori.KategoriService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kategori")
public class KategoriController {

    @Autowired
    KategoriService kategoriService;

    @PostMapping("/add-kategori")
    public BaseResponse addKategori(@RequestBody KategoriResponse kategoriResponse, @RequestHeader("Authorization") String header){
        String jwtToken = header.replace(PREFIX, "");
        Claims claims = Jwts.parser().setSigningKey(SECRET.getBytes()).parseClaimsJws(jwtToken).getBody();
        String user = claims.get("sub").toString();
        return kategoriService.addKategori(kategoriResponse);
    }
}
