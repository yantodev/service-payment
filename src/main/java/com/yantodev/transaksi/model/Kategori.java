package com.yantodev.transaksi.model;

import com.sun.istack.NotNull;
import com.yantodev.transaksi.common.auditable.ModelBase;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "kategori")
public class Kategori extends ModelBase {

    @NotNull
    @Column(name = "name")
    String name;

    public Kategori(){

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
