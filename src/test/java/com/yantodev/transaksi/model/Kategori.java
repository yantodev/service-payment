package com.yantodev.transaksi.model;

import com.sun.istack.NotNull;
import com.yantodev.transaksi.util.auditable.AAuditable;

import javax.persistence.*;

@Entity
@Table(name = "kategori")
public class Kategori extends AAuditable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "name")
    String name;

    public Kategori() {

    }

    public Kategori(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
