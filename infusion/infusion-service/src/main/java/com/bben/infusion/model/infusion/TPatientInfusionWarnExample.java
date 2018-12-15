package com.bben.infusion.model.infusion;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TPatientInfusionWarnExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TPatientInfusionWarnExample() {
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

        public Criteria andPatientIdIsNull() {
            addCriterion("patient_id is null");
            return (Criteria) this;
        }

        public Criteria andPatientIdIsNotNull() {
            addCriterion("patient_id is not null");
            return (Criteria) this;
        }

        public Criteria andPatientIdEqualTo(Integer value) {
            addCriterion("patient_id =", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdNotEqualTo(Integer value) {
            addCriterion("patient_id <>", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdGreaterThan(Integer value) {
            addCriterion("patient_id >", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("patient_id >=", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdLessThan(Integer value) {
            addCriterion("patient_id <", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdLessThanOrEqualTo(Integer value) {
            addCriterion("patient_id <=", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdIn(List<Integer> values) {
            addCriterion("patient_id in", values, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdNotIn(List<Integer> values) {
            addCriterion("patient_id not in", values, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdBetween(Integer value1, Integer value2) {
            addCriterion("patient_id between", value1, value2, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdNotBetween(Integer value1, Integer value2) {
            addCriterion("patient_id not between", value1, value2, "patientId");
            return (Criteria) this;
        }

        public Criteria andEquipmentSnIsNull() {
            addCriterion("equipment_sn is null");
            return (Criteria) this;
        }

        public Criteria andEquipmentSnIsNotNull() {
            addCriterion("equipment_sn is not null");
            return (Criteria) this;
        }

        public Criteria andEquipmentSnEqualTo(String value) {
            addCriterion("equipment_sn =", value, "equipmentSn");
            return (Criteria) this;
        }

        public Criteria andEquipmentSnNotEqualTo(String value) {
            addCriterion("equipment_sn <>", value, "equipmentSn");
            return (Criteria) this;
        }

        public Criteria andEquipmentSnGreaterThan(String value) {
            addCriterion("equipment_sn >", value, "equipmentSn");
            return (Criteria) this;
        }

        public Criteria andEquipmentSnGreaterThanOrEqualTo(String value) {
            addCriterion("equipment_sn >=", value, "equipmentSn");
            return (Criteria) this;
        }

        public Criteria andEquipmentSnLessThan(String value) {
            addCriterion("equipment_sn <", value, "equipmentSn");
            return (Criteria) this;
        }

        public Criteria andEquipmentSnLessThanOrEqualTo(String value) {
            addCriterion("equipment_sn <=", value, "equipmentSn");
            return (Criteria) this;
        }

        public Criteria andEquipmentSnLike(String value) {
            addCriterion("equipment_sn like", value, "equipmentSn");
            return (Criteria) this;
        }

        public Criteria andEquipmentSnNotLike(String value) {
            addCriterion("equipment_sn not like", value, "equipmentSn");
            return (Criteria) this;
        }

        public Criteria andEquipmentSnIn(List<String> values) {
            addCriterion("equipment_sn in", values, "equipmentSn");
            return (Criteria) this;
        }

        public Criteria andEquipmentSnNotIn(List<String> values) {
            addCriterion("equipment_sn not in", values, "equipmentSn");
            return (Criteria) this;
        }

        public Criteria andEquipmentSnBetween(String value1, String value2) {
            addCriterion("equipment_sn between", value1, value2, "equipmentSn");
            return (Criteria) this;
        }

        public Criteria andEquipmentSnNotBetween(String value1, String value2) {
            addCriterion("equipment_sn not between", value1, value2, "equipmentSn");
            return (Criteria) this;
        }

        public Criteria andWarnTypeIsNull() {
            addCriterion("warn_type is null");
            return (Criteria) this;
        }

        public Criteria andWarnTypeIsNotNull() {
            addCriterion("warn_type is not null");
            return (Criteria) this;
        }

        public Criteria andWarnTypeEqualTo(String value) {
            addCriterion("warn_type =", value, "warnType");
            return (Criteria) this;
        }

        public Criteria andWarnTypeNotEqualTo(String value) {
            addCriterion("warn_type <>", value, "warnType");
            return (Criteria) this;
        }

        public Criteria andWarnTypeGreaterThan(String value) {
            addCriterion("warn_type >", value, "warnType");
            return (Criteria) this;
        }

        public Criteria andWarnTypeGreaterThanOrEqualTo(String value) {
            addCriterion("warn_type >=", value, "warnType");
            return (Criteria) this;
        }

        public Criteria andWarnTypeLessThan(String value) {
            addCriterion("warn_type <", value, "warnType");
            return (Criteria) this;
        }

        public Criteria andWarnTypeLessThanOrEqualTo(String value) {
            addCriterion("warn_type <=", value, "warnType");
            return (Criteria) this;
        }

        public Criteria andWarnTypeLike(String value) {
            addCriterion("warn_type like", value, "warnType");
            return (Criteria) this;
        }

        public Criteria andWarnTypeNotLike(String value) {
            addCriterion("warn_type not like", value, "warnType");
            return (Criteria) this;
        }

        public Criteria andWarnTypeIn(List<String> values) {
            addCriterion("warn_type in", values, "warnType");
            return (Criteria) this;
        }

        public Criteria andWarnTypeNotIn(List<String> values) {
            addCriterion("warn_type not in", values, "warnType");
            return (Criteria) this;
        }

        public Criteria andWarnTypeBetween(String value1, String value2) {
            addCriterion("warn_type between", value1, value2, "warnType");
            return (Criteria) this;
        }

        public Criteria andWarnTypeNotBetween(String value1, String value2) {
            addCriterion("warn_type not between", value1, value2, "warnType");
            return (Criteria) this;
        }

        public Criteria andDripSpeedIsNull() {
            addCriterion("drip_speed is null");
            return (Criteria) this;
        }

        public Criteria andDripSpeedIsNotNull() {
            addCriterion("drip_speed is not null");
            return (Criteria) this;
        }

        public Criteria andDripSpeedEqualTo(Integer value) {
            addCriterion("drip_speed =", value, "dripSpeed");
            return (Criteria) this;
        }

        public Criteria andDripSpeedNotEqualTo(Integer value) {
            addCriterion("drip_speed <>", value, "dripSpeed");
            return (Criteria) this;
        }

        public Criteria andDripSpeedGreaterThan(Integer value) {
            addCriterion("drip_speed >", value, "dripSpeed");
            return (Criteria) this;
        }

        public Criteria andDripSpeedGreaterThanOrEqualTo(Integer value) {
            addCriterion("drip_speed >=", value, "dripSpeed");
            return (Criteria) this;
        }

        public Criteria andDripSpeedLessThan(Integer value) {
            addCriterion("drip_speed <", value, "dripSpeed");
            return (Criteria) this;
        }

        public Criteria andDripSpeedLessThanOrEqualTo(Integer value) {
            addCriterion("drip_speed <=", value, "dripSpeed");
            return (Criteria) this;
        }

        public Criteria andDripSpeedIn(List<Integer> values) {
            addCriterion("drip_speed in", values, "dripSpeed");
            return (Criteria) this;
        }

        public Criteria andDripSpeedNotIn(List<Integer> values) {
            addCriterion("drip_speed not in", values, "dripSpeed");
            return (Criteria) this;
        }

        public Criteria andDripSpeedBetween(Integer value1, Integer value2) {
            addCriterion("drip_speed between", value1, value2, "dripSpeed");
            return (Criteria) this;
        }

        public Criteria andDripSpeedNotBetween(Integer value1, Integer value2) {
            addCriterion("drip_speed not between", value1, value2, "dripSpeed");
            return (Criteria) this;
        }

        public Criteria andWarnTimeIsNull() {
            addCriterion("warn_time is null");
            return (Criteria) this;
        }

        public Criteria andWarnTimeIsNotNull() {
            addCriterion("warn_time is not null");
            return (Criteria) this;
        }

        public Criteria andWarnTimeEqualTo(Date value) {
            addCriterion("warn_time =", value, "warnTime");
            return (Criteria) this;
        }

        public Criteria andWarnTimeNotEqualTo(Date value) {
            addCriterion("warn_time <>", value, "warnTime");
            return (Criteria) this;
        }

        public Criteria andWarnTimeGreaterThan(Date value) {
            addCriterion("warn_time >", value, "warnTime");
            return (Criteria) this;
        }

        public Criteria andWarnTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("warn_time >=", value, "warnTime");
            return (Criteria) this;
        }

        public Criteria andWarnTimeLessThan(Date value) {
            addCriterion("warn_time <", value, "warnTime");
            return (Criteria) this;
        }

        public Criteria andWarnTimeLessThanOrEqualTo(Date value) {
            addCriterion("warn_time <=", value, "warnTime");
            return (Criteria) this;
        }

        public Criteria andWarnTimeIn(List<Date> values) {
            addCriterion("warn_time in", values, "warnTime");
            return (Criteria) this;
        }

        public Criteria andWarnTimeNotIn(List<Date> values) {
            addCriterion("warn_time not in", values, "warnTime");
            return (Criteria) this;
        }

        public Criteria andWarnTimeBetween(Date value1, Date value2) {
            addCriterion("warn_time between", value1, value2, "warnTime");
            return (Criteria) this;
        }

        public Criteria andWarnTimeNotBetween(Date value1, Date value2) {
            addCriterion("warn_time not between", value1, value2, "warnTime");
            return (Criteria) this;
        }

        public Criteria andDealWithTimeIsNull() {
            addCriterion("deal_with_time is null");
            return (Criteria) this;
        }

        public Criteria andDealWithTimeIsNotNull() {
            addCriterion("deal_with_time is not null");
            return (Criteria) this;
        }

        public Criteria andDealWithTimeEqualTo(Date value) {
            addCriterion("deal_with_time =", value, "dealWithTime");
            return (Criteria) this;
        }

        public Criteria andDealWithTimeNotEqualTo(Date value) {
            addCriterion("deal_with_time <>", value, "dealWithTime");
            return (Criteria) this;
        }

        public Criteria andDealWithTimeGreaterThan(Date value) {
            addCriterion("deal_with_time >", value, "dealWithTime");
            return (Criteria) this;
        }

        public Criteria andDealWithTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("deal_with_time >=", value, "dealWithTime");
            return (Criteria) this;
        }

        public Criteria andDealWithTimeLessThan(Date value) {
            addCriterion("deal_with_time <", value, "dealWithTime");
            return (Criteria) this;
        }

        public Criteria andDealWithTimeLessThanOrEqualTo(Date value) {
            addCriterion("deal_with_time <=", value, "dealWithTime");
            return (Criteria) this;
        }

        public Criteria andDealWithTimeIn(List<Date> values) {
            addCriterion("deal_with_time in", values, "dealWithTime");
            return (Criteria) this;
        }

        public Criteria andDealWithTimeNotIn(List<Date> values) {
            addCriterion("deal_with_time not in", values, "dealWithTime");
            return (Criteria) this;
        }

        public Criteria andDealWithTimeBetween(Date value1, Date value2) {
            addCriterion("deal_with_time between", value1, value2, "dealWithTime");
            return (Criteria) this;
        }

        public Criteria andDealWithTimeNotBetween(Date value1, Date value2) {
            addCriterion("deal_with_time not between", value1, value2, "dealWithTime");
            return (Criteria) this;
        }

        public Criteria andDealWthByIsNull() {
            addCriterion("deal_wth_by is null");
            return (Criteria) this;
        }

        public Criteria andDealWthByIsNotNull() {
            addCriterion("deal_wth_by is not null");
            return (Criteria) this;
        }

        public Criteria andDealWthByEqualTo(String value) {
            addCriterion("deal_wth_by =", value, "dealWthBy");
            return (Criteria) this;
        }

        public Criteria andDealWthByNotEqualTo(String value) {
            addCriterion("deal_wth_by <>", value, "dealWthBy");
            return (Criteria) this;
        }

        public Criteria andDealWthByGreaterThan(String value) {
            addCriterion("deal_wth_by >", value, "dealWthBy");
            return (Criteria) this;
        }

        public Criteria andDealWthByGreaterThanOrEqualTo(String value) {
            addCriterion("deal_wth_by >=", value, "dealWthBy");
            return (Criteria) this;
        }

        public Criteria andDealWthByLessThan(String value) {
            addCriterion("deal_wth_by <", value, "dealWthBy");
            return (Criteria) this;
        }

        public Criteria andDealWthByLessThanOrEqualTo(String value) {
            addCriterion("deal_wth_by <=", value, "dealWthBy");
            return (Criteria) this;
        }

        public Criteria andDealWthByLike(String value) {
            addCriterion("deal_wth_by like", value, "dealWthBy");
            return (Criteria) this;
        }

        public Criteria andDealWthByNotLike(String value) {
            addCriterion("deal_wth_by not like", value, "dealWthBy");
            return (Criteria) this;
        }

        public Criteria andDealWthByIn(List<String> values) {
            addCriterion("deal_wth_by in", values, "dealWthBy");
            return (Criteria) this;
        }

        public Criteria andDealWthByNotIn(List<String> values) {
            addCriterion("deal_wth_by not in", values, "dealWthBy");
            return (Criteria) this;
        }

        public Criteria andDealWthByBetween(String value1, String value2) {
            addCriterion("deal_wth_by between", value1, value2, "dealWthBy");
            return (Criteria) this;
        }

        public Criteria andDealWthByNotBetween(String value1, String value2) {
            addCriterion("deal_wth_by not between", value1, value2, "dealWthBy");
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