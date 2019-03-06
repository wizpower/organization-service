package com.thoughtmechanix.organization.model;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "organizations")
public class Organization {

    @ApiModelProperty("组织ID")
    @Id
    @Column(name = "organization_id", nullable = false)
    String id;

    @ApiModelProperty("名称")
    @Column(name = "name", nullable = false)
    String name;

    @ApiModelProperty("联系人")
    @Column(name = "contact_name", nullable = false)
    String contactName;

    @ApiModelProperty("联系人邮箱")
    @Column(name = "contact_email", nullable = false)
    String contactEmail;

    @ApiModelProperty("联系人电话")
    @Column(name = "contact_phone", nullable = false)
    String contactPhone;


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }
}
