package com.yantodev.transaksi.service.kategori.impl;

import com.yantodev.transaksi.common.payload.BaseResponse;
import com.yantodev.transaksi.common.payload.CommonMessage;
import com.yantodev.transaksi.model.Kategori;
import com.yantodev.transaksi.module.kategori.payload.KategoriResponse;
import com.yantodev.transaksi.repository.KategoriRepository;
import com.yantodev.transaksi.service.kategori.KategoriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KategoriImpl implements KategoriService {
    @Autowired
    KategoriRepository kategoriRepository;

    @Override
    public BaseResponse addKategori(KategoriResponse kategoriResponse) {
        try{
            Kategori kategori1 = new Kategori();
            kategori1.setName(kategoriResponse.getName());
            kategori1.setIsDeleted(0);

            kategoriRepository.save(kategori1);
            return new BaseResponse(CommonMessage.SAVED,200, kategoriResponse);
        } catch (Exception e){
            return new BaseResponse(CommonMessage.ERROR, 400);
        }
    }
}
