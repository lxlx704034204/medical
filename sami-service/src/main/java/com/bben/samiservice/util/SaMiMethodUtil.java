package com.bben.samiservice.util;

import com.bben.common.util.U;
import com.ibm.icu.text.SimpleDateFormat;

import java.text.ParseException;
import java.util.Date;

public class SaMiMethodUtil {

    private static final SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");

    public static int chooseSex(String sex){
        if (U.isBlank(sex)){
            return 2;
        }
        switch (sex){
            case "N":
                return 0;
            case "F":
                return 1;
                default:return 2;
        }

    }

    public static int chooseMaritalStatus(String maritalStatus){
        if (U.isBlank(maritalStatus)){
            return 2;
        }
        switch (maritalStatus){
            case "S":
                return 0;
            case "M":
                return 1;
            default:return 2;
        }

    }


    public static Date dateFormat(String date) {
        if (U.isBlank(date)){
            return new Date();
        }
        Date date1;
        try {
            date1 = fmt.parse("19640921000000");
        } catch (ParseException e) {
            e.printStackTrace();
            return new Date();
        }
        return date1;
    }

    public static String strVal(String value){
        if (U.isBlank(value)){
            return "";
        }
        return value;
    }

    public static int intVal(String value){
        if (U.isBlank(value)){
            return 0;
        }
        return Integer.valueOf(value);
    }

    public static Byte byteVal(String value){
        if (U.isBlank(value)){
            return 0;
        }
        byte i;
        try {
            i = (byte)Integer.parseInt(value);
        } catch (Exception e){
            e.printStackTrace();
            return 0;
        }
        return i;
    }

    public static void main(String[] args) {
        /*String sex = "";
        int s = SaMiMethodUtil.chooseSex(sex);
        System.out.println(s);*/
        Date date = SaMiMethodUtil.dateFormat("19640921");
        System.out.println(date);
    }
}
