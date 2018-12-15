package com.bben.medical.service.impl;

import com.bben.common.PageInfo;
import com.bben.common.util.U;
import com.bben.medical.mapper.sqlMedical.GradeMapper;
import com.bben.medical.model.sqlMedical.Grade;
import com.bben.medical.model.sqlMedical.GradeExample;
import com.bben.medical.service.GradeService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value = "GradeService")
@CacheConfig(cacheNames = "Grade")
public class GradeServiceImpl implements GradeService {

    @Autowired
    private GradeMapper gradeMapper;//这里会报错，但是并不会影响

    @Override
    public Grade selectByPrimaryKey(Integer id) {
        return gradeMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public int deleteByPrimaryKey(Integer id) {
        return gradeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Grade insertSelective(Grade record) {
        int count = gradeMapper.insertSelective(record);
        if (count == 0) {
            return null;
        }

        return record;
    }

    @Override
    public Grade updateByPrimaryKey(Grade record) {
          int count = gradeMapper.updateByPrimaryKeySelective(record);
        if (count == 0) {
            return null;
        }

        return record;
    }

    @Override
    public PageInfo<Grade> findByCondition(Grade record, int pageNum, int pageSize) {
        GradeExample gradeExample = new GradeExample();
        GradeExample.Criteria criteria = gradeExample.createCriteria();

        gradeExample.setOrderByClause(" id");
        if (U.isNotBlank(record.getGrade())) {
            criteria.andGradeEqualTo(record.getGrade());
        }

        if (U.isNotBlank(record.getGradecolor())) {
            criteria.andGradecolorEqualTo(record.getGradecolor());
        }

        PageHelper.startPage(pageNum, pageSize);
        List<Grade> listGrade = gradeMapper.selectByExample(gradeExample);
        PageInfo<Grade> pageInfoGrade = new PageInfo<>(listGrade);

        return pageInfoGrade;
    }
}
