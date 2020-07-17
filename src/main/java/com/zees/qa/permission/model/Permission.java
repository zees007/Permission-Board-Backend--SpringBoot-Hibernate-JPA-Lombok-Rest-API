package com.zees.qa.permission.model;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PERMISSION")
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "FULL_NAME")
    private String fullname;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "CONTACT")
    private  String contact;

    @Column(name = "REQUESTED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date requestedDate;

    @Column(name = "PURPOSE")
    private String purpose;
    @ColumnDefault("0")
    @Column(name = "RETIRED")
    private Boolean retired = false;
    @Column(name = "RETIRED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date retiredDate;

    public Boolean getRetired() {
        return retired;
    }

    public void setRetired(Boolean retired) {
        this.retired = retired;
    }

    public Date getRetiredDate() {
        return retiredDate;
    }

    public void setRetiredDate(Date retiredDate) {
        this.retiredDate = retiredDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Date getRequestedDate() {
        return requestedDate;
    }

    public void setRequestedDate(Date requestedDate) {
        this.requestedDate = requestedDate;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }
}
