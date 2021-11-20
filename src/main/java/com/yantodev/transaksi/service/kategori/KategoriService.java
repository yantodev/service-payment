package com.yantodev.transaksi.service.kategori;

import com.yantodev.transaksi.common.payload.BaseResponse;
import com.yantodev.transaksi.model.Kategori;

public interface KategoriService {
    BaseResponse addKategori(Kategori kategori);
}
