package com.bben.bedcard.service.impl;

import com.bben.bedcard.mapper.bedcard.TVideoMapper;
import com.bben.bedcard.model.bedcard.TVideo;
import com.bben.bedcard.model.bedcard.TVideoExample;
import com.bben.bedcard.service.TVideoService;
import com.bben.bedcard.vo.TVideoVo;
import com.bben.common.PageInfo;
import com.bben.common.constants.Status;
import com.bben.common.util.A;
import com.bben.common.util.U;
import com.github.pagehelper.PageHelper;
import org.bytedeco.javacpp.opencv_core;
import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Frame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

@Service(value = "TVideoService")
public class TVideoServiceImpl implements TVideoService {

    @Autowired
    private TVideoMapper tVideoMapper;

    @Override
    public List<TVideoVo> findAll() {
        List<TVideo> tVideoList = tVideoMapper.selectByExample(null);
        if (A.isEmpty(tVideoList)){
            return null;
        }
        return TVideoVo.assemblyDataList(tVideoList);
    }

    @Override
    public TVideoVo selectByPrimaryKey(Integer videoId) {
        if (U.isBlank(videoId)){
            return null;
        }
        TVideo tVideo = tVideoMapper.selectByPrimaryKey(videoId);
        if (U.isBlank(tVideo)){
            return null;
        }
        return TVideoVo.assemblyData(tVideo);
    }

    @Override
    public TVideo insertSelective(TVideo record) {
        if (U.isBlank(record)){
            return null;
        }
        int count = tVideoMapper.insertSelective(record);
        if (0 == count){
            return null;
        }
        return record;
    }

    @Override
    public TVideo updateByPrimarykey(TVideo record) {
        if (U.isBlank(record)){
            return null;
        }
        int count = tVideoMapper.updateByPrimaryKeySelective(record);
        if (0 == count){
            return null;
        }
        return record;
    }

    @Override
    public int deleteByPrimarykey(Integer videoId) {
        if (U.isBlank(videoId)){
            return 0;
        }
        return tVideoMapper.deleteByPrimaryKey(videoId);
    }

    @Override
    public PageInfo<TVideoVo> selectByCondition(TVideo record, int pageNum, int pageSize) {
        TVideoExample tVideoExample = new TVideoExample();
        TVideoExample.Criteria criteria = tVideoExample.createCriteria();
        if (U.isNotBlank(record.getVideoType())){
            criteria.andVideoTypeEqualTo(record.getVideoType());
        }
        if (U.isNotBlank(record.getDescription())){
            criteria.andDescriptionLike(record.getDescription());
        }
        if (U.isNotBlank(record.getStatus())){
            criteria.andStatusEqualTo((byte) Status.EFFECTIVE.getStatus().intValue());
        }
        List<TVideo> tVideoList = tVideoMapper.selectByExample(tVideoExample);
        if (A.isEmpty(tVideoList)){
            return null;
        }
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<TVideoVo> tVideoVoPageInfo = new PageInfo<>(TVideoVo.assemblyDataList(tVideoList));
        return tVideoVoPageInfo;
    }

    public void showURL(){
        File f = new File(this.getClass().getResource("/").getPath());
        System.out.println(f);
    }

    /**
     * 获取指定视频的帧并保存为图片至指定目录
     * @param videofile  源视频文件路径
     * @param framefile  截取帧的图片存放路径
     * @throws Exception
     */
    public static void fetchFrame(String videofile, String framefile)
            throws Exception {
        long start = System.currentTimeMillis();
        /*File fff = new File(this.getClass().getResource("/").getPath());
        System.out.println(fff);*/
        File targetFile = new File(framefile);
        FFmpegFrameGrabber ff = new FFmpegFrameGrabber(videofile);
        ff.start();
        int lenght = ff.getLengthInFrames();
        int i = 0;
        Frame f = null;
        while (i < lenght) {
            // 过滤前5帧，避免出现全黑的图片，依自己情况而定
            f = ff.grabFrame();
            if ((i > 5) && (f.image != null)) {
                break;
            }
            i++;
        }
        opencv_core.IplImage img = f.image;
        int owidth = img.width();
        int oheight = img.height();
        // 对截取的帧进行等比例缩放
        int width = 800;
        int height = (int) (((double) width / owidth) * oheight);
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
        bi.getGraphics().drawImage(f.image.getBufferedImage().getScaledInstance(width, height, Image.SCALE_SMOOTH),
                0, 0, null);
        ImageIO.write(bi, "jpg", targetFile);
        //ff.flush();
        ff.stop();
        System.out.println(System.currentTimeMillis() - start);
    }

    public static void main(String[] args) {
        try {
            TVideoServiceImpl tVideoService = new TVideoServiceImpl();
            tVideoService.showURL();
            fetchFrame("http://172.30.1.251/video3.mp4", "D:/img/img3.jpg");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
