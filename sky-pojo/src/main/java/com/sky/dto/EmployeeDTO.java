package com.sky.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(description = "添加员工时传递的数据模型")
public class EmployeeDTO implements Serializable {

    @ApiModelProperty("员工id，默认不传")
    private Long id;

    @ApiModelProperty("员工用户名")
    private String username;

    @ApiModelProperty("员工真实性名")
    private String name;

    @ApiModelProperty("员工电话号码")
    private String phone;

    @ApiModelProperty("员工性别")
    private String sex;

    @ApiModelProperty("员工身份账号")
    private String idNumber;

}
