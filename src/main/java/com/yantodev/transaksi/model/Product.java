package com.yantodev.transaksi.model;

import com.sun.istack.NotNull;
import com.yantodev.transaksi.common.auditable.ModelBase;
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
public class Product extends ModelBase {

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
