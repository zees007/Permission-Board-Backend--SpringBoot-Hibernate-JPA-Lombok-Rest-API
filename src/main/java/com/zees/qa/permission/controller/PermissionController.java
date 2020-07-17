package com.zees.qa.permission.controller;

import com.zees.qa.permission.dto.PermissionRequest;
import com.zees.qa.permission.dto.PermissionResponse;
import com.zees.qa.permission.repository.PermissionRepository;
import com.zees.qa.permission.services.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class PermissionController {

    @Autowired
    PermissionService permissionService;
    @Autowired
    PermissionRepository permissionRepository;


    @PostMapping(value = "/permission/save")
    public ResponseEntity savePermission(@RequestBody PermissionRequest permissionRequest) {

        PermissionResponse permissionResponse = permissionService.savePermission(permissionRequest);
        return ResponseEntity.ok(permissionResponse);
    }


    @PostMapping(value = "/permissions")
    public ResponseEntity getAllPermissions() {
        List<PermissionResponse> permissionResponse = permissionService.getAllPermissions();
        return ResponseEntity.ok(permissionResponse);
    }

    @PostMapping(value = "/permission/delete/{id}")
    public ResponseEntity<PermissionResponse> retire(@PathVariable("id") Integer id) {

        PermissionResponse permissionResponse = permissionService.retire(id);
        return ResponseEntity.ok().body(permissionResponse);
    }
}
