package com.breakthebill.Break.the.Bill.repository;

import com.breakthebill.Break.the.Bill.model.GroupOwnershipTransfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupOwnershipTransferRepository extends JpaRepository<GroupOwnershipTransfer, Long> {
}
