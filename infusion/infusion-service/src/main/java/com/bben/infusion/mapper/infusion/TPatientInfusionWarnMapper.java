package com.bben.infusion.mapper.infusion;

import com.bben.infusion.model.infusion.TPatientInfusionWarn;
import com.bben.infusion.model.infusion.TPatientInfusionWarnExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TPatientInfusionWarnMapper {
    long countByExample(TPatientInfusionWarnExample example);

    int deleteByExample(TPatientInfusionWarnExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TPatientInfusionWarn record);

    int insertSelective(TPatientInfusionWarn record);

    List<TPatientInfusionWarn> selectByExample(TPatientInfusionWarnExample example);

    TPatientInfusionWarn selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TPatientInfusionWarn record, @Param("example") TPatientInfusionWarnExample example);

    int updateByExample(@Param("record") TPatientInfusionWarn record, @Param("example") TPatientInfusionWarnExample example);

    int updateByPrimaryKeySelective(TPatientInfusionWarn record);

    int updateByPrimaryKey(TPatientInfusionWarn record);
}