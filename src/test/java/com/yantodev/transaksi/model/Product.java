package com.yantodev.transaksi.model;

import com.sun.istack.NotNull;
import com.yantodev.transaksi.util.auditable.AAuditable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "product")
public class Product extends AAuditable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "kategori_id")
    private Long kategoriId;

    @NotNull
    @Column(name = "product_nama")
    private String productName;

    @NotNull
    @Column(name = "price")
    private float price;

    @NotNull
    @Column(name = "amount")
    private int amount;

}
