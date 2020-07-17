package com.zees.qa.permission.dto;

import javax.persistence.Column;
import java.util.Date;

public class AccessLogRequest {

    private Integer id;
    private Date checkIn;
    private Date checkOut;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }
}
