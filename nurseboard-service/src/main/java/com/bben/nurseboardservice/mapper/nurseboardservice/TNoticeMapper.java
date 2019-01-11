package com.bben.nurseboardservice.mapper.nurseboardservice;

import com.bben.nurseboardservice.model.nurseboardservice.TNotice;
import com.bben.nurseboardservice.model.nurseboardservice.TNoticeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TNoticeMapper {
    long countByExample(TNoticeExample example);

    int deleteByExample(TNoticeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TNotice record);

    int insertSelective(TNotice record);

    List<TNotice> selectByExample(TNoticeExample example);

    TNotice selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TNotice record, @Param("example") TNoticeExample example);

    int updateByExample(@Param("record") TNotice record, @Param("example") TNoticeExample example);

    int updateByPrimaryKeySelective(TNotice record);

    int updateByPrimaryKey(TNotice record);
}