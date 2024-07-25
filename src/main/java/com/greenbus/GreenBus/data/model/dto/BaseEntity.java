package com.greenbus.GreenBus.data.model.dto;

import com.greenbus.GreenBus.util.CommonUtil;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass
public class BaseEntity {
    private String createdOn;
    private String modifiedOn;

    public void createEntity(){
        this.createdOn = CommonUtil.getCurrentDate();
    }

    public void modifyEntity(){
        this.modifiedOn = CommonUtil.getCurrentDate();
    }
}