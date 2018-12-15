package com.bben.bedcard.service;

import com.bben.bedcard.model.bedcard.TVideo;
import com.bben.bedcard.vo.TVideoVo;
import com.bben.common.PageInfo;

import java.util.List;

public interface TVideoService {

    /**
     * 查询所有视频
     * @return
     */
    List<TVideoVo> findAll();

    /**
     * 根据主键查询视频
     * @param videoId
     * @return
     */
    TVideoVo selectByPrimaryKey(Integer videoId);

    /**
     * 新增视频信息
     * @param record
     * @return
     */
    TVideo insertSelective(TVideo record);

    /**
     * 更新视频信息
     * @param record
     * @return
     */
    TVideo updateByPrimarykey(TVideo record);

    /**
     * 删除视频信息
     * @param videoId
     * @return
     */
    int deleteByPrimarykey(Integer videoId);

    /**
     *  根据讲条件查询视频信息
     * @param record
     * @return
     */
    PageInfo<TVideoVo> selectByCondition(TVideo record, int pageNum, int pageSize);

}
