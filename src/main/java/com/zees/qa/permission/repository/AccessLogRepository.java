package com.zees.qa.permission.repository;

import com.zees.qa.permission.model.AccessLog;
import com.zees.qa.permission.model.Permission;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccessLogRepository extends CrudRepository<AccessLog, Integer> {

    @Query(value = "select * from ACCESS_LOG " +
            "where id=:id "
            , nativeQuery = true)
    AccessLog findAll(@Param("id") Integer id);

    @Query(value = "select * from ACCESS_LOG ", nativeQuery = true)
    List<AccessLog> findByValidSortedCreated();
}
