package com.bben.medical.model.medical;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TUserExample() {
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

        public Criteria andUserCodeIsNull() {
            addCriterion("user_code is null");
            return (Criteria) this;
        }

        public Criteria andUserCodeIsNotNull() {
            addCriterion("user_code is not null");
            return (Criteria) this;
        }

        public Criteria andUserCodeEqualTo(String value) {
            addCriterion("user_code =", value, "userCode");
            return (Criteria) this;
        }

        public Criteria andUserCodeNotEqualTo(String value) {
            addCriterion("user_code <>", value, "userCode");
            return (Criteria) this;
        }

        public Criteria andUserCodeGreaterThan(String value) {
            addCriterion("user_code >", value, "userCode");
            return (Criteria) this;
        }

        public Criteria andUserCodeGreaterThanOrEqualTo(String value) {
            addCriterion("user_code >=", value, "userCode");
            return (Criteria) this;
        }

        public Criteria andUserCodeLessThan(String value) {
            addCriterion("user_code <", value, "userCode");
            return (Criteria) this;
        }

        public Criteria andUserCodeLessThanOrEqualTo(String value) {
            addCriterion("user_code <=", value, "userCode");
            return (Criteria) this;
        }

        public Criteria andUserCodeLike(String value) {
            addCriterion("user_code like", value, "userCode");
            return (Criteria) this;
        }

        public Criteria andUserCodeNotLike(String value) {
            addCriterion("user_code not like", value, "userCode");
            return (Criteria) this;
        }

        public Criteria andUserCodeIn(List<String> values) {
            addCriterion("user_code in", values, "userCode");
            return (Criteria) this;
        }

        public Criteria andUserCodeNotIn(List<String> values) {
            addCriterion("user_code not in", values, "userCode");
            return (Criteria) this;
        }

        public Criteria andUserCodeBetween(String value1, String value2) {
            addCriterion("user_code between", value1, value2, "userCode");
            return (Criteria) this;
        }

        public Criteria andUserCodeNotBetween(String value1, String value2) {
            addCriterion("user_code not between", value1, value2, "userCode");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserTypeIsNull() {
            addCriterion("user_type is null");
            return (Criteria) this;
        }

        public Criteria andUserTypeIsNotNull() {
            addCriterion("user_type is not null");
            return (Criteria) this;
        }

        public Criteria andUserTypeEqualTo(String value) {
            addCriterion("user_type =", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotEqualTo(String value) {
            addCriterion("user_type <>", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThan(String value) {
            addCriterion("user_type >", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThanOrEqualTo(String value) {
            addCriterion("user_type >=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThan(String value) {
            addCriterion("user_type <", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThanOrEqualTo(String value) {
            addCriterion("user_type <=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLike(String value) {
            addCriterion("user_type like", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotLike(String value) {
            addCriterion("user_type not like", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeIn(List<String> values) {
            addCriterion("user_type in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotIn(List<String> values) {
            addCriterion("user_type not in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeBetween(String value1, String value2) {
            addCriterion("user_type between", value1, value2, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotBetween(String value1, String value2) {
            addCriterion("user_type not between", value1, value2, "userType");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(String value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLike(String value) {
            addCriterion("sex like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotLike(String value) {
            addCriterion("sex not like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<String> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<String> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andDateBirthIsNull() {
            addCriterion("date_birth is null");
            return (Criteria) this;
        }

        public Criteria andDateBirthIsNotNull() {
            addCriterion("date_birth is not null");
            return (Criteria) this;
        }

        public Criteria andDateBirthEqualTo(Date value) {
            addCriterion("date_birth =", value, "dateBirth");
            return (Criteria) this;
        }

        public Criteria andDateBirthNotEqualTo(Date value) {
            addCriterion("date_birth <>", value, "dateBirth");
            return (Criteria) this;
        }

        public Criteria andDateBirthGreaterThan(Date value) {
            addCriterion("date_birth >", value, "dateBirth");
            return (Criteria) this;
        }

        public Criteria andDateBirthGreaterThanOrEqualTo(Date value) {
            addCriterion("date_birth >=", value, "dateBirth");
            return (Criteria) this;
        }

        public Criteria andDateBirthLessThan(Date value) {
            addCriterion("date_birth <", value, "dateBirth");
            return (Criteria) this;
        }

        public Criteria andDateBirthLessThanOrEqualTo(Date value) {
            addCriterion("date_birth <=", value, "dateBirth");
            return (Criteria) this;
        }

        public Criteria andDateBirthIn(List<Date> values) {
            addCriterion("date_birth in", values, "dateBirth");
            return (Criteria) this;
        }

        public Criteria andDateBirthNotIn(List<Date> values) {
            addCriterion("date_birth not in", values, "dateBirth");
            return (Criteria) this;
        }

        public Criteria andDateBirthBetween(Date value1, Date value2) {
            addCriterion("date_birth between", value1, value2, "dateBirth");
            return (Criteria) this;
        }

        public Criteria andDateBirthNotBetween(Date value1, Date value2) {
            addCriterion("date_birth not between", value1, value2, "dateBirth");
            return (Criteria) this;
        }

        public Criteria andBirthplaceIsNull() {
            addCriterion("birthplace is null");
            return (Criteria) this;
        }

        public Criteria andBirthplaceIsNotNull() {
            addCriterion("birthplace is not null");
            return (Criteria) this;
        }

        public Criteria andBirthplaceEqualTo(String value) {
            addCriterion("birthplace =", value, "birthplace");
            return (Criteria) this;
        }

        public Criteria andBirthplaceNotEqualTo(String value) {
            addCriterion("birthplace <>", value, "birthplace");
            return (Criteria) this;
        }

        public Criteria andBirthplaceGreaterThan(String value) {
            addCriterion("birthplace >", value, "birthplace");
            return (Criteria) this;
        }

        public Criteria andBirthplaceGreaterThanOrEqualTo(String value) {
            addCriterion("birthplace >=", value, "birthplace");
            return (Criteria) this;
        }

        public Criteria andBirthplaceLessThan(String value) {
            addCriterion("birthplace <", value, "birthplace");
            return (Criteria) this;
        }

        public Criteria andBirthplaceLessThanOrEqualTo(String value) {
            addCriterion("birthplace <=", value, "birthplace");
            return (Criteria) this;
        }

        public Criteria andBirthplaceLike(String value) {
            addCriterion("birthplace like", value, "birthplace");
            return (Criteria) this;
        }

        public Criteria andBirthplaceNotLike(String value) {
            addCriterion("birthplace not like", value, "birthplace");
            return (Criteria) this;
        }

        public Criteria andBirthplaceIn(List<String> values) {
            addCriterion("birthplace in", values, "birthplace");
            return (Criteria) this;
        }

        public Criteria andBirthplaceNotIn(List<String> values) {
            addCriterion("birthplace not in", values, "birthplace");
            return (Criteria) this;
        }

        public Criteria andBirthplaceBetween(String value1, String value2) {
            addCriterion("birthplace between", value1, value2, "birthplace");
            return (Criteria) this;
        }

        public Criteria andBirthplaceNotBetween(String value1, String value2) {
            addCriterion("birthplace not between", value1, value2, "birthplace");
            return (Criteria) this;
        }

        public Criteria andMobileIsNull() {
            addCriterion("mobile is null");
            return (Criteria) this;
        }

        public Criteria andMobileIsNotNull() {
            addCriterion("mobile is not null");
            return (Criteria) this;
        }

        public Criteria andMobileEqualTo(String value) {
            addCriterion("mobile =", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotEqualTo(String value) {
            addCriterion("mobile <>", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThan(String value) {
            addCriterion("mobile >", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThanOrEqualTo(String value) {
            addCriterion("mobile >=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThan(String value) {
            addCriterion("mobile <", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThanOrEqualTo(String value) {
            addCriterion("mobile <=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLike(String value) {
            addCriterion("mobile like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotLike(String value) {
            addCriterion("mobile not like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileIn(List<String> values) {
            addCriterion("mobile in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotIn(List<String> values) {
            addCriterion("mobile not in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileBetween(String value1, String value2) {
            addCriterion("mobile between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotBetween(String value1, String value2) {
            addCriterion("mobile not between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andIdNumberIsNull() {
            addCriterion("id_number is null");
            return (Criteria) this;
        }

        public Criteria andIdNumberIsNotNull() {
            addCriterion("id_number is not null");
            return (Criteria) this;
        }

        public Criteria andIdNumberEqualTo(String value) {
            addCriterion("id_number =", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberNotEqualTo(String value) {
            addCriterion("id_number <>", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberGreaterThan(String value) {
            addCriterion("id_number >", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberGreaterThanOrEqualTo(String value) {
            addCriterion("id_number >=", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberLessThan(String value) {
            addCriterion("id_number <", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberLessThanOrEqualTo(String value) {
            addCriterion("id_number <=", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberLike(String value) {
            addCriterion("id_number like", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberNotLike(String value) {
            addCriterion("id_number not like", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberIn(List<String> values) {
            addCriterion("id_number in", values, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberNotIn(List<String> values) {
            addCriterion("id_number not in", values, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberBetween(String value1, String value2) {
            addCriterion("id_number between", value1, value2, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberNotBetween(String value1, String value2) {
            addCriterion("id_number not between", value1, value2, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberTypeIsNull() {
            addCriterion("id_number_type is null");
            return (Criteria) this;
        }

        public Criteria andIdNumberTypeIsNotNull() {
            addCriterion("id_number_type is not null");
            return (Criteria) this;
        }

        public Criteria andIdNumberTypeEqualTo(String value) {
            addCriterion("id_number_type =", value, "idNumberType");
            return (Criteria) this;
        }

        public Criteria andIdNumberTypeNotEqualTo(String value) {
            addCriterion("id_number_type <>", value, "idNumberType");
            return (Criteria) this;
        }

        public Criteria andIdNumberTypeGreaterThan(String value) {
            addCriterion("id_number_type >", value, "idNumberType");
            return (Criteria) this;
        }

        public Criteria andIdNumberTypeGreaterThanOrEqualTo(String value) {
            addCriterion("id_number_type >=", value, "idNumberType");
            return (Criteria) this;
        }

        public Criteria andIdNumberTypeLessThan(String value) {
            addCriterion("id_number_type <", value, "idNumberType");
            return (Criteria) this;
        }

        public Criteria andIdNumberTypeLessThanOrEqualTo(String value) {
            addCriterion("id_number_type <=", value, "idNumberType");
            return (Criteria) this;
        }

        public Criteria andIdNumberTypeLike(String value) {
            addCriterion("id_number_type like", value, "idNumberType");
            return (Criteria) this;
        }

        public Criteria andIdNumberTypeNotLike(String value) {
            addCriterion("id_number_type not like", value, "idNumberType");
            return (Criteria) this;
        }

        public Criteria andIdNumberTypeIn(List<String> values) {
            addCriterion("id_number_type in", values, "idNumberType");
            return (Criteria) this;
        }

        public Criteria andIdNumberTypeNotIn(List<String> values) {
            addCriterion("id_number_type not in", values, "idNumberType");
            return (Criteria) this;
        }

        public Criteria andIdNumberTypeBetween(String value1, String value2) {
            addCriterion("id_number_type between", value1, value2, "idNumberType");
            return (Criteria) this;
        }

        public Criteria andIdNumberTypeNotBetween(String value1, String value2) {
            addCriterion("id_number_type not between", value1, value2, "idNumberType");
            return (Criteria) this;
        }

        public Criteria andMeLevelIsNull() {
            addCriterion("me_level is null");
            return (Criteria) this;
        }

        public Criteria andMeLevelIsNotNull() {
            addCriterion("me_level is not null");
            return (Criteria) this;
        }

        public Criteria andMeLevelEqualTo(String value) {
            addCriterion("me_level =", value, "meLevel");
            return (Criteria) this;
        }

        public Criteria andMeLevelNotEqualTo(String value) {
            addCriterion("me_level <>", value, "meLevel");
            return (Criteria) this;
        }

        public Criteria andMeLevelGreaterThan(String value) {
            addCriterion("me_level >", value, "meLevel");
            return (Criteria) this;
        }

        public Criteria andMeLevelGreaterThanOrEqualTo(String value) {
            addCriterion("me_level >=", value, "meLevel");
            return (Criteria) this;
        }

        public Criteria andMeLevelLessThan(String value) {
            addCriterion("me_level <", value, "meLevel");
            return (Criteria) this;
        }

        public Criteria andMeLevelLessThanOrEqualTo(String value) {
            addCriterion("me_level <=", value, "meLevel");
            return (Criteria) this;
        }

        public Criteria andMeLevelLike(String value) {
            addCriterion("me_level like", value, "meLevel");
            return (Criteria) this;
        }

        public Criteria andMeLevelNotLike(String value) {
            addCriterion("me_level not like", value, "meLevel");
            return (Criteria) this;
        }

        public Criteria andMeLevelIn(List<String> values) {
            addCriterion("me_level in", values, "meLevel");
            return (Criteria) this;
        }

        public Criteria andMeLevelNotIn(List<String> values) {
            addCriterion("me_level not in", values, "meLevel");
            return (Criteria) this;
        }

        public Criteria andMeLevelBetween(String value1, String value2) {
            addCriterion("me_level between", value1, value2, "meLevel");
            return (Criteria) this;
        }

        public Criteria andMeLevelNotBetween(String value1, String value2) {
            addCriterion("me_level not between", value1, value2, "meLevel");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAccountExpiredIsNull() {
            addCriterion("account_expired is null");
            return (Criteria) this;
        }

        public Criteria andAccountExpiredIsNotNull() {
            addCriterion("account_expired is not null");
            return (Criteria) this;
        }

        public Criteria andAccountExpiredEqualTo(Boolean value) {
            addCriterion("account_expired =", value, "accountExpired");
            return (Criteria) this;
        }

        public Criteria andAccountExpiredNotEqualTo(Boolean value) {
            addCriterion("account_expired <>", value, "accountExpired");
            return (Criteria) this;
        }

        public Criteria andAccountExpiredGreaterThan(Boolean value) {
            addCriterion("account_expired >", value, "accountExpired");
            return (Criteria) this;
        }

        public Criteria andAccountExpiredGreaterThanOrEqualTo(Boolean value) {
            addCriterion("account_expired >=", value, "accountExpired");
            return (Criteria) this;
        }

        public Criteria andAccountExpiredLessThan(Boolean value) {
            addCriterion("account_expired <", value, "accountExpired");
            return (Criteria) this;
        }

        public Criteria andAccountExpiredLessThanOrEqualTo(Boolean value) {
            addCriterion("account_expired <=", value, "accountExpired");
            return (Criteria) this;
        }

        public Criteria andAccountExpiredIn(List<Boolean> values) {
            addCriterion("account_expired in", values, "accountExpired");
            return (Criteria) this;
        }

        public Criteria andAccountExpiredNotIn(List<Boolean> values) {
            addCriterion("account_expired not in", values, "accountExpired");
            return (Criteria) this;
        }

        public Criteria andAccountExpiredBetween(Boolean value1, Boolean value2) {
            addCriterion("account_expired between", value1, value2, "accountExpired");
            return (Criteria) this;
        }

        public Criteria andAccountExpiredNotBetween(Boolean value1, Boolean value2) {
            addCriterion("account_expired not between", value1, value2, "accountExpired");
            return (Criteria) this;
        }

        public Criteria andCredentialsNonExpiredIsNull() {
            addCriterion("credentials_non_expired is null");
            return (Criteria) this;
        }

        public Criteria andCredentialsNonExpiredIsNotNull() {
            addCriterion("credentials_non_expired is not null");
            return (Criteria) this;
        }

        public Criteria andCredentialsNonExpiredEqualTo(Boolean value) {
            addCriterion("credentials_non_expired =", value, "credentialsNonExpired");
            return (Criteria) this;
        }

        public Criteria andCredentialsNonExpiredNotEqualTo(Boolean value) {
            addCriterion("credentials_non_expired <>", value, "credentialsNonExpired");
            return (Criteria) this;
        }

        public Criteria andCredentialsNonExpiredGreaterThan(Boolean value) {
            addCriterion("credentials_non_expired >", value, "credentialsNonExpired");
            return (Criteria) this;
        }

        public Criteria andCredentialsNonExpiredGreaterThanOrEqualTo(Boolean value) {
            addCriterion("credentials_non_expired >=", value, "credentialsNonExpired");
            return (Criteria) this;
        }

        public Criteria andCredentialsNonExpiredLessThan(Boolean value) {
            addCriterion("credentials_non_expired <", value, "credentialsNonExpired");
            return (Criteria) this;
        }

        public Criteria andCredentialsNonExpiredLessThanOrEqualTo(Boolean value) {
            addCriterion("credentials_non_expired <=", value, "credentialsNonExpired");
            return (Criteria) this;
        }

        public Criteria andCredentialsNonExpiredIn(List<Boolean> values) {
            addCriterion("credentials_non_expired in", values, "credentialsNonExpired");
            return (Criteria) this;
        }

        public Criteria andCredentialsNonExpiredNotIn(List<Boolean> values) {
            addCriterion("credentials_non_expired not in", values, "credentialsNonExpired");
            return (Criteria) this;
        }

        public Criteria andCredentialsNonExpiredBetween(Boolean value1, Boolean value2) {
            addCriterion("credentials_non_expired between", value1, value2, "credentialsNonExpired");
            return (Criteria) this;
        }

        public Criteria andCredentialsNonExpiredNotBetween(Boolean value1, Boolean value2) {
            addCriterion("credentials_non_expired not between", value1, value2, "credentialsNonExpired");
            return (Criteria) this;
        }

        public Criteria andAccountNonLockedIsNull() {
            addCriterion("account_non_locked is null");
            return (Criteria) this;
        }

        public Criteria andAccountNonLockedIsNotNull() {
            addCriterion("account_non_locked is not null");
            return (Criteria) this;
        }

        public Criteria andAccountNonLockedEqualTo(Boolean value) {
            addCriterion("account_non_locked =", value, "accountNonLocked");
            return (Criteria) this;
        }

        public Criteria andAccountNonLockedNotEqualTo(Boolean value) {
            addCriterion("account_non_locked <>", value, "accountNonLocked");
            return (Criteria) this;
        }

        public Criteria andAccountNonLockedGreaterThan(Boolean value) {
            addCriterion("account_non_locked >", value, "accountNonLocked");
            return (Criteria) this;
        }

        public Criteria andAccountNonLockedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("account_non_locked >=", value, "accountNonLocked");
            return (Criteria) this;
        }

        public Criteria andAccountNonLockedLessThan(Boolean value) {
            addCriterion("account_non_locked <", value, "accountNonLocked");
            return (Criteria) this;
        }

        public Criteria andAccountNonLockedLessThanOrEqualTo(Boolean value) {
            addCriterion("account_non_locked <=", value, "accountNonLocked");
            return (Criteria) this;
        }

        public Criteria andAccountNonLockedIn(List<Boolean> values) {
            addCriterion("account_non_locked in", values, "accountNonLocked");
            return (Criteria) this;
        }

        public Criteria andAccountNonLockedNotIn(List<Boolean> values) {
            addCriterion("account_non_locked not in", values, "accountNonLocked");
            return (Criteria) this;
        }

        public Criteria andAccountNonLockedBetween(Boolean value1, Boolean value2) {
            addCriterion("account_non_locked between", value1, value2, "accountNonLocked");
            return (Criteria) this;
        }

        public Criteria andAccountNonLockedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("account_non_locked not between", value1, value2, "accountNonLocked");
            return (Criteria) this;
        }

        public Criteria andBossIsNull() {
            addCriterion("boss is null");
            return (Criteria) this;
        }

        public Criteria andBossIsNotNull() {
            addCriterion("boss is not null");
            return (Criteria) this;
        }

        public Criteria andBossEqualTo(String value) {
            addCriterion("boss =", value, "boss");
            return (Criteria) this;
        }

        public Criteria andBossNotEqualTo(String value) {
            addCriterion("boss <>", value, "boss");
            return (Criteria) this;
        }

        public Criteria andBossGreaterThan(String value) {
            addCriterion("boss >", value, "boss");
            return (Criteria) this;
        }

        public Criteria andBossGreaterThanOrEqualTo(String value) {
            addCriterion("boss >=", value, "boss");
            return (Criteria) this;
        }

        public Criteria andBossLessThan(String value) {
            addCriterion("boss <", value, "boss");
            return (Criteria) this;
        }

        public Criteria andBossLessThanOrEqualTo(String value) {
            addCriterion("boss <=", value, "boss");
            return (Criteria) this;
        }

        public Criteria andBossLike(String value) {
            addCriterion("boss like", value, "boss");
            return (Criteria) this;
        }

        public Criteria andBossNotLike(String value) {
            addCriterion("boss not like", value, "boss");
            return (Criteria) this;
        }

        public Criteria andBossIn(List<String> values) {
            addCriterion("boss in", values, "boss");
            return (Criteria) this;
        }

        public Criteria andBossNotIn(List<String> values) {
            addCriterion("boss not in", values, "boss");
            return (Criteria) this;
        }

        public Criteria andBossBetween(String value1, String value2) {
            addCriterion("boss between", value1, value2, "boss");
            return (Criteria) this;
        }

        public Criteria andBossNotBetween(String value1, String value2) {
            addCriterion("boss not between", value1, value2, "boss");
            return (Criteria) this;
        }

        public Criteria andBossLevelIsNull() {
            addCriterion("boss_level is null");
            return (Criteria) this;
        }

        public Criteria andBossLevelIsNotNull() {
            addCriterion("boss_level is not null");
            return (Criteria) this;
        }

        public Criteria andBossLevelEqualTo(String value) {
            addCriterion("boss_level =", value, "bossLevel");
            return (Criteria) this;
        }

        public Criteria andBossLevelNotEqualTo(String value) {
            addCriterion("boss_level <>", value, "bossLevel");
            return (Criteria) this;
        }

        public Criteria andBossLevelGreaterThan(String value) {
            addCriterion("boss_level >", value, "bossLevel");
            return (Criteria) this;
        }

        public Criteria andBossLevelGreaterThanOrEqualTo(String value) {
            addCriterion("boss_level >=", value, "bossLevel");
            return (Criteria) this;
        }

        public Criteria andBossLevelLessThan(String value) {
            addCriterion("boss_level <", value, "bossLevel");
            return (Criteria) this;
        }

        public Criteria andBossLevelLessThanOrEqualTo(String value) {
            addCriterion("boss_level <=", value, "bossLevel");
            return (Criteria) this;
        }

        public Criteria andBossLevelLike(String value) {
            addCriterion("boss_level like", value, "bossLevel");
            return (Criteria) this;
        }

        public Criteria andBossLevelNotLike(String value) {
            addCriterion("boss_level not like", value, "bossLevel");
            return (Criteria) this;
        }

        public Criteria andBossLevelIn(List<String> values) {
            addCriterion("boss_level in", values, "bossLevel");
            return (Criteria) this;
        }

        public Criteria andBossLevelNotIn(List<String> values) {
            addCriterion("boss_level not in", values, "bossLevel");
            return (Criteria) this;
        }

        public Criteria andBossLevelBetween(String value1, String value2) {
            addCriterion("boss_level between", value1, value2, "bossLevel");
            return (Criteria) this;
        }

        public Criteria andBossLevelNotBetween(String value1, String value2) {
            addCriterion("boss_level not between", value1, value2, "bossLevel");
            return (Criteria) this;
        }

        public Criteria andBossPhoneIsNull() {
            addCriterion("boss_phone is null");
            return (Criteria) this;
        }

        public Criteria andBossPhoneIsNotNull() {
            addCriterion("boss_phone is not null");
            return (Criteria) this;
        }

        public Criteria andBossPhoneEqualTo(String value) {
            addCriterion("boss_phone =", value, "bossPhone");
            return (Criteria) this;
        }

        public Criteria andBossPhoneNotEqualTo(String value) {
            addCriterion("boss_phone <>", value, "bossPhone");
            return (Criteria) this;
        }

        public Criteria andBossPhoneGreaterThan(String value) {
            addCriterion("boss_phone >", value, "bossPhone");
            return (Criteria) this;
        }

        public Criteria andBossPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("boss_phone >=", value, "bossPhone");
            return (Criteria) this;
        }

        public Criteria andBossPhoneLessThan(String value) {
            addCriterion("boss_phone <", value, "bossPhone");
            return (Criteria) this;
        }

        public Criteria andBossPhoneLessThanOrEqualTo(String value) {
            addCriterion("boss_phone <=", value, "bossPhone");
            return (Criteria) this;
        }

        public Criteria andBossPhoneLike(String value) {
            addCriterion("boss_phone like", value, "bossPhone");
            return (Criteria) this;
        }

        public Criteria andBossPhoneNotLike(String value) {
            addCriterion("boss_phone not like", value, "bossPhone");
            return (Criteria) this;
        }

        public Criteria andBossPhoneIn(List<String> values) {
            addCriterion("boss_phone in", values, "bossPhone");
            return (Criteria) this;
        }

        public Criteria andBossPhoneNotIn(List<String> values) {
            addCriterion("boss_phone not in", values, "bossPhone");
            return (Criteria) this;
        }

        public Criteria andBossPhoneBetween(String value1, String value2) {
            addCriterion("boss_phone between", value1, value2, "bossPhone");
            return (Criteria) this;
        }

        public Criteria andBossPhoneNotBetween(String value1, String value2) {
            addCriterion("boss_phone not between", value1, value2, "bossPhone");
            return (Criteria) this;
        }

        public Criteria andBossMobileIsNull() {
            addCriterion("boss_mobile is null");
            return (Criteria) this;
        }

        public Criteria andBossMobileIsNotNull() {
            addCriterion("boss_mobile is not null");
            return (Criteria) this;
        }

        public Criteria andBossMobileEqualTo(String value) {
            addCriterion("boss_mobile =", value, "bossMobile");
            return (Criteria) this;
        }

        public Criteria andBossMobileNotEqualTo(String value) {
            addCriterion("boss_mobile <>", value, "bossMobile");
            return (Criteria) this;
        }

        public Criteria andBossMobileGreaterThan(String value) {
            addCriterion("boss_mobile >", value, "bossMobile");
            return (Criteria) this;
        }

        public Criteria andBossMobileGreaterThanOrEqualTo(String value) {
            addCriterion("boss_mobile >=", value, "bossMobile");
            return (Criteria) this;
        }

        public Criteria andBossMobileLessThan(String value) {
            addCriterion("boss_mobile <", value, "bossMobile");
            return (Criteria) this;
        }

        public Criteria andBossMobileLessThanOrEqualTo(String value) {
            addCriterion("boss_mobile <=", value, "bossMobile");
            return (Criteria) this;
        }

        public Criteria andBossMobileLike(String value) {
            addCriterion("boss_mobile like", value, "bossMobile");
            return (Criteria) this;
        }

        public Criteria andBossMobileNotLike(String value) {
            addCriterion("boss_mobile not like", value, "bossMobile");
            return (Criteria) this;
        }

        public Criteria andBossMobileIn(List<String> values) {
            addCriterion("boss_mobile in", values, "bossMobile");
            return (Criteria) this;
        }

        public Criteria andBossMobileNotIn(List<String> values) {
            addCriterion("boss_mobile not in", values, "bossMobile");
            return (Criteria) this;
        }

        public Criteria andBossMobileBetween(String value1, String value2) {
            addCriterion("boss_mobile between", value1, value2, "bossMobile");
            return (Criteria) this;
        }

        public Criteria andBossMobileNotBetween(String value1, String value2) {
            addCriterion("boss_mobile not between", value1, value2, "bossMobile");
            return (Criteria) this;
        }

        public Criteria andExpirationDateIsNull() {
            addCriterion("expiration_date is null");
            return (Criteria) this;
        }

        public Criteria andExpirationDateIsNotNull() {
            addCriterion("expiration_date is not null");
            return (Criteria) this;
        }

        public Criteria andExpirationDateEqualTo(Date value) {
            addCriterion("expiration_date =", value, "expirationDate");
            return (Criteria) this;
        }

        public Criteria andExpirationDateNotEqualTo(Date value) {
            addCriterion("expiration_date <>", value, "expirationDate");
            return (Criteria) this;
        }

        public Criteria andExpirationDateGreaterThan(Date value) {
            addCriterion("expiration_date >", value, "expirationDate");
            return (Criteria) this;
        }

        public Criteria andExpirationDateGreaterThanOrEqualTo(Date value) {
            addCriterion("expiration_date >=", value, "expirationDate");
            return (Criteria) this;
        }

        public Criteria andExpirationDateLessThan(Date value) {
            addCriterion("expiration_date <", value, "expirationDate");
            return (Criteria) this;
        }

        public Criteria andExpirationDateLessThanOrEqualTo(Date value) {
            addCriterion("expiration_date <=", value, "expirationDate");
            return (Criteria) this;
        }

        public Criteria andExpirationDateIn(List<Date> values) {
            addCriterion("expiration_date in", values, "expirationDate");
            return (Criteria) this;
        }

        public Criteria andExpirationDateNotIn(List<Date> values) {
            addCriterion("expiration_date not in", values, "expirationDate");
            return (Criteria) this;
        }

        public Criteria andExpirationDateBetween(Date value1, Date value2) {
            addCriterion("expiration_date between", value1, value2, "expirationDate");
            return (Criteria) this;
        }

        public Criteria andExpirationDateNotBetween(Date value1, Date value2) {
            addCriterion("expiration_date not between", value1, value2, "expirationDate");
            return (Criteria) this;
        }

        public Criteria andPasswordQuestionIsNull() {
            addCriterion("password_question is null");
            return (Criteria) this;
        }

        public Criteria andPasswordQuestionIsNotNull() {
            addCriterion("password_question is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordQuestionEqualTo(String value) {
            addCriterion("password_question =", value, "passwordQuestion");
            return (Criteria) this;
        }

        public Criteria andPasswordQuestionNotEqualTo(String value) {
            addCriterion("password_question <>", value, "passwordQuestion");
            return (Criteria) this;
        }

        public Criteria andPasswordQuestionGreaterThan(String value) {
            addCriterion("password_question >", value, "passwordQuestion");
            return (Criteria) this;
        }

        public Criteria andPasswordQuestionGreaterThanOrEqualTo(String value) {
            addCriterion("password_question >=", value, "passwordQuestion");
            return (Criteria) this;
        }

        public Criteria andPasswordQuestionLessThan(String value) {
            addCriterion("password_question <", value, "passwordQuestion");
            return (Criteria) this;
        }

        public Criteria andPasswordQuestionLessThanOrEqualTo(String value) {
            addCriterion("password_question <=", value, "passwordQuestion");
            return (Criteria) this;
        }

        public Criteria andPasswordQuestionLike(String value) {
            addCriterion("password_question like", value, "passwordQuestion");
            return (Criteria) this;
        }

        public Criteria andPasswordQuestionNotLike(String value) {
            addCriterion("password_question not like", value, "passwordQuestion");
            return (Criteria) this;
        }

        public Criteria andPasswordQuestionIn(List<String> values) {
            addCriterion("password_question in", values, "passwordQuestion");
            return (Criteria) this;
        }

        public Criteria andPasswordQuestionNotIn(List<String> values) {
            addCriterion("password_question not in", values, "passwordQuestion");
            return (Criteria) this;
        }

        public Criteria andPasswordQuestionBetween(String value1, String value2) {
            addCriterion("password_question between", value1, value2, "passwordQuestion");
            return (Criteria) this;
        }

        public Criteria andPasswordQuestionNotBetween(String value1, String value2) {
            addCriterion("password_question not between", value1, value2, "passwordQuestion");
            return (Criteria) this;
        }

        public Criteria andPasswordAnswerIsNull() {
            addCriterion("password_answer is null");
            return (Criteria) this;
        }

        public Criteria andPasswordAnswerIsNotNull() {
            addCriterion("password_answer is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordAnswerEqualTo(String value) {
            addCriterion("password_answer =", value, "passwordAnswer");
            return (Criteria) this;
        }

        public Criteria andPasswordAnswerNotEqualTo(String value) {
            addCriterion("password_answer <>", value, "passwordAnswer");
            return (Criteria) this;
        }

        public Criteria andPasswordAnswerGreaterThan(String value) {
            addCriterion("password_answer >", value, "passwordAnswer");
            return (Criteria) this;
        }

        public Criteria andPasswordAnswerGreaterThanOrEqualTo(String value) {
            addCriterion("password_answer >=", value, "passwordAnswer");
            return (Criteria) this;
        }

        public Criteria andPasswordAnswerLessThan(String value) {
            addCriterion("password_answer <", value, "passwordAnswer");
            return (Criteria) this;
        }

        public Criteria andPasswordAnswerLessThanOrEqualTo(String value) {
            addCriterion("password_answer <=", value, "passwordAnswer");
            return (Criteria) this;
        }

        public Criteria andPasswordAnswerLike(String value) {
            addCriterion("password_answer like", value, "passwordAnswer");
            return (Criteria) this;
        }

        public Criteria andPasswordAnswerNotLike(String value) {
            addCriterion("password_answer not like", value, "passwordAnswer");
            return (Criteria) this;
        }

        public Criteria andPasswordAnswerIn(List<String> values) {
            addCriterion("password_answer in", values, "passwordAnswer");
            return (Criteria) this;
        }

        public Criteria andPasswordAnswerNotIn(List<String> values) {
            addCriterion("password_answer not in", values, "passwordAnswer");
            return (Criteria) this;
        }

        public Criteria andPasswordAnswerBetween(String value1, String value2) {
            addCriterion("password_answer between", value1, value2, "passwordAnswer");
            return (Criteria) this;
        }

        public Criteria andPasswordAnswerNotBetween(String value1, String value2) {
            addCriterion("password_answer not between", value1, value2, "passwordAnswer");
            return (Criteria) this;
        }

        public Criteria andLastLoginIsNull() {
            addCriterion("last_login is null");
            return (Criteria) this;
        }

        public Criteria andLastLoginIsNotNull() {
            addCriterion("last_login is not null");
            return (Criteria) this;
        }

        public Criteria andLastLoginEqualTo(Date value) {
            addCriterion("last_login =", value, "lastLogin");
            return (Criteria) this;
        }

        public Criteria andLastLoginNotEqualTo(Date value) {
            addCriterion("last_login <>", value, "lastLogin");
            return (Criteria) this;
        }

        public Criteria andLastLoginGreaterThan(Date value) {
            addCriterion("last_login >", value, "lastLogin");
            return (Criteria) this;
        }

        public Criteria andLastLoginGreaterThanOrEqualTo(Date value) {
            addCriterion("last_login >=", value, "lastLogin");
            return (Criteria) this;
        }

        public Criteria andLastLoginLessThan(Date value) {
            addCriterion("last_login <", value, "lastLogin");
            return (Criteria) this;
        }

        public Criteria andLastLoginLessThanOrEqualTo(Date value) {
            addCriterion("last_login <=", value, "lastLogin");
            return (Criteria) this;
        }

        public Criteria andLastLoginIn(List<Date> values) {
            addCriterion("last_login in", values, "lastLogin");
            return (Criteria) this;
        }

        public Criteria andLastLoginNotIn(List<Date> values) {
            addCriterion("last_login not in", values, "lastLogin");
            return (Criteria) this;
        }

        public Criteria andLastLoginBetween(Date value1, Date value2) {
            addCriterion("last_login between", value1, value2, "lastLogin");
            return (Criteria) this;
        }

        public Criteria andLastLoginNotBetween(Date value1, Date value2) {
            addCriterion("last_login not between", value1, value2, "lastLogin");
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