package com.yantodev.transaksi.util.auditable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
@Getter
@Setter
public abstract class AAuditable {

    @JsonIgnore
    @CreatedBy
    @Column(name = "created_by", updatable = false, nullable = false)
    protected Long createdBy;

    @JsonIgnore
    @CreatedDate
    @Column(name = "created_on", nullable = false, updatable = false)
    protected Date createdOn;

    @JsonIgnore
    @LastModifiedBy
    @Column(name = "modified_by")
    protected Long modifiedBy;

    @JsonIgnore
    @LastModifiedDate
    @Column(name = "modified_on")
    protected Date modifiedOn;
}
