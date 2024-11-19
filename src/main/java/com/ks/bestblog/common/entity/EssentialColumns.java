package com.ks.bestblog.common.entity;


import com.ks.bestblog.common.MemberDetails;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.context.SecurityContextHolder;

import java.time.LocalDateTime;


@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class EssentialColumns {

    @CreatedDate
    private LocalDateTime createDate;

    @LastModifiedDate
    private LocalDateTime updateDate;

    private long createMemberId;

    private long updateMemberId;

    @PrePersist
    public void perPersistMemberId() {
        MemberDetails memberDetails = (MemberDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        this.createMemberId = memberDetails.getId();
        this.updateMemberId = memberDetails.getId();
    }

    @PreUpdate
    public void preUpdateUpdatedByUserNo() {

            MemberDetails memberDetails = (MemberDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (memberDetails != null) {
            this.updateMemberId = memberDetails.getId();
            this.updateDate = LocalDateTime.now();
        }
    }
}
