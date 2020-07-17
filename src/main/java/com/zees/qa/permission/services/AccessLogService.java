package com.zees.qa.permission.services;

import com.zees.qa.permission.dto.AccessLogRequest;
import com.zees.qa.permission.dto.AccessLogResponse;

import java.util.List;

public interface AccessLogService {


    AccessLogResponse saveAccessLog(AccessLogRequest accessLogRequest);

    List<AccessLogResponse> getAllAccessLog();
}
