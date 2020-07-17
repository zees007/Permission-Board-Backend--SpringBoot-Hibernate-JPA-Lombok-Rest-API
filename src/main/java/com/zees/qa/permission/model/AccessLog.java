package com.zees.qa.permission.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ACCESS_LOG")
public class AccessLog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "CHECK_IN")
    private Date checkIn;
    @Column(name = "CHECK_OUT")
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
