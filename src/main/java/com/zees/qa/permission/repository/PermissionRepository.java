package com.zees.qa.permission.repository;

import com.zees.qa.permission.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PermissionRepository extends CrudRepository<Permission, Integer> {

    @Query(value = "select * from PERMISSION " +
            "where id=:id " +
            "and retired=0 "
            , nativeQuery = true)
    Permission findAllValid(@Param("id") Integer id);

    @Query(value = "select * from PERMISSION " + "where retired=0 "+
            "ORDER by id desc ", nativeQuery = true)
    List<Permission> findByValidSortedCreated();
}
