package com.zees.qa.permission.dto;

import javax.persistence.Column;
import java.util.Date;

public class AccessLogResponse {


    private Date checkIn;
    private Date checkOut;

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
