package com.bben.bedcard.mapper.bedcard;

import com.bben.bedcard.model.bedcard.TDrugsDose;
import com.bben.bedcard.model.bedcard.TDrugsDoseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TDrugsDoseMapper {
    long countByExample(TDrugsDoseExample example);

    int deleteByExample(TDrugsDoseExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TDrugsDose record);

    int insertSelective(TDrugsDose record);

    List<TDrugsDose> selectByExample(TDrugsDoseExample example);

    TDrugsDose selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TDrugsDose record, @Param("example") TDrugsDoseExample example);

    int updateByExample(@Param("record") TDrugsDose record, @Param("example") TDrugsDoseExample example);

    int updateByPrimaryKeySelective(TDrugsDose record);

    int updateByPrimaryKey(TDrugsDose record);
}