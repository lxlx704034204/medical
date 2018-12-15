package com.bben.infusion.mapper.infusion;

import com.bben.infusion.model.infusion.TPatientCall;
import com.bben.infusion.model.infusion.TPatientCallExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TPatientCallMapper {
    long countByExample(TPatientCallExample example);

    int deleteByExample(TPatientCallExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TPatientCall record);

    int insertSelective(TPatientCall record);

    List<TPatientCall> selectByExample(TPatientCallExample example);

    TPatientCall selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TPatientCall record, @Param("example") TPatientCallExample example);

    int updateByExample(@Param("record") TPatientCall record, @Param("example") TPatientCallExample example);

    int updateByPrimaryKeySelective(TPatientCall record);

    int updateByPrimaryKey(TPatientCall record);

    List<TPatientCall> selectByCondition(TPatientCall record);

}