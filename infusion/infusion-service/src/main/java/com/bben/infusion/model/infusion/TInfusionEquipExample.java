package com.bben.infusion.model.infusion;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TInfusionEquipExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TInfusionEquipExample() {
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

        public Criteria andBatteryLifeIdIsNull() {
            addCriterion("battery_life_id is null");
            return (Criteria) this;
        }

        public Criteria andBatteryLifeIdIsNotNull() {
            addCriterion("battery_life_id is not null");
            return (Criteria) this;
        }

        public Criteria andBatteryLifeIdEqualTo(Integer value) {
            addCriterion("battery_life_id =", value, "batteryLifeId");
            return (Criteria) this;
        }

        public Criteria andBatteryLifeIdNotEqualTo(Integer value) {
            addCriterion("battery_life_id <>", value, "batteryLifeId");
            return (Criteria) this;
        }

        public Criteria andBatteryLifeIdGreaterThan(Integer value) {
            addCriterion("battery_life_id >", value, "batteryLifeId");
            return (Criteria) this;
        }

        public Criteria andBatteryLifeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("battery_life_id >=", value, "batteryLifeId");
            return (Criteria) this;
        }

        public Criteria andBatteryLifeIdLessThan(Integer value) {
            addCriterion("battery_life_id <", value, "batteryLifeId");
            return (Criteria) this;
        }

        public Criteria andBatteryLifeIdLessThanOrEqualTo(Integer value) {
            addCriterion("battery_life_id <=", value, "batteryLifeId");
            return (Criteria) this;
        }

        public Criteria andBatteryLifeIdIn(List<Integer> values) {
            addCriterion("battery_life_id in", values, "batteryLifeId");
            return (Criteria) this;
        }

        public Criteria andBatteryLifeIdNotIn(List<Integer> values) {
            addCriterion("battery_life_id not in", values, "batteryLifeId");
            return (Criteria) this;
        }

        public Criteria andBatteryLifeIdBetween(Integer value1, Integer value2) {
            addCriterion("battery_life_id between", value1, value2, "batteryLifeId");
            return (Criteria) this;
        }

        public Criteria andBatteryLifeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("battery_life_id not between", value1, value2, "batteryLifeId");
            return (Criteria) this;
        }

        public Criteria andWorkStatusIsNull() {
            addCriterion("work_status is null");
            return (Criteria) this;
        }

        public Criteria andWorkStatusIsNotNull() {
            addCriterion("work_status is not null");
            return (Criteria) this;
        }

        public Criteria andWorkStatusEqualTo(Byte value) {
            addCriterion("work_status =", value, "workStatus");
            return (Criteria) this;
        }

        public Criteria andWorkStatusNotEqualTo(Byte value) {
            addCriterion("work_status <>", value, "workStatus");
            return (Criteria) this;
        }

        public Criteria andWorkStatusGreaterThan(Byte value) {
            addCriterion("work_status >", value, "workStatus");
            return (Criteria) this;
        }

        public Criteria andWorkStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("work_status >=", value, "workStatus");
            return (Criteria) this;
        }

        public Criteria andWorkStatusLessThan(Byte value) {
            addCriterion("work_status <", value, "workStatus");
            return (Criteria) this;
        }

        public Criteria andWorkStatusLessThanOrEqualTo(Byte value) {
            addCriterion("work_status <=", value, "workStatus");
            return (Criteria) this;
        }

        public Criteria andWorkStatusIn(List<Byte> values) {
            addCriterion("work_status in", values, "workStatus");
            return (Criteria) this;
        }

        public Criteria andWorkStatusNotIn(List<Byte> values) {
            addCriterion("work_status not in", values, "workStatus");
            return (Criteria) this;
        }

        public Criteria andWorkStatusBetween(Byte value1, Byte value2) {
            addCriterion("work_status between", value1, value2, "workStatus");
            return (Criteria) this;
        }

        public Criteria andWorkStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("work_status not between", value1, value2, "workStatus");
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