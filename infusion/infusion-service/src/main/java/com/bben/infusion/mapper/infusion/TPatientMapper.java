package com.bben.infusion.mapper.infusion;

import com.bben.infusion.model.infusion.TPatient;
import com.bben.infusion.model.infusion.TPatientExample;
import com.bben.infusion.model.param_model.TPatientInfusionEquipParam;
import com.bben.infusion.model.param_model.TPatientParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TPatientMapper {
    long countByExample(TPatientExample example);

    int deleteByExample(TPatientExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TPatient record);

    int insertSelective(TPatient record);

    List<TPatient> selectByExample(TPatientExample example);

    TPatient selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TPatient record, @Param("example") TPatientExample example);

    int updateByExample(@Param("record") TPatient record, @Param("example") TPatientExample example);

    int updateByPrimaryKeySelective(TPatient record);

    int updateByPrimaryKey(TPatient record);

    List<TPatientParam> selectPatientEquipByExample(TPatientExample example);

    TPatientInfusionEquipParam selectPatientInfusionEquipByCon(Integer pid);
}