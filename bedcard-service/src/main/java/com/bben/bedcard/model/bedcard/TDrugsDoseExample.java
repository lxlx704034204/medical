package com.bben.bedcard.model.bedcard;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TDrugsDoseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TDrugsDoseExample() {
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

        public Criteria andMedicationRecordIdIsNull() {
            addCriterion("medication_record_id is null");
            return (Criteria) this;
        }

        public Criteria andMedicationRecordIdIsNotNull() {
            addCriterion("medication_record_id is not null");
            return (Criteria) this;
        }

        public Criteria andMedicationRecordIdEqualTo(Integer value) {
            addCriterion("medication_record_id =", value, "medicationRecordId");
            return (Criteria) this;
        }

        public Criteria andMedicationRecordIdNotEqualTo(Integer value) {
            addCriterion("medication_record_id <>", value, "medicationRecordId");
            return (Criteria) this;
        }

        public Criteria andMedicationRecordIdGreaterThan(Integer value) {
            addCriterion("medication_record_id >", value, "medicationRecordId");
            return (Criteria) this;
        }

        public Criteria andMedicationRecordIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("medication_record_id >=", value, "medicationRecordId");
            return (Criteria) this;
        }

        public Criteria andMedicationRecordIdLessThan(Integer value) {
            addCriterion("medication_record_id <", value, "medicationRecordId");
            return (Criteria) this;
        }

        public Criteria andMedicationRecordIdLessThanOrEqualTo(Integer value) {
            addCriterion("medication_record_id <=", value, "medicationRecordId");
            return (Criteria) this;
        }

        public Criteria andMedicationRecordIdIn(List<Integer> values) {
            addCriterion("medication_record_id in", values, "medicationRecordId");
            return (Criteria) this;
        }

        public Criteria andMedicationRecordIdNotIn(List<Integer> values) {
            addCriterion("medication_record_id not in", values, "medicationRecordId");
            return (Criteria) this;
        }

        public Criteria andMedicationRecordIdBetween(Integer value1, Integer value2) {
            addCriterion("medication_record_id between", value1, value2, "medicationRecordId");
            return (Criteria) this;
        }

        public Criteria andMedicationRecordIdNotBetween(Integer value1, Integer value2) {
            addCriterion("medication_record_id not between", value1, value2, "medicationRecordId");
            return (Criteria) this;
        }

        public Criteria andDrugNameIsNull() {
            addCriterion("drug_name is null");
            return (Criteria) this;
        }

        public Criteria andDrugNameIsNotNull() {
            addCriterion("drug_name is not null");
            return (Criteria) this;
        }

        public Criteria andDrugNameEqualTo(String value) {
            addCriterion("drug_name =", value, "drugName");
            return (Criteria) this;
        }

        public Criteria andDrugNameNotEqualTo(String value) {
            addCriterion("drug_name <>", value, "drugName");
            return (Criteria) this;
        }

        public Criteria andDrugNameGreaterThan(String value) {
            addCriterion("drug_name >", value, "drugName");
            return (Criteria) this;
        }

        public Criteria andDrugNameGreaterThanOrEqualTo(String value) {
            addCriterion("drug_name >=", value, "drugName");
            return (Criteria) this;
        }

        public Criteria andDrugNameLessThan(String value) {
            addCriterion("drug_name <", value, "drugName");
            return (Criteria) this;
        }

        public Criteria andDrugNameLessThanOrEqualTo(String value) {
            addCriterion("drug_name <=", value, "drugName");
            return (Criteria) this;
        }

        public Criteria andDrugNameLike(String value) {
            addCriterion("drug_name like", value, "drugName");
            return (Criteria) this;
        }

        public Criteria andDrugNameNotLike(String value) {
            addCriterion("drug_name not like", value, "drugName");
            return (Criteria) this;
        }

        public Criteria andDrugNameIn(List<String> values) {
            addCriterion("drug_name in", values, "drugName");
            return (Criteria) this;
        }

        public Criteria andDrugNameNotIn(List<String> values) {
            addCriterion("drug_name not in", values, "drugName");
            return (Criteria) this;
        }

        public Criteria andDrugNameBetween(String value1, String value2) {
            addCriterion("drug_name between", value1, value2, "drugName");
            return (Criteria) this;
        }

        public Criteria andDrugNameNotBetween(String value1, String value2) {
            addCriterion("drug_name not between", value1, value2, "drugName");
            return (Criteria) this;
        }

        public Criteria andBreakfastConsumptionIsNull() {
            addCriterion("breakfast_consumption is null");
            return (Criteria) this;
        }

        public Criteria andBreakfastConsumptionIsNotNull() {
            addCriterion("breakfast_consumption is not null");
            return (Criteria) this;
        }

        public Criteria andBreakfastConsumptionEqualTo(String value) {
            addCriterion("breakfast_consumption =", value, "breakfastConsumption");
            return (Criteria) this;
        }

        public Criteria andBreakfastConsumptionNotEqualTo(String value) {
            addCriterion("breakfast_consumption <>", value, "breakfastConsumption");
            return (Criteria) this;
        }

        public Criteria andBreakfastConsumptionGreaterThan(String value) {
            addCriterion("breakfast_consumption >", value, "breakfastConsumption");
            return (Criteria) this;
        }

        public Criteria andBreakfastConsumptionGreaterThanOrEqualTo(String value) {
            addCriterion("breakfast_consumption >=", value, "breakfastConsumption");
            return (Criteria) this;
        }

        public Criteria andBreakfastConsumptionLessThan(String value) {
            addCriterion("breakfast_consumption <", value, "breakfastConsumption");
            return (Criteria) this;
        }

        public Criteria andBreakfastConsumptionLessThanOrEqualTo(String value) {
            addCriterion("breakfast_consumption <=", value, "breakfastConsumption");
            return (Criteria) this;
        }

        public Criteria andBreakfastConsumptionLike(String value) {
            addCriterion("breakfast_consumption like", value, "breakfastConsumption");
            return (Criteria) this;
        }

        public Criteria andBreakfastConsumptionNotLike(String value) {
            addCriterion("breakfast_consumption not like", value, "breakfastConsumption");
            return (Criteria) this;
        }

        public Criteria andBreakfastConsumptionIn(List<String> values) {
            addCriterion("breakfast_consumption in", values, "breakfastConsumption");
            return (Criteria) this;
        }

        public Criteria andBreakfastConsumptionNotIn(List<String> values) {
            addCriterion("breakfast_consumption not in", values, "breakfastConsumption");
            return (Criteria) this;
        }

        public Criteria andBreakfastConsumptionBetween(String value1, String value2) {
            addCriterion("breakfast_consumption between", value1, value2, "breakfastConsumption");
            return (Criteria) this;
        }

        public Criteria andBreakfastConsumptionNotBetween(String value1, String value2) {
            addCriterion("breakfast_consumption not between", value1, value2, "breakfastConsumption");
            return (Criteria) this;
        }

        public Criteria andLunchConsumptionIsNull() {
            addCriterion("lunch_consumption is null");
            return (Criteria) this;
        }

        public Criteria andLunchConsumptionIsNotNull() {
            addCriterion("lunch_consumption is not null");
            return (Criteria) this;
        }

        public Criteria andLunchConsumptionEqualTo(String value) {
            addCriterion("lunch_consumption =", value, "lunchConsumption");
            return (Criteria) this;
        }

        public Criteria andLunchConsumptionNotEqualTo(String value) {
            addCriterion("lunch_consumption <>", value, "lunchConsumption");
            return (Criteria) this;
        }

        public Criteria andLunchConsumptionGreaterThan(String value) {
            addCriterion("lunch_consumption >", value, "lunchConsumption");
            return (Criteria) this;
        }

        public Criteria andLunchConsumptionGreaterThanOrEqualTo(String value) {
            addCriterion("lunch_consumption >=", value, "lunchConsumption");
            return (Criteria) this;
        }

        public Criteria andLunchConsumptionLessThan(String value) {
            addCriterion("lunch_consumption <", value, "lunchConsumption");
            return (Criteria) this;
        }

        public Criteria andLunchConsumptionLessThanOrEqualTo(String value) {
            addCriterion("lunch_consumption <=", value, "lunchConsumption");
            return (Criteria) this;
        }

        public Criteria andLunchConsumptionLike(String value) {
            addCriterion("lunch_consumption like", value, "lunchConsumption");
            return (Criteria) this;
        }

        public Criteria andLunchConsumptionNotLike(String value) {
            addCriterion("lunch_consumption not like", value, "lunchConsumption");
            return (Criteria) this;
        }

        public Criteria andLunchConsumptionIn(List<String> values) {
            addCriterion("lunch_consumption in", values, "lunchConsumption");
            return (Criteria) this;
        }

        public Criteria andLunchConsumptionNotIn(List<String> values) {
            addCriterion("lunch_consumption not in", values, "lunchConsumption");
            return (Criteria) this;
        }

        public Criteria andLunchConsumptionBetween(String value1, String value2) {
            addCriterion("lunch_consumption between", value1, value2, "lunchConsumption");
            return (Criteria) this;
        }

        public Criteria andLunchConsumptionNotBetween(String value1, String value2) {
            addCriterion("lunch_consumption not between", value1, value2, "lunchConsumption");
            return (Criteria) this;
        }

        public Criteria andDinnerConsumptionIsNull() {
            addCriterion("dinner_consumption is null");
            return (Criteria) this;
        }

        public Criteria andDinnerConsumptionIsNotNull() {
            addCriterion("dinner_consumption is not null");
            return (Criteria) this;
        }

        public Criteria andDinnerConsumptionEqualTo(String value) {
            addCriterion("dinner_consumption =", value, "dinnerConsumption");
            return (Criteria) this;
        }

        public Criteria andDinnerConsumptionNotEqualTo(String value) {
            addCriterion("dinner_consumption <>", value, "dinnerConsumption");
            return (Criteria) this;
        }

        public Criteria andDinnerConsumptionGreaterThan(String value) {
            addCriterion("dinner_consumption >", value, "dinnerConsumption");
            return (Criteria) this;
        }

        public Criteria andDinnerConsumptionGreaterThanOrEqualTo(String value) {
            addCriterion("dinner_consumption >=", value, "dinnerConsumption");
            return (Criteria) this;
        }

        public Criteria andDinnerConsumptionLessThan(String value) {
            addCriterion("dinner_consumption <", value, "dinnerConsumption");
            return (Criteria) this;
        }

        public Criteria andDinnerConsumptionLessThanOrEqualTo(String value) {
            addCriterion("dinner_consumption <=", value, "dinnerConsumption");
            return (Criteria) this;
        }

        public Criteria andDinnerConsumptionLike(String value) {
            addCriterion("dinner_consumption like", value, "dinnerConsumption");
            return (Criteria) this;
        }

        public Criteria andDinnerConsumptionNotLike(String value) {
            addCriterion("dinner_consumption not like", value, "dinnerConsumption");
            return (Criteria) this;
        }

        public Criteria andDinnerConsumptionIn(List<String> values) {
            addCriterion("dinner_consumption in", values, "dinnerConsumption");
            return (Criteria) this;
        }

        public Criteria andDinnerConsumptionNotIn(List<String> values) {
            addCriterion("dinner_consumption not in", values, "dinnerConsumption");
            return (Criteria) this;
        }

        public Criteria andDinnerConsumptionBetween(String value1, String value2) {
            addCriterion("dinner_consumption between", value1, value2, "dinnerConsumption");
            return (Criteria) this;
        }

        public Criteria andDinnerConsumptionNotBetween(String value1, String value2) {
            addCriterion("dinner_consumption not between", value1, value2, "dinnerConsumption");
            return (Criteria) this;
        }

        public Criteria andBeforeSleepConsumptionIsNull() {
            addCriterion("before_sleep_consumption is null");
            return (Criteria) this;
        }

        public Criteria andBeforeSleepConsumptionIsNotNull() {
            addCriterion("before_sleep_consumption is not null");
            return (Criteria) this;
        }

        public Criteria andBeforeSleepConsumptionEqualTo(String value) {
            addCriterion("before_sleep_consumption =", value, "beforeSleepConsumption");
            return (Criteria) this;
        }

        public Criteria andBeforeSleepConsumptionNotEqualTo(String value) {
            addCriterion("before_sleep_consumption <>", value, "beforeSleepConsumption");
            return (Criteria) this;
        }

        public Criteria andBeforeSleepConsumptionGreaterThan(String value) {
            addCriterion("before_sleep_consumption >", value, "beforeSleepConsumption");
            return (Criteria) this;
        }

        public Criteria andBeforeSleepConsumptionGreaterThanOrEqualTo(String value) {
            addCriterion("before_sleep_consumption >=", value, "beforeSleepConsumption");
            return (Criteria) this;
        }

        public Criteria andBeforeSleepConsumptionLessThan(String value) {
            addCriterion("before_sleep_consumption <", value, "beforeSleepConsumption");
            return (Criteria) this;
        }

        public Criteria andBeforeSleepConsumptionLessThanOrEqualTo(String value) {
            addCriterion("before_sleep_consumption <=", value, "beforeSleepConsumption");
            return (Criteria) this;
        }

        public Criteria andBeforeSleepConsumptionLike(String value) {
            addCriterion("before_sleep_consumption like", value, "beforeSleepConsumption");
            return (Criteria) this;
        }

        public Criteria andBeforeSleepConsumptionNotLike(String value) {
            addCriterion("before_sleep_consumption not like", value, "beforeSleepConsumption");
            return (Criteria) this;
        }

        public Criteria andBeforeSleepConsumptionIn(List<String> values) {
            addCriterion("before_sleep_consumption in", values, "beforeSleepConsumption");
            return (Criteria) this;
        }

        public Criteria andBeforeSleepConsumptionNotIn(List<String> values) {
            addCriterion("before_sleep_consumption not in", values, "beforeSleepConsumption");
            return (Criteria) this;
        }

        public Criteria andBeforeSleepConsumptionBetween(String value1, String value2) {
            addCriterion("before_sleep_consumption between", value1, value2, "beforeSleepConsumption");
            return (Criteria) this;
        }

        public Criteria andBeforeSleepConsumptionNotBetween(String value1, String value2) {
            addCriterion("before_sleep_consumption not between", value1, value2, "beforeSleepConsumption");
            return (Criteria) this;
        }

        public Criteria andOtherIsNull() {
            addCriterion("other is null");
            return (Criteria) this;
        }

        public Criteria andOtherIsNotNull() {
            addCriterion("other is not null");
            return (Criteria) this;
        }

        public Criteria andOtherEqualTo(String value) {
            addCriterion("other =", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherNotEqualTo(String value) {
            addCriterion("other <>", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherGreaterThan(String value) {
            addCriterion("other >", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherGreaterThanOrEqualTo(String value) {
            addCriterion("other >=", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherLessThan(String value) {
            addCriterion("other <", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherLessThanOrEqualTo(String value) {
            addCriterion("other <=", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherLike(String value) {
            addCriterion("other like", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherNotLike(String value) {
            addCriterion("other not like", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherIn(List<String> values) {
            addCriterion("other in", values, "other");
            return (Criteria) this;
        }

        public Criteria andOtherNotIn(List<String> values) {
            addCriterion("other not in", values, "other");
            return (Criteria) this;
        }

        public Criteria andOtherBetween(String value1, String value2) {
            addCriterion("other between", value1, value2, "other");
            return (Criteria) this;
        }

        public Criteria andOtherNotBetween(String value1, String value2) {
            addCriterion("other not between", value1, value2, "other");
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