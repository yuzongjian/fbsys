package com.buoy.entity;

import java.util.ArrayList;
import java.util.List;

public class LasttimeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LasttimeExample() {
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

        public Criteria andLtIdIsNull() {
            addCriterion("lt_id is null");
            return (Criteria) this;
        }

        public Criteria andLtIdIsNotNull() {
            addCriterion("lt_id is not null");
            return (Criteria) this;
        }

        public Criteria andLtIdEqualTo(Integer value) {
            addCriterion("lt_id =", value, "ltId");
            return (Criteria) this;
        }

        public Criteria andLtIdNotEqualTo(Integer value) {
            addCriterion("lt_id <>", value, "ltId");
            return (Criteria) this;
        }

        public Criteria andLtIdGreaterThan(Integer value) {
            addCriterion("lt_id >", value, "ltId");
            return (Criteria) this;
        }

        public Criteria andLtIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("lt_id >=", value, "ltId");
            return (Criteria) this;
        }

        public Criteria andLtIdLessThan(Integer value) {
            addCriterion("lt_id <", value, "ltId");
            return (Criteria) this;
        }

        public Criteria andLtIdLessThanOrEqualTo(Integer value) {
            addCriterion("lt_id <=", value, "ltId");
            return (Criteria) this;
        }

        public Criteria andLtIdIn(List<Integer> values) {
            addCriterion("lt_id in", values, "ltId");
            return (Criteria) this;
        }

        public Criteria andLtIdNotIn(List<Integer> values) {
            addCriterion("lt_id not in", values, "ltId");
            return (Criteria) this;
        }

        public Criteria andLtIdBetween(Integer value1, Integer value2) {
            addCriterion("lt_id between", value1, value2, "ltId");
            return (Criteria) this;
        }

        public Criteria andLtIdNotBetween(Integer value1, Integer value2) {
            addCriterion("lt_id not between", value1, value2, "ltId");
            return (Criteria) this;
        }

        public Criteria andLtBuoyIsNull() {
            addCriterion("lt_buoy is null");
            return (Criteria) this;
        }

        public Criteria andLtBuoyIsNotNull() {
            addCriterion("lt_buoy is not null");
            return (Criteria) this;
        }

        public Criteria andLtBuoyEqualTo(String value) {
            addCriterion("lt_buoy =", value, "ltBuoy");
            return (Criteria) this;
        }

        public Criteria andLtBuoyNotEqualTo(String value) {
            addCriterion("lt_buoy <>", value, "ltBuoy");
            return (Criteria) this;
        }

        public Criteria andLtBuoyGreaterThan(String value) {
            addCriterion("lt_buoy >", value, "ltBuoy");
            return (Criteria) this;
        }

        public Criteria andLtBuoyGreaterThanOrEqualTo(String value) {
            addCriterion("lt_buoy >=", value, "ltBuoy");
            return (Criteria) this;
        }

        public Criteria andLtBuoyLessThan(String value) {
            addCriterion("lt_buoy <", value, "ltBuoy");
            return (Criteria) this;
        }

        public Criteria andLtBuoyLessThanOrEqualTo(String value) {
            addCriterion("lt_buoy <=", value, "ltBuoy");
            return (Criteria) this;
        }

        public Criteria andLtBuoyLike(String value) {
            addCriterion("lt_buoy like", value, "ltBuoy");
            return (Criteria) this;
        }

        public Criteria andLtBuoyNotLike(String value) {
            addCriterion("lt_buoy not like", value, "ltBuoy");
            return (Criteria) this;
        }

        public Criteria andLtBuoyIn(List<String> values) {
            addCriterion("lt_buoy in", values, "ltBuoy");
            return (Criteria) this;
        }

        public Criteria andLtBuoyNotIn(List<String> values) {
            addCriterion("lt_buoy not in", values, "ltBuoy");
            return (Criteria) this;
        }

        public Criteria andLtBuoyBetween(String value1, String value2) {
            addCriterion("lt_buoy between", value1, value2, "ltBuoy");
            return (Criteria) this;
        }

        public Criteria andLtBuoyNotBetween(String value1, String value2) {
            addCriterion("lt_buoy not between", value1, value2, "ltBuoy");
            return (Criteria) this;
        }

        public Criteria andLtDateIsNull() {
            addCriterion("lt_date is null");
            return (Criteria) this;
        }

        public Criteria andLtDateIsNotNull() {
            addCriterion("lt_date is not null");
            return (Criteria) this;
        }

        public Criteria andLtDateEqualTo(String value) {
            addCriterion("lt_date =", value, "ltDate");
            return (Criteria) this;
        }

        public Criteria andLtDateNotEqualTo(String value) {
            addCriterion("lt_date <>", value, "ltDate");
            return (Criteria) this;
        }

        public Criteria andLtDateGreaterThan(String value) {
            addCriterion("lt_date >", value, "ltDate");
            return (Criteria) this;
        }

        public Criteria andLtDateGreaterThanOrEqualTo(String value) {
            addCriterion("lt_date >=", value, "ltDate");
            return (Criteria) this;
        }

        public Criteria andLtDateLessThan(String value) {
            addCriterion("lt_date <", value, "ltDate");
            return (Criteria) this;
        }

        public Criteria andLtDateLessThanOrEqualTo(String value) {
            addCriterion("lt_date <=", value, "ltDate");
            return (Criteria) this;
        }

        public Criteria andLtDateLike(String value) {
            addCriterion("lt_date like", value, "ltDate");
            return (Criteria) this;
        }

        public Criteria andLtDateNotLike(String value) {
            addCriterion("lt_date not like", value, "ltDate");
            return (Criteria) this;
        }

        public Criteria andLtDateIn(List<String> values) {
            addCriterion("lt_date in", values, "ltDate");
            return (Criteria) this;
        }

        public Criteria andLtDateNotIn(List<String> values) {
            addCriterion("lt_date not in", values, "ltDate");
            return (Criteria) this;
        }

        public Criteria andLtDateBetween(String value1, String value2) {
            addCriterion("lt_date between", value1, value2, "ltDate");
            return (Criteria) this;
        }

        public Criteria andLtDateNotBetween(String value1, String value2) {
            addCriterion("lt_date not between", value1, value2, "ltDate");
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