package com.bben.infusion.mapper.infusion;

import com.bben.infusion.model.infusion.TPatientInfusionInfo;
import com.bben.infusion.model.infusion.TPatientInfusionInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TPatientInfusionInfoMapper {
    long countByExample(TPatientInfusionInfoExample example);

    int deleteByExample(TPatientInfusionInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TPatientInfusionInfo record);

    int insertSelective(TPatientInfusionInfo record);

    List<TPatientInfusionInfo> selectByExample(TPatientInfusionInfoExample example);

    TPatientInfusionInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TPatientInfusionInfo record, @Param("example") TPatientInfusionInfoExample example);

    int updateByExample(@Param("record") TPatientInfusionInfo record, @Param("example") TPatientInfusionInfoExample example);

    int updateByPrimaryKeySelective(TPatientInfusionInfo record);

    int updateByPrimaryKey(TPatientInfusionInfo record);
}