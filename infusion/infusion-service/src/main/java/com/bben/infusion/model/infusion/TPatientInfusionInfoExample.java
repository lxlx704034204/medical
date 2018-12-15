package com.bben.infusion.model.infusion;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TPatientInfusionInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TPatientInfusionInfoExample() {
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

        public Criteria andInfusionNoIsNull() {
            addCriterion("infusion_no is null");
            return (Criteria) this;
        }

        public Criteria andInfusionNoIsNotNull() {
            addCriterion("infusion_no is not null");
            return (Criteria) this;
        }

        public Criteria andInfusionNoEqualTo(String value) {
            addCriterion("infusion_no =", value, "infusionNo");
            return (Criteria) this;
        }

        public Criteria andInfusionNoNotEqualTo(String value) {
            addCriterion("infusion_no <>", value, "infusionNo");
            return (Criteria) this;
        }

        public Criteria andInfusionNoGreaterThan(String value) {
            addCriterion("infusion_no >", value, "infusionNo");
            return (Criteria) this;
        }

        public Criteria andInfusionNoGreaterThanOrEqualTo(String value) {
            addCriterion("infusion_no >=", value, "infusionNo");
            return (Criteria) this;
        }

        public Criteria andInfusionNoLessThan(String value) {
            addCriterion("infusion_no <", value, "infusionNo");
            return (Criteria) this;
        }

        public Criteria andInfusionNoLessThanOrEqualTo(String value) {
            addCriterion("infusion_no <=", value, "infusionNo");
            return (Criteria) this;
        }

        public Criteria andInfusionNoLike(String value) {
            addCriterion("infusion_no like", value, "infusionNo");
            return (Criteria) this;
        }

        public Criteria andInfusionNoNotLike(String value) {
            addCriterion("infusion_no not like", value, "infusionNo");
            return (Criteria) this;
        }

        public Criteria andInfusionNoIn(List<String> values) {
            addCriterion("infusion_no in", values, "infusionNo");
            return (Criteria) this;
        }

        public Criteria andInfusionNoNotIn(List<String> values) {
            addCriterion("infusion_no not in", values, "infusionNo");
            return (Criteria) this;
        }

        public Criteria andInfusionNoBetween(String value1, String value2) {
            addCriterion("infusion_no between", value1, value2, "infusionNo");
            return (Criteria) this;
        }

        public Criteria andInfusionNoNotBetween(String value1, String value2) {
            addCriterion("infusion_no not between", value1, value2, "infusionNo");
            return (Criteria) this;
        }

        public Criteria andSequenceIdIsNull() {
            addCriterion("sequence_id is null");
            return (Criteria) this;
        }

        public Criteria andSequenceIdIsNotNull() {
            addCriterion("sequence_id is not null");
            return (Criteria) this;
        }

        public Criteria andSequenceIdEqualTo(Integer value) {
            addCriterion("sequence_id =", value, "sequenceId");
            return (Criteria) this;
        }

        public Criteria andSequenceIdNotEqualTo(Integer value) {
            addCriterion("sequence_id <>", value, "sequenceId");
            return (Criteria) this;
        }

        public Criteria andSequenceIdGreaterThan(Integer value) {
            addCriterion("sequence_id >", value, "sequenceId");
            return (Criteria) this;
        }

        public Criteria andSequenceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("sequence_id >=", value, "sequenceId");
            return (Criteria) this;
        }

        public Criteria andSequenceIdLessThan(Integer value) {
            addCriterion("sequence_id <", value, "sequenceId");
            return (Criteria) this;
        }

        public Criteria andSequenceIdLessThanOrEqualTo(Integer value) {
            addCriterion("sequence_id <=", value, "sequenceId");
            return (Criteria) this;
        }

        public Criteria andSequenceIdIn(List<Integer> values) {
            addCriterion("sequence_id in", values, "sequenceId");
            return (Criteria) this;
        }

        public Criteria andSequenceIdNotIn(List<Integer> values) {
            addCriterion("sequence_id not in", values, "sequenceId");
            return (Criteria) this;
        }

        public Criteria andSequenceIdBetween(Integer value1, Integer value2) {
            addCriterion("sequence_id between", value1, value2, "sequenceId");
            return (Criteria) this;
        }

        public Criteria andSequenceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("sequence_id not between", value1, value2, "sequenceId");
            return (Criteria) this;
        }

        public Criteria andDrugNameListIsNull() {
            addCriterion("drug_name_list is null");
            return (Criteria) this;
        }

        public Criteria andDrugNameListIsNotNull() {
            addCriterion("drug_name_list is not null");
            return (Criteria) this;
        }

        public Criteria andDrugNameListEqualTo(String value) {
            addCriterion("drug_name_list =", value, "drugNameList");
            return (Criteria) this;
        }

        public Criteria andDrugNameListNotEqualTo(String value) {
            addCriterion("drug_name_list <>", value, "drugNameList");
            return (Criteria) this;
        }

        public Criteria andDrugNameListGreaterThan(String value) {
            addCriterion("drug_name_list >", value, "drugNameList");
            return (Criteria) this;
        }

        public Criteria andDrugNameListGreaterThanOrEqualTo(String value) {
            addCriterion("drug_name_list >=", value, "drugNameList");
            return (Criteria) this;
        }

        public Criteria andDrugNameListLessThan(String value) {
            addCriterion("drug_name_list <", value, "drugNameList");
            return (Criteria) this;
        }

        public Criteria andDrugNameListLessThanOrEqualTo(String value) {
            addCriterion("drug_name_list <=", value, "drugNameList");
            return (Criteria) this;
        }

        public Criteria andDrugNameListLike(String value) {
            addCriterion("drug_name_list like", value, "drugNameList");
            return (Criteria) this;
        }

        public Criteria andDrugNameListNotLike(String value) {
            addCriterion("drug_name_list not like", value, "drugNameList");
            return (Criteria) this;
        }

        public Criteria andDrugNameListIn(List<String> values) {
            addCriterion("drug_name_list in", values, "drugNameList");
            return (Criteria) this;
        }

        public Criteria andDrugNameListNotIn(List<String> values) {
            addCriterion("drug_name_list not in", values, "drugNameList");
            return (Criteria) this;
        }

        public Criteria andDrugNameListBetween(String value1, String value2) {
            addCriterion("drug_name_list between", value1, value2, "drugNameList");
            return (Criteria) this;
        }

        public Criteria andDrugNameListNotBetween(String value1, String value2) {
            addCriterion("drug_name_list not between", value1, value2, "drugNameList");
            return (Criteria) this;
        }

        public Criteria andMaxDripIsNull() {
            addCriterion("max_drip is null");
            return (Criteria) this;
        }

        public Criteria andMaxDripIsNotNull() {
            addCriterion("max_drip is not null");
            return (Criteria) this;
        }

        public Criteria andMaxDripEqualTo(Integer value) {
            addCriterion("max_drip =", value, "maxDrip");
            return (Criteria) this;
        }

        public Criteria andMaxDripNotEqualTo(Integer value) {
            addCriterion("max_drip <>", value, "maxDrip");
            return (Criteria) this;
        }

        public Criteria andMaxDripGreaterThan(Integer value) {
            addCriterion("max_drip >", value, "maxDrip");
            return (Criteria) this;
        }

        public Criteria andMaxDripGreaterThanOrEqualTo(Integer value) {
            addCriterion("max_drip >=", value, "maxDrip");
            return (Criteria) this;
        }

        public Criteria andMaxDripLessThan(Integer value) {
            addCriterion("max_drip <", value, "maxDrip");
            return (Criteria) this;
        }

        public Criteria andMaxDripLessThanOrEqualTo(Integer value) {
            addCriterion("max_drip <=", value, "maxDrip");
            return (Criteria) this;
        }

        public Criteria andMaxDripIn(List<Integer> values) {
            addCriterion("max_drip in", values, "maxDrip");
            return (Criteria) this;
        }

        public Criteria andMaxDripNotIn(List<Integer> values) {
            addCriterion("max_drip not in", values, "maxDrip");
            return (Criteria) this;
        }

        public Criteria andMaxDripBetween(Integer value1, Integer value2) {
            addCriterion("max_drip between", value1, value2, "maxDrip");
            return (Criteria) this;
        }

        public Criteria andMaxDripNotBetween(Integer value1, Integer value2) {
            addCriterion("max_drip not between", value1, value2, "maxDrip");
            return (Criteria) this;
        }

        public Criteria andMinDripIsNull() {
            addCriterion("min_drip is null");
            return (Criteria) this;
        }

        public Criteria andMinDripIsNotNull() {
            addCriterion("min_drip is not null");
            return (Criteria) this;
        }

        public Criteria andMinDripEqualTo(Integer value) {
            addCriterion("min_drip =", value, "minDrip");
            return (Criteria) this;
        }

        public Criteria andMinDripNotEqualTo(Integer value) {
            addCriterion("min_drip <>", value, "minDrip");
            return (Criteria) this;
        }

        public Criteria andMinDripGreaterThan(Integer value) {
            addCriterion("min_drip >", value, "minDrip");
            return (Criteria) this;
        }

        public Criteria andMinDripGreaterThanOrEqualTo(Integer value) {
            addCriterion("min_drip >=", value, "minDrip");
            return (Criteria) this;
        }

        public Criteria andMinDripLessThan(Integer value) {
            addCriterion("min_drip <", value, "minDrip");
            return (Criteria) this;
        }

        public Criteria andMinDripLessThanOrEqualTo(Integer value) {
            addCriterion("min_drip <=", value, "minDrip");
            return (Criteria) this;
        }

        public Criteria andMinDripIn(List<Integer> values) {
            addCriterion("min_drip in", values, "minDrip");
            return (Criteria) this;
        }

        public Criteria andMinDripNotIn(List<Integer> values) {
            addCriterion("min_drip not in", values, "minDrip");
            return (Criteria) this;
        }

        public Criteria andMinDripBetween(Integer value1, Integer value2) {
            addCriterion("min_drip between", value1, value2, "minDrip");
            return (Criteria) this;
        }

        public Criteria andMinDripNotBetween(Integer value1, Integer value2) {
            addCriterion("min_drip not between", value1, value2, "minDrip");
            return (Criteria) this;
        }

        public Criteria andMaxTimeLenIsNull() {
            addCriterion("max_time_len is null");
            return (Criteria) this;
        }

        public Criteria andMaxTimeLenIsNotNull() {
            addCriterion("max_time_len is not null");
            return (Criteria) this;
        }

        public Criteria andMaxTimeLenEqualTo(Integer value) {
            addCriterion("max_time_len =", value, "maxTimeLen");
            return (Criteria) this;
        }

        public Criteria andMaxTimeLenNotEqualTo(Integer value) {
            addCriterion("max_time_len <>", value, "maxTimeLen");
            return (Criteria) this;
        }

        public Criteria andMaxTimeLenGreaterThan(Integer value) {
            addCriterion("max_time_len >", value, "maxTimeLen");
            return (Criteria) this;
        }

        public Criteria andMaxTimeLenGreaterThanOrEqualTo(Integer value) {
            addCriterion("max_time_len >=", value, "maxTimeLen");
            return (Criteria) this;
        }

        public Criteria andMaxTimeLenLessThan(Integer value) {
            addCriterion("max_time_len <", value, "maxTimeLen");
            return (Criteria) this;
        }

        public Criteria andMaxTimeLenLessThanOrEqualTo(Integer value) {
            addCriterion("max_time_len <=", value, "maxTimeLen");
            return (Criteria) this;
        }

        public Criteria andMaxTimeLenIn(List<Integer> values) {
            addCriterion("max_time_len in", values, "maxTimeLen");
            return (Criteria) this;
        }

        public Criteria andMaxTimeLenNotIn(List<Integer> values) {
            addCriterion("max_time_len not in", values, "maxTimeLen");
            return (Criteria) this;
        }

        public Criteria andMaxTimeLenBetween(Integer value1, Integer value2) {
            addCriterion("max_time_len between", value1, value2, "maxTimeLen");
            return (Criteria) this;
        }

        public Criteria andMaxTimeLenNotBetween(Integer value1, Integer value2) {
            addCriterion("max_time_len not between", value1, value2, "maxTimeLen");
            return (Criteria) this;
        }

        public Criteria andMinTimeLenIsNull() {
            addCriterion("min_time_len is null");
            return (Criteria) this;
        }

        public Criteria andMinTimeLenIsNotNull() {
            addCriterion("min_time_len is not null");
            return (Criteria) this;
        }

        public Criteria andMinTimeLenEqualTo(Integer value) {
            addCriterion("min_time_len =", value, "minTimeLen");
            return (Criteria) this;
        }

        public Criteria andMinTimeLenNotEqualTo(Integer value) {
            addCriterion("min_time_len <>", value, "minTimeLen");
            return (Criteria) this;
        }

        public Criteria andMinTimeLenGreaterThan(Integer value) {
            addCriterion("min_time_len >", value, "minTimeLen");
            return (Criteria) this;
        }

        public Criteria andMinTimeLenGreaterThanOrEqualTo(Integer value) {
            addCriterion("min_time_len >=", value, "minTimeLen");
            return (Criteria) this;
        }

        public Criteria andMinTimeLenLessThan(Integer value) {
            addCriterion("min_time_len <", value, "minTimeLen");
            return (Criteria) this;
        }

        public Criteria andMinTimeLenLessThanOrEqualTo(Integer value) {
            addCriterion("min_time_len <=", value, "minTimeLen");
            return (Criteria) this;
        }

        public Criteria andMinTimeLenIn(List<Integer> values) {
            addCriterion("min_time_len in", values, "minTimeLen");
            return (Criteria) this;
        }

        public Criteria andMinTimeLenNotIn(List<Integer> values) {
            addCriterion("min_time_len not in", values, "minTimeLen");
            return (Criteria) this;
        }

        public Criteria andMinTimeLenBetween(Integer value1, Integer value2) {
            addCriterion("min_time_len between", value1, value2, "minTimeLen");
            return (Criteria) this;
        }

        public Criteria andMinTimeLenNotBetween(Integer value1, Integer value2) {
            addCriterion("min_time_len not between", value1, value2, "minTimeLen");
            return (Criteria) this;
        }

        public Criteria andBottleLiquidWeightIsNull() {
            addCriterion("bottle_liquid_weight is null");
            return (Criteria) this;
        }

        public Criteria andBottleLiquidWeightIsNotNull() {
            addCriterion("bottle_liquid_weight is not null");
            return (Criteria) this;
        }

        public Criteria andBottleLiquidWeightEqualTo(Integer value) {
            addCriterion("bottle_liquid_weight =", value, "bottleLiquidWeight");
            return (Criteria) this;
        }

        public Criteria andBottleLiquidWeightNotEqualTo(Integer value) {
            addCriterion("bottle_liquid_weight <>", value, "bottleLiquidWeight");
            return (Criteria) this;
        }

        public Criteria andBottleLiquidWeightGreaterThan(Integer value) {
            addCriterion("bottle_liquid_weight >", value, "bottleLiquidWeight");
            return (Criteria) this;
        }

        public Criteria andBottleLiquidWeightGreaterThanOrEqualTo(Integer value) {
            addCriterion("bottle_liquid_weight >=", value, "bottleLiquidWeight");
            return (Criteria) this;
        }

        public Criteria andBottleLiquidWeightLessThan(Integer value) {
            addCriterion("bottle_liquid_weight <", value, "bottleLiquidWeight");
            return (Criteria) this;
        }

        public Criteria andBottleLiquidWeightLessThanOrEqualTo(Integer value) {
            addCriterion("bottle_liquid_weight <=", value, "bottleLiquidWeight");
            return (Criteria) this;
        }

        public Criteria andBottleLiquidWeightIn(List<Integer> values) {
            addCriterion("bottle_liquid_weight in", values, "bottleLiquidWeight");
            return (Criteria) this;
        }

        public Criteria andBottleLiquidWeightNotIn(List<Integer> values) {
            addCriterion("bottle_liquid_weight not in", values, "bottleLiquidWeight");
            return (Criteria) this;
        }

        public Criteria andBottleLiquidWeightBetween(Integer value1, Integer value2) {
            addCriterion("bottle_liquid_weight between", value1, value2, "bottleLiquidWeight");
            return (Criteria) this;
        }

        public Criteria andBottleLiquidWeightNotBetween(Integer value1, Integer value2) {
            addCriterion("bottle_liquid_weight not between", value1, value2, "bottleLiquidWeight");
            return (Criteria) this;
        }

        public Criteria andBottleWeightIsNull() {
            addCriterion("bottle_weight is null");
            return (Criteria) this;
        }

        public Criteria andBottleWeightIsNotNull() {
            addCriterion("bottle_weight is not null");
            return (Criteria) this;
        }

        public Criteria andBottleWeightEqualTo(Integer value) {
            addCriterion("bottle_weight =", value, "bottleWeight");
            return (Criteria) this;
        }

        public Criteria andBottleWeightNotEqualTo(Integer value) {
            addCriterion("bottle_weight <>", value, "bottleWeight");
            return (Criteria) this;
        }

        public Criteria andBottleWeightGreaterThan(Integer value) {
            addCriterion("bottle_weight >", value, "bottleWeight");
            return (Criteria) this;
        }

        public Criteria andBottleWeightGreaterThanOrEqualTo(Integer value) {
            addCriterion("bottle_weight >=", value, "bottleWeight");
            return (Criteria) this;
        }

        public Criteria andBottleWeightLessThan(Integer value) {
            addCriterion("bottle_weight <", value, "bottleWeight");
            return (Criteria) this;
        }

        public Criteria andBottleWeightLessThanOrEqualTo(Integer value) {
            addCriterion("bottle_weight <=", value, "bottleWeight");
            return (Criteria) this;
        }

        public Criteria andBottleWeightIn(List<Integer> values) {
            addCriterion("bottle_weight in", values, "bottleWeight");
            return (Criteria) this;
        }

        public Criteria andBottleWeightNotIn(List<Integer> values) {
            addCriterion("bottle_weight not in", values, "bottleWeight");
            return (Criteria) this;
        }

        public Criteria andBottleWeightBetween(Integer value1, Integer value2) {
            addCriterion("bottle_weight between", value1, value2, "bottleWeight");
            return (Criteria) this;
        }

        public Criteria andBottleWeightNotBetween(Integer value1, Integer value2) {
            addCriterion("bottle_weight not between", value1, value2, "bottleWeight");
            return (Criteria) this;
        }

        public Criteria andEstimateTimeLenIsNull() {
            addCriterion("estimate_time_len is null");
            return (Criteria) this;
        }

        public Criteria andEstimateTimeLenIsNotNull() {
            addCriterion("estimate_time_len is not null");
            return (Criteria) this;
        }

        public Criteria andEstimateTimeLenEqualTo(Integer value) {
            addCriterion("estimate_time_len =", value, "estimateTimeLen");
            return (Criteria) this;
        }

        public Criteria andEstimateTimeLenNotEqualTo(Integer value) {
            addCriterion("estimate_time_len <>", value, "estimateTimeLen");
            return (Criteria) this;
        }

        public Criteria andEstimateTimeLenGreaterThan(Integer value) {
            addCriterion("estimate_time_len >", value, "estimateTimeLen");
            return (Criteria) this;
        }

        public Criteria andEstimateTimeLenGreaterThanOrEqualTo(Integer value) {
            addCriterion("estimate_time_len >=", value, "estimateTimeLen");
            return (Criteria) this;
        }

        public Criteria andEstimateTimeLenLessThan(Integer value) {
            addCriterion("estimate_time_len <", value, "estimateTimeLen");
            return (Criteria) this;
        }

        public Criteria andEstimateTimeLenLessThanOrEqualTo(Integer value) {
            addCriterion("estimate_time_len <=", value, "estimateTimeLen");
            return (Criteria) this;
        }

        public Criteria andEstimateTimeLenIn(List<Integer> values) {
            addCriterion("estimate_time_len in", values, "estimateTimeLen");
            return (Criteria) this;
        }

        public Criteria andEstimateTimeLenNotIn(List<Integer> values) {
            addCriterion("estimate_time_len not in", values, "estimateTimeLen");
            return (Criteria) this;
        }

        public Criteria andEstimateTimeLenBetween(Integer value1, Integer value2) {
            addCriterion("estimate_time_len between", value1, value2, "estimateTimeLen");
            return (Criteria) this;
        }

        public Criteria andEstimateTimeLenNotBetween(Integer value1, Integer value2) {
            addCriterion("estimate_time_len not between", value1, value2, "estimateTimeLen");
            return (Criteria) this;
        }

        public Criteria andNormalDripIsNull() {
            addCriterion("normal_drip is null");
            return (Criteria) this;
        }

        public Criteria andNormalDripIsNotNull() {
            addCriterion("normal_drip is not null");
            return (Criteria) this;
        }

        public Criteria andNormalDripEqualTo(Integer value) {
            addCriterion("normal_drip =", value, "normalDrip");
            return (Criteria) this;
        }

        public Criteria andNormalDripNotEqualTo(Integer value) {
            addCriterion("normal_drip <>", value, "normalDrip");
            return (Criteria) this;
        }

        public Criteria andNormalDripGreaterThan(Integer value) {
            addCriterion("normal_drip >", value, "normalDrip");
            return (Criteria) this;
        }

        public Criteria andNormalDripGreaterThanOrEqualTo(Integer value) {
            addCriterion("normal_drip >=", value, "normalDrip");
            return (Criteria) this;
        }

        public Criteria andNormalDripLessThan(Integer value) {
            addCriterion("normal_drip <", value, "normalDrip");
            return (Criteria) this;
        }

        public Criteria andNormalDripLessThanOrEqualTo(Integer value) {
            addCriterion("normal_drip <=", value, "normalDrip");
            return (Criteria) this;
        }

        public Criteria andNormalDripIn(List<Integer> values) {
            addCriterion("normal_drip in", values, "normalDrip");
            return (Criteria) this;
        }

        public Criteria andNormalDripNotIn(List<Integer> values) {
            addCriterion("normal_drip not in", values, "normalDrip");
            return (Criteria) this;
        }

        public Criteria andNormalDripBetween(Integer value1, Integer value2) {
            addCriterion("normal_drip between", value1, value2, "normalDrip");
            return (Criteria) this;
        }

        public Criteria andNormalDripNotBetween(Integer value1, Integer value2) {
            addCriterion("normal_drip not between", value1, value2, "normalDrip");
            return (Criteria) this;
        }

        public Criteria andRunStatusIsNull() {
            addCriterion("run_status is null");
            return (Criteria) this;
        }

        public Criteria andRunStatusIsNotNull() {
            addCriterion("run_status is not null");
            return (Criteria) this;
        }

        public Criteria andRunStatusEqualTo(Integer value) {
            addCriterion("run_status =", value, "runStatus");
            return (Criteria) this;
        }

        public Criteria andRunStatusNotEqualTo(Integer value) {
            addCriterion("run_status <>", value, "runStatus");
            return (Criteria) this;
        }

        public Criteria andRunStatusGreaterThan(Integer value) {
            addCriterion("run_status >", value, "runStatus");
            return (Criteria) this;
        }

        public Criteria andRunStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("run_status >=", value, "runStatus");
            return (Criteria) this;
        }

        public Criteria andRunStatusLessThan(Integer value) {
            addCriterion("run_status <", value, "runStatus");
            return (Criteria) this;
        }

        public Criteria andRunStatusLessThanOrEqualTo(Integer value) {
            addCriterion("run_status <=", value, "runStatus");
            return (Criteria) this;
        }

        public Criteria andRunStatusIn(List<Integer> values) {
            addCriterion("run_status in", values, "runStatus");
            return (Criteria) this;
        }

        public Criteria andRunStatusNotIn(List<Integer> values) {
            addCriterion("run_status not in", values, "runStatus");
            return (Criteria) this;
        }

        public Criteria andRunStatusBetween(Integer value1, Integer value2) {
            addCriterion("run_status between", value1, value2, "runStatus");
            return (Criteria) this;
        }

        public Criteria andRunStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("run_status not between", value1, value2, "runStatus");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIsNull() {
            addCriterion("begin_time is null");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIsNotNull() {
            addCriterion("begin_time is not null");
            return (Criteria) this;
        }

        public Criteria andBeginTimeEqualTo(Date value) {
            addCriterion("begin_time =", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotEqualTo(Date value) {
            addCriterion("begin_time <>", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeGreaterThan(Date value) {
            addCriterion("begin_time >", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("begin_time >=", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeLessThan(Date value) {
            addCriterion("begin_time <", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeLessThanOrEqualTo(Date value) {
            addCriterion("begin_time <=", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIn(List<Date> values) {
            addCriterion("begin_time in", values, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotIn(List<Date> values) {
            addCriterion("begin_time not in", values, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeBetween(Date value1, Date value2) {
            addCriterion("begin_time between", value1, value2, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotBetween(Date value1, Date value2) {
            addCriterion("begin_time not between", value1, value2, "beginTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
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