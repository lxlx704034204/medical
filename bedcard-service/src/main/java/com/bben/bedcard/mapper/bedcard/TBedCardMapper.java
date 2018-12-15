package com.bben.bedcard.mapper.bedcard;

import com.bben.bedcard.model.bedcard.TBedCard;
import com.bben.bedcard.model.bedcard.TBedCardExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TBedCardMapper {
    long countByExample(TBedCardExample example);

    int deleteByExample(TBedCardExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TBedCard record);

    int insertSelective(TBedCard record);

    List<TBedCard> selectByExample(TBedCardExample example);

    TBedCard selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TBedCard record, @Param("example") TBedCardExample example);

    int updateByExample(@Param("record") TBedCard record, @Param("example") TBedCardExample example);

    int updateByPrimaryKeySelective(TBedCard record);

    int updateByPrimaryKey(TBedCard record);
}