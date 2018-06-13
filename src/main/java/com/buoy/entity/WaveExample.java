package com.buoy.entity;

import java.util.ArrayList;
import java.util.List;

public class WaveExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WaveExample() {
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

        public Criteria andWIdIsNull() {
            addCriterion("w_id is null");
            return (Criteria) this;
        }

        public Criteria andWIdIsNotNull() {
            addCriterion("w_id is not null");
            return (Criteria) this;
        }

        public Criteria andWIdEqualTo(Integer value) {
            addCriterion("w_id =", value, "wId");
            return (Criteria) this;
        }

        public Criteria andWIdNotEqualTo(Integer value) {
            addCriterion("w_id <>", value, "wId");
            return (Criteria) this;
        }

        public Criteria andWIdGreaterThan(Integer value) {
            addCriterion("w_id >", value, "wId");
            return (Criteria) this;
        }

        public Criteria andWIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("w_id >=", value, "wId");
            return (Criteria) this;
        }

        public Criteria andWIdLessThan(Integer value) {
            addCriterion("w_id <", value, "wId");
            return (Criteria) this;
        }

        public Criteria andWIdLessThanOrEqualTo(Integer value) {
            addCriterion("w_id <=", value, "wId");
            return (Criteria) this;
        }

        public Criteria andWIdIn(List<Integer> values) {
            addCriterion("w_id in", values, "wId");
            return (Criteria) this;
        }

        public Criteria andWIdNotIn(List<Integer> values) {
            addCriterion("w_id not in", values, "wId");
            return (Criteria) this;
        }

        public Criteria andWIdBetween(Integer value1, Integer value2) {
            addCriterion("w_id between", value1, value2, "wId");
            return (Criteria) this;
        }

        public Criteria andWIdNotBetween(Integer value1, Integer value2) {
            addCriterion("w_id not between", value1, value2, "wId");
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

        public Criteria andWBuoyidIsNull() {
            addCriterion("w_buoyid is null");
            return (Criteria) this;
        }

        public Criteria andWBuoyidIsNotNull() {
            addCriterion("w_buoyid is not null");
            return (Criteria) this;
        }

        public Criteria andWBuoyidEqualTo(String value) {
            addCriterion("w_buoyid =", value, "wBuoyid");
            return (Criteria) this;
        }

        public Criteria andWBuoyidNotEqualTo(String value) {
            addCriterion("w_buoyid <>", value, "wBuoyid");
            return (Criteria) this;
        }

        public Criteria andWBuoyidGreaterThan(String value) {
            addCriterion("w_buoyid >", value, "wBuoyid");
            return (Criteria) this;
        }

        public Criteria andWBuoyidGreaterThanOrEqualTo(String value) {
            addCriterion("w_buoyid >=", value, "wBuoyid");
            return (Criteria) this;
        }

        public Criteria andWBuoyidLessThan(String value) {
            addCriterion("w_buoyid <", value, "wBuoyid");
            return (Criteria) this;
        }

        public Criteria andWBuoyidLessThanOrEqualTo(String value) {
            addCriterion("w_buoyid <=", value, "wBuoyid");
            return (Criteria) this;
        }

        public Criteria andWBuoyidLike(String value) {
            addCriterion("w_buoyid like", value, "wBuoyid");
            return (Criteria) this;
        }

        public Criteria andWBuoyidNotLike(String value) {
            addCriterion("w_buoyid not like", value, "wBuoyid");
            return (Criteria) this;
        }

        public Criteria andWBuoyidIn(List<String> values) {
            addCriterion("w_buoyid in", values, "wBuoyid");
            return (Criteria) this;
        }

        public Criteria andWBuoyidNotIn(List<String> values) {
            addCriterion("w_buoyid not in", values, "wBuoyid");
            return (Criteria) this;
        }

        public Criteria andWBuoyidBetween(String value1, String value2) {
            addCriterion("w_buoyid between", value1, value2, "wBuoyid");
            return (Criteria) this;
        }

        public Criteria andWBuoyidNotBetween(String value1, String value2) {
            addCriterion("w_buoyid not between", value1, value2, "wBuoyid");
            return (Criteria) this;
        }

        public Criteria andWHighMaxIsNull() {
            addCriterion("w_high_max is null");
            return (Criteria) this;
        }

        public Criteria andWHighMaxIsNotNull() {
            addCriterion("w_high_max is not null");
            return (Criteria) this;
        }

        public Criteria andWHighMaxEqualTo(String value) {
            addCriterion("w_high_max =", value, "wHighMax");
            return (Criteria) this;
        }

        public Criteria andWHighMaxNotEqualTo(String value) {
            addCriterion("w_high_max <>", value, "wHighMax");
            return (Criteria) this;
        }

        public Criteria andWHighMaxGreaterThan(String value) {
            addCriterion("w_high_max >", value, "wHighMax");
            return (Criteria) this;
        }

        public Criteria andWHighMaxGreaterThanOrEqualTo(String value) {
            addCriterion("w_high_max >=", value, "wHighMax");
            return (Criteria) this;
        }

        public Criteria andWHighMaxLessThan(String value) {
            addCriterion("w_high_max <", value, "wHighMax");
            return (Criteria) this;
        }

        public Criteria andWHighMaxLessThanOrEqualTo(String value) {
            addCriterion("w_high_max <=", value, "wHighMax");
            return (Criteria) this;
        }

        public Criteria andWHighMaxLike(String value) {
            addCriterion("w_high_max like", value, "wHighMax");
            return (Criteria) this;
        }

        public Criteria andWHighMaxNotLike(String value) {
            addCriterion("w_high_max not like", value, "wHighMax");
            return (Criteria) this;
        }

        public Criteria andWHighMaxIn(List<String> values) {
            addCriterion("w_high_max in", values, "wHighMax");
            return (Criteria) this;
        }

        public Criteria andWHighMaxNotIn(List<String> values) {
            addCriterion("w_high_max not in", values, "wHighMax");
            return (Criteria) this;
        }

        public Criteria andWHighMaxBetween(String value1, String value2) {
            addCriterion("w_high_max between", value1, value2, "wHighMax");
            return (Criteria) this;
        }

        public Criteria andWHighMaxNotBetween(String value1, String value2) {
            addCriterion("w_high_max not between", value1, value2, "wHighMax");
            return (Criteria) this;
        }

        public Criteria andWHighTenthIsNull() {
            addCriterion("w_high_tenth is null");
            return (Criteria) this;
        }

        public Criteria andWHighTenthIsNotNull() {
            addCriterion("w_high_tenth is not null");
            return (Criteria) this;
        }

        public Criteria andWHighTenthEqualTo(String value) {
            addCriterion("w_high_tenth =", value, "wHighTenth");
            return (Criteria) this;
        }

        public Criteria andWHighTenthNotEqualTo(String value) {
            addCriterion("w_high_tenth <>", value, "wHighTenth");
            return (Criteria) this;
        }

        public Criteria andWHighTenthGreaterThan(String value) {
            addCriterion("w_high_tenth >", value, "wHighTenth");
            return (Criteria) this;
        }

        public Criteria andWHighTenthGreaterThanOrEqualTo(String value) {
            addCriterion("w_high_tenth >=", value, "wHighTenth");
            return (Criteria) this;
        }

        public Criteria andWHighTenthLessThan(String value) {
            addCriterion("w_high_tenth <", value, "wHighTenth");
            return (Criteria) this;
        }

        public Criteria andWHighTenthLessThanOrEqualTo(String value) {
            addCriterion("w_high_tenth <=", value, "wHighTenth");
            return (Criteria) this;
        }

        public Criteria andWHighTenthLike(String value) {
            addCriterion("w_high_tenth like", value, "wHighTenth");
            return (Criteria) this;
        }

        public Criteria andWHighTenthNotLike(String value) {
            addCriterion("w_high_tenth not like", value, "wHighTenth");
            return (Criteria) this;
        }

        public Criteria andWHighTenthIn(List<String> values) {
            addCriterion("w_high_tenth in", values, "wHighTenth");
            return (Criteria) this;
        }

        public Criteria andWHighTenthNotIn(List<String> values) {
            addCriterion("w_high_tenth not in", values, "wHighTenth");
            return (Criteria) this;
        }

        public Criteria andWHighTenthBetween(String value1, String value2) {
            addCriterion("w_high_tenth between", value1, value2, "wHighTenth");
            return (Criteria) this;
        }

        public Criteria andWHighTenthNotBetween(String value1, String value2) {
            addCriterion("w_high_tenth not between", value1, value2, "wHighTenth");
            return (Criteria) this;
        }

        public Criteria andWHighAverageIsNull() {
            addCriterion("w_high_average is null");
            return (Criteria) this;
        }

        public Criteria andWHighAverageIsNotNull() {
            addCriterion("w_high_average is not null");
            return (Criteria) this;
        }

        public Criteria andWHighAverageEqualTo(String value) {
            addCriterion("w_high_average =", value, "wHighAverage");
            return (Criteria) this;
        }

        public Criteria andWHighAverageNotEqualTo(String value) {
            addCriterion("w_high_average <>", value, "wHighAverage");
            return (Criteria) this;
        }

        public Criteria andWHighAverageGreaterThan(String value) {
            addCriterion("w_high_average >", value, "wHighAverage");
            return (Criteria) this;
        }

        public Criteria andWHighAverageGreaterThanOrEqualTo(String value) {
            addCriterion("w_high_average >=", value, "wHighAverage");
            return (Criteria) this;
        }

        public Criteria andWHighAverageLessThan(String value) {
            addCriterion("w_high_average <", value, "wHighAverage");
            return (Criteria) this;
        }

        public Criteria andWHighAverageLessThanOrEqualTo(String value) {
            addCriterion("w_high_average <=", value, "wHighAverage");
            return (Criteria) this;
        }

        public Criteria andWHighAverageLike(String value) {
            addCriterion("w_high_average like", value, "wHighAverage");
            return (Criteria) this;
        }

        public Criteria andWHighAverageNotLike(String value) {
            addCriterion("w_high_average not like", value, "wHighAverage");
            return (Criteria) this;
        }

        public Criteria andWHighAverageIn(List<String> values) {
            addCriterion("w_high_average in", values, "wHighAverage");
            return (Criteria) this;
        }

        public Criteria andWHighAverageNotIn(List<String> values) {
            addCriterion("w_high_average not in", values, "wHighAverage");
            return (Criteria) this;
        }

        public Criteria andWHighAverageBetween(String value1, String value2) {
            addCriterion("w_high_average between", value1, value2, "wHighAverage");
            return (Criteria) this;
        }

        public Criteria andWHighAverageNotBetween(String value1, String value2) {
            addCriterion("w_high_average not between", value1, value2, "wHighAverage");
            return (Criteria) this;
        }

        public Criteria andWHighEffectiveIsNull() {
            addCriterion("w_high_effective is null");
            return (Criteria) this;
        }

        public Criteria andWHighEffectiveIsNotNull() {
            addCriterion("w_high_effective is not null");
            return (Criteria) this;
        }

        public Criteria andWHighEffectiveEqualTo(String value) {
            addCriterion("w_high_effective =", value, "wHighEffective");
            return (Criteria) this;
        }

        public Criteria andWHighEffectiveNotEqualTo(String value) {
            addCriterion("w_high_effective <>", value, "wHighEffective");
            return (Criteria) this;
        }

        public Criteria andWHighEffectiveGreaterThan(String value) {
            addCriterion("w_high_effective >", value, "wHighEffective");
            return (Criteria) this;
        }

        public Criteria andWHighEffectiveGreaterThanOrEqualTo(String value) {
            addCriterion("w_high_effective >=", value, "wHighEffective");
            return (Criteria) this;
        }

        public Criteria andWHighEffectiveLessThan(String value) {
            addCriterion("w_high_effective <", value, "wHighEffective");
            return (Criteria) this;
        }

        public Criteria andWHighEffectiveLessThanOrEqualTo(String value) {
            addCriterion("w_high_effective <=", value, "wHighEffective");
            return (Criteria) this;
        }

        public Criteria andWHighEffectiveLike(String value) {
            addCriterion("w_high_effective like", value, "wHighEffective");
            return (Criteria) this;
        }

        public Criteria andWHighEffectiveNotLike(String value) {
            addCriterion("w_high_effective not like", value, "wHighEffective");
            return (Criteria) this;
        }

        public Criteria andWHighEffectiveIn(List<String> values) {
            addCriterion("w_high_effective in", values, "wHighEffective");
            return (Criteria) this;
        }

        public Criteria andWHighEffectiveNotIn(List<String> values) {
            addCriterion("w_high_effective not in", values, "wHighEffective");
            return (Criteria) this;
        }

        public Criteria andWHighEffectiveBetween(String value1, String value2) {
            addCriterion("w_high_effective between", value1, value2, "wHighEffective");
            return (Criteria) this;
        }

        public Criteria andWHighEffectiveNotBetween(String value1, String value2) {
            addCriterion("w_high_effective not between", value1, value2, "wHighEffective");
            return (Criteria) this;
        }

        public Criteria andWCycleMaxIsNull() {
            addCriterion("w_cycle_max is null");
            return (Criteria) this;
        }

        public Criteria andWCycleMaxIsNotNull() {
            addCriterion("w_cycle_max is not null");
            return (Criteria) this;
        }

        public Criteria andWCycleMaxEqualTo(String value) {
            addCriterion("w_cycle_max =", value, "wCycleMax");
            return (Criteria) this;
        }

        public Criteria andWCycleMaxNotEqualTo(String value) {
            addCriterion("w_cycle_max <>", value, "wCycleMax");
            return (Criteria) this;
        }

        public Criteria andWCycleMaxGreaterThan(String value) {
            addCriterion("w_cycle_max >", value, "wCycleMax");
            return (Criteria) this;
        }

        public Criteria andWCycleMaxGreaterThanOrEqualTo(String value) {
            addCriterion("w_cycle_max >=", value, "wCycleMax");
            return (Criteria) this;
        }

        public Criteria andWCycleMaxLessThan(String value) {
            addCriterion("w_cycle_max <", value, "wCycleMax");
            return (Criteria) this;
        }

        public Criteria andWCycleMaxLessThanOrEqualTo(String value) {
            addCriterion("w_cycle_max <=", value, "wCycleMax");
            return (Criteria) this;
        }

        public Criteria andWCycleMaxLike(String value) {
            addCriterion("w_cycle_max like", value, "wCycleMax");
            return (Criteria) this;
        }

        public Criteria andWCycleMaxNotLike(String value) {
            addCriterion("w_cycle_max not like", value, "wCycleMax");
            return (Criteria) this;
        }

        public Criteria andWCycleMaxIn(List<String> values) {
            addCriterion("w_cycle_max in", values, "wCycleMax");
            return (Criteria) this;
        }

        public Criteria andWCycleMaxNotIn(List<String> values) {
            addCriterion("w_cycle_max not in", values, "wCycleMax");
            return (Criteria) this;
        }

        public Criteria andWCycleMaxBetween(String value1, String value2) {
            addCriterion("w_cycle_max between", value1, value2, "wCycleMax");
            return (Criteria) this;
        }

        public Criteria andWCycleMaxNotBetween(String value1, String value2) {
            addCriterion("w_cycle_max not between", value1, value2, "wCycleMax");
            return (Criteria) this;
        }

        public Criteria andWCycleTenthIsNull() {
            addCriterion("w_cycle_tenth is null");
            return (Criteria) this;
        }

        public Criteria andWCycleTenthIsNotNull() {
            addCriterion("w_cycle_tenth is not null");
            return (Criteria) this;
        }

        public Criteria andWCycleTenthEqualTo(String value) {
            addCriterion("w_cycle_tenth =", value, "wCycleTenth");
            return (Criteria) this;
        }

        public Criteria andWCycleTenthNotEqualTo(String value) {
            addCriterion("w_cycle_tenth <>", value, "wCycleTenth");
            return (Criteria) this;
        }

        public Criteria andWCycleTenthGreaterThan(String value) {
            addCriterion("w_cycle_tenth >", value, "wCycleTenth");
            return (Criteria) this;
        }

        public Criteria andWCycleTenthGreaterThanOrEqualTo(String value) {
            addCriterion("w_cycle_tenth >=", value, "wCycleTenth");
            return (Criteria) this;
        }

        public Criteria andWCycleTenthLessThan(String value) {
            addCriterion("w_cycle_tenth <", value, "wCycleTenth");
            return (Criteria) this;
        }

        public Criteria andWCycleTenthLessThanOrEqualTo(String value) {
            addCriterion("w_cycle_tenth <=", value, "wCycleTenth");
            return (Criteria) this;
        }

        public Criteria andWCycleTenthLike(String value) {
            addCriterion("w_cycle_tenth like", value, "wCycleTenth");
            return (Criteria) this;
        }

        public Criteria andWCycleTenthNotLike(String value) {
            addCriterion("w_cycle_tenth not like", value, "wCycleTenth");
            return (Criteria) this;
        }

        public Criteria andWCycleTenthIn(List<String> values) {
            addCriterion("w_cycle_tenth in", values, "wCycleTenth");
            return (Criteria) this;
        }

        public Criteria andWCycleTenthNotIn(List<String> values) {
            addCriterion("w_cycle_tenth not in", values, "wCycleTenth");
            return (Criteria) this;
        }

        public Criteria andWCycleTenthBetween(String value1, String value2) {
            addCriterion("w_cycle_tenth between", value1, value2, "wCycleTenth");
            return (Criteria) this;
        }

        public Criteria andWCycleTenthNotBetween(String value1, String value2) {
            addCriterion("w_cycle_tenth not between", value1, value2, "wCycleTenth");
            return (Criteria) this;
        }

        public Criteria andWCycleAverageIsNull() {
            addCriterion("w_cycle_average is null");
            return (Criteria) this;
        }

        public Criteria andWCycleAverageIsNotNull() {
            addCriterion("w_cycle_average is not null");
            return (Criteria) this;
        }

        public Criteria andWCycleAverageEqualTo(String value) {
            addCriterion("w_cycle_average =", value, "wCycleAverage");
            return (Criteria) this;
        }

        public Criteria andWCycleAverageNotEqualTo(String value) {
            addCriterion("w_cycle_average <>", value, "wCycleAverage");
            return (Criteria) this;
        }

        public Criteria andWCycleAverageGreaterThan(String value) {
            addCriterion("w_cycle_average >", value, "wCycleAverage");
            return (Criteria) this;
        }

        public Criteria andWCycleAverageGreaterThanOrEqualTo(String value) {
            addCriterion("w_cycle_average >=", value, "wCycleAverage");
            return (Criteria) this;
        }

        public Criteria andWCycleAverageLessThan(String value) {
            addCriterion("w_cycle_average <", value, "wCycleAverage");
            return (Criteria) this;
        }

        public Criteria andWCycleAverageLessThanOrEqualTo(String value) {
            addCriterion("w_cycle_average <=", value, "wCycleAverage");
            return (Criteria) this;
        }

        public Criteria andWCycleAverageLike(String value) {
            addCriterion("w_cycle_average like", value, "wCycleAverage");
            return (Criteria) this;
        }

        public Criteria andWCycleAverageNotLike(String value) {
            addCriterion("w_cycle_average not like", value, "wCycleAverage");
            return (Criteria) this;
        }

        public Criteria andWCycleAverageIn(List<String> values) {
            addCriterion("w_cycle_average in", values, "wCycleAverage");
            return (Criteria) this;
        }

        public Criteria andWCycleAverageNotIn(List<String> values) {
            addCriterion("w_cycle_average not in", values, "wCycleAverage");
            return (Criteria) this;
        }

        public Criteria andWCycleAverageBetween(String value1, String value2) {
            addCriterion("w_cycle_average between", value1, value2, "wCycleAverage");
            return (Criteria) this;
        }

        public Criteria andWCycleAverageNotBetween(String value1, String value2) {
            addCriterion("w_cycle_average not between", value1, value2, "wCycleAverage");
            return (Criteria) this;
        }

        public Criteria andWCycleEffectiveIsNull() {
            addCriterion("w_cycle_effective is null");
            return (Criteria) this;
        }

        public Criteria andWCycleEffectiveIsNotNull() {
            addCriterion("w_cycle_effective is not null");
            return (Criteria) this;
        }

        public Criteria andWCycleEffectiveEqualTo(String value) {
            addCriterion("w_cycle_effective =", value, "wCycleEffective");
            return (Criteria) this;
        }

        public Criteria andWCycleEffectiveNotEqualTo(String value) {
            addCriterion("w_cycle_effective <>", value, "wCycleEffective");
            return (Criteria) this;
        }

        public Criteria andWCycleEffectiveGreaterThan(String value) {
            addCriterion("w_cycle_effective >", value, "wCycleEffective");
            return (Criteria) this;
        }

        public Criteria andWCycleEffectiveGreaterThanOrEqualTo(String value) {
            addCriterion("w_cycle_effective >=", value, "wCycleEffective");
            return (Criteria) this;
        }

        public Criteria andWCycleEffectiveLessThan(String value) {
            addCriterion("w_cycle_effective <", value, "wCycleEffective");
            return (Criteria) this;
        }

        public Criteria andWCycleEffectiveLessThanOrEqualTo(String value) {
            addCriterion("w_cycle_effective <=", value, "wCycleEffective");
            return (Criteria) this;
        }

        public Criteria andWCycleEffectiveLike(String value) {
            addCriterion("w_cycle_effective like", value, "wCycleEffective");
            return (Criteria) this;
        }

        public Criteria andWCycleEffectiveNotLike(String value) {
            addCriterion("w_cycle_effective not like", value, "wCycleEffective");
            return (Criteria) this;
        }

        public Criteria andWCycleEffectiveIn(List<String> values) {
            addCriterion("w_cycle_effective in", values, "wCycleEffective");
            return (Criteria) this;
        }

        public Criteria andWCycleEffectiveNotIn(List<String> values) {
            addCriterion("w_cycle_effective not in", values, "wCycleEffective");
            return (Criteria) this;
        }

        public Criteria andWCycleEffectiveBetween(String value1, String value2) {
            addCriterion("w_cycle_effective between", value1, value2, "wCycleEffective");
            return (Criteria) this;
        }

        public Criteria andWCycleEffectiveNotBetween(String value1, String value2) {
            addCriterion("w_cycle_effective not between", value1, value2, "wCycleEffective");
            return (Criteria) this;
        }

        public Criteria andWToIsNull() {
            addCriterion("w_to is null");
            return (Criteria) this;
        }

        public Criteria andWToIsNotNull() {
            addCriterion("w_to is not null");
            return (Criteria) this;
        }

        public Criteria andWToEqualTo(String value) {
            addCriterion("w_to =", value, "wTo");
            return (Criteria) this;
        }

        public Criteria andWToNotEqualTo(String value) {
            addCriterion("w_to <>", value, "wTo");
            return (Criteria) this;
        }

        public Criteria andWToGreaterThan(String value) {
            addCriterion("w_to >", value, "wTo");
            return (Criteria) this;
        }

        public Criteria andWToGreaterThanOrEqualTo(String value) {
            addCriterion("w_to >=", value, "wTo");
            return (Criteria) this;
        }

        public Criteria andWToLessThan(String value) {
            addCriterion("w_to <", value, "wTo");
            return (Criteria) this;
        }

        public Criteria andWToLessThanOrEqualTo(String value) {
            addCriterion("w_to <=", value, "wTo");
            return (Criteria) this;
        }

        public Criteria andWToLike(String value) {
            addCriterion("w_to like", value, "wTo");
            return (Criteria) this;
        }

        public Criteria andWToNotLike(String value) {
            addCriterion("w_to not like", value, "wTo");
            return (Criteria) this;
        }

        public Criteria andWToIn(List<String> values) {
            addCriterion("w_to in", values, "wTo");
            return (Criteria) this;
        }

        public Criteria andWToNotIn(List<String> values) {
            addCriterion("w_to not in", values, "wTo");
            return (Criteria) this;
        }

        public Criteria andWToBetween(String value1, String value2) {
            addCriterion("w_to between", value1, value2, "wTo");
            return (Criteria) this;
        }

        public Criteria andWToNotBetween(String value1, String value2) {
            addCriterion("w_to not between", value1, value2, "wTo");
            return (Criteria) this;
        }

        public Criteria andWCountIsNull() {
            addCriterion("w_count is null");
            return (Criteria) this;
        }

        public Criteria andWCountIsNotNull() {
            addCriterion("w_count is not null");
            return (Criteria) this;
        }

        public Criteria andWCountEqualTo(String value) {
            addCriterion("w_count =", value, "wCount");
            return (Criteria) this;
        }

        public Criteria andWCountNotEqualTo(String value) {
            addCriterion("w_count <>", value, "wCount");
            return (Criteria) this;
        }

        public Criteria andWCountGreaterThan(String value) {
            addCriterion("w_count >", value, "wCount");
            return (Criteria) this;
        }

        public Criteria andWCountGreaterThanOrEqualTo(String value) {
            addCriterion("w_count >=", value, "wCount");
            return (Criteria) this;
        }

        public Criteria andWCountLessThan(String value) {
            addCriterion("w_count <", value, "wCount");
            return (Criteria) this;
        }

        public Criteria andWCountLessThanOrEqualTo(String value) {
            addCriterion("w_count <=", value, "wCount");
            return (Criteria) this;
        }

        public Criteria andWCountLike(String value) {
            addCriterion("w_count like", value, "wCount");
            return (Criteria) this;
        }

        public Criteria andWCountNotLike(String value) {
            addCriterion("w_count not like", value, "wCount");
            return (Criteria) this;
        }

        public Criteria andWCountIn(List<String> values) {
            addCriterion("w_count in", values, "wCount");
            return (Criteria) this;
        }

        public Criteria andWCountNotIn(List<String> values) {
            addCriterion("w_count not in", values, "wCount");
            return (Criteria) this;
        }

        public Criteria andWCountBetween(String value1, String value2) {
            addCriterion("w_count between", value1, value2, "wCount");
            return (Criteria) this;
        }

        public Criteria andWCountNotBetween(String value1, String value2) {
            addCriterion("w_count not between", value1, value2, "wCount");
            return (Criteria) this;
        }

        public Criteria andWDateidIsNull() {
            addCriterion("w_dateid is null");
            return (Criteria) this;
        }

        public Criteria andWDateidIsNotNull() {
            addCriterion("w_dateid is not null");
            return (Criteria) this;
        }

        public Criteria andWDateidEqualTo(String value) {
            addCriterion("w_dateid =", value, "wDateid");
            return (Criteria) this;
        }

        public Criteria andWDateidNotEqualTo(String value) {
            addCriterion("w_dateid <>", value, "wDateid");
            return (Criteria) this;
        }

        public Criteria andWDateidGreaterThan(String value) {
            addCriterion("w_dateid >", value, "wDateid");
            return (Criteria) this;
        }

        public Criteria andWDateidGreaterThanOrEqualTo(String value) {
            addCriterion("w_dateid >=", value, "wDateid");
            return (Criteria) this;
        }

        public Criteria andWDateidLessThan(String value) {
            addCriterion("w_dateid <", value, "wDateid");
            return (Criteria) this;
        }

        public Criteria andWDateidLessThanOrEqualTo(String value) {
            addCriterion("w_dateid <=", value, "wDateid");
            return (Criteria) this;
        }

        public Criteria andWDateidLike(String value) {
            addCriterion("w_dateid like", value, "wDateid");
            return (Criteria) this;
        }

        public Criteria andWDateidNotLike(String value) {
            addCriterion("w_dateid not like", value, "wDateid");
            return (Criteria) this;
        }

        public Criteria andWDateidIn(List<String> values) {
            addCriterion("w_dateid in", values, "wDateid");
            return (Criteria) this;
        }

        public Criteria andWDateidNotIn(List<String> values) {
            addCriterion("w_dateid not in", values, "wDateid");
            return (Criteria) this;
        }

        public Criteria andWDateidBetween(String value1, String value2) {
            addCriterion("w_dateid between", value1, value2, "wDateid");
            return (Criteria) this;
        }

        public Criteria andWDateidNotBetween(String value1, String value2) {
            addCriterion("w_dateid not between", value1, value2, "wDateid");
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