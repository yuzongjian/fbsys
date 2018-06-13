package com.buoy.entity;

import java.util.ArrayList;
import java.util.List;

public class CurrentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CurrentExample() {
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

        public Criteria andCIdIsNull() {
            addCriterion("c_id is null");
            return (Criteria) this;
        }

        public Criteria andCIdIsNotNull() {
            addCriterion("c_id is not null");
            return (Criteria) this;
        }

        public Criteria andCIdEqualTo(Integer value) {
            addCriterion("c_id =", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdNotEqualTo(Integer value) {
            addCriterion("c_id <>", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdGreaterThan(Integer value) {
            addCriterion("c_id >", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("c_id >=", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdLessThan(Integer value) {
            addCriterion("c_id <", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdLessThanOrEqualTo(Integer value) {
            addCriterion("c_id <=", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdIn(List<Integer> values) {
            addCriterion("c_id in", values, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdNotIn(List<Integer> values) {
            addCriterion("c_id not in", values, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdBetween(Integer value1, Integer value2) {
            addCriterion("c_id between", value1, value2, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdNotBetween(Integer value1, Integer value2) {
            addCriterion("c_id not between", value1, value2, "cId");
            return (Criteria) this;
        }

        public Criteria andDateIsNull() {
            addCriterion("date is null");
            return (Criteria) this;
        }

        public Criteria andDateIsNotNull() {
            addCriterion("date is not null");
            return (Criteria) this;
        }

        public Criteria andDateEqualTo(String value) {
            addCriterion("date =", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotEqualTo(String value) {
            addCriterion("date <>", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThan(String value) {
            addCriterion("date >", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThanOrEqualTo(String value) {
            addCriterion("date >=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThan(String value) {
            addCriterion("date <", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThanOrEqualTo(String value) {
            addCriterion("date <=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLike(String value) {
            addCriterion("date like", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotLike(String value) {
            addCriterion("date not like", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateIn(List<String> values) {
            addCriterion("date in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotIn(List<String> values) {
            addCriterion("date not in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateBetween(String value1, String value2) {
            addCriterion("date between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotBetween(String value1, String value2) {
            addCriterion("date not between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andCBuoyidIsNull() {
            addCriterion("c_buoyid is null");
            return (Criteria) this;
        }

        public Criteria andCBuoyidIsNotNull() {
            addCriterion("c_buoyid is not null");
            return (Criteria) this;
        }

        public Criteria andCBuoyidEqualTo(String value) {
            addCriterion("c_buoyid =", value, "cBuoyid");
            return (Criteria) this;
        }

        public Criteria andCBuoyidNotEqualTo(String value) {
            addCriterion("c_buoyid <>", value, "cBuoyid");
            return (Criteria) this;
        }

        public Criteria andCBuoyidGreaterThan(String value) {
            addCriterion("c_buoyid >", value, "cBuoyid");
            return (Criteria) this;
        }

        public Criteria andCBuoyidGreaterThanOrEqualTo(String value) {
            addCriterion("c_buoyid >=", value, "cBuoyid");
            return (Criteria) this;
        }

        public Criteria andCBuoyidLessThan(String value) {
            addCriterion("c_buoyid <", value, "cBuoyid");
            return (Criteria) this;
        }

        public Criteria andCBuoyidLessThanOrEqualTo(String value) {
            addCriterion("c_buoyid <=", value, "cBuoyid");
            return (Criteria) this;
        }

        public Criteria andCBuoyidLike(String value) {
            addCriterion("c_buoyid like", value, "cBuoyid");
            return (Criteria) this;
        }

        public Criteria andCBuoyidNotLike(String value) {
            addCriterion("c_buoyid not like", value, "cBuoyid");
            return (Criteria) this;
        }

        public Criteria andCBuoyidIn(List<String> values) {
            addCriterion("c_buoyid in", values, "cBuoyid");
            return (Criteria) this;
        }

        public Criteria andCBuoyidNotIn(List<String> values) {
            addCriterion("c_buoyid not in", values, "cBuoyid");
            return (Criteria) this;
        }

        public Criteria andCBuoyidBetween(String value1, String value2) {
            addCriterion("c_buoyid between", value1, value2, "cBuoyid");
            return (Criteria) this;
        }

        public Criteria andCBuoyidNotBetween(String value1, String value2) {
            addCriterion("c_buoyid not between", value1, value2, "cBuoyid");
            return (Criteria) this;
        }

        public Criteria andCSpeed1IsNull() {
            addCriterion("c_speed1 is null");
            return (Criteria) this;
        }

        public Criteria andCSpeed1IsNotNull() {
            addCriterion("c_speed1 is not null");
            return (Criteria) this;
        }

        public Criteria andCSpeed1EqualTo(String value) {
            addCriterion("c_speed1 =", value, "cSpeed1");
            return (Criteria) this;
        }

        public Criteria andCSpeed1NotEqualTo(String value) {
            addCriterion("c_speed1 <>", value, "cSpeed1");
            return (Criteria) this;
        }

        public Criteria andCSpeed1GreaterThan(String value) {
            addCriterion("c_speed1 >", value, "cSpeed1");
            return (Criteria) this;
        }

        public Criteria andCSpeed1GreaterThanOrEqualTo(String value) {
            addCriterion("c_speed1 >=", value, "cSpeed1");
            return (Criteria) this;
        }

        public Criteria andCSpeed1LessThan(String value) {
            addCriterion("c_speed1 <", value, "cSpeed1");
            return (Criteria) this;
        }

        public Criteria andCSpeed1LessThanOrEqualTo(String value) {
            addCriterion("c_speed1 <=", value, "cSpeed1");
            return (Criteria) this;
        }

        public Criteria andCSpeed1Like(String value) {
            addCriterion("c_speed1 like", value, "cSpeed1");
            return (Criteria) this;
        }

        public Criteria andCSpeed1NotLike(String value) {
            addCriterion("c_speed1 not like", value, "cSpeed1");
            return (Criteria) this;
        }

        public Criteria andCSpeed1In(List<String> values) {
            addCriterion("c_speed1 in", values, "cSpeed1");
            return (Criteria) this;
        }

        public Criteria andCSpeed1NotIn(List<String> values) {
            addCriterion("c_speed1 not in", values, "cSpeed1");
            return (Criteria) this;
        }

        public Criteria andCSpeed1Between(String value1, String value2) {
            addCriterion("c_speed1 between", value1, value2, "cSpeed1");
            return (Criteria) this;
        }

        public Criteria andCSpeed1NotBetween(String value1, String value2) {
            addCriterion("c_speed1 not between", value1, value2, "cSpeed1");
            return (Criteria) this;
        }

        public Criteria andCTo1IsNull() {
            addCriterion("c_to1 is null");
            return (Criteria) this;
        }

        public Criteria andCTo1IsNotNull() {
            addCriterion("c_to1 is not null");
            return (Criteria) this;
        }

        public Criteria andCTo1EqualTo(String value) {
            addCriterion("c_to1 =", value, "cTo1");
            return (Criteria) this;
        }

        public Criteria andCTo1NotEqualTo(String value) {
            addCriterion("c_to1 <>", value, "cTo1");
            return (Criteria) this;
        }

        public Criteria andCTo1GreaterThan(String value) {
            addCriterion("c_to1 >", value, "cTo1");
            return (Criteria) this;
        }

        public Criteria andCTo1GreaterThanOrEqualTo(String value) {
            addCriterion("c_to1 >=", value, "cTo1");
            return (Criteria) this;
        }

        public Criteria andCTo1LessThan(String value) {
            addCriterion("c_to1 <", value, "cTo1");
            return (Criteria) this;
        }

        public Criteria andCTo1LessThanOrEqualTo(String value) {
            addCriterion("c_to1 <=", value, "cTo1");
            return (Criteria) this;
        }

        public Criteria andCTo1Like(String value) {
            addCriterion("c_to1 like", value, "cTo1");
            return (Criteria) this;
        }

        public Criteria andCTo1NotLike(String value) {
            addCriterion("c_to1 not like", value, "cTo1");
            return (Criteria) this;
        }

        public Criteria andCTo1In(List<String> values) {
            addCriterion("c_to1 in", values, "cTo1");
            return (Criteria) this;
        }

        public Criteria andCTo1NotIn(List<String> values) {
            addCriterion("c_to1 not in", values, "cTo1");
            return (Criteria) this;
        }

        public Criteria andCTo1Between(String value1, String value2) {
            addCriterion("c_to1 between", value1, value2, "cTo1");
            return (Criteria) this;
        }

        public Criteria andCTo1NotBetween(String value1, String value2) {
            addCriterion("c_to1 not between", value1, value2, "cTo1");
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