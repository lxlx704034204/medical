package com.bben.medical.mapper.medical;

import com.bben.common.PageInfo;
import com.bben.medical.model.medical.TPca;
import com.bben.medical.model.medical.TPcaExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TPcaMapper {
    long countByExample(TPcaExample example);

    int deleteByExample(TPcaExample example);

    int deleteByPrimaryKey(String pcaCode);

    int insert(TPca record);

    int insertSelective(TPca record);

    List<TPca> selectByExample(TPcaExample example);

    TPca selectByPrimaryKey(String pcaCode);

    int updateByExampleSelective(@Param("record") TPca record, @Param("example") TPcaExample example);

    int updateByExample(@Param("record") TPca record, @Param("example") TPcaExample example);

    int updateByPrimaryKeySelective(TPca record);

    int updateByPrimaryKey(TPca record);

    TPca getForCityAndArea(Map condition);
}