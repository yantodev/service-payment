package com.yantodev.transaksi.repository;

import com.yantodev.transaksi.model.Kategori;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KategoriRepository extends JpaRepository<Kategori, Long> {
}
