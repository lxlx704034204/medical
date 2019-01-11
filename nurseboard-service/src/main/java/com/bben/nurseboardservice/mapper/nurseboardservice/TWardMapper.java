package com.bben.nurseboardservice.mapper.nurseboardservice;

import com.bben.nurseboardservice.model.nurseboardservice.TWard;
import com.bben.nurseboardservice.model.nurseboardservice.TWardExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TWardMapper {
    long countByExample(TWardExample example);

    int deleteByExample(TWardExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TWard record);

    int insertSelective(TWard record);

    List<TWard> selectByExample(TWardExample example);

    TWard selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TWard record, @Param("example") TWardExample example);

    int updateByExample(@Param("record") TWard record, @Param("example") TWardExample example);

    int updateByPrimaryKeySelective(TWard record);

    int updateByPrimaryKey(TWard record);
}