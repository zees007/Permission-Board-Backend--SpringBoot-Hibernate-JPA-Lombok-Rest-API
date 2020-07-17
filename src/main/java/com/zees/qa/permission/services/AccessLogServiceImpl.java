package com.zees.qa.permission.services;

import com.zees.qa.permission.dto.AccessLogRequest;
import com.zees.qa.permission.dto.AccessLogResponse;
import com.zees.qa.permission.dto.PermissionResponse;
import com.zees.qa.permission.model.AccessLog;
import com.zees.qa.permission.model.Permission;
import com.zees.qa.permission.repository.AccessLogRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class AccessLogServiceImpl implements AccessLogService {

    @Autowired
    AccessLogRepository accessLogRepository;

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public AccessLogResponse saveAccessLog(AccessLogRequest accessLogRequest) {
        if (accessLogRequest.getCheckIn() == null) {
            throw new RuntimeException("Parameter checkIn not found in request");
        } else if (accessLogRequest.getCheckOut() == null) {
            throw new RuntimeException("Parameter checkOut not found in request");
        }
        AccessLog savedAccessLog = null;
        if (accessLogRequest.getId() != null) {
            AccessLog oldAccessLog = accessLogRepository.findAll(accessLogRequest.getId());
            if (oldAccessLog != null) {
                oldAccessLog.setCheckIn(accessLogRequest.getCheckIn());
                oldAccessLog.setCheckOut(accessLogRequest.getCheckOut());
                savedAccessLog = accessLogRepository.save(oldAccessLog);
            } else {
                throw new RuntimeException("Cannot find permission with identifier: " + accessLogRequest.getId());
            }

        } else {
            AccessLog accessLog = modelMapper.map(accessLogRequest, AccessLog.class);
            savedAccessLog = accessLogRepository.save(accessLog);

        }
        AccessLogResponse accessLogResponse = modelMapper.map(savedAccessLog, AccessLogResponse.class);
        return accessLogResponse;
    }

    @Override
    public List<AccessLogResponse> getAllAccessLog() {
        List<AccessLog> accessLogs = (List<AccessLog>) accessLogRepository.findByValidSortedCreated();
        Type listOfAccessLogRes = new TypeToken<List<AccessLogResponse>>() {
        }.getType();
        List<AccessLogResponse> accessLogResponse = modelMapper.map(accessLogs, listOfAccessLogRes);
        return accessLogResponse;
    }
}
