package com.yantodev.transaksi.service.kategori;

import com.yantodev.transaksi.common.payload.BaseResponse;
import com.yantodev.transaksi.model.Kategori;
import com.yantodev.transaksi.module.kategori.payload.KategoriResponse;

public interface KategoriService {
    BaseResponse addKategori(KategoriResponse kategoriResponse);
}
