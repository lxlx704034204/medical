package com.bben.infusion.mapper.infusion;

import com.bben.infusion.model.infusion.TGatherData;
import com.bben.infusion.model.infusion.TGatherDataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TGatherDataMapper {
    long countByExample(TGatherDataExample example);

    int deleteByExample(TGatherDataExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TGatherData record);

    int insertSelective(TGatherData record);

    List<TGatherData> selectByExample(TGatherDataExample example);

    TGatherData selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TGatherData record, @Param("example") TGatherDataExample example);

    int updateByExample(@Param("record") TGatherData record, @Param("example") TGatherDataExample example);

    int updateByPrimaryKeySelective(TGatherData record);

    int updateByPrimaryKey(TGatherData record);
}