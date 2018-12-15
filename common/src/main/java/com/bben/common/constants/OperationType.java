package com.bben.common.constants;

public class OperationType {

    /**
     * 添加/更新类型
     */
    public static final String  ADD_OR_UPDATE= "ADD_OR_UPDATE";

    /**
     * 删除类型
     */
    public static final String DELETE = "DELETE";

    public static String getUpdate(){
        return ADD_OR_UPDATE;
    }
    public static String getDelete(){
        return DELETE;
    }

    public static int getOperationType(String operationType){
        switch (operationType){
            case ADD_OR_UPDATE:return 1;
            case DELETE:return 2;
            default:return 0;
        }

    }


}
