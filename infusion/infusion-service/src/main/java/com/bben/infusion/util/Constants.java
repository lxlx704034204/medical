package com.bben.infusion.util;

/**
 * 自定义常量
 */
public class Constants {

    //执行状态 0未输液  1正在输液 2输液结束
    public static final class RunStatusConstant{
        public static final Integer  NOT = 0;
        public static final Integer  DOING = 1;
        public static final Integer  OVER = 2;
    };

    //输液状态 0：正常  1：过快 2：过慢 3：即将结束 4：输液暂停 5：已结束待处理 6：设备故障
    public static final class InfusionStatus{
        public static final int NORMAL = 0;
        public static final int FAST = 1;
        public static final int SLOW = 2;
        public static final int ENDING = 3;
        public static final int PAUSE = 4;
        public static final int OVER = 5;
        public static final int ERROR = 6;
    }

    //背景颜色 0：蓝色 1：红色 2：黄色 3：棕色
    public static final class BoardStatus{
        public static final int BLUE = 0;
        public static final int RED = 1;
        public static final int YELLOW = 2;
        public static final int BROWN = 3;
    }

    //电池状态 0：电量正常 1：电量不足
    public static final class BatteryStatus{
        public static final int NORMAL = 0;
        public static final int LACK = 1;
    }

    //全局配置参数
    public static final class ControlParam{
        public static final String INFUSION_ENDING_WARN = "infusion_ending_warn";
        public static final String INFUSION_END_WARN = "infusion_end_warn";
        public static final String INFUSION_ENDING_WARN_DEFAULT = "85";//默认输液即将结束阀值
        public static final String INFUSION_END_WARN_DEFAULT = "95";//默认输液已经结束阀值
    }

    public static final int RECENTLY_GATHER = 5;//最近5条监控数据
    public static final int CALL_INTERVAL_TIME = 2;//最近两天的输液呼叫
    public static final String CALL_PREFIX_REDIS = "call";
    public static final String INFUSION_PREFIX_REDIS = "infusion";

    public static final String voicePath = "http://172.40.1.137:8083/voice/";//相当于资源服务器访问路径
    public static final String voiceSuffix = ".wav";
    public static final String redisSplit = ":";

    public static final String voicesPath = "D:\\company\\svndata\\branches\\java后台代码\\BbenMedical\\infusion\\infusion-service\\src\\main\\resources\\templates";


}
