package com.ks.bestblog.common.entity;


import com.ks.bestblog.common.MemberDetails;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.security.core.context.SecurityContextHolder;

import java.time.LocalDateTime;


@Getter
public class EssentialColumns {

    @CreatedDate
    private LocalDateTime createDate;

    @LastModifiedDate
    private LocalDateTime updateDate;

    private long createMemberId;

    private long updatedMemberId;

    @PrePersist
    public void perPersistMemberId() {
        MemberDetails memberDetails = (MemberDetails) SecurityContextHolder.getContext().getAuthentication();
        this.createMemberId = memberDetails.getId();
        this.updatedMemberId = memberDetails.getId();
    }

    @PreUpdate
    public void preUpdateUpdatedByUserNo() {
        MemberDetails memberDetails = (MemberDetails)SecurityContextHolder.getContext().getAuthentication();
        this.updatedMemberId = memberDetails.getId();
    }

}
