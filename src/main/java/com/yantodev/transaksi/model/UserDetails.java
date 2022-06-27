package com.yantodev.transaksi.model;

import com.yantodev.transaksi.util.auditable.AAuditable;

import javax.persistence.*;

@Entity
@Table(name = "user_details")
public class UserDetails extends AAuditable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(name = "firstname")
    private String firstname;

}
