package com.buoy.entity;

import java.util.ArrayList;
import java.util.List;

public class BuoyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BuoyExample() {
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

        public Criteria andBIdIsNull() {
            addCriterion("b_id is null");
            return (Criteria) this;
        }

        public Criteria andBIdIsNotNull() {
            addCriterion("b_id is not null");
            return (Criteria) this;
        }

        public Criteria andBIdEqualTo(Integer value) {
            addCriterion("b_id =", value, "bId");
            return (Criteria) this;
        }

        public Criteria andBIdNotEqualTo(Integer value) {
            addCriterion("b_id <>", value, "bId");
            return (Criteria) this;
        }

        public Criteria andBIdGreaterThan(Integer value) {
            addCriterion("b_id >", value, "bId");
            return (Criteria) this;
        }

        public Criteria andBIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("b_id >=", value, "bId");
            return (Criteria) this;
        }

        public Criteria andBIdLessThan(Integer value) {
            addCriterion("b_id <", value, "bId");
            return (Criteria) this;
        }

        public Criteria andBIdLessThanOrEqualTo(Integer value) {
            addCriterion("b_id <=", value, "bId");
            return (Criteria) this;
        }

        public Criteria andBIdIn(List<Integer> values) {
            addCriterion("b_id in", values, "bId");
            return (Criteria) this;
        }

        public Criteria andBIdNotIn(List<Integer> values) {
            addCriterion("b_id not in", values, "bId");
            return (Criteria) this;
        }

        public Criteria andBIdBetween(Integer value1, Integer value2) {
            addCriterion("b_id between", value1, value2, "bId");
            return (Criteria) this;
        }

        public Criteria andBIdNotBetween(Integer value1, Integer value2) {
            addCriterion("b_id not between", value1, value2, "bId");
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

        public Criteria andBBuoyidIsNull() {
            addCriterion("b_buoyid is null");
            return (Criteria) this;
        }

        public Criteria andBBuoyidIsNotNull() {
            addCriterion("b_buoyid is not null");
            return (Criteria) this;
        }

        public Criteria andBBuoyidEqualTo(String value) {
            addCriterion("b_buoyid =", value, "bBuoyid");
            return (Criteria) this;
        }

        public Criteria andBBuoyidNotEqualTo(String value) {
            addCriterion("b_buoyid <>", value, "bBuoyid");
            return (Criteria) this;
        }

        public Criteria andBBuoyidGreaterThan(String value) {
            addCriterion("b_buoyid >", value, "bBuoyid");
            return (Criteria) this;
        }

        public Criteria andBBuoyidGreaterThanOrEqualTo(String value) {
            addCriterion("b_buoyid >=", value, "bBuoyid");
            return (Criteria) this;
        }

        public Criteria andBBuoyidLessThan(String value) {
            addCriterion("b_buoyid <", value, "bBuoyid");
            return (Criteria) this;
        }

        public Criteria andBBuoyidLessThanOrEqualTo(String value) {
            addCriterion("b_buoyid <=", value, "bBuoyid");
            return (Criteria) this;
        }

        public Criteria andBBuoyidLike(String value) {
            addCriterion("b_buoyid like", value, "bBuoyid");
            return (Criteria) this;
        }

        public Criteria andBBuoyidNotLike(String value) {
            addCriterion("b_buoyid not like", value, "bBuoyid");
            return (Criteria) this;
        }

        public Criteria andBBuoyidIn(List<String> values) {
            addCriterion("b_buoyid in", values, "bBuoyid");
            return (Criteria) this;
        }

        public Criteria andBBuoyidNotIn(List<String> values) {
            addCriterion("b_buoyid not in", values, "bBuoyid");
            return (Criteria) this;
        }

        public Criteria andBBuoyidBetween(String value1, String value2) {
            addCriterion("b_buoyid between", value1, value2, "bBuoyid");
            return (Criteria) this;
        }

        public Criteria andBBuoyidNotBetween(String value1, String value2) {
            addCriterion("b_buoyid not between", value1, value2, "bBuoyid");
            return (Criteria) this;
        }

        public Criteria andBMnumIsNull() {
            addCriterion("b_Mnum is null");
            return (Criteria) this;
        }

        public Criteria andBMnumIsNotNull() {
            addCriterion("b_Mnum is not null");
            return (Criteria) this;
        }

        public Criteria andBMnumEqualTo(String value) {
            addCriterion("b_Mnum =", value, "bMnum");
            return (Criteria) this;
        }

        public Criteria andBMnumNotEqualTo(String value) {
            addCriterion("b_Mnum <>", value, "bMnum");
            return (Criteria) this;
        }

        public Criteria andBMnumGreaterThan(String value) {
            addCriterion("b_Mnum >", value, "bMnum");
            return (Criteria) this;
        }

        public Criteria andBMnumGreaterThanOrEqualTo(String value) {
            addCriterion("b_Mnum >=", value, "bMnum");
            return (Criteria) this;
        }

        public Criteria andBMnumLessThan(String value) {
            addCriterion("b_Mnum <", value, "bMnum");
            return (Criteria) this;
        }

        public Criteria andBMnumLessThanOrEqualTo(String value) {
            addCriterion("b_Mnum <=", value, "bMnum");
            return (Criteria) this;
        }

        public Criteria andBMnumLike(String value) {
            addCriterion("b_Mnum like", value, "bMnum");
            return (Criteria) this;
        }

        public Criteria andBMnumNotLike(String value) {
            addCriterion("b_Mnum not like", value, "bMnum");
            return (Criteria) this;
        }

        public Criteria andBMnumIn(List<String> values) {
            addCriterion("b_Mnum in", values, "bMnum");
            return (Criteria) this;
        }

        public Criteria andBMnumNotIn(List<String> values) {
            addCriterion("b_Mnum not in", values, "bMnum");
            return (Criteria) this;
        }

        public Criteria andBMnumBetween(String value1, String value2) {
            addCriterion("b_Mnum between", value1, value2, "bMnum");
            return (Criteria) this;
        }

        public Criteria andBMnumNotBetween(String value1, String value2) {
            addCriterion("b_Mnum not between", value1, value2, "bMnum");
            return (Criteria) this;
        }

        public Criteria andBRwIsNull() {
            addCriterion("b_rw is null");
            return (Criteria) this;
        }

        public Criteria andBRwIsNotNull() {
            addCriterion("b_rw is not null");
            return (Criteria) this;
        }

        public Criteria andBRwEqualTo(String value) {
            addCriterion("b_rw =", value, "bRw");
            return (Criteria) this;
        }

        public Criteria andBRwNotEqualTo(String value) {
            addCriterion("b_rw <>", value, "bRw");
            return (Criteria) this;
        }

        public Criteria andBRwGreaterThan(String value) {
            addCriterion("b_rw >", value, "bRw");
            return (Criteria) this;
        }

        public Criteria andBRwGreaterThanOrEqualTo(String value) {
            addCriterion("b_rw >=", value, "bRw");
            return (Criteria) this;
        }

        public Criteria andBRwLessThan(String value) {
            addCriterion("b_rw <", value, "bRw");
            return (Criteria) this;
        }

        public Criteria andBRwLessThanOrEqualTo(String value) {
            addCriterion("b_rw <=", value, "bRw");
            return (Criteria) this;
        }

        public Criteria andBRwLike(String value) {
            addCriterion("b_rw like", value, "bRw");
            return (Criteria) this;
        }

        public Criteria andBRwNotLike(String value) {
            addCriterion("b_rw not like", value, "bRw");
            return (Criteria) this;
        }

        public Criteria andBRwIn(List<String> values) {
            addCriterion("b_rw in", values, "bRw");
            return (Criteria) this;
        }

        public Criteria andBRwNotIn(List<String> values) {
            addCriterion("b_rw not in", values, "bRw");
            return (Criteria) this;
        }

        public Criteria andBRwBetween(String value1, String value2) {
            addCriterion("b_rw between", value1, value2, "bRw");
            return (Criteria) this;
        }

        public Criteria andBRwNotBetween(String value1, String value2) {
            addCriterion("b_rw not between", value1, value2, "bRw");
            return (Criteria) this;
        }

        public Criteria andBLongitudeIsNull() {
            addCriterion("b_longitude is null");
            return (Criteria) this;
        }

        public Criteria andBLongitudeIsNotNull() {
            addCriterion("b_longitude is not null");
            return (Criteria) this;
        }

        public Criteria andBLongitudeEqualTo(String value) {
            addCriterion("b_longitude =", value, "bLongitude");
            return (Criteria) this;
        }

        public Criteria andBLongitudeNotEqualTo(String value) {
            addCriterion("b_longitude <>", value, "bLongitude");
            return (Criteria) this;
        }

        public Criteria andBLongitudeGreaterThan(String value) {
            addCriterion("b_longitude >", value, "bLongitude");
            return (Criteria) this;
        }

        public Criteria andBLongitudeGreaterThanOrEqualTo(String value) {
            addCriterion("b_longitude >=", value, "bLongitude");
            return (Criteria) this;
        }

        public Criteria andBLongitudeLessThan(String value) {
            addCriterion("b_longitude <", value, "bLongitude");
            return (Criteria) this;
        }

        public Criteria andBLongitudeLessThanOrEqualTo(String value) {
            addCriterion("b_longitude <=", value, "bLongitude");
            return (Criteria) this;
        }

        public Criteria andBLongitudeLike(String value) {
            addCriterion("b_longitude like", value, "bLongitude");
            return (Criteria) this;
        }

        public Criteria andBLongitudeNotLike(String value) {
            addCriterion("b_longitude not like", value, "bLongitude");
            return (Criteria) this;
        }

        public Criteria andBLongitudeIn(List<String> values) {
            addCriterion("b_longitude in", values, "bLongitude");
            return (Criteria) this;
        }

        public Criteria andBLongitudeNotIn(List<String> values) {
            addCriterion("b_longitude not in", values, "bLongitude");
            return (Criteria) this;
        }

        public Criteria andBLongitudeBetween(String value1, String value2) {
            addCriterion("b_longitude between", value1, value2, "bLongitude");
            return (Criteria) this;
        }

        public Criteria andBLongitudeNotBetween(String value1, String value2) {
            addCriterion("b_longitude not between", value1, value2, "bLongitude");
            return (Criteria) this;
        }

        public Criteria andBLatitudeIsNull() {
            addCriterion("b_latitude is null");
            return (Criteria) this;
        }

        public Criteria andBLatitudeIsNotNull() {
            addCriterion("b_latitude is not null");
            return (Criteria) this;
        }

        public Criteria andBLatitudeEqualTo(String value) {
            addCriterion("b_latitude =", value, "bLatitude");
            return (Criteria) this;
        }

        public Criteria andBLatitudeNotEqualTo(String value) {
            addCriterion("b_latitude <>", value, "bLatitude");
            return (Criteria) this;
        }

        public Criteria andBLatitudeGreaterThan(String value) {
            addCriterion("b_latitude >", value, "bLatitude");
            return (Criteria) this;
        }

        public Criteria andBLatitudeGreaterThanOrEqualTo(String value) {
            addCriterion("b_latitude >=", value, "bLatitude");
            return (Criteria) this;
        }

        public Criteria andBLatitudeLessThan(String value) {
            addCriterion("b_latitude <", value, "bLatitude");
            return (Criteria) this;
        }

        public Criteria andBLatitudeLessThanOrEqualTo(String value) {
            addCriterion("b_latitude <=", value, "bLatitude");
            return (Criteria) this;
        }

        public Criteria andBLatitudeLike(String value) {
            addCriterion("b_latitude like", value, "bLatitude");
            return (Criteria) this;
        }

        public Criteria andBLatitudeNotLike(String value) {
            addCriterion("b_latitude not like", value, "bLatitude");
            return (Criteria) this;
        }

        public Criteria andBLatitudeIn(List<String> values) {
            addCriterion("b_latitude in", values, "bLatitude");
            return (Criteria) this;
        }

        public Criteria andBLatitudeNotIn(List<String> values) {
            addCriterion("b_latitude not in", values, "bLatitude");
            return (Criteria) this;
        }

        public Criteria andBLatitudeBetween(String value1, String value2) {
            addCriterion("b_latitude between", value1, value2, "bLatitude");
            return (Criteria) this;
        }

        public Criteria andBLatitudeNotBetween(String value1, String value2) {
            addCriterion("b_latitude not between", value1, value2, "bLatitude");
            return (Criteria) this;
        }

        public Criteria andBBearingIsNull() {
            addCriterion("b_bearing is null");
            return (Criteria) this;
        }

        public Criteria andBBearingIsNotNull() {
            addCriterion("b_bearing is not null");
            return (Criteria) this;
        }

        public Criteria andBBearingEqualTo(String value) {
            addCriterion("b_bearing =", value, "bBearing");
            return (Criteria) this;
        }

        public Criteria andBBearingNotEqualTo(String value) {
            addCriterion("b_bearing <>", value, "bBearing");
            return (Criteria) this;
        }

        public Criteria andBBearingGreaterThan(String value) {
            addCriterion("b_bearing >", value, "bBearing");
            return (Criteria) this;
        }

        public Criteria andBBearingGreaterThanOrEqualTo(String value) {
            addCriterion("b_bearing >=", value, "bBearing");
            return (Criteria) this;
        }

        public Criteria andBBearingLessThan(String value) {
            addCriterion("b_bearing <", value, "bBearing");
            return (Criteria) this;
        }

        public Criteria andBBearingLessThanOrEqualTo(String value) {
            addCriterion("b_bearing <=", value, "bBearing");
            return (Criteria) this;
        }

        public Criteria andBBearingLike(String value) {
            addCriterion("b_bearing like", value, "bBearing");
            return (Criteria) this;
        }

        public Criteria andBBearingNotLike(String value) {
            addCriterion("b_bearing not like", value, "bBearing");
            return (Criteria) this;
        }

        public Criteria andBBearingIn(List<String> values) {
            addCriterion("b_bearing in", values, "bBearing");
            return (Criteria) this;
        }

        public Criteria andBBearingNotIn(List<String> values) {
            addCriterion("b_bearing not in", values, "bBearing");
            return (Criteria) this;
        }

        public Criteria andBBearingBetween(String value1, String value2) {
            addCriterion("b_bearing between", value1, value2, "bBearing");
            return (Criteria) this;
        }

        public Criteria andBBearingNotBetween(String value1, String value2) {
            addCriterion("b_bearing not between", value1, value2, "bBearing");
            return (Criteria) this;
        }

        public Criteria andBVoltageIsNull() {
            addCriterion("b_voltage is null");
            return (Criteria) this;
        }

        public Criteria andBVoltageIsNotNull() {
            addCriterion("b_voltage is not null");
            return (Criteria) this;
        }

        public Criteria andBVoltageEqualTo(String value) {
            addCriterion("b_voltage =", value, "bVoltage");
            return (Criteria) this;
        }

        public Criteria andBVoltageNotEqualTo(String value) {
            addCriterion("b_voltage <>", value, "bVoltage");
            return (Criteria) this;
        }

        public Criteria andBVoltageGreaterThan(String value) {
            addCriterion("b_voltage >", value, "bVoltage");
            return (Criteria) this;
        }

        public Criteria andBVoltageGreaterThanOrEqualTo(String value) {
            addCriterion("b_voltage >=", value, "bVoltage");
            return (Criteria) this;
        }

        public Criteria andBVoltageLessThan(String value) {
            addCriterion("b_voltage <", value, "bVoltage");
            return (Criteria) this;
        }

        public Criteria andBVoltageLessThanOrEqualTo(String value) {
            addCriterion("b_voltage <=", value, "bVoltage");
            return (Criteria) this;
        }

        public Criteria andBVoltageLike(String value) {
            addCriterion("b_voltage like", value, "bVoltage");
            return (Criteria) this;
        }

        public Criteria andBVoltageNotLike(String value) {
            addCriterion("b_voltage not like", value, "bVoltage");
            return (Criteria) this;
        }

        public Criteria andBVoltageIn(List<String> values) {
            addCriterion("b_voltage in", values, "bVoltage");
            return (Criteria) this;
        }

        public Criteria andBVoltageNotIn(List<String> values) {
            addCriterion("b_voltage not in", values, "bVoltage");
            return (Criteria) this;
        }

        public Criteria andBVoltageBetween(String value1, String value2) {
            addCriterion("b_voltage between", value1, value2, "bVoltage");
            return (Criteria) this;
        }

        public Criteria andBVoltageNotBetween(String value1, String value2) {
            addCriterion("b_voltage not between", value1, value2, "bVoltage");
            return (Criteria) this;
        }

        public Criteria andBRidlightIsNull() {
            addCriterion("b_ridlight is null");
            return (Criteria) this;
        }

        public Criteria andBRidlightIsNotNull() {
            addCriterion("b_ridlight is not null");
            return (Criteria) this;
        }

        public Criteria andBRidlightEqualTo(String value) {
            addCriterion("b_ridlight =", value, "bRidlight");
            return (Criteria) this;
        }

        public Criteria andBRidlightNotEqualTo(String value) {
            addCriterion("b_ridlight <>", value, "bRidlight");
            return (Criteria) this;
        }

        public Criteria andBRidlightGreaterThan(String value) {
            addCriterion("b_ridlight >", value, "bRidlight");
            return (Criteria) this;
        }

        public Criteria andBRidlightGreaterThanOrEqualTo(String value) {
            addCriterion("b_ridlight >=", value, "bRidlight");
            return (Criteria) this;
        }

        public Criteria andBRidlightLessThan(String value) {
            addCriterion("b_ridlight <", value, "bRidlight");
            return (Criteria) this;
        }

        public Criteria andBRidlightLessThanOrEqualTo(String value) {
            addCriterion("b_ridlight <=", value, "bRidlight");
            return (Criteria) this;
        }

        public Criteria andBRidlightLike(String value) {
            addCriterion("b_ridlight like", value, "bRidlight");
            return (Criteria) this;
        }

        public Criteria andBRidlightNotLike(String value) {
            addCriterion("b_ridlight not like", value, "bRidlight");
            return (Criteria) this;
        }

        public Criteria andBRidlightIn(List<String> values) {
            addCriterion("b_ridlight in", values, "bRidlight");
            return (Criteria) this;
        }

        public Criteria andBRidlightNotIn(List<String> values) {
            addCriterion("b_ridlight not in", values, "bRidlight");
            return (Criteria) this;
        }

        public Criteria andBRidlightBetween(String value1, String value2) {
            addCriterion("b_ridlight between", value1, value2, "bRidlight");
            return (Criteria) this;
        }

        public Criteria andBRidlightNotBetween(String value1, String value2) {
            addCriterion("b_ridlight not between", value1, value2, "bRidlight");
            return (Criteria) this;
        }

        public Criteria andBWatpoliceIsNull() {
            addCriterion("b_watpolice is null");
            return (Criteria) this;
        }

        public Criteria andBWatpoliceIsNotNull() {
            addCriterion("b_watpolice is not null");
            return (Criteria) this;
        }

        public Criteria andBWatpoliceEqualTo(String value) {
            addCriterion("b_watpolice =", value, "bWatpolice");
            return (Criteria) this;
        }

        public Criteria andBWatpoliceNotEqualTo(String value) {
            addCriterion("b_watpolice <>", value, "bWatpolice");
            return (Criteria) this;
        }

        public Criteria andBWatpoliceGreaterThan(String value) {
            addCriterion("b_watpolice >", value, "bWatpolice");
            return (Criteria) this;
        }

        public Criteria andBWatpoliceGreaterThanOrEqualTo(String value) {
            addCriterion("b_watpolice >=", value, "bWatpolice");
            return (Criteria) this;
        }

        public Criteria andBWatpoliceLessThan(String value) {
            addCriterion("b_watpolice <", value, "bWatpolice");
            return (Criteria) this;
        }

        public Criteria andBWatpoliceLessThanOrEqualTo(String value) {
            addCriterion("b_watpolice <=", value, "bWatpolice");
            return (Criteria) this;
        }

        public Criteria andBWatpoliceLike(String value) {
            addCriterion("b_watpolice like", value, "bWatpolice");
            return (Criteria) this;
        }

        public Criteria andBWatpoliceNotLike(String value) {
            addCriterion("b_watpolice not like", value, "bWatpolice");
            return (Criteria) this;
        }

        public Criteria andBWatpoliceIn(List<String> values) {
            addCriterion("b_watpolice in", values, "bWatpolice");
            return (Criteria) this;
        }

        public Criteria andBWatpoliceNotIn(List<String> values) {
            addCriterion("b_watpolice not in", values, "bWatpolice");
            return (Criteria) this;
        }

        public Criteria andBWatpoliceBetween(String value1, String value2) {
            addCriterion("b_watpolice between", value1, value2, "bWatpolice");
            return (Criteria) this;
        }

        public Criteria andBWatpoliceNotBetween(String value1, String value2) {
            addCriterion("b_watpolice not between", value1, value2, "bWatpolice");
            return (Criteria) this;
        }

        public Criteria andBDoorpoliceIsNull() {
            addCriterion("b_doorpolice is null");
            return (Criteria) this;
        }

        public Criteria andBDoorpoliceIsNotNull() {
            addCriterion("b_doorpolice is not null");
            return (Criteria) this;
        }

        public Criteria andBDoorpoliceEqualTo(String value) {
            addCriterion("b_doorpolice =", value, "bDoorpolice");
            return (Criteria) this;
        }

        public Criteria andBDoorpoliceNotEqualTo(String value) {
            addCriterion("b_doorpolice <>", value, "bDoorpolice");
            return (Criteria) this;
        }

        public Criteria andBDoorpoliceGreaterThan(String value) {
            addCriterion("b_doorpolice >", value, "bDoorpolice");
            return (Criteria) this;
        }

        public Criteria andBDoorpoliceGreaterThanOrEqualTo(String value) {
            addCriterion("b_doorpolice >=", value, "bDoorpolice");
            return (Criteria) this;
        }

        public Criteria andBDoorpoliceLessThan(String value) {
            addCriterion("b_doorpolice <", value, "bDoorpolice");
            return (Criteria) this;
        }

        public Criteria andBDoorpoliceLessThanOrEqualTo(String value) {
            addCriterion("b_doorpolice <=", value, "bDoorpolice");
            return (Criteria) this;
        }

        public Criteria andBDoorpoliceLike(String value) {
            addCriterion("b_doorpolice like", value, "bDoorpolice");
            return (Criteria) this;
        }

        public Criteria andBDoorpoliceNotLike(String value) {
            addCriterion("b_doorpolice not like", value, "bDoorpolice");
            return (Criteria) this;
        }

        public Criteria andBDoorpoliceIn(List<String> values) {
            addCriterion("b_doorpolice in", values, "bDoorpolice");
            return (Criteria) this;
        }

        public Criteria andBDoorpoliceNotIn(List<String> values) {
            addCriterion("b_doorpolice not in", values, "bDoorpolice");
            return (Criteria) this;
        }

        public Criteria andBDoorpoliceBetween(String value1, String value2) {
            addCriterion("b_doorpolice between", value1, value2, "bDoorpolice");
            return (Criteria) this;
        }

        public Criteria andBDoorpoliceNotBetween(String value1, String value2) {
            addCriterion("b_doorpolice not between", value1, value2, "bDoorpolice");
            return (Criteria) this;
        }

        public Criteria andBShiftIsNull() {
            addCriterion("b_shift is null");
            return (Criteria) this;
        }

        public Criteria andBShiftIsNotNull() {
            addCriterion("b_shift is not null");
            return (Criteria) this;
        }

        public Criteria andBShiftEqualTo(String value) {
            addCriterion("b_shift =", value, "bShift");
            return (Criteria) this;
        }

        public Criteria andBShiftNotEqualTo(String value) {
            addCriterion("b_shift <>", value, "bShift");
            return (Criteria) this;
        }

        public Criteria andBShiftGreaterThan(String value) {
            addCriterion("b_shift >", value, "bShift");
            return (Criteria) this;
        }

        public Criteria andBShiftGreaterThanOrEqualTo(String value) {
            addCriterion("b_shift >=", value, "bShift");
            return (Criteria) this;
        }

        public Criteria andBShiftLessThan(String value) {
            addCriterion("b_shift <", value, "bShift");
            return (Criteria) this;
        }

        public Criteria andBShiftLessThanOrEqualTo(String value) {
            addCriterion("b_shift <=", value, "bShift");
            return (Criteria) this;
        }

        public Criteria andBShiftLike(String value) {
            addCriterion("b_shift like", value, "bShift");
            return (Criteria) this;
        }

        public Criteria andBShiftNotLike(String value) {
            addCriterion("b_shift not like", value, "bShift");
            return (Criteria) this;
        }

        public Criteria andBShiftIn(List<String> values) {
            addCriterion("b_shift in", values, "bShift");
            return (Criteria) this;
        }

        public Criteria andBShiftNotIn(List<String> values) {
            addCriterion("b_shift not in", values, "bShift");
            return (Criteria) this;
        }

        public Criteria andBShiftBetween(String value1, String value2) {
            addCriterion("b_shift between", value1, value2, "bShift");
            return (Criteria) this;
        }

        public Criteria andBShiftNotBetween(String value1, String value2) {
            addCriterion("b_shift not between", value1, value2, "bShift");
            return (Criteria) this;
        }

        public Criteria andBHatchIsNull() {
            addCriterion("b_hatch is null");
            return (Criteria) this;
        }

        public Criteria andBHatchIsNotNull() {
            addCriterion("b_hatch is not null");
            return (Criteria) this;
        }

        public Criteria andBHatchEqualTo(String value) {
            addCriterion("b_hatch =", value, "bHatch");
            return (Criteria) this;
        }

        public Criteria andBHatchNotEqualTo(String value) {
            addCriterion("b_hatch <>", value, "bHatch");
            return (Criteria) this;
        }

        public Criteria andBHatchGreaterThan(String value) {
            addCriterion("b_hatch >", value, "bHatch");
            return (Criteria) this;
        }

        public Criteria andBHatchGreaterThanOrEqualTo(String value) {
            addCriterion("b_hatch >=", value, "bHatch");
            return (Criteria) this;
        }

        public Criteria andBHatchLessThan(String value) {
            addCriterion("b_hatch <", value, "bHatch");
            return (Criteria) this;
        }

        public Criteria andBHatchLessThanOrEqualTo(String value) {
            addCriterion("b_hatch <=", value, "bHatch");
            return (Criteria) this;
        }

        public Criteria andBHatchLike(String value) {
            addCriterion("b_hatch like", value, "bHatch");
            return (Criteria) this;
        }

        public Criteria andBHatchNotLike(String value) {
            addCriterion("b_hatch not like", value, "bHatch");
            return (Criteria) this;
        }

        public Criteria andBHatchIn(List<String> values) {
            addCriterion("b_hatch in", values, "bHatch");
            return (Criteria) this;
        }

        public Criteria andBHatchNotIn(List<String> values) {
            addCriterion("b_hatch not in", values, "bHatch");
            return (Criteria) this;
        }

        public Criteria andBHatchBetween(String value1, String value2) {
            addCriterion("b_hatch between", value1, value2, "bHatch");
            return (Criteria) this;
        }

        public Criteria andBHatchNotBetween(String value1, String value2) {
            addCriterion("b_hatch not between", value1, value2, "bHatch");
            return (Criteria) this;
        }

        public Criteria andBPliceIsNull() {
            addCriterion("b_plice is null");
            return (Criteria) this;
        }

        public Criteria andBPliceIsNotNull() {
            addCriterion("b_plice is not null");
            return (Criteria) this;
        }

        public Criteria andBPliceEqualTo(String value) {
            addCriterion("b_plice =", value, "bPlice");
            return (Criteria) this;
        }

        public Criteria andBPliceNotEqualTo(String value) {
            addCriterion("b_plice <>", value, "bPlice");
            return (Criteria) this;
        }

        public Criteria andBPliceGreaterThan(String value) {
            addCriterion("b_plice >", value, "bPlice");
            return (Criteria) this;
        }

        public Criteria andBPliceGreaterThanOrEqualTo(String value) {
            addCriterion("b_plice >=", value, "bPlice");
            return (Criteria) this;
        }

        public Criteria andBPliceLessThan(String value) {
            addCriterion("b_plice <", value, "bPlice");
            return (Criteria) this;
        }

        public Criteria andBPliceLessThanOrEqualTo(String value) {
            addCriterion("b_plice <=", value, "bPlice");
            return (Criteria) this;
        }

        public Criteria andBPliceLike(String value) {
            addCriterion("b_plice like", value, "bPlice");
            return (Criteria) this;
        }

        public Criteria andBPliceNotLike(String value) {
            addCriterion("b_plice not like", value, "bPlice");
            return (Criteria) this;
        }

        public Criteria andBPliceIn(List<String> values) {
            addCriterion("b_plice in", values, "bPlice");
            return (Criteria) this;
        }

        public Criteria andBPliceNotIn(List<String> values) {
            addCriterion("b_plice not in", values, "bPlice");
            return (Criteria) this;
        }

        public Criteria andBPliceBetween(String value1, String value2) {
            addCriterion("b_plice between", value1, value2, "bPlice");
            return (Criteria) this;
        }

        public Criteria andBPliceNotBetween(String value1, String value2) {
            addCriterion("b_plice not between", value1, value2, "bPlice");
            return (Criteria) this;
        }

        public Criteria andBRidlightStatusIsNull() {
            addCriterion("b_ridlight_status is null");
            return (Criteria) this;
        }

        public Criteria andBRidlightStatusIsNotNull() {
            addCriterion("b_ridlight_status is not null");
            return (Criteria) this;
        }

        public Criteria andBRidlightStatusEqualTo(String value) {
            addCriterion("b_ridlight_status =", value, "bRidlightStatus");
            return (Criteria) this;
        }

        public Criteria andBRidlightStatusNotEqualTo(String value) {
            addCriterion("b_ridlight_status <>", value, "bRidlightStatus");
            return (Criteria) this;
        }

        public Criteria andBRidlightStatusGreaterThan(String value) {
            addCriterion("b_ridlight_status >", value, "bRidlightStatus");
            return (Criteria) this;
        }

        public Criteria andBRidlightStatusGreaterThanOrEqualTo(String value) {
            addCriterion("b_ridlight_status >=", value, "bRidlightStatus");
            return (Criteria) this;
        }

        public Criteria andBRidlightStatusLessThan(String value) {
            addCriterion("b_ridlight_status <", value, "bRidlightStatus");
            return (Criteria) this;
        }

        public Criteria andBRidlightStatusLessThanOrEqualTo(String value) {
            addCriterion("b_ridlight_status <=", value, "bRidlightStatus");
            return (Criteria) this;
        }

        public Criteria andBRidlightStatusLike(String value) {
            addCriterion("b_ridlight_status like", value, "bRidlightStatus");
            return (Criteria) this;
        }

        public Criteria andBRidlightStatusNotLike(String value) {
            addCriterion("b_ridlight_status not like", value, "bRidlightStatus");
            return (Criteria) this;
        }

        public Criteria andBRidlightStatusIn(List<String> values) {
            addCriterion("b_ridlight_status in", values, "bRidlightStatus");
            return (Criteria) this;
        }

        public Criteria andBRidlightStatusNotIn(List<String> values) {
            addCriterion("b_ridlight_status not in", values, "bRidlightStatus");
            return (Criteria) this;
        }

        public Criteria andBRidlightStatusBetween(String value1, String value2) {
            addCriterion("b_ridlight_status between", value1, value2, "bRidlightStatus");
            return (Criteria) this;
        }

        public Criteria andBRidlightStatusNotBetween(String value1, String value2) {
            addCriterion("b_ridlight_status not between", value1, value2, "bRidlightStatus");
            return (Criteria) this;
        }

        public Criteria andBWatpoliceStatusIsNull() {
            addCriterion("b_watpolice_status is null");
            return (Criteria) this;
        }

        public Criteria andBWatpoliceStatusIsNotNull() {
            addCriterion("b_watpolice_status is not null");
            return (Criteria) this;
        }

        public Criteria andBWatpoliceStatusEqualTo(String value) {
            addCriterion("b_watpolice_status =", value, "bWatpoliceStatus");
            return (Criteria) this;
        }

        public Criteria andBWatpoliceStatusNotEqualTo(String value) {
            addCriterion("b_watpolice_status <>", value, "bWatpoliceStatus");
            return (Criteria) this;
        }

        public Criteria andBWatpoliceStatusGreaterThan(String value) {
            addCriterion("b_watpolice_status >", value, "bWatpoliceStatus");
            return (Criteria) this;
        }

        public Criteria andBWatpoliceStatusGreaterThanOrEqualTo(String value) {
            addCriterion("b_watpolice_status >=", value, "bWatpoliceStatus");
            return (Criteria) this;
        }

        public Criteria andBWatpoliceStatusLessThan(String value) {
            addCriterion("b_watpolice_status <", value, "bWatpoliceStatus");
            return (Criteria) this;
        }

        public Criteria andBWatpoliceStatusLessThanOrEqualTo(String value) {
            addCriterion("b_watpolice_status <=", value, "bWatpoliceStatus");
            return (Criteria) this;
        }

        public Criteria andBWatpoliceStatusLike(String value) {
            addCriterion("b_watpolice_status like", value, "bWatpoliceStatus");
            return (Criteria) this;
        }

        public Criteria andBWatpoliceStatusNotLike(String value) {
            addCriterion("b_watpolice_status not like", value, "bWatpoliceStatus");
            return (Criteria) this;
        }

        public Criteria andBWatpoliceStatusIn(List<String> values) {
            addCriterion("b_watpolice_status in", values, "bWatpoliceStatus");
            return (Criteria) this;
        }

        public Criteria andBWatpoliceStatusNotIn(List<String> values) {
            addCriterion("b_watpolice_status not in", values, "bWatpoliceStatus");
            return (Criteria) this;
        }

        public Criteria andBWatpoliceStatusBetween(String value1, String value2) {
            addCriterion("b_watpolice_status between", value1, value2, "bWatpoliceStatus");
            return (Criteria) this;
        }

        public Criteria andBWatpoliceStatusNotBetween(String value1, String value2) {
            addCriterion("b_watpolice_status not between", value1, value2, "bWatpoliceStatus");
            return (Criteria) this;
        }

        public Criteria andBShiftStatusIsNull() {
            addCriterion("b_shift_status is null");
            return (Criteria) this;
        }

        public Criteria andBShiftStatusIsNotNull() {
            addCriterion("b_shift_status is not null");
            return (Criteria) this;
        }

        public Criteria andBShiftStatusEqualTo(String value) {
            addCriterion("b_shift_status =", value, "bShiftStatus");
            return (Criteria) this;
        }

        public Criteria andBShiftStatusNotEqualTo(String value) {
            addCriterion("b_shift_status <>", value, "bShiftStatus");
            return (Criteria) this;
        }

        public Criteria andBShiftStatusGreaterThan(String value) {
            addCriterion("b_shift_status >", value, "bShiftStatus");
            return (Criteria) this;
        }

        public Criteria andBShiftStatusGreaterThanOrEqualTo(String value) {
            addCriterion("b_shift_status >=", value, "bShiftStatus");
            return (Criteria) this;
        }

        public Criteria andBShiftStatusLessThan(String value) {
            addCriterion("b_shift_status <", value, "bShiftStatus");
            return (Criteria) this;
        }

        public Criteria andBShiftStatusLessThanOrEqualTo(String value) {
            addCriterion("b_shift_status <=", value, "bShiftStatus");
            return (Criteria) this;
        }

        public Criteria andBShiftStatusLike(String value) {
            addCriterion("b_shift_status like", value, "bShiftStatus");
            return (Criteria) this;
        }

        public Criteria andBShiftStatusNotLike(String value) {
            addCriterion("b_shift_status not like", value, "bShiftStatus");
            return (Criteria) this;
        }

        public Criteria andBShiftStatusIn(List<String> values) {
            addCriterion("b_shift_status in", values, "bShiftStatus");
            return (Criteria) this;
        }

        public Criteria andBShiftStatusNotIn(List<String> values) {
            addCriterion("b_shift_status not in", values, "bShiftStatus");
            return (Criteria) this;
        }

        public Criteria andBShiftStatusBetween(String value1, String value2) {
            addCriterion("b_shift_status between", value1, value2, "bShiftStatus");
            return (Criteria) this;
        }

        public Criteria andBShiftStatusNotBetween(String value1, String value2) {
            addCriterion("b_shift_status not between", value1, value2, "bShiftStatus");
            return (Criteria) this;
        }

        public Criteria andBFreeIsNull() {
            addCriterion("b_free is null");
            return (Criteria) this;
        }

        public Criteria andBFreeIsNotNull() {
            addCriterion("b_free is not null");
            return (Criteria) this;
        }

        public Criteria andBFreeEqualTo(String value) {
            addCriterion("b_free =", value, "bFree");
            return (Criteria) this;
        }

        public Criteria andBFreeNotEqualTo(String value) {
            addCriterion("b_free <>", value, "bFree");
            return (Criteria) this;
        }

        public Criteria andBFreeGreaterThan(String value) {
            addCriterion("b_free >", value, "bFree");
            return (Criteria) this;
        }

        public Criteria andBFreeGreaterThanOrEqualTo(String value) {
            addCriterion("b_free >=", value, "bFree");
            return (Criteria) this;
        }

        public Criteria andBFreeLessThan(String value) {
            addCriterion("b_free <", value, "bFree");
            return (Criteria) this;
        }

        public Criteria andBFreeLessThanOrEqualTo(String value) {
            addCriterion("b_free <=", value, "bFree");
            return (Criteria) this;
        }

        public Criteria andBFreeLike(String value) {
            addCriterion("b_free like", value, "bFree");
            return (Criteria) this;
        }

        public Criteria andBFreeNotLike(String value) {
            addCriterion("b_free not like", value, "bFree");
            return (Criteria) this;
        }

        public Criteria andBFreeIn(List<String> values) {
            addCriterion("b_free in", values, "bFree");
            return (Criteria) this;
        }

        public Criteria andBFreeNotIn(List<String> values) {
            addCriterion("b_free not in", values, "bFree");
            return (Criteria) this;
        }

        public Criteria andBFreeBetween(String value1, String value2) {
            addCriterion("b_free between", value1, value2, "bFree");
            return (Criteria) this;
        }

        public Criteria andBFreeNotBetween(String value1, String value2) {
            addCriterion("b_free not between", value1, value2, "bFree");
            return (Criteria) this;
        }

        public Criteria andBSensorIsNull() {
            addCriterion("b_sensor is null");
            return (Criteria) this;
        }

        public Criteria andBSensorIsNotNull() {
            addCriterion("b_sensor is not null");
            return (Criteria) this;
        }

        public Criteria andBSensorEqualTo(String value) {
            addCriterion("b_sensor =", value, "bSensor");
            return (Criteria) this;
        }

        public Criteria andBSensorNotEqualTo(String value) {
            addCriterion("b_sensor <>", value, "bSensor");
            return (Criteria) this;
        }

        public Criteria andBSensorGreaterThan(String value) {
            addCriterion("b_sensor >", value, "bSensor");
            return (Criteria) this;
        }

        public Criteria andBSensorGreaterThanOrEqualTo(String value) {
            addCriterion("b_sensor >=", value, "bSensor");
            return (Criteria) this;
        }

        public Criteria andBSensorLessThan(String value) {
            addCriterion("b_sensor <", value, "bSensor");
            return (Criteria) this;
        }

        public Criteria andBSensorLessThanOrEqualTo(String value) {
            addCriterion("b_sensor <=", value, "bSensor");
            return (Criteria) this;
        }

        public Criteria andBSensorLike(String value) {
            addCriterion("b_sensor like", value, "bSensor");
            return (Criteria) this;
        }

        public Criteria andBSensorNotLike(String value) {
            addCriterion("b_sensor not like", value, "bSensor");
            return (Criteria) this;
        }

        public Criteria andBSensorIn(List<String> values) {
            addCriterion("b_sensor in", values, "bSensor");
            return (Criteria) this;
        }

        public Criteria andBSensorNotIn(List<String> values) {
            addCriterion("b_sensor not in", values, "bSensor");
            return (Criteria) this;
        }

        public Criteria andBSensorBetween(String value1, String value2) {
            addCriterion("b_sensor between", value1, value2, "bSensor");
            return (Criteria) this;
        }

        public Criteria andBSensorNotBetween(String value1, String value2) {
            addCriterion("b_sensor not between", value1, value2, "bSensor");
            return (Criteria) this;
        }

        public Criteria andBSensorStatusIsNull() {
            addCriterion("b_sensor_status is null");
            return (Criteria) this;
        }

        public Criteria andBSensorStatusIsNotNull() {
            addCriterion("b_sensor_status is not null");
            return (Criteria) this;
        }

        public Criteria andBSensorStatusEqualTo(String value) {
            addCriterion("b_sensor_status =", value, "bSensorStatus");
            return (Criteria) this;
        }

        public Criteria andBSensorStatusNotEqualTo(String value) {
            addCriterion("b_sensor_status <>", value, "bSensorStatus");
            return (Criteria) this;
        }

        public Criteria andBSensorStatusGreaterThan(String value) {
            addCriterion("b_sensor_status >", value, "bSensorStatus");
            return (Criteria) this;
        }

        public Criteria andBSensorStatusGreaterThanOrEqualTo(String value) {
            addCriterion("b_sensor_status >=", value, "bSensorStatus");
            return (Criteria) this;
        }

        public Criteria andBSensorStatusLessThan(String value) {
            addCriterion("b_sensor_status <", value, "bSensorStatus");
            return (Criteria) this;
        }

        public Criteria andBSensorStatusLessThanOrEqualTo(String value) {
            addCriterion("b_sensor_status <=", value, "bSensorStatus");
            return (Criteria) this;
        }

        public Criteria andBSensorStatusLike(String value) {
            addCriterion("b_sensor_status like", value, "bSensorStatus");
            return (Criteria) this;
        }

        public Criteria andBSensorStatusNotLike(String value) {
            addCriterion("b_sensor_status not like", value, "bSensorStatus");
            return (Criteria) this;
        }

        public Criteria andBSensorStatusIn(List<String> values) {
            addCriterion("b_sensor_status in", values, "bSensorStatus");
            return (Criteria) this;
        }

        public Criteria andBSensorStatusNotIn(List<String> values) {
            addCriterion("b_sensor_status not in", values, "bSensorStatus");
            return (Criteria) this;
        }

        public Criteria andBSensorStatusBetween(String value1, String value2) {
            addCriterion("b_sensor_status between", value1, value2, "bSensorStatus");
            return (Criteria) this;
        }

        public Criteria andBSensorStatusNotBetween(String value1, String value2) {
            addCriterion("b_sensor_status not between", value1, value2, "bSensorStatus");
            return (Criteria) this;
        }

        public Criteria andBSensorPoliceIsNull() {
            addCriterion("b_sensor_police is null");
            return (Criteria) this;
        }

        public Criteria andBSensorPoliceIsNotNull() {
            addCriterion("b_sensor_police is not null");
            return (Criteria) this;
        }

        public Criteria andBSensorPoliceEqualTo(String value) {
            addCriterion("b_sensor_police =", value, "bSensorPolice");
            return (Criteria) this;
        }

        public Criteria andBSensorPoliceNotEqualTo(String value) {
            addCriterion("b_sensor_police <>", value, "bSensorPolice");
            return (Criteria) this;
        }

        public Criteria andBSensorPoliceGreaterThan(String value) {
            addCriterion("b_sensor_police >", value, "bSensorPolice");
            return (Criteria) this;
        }

        public Criteria andBSensorPoliceGreaterThanOrEqualTo(String value) {
            addCriterion("b_sensor_police >=", value, "bSensorPolice");
            return (Criteria) this;
        }

        public Criteria andBSensorPoliceLessThan(String value) {
            addCriterion("b_sensor_police <", value, "bSensorPolice");
            return (Criteria) this;
        }

        public Criteria andBSensorPoliceLessThanOrEqualTo(String value) {
            addCriterion("b_sensor_police <=", value, "bSensorPolice");
            return (Criteria) this;
        }

        public Criteria andBSensorPoliceLike(String value) {
            addCriterion("b_sensor_police like", value, "bSensorPolice");
            return (Criteria) this;
        }

        public Criteria andBSensorPoliceNotLike(String value) {
            addCriterion("b_sensor_police not like", value, "bSensorPolice");
            return (Criteria) this;
        }

        public Criteria andBSensorPoliceIn(List<String> values) {
            addCriterion("b_sensor_police in", values, "bSensorPolice");
            return (Criteria) this;
        }

        public Criteria andBSensorPoliceNotIn(List<String> values) {
            addCriterion("b_sensor_police not in", values, "bSensorPolice");
            return (Criteria) this;
        }

        public Criteria andBSensorPoliceBetween(String value1, String value2) {
            addCriterion("b_sensor_police between", value1, value2, "bSensorPolice");
            return (Criteria) this;
        }

        public Criteria andBSensorPoliceNotBetween(String value1, String value2) {
            addCriterion("b_sensor_police not between", value1, value2, "bSensorPolice");
            return (Criteria) this;
        }

        public Criteria andBBreakStatusIsNull() {
            addCriterion("b_break_status is null");
            return (Criteria) this;
        }

        public Criteria andBBreakStatusIsNotNull() {
            addCriterion("b_break_status is not null");
            return (Criteria) this;
        }

        public Criteria andBBreakStatusEqualTo(String value) {
            addCriterion("b_break_status =", value, "bBreakStatus");
            return (Criteria) this;
        }

        public Criteria andBBreakStatusNotEqualTo(String value) {
            addCriterion("b_break_status <>", value, "bBreakStatus");
            return (Criteria) this;
        }

        public Criteria andBBreakStatusGreaterThan(String value) {
            addCriterion("b_break_status >", value, "bBreakStatus");
            return (Criteria) this;
        }

        public Criteria andBBreakStatusGreaterThanOrEqualTo(String value) {
            addCriterion("b_break_status >=", value, "bBreakStatus");
            return (Criteria) this;
        }

        public Criteria andBBreakStatusLessThan(String value) {
            addCriterion("b_break_status <", value, "bBreakStatus");
            return (Criteria) this;
        }

        public Criteria andBBreakStatusLessThanOrEqualTo(String value) {
            addCriterion("b_break_status <=", value, "bBreakStatus");
            return (Criteria) this;
        }

        public Criteria andBBreakStatusLike(String value) {
            addCriterion("b_break_status like", value, "bBreakStatus");
            return (Criteria) this;
        }

        public Criteria andBBreakStatusNotLike(String value) {
            addCriterion("b_break_status not like", value, "bBreakStatus");
            return (Criteria) this;
        }

        public Criteria andBBreakStatusIn(List<String> values) {
            addCriterion("b_break_status in", values, "bBreakStatus");
            return (Criteria) this;
        }

        public Criteria andBBreakStatusNotIn(List<String> values) {
            addCriterion("b_break_status not in", values, "bBreakStatus");
            return (Criteria) this;
        }

        public Criteria andBBreakStatusBetween(String value1, String value2) {
            addCriterion("b_break_status between", value1, value2, "bBreakStatus");
            return (Criteria) this;
        }

        public Criteria andBBreakStatusNotBetween(String value1, String value2) {
            addCriterion("b_break_status not between", value1, value2, "bBreakStatus");
            return (Criteria) this;
        }

        public Criteria andBDatafromIsNull() {
            addCriterion("b_datafrom is null");
            return (Criteria) this;
        }

        public Criteria andBDatafromIsNotNull() {
            addCriterion("b_datafrom is not null");
            return (Criteria) this;
        }

        public Criteria andBDatafromEqualTo(String value) {
            addCriterion("b_datafrom =", value, "bDatafrom");
            return (Criteria) this;
        }

        public Criteria andBDatafromNotEqualTo(String value) {
            addCriterion("b_datafrom <>", value, "bDatafrom");
            return (Criteria) this;
        }

        public Criteria andBDatafromGreaterThan(String value) {
            addCriterion("b_datafrom >", value, "bDatafrom");
            return (Criteria) this;
        }

        public Criteria andBDatafromGreaterThanOrEqualTo(String value) {
            addCriterion("b_datafrom >=", value, "bDatafrom");
            return (Criteria) this;
        }

        public Criteria andBDatafromLessThan(String value) {
            addCriterion("b_datafrom <", value, "bDatafrom");
            return (Criteria) this;
        }

        public Criteria andBDatafromLessThanOrEqualTo(String value) {
            addCriterion("b_datafrom <=", value, "bDatafrom");
            return (Criteria) this;
        }

        public Criteria andBDatafromLike(String value) {
            addCriterion("b_datafrom like", value, "bDatafrom");
            return (Criteria) this;
        }

        public Criteria andBDatafromNotLike(String value) {
            addCriterion("b_datafrom not like", value, "bDatafrom");
            return (Criteria) this;
        }

        public Criteria andBDatafromIn(List<String> values) {
            addCriterion("b_datafrom in", values, "bDatafrom");
            return (Criteria) this;
        }

        public Criteria andBDatafromNotIn(List<String> values) {
            addCriterion("b_datafrom not in", values, "bDatafrom");
            return (Criteria) this;
        }

        public Criteria andBDatafromBetween(String value1, String value2) {
            addCriterion("b_datafrom between", value1, value2, "bDatafrom");
            return (Criteria) this;
        }

        public Criteria andBDatafromNotBetween(String value1, String value2) {
            addCriterion("b_datafrom not between", value1, value2, "bDatafrom");
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