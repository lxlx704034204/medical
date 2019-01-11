package com.bben.nurseboardservice.mapper.nurseboardservice;

import com.bben.nurseboardservice.model.nurseboardservice.TNurseLevel;
import com.bben.nurseboardservice.model.nurseboardservice.TNurseLevelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TNurseLevelMapper {
    long countByExample(TNurseLevelExample example);

    int deleteByExample(TNurseLevelExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TNurseLevel record);

    int insertSelective(TNurseLevel record);

    List<TNurseLevel> selectByExample(TNurseLevelExample example);

    TNurseLevel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TNurseLevel record, @Param("example") TNurseLevelExample example);

    int updateByExample(@Param("record") TNurseLevel record, @Param("example") TNurseLevelExample example);

    int updateByPrimaryKeySelective(TNurseLevel record);

    int updateByPrimaryKey(TNurseLevel record);
}