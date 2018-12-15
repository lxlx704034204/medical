package com.bben.common.constants;

/**
 * @Author: Lizhenwei
 * @Date: 2018/11/6 14:54
 */
public enum  Status {

    /**
     * 有效
     */
    EFFECTIVE(1)  ,

    /**
     * 无效
     */
    INVALID(0);

    private Integer status;


    private Status(int status){
        this.status = status;
    }

    public Integer getStatus(){
        return status;
    }
}
