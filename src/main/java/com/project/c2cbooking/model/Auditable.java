package com.project.c2cbooking.model;

import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.sql.Timestamp;

@Setter(AccessLevel.PROTECTED)
@Getter(AccessLevel.PROTECTED)
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class Auditable<U> {
    @CreatedBy
    @Column(name = "created_by")
    private U createdBy;

    @CreatedDate
    @Column(name = "created_at", length = 3)
    private Timestamp createdDate;

    @LastModifiedBy
    @Column(name = "update_by")
    private U updatedBy;

    @LastModifiedDate
    @Column(name = "update_at", length = 3)
    private Timestamp updatedDate;


}
