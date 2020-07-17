package com.zees.qa.permission.controller;

import com.zees.qa.permission.dto.AccessLogRequest;
import com.zees.qa.permission.dto.AccessLogResponse;
import com.zees.qa.permission.dto.PermissionRequest;
import com.zees.qa.permission.dto.PermissionResponse;
import com.zees.qa.permission.services.AccessLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccessLogController {

    @Autowired
    AccessLogService accessLogService;

    @PostMapping(value = "/accessLog/save")
    public ResponseEntity saveAccessLog(@RequestBody AccessLogRequest accessLogRequest) {

        AccessLogResponse accessLogResponse = accessLogService.saveAccessLog(accessLogRequest);
        return ResponseEntity.ok(accessLogResponse);
    }

    @PostMapping(value = "/accessLogs")
    public ResponseEntity getAllAccessLog() {
        List<AccessLogResponse> accessLogResponse = accessLogService.getAllAccessLog();
        return ResponseEntity.ok(accessLogResponse);
    }
}
