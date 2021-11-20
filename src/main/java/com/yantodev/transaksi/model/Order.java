package com.yantodev.transaksi.model;

import com.yantodev.transaksi.common.auditable.ModelBase;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="tbl_order")
public class Order extends ModelBase {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product productId;

    @Column(name = "amount")
    private int amount;

    @Column(name = "totak_price")
    private double totalPrice;

    @Column(name = "is_cancel")
    private int isCancel;

}
