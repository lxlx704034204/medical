package com.bben.medical.dto;

import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
public class TUserDto {
    @ApiParam("用户名称")
    private String userName;

    @ApiParam("用户密码")
    private String password;

    @ApiParam("性别")
    private String sex;

    @ApiParam("用户类型")
    private String userType;

    @ApiParam("出生日期")
    private Date dateBirth;

    @ApiParam("籍贯")
    private String birthplace;

    @ApiParam("手机")
    private String mobile;

    @ApiParam("电话")
    private String phone;

    @ApiParam("email")
    private String email;

    @ApiParam("证件号码")
    private String idNumber;

    @ApiParam("证件类型")
    private String idNumberType;

    @ApiParam("本人级别")
    private String meLevel;

    @ApiParam("地址")
    private String address;

    @ApiParam("上级人")
    private String boss;

    @ApiParam("上级人级别")
    private String bossLevel;

    @ApiParam("上级联系电话")
    private String bossPhone;

    @ApiParam("上级手机")
    private String bossMobile;

    @ApiParam("过期日期")
    private Date expirationDate;

    @ApiParam("密码问题")
    private String passwordQuestion;

    @ApiParam("密码答案")
    private String passwordAnswer;

    @ApiParam("备注")
    private String description;

}
