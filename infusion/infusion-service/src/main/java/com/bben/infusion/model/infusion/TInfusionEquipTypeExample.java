package com.bben.infusion.model.infusion;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TInfusionEquipTypeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TInfusionEquipTypeExample() {
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

        public Criteria andInfusionEquipTypeIsNull() {
            addCriterion("infusion_equip_type is null");
            return (Criteria) this;
        }

        public Criteria andInfusionEquipTypeIsNotNull() {
            addCriterion("infusion_equip_type is not null");
            return (Criteria) this;
        }

        public Criteria andInfusionEquipTypeEqualTo(String value) {
            addCriterion("infusion_equip_type =", value, "infusionEquipType");
            return (Criteria) this;
        }

        public Criteria andInfusionEquipTypeNotEqualTo(String value) {
            addCriterion("infusion_equip_type <>", value, "infusionEquipType");
            return (Criteria) this;
        }

        public Criteria andInfusionEquipTypeGreaterThan(String value) {
            addCriterion("infusion_equip_type >", value, "infusionEquipType");
            return (Criteria) this;
        }

        public Criteria andInfusionEquipTypeGreaterThanOrEqualTo(String value) {
            addCriterion("infusion_equip_type >=", value, "infusionEquipType");
            return (Criteria) this;
        }

        public Criteria andInfusionEquipTypeLessThan(String value) {
            addCriterion("infusion_equip_type <", value, "infusionEquipType");
            return (Criteria) this;
        }

        public Criteria andInfusionEquipTypeLessThanOrEqualTo(String value) {
            addCriterion("infusion_equip_type <=", value, "infusionEquipType");
            return (Criteria) this;
        }

        public Criteria andInfusionEquipTypeLike(String value) {
            addCriterion("infusion_equip_type like", value, "infusionEquipType");
            return (Criteria) this;
        }

        public Criteria andInfusionEquipTypeNotLike(String value) {
            addCriterion("infusion_equip_type not like", value, "infusionEquipType");
            return (Criteria) this;
        }

        public Criteria andInfusionEquipTypeIn(List<String> values) {
            addCriterion("infusion_equip_type in", values, "infusionEquipType");
            return (Criteria) this;
        }

        public Criteria andInfusionEquipTypeNotIn(List<String> values) {
            addCriterion("infusion_equip_type not in", values, "infusionEquipType");
            return (Criteria) this;
        }

        public Criteria andInfusionEquipTypeBetween(String value1, String value2) {
            addCriterion("infusion_equip_type between", value1, value2, "infusionEquipType");
            return (Criteria) this;
        }

        public Criteria andInfusionEquipTypeNotBetween(String value1, String value2) {
            addCriterion("infusion_equip_type not between", value1, value2, "infusionEquipType");
            return (Criteria) this;
        }

        public Criteria andVoltageWarnIsNull() {
            addCriterion("voltage_warn is null");
            return (Criteria) this;
        }

        public Criteria andVoltageWarnIsNotNull() {
            addCriterion("voltage_warn is not null");
            return (Criteria) this;
        }

        public Criteria andVoltageWarnEqualTo(Integer value) {
            addCriterion("voltage_warn =", value, "voltageWarn");
            return (Criteria) this;
        }

        public Criteria andVoltageWarnNotEqualTo(Integer value) {
            addCriterion("voltage_warn <>", value, "voltageWarn");
            return (Criteria) this;
        }

        public Criteria andVoltageWarnGreaterThan(Integer value) {
            addCriterion("voltage_warn >", value, "voltageWarn");
            return (Criteria) this;
        }

        public Criteria andVoltageWarnGreaterThanOrEqualTo(Integer value) {
            addCriterion("voltage_warn >=", value, "voltageWarn");
            return (Criteria) this;
        }

        public Criteria andVoltageWarnLessThan(Integer value) {
            addCriterion("voltage_warn <", value, "voltageWarn");
            return (Criteria) this;
        }

        public Criteria andVoltageWarnLessThanOrEqualTo(Integer value) {
            addCriterion("voltage_warn <=", value, "voltageWarn");
            return (Criteria) this;
        }

        public Criteria andVoltageWarnIn(List<Integer> values) {
            addCriterion("voltage_warn in", values, "voltageWarn");
            return (Criteria) this;
        }

        public Criteria andVoltageWarnNotIn(List<Integer> values) {
            addCriterion("voltage_warn not in", values, "voltageWarn");
            return (Criteria) this;
        }

        public Criteria andVoltageWarnBetween(Integer value1, Integer value2) {
            addCriterion("voltage_warn between", value1, value2, "voltageWarn");
            return (Criteria) this;
        }

        public Criteria andVoltageWarnNotBetween(Integer value1, Integer value2) {
            addCriterion("voltage_warn not between", value1, value2, "voltageWarn");
            return (Criteria) this;
        }

        public Criteria andLowAlarmIsNull() {
            addCriterion("low_alarm is null");
            return (Criteria) this;
        }

        public Criteria andLowAlarmIsNotNull() {
            addCriterion("low_alarm is not null");
            return (Criteria) this;
        }

        public Criteria andLowAlarmEqualTo(Integer value) {
            addCriterion("low_alarm =", value, "lowAlarm");
            return (Criteria) this;
        }

        public Criteria andLowAlarmNotEqualTo(Integer value) {
            addCriterion("low_alarm <>", value, "lowAlarm");
            return (Criteria) this;
        }

        public Criteria andLowAlarmGreaterThan(Integer value) {
            addCriterion("low_alarm >", value, "lowAlarm");
            return (Criteria) this;
        }

        public Criteria andLowAlarmGreaterThanOrEqualTo(Integer value) {
            addCriterion("low_alarm >=", value, "lowAlarm");
            return (Criteria) this;
        }

        public Criteria andLowAlarmLessThan(Integer value) {
            addCriterion("low_alarm <", value, "lowAlarm");
            return (Criteria) this;
        }

        public Criteria andLowAlarmLessThanOrEqualTo(Integer value) {
            addCriterion("low_alarm <=", value, "lowAlarm");
            return (Criteria) this;
        }

        public Criteria andLowAlarmIn(List<Integer> values) {
            addCriterion("low_alarm in", values, "lowAlarm");
            return (Criteria) this;
        }

        public Criteria andLowAlarmNotIn(List<Integer> values) {
            addCriterion("low_alarm not in", values, "lowAlarm");
            return (Criteria) this;
        }

        public Criteria andLowAlarmBetween(Integer value1, Integer value2) {
            addCriterion("low_alarm between", value1, value2, "lowAlarm");
            return (Criteria) this;
        }

        public Criteria andLowAlarmNotBetween(Integer value1, Integer value2) {
            addCriterion("low_alarm not between", value1, value2, "lowAlarm");
            return (Criteria) this;
        }

        public Criteria andDripWarnIsNull() {
            addCriterion("drip_warn is null");
            return (Criteria) this;
        }

        public Criteria andDripWarnIsNotNull() {
            addCriterion("drip_warn is not null");
            return (Criteria) this;
        }

        public Criteria andDripWarnEqualTo(Integer value) {
            addCriterion("drip_warn =", value, "dripWarn");
            return (Criteria) this;
        }

        public Criteria andDripWarnNotEqualTo(Integer value) {
            addCriterion("drip_warn <>", value, "dripWarn");
            return (Criteria) this;
        }

        public Criteria andDripWarnGreaterThan(Integer value) {
            addCriterion("drip_warn >", value, "dripWarn");
            return (Criteria) this;
        }

        public Criteria andDripWarnGreaterThanOrEqualTo(Integer value) {
            addCriterion("drip_warn >=", value, "dripWarn");
            return (Criteria) this;
        }

        public Criteria andDripWarnLessThan(Integer value) {
            addCriterion("drip_warn <", value, "dripWarn");
            return (Criteria) this;
        }

        public Criteria andDripWarnLessThanOrEqualTo(Integer value) {
            addCriterion("drip_warn <=", value, "dripWarn");
            return (Criteria) this;
        }

        public Criteria andDripWarnIn(List<Integer> values) {
            addCriterion("drip_warn in", values, "dripWarn");
            return (Criteria) this;
        }

        public Criteria andDripWarnNotIn(List<Integer> values) {
            addCriterion("drip_warn not in", values, "dripWarn");
            return (Criteria) this;
        }

        public Criteria andDripWarnBetween(Integer value1, Integer value2) {
            addCriterion("drip_warn between", value1, value2, "dripWarn");
            return (Criteria) this;
        }

        public Criteria andDripWarnNotBetween(Integer value1, Integer value2) {
            addCriterion("drip_warn not between", value1, value2, "dripWarn");
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