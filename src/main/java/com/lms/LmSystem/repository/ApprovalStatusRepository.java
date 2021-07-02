package com.lms.LmSystem.repository;

import com.lms.LmSystem.entity.ApprovalStatus;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApprovalStatusRepository extends CrudRepository<ApprovalStatus, String> {
    @Query(value = "SELECT * FROM approval_status WHERE status_approval = 'true'", nativeQuery = true)
    List<ApprovalStatus> getActiveApprovalStatus();

    @Query(value = "SELECT * FROM approval_status WHERE approval_status_id = :id", nativeQuery = true)
    List <ApprovalStatus> getApprovalStatusById(@Param(value="id") Integer id);

//    @Query(value = "SELECT * FROM product_category", nativeQuery = true)
//    List <ProductCategory>  getMax();
}
