package com.zees.qa.permission.services;

import com.zees.qa.permission.dto.PermissionRequest;
import com.zees.qa.permission.dto.PermissionResponse;

import java.util.List;

public interface PermissionService {

    PermissionResponse savePermission(PermissionRequest permissionRequest);

    List<PermissionResponse> getAllPermissions();

    PermissionResponse retire(Integer id);
}
