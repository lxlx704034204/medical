package com.bben.infusion.model.infusion;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TInfusionParamExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TInfusionParamExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andDripTypeIsNull() {
            addCriterion("drip_type is null");
            return (Criteria) this;
        }

        public Criteria andDripTypeIsNotNull() {
            addCriterion("drip_type is not null");
            return (Criteria) this;
        }

        public Criteria andDripTypeEqualTo(String value) {
            addCriterion("drip_type =", value, "dripType");
            return (Criteria) this;
        }

        public Criteria andDripTypeNotEqualTo(String value) {
            addCriterion("drip_type <>", value, "dripType");
            return (Criteria) this;
        }

        public Criteria andDripTypeGreaterThan(String value) {
            addCriterion("drip_type >", value, "dripType");
            return (Criteria) this;
        }

        public Criteria andDripTypeGreaterThanOrEqualTo(String value) {
            addCriterion("drip_type >=", value, "dripType");
            return (Criteria) this;
        }

        public Criteria andDripTypeLessThan(String value) {
            addCriterion("drip_type <", value, "dripType");
            return (Criteria) this;
        }

        public Criteria andDripTypeLessThanOrEqualTo(String value) {
            addCriterion("drip_type <=", value, "dripType");
            return (Criteria) this;
        }

        public Criteria andDripTypeLike(String value) {
            addCriterion("drip_type like", value, "dripType");
            return (Criteria) this;
        }

        public Criteria andDripTypeNotLike(String value) {
            addCriterion("drip_type not like", value, "dripType");
            return (Criteria) this;
        }

        public Criteria andDripTypeIn(List<String> values) {
            addCriterion("drip_type in", values, "dripType");
            return (Criteria) this;
        }

        public Criteria andDripTypeNotIn(List<String> values) {
            addCriterion("drip_type not in", values, "dripType");
            return (Criteria) this;
        }

        public Criteria andDripTypeBetween(String value1, String value2) {
            addCriterion("drip_type between", value1, value2, "dripType");
            return (Criteria) this;
        }

        public Criteria andDripTypeNotBetween(String value1, String value2) {
            addCriterion("drip_type not between", value1, value2, "dripType");
            return (Criteria) this;
        }

        public Criteria andOldMaxIsNull() {
            addCriterion("old_max is null");
            return (Criteria) this;
        }

        public Criteria andOldMaxIsNotNull() {
            addCriterion("old_max is not null");
            return (Criteria) this;
        }

        public Criteria andOldMaxEqualTo(Integer value) {
            addCriterion("old_max =", value, "oldMax");
            return (Criteria) this;
        }

        public Criteria andOldMaxNotEqualTo(Integer value) {
            addCriterion("old_max <>", value, "oldMax");
            return (Criteria) this;
        }

        public Criteria andOldMaxGreaterThan(Integer value) {
            addCriterion("old_max >", value, "oldMax");
            return (Criteria) this;
        }

        public Criteria andOldMaxGreaterThanOrEqualTo(Integer value) {
            addCriterion("old_max >=", value, "oldMax");
            return (Criteria) this;
        }

        public Criteria andOldMaxLessThan(Integer value) {
            addCriterion("old_max <", value, "oldMax");
            return (Criteria) this;
        }

        public Criteria andOldMaxLessThanOrEqualTo(Integer value) {
            addCriterion("old_max <=", value, "oldMax");
            return (Criteria) this;
        }

        public Criteria andOldMaxIn(List<Integer> values) {
            addCriterion("old_max in", values, "oldMax");
            return (Criteria) this;
        }

        public Criteria andOldMaxNotIn(List<Integer> values) {
            addCriterion("old_max not in", values, "oldMax");
            return (Criteria) this;
        }

        public Criteria andOldMaxBetween(Integer value1, Integer value2) {
            addCriterion("old_max between", value1, value2, "oldMax");
            return (Criteria) this;
        }

        public Criteria andOldMaxNotBetween(Integer value1, Integer value2) {
            addCriterion("old_max not between", value1, value2, "oldMax");
            return (Criteria) this;
        }

        public Criteria andOldMinIsNull() {
            addCriterion("old_min is null");
            return (Criteria) this;
        }

        public Criteria andOldMinIsNotNull() {
            addCriterion("old_min is not null");
            return (Criteria) this;
        }

        public Criteria andOldMinEqualTo(Integer value) {
            addCriterion("old_min =", value, "oldMin");
            return (Criteria) this;
        }

        public Criteria andOldMinNotEqualTo(Integer value) {
            addCriterion("old_min <>", value, "oldMin");
            return (Criteria) this;
        }

        public Criteria andOldMinGreaterThan(Integer value) {
            addCriterion("old_min >", value, "oldMin");
            return (Criteria) this;
        }

        public Criteria andOldMinGreaterThanOrEqualTo(Integer value) {
            addCriterion("old_min >=", value, "oldMin");
            return (Criteria) this;
        }

        public Criteria andOldMinLessThan(Integer value) {
            addCriterion("old_min <", value, "oldMin");
            return (Criteria) this;
        }

        public Criteria andOldMinLessThanOrEqualTo(Integer value) {
            addCriterion("old_min <=", value, "oldMin");
            return (Criteria) this;
        }

        public Criteria andOldMinIn(List<Integer> values) {
            addCriterion("old_min in", values, "oldMin");
            return (Criteria) this;
        }

        public Criteria andOldMinNotIn(List<Integer> values) {
            addCriterion("old_min not in", values, "oldMin");
            return (Criteria) this;
        }

        public Criteria andOldMinBetween(Integer value1, Integer value2) {
            addCriterion("old_min between", value1, value2, "oldMin");
            return (Criteria) this;
        }

        public Criteria andOldMinNotBetween(Integer value1, Integer value2) {
            addCriterion("old_min not between", value1, value2, "oldMin");
            return (Criteria) this;
        }

        public Criteria andMaxDripSpeedIsNull() {
            addCriterion("max_drip_speed is null");
            return (Criteria) this;
        }

        public Criteria andMaxDripSpeedIsNotNull() {
            addCriterion("max_drip_speed is not null");
            return (Criteria) this;
        }

        public Criteria andMaxDripSpeedEqualTo(Integer value) {
            addCriterion("max_drip_speed =", value, "maxDripSpeed");
            return (Criteria) this;
        }

        public Criteria andMaxDripSpeedNotEqualTo(Integer value) {
            addCriterion("max_drip_speed <>", value, "maxDripSpeed");
            return (Criteria) this;
        }

        public Criteria andMaxDripSpeedGreaterThan(Integer value) {
            addCriterion("max_drip_speed >", value, "maxDripSpeed");
            return (Criteria) this;
        }

        public Criteria andMaxDripSpeedGreaterThanOrEqualTo(Integer value) {
            addCriterion("max_drip_speed >=", value, "maxDripSpeed");
            return (Criteria) this;
        }

        public Criteria andMaxDripSpeedLessThan(Integer value) {
            addCriterion("max_drip_speed <", value, "maxDripSpeed");
            return (Criteria) this;
        }

        public Criteria andMaxDripSpeedLessThanOrEqualTo(Integer value) {
            addCriterion("max_drip_speed <=", value, "maxDripSpeed");
            return (Criteria) this;
        }

        public Criteria andMaxDripSpeedIn(List<Integer> values) {
            addCriterion("max_drip_speed in", values, "maxDripSpeed");
            return (Criteria) this;
        }

        public Criteria andMaxDripSpeedNotIn(List<Integer> values) {
            addCriterion("max_drip_speed not in", values, "maxDripSpeed");
            return (Criteria) this;
        }

        public Criteria andMaxDripSpeedBetween(Integer value1, Integer value2) {
            addCriterion("max_drip_speed between", value1, value2, "maxDripSpeed");
            return (Criteria) this;
        }

        public Criteria andMaxDripSpeedNotBetween(Integer value1, Integer value2) {
            addCriterion("max_drip_speed not between", value1, value2, "maxDripSpeed");
            return (Criteria) this;
        }

        public Criteria andMinDripSpeedIsNull() {
            addCriterion("min_drip_speed is null");
            return (Criteria) this;
        }

        public Criteria andMinDripSpeedIsNotNull() {
            addCriterion("min_drip_speed is not null");
            return (Criteria) this;
        }

        public Criteria andMinDripSpeedEqualTo(Integer value) {
            addCriterion("min_drip_speed =", value, "minDripSpeed");
            return (Criteria) this;
        }

        public Criteria andMinDripSpeedNotEqualTo(Integer value) {
            addCriterion("min_drip_speed <>", value, "minDripSpeed");
            return (Criteria) this;
        }

        public Criteria andMinDripSpeedGreaterThan(Integer value) {
            addCriterion("min_drip_speed >", value, "minDripSpeed");
            return (Criteria) this;
        }

        public Criteria andMinDripSpeedGreaterThanOrEqualTo(Integer value) {
            addCriterion("min_drip_speed >=", value, "minDripSpeed");
            return (Criteria) this;
        }

        public Criteria andMinDripSpeedLessThan(Integer value) {
            addCriterion("min_drip_speed <", value, "minDripSpeed");
            return (Criteria) this;
        }

        public Criteria andMinDripSpeedLessThanOrEqualTo(Integer value) {
            addCriterion("min_drip_speed <=", value, "minDripSpeed");
            return (Criteria) this;
        }

        public Criteria andMinDripSpeedIn(List<Integer> values) {
            addCriterion("min_drip_speed in", values, "minDripSpeed");
            return (Criteria) this;
        }

        public Criteria andMinDripSpeedNotIn(List<Integer> values) {
            addCriterion("min_drip_speed not in", values, "minDripSpeed");
            return (Criteria) this;
        }

        public Criteria andMinDripSpeedBetween(Integer value1, Integer value2) {
            addCriterion("min_drip_speed between", value1, value2, "minDripSpeed");
            return (Criteria) this;
        }

        public Criteria andMinDripSpeedNotBetween(Integer value1, Integer value2) {
            addCriterion("min_drip_speed not between", value1, value2, "minDripSpeed");
            return (Criteria) this;
        }

        public Criteria andMedicineNameIsNull() {
            addCriterion("medicine_name is null");
            return (Criteria) this;
        }

        public Criteria andMedicineNameIsNotNull() {
            addCriterion("medicine_name is not null");
            return (Criteria) this;
        }

        public Criteria andMedicineNameEqualTo(String value) {
            addCriterion("medicine_name =", value, "medicineName");
            return (Criteria) this;
        }

        public Criteria andMedicineNameNotEqualTo(String value) {
            addCriterion("medicine_name <>", value, "medicineName");
            return (Criteria) this;
        }

        public Criteria andMedicineNameGreaterThan(String value) {
            addCriterion("medicine_name >", value, "medicineName");
            return (Criteria) this;
        }

        public Criteria andMedicineNameGreaterThanOrEqualTo(String value) {
            addCriterion("medicine_name >=", value, "medicineName");
            return (Criteria) this;
        }

        public Criteria andMedicineNameLessThan(String value) {
            addCriterion("medicine_name <", value, "medicineName");
            return (Criteria) this;
        }

        public Criteria andMedicineNameLessThanOrEqualTo(String value) {
            addCriterion("medicine_name <=", value, "medicineName");
            return (Criteria) this;
        }

        public Criteria andMedicineNameLike(String value) {
            addCriterion("medicine_name like", value, "medicineName");
            return (Criteria) this;
        }

        public Criteria andMedicineNameNotLike(String value) {
            addCriterion("medicine_name not like", value, "medicineName");
            return (Criteria) this;
        }

        public Criteria andMedicineNameIn(List<String> values) {
            addCriterion("medicine_name in", values, "medicineName");
            return (Criteria) this;
        }

        public Criteria andMedicineNameNotIn(List<String> values) {
            addCriterion("medicine_name not in", values, "medicineName");
            return (Criteria) this;
        }

        public Criteria andMedicineNameBetween(String value1, String value2) {
            addCriterion("medicine_name between", value1, value2, "medicineName");
            return (Criteria) this;
        }

        public Criteria andMedicineNameNotBetween(String value1, String value2) {
            addCriterion("medicine_name not between", value1, value2, "medicineName");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Byte value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Byte value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Byte value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Byte value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Byte value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Byte> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Byte> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Byte value1, Byte value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNull() {
            addCriterion("create_by is null");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNotNull() {
            addCriterion("create_by is not null");
            return (Criteria) this;
        }

        public Criteria andCreateByEqualTo(String value) {
            addCriterion("create_by =", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotEqualTo(String value) {
            addCriterion("create_by <>", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThan(String value) {
            addCriterion("create_by >", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThanOrEqualTo(String value) {
            addCriterion("create_by >=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThan(String value) {
            addCriterion("create_by <", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThanOrEqualTo(String value) {
            addCriterion("create_by <=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLike(String value) {
            addCriterion("create_by like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotLike(String value) {
            addCriterion("create_by not like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByIn(List<String> values) {
            addCriterion("create_by in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotIn(List<String> values) {
            addCriterion("create_by not in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByBetween(String value1, String value2) {
            addCriterion("create_by between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotBetween(String value1, String value2) {
            addCriterion("create_by not between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNull() {
            addCriterion("update_by is null");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNotNull() {
            addCriterion("update_by is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateByEqualTo(String value) {
            addCriterion("update_by =", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotEqualTo(String value) {
            addCriterion("update_by <>", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThan(String value) {
            addCriterion("update_by >", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThanOrEqualTo(String value) {
            addCriterion("update_by >=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThan(String value) {
            addCriterion("update_by <", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThanOrEqualTo(String value) {
            addCriterion("update_by <=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLike(String value) {
            addCriterion("update_by like", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotLike(String value) {
            addCriterion("update_by not like", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByIn(List<String> values) {
            addCriterion("update_by in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotIn(List<String> values) {
            addCriterion("update_by not in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByBetween(String value1, String value2) {
            addCriterion("update_by between", value1, value2, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotBetween(String value1, String value2) {
            addCriterion("update_by not between", value1, value2, "updateBy");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}