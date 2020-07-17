package com.zees.qa.permission.services;

import com.zees.qa.permission.dto.PermissionRequest;
import com.zees.qa.permission.dto.PermissionResponse;
import com.zees.qa.permission.model.Permission;
import com.zees.qa.permission.repository.PermissionRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    PermissionRepository permissionRepository;

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public PermissionResponse savePermission(PermissionRequest permissionRequest) {
        if (permissionRequest.getFullname() == null) {
            throw new RuntimeException("Parameter Fullname not found in request");
        } else if (permissionRequest.getEmail() == null) {
            throw new RuntimeException("Parameter email not found in request");
        } else if (permissionRequest.getContact() == null) {
            throw new RuntimeException("Parameter contact not found in request");
        } else if (permissionRequest.getRequestedDate() == null) {
            throw new RuntimeException("Parameter Requested Date not found in request");
        }else if (permissionRequest.getPurpose() == null) {
            throw new RuntimeException("Parameter purpose Date not found in request");
        }
        Permission savedPermission = null;
        if (permissionRequest.getId() != null) {
            Permission oldPermission = permissionRepository.findAllValid(permissionRequest.getId());
            if (oldPermission != null) {
                oldPermission.setFullname(permissionRequest.getFullname());
                oldPermission.setEmail(permissionRequest.getEmail());
                oldPermission.setContact(permissionRequest.getContact());
                oldPermission.setRequestedDate(permissionRequest.getRequestedDate());
                oldPermission.setPurpose(permissionRequest.getPurpose());

                savedPermission = permissionRepository.save(oldPermission);
            } else {
                throw new RuntimeException("Cannot find permission with identifier: " + permissionRequest.getId());
            }

        } else {
            Permission permission = modelMapper.map(permissionRequest, Permission.class);
            savedPermission = permissionRepository.save(permission);


        }
        PermissionResponse permissionResponse = modelMapper.map(savedPermission, PermissionResponse.class);
        return permissionResponse;
    }

    @Override
    public List<PermissionResponse> getAllPermissions() {

        List<Permission> permissions = (List<Permission>) permissionRepository.findByValidSortedCreated();
        Type listOfPermissionRes = new TypeToken<List<PermissionResponse>>() {
        }.getType();
        List<PermissionResponse> permissionResponse = modelMapper.map(permissions, listOfPermissionRes);
        return permissionResponse;
    }

    @Override
    public PermissionResponse retire(Integer id) {
        Permission permission = permissionRepository.findAllValid(id);
        permission.setRetired(true);
        permission.setRetiredDate(new Date());
        permissionRepository.save(permission);
        PermissionResponse permissionResponse = modelMapper.map(permission, PermissionResponse.class);
        return permissionResponse;
    }


}
