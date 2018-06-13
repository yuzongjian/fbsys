package com.buoy.entity;

import java.util.ArrayList;
import java.util.List;

public class WaterqualityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WaterqualityExample() {
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

        public Criteria andWqIdIsNull() {
            addCriterion("wq_id is null");
            return (Criteria) this;
        }

        public Criteria andWqIdIsNotNull() {
            addCriterion("wq_id is not null");
            return (Criteria) this;
        }

        public Criteria andWqIdEqualTo(Integer value) {
            addCriterion("wq_id =", value, "wqId");
            return (Criteria) this;
        }

        public Criteria andWqIdNotEqualTo(Integer value) {
            addCriterion("wq_id <>", value, "wqId");
            return (Criteria) this;
        }

        public Criteria andWqIdGreaterThan(Integer value) {
            addCriterion("wq_id >", value, "wqId");
            return (Criteria) this;
        }

        public Criteria andWqIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("wq_id >=", value, "wqId");
            return (Criteria) this;
        }

        public Criteria andWqIdLessThan(Integer value) {
            addCriterion("wq_id <", value, "wqId");
            return (Criteria) this;
        }

        public Criteria andWqIdLessThanOrEqualTo(Integer value) {
            addCriterion("wq_id <=", value, "wqId");
            return (Criteria) this;
        }

        public Criteria andWqIdIn(List<Integer> values) {
            addCriterion("wq_id in", values, "wqId");
            return (Criteria) this;
        }

        public Criteria andWqIdNotIn(List<Integer> values) {
            addCriterion("wq_id not in", values, "wqId");
            return (Criteria) this;
        }

        public Criteria andWqIdBetween(Integer value1, Integer value2) {
            addCriterion("wq_id between", value1, value2, "wqId");
            return (Criteria) this;
        }

        public Criteria andWqIdNotBetween(Integer value1, Integer value2) {
            addCriterion("wq_id not between", value1, value2, "wqId");
            return (Criteria) this;
        }

        public Criteria andWqBuoyidIsNull() {
            addCriterion("wq_buoyid is null");
            return (Criteria) this;
        }

        public Criteria andWqBuoyidIsNotNull() {
            addCriterion("wq_buoyid is not null");
            return (Criteria) this;
        }

        public Criteria andWqBuoyidEqualTo(String value) {
            addCriterion("wq_buoyid =", value, "wqBuoyid");
            return (Criteria) this;
        }

        public Criteria andWqBuoyidNotEqualTo(String value) {
            addCriterion("wq_buoyid <>", value, "wqBuoyid");
            return (Criteria) this;
        }

        public Criteria andWqBuoyidGreaterThan(String value) {
            addCriterion("wq_buoyid >", value, "wqBuoyid");
            return (Criteria) this;
        }

        public Criteria andWqBuoyidGreaterThanOrEqualTo(String value) {
            addCriterion("wq_buoyid >=", value, "wqBuoyid");
            return (Criteria) this;
        }

        public Criteria andWqBuoyidLessThan(String value) {
            addCriterion("wq_buoyid <", value, "wqBuoyid");
            return (Criteria) this;
        }

        public Criteria andWqBuoyidLessThanOrEqualTo(String value) {
            addCriterion("wq_buoyid <=", value, "wqBuoyid");
            return (Criteria) this;
        }

        public Criteria andWqBuoyidLike(String value) {
            addCriterion("wq_buoyid like", value, "wqBuoyid");
            return (Criteria) this;
        }

        public Criteria andWqBuoyidNotLike(String value) {
            addCriterion("wq_buoyid not like", value, "wqBuoyid");
            return (Criteria) this;
        }

        public Criteria andWqBuoyidIn(List<String> values) {
            addCriterion("wq_buoyid in", values, "wqBuoyid");
            return (Criteria) this;
        }

        public Criteria andWqBuoyidNotIn(List<String> values) {
            addCriterion("wq_buoyid not in", values, "wqBuoyid");
            return (Criteria) this;
        }

        public Criteria andWqBuoyidBetween(String value1, String value2) {
            addCriterion("wq_buoyid between", value1, value2, "wqBuoyid");
            return (Criteria) this;
        }

        public Criteria andWqBuoyidNotBetween(String value1, String value2) {
            addCriterion("wq_buoyid not between", value1, value2, "wqBuoyid");
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

        public Criteria andWqWattempIsNull() {
            addCriterion("wq_wattemp is null");
            return (Criteria) this;
        }

        public Criteria andWqWattempIsNotNull() {
            addCriterion("wq_wattemp is not null");
            return (Criteria) this;
        }

        public Criteria andWqWattempEqualTo(String value) {
            addCriterion("wq_wattemp =", value, "wqWattemp");
            return (Criteria) this;
        }

        public Criteria andWqWattempNotEqualTo(String value) {
            addCriterion("wq_wattemp <>", value, "wqWattemp");
            return (Criteria) this;
        }

        public Criteria andWqWattempGreaterThan(String value) {
            addCriterion("wq_wattemp >", value, "wqWattemp");
            return (Criteria) this;
        }

        public Criteria andWqWattempGreaterThanOrEqualTo(String value) {
            addCriterion("wq_wattemp >=", value, "wqWattemp");
            return (Criteria) this;
        }

        public Criteria andWqWattempLessThan(String value) {
            addCriterion("wq_wattemp <", value, "wqWattemp");
            return (Criteria) this;
        }

        public Criteria andWqWattempLessThanOrEqualTo(String value) {
            addCriterion("wq_wattemp <=", value, "wqWattemp");
            return (Criteria) this;
        }

        public Criteria andWqWattempLike(String value) {
            addCriterion("wq_wattemp like", value, "wqWattemp");
            return (Criteria) this;
        }

        public Criteria andWqWattempNotLike(String value) {
            addCriterion("wq_wattemp not like", value, "wqWattemp");
            return (Criteria) this;
        }

        public Criteria andWqWattempIn(List<String> values) {
            addCriterion("wq_wattemp in", values, "wqWattemp");
            return (Criteria) this;
        }

        public Criteria andWqWattempNotIn(List<String> values) {
            addCriterion("wq_wattemp not in", values, "wqWattemp");
            return (Criteria) this;
        }

        public Criteria andWqWattempBetween(String value1, String value2) {
            addCriterion("wq_wattemp between", value1, value2, "wqWattemp");
            return (Criteria) this;
        }

        public Criteria andWqWattempNotBetween(String value1, String value2) {
            addCriterion("wq_wattemp not between", value1, value2, "wqWattemp");
            return (Criteria) this;
        }

        public Criteria andWqSeatempIsNull() {
            addCriterion("wq_seatemp is null");
            return (Criteria) this;
        }

        public Criteria andWqSeatempIsNotNull() {
            addCriterion("wq_seatemp is not null");
            return (Criteria) this;
        }

        public Criteria andWqSeatempEqualTo(String value) {
            addCriterion("wq_seatemp =", value, "wqSeatemp");
            return (Criteria) this;
        }

        public Criteria andWqSeatempNotEqualTo(String value) {
            addCriterion("wq_seatemp <>", value, "wqSeatemp");
            return (Criteria) this;
        }

        public Criteria andWqSeatempGreaterThan(String value) {
            addCriterion("wq_seatemp >", value, "wqSeatemp");
            return (Criteria) this;
        }

        public Criteria andWqSeatempGreaterThanOrEqualTo(String value) {
            addCriterion("wq_seatemp >=", value, "wqSeatemp");
            return (Criteria) this;
        }

        public Criteria andWqSeatempLessThan(String value) {
            addCriterion("wq_seatemp <", value, "wqSeatemp");
            return (Criteria) this;
        }

        public Criteria andWqSeatempLessThanOrEqualTo(String value) {
            addCriterion("wq_seatemp <=", value, "wqSeatemp");
            return (Criteria) this;
        }

        public Criteria andWqSeatempLike(String value) {
            addCriterion("wq_seatemp like", value, "wqSeatemp");
            return (Criteria) this;
        }

        public Criteria andWqSeatempNotLike(String value) {
            addCriterion("wq_seatemp not like", value, "wqSeatemp");
            return (Criteria) this;
        }

        public Criteria andWqSeatempIn(List<String> values) {
            addCriterion("wq_seatemp in", values, "wqSeatemp");
            return (Criteria) this;
        }

        public Criteria andWqSeatempNotIn(List<String> values) {
            addCriterion("wq_seatemp not in", values, "wqSeatemp");
            return (Criteria) this;
        }

        public Criteria andWqSeatempBetween(String value1, String value2) {
            addCriterion("wq_seatemp between", value1, value2, "wqSeatemp");
            return (Criteria) this;
        }

        public Criteria andWqSeatempNotBetween(String value1, String value2) {
            addCriterion("wq_seatemp not between", value1, value2, "wqSeatemp");
            return (Criteria) this;
        }

        public Criteria andWqIndeptempIsNull() {
            addCriterion("wq_indeptemp is null");
            return (Criteria) this;
        }

        public Criteria andWqIndeptempIsNotNull() {
            addCriterion("wq_indeptemp is not null");
            return (Criteria) this;
        }

        public Criteria andWqIndeptempEqualTo(String value) {
            addCriterion("wq_indeptemp =", value, "wqIndeptemp");
            return (Criteria) this;
        }

        public Criteria andWqIndeptempNotEqualTo(String value) {
            addCriterion("wq_indeptemp <>", value, "wqIndeptemp");
            return (Criteria) this;
        }

        public Criteria andWqIndeptempGreaterThan(String value) {
            addCriterion("wq_indeptemp >", value, "wqIndeptemp");
            return (Criteria) this;
        }

        public Criteria andWqIndeptempGreaterThanOrEqualTo(String value) {
            addCriterion("wq_indeptemp >=", value, "wqIndeptemp");
            return (Criteria) this;
        }

        public Criteria andWqIndeptempLessThan(String value) {
            addCriterion("wq_indeptemp <", value, "wqIndeptemp");
            return (Criteria) this;
        }

        public Criteria andWqIndeptempLessThanOrEqualTo(String value) {
            addCriterion("wq_indeptemp <=", value, "wqIndeptemp");
            return (Criteria) this;
        }

        public Criteria andWqIndeptempLike(String value) {
            addCriterion("wq_indeptemp like", value, "wqIndeptemp");
            return (Criteria) this;
        }

        public Criteria andWqIndeptempNotLike(String value) {
            addCriterion("wq_indeptemp not like", value, "wqIndeptemp");
            return (Criteria) this;
        }

        public Criteria andWqIndeptempIn(List<String> values) {
            addCriterion("wq_indeptemp in", values, "wqIndeptemp");
            return (Criteria) this;
        }

        public Criteria andWqIndeptempNotIn(List<String> values) {
            addCriterion("wq_indeptemp not in", values, "wqIndeptemp");
            return (Criteria) this;
        }

        public Criteria andWqIndeptempBetween(String value1, String value2) {
            addCriterion("wq_indeptemp between", value1, value2, "wqIndeptemp");
            return (Criteria) this;
        }

        public Criteria andWqIndeptempNotBetween(String value1, String value2) {
            addCriterion("wq_indeptemp not between", value1, value2, "wqIndeptemp");
            return (Criteria) this;
        }

        public Criteria andWqTempIsNull() {
            addCriterion("wq_temp is null");
            return (Criteria) this;
        }

        public Criteria andWqTempIsNotNull() {
            addCriterion("wq_temp is not null");
            return (Criteria) this;
        }

        public Criteria andWqTempEqualTo(String value) {
            addCriterion("wq_temp =", value, "wqTemp");
            return (Criteria) this;
        }

        public Criteria andWqTempNotEqualTo(String value) {
            addCriterion("wq_temp <>", value, "wqTemp");
            return (Criteria) this;
        }

        public Criteria andWqTempGreaterThan(String value) {
            addCriterion("wq_temp >", value, "wqTemp");
            return (Criteria) this;
        }

        public Criteria andWqTempGreaterThanOrEqualTo(String value) {
            addCriterion("wq_temp >=", value, "wqTemp");
            return (Criteria) this;
        }

        public Criteria andWqTempLessThan(String value) {
            addCriterion("wq_temp <", value, "wqTemp");
            return (Criteria) this;
        }

        public Criteria andWqTempLessThanOrEqualTo(String value) {
            addCriterion("wq_temp <=", value, "wqTemp");
            return (Criteria) this;
        }

        public Criteria andWqTempLike(String value) {
            addCriterion("wq_temp like", value, "wqTemp");
            return (Criteria) this;
        }

        public Criteria andWqTempNotLike(String value) {
            addCriterion("wq_temp not like", value, "wqTemp");
            return (Criteria) this;
        }

        public Criteria andWqTempIn(List<String> values) {
            addCriterion("wq_temp in", values, "wqTemp");
            return (Criteria) this;
        }

        public Criteria andWqTempNotIn(List<String> values) {
            addCriterion("wq_temp not in", values, "wqTemp");
            return (Criteria) this;
        }

        public Criteria andWqTempBetween(String value1, String value2) {
            addCriterion("wq_temp between", value1, value2, "wqTemp");
            return (Criteria) this;
        }

        public Criteria andWqTempNotBetween(String value1, String value2) {
            addCriterion("wq_temp not between", value1, value2, "wqTemp");
            return (Criteria) this;
        }

        public Criteria andWqSalinityIsNull() {
            addCriterion("wq_salinity is null");
            return (Criteria) this;
        }

        public Criteria andWqSalinityIsNotNull() {
            addCriterion("wq_salinity is not null");
            return (Criteria) this;
        }

        public Criteria andWqSalinityEqualTo(String value) {
            addCriterion("wq_salinity =", value, "wqSalinity");
            return (Criteria) this;
        }

        public Criteria andWqSalinityNotEqualTo(String value) {
            addCriterion("wq_salinity <>", value, "wqSalinity");
            return (Criteria) this;
        }

        public Criteria andWqSalinityGreaterThan(String value) {
            addCriterion("wq_salinity >", value, "wqSalinity");
            return (Criteria) this;
        }

        public Criteria andWqSalinityGreaterThanOrEqualTo(String value) {
            addCriterion("wq_salinity >=", value, "wqSalinity");
            return (Criteria) this;
        }

        public Criteria andWqSalinityLessThan(String value) {
            addCriterion("wq_salinity <", value, "wqSalinity");
            return (Criteria) this;
        }

        public Criteria andWqSalinityLessThanOrEqualTo(String value) {
            addCriterion("wq_salinity <=", value, "wqSalinity");
            return (Criteria) this;
        }

        public Criteria andWqSalinityLike(String value) {
            addCriterion("wq_salinity like", value, "wqSalinity");
            return (Criteria) this;
        }

        public Criteria andWqSalinityNotLike(String value) {
            addCriterion("wq_salinity not like", value, "wqSalinity");
            return (Criteria) this;
        }

        public Criteria andWqSalinityIn(List<String> values) {
            addCriterion("wq_salinity in", values, "wqSalinity");
            return (Criteria) this;
        }

        public Criteria andWqSalinityNotIn(List<String> values) {
            addCriterion("wq_salinity not in", values, "wqSalinity");
            return (Criteria) this;
        }

        public Criteria andWqSalinityBetween(String value1, String value2) {
            addCriterion("wq_salinity between", value1, value2, "wqSalinity");
            return (Criteria) this;
        }

        public Criteria andWqSalinityNotBetween(String value1, String value2) {
            addCriterion("wq_salinity not between", value1, value2, "wqSalinity");
            return (Criteria) this;
        }

        public Criteria andWqConductivityIsNull() {
            addCriterion("wq_conductivity is null");
            return (Criteria) this;
        }

        public Criteria andWqConductivityIsNotNull() {
            addCriterion("wq_conductivity is not null");
            return (Criteria) this;
        }

        public Criteria andWqConductivityEqualTo(String value) {
            addCriterion("wq_conductivity =", value, "wqConductivity");
            return (Criteria) this;
        }

        public Criteria andWqConductivityNotEqualTo(String value) {
            addCriterion("wq_conductivity <>", value, "wqConductivity");
            return (Criteria) this;
        }

        public Criteria andWqConductivityGreaterThan(String value) {
            addCriterion("wq_conductivity >", value, "wqConductivity");
            return (Criteria) this;
        }

        public Criteria andWqConductivityGreaterThanOrEqualTo(String value) {
            addCriterion("wq_conductivity >=", value, "wqConductivity");
            return (Criteria) this;
        }

        public Criteria andWqConductivityLessThan(String value) {
            addCriterion("wq_conductivity <", value, "wqConductivity");
            return (Criteria) this;
        }

        public Criteria andWqConductivityLessThanOrEqualTo(String value) {
            addCriterion("wq_conductivity <=", value, "wqConductivity");
            return (Criteria) this;
        }

        public Criteria andWqConductivityLike(String value) {
            addCriterion("wq_conductivity like", value, "wqConductivity");
            return (Criteria) this;
        }

        public Criteria andWqConductivityNotLike(String value) {
            addCriterion("wq_conductivity not like", value, "wqConductivity");
            return (Criteria) this;
        }

        public Criteria andWqConductivityIn(List<String> values) {
            addCriterion("wq_conductivity in", values, "wqConductivity");
            return (Criteria) this;
        }

        public Criteria andWqConductivityNotIn(List<String> values) {
            addCriterion("wq_conductivity not in", values, "wqConductivity");
            return (Criteria) this;
        }

        public Criteria andWqConductivityBetween(String value1, String value2) {
            addCriterion("wq_conductivity between", value1, value2, "wqConductivity");
            return (Criteria) this;
        }

        public Criteria andWqConductivityNotBetween(String value1, String value2) {
            addCriterion("wq_conductivity not between", value1, value2, "wqConductivity");
            return (Criteria) this;
        }

        public Criteria andWqDoIsNull() {
            addCriterion("wq_DO is null");
            return (Criteria) this;
        }

        public Criteria andWqDoIsNotNull() {
            addCriterion("wq_DO is not null");
            return (Criteria) this;
        }

        public Criteria andWqDoEqualTo(String value) {
            addCriterion("wq_DO =", value, "wqDo");
            return (Criteria) this;
        }

        public Criteria andWqDoNotEqualTo(String value) {
            addCriterion("wq_DO <>", value, "wqDo");
            return (Criteria) this;
        }

        public Criteria andWqDoGreaterThan(String value) {
            addCriterion("wq_DO >", value, "wqDo");
            return (Criteria) this;
        }

        public Criteria andWqDoGreaterThanOrEqualTo(String value) {
            addCriterion("wq_DO >=", value, "wqDo");
            return (Criteria) this;
        }

        public Criteria andWqDoLessThan(String value) {
            addCriterion("wq_DO <", value, "wqDo");
            return (Criteria) this;
        }

        public Criteria andWqDoLessThanOrEqualTo(String value) {
            addCriterion("wq_DO <=", value, "wqDo");
            return (Criteria) this;
        }

        public Criteria andWqDoLike(String value) {
            addCriterion("wq_DO like", value, "wqDo");
            return (Criteria) this;
        }

        public Criteria andWqDoNotLike(String value) {
            addCriterion("wq_DO not like", value, "wqDo");
            return (Criteria) this;
        }

        public Criteria andWqDoIn(List<String> values) {
            addCriterion("wq_DO in", values, "wqDo");
            return (Criteria) this;
        }

        public Criteria andWqDoNotIn(List<String> values) {
            addCriterion("wq_DO not in", values, "wqDo");
            return (Criteria) this;
        }

        public Criteria andWqDoBetween(String value1, String value2) {
            addCriterion("wq_DO between", value1, value2, "wqDo");
            return (Criteria) this;
        }

        public Criteria andWqDoNotBetween(String value1, String value2) {
            addCriterion("wq_DO not between", value1, value2, "wqDo");
            return (Criteria) this;
        }

        public Criteria andWqPhIsNull() {
            addCriterion("wq_PH is null");
            return (Criteria) this;
        }

        public Criteria andWqPhIsNotNull() {
            addCriterion("wq_PH is not null");
            return (Criteria) this;
        }

        public Criteria andWqPhEqualTo(String value) {
            addCriterion("wq_PH =", value, "wqPh");
            return (Criteria) this;
        }

        public Criteria andWqPhNotEqualTo(String value) {
            addCriterion("wq_PH <>", value, "wqPh");
            return (Criteria) this;
        }

        public Criteria andWqPhGreaterThan(String value) {
            addCriterion("wq_PH >", value, "wqPh");
            return (Criteria) this;
        }

        public Criteria andWqPhGreaterThanOrEqualTo(String value) {
            addCriterion("wq_PH >=", value, "wqPh");
            return (Criteria) this;
        }

        public Criteria andWqPhLessThan(String value) {
            addCriterion("wq_PH <", value, "wqPh");
            return (Criteria) this;
        }

        public Criteria andWqPhLessThanOrEqualTo(String value) {
            addCriterion("wq_PH <=", value, "wqPh");
            return (Criteria) this;
        }

        public Criteria andWqPhLike(String value) {
            addCriterion("wq_PH like", value, "wqPh");
            return (Criteria) this;
        }

        public Criteria andWqPhNotLike(String value) {
            addCriterion("wq_PH not like", value, "wqPh");
            return (Criteria) this;
        }

        public Criteria andWqPhIn(List<String> values) {
            addCriterion("wq_PH in", values, "wqPh");
            return (Criteria) this;
        }

        public Criteria andWqPhNotIn(List<String> values) {
            addCriterion("wq_PH not in", values, "wqPh");
            return (Criteria) this;
        }

        public Criteria andWqPhBetween(String value1, String value2) {
            addCriterion("wq_PH between", value1, value2, "wqPh");
            return (Criteria) this;
        }

        public Criteria andWqPhNotBetween(String value1, String value2) {
            addCriterion("wq_PH not between", value1, value2, "wqPh");
            return (Criteria) this;
        }

        public Criteria andWqTurbidityIsNull() {
            addCriterion("wq_turbidity is null");
            return (Criteria) this;
        }

        public Criteria andWqTurbidityIsNotNull() {
            addCriterion("wq_turbidity is not null");
            return (Criteria) this;
        }

        public Criteria andWqTurbidityEqualTo(String value) {
            addCriterion("wq_turbidity =", value, "wqTurbidity");
            return (Criteria) this;
        }

        public Criteria andWqTurbidityNotEqualTo(String value) {
            addCriterion("wq_turbidity <>", value, "wqTurbidity");
            return (Criteria) this;
        }

        public Criteria andWqTurbidityGreaterThan(String value) {
            addCriterion("wq_turbidity >", value, "wqTurbidity");
            return (Criteria) this;
        }

        public Criteria andWqTurbidityGreaterThanOrEqualTo(String value) {
            addCriterion("wq_turbidity >=", value, "wqTurbidity");
            return (Criteria) this;
        }

        public Criteria andWqTurbidityLessThan(String value) {
            addCriterion("wq_turbidity <", value, "wqTurbidity");
            return (Criteria) this;
        }

        public Criteria andWqTurbidityLessThanOrEqualTo(String value) {
            addCriterion("wq_turbidity <=", value, "wqTurbidity");
            return (Criteria) this;
        }

        public Criteria andWqTurbidityLike(String value) {
            addCriterion("wq_turbidity like", value, "wqTurbidity");
            return (Criteria) this;
        }

        public Criteria andWqTurbidityNotLike(String value) {
            addCriterion("wq_turbidity not like", value, "wqTurbidity");
            return (Criteria) this;
        }

        public Criteria andWqTurbidityIn(List<String> values) {
            addCriterion("wq_turbidity in", values, "wqTurbidity");
            return (Criteria) this;
        }

        public Criteria andWqTurbidityNotIn(List<String> values) {
            addCriterion("wq_turbidity not in", values, "wqTurbidity");
            return (Criteria) this;
        }

        public Criteria andWqTurbidityBetween(String value1, String value2) {
            addCriterion("wq_turbidity between", value1, value2, "wqTurbidity");
            return (Criteria) this;
        }

        public Criteria andWqTurbidityNotBetween(String value1, String value2) {
            addCriterion("wq_turbidity not between", value1, value2, "wqTurbidity");
            return (Criteria) this;
        }

        public Criteria andWqChllIsNull() {
            addCriterion("wq_chll is null");
            return (Criteria) this;
        }

        public Criteria andWqChllIsNotNull() {
            addCriterion("wq_chll is not null");
            return (Criteria) this;
        }

        public Criteria andWqChllEqualTo(String value) {
            addCriterion("wq_chll =", value, "wqChll");
            return (Criteria) this;
        }

        public Criteria andWqChllNotEqualTo(String value) {
            addCriterion("wq_chll <>", value, "wqChll");
            return (Criteria) this;
        }

        public Criteria andWqChllGreaterThan(String value) {
            addCriterion("wq_chll >", value, "wqChll");
            return (Criteria) this;
        }

        public Criteria andWqChllGreaterThanOrEqualTo(String value) {
            addCriterion("wq_chll >=", value, "wqChll");
            return (Criteria) this;
        }

        public Criteria andWqChllLessThan(String value) {
            addCriterion("wq_chll <", value, "wqChll");
            return (Criteria) this;
        }

        public Criteria andWqChllLessThanOrEqualTo(String value) {
            addCriterion("wq_chll <=", value, "wqChll");
            return (Criteria) this;
        }

        public Criteria andWqChllLike(String value) {
            addCriterion("wq_chll like", value, "wqChll");
            return (Criteria) this;
        }

        public Criteria andWqChllNotLike(String value) {
            addCriterion("wq_chll not like", value, "wqChll");
            return (Criteria) this;
        }

        public Criteria andWqChllIn(List<String> values) {
            addCriterion("wq_chll in", values, "wqChll");
            return (Criteria) this;
        }

        public Criteria andWqChllNotIn(List<String> values) {
            addCriterion("wq_chll not in", values, "wqChll");
            return (Criteria) this;
        }

        public Criteria andWqChllBetween(String value1, String value2) {
            addCriterion("wq_chll between", value1, value2, "wqChll");
            return (Criteria) this;
        }

        public Criteria andWqChllNotBetween(String value1, String value2) {
            addCriterion("wq_chll not between", value1, value2, "wqChll");
            return (Criteria) this;
        }

        public Criteria andWqSaltempIsNull() {
            addCriterion("wq_saltemp is null");
            return (Criteria) this;
        }

        public Criteria andWqSaltempIsNotNull() {
            addCriterion("wq_saltemp is not null");
            return (Criteria) this;
        }

        public Criteria andWqSaltempEqualTo(String value) {
            addCriterion("wq_saltemp =", value, "wqSaltemp");
            return (Criteria) this;
        }

        public Criteria andWqSaltempNotEqualTo(String value) {
            addCriterion("wq_saltemp <>", value, "wqSaltemp");
            return (Criteria) this;
        }

        public Criteria andWqSaltempGreaterThan(String value) {
            addCriterion("wq_saltemp >", value, "wqSaltemp");
            return (Criteria) this;
        }

        public Criteria andWqSaltempGreaterThanOrEqualTo(String value) {
            addCriterion("wq_saltemp >=", value, "wqSaltemp");
            return (Criteria) this;
        }

        public Criteria andWqSaltempLessThan(String value) {
            addCriterion("wq_saltemp <", value, "wqSaltemp");
            return (Criteria) this;
        }

        public Criteria andWqSaltempLessThanOrEqualTo(String value) {
            addCriterion("wq_saltemp <=", value, "wqSaltemp");
            return (Criteria) this;
        }

        public Criteria andWqSaltempLike(String value) {
            addCriterion("wq_saltemp like", value, "wqSaltemp");
            return (Criteria) this;
        }

        public Criteria andWqSaltempNotLike(String value) {
            addCriterion("wq_saltemp not like", value, "wqSaltemp");
            return (Criteria) this;
        }

        public Criteria andWqSaltempIn(List<String> values) {
            addCriterion("wq_saltemp in", values, "wqSaltemp");
            return (Criteria) this;
        }

        public Criteria andWqSaltempNotIn(List<String> values) {
            addCriterion("wq_saltemp not in", values, "wqSaltemp");
            return (Criteria) this;
        }

        public Criteria andWqSaltempBetween(String value1, String value2) {
            addCriterion("wq_saltemp between", value1, value2, "wqSaltemp");
            return (Criteria) this;
        }

        public Criteria andWqSaltempNotBetween(String value1, String value2) {
            addCriterion("wq_saltemp not between", value1, value2, "wqSaltemp");
            return (Criteria) this;
        }

        public Criteria andWqCo2IsNull() {
            addCriterion("wq_co2 is null");
            return (Criteria) this;
        }

        public Criteria andWqCo2IsNotNull() {
            addCriterion("wq_co2 is not null");
            return (Criteria) this;
        }

        public Criteria andWqCo2EqualTo(String value) {
            addCriterion("wq_co2 =", value, "wqCo2");
            return (Criteria) this;
        }

        public Criteria andWqCo2NotEqualTo(String value) {
            addCriterion("wq_co2 <>", value, "wqCo2");
            return (Criteria) this;
        }

        public Criteria andWqCo2GreaterThan(String value) {
            addCriterion("wq_co2 >", value, "wqCo2");
            return (Criteria) this;
        }

        public Criteria andWqCo2GreaterThanOrEqualTo(String value) {
            addCriterion("wq_co2 >=", value, "wqCo2");
            return (Criteria) this;
        }

        public Criteria andWqCo2LessThan(String value) {
            addCriterion("wq_co2 <", value, "wqCo2");
            return (Criteria) this;
        }

        public Criteria andWqCo2LessThanOrEqualTo(String value) {
            addCriterion("wq_co2 <=", value, "wqCo2");
            return (Criteria) this;
        }

        public Criteria andWqCo2Like(String value) {
            addCriterion("wq_co2 like", value, "wqCo2");
            return (Criteria) this;
        }

        public Criteria andWqCo2NotLike(String value) {
            addCriterion("wq_co2 not like", value, "wqCo2");
            return (Criteria) this;
        }

        public Criteria andWqCo2In(List<String> values) {
            addCriterion("wq_co2 in", values, "wqCo2");
            return (Criteria) this;
        }

        public Criteria andWqCo2NotIn(List<String> values) {
            addCriterion("wq_co2 not in", values, "wqCo2");
            return (Criteria) this;
        }

        public Criteria andWqCo2Between(String value1, String value2) {
            addCriterion("wq_co2 between", value1, value2, "wqCo2");
            return (Criteria) this;
        }

        public Criteria andWqCo2NotBetween(String value1, String value2) {
            addCriterion("wq_co2 not between", value1, value2, "wqCo2");
            return (Criteria) this;
        }

        public Criteria andWqScIsNull() {
            addCriterion("wq_sc is null");
            return (Criteria) this;
        }

        public Criteria andWqScIsNotNull() {
            addCriterion("wq_sc is not null");
            return (Criteria) this;
        }

        public Criteria andWqScEqualTo(String value) {
            addCriterion("wq_sc =", value, "wqSc");
            return (Criteria) this;
        }

        public Criteria andWqScNotEqualTo(String value) {
            addCriterion("wq_sc <>", value, "wqSc");
            return (Criteria) this;
        }

        public Criteria andWqScGreaterThan(String value) {
            addCriterion("wq_sc >", value, "wqSc");
            return (Criteria) this;
        }

        public Criteria andWqScGreaterThanOrEqualTo(String value) {
            addCriterion("wq_sc >=", value, "wqSc");
            return (Criteria) this;
        }

        public Criteria andWqScLessThan(String value) {
            addCriterion("wq_sc <", value, "wqSc");
            return (Criteria) this;
        }

        public Criteria andWqScLessThanOrEqualTo(String value) {
            addCriterion("wq_sc <=", value, "wqSc");
            return (Criteria) this;
        }

        public Criteria andWqScLike(String value) {
            addCriterion("wq_sc like", value, "wqSc");
            return (Criteria) this;
        }

        public Criteria andWqScNotLike(String value) {
            addCriterion("wq_sc not like", value, "wqSc");
            return (Criteria) this;
        }

        public Criteria andWqScIn(List<String> values) {
            addCriterion("wq_sc in", values, "wqSc");
            return (Criteria) this;
        }

        public Criteria andWqScNotIn(List<String> values) {
            addCriterion("wq_sc not in", values, "wqSc");
            return (Criteria) this;
        }

        public Criteria andWqScBetween(String value1, String value2) {
            addCriterion("wq_sc between", value1, value2, "wqSc");
            return (Criteria) this;
        }

        public Criteria andWqScNotBetween(String value1, String value2) {
            addCriterion("wq_sc not between", value1, value2, "wqSc");
            return (Criteria) this;
        }

        public Criteria andWqDatafromIsNull() {
            addCriterion("wq_datafrom is null");
            return (Criteria) this;
        }

        public Criteria andWqDatafromIsNotNull() {
            addCriterion("wq_datafrom is not null");
            return (Criteria) this;
        }

        public Criteria andWqDatafromEqualTo(String value) {
            addCriterion("wq_datafrom =", value, "wqDatafrom");
            return (Criteria) this;
        }

        public Criteria andWqDatafromNotEqualTo(String value) {
            addCriterion("wq_datafrom <>", value, "wqDatafrom");
            return (Criteria) this;
        }

        public Criteria andWqDatafromGreaterThan(String value) {
            addCriterion("wq_datafrom >", value, "wqDatafrom");
            return (Criteria) this;
        }

        public Criteria andWqDatafromGreaterThanOrEqualTo(String value) {
            addCriterion("wq_datafrom >=", value, "wqDatafrom");
            return (Criteria) this;
        }

        public Criteria andWqDatafromLessThan(String value) {
            addCriterion("wq_datafrom <", value, "wqDatafrom");
            return (Criteria) this;
        }

        public Criteria andWqDatafromLessThanOrEqualTo(String value) {
            addCriterion("wq_datafrom <=", value, "wqDatafrom");
            return (Criteria) this;
        }

        public Criteria andWqDatafromLike(String value) {
            addCriterion("wq_datafrom like", value, "wqDatafrom");
            return (Criteria) this;
        }

        public Criteria andWqDatafromNotLike(String value) {
            addCriterion("wq_datafrom not like", value, "wqDatafrom");
            return (Criteria) this;
        }

        public Criteria andWqDatafromIn(List<String> values) {
            addCriterion("wq_datafrom in", values, "wqDatafrom");
            return (Criteria) this;
        }

        public Criteria andWqDatafromNotIn(List<String> values) {
            addCriterion("wq_datafrom not in", values, "wqDatafrom");
            return (Criteria) this;
        }

        public Criteria andWqDatafromBetween(String value1, String value2) {
            addCriterion("wq_datafrom between", value1, value2, "wqDatafrom");
            return (Criteria) this;
        }

        public Criteria andWqDatafromNotBetween(String value1, String value2) {
            addCriterion("wq_datafrom not between", value1, value2, "wqDatafrom");
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