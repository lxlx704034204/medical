package com.bben.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 生成编码工具类
 * @Author: Lizhenwei
 * @Date: 2018/11/5 10:53
 */
public final class CodeUtil {

    private final static SimpleDateFormat formatter=new SimpleDateFormat("yyyyMMddHHmmss");

    /**
     * 生成角色编码
     * @return
     */
    public static String generatRoleCode(){
        return "RO"+nowTimeAndRandom();
    }

    /**
     * 生成资源编码
     * @return
     */
    public static String generatResourceCode(){
        return "RE"+nowTimeAndRandom();
    }

    private static String nowTimeAndRandom(){
        String nowTime = formatter.format(new Date());
        return nowTime+U.random(6);
    }

    /**
     * 生成用户编码
     * @return
     */
    public static String generatUserCode(){
        return "UU"+nowTimeAndRandom();
    }

}
