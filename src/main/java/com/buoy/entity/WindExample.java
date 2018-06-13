package com.buoy.entity;

import java.util.ArrayList;
import java.util.List;

public class WindExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WindExample() {
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

        public Criteria andWindIdIsNull() {
            addCriterion("wind_id is null");
            return (Criteria) this;
        }

        public Criteria andWindIdIsNotNull() {
            addCriterion("wind_id is not null");
            return (Criteria) this;
        }

        public Criteria andWindIdEqualTo(Integer value) {
            addCriterion("wind_id =", value, "windId");
            return (Criteria) this;
        }

        public Criteria andWindIdNotEqualTo(Integer value) {
            addCriterion("wind_id <>", value, "windId");
            return (Criteria) this;
        }

        public Criteria andWindIdGreaterThan(Integer value) {
            addCriterion("wind_id >", value, "windId");
            return (Criteria) this;
        }

        public Criteria andWindIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("wind_id >=", value, "windId");
            return (Criteria) this;
        }

        public Criteria andWindIdLessThan(Integer value) {
            addCriterion("wind_id <", value, "windId");
            return (Criteria) this;
        }

        public Criteria andWindIdLessThanOrEqualTo(Integer value) {
            addCriterion("wind_id <=", value, "windId");
            return (Criteria) this;
        }

        public Criteria andWindIdIn(List<Integer> values) {
            addCriterion("wind_id in", values, "windId");
            return (Criteria) this;
        }

        public Criteria andWindIdNotIn(List<Integer> values) {
            addCriterion("wind_id not in", values, "windId");
            return (Criteria) this;
        }

        public Criteria andWindIdBetween(Integer value1, Integer value2) {
            addCriterion("wind_id between", value1, value2, "windId");
            return (Criteria) this;
        }

        public Criteria andWindIdNotBetween(Integer value1, Integer value2) {
            addCriterion("wind_id not between", value1, value2, "windId");
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

        public Criteria andWindBuoyidIsNull() {
            addCriterion("wind_buoyid is null");
            return (Criteria) this;
        }

        public Criteria andWindBuoyidIsNotNull() {
            addCriterion("wind_buoyid is not null");
            return (Criteria) this;
        }

        public Criteria andWindBuoyidEqualTo(String value) {
            addCriterion("wind_buoyid =", value, "windBuoyid");
            return (Criteria) this;
        }

        public Criteria andWindBuoyidNotEqualTo(String value) {
            addCriterion("wind_buoyid <>", value, "windBuoyid");
            return (Criteria) this;
        }

        public Criteria andWindBuoyidGreaterThan(String value) {
            addCriterion("wind_buoyid >", value, "windBuoyid");
            return (Criteria) this;
        }

        public Criteria andWindBuoyidGreaterThanOrEqualTo(String value) {
            addCriterion("wind_buoyid >=", value, "windBuoyid");
            return (Criteria) this;
        }

        public Criteria andWindBuoyidLessThan(String value) {
            addCriterion("wind_buoyid <", value, "windBuoyid");
            return (Criteria) this;
        }

        public Criteria andWindBuoyidLessThanOrEqualTo(String value) {
            addCriterion("wind_buoyid <=", value, "windBuoyid");
            return (Criteria) this;
        }

        public Criteria andWindBuoyidLike(String value) {
            addCriterion("wind_buoyid like", value, "windBuoyid");
            return (Criteria) this;
        }

        public Criteria andWindBuoyidNotLike(String value) {
            addCriterion("wind_buoyid not like", value, "windBuoyid");
            return (Criteria) this;
        }

        public Criteria andWindBuoyidIn(List<String> values) {
            addCriterion("wind_buoyid in", values, "windBuoyid");
            return (Criteria) this;
        }

        public Criteria andWindBuoyidNotIn(List<String> values) {
            addCriterion("wind_buoyid not in", values, "windBuoyid");
            return (Criteria) this;
        }

        public Criteria andWindBuoyidBetween(String value1, String value2) {
            addCriterion("wind_buoyid between", value1, value2, "windBuoyid");
            return (Criteria) this;
        }

        public Criteria andWindBuoyidNotBetween(String value1, String value2) {
            addCriterion("wind_buoyid not between", value1, value2, "windBuoyid");
            return (Criteria) this;
        }

        public Criteria andWindSpeedMaxIsNull() {
            addCriterion("wind_speed_max is null");
            return (Criteria) this;
        }

        public Criteria andWindSpeedMaxIsNotNull() {
            addCriterion("wind_speed_max is not null");
            return (Criteria) this;
        }

        public Criteria andWindSpeedMaxEqualTo(String value) {
            addCriterion("wind_speed_max =", value, "windSpeedMax");
            return (Criteria) this;
        }

        public Criteria andWindSpeedMaxNotEqualTo(String value) {
            addCriterion("wind_speed_max <>", value, "windSpeedMax");
            return (Criteria) this;
        }

        public Criteria andWindSpeedMaxGreaterThan(String value) {
            addCriterion("wind_speed_max >", value, "windSpeedMax");
            return (Criteria) this;
        }

        public Criteria andWindSpeedMaxGreaterThanOrEqualTo(String value) {
            addCriterion("wind_speed_max >=", value, "windSpeedMax");
            return (Criteria) this;
        }

        public Criteria andWindSpeedMaxLessThan(String value) {
            addCriterion("wind_speed_max <", value, "windSpeedMax");
            return (Criteria) this;
        }

        public Criteria andWindSpeedMaxLessThanOrEqualTo(String value) {
            addCriterion("wind_speed_max <=", value, "windSpeedMax");
            return (Criteria) this;
        }

        public Criteria andWindSpeedMaxLike(String value) {
            addCriterion("wind_speed_max like", value, "windSpeedMax");
            return (Criteria) this;
        }

        public Criteria andWindSpeedMaxNotLike(String value) {
            addCriterion("wind_speed_max not like", value, "windSpeedMax");
            return (Criteria) this;
        }

        public Criteria andWindSpeedMaxIn(List<String> values) {
            addCriterion("wind_speed_max in", values, "windSpeedMax");
            return (Criteria) this;
        }

        public Criteria andWindSpeedMaxNotIn(List<String> values) {
            addCriterion("wind_speed_max not in", values, "windSpeedMax");
            return (Criteria) this;
        }

        public Criteria andWindSpeedMaxBetween(String value1, String value2) {
            addCriterion("wind_speed_max between", value1, value2, "windSpeedMax");
            return (Criteria) this;
        }

        public Criteria andWindSpeedMaxNotBetween(String value1, String value2) {
            addCriterion("wind_speed_max not between", value1, value2, "windSpeedMax");
            return (Criteria) this;
        }

        public Criteria andWindSpeedMaxtoIsNull() {
            addCriterion("wind_speed_maxto is null");
            return (Criteria) this;
        }

        public Criteria andWindSpeedMaxtoIsNotNull() {
            addCriterion("wind_speed_maxto is not null");
            return (Criteria) this;
        }

        public Criteria andWindSpeedMaxtoEqualTo(String value) {
            addCriterion("wind_speed_maxto =", value, "windSpeedMaxto");
            return (Criteria) this;
        }

        public Criteria andWindSpeedMaxtoNotEqualTo(String value) {
            addCriterion("wind_speed_maxto <>", value, "windSpeedMaxto");
            return (Criteria) this;
        }

        public Criteria andWindSpeedMaxtoGreaterThan(String value) {
            addCriterion("wind_speed_maxto >", value, "windSpeedMaxto");
            return (Criteria) this;
        }

        public Criteria andWindSpeedMaxtoGreaterThanOrEqualTo(String value) {
            addCriterion("wind_speed_maxto >=", value, "windSpeedMaxto");
            return (Criteria) this;
        }

        public Criteria andWindSpeedMaxtoLessThan(String value) {
            addCriterion("wind_speed_maxto <", value, "windSpeedMaxto");
            return (Criteria) this;
        }

        public Criteria andWindSpeedMaxtoLessThanOrEqualTo(String value) {
            addCriterion("wind_speed_maxto <=", value, "windSpeedMaxto");
            return (Criteria) this;
        }

        public Criteria andWindSpeedMaxtoLike(String value) {
            addCriterion("wind_speed_maxto like", value, "windSpeedMaxto");
            return (Criteria) this;
        }

        public Criteria andWindSpeedMaxtoNotLike(String value) {
            addCriterion("wind_speed_maxto not like", value, "windSpeedMaxto");
            return (Criteria) this;
        }

        public Criteria andWindSpeedMaxtoIn(List<String> values) {
            addCriterion("wind_speed_maxto in", values, "windSpeedMaxto");
            return (Criteria) this;
        }

        public Criteria andWindSpeedMaxtoNotIn(List<String> values) {
            addCriterion("wind_speed_maxto not in", values, "windSpeedMaxto");
            return (Criteria) this;
        }

        public Criteria andWindSpeedMaxtoBetween(String value1, String value2) {
            addCriterion("wind_speed_maxto between", value1, value2, "windSpeedMaxto");
            return (Criteria) this;
        }

        public Criteria andWindSpeedMaxtoNotBetween(String value1, String value2) {
            addCriterion("wind_speed_maxto not between", value1, value2, "windSpeedMaxto");
            return (Criteria) this;
        }

        public Criteria andWindSpeedMaxtimeIsNull() {
            addCriterion("wind_speed_maxtime is null");
            return (Criteria) this;
        }

        public Criteria andWindSpeedMaxtimeIsNotNull() {
            addCriterion("wind_speed_maxtime is not null");
            return (Criteria) this;
        }

        public Criteria andWindSpeedMaxtimeEqualTo(String value) {
            addCriterion("wind_speed_maxtime =", value, "windSpeedMaxtime");
            return (Criteria) this;
        }

        public Criteria andWindSpeedMaxtimeNotEqualTo(String value) {
            addCriterion("wind_speed_maxtime <>", value, "windSpeedMaxtime");
            return (Criteria) this;
        }

        public Criteria andWindSpeedMaxtimeGreaterThan(String value) {
            addCriterion("wind_speed_maxtime >", value, "windSpeedMaxtime");
            return (Criteria) this;
        }

        public Criteria andWindSpeedMaxtimeGreaterThanOrEqualTo(String value) {
            addCriterion("wind_speed_maxtime >=", value, "windSpeedMaxtime");
            return (Criteria) this;
        }

        public Criteria andWindSpeedMaxtimeLessThan(String value) {
            addCriterion("wind_speed_maxtime <", value, "windSpeedMaxtime");
            return (Criteria) this;
        }

        public Criteria andWindSpeedMaxtimeLessThanOrEqualTo(String value) {
            addCriterion("wind_speed_maxtime <=", value, "windSpeedMaxtime");
            return (Criteria) this;
        }

        public Criteria andWindSpeedMaxtimeLike(String value) {
            addCriterion("wind_speed_maxtime like", value, "windSpeedMaxtime");
            return (Criteria) this;
        }

        public Criteria andWindSpeedMaxtimeNotLike(String value) {
            addCriterion("wind_speed_maxtime not like", value, "windSpeedMaxtime");
            return (Criteria) this;
        }

        public Criteria andWindSpeedMaxtimeIn(List<String> values) {
            addCriterion("wind_speed_maxtime in", values, "windSpeedMaxtime");
            return (Criteria) this;
        }

        public Criteria andWindSpeedMaxtimeNotIn(List<String> values) {
            addCriterion("wind_speed_maxtime not in", values, "windSpeedMaxtime");
            return (Criteria) this;
        }

        public Criteria andWindSpeedMaxtimeBetween(String value1, String value2) {
            addCriterion("wind_speed_maxtime between", value1, value2, "windSpeedMaxtime");
            return (Criteria) this;
        }

        public Criteria andWindSpeedMaxtimeNotBetween(String value1, String value2) {
            addCriterion("wind_speed_maxtime not between", value1, value2, "windSpeedMaxtime");
            return (Criteria) this;
        }

        public Criteria andWindSpeedJiIsNull() {
            addCriterion("wind_speed_ji is null");
            return (Criteria) this;
        }

        public Criteria andWindSpeedJiIsNotNull() {
            addCriterion("wind_speed_ji is not null");
            return (Criteria) this;
        }

        public Criteria andWindSpeedJiEqualTo(String value) {
            addCriterion("wind_speed_ji =", value, "windSpeedJi");
            return (Criteria) this;
        }

        public Criteria andWindSpeedJiNotEqualTo(String value) {
            addCriterion("wind_speed_ji <>", value, "windSpeedJi");
            return (Criteria) this;
        }

        public Criteria andWindSpeedJiGreaterThan(String value) {
            addCriterion("wind_speed_ji >", value, "windSpeedJi");
            return (Criteria) this;
        }

        public Criteria andWindSpeedJiGreaterThanOrEqualTo(String value) {
            addCriterion("wind_speed_ji >=", value, "windSpeedJi");
            return (Criteria) this;
        }

        public Criteria andWindSpeedJiLessThan(String value) {
            addCriterion("wind_speed_ji <", value, "windSpeedJi");
            return (Criteria) this;
        }

        public Criteria andWindSpeedJiLessThanOrEqualTo(String value) {
            addCriterion("wind_speed_ji <=", value, "windSpeedJi");
            return (Criteria) this;
        }

        public Criteria andWindSpeedJiLike(String value) {
            addCriterion("wind_speed_ji like", value, "windSpeedJi");
            return (Criteria) this;
        }

        public Criteria andWindSpeedJiNotLike(String value) {
            addCriterion("wind_speed_ji not like", value, "windSpeedJi");
            return (Criteria) this;
        }

        public Criteria andWindSpeedJiIn(List<String> values) {
            addCriterion("wind_speed_ji in", values, "windSpeedJi");
            return (Criteria) this;
        }

        public Criteria andWindSpeedJiNotIn(List<String> values) {
            addCriterion("wind_speed_ji not in", values, "windSpeedJi");
            return (Criteria) this;
        }

        public Criteria andWindSpeedJiBetween(String value1, String value2) {
            addCriterion("wind_speed_ji between", value1, value2, "windSpeedJi");
            return (Criteria) this;
        }

        public Criteria andWindSpeedJiNotBetween(String value1, String value2) {
            addCriterion("wind_speed_ji not between", value1, value2, "windSpeedJi");
            return (Criteria) this;
        }

        public Criteria andWindSpeedJitoIsNull() {
            addCriterion("wind_speed_jito is null");
            return (Criteria) this;
        }

        public Criteria andWindSpeedJitoIsNotNull() {
            addCriterion("wind_speed_jito is not null");
            return (Criteria) this;
        }

        public Criteria andWindSpeedJitoEqualTo(String value) {
            addCriterion("wind_speed_jito =", value, "windSpeedJito");
            return (Criteria) this;
        }

        public Criteria andWindSpeedJitoNotEqualTo(String value) {
            addCriterion("wind_speed_jito <>", value, "windSpeedJito");
            return (Criteria) this;
        }

        public Criteria andWindSpeedJitoGreaterThan(String value) {
            addCriterion("wind_speed_jito >", value, "windSpeedJito");
            return (Criteria) this;
        }

        public Criteria andWindSpeedJitoGreaterThanOrEqualTo(String value) {
            addCriterion("wind_speed_jito >=", value, "windSpeedJito");
            return (Criteria) this;
        }

        public Criteria andWindSpeedJitoLessThan(String value) {
            addCriterion("wind_speed_jito <", value, "windSpeedJito");
            return (Criteria) this;
        }

        public Criteria andWindSpeedJitoLessThanOrEqualTo(String value) {
            addCriterion("wind_speed_jito <=", value, "windSpeedJito");
            return (Criteria) this;
        }

        public Criteria andWindSpeedJitoLike(String value) {
            addCriterion("wind_speed_jito like", value, "windSpeedJito");
            return (Criteria) this;
        }

        public Criteria andWindSpeedJitoNotLike(String value) {
            addCriterion("wind_speed_jito not like", value, "windSpeedJito");
            return (Criteria) this;
        }

        public Criteria andWindSpeedJitoIn(List<String> values) {
            addCriterion("wind_speed_jito in", values, "windSpeedJito");
            return (Criteria) this;
        }

        public Criteria andWindSpeedJitoNotIn(List<String> values) {
            addCriterion("wind_speed_jito not in", values, "windSpeedJito");
            return (Criteria) this;
        }

        public Criteria andWindSpeedJitoBetween(String value1, String value2) {
            addCriterion("wind_speed_jito between", value1, value2, "windSpeedJito");
            return (Criteria) this;
        }

        public Criteria andWindSpeedJitoNotBetween(String value1, String value2) {
            addCriterion("wind_speed_jito not between", value1, value2, "windSpeedJito");
            return (Criteria) this;
        }

        public Criteria andWindSpeedJitimeIsNull() {
            addCriterion("wind_speed_jitime is null");
            return (Criteria) this;
        }

        public Criteria andWindSpeedJitimeIsNotNull() {
            addCriterion("wind_speed_jitime is not null");
            return (Criteria) this;
        }

        public Criteria andWindSpeedJitimeEqualTo(String value) {
            addCriterion("wind_speed_jitime =", value, "windSpeedJitime");
            return (Criteria) this;
        }

        public Criteria andWindSpeedJitimeNotEqualTo(String value) {
            addCriterion("wind_speed_jitime <>", value, "windSpeedJitime");
            return (Criteria) this;
        }

        public Criteria andWindSpeedJitimeGreaterThan(String value) {
            addCriterion("wind_speed_jitime >", value, "windSpeedJitime");
            return (Criteria) this;
        }

        public Criteria andWindSpeedJitimeGreaterThanOrEqualTo(String value) {
            addCriterion("wind_speed_jitime >=", value, "windSpeedJitime");
            return (Criteria) this;
        }

        public Criteria andWindSpeedJitimeLessThan(String value) {
            addCriterion("wind_speed_jitime <", value, "windSpeedJitime");
            return (Criteria) this;
        }

        public Criteria andWindSpeedJitimeLessThanOrEqualTo(String value) {
            addCriterion("wind_speed_jitime <=", value, "windSpeedJitime");
            return (Criteria) this;
        }

        public Criteria andWindSpeedJitimeLike(String value) {
            addCriterion("wind_speed_jitime like", value, "windSpeedJitime");
            return (Criteria) this;
        }

        public Criteria andWindSpeedJitimeNotLike(String value) {
            addCriterion("wind_speed_jitime not like", value, "windSpeedJitime");
            return (Criteria) this;
        }

        public Criteria andWindSpeedJitimeIn(List<String> values) {
            addCriterion("wind_speed_jitime in", values, "windSpeedJitime");
            return (Criteria) this;
        }

        public Criteria andWindSpeedJitimeNotIn(List<String> values) {
            addCriterion("wind_speed_jitime not in", values, "windSpeedJitime");
            return (Criteria) this;
        }

        public Criteria andWindSpeedJitimeBetween(String value1, String value2) {
            addCriterion("wind_speed_jitime between", value1, value2, "windSpeedJitime");
            return (Criteria) this;
        }

        public Criteria andWindSpeedJitimeNotBetween(String value1, String value2) {
            addCriterion("wind_speed_jitime not between", value1, value2, "windSpeedJitime");
            return (Criteria) this;
        }

        public Criteria andWindSpeedTenIsNull() {
            addCriterion("wind_speed_ten is null");
            return (Criteria) this;
        }

        public Criteria andWindSpeedTenIsNotNull() {
            addCriterion("wind_speed_ten is not null");
            return (Criteria) this;
        }

        public Criteria andWindSpeedTenEqualTo(String value) {
            addCriterion("wind_speed_ten =", value, "windSpeedTen");
            return (Criteria) this;
        }

        public Criteria andWindSpeedTenNotEqualTo(String value) {
            addCriterion("wind_speed_ten <>", value, "windSpeedTen");
            return (Criteria) this;
        }

        public Criteria andWindSpeedTenGreaterThan(String value) {
            addCriterion("wind_speed_ten >", value, "windSpeedTen");
            return (Criteria) this;
        }

        public Criteria andWindSpeedTenGreaterThanOrEqualTo(String value) {
            addCriterion("wind_speed_ten >=", value, "windSpeedTen");
            return (Criteria) this;
        }

        public Criteria andWindSpeedTenLessThan(String value) {
            addCriterion("wind_speed_ten <", value, "windSpeedTen");
            return (Criteria) this;
        }

        public Criteria andWindSpeedTenLessThanOrEqualTo(String value) {
            addCriterion("wind_speed_ten <=", value, "windSpeedTen");
            return (Criteria) this;
        }

        public Criteria andWindSpeedTenLike(String value) {
            addCriterion("wind_speed_ten like", value, "windSpeedTen");
            return (Criteria) this;
        }

        public Criteria andWindSpeedTenNotLike(String value) {
            addCriterion("wind_speed_ten not like", value, "windSpeedTen");
            return (Criteria) this;
        }

        public Criteria andWindSpeedTenIn(List<String> values) {
            addCriterion("wind_speed_ten in", values, "windSpeedTen");
            return (Criteria) this;
        }

        public Criteria andWindSpeedTenNotIn(List<String> values) {
            addCriterion("wind_speed_ten not in", values, "windSpeedTen");
            return (Criteria) this;
        }

        public Criteria andWindSpeedTenBetween(String value1, String value2) {
            addCriterion("wind_speed_ten between", value1, value2, "windSpeedTen");
            return (Criteria) this;
        }

        public Criteria andWindSpeedTenNotBetween(String value1, String value2) {
            addCriterion("wind_speed_ten not between", value1, value2, "windSpeedTen");
            return (Criteria) this;
        }

        public Criteria andWindSpeedTentoIsNull() {
            addCriterion("wind_speed_tento is null");
            return (Criteria) this;
        }

        public Criteria andWindSpeedTentoIsNotNull() {
            addCriterion("wind_speed_tento is not null");
            return (Criteria) this;
        }

        public Criteria andWindSpeedTentoEqualTo(String value) {
            addCriterion("wind_speed_tento =", value, "windSpeedTento");
            return (Criteria) this;
        }

        public Criteria andWindSpeedTentoNotEqualTo(String value) {
            addCriterion("wind_speed_tento <>", value, "windSpeedTento");
            return (Criteria) this;
        }

        public Criteria andWindSpeedTentoGreaterThan(String value) {
            addCriterion("wind_speed_tento >", value, "windSpeedTento");
            return (Criteria) this;
        }

        public Criteria andWindSpeedTentoGreaterThanOrEqualTo(String value) {
            addCriterion("wind_speed_tento >=", value, "windSpeedTento");
            return (Criteria) this;
        }

        public Criteria andWindSpeedTentoLessThan(String value) {
            addCriterion("wind_speed_tento <", value, "windSpeedTento");
            return (Criteria) this;
        }

        public Criteria andWindSpeedTentoLessThanOrEqualTo(String value) {
            addCriterion("wind_speed_tento <=", value, "windSpeedTento");
            return (Criteria) this;
        }

        public Criteria andWindSpeedTentoLike(String value) {
            addCriterion("wind_speed_tento like", value, "windSpeedTento");
            return (Criteria) this;
        }

        public Criteria andWindSpeedTentoNotLike(String value) {
            addCriterion("wind_speed_tento not like", value, "windSpeedTento");
            return (Criteria) this;
        }

        public Criteria andWindSpeedTentoIn(List<String> values) {
            addCriterion("wind_speed_tento in", values, "windSpeedTento");
            return (Criteria) this;
        }

        public Criteria andWindSpeedTentoNotIn(List<String> values) {
            addCriterion("wind_speed_tento not in", values, "windSpeedTento");
            return (Criteria) this;
        }

        public Criteria andWindSpeedTentoBetween(String value1, String value2) {
            addCriterion("wind_speed_tento between", value1, value2, "windSpeedTento");
            return (Criteria) this;
        }

        public Criteria andWindSpeedTentoNotBetween(String value1, String value2) {
            addCriterion("wind_speed_tento not between", value1, value2, "windSpeedTento");
            return (Criteria) this;
        }

        public Criteria andWindSpeedInstantIsNull() {
            addCriterion("wind_speed_instant is null");
            return (Criteria) this;
        }

        public Criteria andWindSpeedInstantIsNotNull() {
            addCriterion("wind_speed_instant is not null");
            return (Criteria) this;
        }

        public Criteria andWindSpeedInstantEqualTo(String value) {
            addCriterion("wind_speed_instant =", value, "windSpeedInstant");
            return (Criteria) this;
        }

        public Criteria andWindSpeedInstantNotEqualTo(String value) {
            addCriterion("wind_speed_instant <>", value, "windSpeedInstant");
            return (Criteria) this;
        }

        public Criteria andWindSpeedInstantGreaterThan(String value) {
            addCriterion("wind_speed_instant >", value, "windSpeedInstant");
            return (Criteria) this;
        }

        public Criteria andWindSpeedInstantGreaterThanOrEqualTo(String value) {
            addCriterion("wind_speed_instant >=", value, "windSpeedInstant");
            return (Criteria) this;
        }

        public Criteria andWindSpeedInstantLessThan(String value) {
            addCriterion("wind_speed_instant <", value, "windSpeedInstant");
            return (Criteria) this;
        }

        public Criteria andWindSpeedInstantLessThanOrEqualTo(String value) {
            addCriterion("wind_speed_instant <=", value, "windSpeedInstant");
            return (Criteria) this;
        }

        public Criteria andWindSpeedInstantLike(String value) {
            addCriterion("wind_speed_instant like", value, "windSpeedInstant");
            return (Criteria) this;
        }

        public Criteria andWindSpeedInstantNotLike(String value) {
            addCriterion("wind_speed_instant not like", value, "windSpeedInstant");
            return (Criteria) this;
        }

        public Criteria andWindSpeedInstantIn(List<String> values) {
            addCriterion("wind_speed_instant in", values, "windSpeedInstant");
            return (Criteria) this;
        }

        public Criteria andWindSpeedInstantNotIn(List<String> values) {
            addCriterion("wind_speed_instant not in", values, "windSpeedInstant");
            return (Criteria) this;
        }

        public Criteria andWindSpeedInstantBetween(String value1, String value2) {
            addCriterion("wind_speed_instant between", value1, value2, "windSpeedInstant");
            return (Criteria) this;
        }

        public Criteria andWindSpeedInstantNotBetween(String value1, String value2) {
            addCriterion("wind_speed_instant not between", value1, value2, "windSpeedInstant");
            return (Criteria) this;
        }

        public Criteria andWindToInstantIsNull() {
            addCriterion("wind_to_instant is null");
            return (Criteria) this;
        }

        public Criteria andWindToInstantIsNotNull() {
            addCriterion("wind_to_instant is not null");
            return (Criteria) this;
        }

        public Criteria andWindToInstantEqualTo(String value) {
            addCriterion("wind_to_instant =", value, "windToInstant");
            return (Criteria) this;
        }

        public Criteria andWindToInstantNotEqualTo(String value) {
            addCriterion("wind_to_instant <>", value, "windToInstant");
            return (Criteria) this;
        }

        public Criteria andWindToInstantGreaterThan(String value) {
            addCriterion("wind_to_instant >", value, "windToInstant");
            return (Criteria) this;
        }

        public Criteria andWindToInstantGreaterThanOrEqualTo(String value) {
            addCriterion("wind_to_instant >=", value, "windToInstant");
            return (Criteria) this;
        }

        public Criteria andWindToInstantLessThan(String value) {
            addCriterion("wind_to_instant <", value, "windToInstant");
            return (Criteria) this;
        }

        public Criteria andWindToInstantLessThanOrEqualTo(String value) {
            addCriterion("wind_to_instant <=", value, "windToInstant");
            return (Criteria) this;
        }

        public Criteria andWindToInstantLike(String value) {
            addCriterion("wind_to_instant like", value, "windToInstant");
            return (Criteria) this;
        }

        public Criteria andWindToInstantNotLike(String value) {
            addCriterion("wind_to_instant not like", value, "windToInstant");
            return (Criteria) this;
        }

        public Criteria andWindToInstantIn(List<String> values) {
            addCriterion("wind_to_instant in", values, "windToInstant");
            return (Criteria) this;
        }

        public Criteria andWindToInstantNotIn(List<String> values) {
            addCriterion("wind_to_instant not in", values, "windToInstant");
            return (Criteria) this;
        }

        public Criteria andWindToInstantBetween(String value1, String value2) {
            addCriterion("wind_to_instant between", value1, value2, "windToInstant");
            return (Criteria) this;
        }

        public Criteria andWindToInstantNotBetween(String value1, String value2) {
            addCriterion("wind_to_instant not between", value1, value2, "windToInstant");
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