package com.bben.infusion.util;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class VoiceFile {

    public static void main(String[] args) throws IOException {
        String date = DateUtil.SDF_STANDARD_DAY.format(new Date());
        String fileName = String.valueOf(System.nanoTime()) + Constants.voiceSuffix;
        String voicePath = Constants.voicePath + date + "/" + fileName;
        voiceConvertFile(date,"I just want to test it!!!",fileName);

//        Date date = DateUtil.getBeforeDayTime(new Date(),2);
//        String day = DateUtil.SDF_STANDARD_DAY.format(new Date());
//        System.out.println("day:"+day);
//
//        String path = Constants.voicesPath + File.separator + day;
//        System.out.println("path:"+path);
//        FileUtil.delFolder(path);

    }

    public static void voiceConvertFile(String date,String content,String fileName){
        try {
            ActiveXComponent ax = new ActiveXComponent("Sapi.SpVoice");

            //运行时输出语音内容
            Dispatch spVoice = ax.getObject();
//            本地播放
//            // 音量 0-100
//            ax.setProperty("Volume", new Variant(100));
//            // 语音朗读速度 -10 到 +10
//            ax.setProperty("Rate", new Variant(-3));
//            // 执行朗读
//            Dispatch.call(spVoice, "Speak", new Variant(content));

            //下面是构建文件流把生成语音文件
            ax = new ActiveXComponent("Sapi.SpFileStream");
            Dispatch spFileStream = ax.getObject();
            ax = new ActiveXComponent("Sapi.SpAudioFormat");
            Dispatch spAudioFormat = ax.getObject();

            //设置音频流格式
            Dispatch.put(spAudioFormat, "Type", new Variant(22));
            //设置文件输出流格式
            Dispatch.putRef(spFileStream, "Format", spAudioFormat);

            String path = Constants.voicesPath + File.separator + date;
            File file = new File(path);
            if(!file.exists()){
                file.mkdirs();
            }
            String voicePath = file.getAbsolutePath() + File.separator + fileName;
            Dispatch.call(spFileStream, "Open", new Variant(voicePath), new Variant(3), new Variant(true));
            //设置声音对象的音频输出流为输出文件对象
            Dispatch.putRef(spVoice, "AudioOutputStream", spFileStream);
            //设置音量 0到100
            Dispatch.put(spVoice, "Volume", new Variant(100));
            //设置朗读速度
            Dispatch.put(spVoice, "Rate", new Variant(-2));
            //开始朗读
            Dispatch.call(spVoice, "Speak", new Variant(content));

            //关闭输出文件
            Dispatch.call(spFileStream, "Close");
            Dispatch.putRef(spVoice, "AudioOutputStream", null);

            spAudioFormat.safeRelease();
            spFileStream.safeRelease();
            spVoice.safeRelease();
            ax.safeRelease();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
