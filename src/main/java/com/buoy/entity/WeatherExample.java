package com.buoy.entity;

import java.util.ArrayList;
import java.util.List;

public class WeatherExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WeatherExample() {
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

        public Criteria andWAirpreIsNull() {
            addCriterion("w_airpre is null");
            return (Criteria) this;
        }

        public Criteria andWAirpreIsNotNull() {
            addCriterion("w_airpre is not null");
            return (Criteria) this;
        }

        public Criteria andWAirpreEqualTo(String value) {
            addCriterion("w_airpre =", value, "wAirpre");
            return (Criteria) this;
        }

        public Criteria andWAirpreNotEqualTo(String value) {
            addCriterion("w_airpre <>", value, "wAirpre");
            return (Criteria) this;
        }

        public Criteria andWAirpreGreaterThan(String value) {
            addCriterion("w_airpre >", value, "wAirpre");
            return (Criteria) this;
        }

        public Criteria andWAirpreGreaterThanOrEqualTo(String value) {
            addCriterion("w_airpre >=", value, "wAirpre");
            return (Criteria) this;
        }

        public Criteria andWAirpreLessThan(String value) {
            addCriterion("w_airpre <", value, "wAirpre");
            return (Criteria) this;
        }

        public Criteria andWAirpreLessThanOrEqualTo(String value) {
            addCriterion("w_airpre <=", value, "wAirpre");
            return (Criteria) this;
        }

        public Criteria andWAirpreLike(String value) {
            addCriterion("w_airpre like", value, "wAirpre");
            return (Criteria) this;
        }

        public Criteria andWAirpreNotLike(String value) {
            addCriterion("w_airpre not like", value, "wAirpre");
            return (Criteria) this;
        }

        public Criteria andWAirpreIn(List<String> values) {
            addCriterion("w_airpre in", values, "wAirpre");
            return (Criteria) this;
        }

        public Criteria andWAirpreNotIn(List<String> values) {
            addCriterion("w_airpre not in", values, "wAirpre");
            return (Criteria) this;
        }

        public Criteria andWAirpreBetween(String value1, String value2) {
            addCriterion("w_airpre between", value1, value2, "wAirpre");
            return (Criteria) this;
        }

        public Criteria andWAirpreNotBetween(String value1, String value2) {
            addCriterion("w_airpre not between", value1, value2, "wAirpre");
            return (Criteria) this;
        }

        public Criteria andWAirtempIsNull() {
            addCriterion("w_airtemp is null");
            return (Criteria) this;
        }

        public Criteria andWAirtempIsNotNull() {
            addCriterion("w_airtemp is not null");
            return (Criteria) this;
        }

        public Criteria andWAirtempEqualTo(String value) {
            addCriterion("w_airtemp =", value, "wAirtemp");
            return (Criteria) this;
        }

        public Criteria andWAirtempNotEqualTo(String value) {
            addCriterion("w_airtemp <>", value, "wAirtemp");
            return (Criteria) this;
        }

        public Criteria andWAirtempGreaterThan(String value) {
            addCriterion("w_airtemp >", value, "wAirtemp");
            return (Criteria) this;
        }

        public Criteria andWAirtempGreaterThanOrEqualTo(String value) {
            addCriterion("w_airtemp >=", value, "wAirtemp");
            return (Criteria) this;
        }

        public Criteria andWAirtempLessThan(String value) {
            addCriterion("w_airtemp <", value, "wAirtemp");
            return (Criteria) this;
        }

        public Criteria andWAirtempLessThanOrEqualTo(String value) {
            addCriterion("w_airtemp <=", value, "wAirtemp");
            return (Criteria) this;
        }

        public Criteria andWAirtempLike(String value) {
            addCriterion("w_airtemp like", value, "wAirtemp");
            return (Criteria) this;
        }

        public Criteria andWAirtempNotLike(String value) {
            addCriterion("w_airtemp not like", value, "wAirtemp");
            return (Criteria) this;
        }

        public Criteria andWAirtempIn(List<String> values) {
            addCriterion("w_airtemp in", values, "wAirtemp");
            return (Criteria) this;
        }

        public Criteria andWAirtempNotIn(List<String> values) {
            addCriterion("w_airtemp not in", values, "wAirtemp");
            return (Criteria) this;
        }

        public Criteria andWAirtempBetween(String value1, String value2) {
            addCriterion("w_airtemp between", value1, value2, "wAirtemp");
            return (Criteria) this;
        }

        public Criteria andWAirtempNotBetween(String value1, String value2) {
            addCriterion("w_airtemp not between", value1, value2, "wAirtemp");
            return (Criteria) this;
        }

        public Criteria andWWattempIsNull() {
            addCriterion("w_wattemp is null");
            return (Criteria) this;
        }

        public Criteria andWWattempIsNotNull() {
            addCriterion("w_wattemp is not null");
            return (Criteria) this;
        }

        public Criteria andWWattempEqualTo(String value) {
            addCriterion("w_wattemp =", value, "wWattemp");
            return (Criteria) this;
        }

        public Criteria andWWattempNotEqualTo(String value) {
            addCriterion("w_wattemp <>", value, "wWattemp");
            return (Criteria) this;
        }

        public Criteria andWWattempGreaterThan(String value) {
            addCriterion("w_wattemp >", value, "wWattemp");
            return (Criteria) this;
        }

        public Criteria andWWattempGreaterThanOrEqualTo(String value) {
            addCriterion("w_wattemp >=", value, "wWattemp");
            return (Criteria) this;
        }

        public Criteria andWWattempLessThan(String value) {
            addCriterion("w_wattemp <", value, "wWattemp");
            return (Criteria) this;
        }

        public Criteria andWWattempLessThanOrEqualTo(String value) {
            addCriterion("w_wattemp <=", value, "wWattemp");
            return (Criteria) this;
        }

        public Criteria andWWattempLike(String value) {
            addCriterion("w_wattemp like", value, "wWattemp");
            return (Criteria) this;
        }

        public Criteria andWWattempNotLike(String value) {
            addCriterion("w_wattemp not like", value, "wWattemp");
            return (Criteria) this;
        }

        public Criteria andWWattempIn(List<String> values) {
            addCriterion("w_wattemp in", values, "wWattemp");
            return (Criteria) this;
        }

        public Criteria andWWattempNotIn(List<String> values) {
            addCriterion("w_wattemp not in", values, "wWattemp");
            return (Criteria) this;
        }

        public Criteria andWWattempBetween(String value1, String value2) {
            addCriterion("w_wattemp between", value1, value2, "wWattemp");
            return (Criteria) this;
        }

        public Criteria andWWattempNotBetween(String value1, String value2) {
            addCriterion("w_wattemp not between", value1, value2, "wWattemp");
            return (Criteria) this;
        }

        public Criteria andWHatchtempIsNull() {
            addCriterion("w_hatchtemp is null");
            return (Criteria) this;
        }

        public Criteria andWHatchtempIsNotNull() {
            addCriterion("w_hatchtemp is not null");
            return (Criteria) this;
        }

        public Criteria andWHatchtempEqualTo(String value) {
            addCriterion("w_hatchtemp =", value, "wHatchtemp");
            return (Criteria) this;
        }

        public Criteria andWHatchtempNotEqualTo(String value) {
            addCriterion("w_hatchtemp <>", value, "wHatchtemp");
            return (Criteria) this;
        }

        public Criteria andWHatchtempGreaterThan(String value) {
            addCriterion("w_hatchtemp >", value, "wHatchtemp");
            return (Criteria) this;
        }

        public Criteria andWHatchtempGreaterThanOrEqualTo(String value) {
            addCriterion("w_hatchtemp >=", value, "wHatchtemp");
            return (Criteria) this;
        }

        public Criteria andWHatchtempLessThan(String value) {
            addCriterion("w_hatchtemp <", value, "wHatchtemp");
            return (Criteria) this;
        }

        public Criteria andWHatchtempLessThanOrEqualTo(String value) {
            addCriterion("w_hatchtemp <=", value, "wHatchtemp");
            return (Criteria) this;
        }

        public Criteria andWHatchtempLike(String value) {
            addCriterion("w_hatchtemp like", value, "wHatchtemp");
            return (Criteria) this;
        }

        public Criteria andWHatchtempNotLike(String value) {
            addCriterion("w_hatchtemp not like", value, "wHatchtemp");
            return (Criteria) this;
        }

        public Criteria andWHatchtempIn(List<String> values) {
            addCriterion("w_hatchtemp in", values, "wHatchtemp");
            return (Criteria) this;
        }

        public Criteria andWHatchtempNotIn(List<String> values) {
            addCriterion("w_hatchtemp not in", values, "wHatchtemp");
            return (Criteria) this;
        }

        public Criteria andWHatchtempBetween(String value1, String value2) {
            addCriterion("w_hatchtemp between", value1, value2, "wHatchtemp");
            return (Criteria) this;
        }

        public Criteria andWHatchtempNotBetween(String value1, String value2) {
            addCriterion("w_hatchtemp not between", value1, value2, "wHatchtemp");
            return (Criteria) this;
        }

        public Criteria andWOppohumiIsNull() {
            addCriterion("w_oppohumi is null");
            return (Criteria) this;
        }

        public Criteria andWOppohumiIsNotNull() {
            addCriterion("w_oppohumi is not null");
            return (Criteria) this;
        }

        public Criteria andWOppohumiEqualTo(String value) {
            addCriterion("w_oppohumi =", value, "wOppohumi");
            return (Criteria) this;
        }

        public Criteria andWOppohumiNotEqualTo(String value) {
            addCriterion("w_oppohumi <>", value, "wOppohumi");
            return (Criteria) this;
        }

        public Criteria andWOppohumiGreaterThan(String value) {
            addCriterion("w_oppohumi >", value, "wOppohumi");
            return (Criteria) this;
        }

        public Criteria andWOppohumiGreaterThanOrEqualTo(String value) {
            addCriterion("w_oppohumi >=", value, "wOppohumi");
            return (Criteria) this;
        }

        public Criteria andWOppohumiLessThan(String value) {
            addCriterion("w_oppohumi <", value, "wOppohumi");
            return (Criteria) this;
        }

        public Criteria andWOppohumiLessThanOrEqualTo(String value) {
            addCriterion("w_oppohumi <=", value, "wOppohumi");
            return (Criteria) this;
        }

        public Criteria andWOppohumiLike(String value) {
            addCriterion("w_oppohumi like", value, "wOppohumi");
            return (Criteria) this;
        }

        public Criteria andWOppohumiNotLike(String value) {
            addCriterion("w_oppohumi not like", value, "wOppohumi");
            return (Criteria) this;
        }

        public Criteria andWOppohumiIn(List<String> values) {
            addCriterion("w_oppohumi in", values, "wOppohumi");
            return (Criteria) this;
        }

        public Criteria andWOppohumiNotIn(List<String> values) {
            addCriterion("w_oppohumi not in", values, "wOppohumi");
            return (Criteria) this;
        }

        public Criteria andWOppohumiBetween(String value1, String value2) {
            addCriterion("w_oppohumi between", value1, value2, "wOppohumi");
            return (Criteria) this;
        }

        public Criteria andWOppohumiNotBetween(String value1, String value2) {
            addCriterion("w_oppohumi not between", value1, value2, "wOppohumi");
            return (Criteria) this;
        }

        public Criteria andVVisipuluIsNull() {
            addCriterion("v_visipulu is null");
            return (Criteria) this;
        }

        public Criteria andVVisipuluIsNotNull() {
            addCriterion("v_visipulu is not null");
            return (Criteria) this;
        }

        public Criteria andVVisipuluEqualTo(String value) {
            addCriterion("v_visipulu =", value, "vVisipulu");
            return (Criteria) this;
        }

        public Criteria andVVisipuluNotEqualTo(String value) {
            addCriterion("v_visipulu <>", value, "vVisipulu");
            return (Criteria) this;
        }

        public Criteria andVVisipuluGreaterThan(String value) {
            addCriterion("v_visipulu >", value, "vVisipulu");
            return (Criteria) this;
        }

        public Criteria andVVisipuluGreaterThanOrEqualTo(String value) {
            addCriterion("v_visipulu >=", value, "vVisipulu");
            return (Criteria) this;
        }

        public Criteria andVVisipuluLessThan(String value) {
            addCriterion("v_visipulu <", value, "vVisipulu");
            return (Criteria) this;
        }

        public Criteria andVVisipuluLessThanOrEqualTo(String value) {
            addCriterion("v_visipulu <=", value, "vVisipulu");
            return (Criteria) this;
        }

        public Criteria andVVisipuluLike(String value) {
            addCriterion("v_visipulu like", value, "vVisipulu");
            return (Criteria) this;
        }

        public Criteria andVVisipuluNotLike(String value) {
            addCriterion("v_visipulu not like", value, "vVisipulu");
            return (Criteria) this;
        }

        public Criteria andVVisipuluIn(List<String> values) {
            addCriterion("v_visipulu in", values, "vVisipulu");
            return (Criteria) this;
        }

        public Criteria andVVisipuluNotIn(List<String> values) {
            addCriterion("v_visipulu not in", values, "vVisipulu");
            return (Criteria) this;
        }

        public Criteria andVVisipuluBetween(String value1, String value2) {
            addCriterion("v_visipulu between", value1, value2, "vVisipulu");
            return (Criteria) this;
        }

        public Criteria andVVisipuluNotBetween(String value1, String value2) {
            addCriterion("v_visipulu not between", value1, value2, "vVisipulu");
            return (Criteria) this;
        }

        public Criteria andWVisibiliIsNull() {
            addCriterion("w_visibili is null");
            return (Criteria) this;
        }

        public Criteria andWVisibiliIsNotNull() {
            addCriterion("w_visibili is not null");
            return (Criteria) this;
        }

        public Criteria andWVisibiliEqualTo(String value) {
            addCriterion("w_visibili =", value, "wVisibili");
            return (Criteria) this;
        }

        public Criteria andWVisibiliNotEqualTo(String value) {
            addCriterion("w_visibili <>", value, "wVisibili");
            return (Criteria) this;
        }

        public Criteria andWVisibiliGreaterThan(String value) {
            addCriterion("w_visibili >", value, "wVisibili");
            return (Criteria) this;
        }

        public Criteria andWVisibiliGreaterThanOrEqualTo(String value) {
            addCriterion("w_visibili >=", value, "wVisibili");
            return (Criteria) this;
        }

        public Criteria andWVisibiliLessThan(String value) {
            addCriterion("w_visibili <", value, "wVisibili");
            return (Criteria) this;
        }

        public Criteria andWVisibiliLessThanOrEqualTo(String value) {
            addCriterion("w_visibili <=", value, "wVisibili");
            return (Criteria) this;
        }

        public Criteria andWVisibiliLike(String value) {
            addCriterion("w_visibili like", value, "wVisibili");
            return (Criteria) this;
        }

        public Criteria andWVisibiliNotLike(String value) {
            addCriterion("w_visibili not like", value, "wVisibili");
            return (Criteria) this;
        }

        public Criteria andWVisibiliIn(List<String> values) {
            addCriterion("w_visibili in", values, "wVisibili");
            return (Criteria) this;
        }

        public Criteria andWVisibiliNotIn(List<String> values) {
            addCriterion("w_visibili not in", values, "wVisibili");
            return (Criteria) this;
        }

        public Criteria andWVisibiliBetween(String value1, String value2) {
            addCriterion("w_visibili between", value1, value2, "wVisibili");
            return (Criteria) this;
        }

        public Criteria andWVisibiliNotBetween(String value1, String value2) {
            addCriterion("w_visibili not between", value1, value2, "wVisibili");
            return (Criteria) this;
        }

        public Criteria andWRainIsNull() {
            addCriterion("w_rain is null");
            return (Criteria) this;
        }

        public Criteria andWRainIsNotNull() {
            addCriterion("w_rain is not null");
            return (Criteria) this;
        }

        public Criteria andWRainEqualTo(String value) {
            addCriterion("w_rain =", value, "wRain");
            return (Criteria) this;
        }

        public Criteria andWRainNotEqualTo(String value) {
            addCriterion("w_rain <>", value, "wRain");
            return (Criteria) this;
        }

        public Criteria andWRainGreaterThan(String value) {
            addCriterion("w_rain >", value, "wRain");
            return (Criteria) this;
        }

        public Criteria andWRainGreaterThanOrEqualTo(String value) {
            addCriterion("w_rain >=", value, "wRain");
            return (Criteria) this;
        }

        public Criteria andWRainLessThan(String value) {
            addCriterion("w_rain <", value, "wRain");
            return (Criteria) this;
        }

        public Criteria andWRainLessThanOrEqualTo(String value) {
            addCriterion("w_rain <=", value, "wRain");
            return (Criteria) this;
        }

        public Criteria andWRainLike(String value) {
            addCriterion("w_rain like", value, "wRain");
            return (Criteria) this;
        }

        public Criteria andWRainNotLike(String value) {
            addCriterion("w_rain not like", value, "wRain");
            return (Criteria) this;
        }

        public Criteria andWRainIn(List<String> values) {
            addCriterion("w_rain in", values, "wRain");
            return (Criteria) this;
        }

        public Criteria andWRainNotIn(List<String> values) {
            addCriterion("w_rain not in", values, "wRain");
            return (Criteria) this;
        }

        public Criteria andWRainBetween(String value1, String value2) {
            addCriterion("w_rain between", value1, value2, "wRain");
            return (Criteria) this;
        }

        public Criteria andWRainNotBetween(String value1, String value2) {
            addCriterion("w_rain not between", value1, value2, "wRain");
            return (Criteria) this;
        }

        public Criteria andWRainHourIsNull() {
            addCriterion("w_rain_hour is null");
            return (Criteria) this;
        }

        public Criteria andWRainHourIsNotNull() {
            addCriterion("w_rain_hour is not null");
            return (Criteria) this;
        }

        public Criteria andWRainHourEqualTo(String value) {
            addCriterion("w_rain_hour =", value, "wRainHour");
            return (Criteria) this;
        }

        public Criteria andWRainHourNotEqualTo(String value) {
            addCriterion("w_rain_hour <>", value, "wRainHour");
            return (Criteria) this;
        }

        public Criteria andWRainHourGreaterThan(String value) {
            addCriterion("w_rain_hour >", value, "wRainHour");
            return (Criteria) this;
        }

        public Criteria andWRainHourGreaterThanOrEqualTo(String value) {
            addCriterion("w_rain_hour >=", value, "wRainHour");
            return (Criteria) this;
        }

        public Criteria andWRainHourLessThan(String value) {
            addCriterion("w_rain_hour <", value, "wRainHour");
            return (Criteria) this;
        }

        public Criteria andWRainHourLessThanOrEqualTo(String value) {
            addCriterion("w_rain_hour <=", value, "wRainHour");
            return (Criteria) this;
        }

        public Criteria andWRainHourLike(String value) {
            addCriterion("w_rain_hour like", value, "wRainHour");
            return (Criteria) this;
        }

        public Criteria andWRainHourNotLike(String value) {
            addCriterion("w_rain_hour not like", value, "wRainHour");
            return (Criteria) this;
        }

        public Criteria andWRainHourIn(List<String> values) {
            addCriterion("w_rain_hour in", values, "wRainHour");
            return (Criteria) this;
        }

        public Criteria andWRainHourNotIn(List<String> values) {
            addCriterion("w_rain_hour not in", values, "wRainHour");
            return (Criteria) this;
        }

        public Criteria andWRainHourBetween(String value1, String value2) {
            addCriterion("w_rain_hour between", value1, value2, "wRainHour");
            return (Criteria) this;
        }

        public Criteria andWRainHourNotBetween(String value1, String value2) {
            addCriterion("w_rain_hour not between", value1, value2, "wRainHour");
            return (Criteria) this;
        }

        public Criteria andWTotalRadIsNull() {
            addCriterion("w_total_rad is null");
            return (Criteria) this;
        }

        public Criteria andWTotalRadIsNotNull() {
            addCriterion("w_total_rad is not null");
            return (Criteria) this;
        }

        public Criteria andWTotalRadEqualTo(String value) {
            addCriterion("w_total_rad =", value, "wTotalRad");
            return (Criteria) this;
        }

        public Criteria andWTotalRadNotEqualTo(String value) {
            addCriterion("w_total_rad <>", value, "wTotalRad");
            return (Criteria) this;
        }

        public Criteria andWTotalRadGreaterThan(String value) {
            addCriterion("w_total_rad >", value, "wTotalRad");
            return (Criteria) this;
        }

        public Criteria andWTotalRadGreaterThanOrEqualTo(String value) {
            addCriterion("w_total_rad >=", value, "wTotalRad");
            return (Criteria) this;
        }

        public Criteria andWTotalRadLessThan(String value) {
            addCriterion("w_total_rad <", value, "wTotalRad");
            return (Criteria) this;
        }

        public Criteria andWTotalRadLessThanOrEqualTo(String value) {
            addCriterion("w_total_rad <=", value, "wTotalRad");
            return (Criteria) this;
        }

        public Criteria andWTotalRadLike(String value) {
            addCriterion("w_total_rad like", value, "wTotalRad");
            return (Criteria) this;
        }

        public Criteria andWTotalRadNotLike(String value) {
            addCriterion("w_total_rad not like", value, "wTotalRad");
            return (Criteria) this;
        }

        public Criteria andWTotalRadIn(List<String> values) {
            addCriterion("w_total_rad in", values, "wTotalRad");
            return (Criteria) this;
        }

        public Criteria andWTotalRadNotIn(List<String> values) {
            addCriterion("w_total_rad not in", values, "wTotalRad");
            return (Criteria) this;
        }

        public Criteria andWTotalRadBetween(String value1, String value2) {
            addCriterion("w_total_rad between", value1, value2, "wTotalRad");
            return (Criteria) this;
        }

        public Criteria andWTotalRadNotBetween(String value1, String value2) {
            addCriterion("w_total_rad not between", value1, value2, "wTotalRad");
            return (Criteria) this;
        }

        public Criteria andWRedRadIsNull() {
            addCriterion("w_red_rad is null");
            return (Criteria) this;
        }

        public Criteria andWRedRadIsNotNull() {
            addCriterion("w_red_rad is not null");
            return (Criteria) this;
        }

        public Criteria andWRedRadEqualTo(String value) {
            addCriterion("w_red_rad =", value, "wRedRad");
            return (Criteria) this;
        }

        public Criteria andWRedRadNotEqualTo(String value) {
            addCriterion("w_red_rad <>", value, "wRedRad");
            return (Criteria) this;
        }

        public Criteria andWRedRadGreaterThan(String value) {
            addCriterion("w_red_rad >", value, "wRedRad");
            return (Criteria) this;
        }

        public Criteria andWRedRadGreaterThanOrEqualTo(String value) {
            addCriterion("w_red_rad >=", value, "wRedRad");
            return (Criteria) this;
        }

        public Criteria andWRedRadLessThan(String value) {
            addCriterion("w_red_rad <", value, "wRedRad");
            return (Criteria) this;
        }

        public Criteria andWRedRadLessThanOrEqualTo(String value) {
            addCriterion("w_red_rad <=", value, "wRedRad");
            return (Criteria) this;
        }

        public Criteria andWRedRadLike(String value) {
            addCriterion("w_red_rad like", value, "wRedRad");
            return (Criteria) this;
        }

        public Criteria andWRedRadNotLike(String value) {
            addCriterion("w_red_rad not like", value, "wRedRad");
            return (Criteria) this;
        }

        public Criteria andWRedRadIn(List<String> values) {
            addCriterion("w_red_rad in", values, "wRedRad");
            return (Criteria) this;
        }

        public Criteria andWRedRadNotIn(List<String> values) {
            addCriterion("w_red_rad not in", values, "wRedRad");
            return (Criteria) this;
        }

        public Criteria andWRedRadBetween(String value1, String value2) {
            addCriterion("w_red_rad between", value1, value2, "wRedRad");
            return (Criteria) this;
        }

        public Criteria andWRedRadNotBetween(String value1, String value2) {
            addCriterion("w_red_rad not between", value1, value2, "wRedRad");
            return (Criteria) this;
        }

        public Criteria andWSunIsNull() {
            addCriterion("w_sun is null");
            return (Criteria) this;
        }

        public Criteria andWSunIsNotNull() {
            addCriterion("w_sun is not null");
            return (Criteria) this;
        }

        public Criteria andWSunEqualTo(String value) {
            addCriterion("w_sun =", value, "wSun");
            return (Criteria) this;
        }

        public Criteria andWSunNotEqualTo(String value) {
            addCriterion("w_sun <>", value, "wSun");
            return (Criteria) this;
        }

        public Criteria andWSunGreaterThan(String value) {
            addCriterion("w_sun >", value, "wSun");
            return (Criteria) this;
        }

        public Criteria andWSunGreaterThanOrEqualTo(String value) {
            addCriterion("w_sun >=", value, "wSun");
            return (Criteria) this;
        }

        public Criteria andWSunLessThan(String value) {
            addCriterion("w_sun <", value, "wSun");
            return (Criteria) this;
        }

        public Criteria andWSunLessThanOrEqualTo(String value) {
            addCriterion("w_sun <=", value, "wSun");
            return (Criteria) this;
        }

        public Criteria andWSunLike(String value) {
            addCriterion("w_sun like", value, "wSun");
            return (Criteria) this;
        }

        public Criteria andWSunNotLike(String value) {
            addCriterion("w_sun not like", value, "wSun");
            return (Criteria) this;
        }

        public Criteria andWSunIn(List<String> values) {
            addCriterion("w_sun in", values, "wSun");
            return (Criteria) this;
        }

        public Criteria andWSunNotIn(List<String> values) {
            addCriterion("w_sun not in", values, "wSun");
            return (Criteria) this;
        }

        public Criteria andWSunBetween(String value1, String value2) {
            addCriterion("w_sun between", value1, value2, "wSun");
            return (Criteria) this;
        }

        public Criteria andWSunNotBetween(String value1, String value2) {
            addCriterion("w_sun not between", value1, value2, "wSun");
            return (Criteria) this;
        }

        public Criteria andWDataidIsNull() {
            addCriterion("w_dataid is null");
            return (Criteria) this;
        }

        public Criteria andWDataidIsNotNull() {
            addCriterion("w_dataid is not null");
            return (Criteria) this;
        }

        public Criteria andWDataidEqualTo(String value) {
            addCriterion("w_dataid =", value, "wDataid");
            return (Criteria) this;
        }

        public Criteria andWDataidNotEqualTo(String value) {
            addCriterion("w_dataid <>", value, "wDataid");
            return (Criteria) this;
        }

        public Criteria andWDataidGreaterThan(String value) {
            addCriterion("w_dataid >", value, "wDataid");
            return (Criteria) this;
        }

        public Criteria andWDataidGreaterThanOrEqualTo(String value) {
            addCriterion("w_dataid >=", value, "wDataid");
            return (Criteria) this;
        }

        public Criteria andWDataidLessThan(String value) {
            addCriterion("w_dataid <", value, "wDataid");
            return (Criteria) this;
        }

        public Criteria andWDataidLessThanOrEqualTo(String value) {
            addCriterion("w_dataid <=", value, "wDataid");
            return (Criteria) this;
        }

        public Criteria andWDataidLike(String value) {
            addCriterion("w_dataid like", value, "wDataid");
            return (Criteria) this;
        }

        public Criteria andWDataidNotLike(String value) {
            addCriterion("w_dataid not like", value, "wDataid");
            return (Criteria) this;
        }

        public Criteria andWDataidIn(List<String> values) {
            addCriterion("w_dataid in", values, "wDataid");
            return (Criteria) this;
        }

        public Criteria andWDataidNotIn(List<String> values) {
            addCriterion("w_dataid not in", values, "wDataid");
            return (Criteria) this;
        }

        public Criteria andWDataidBetween(String value1, String value2) {
            addCriterion("w_dataid between", value1, value2, "wDataid");
            return (Criteria) this;
        }

        public Criteria andWDataidNotBetween(String value1, String value2) {
            addCriterion("w_dataid not between", value1, value2, "wDataid");
            return (Criteria) this;
        }

        public Criteria andWRainMeasureIsNull() {
            addCriterion("w_rain_measure is null");
            return (Criteria) this;
        }

        public Criteria andWRainMeasureIsNotNull() {
            addCriterion("w_rain_measure is not null");
            return (Criteria) this;
        }

        public Criteria andWRainMeasureEqualTo(String value) {
            addCriterion("w_rain_measure =", value, "wRainMeasure");
            return (Criteria) this;
        }

        public Criteria andWRainMeasureNotEqualTo(String value) {
            addCriterion("w_rain_measure <>", value, "wRainMeasure");
            return (Criteria) this;
        }

        public Criteria andWRainMeasureGreaterThan(String value) {
            addCriterion("w_rain_measure >", value, "wRainMeasure");
            return (Criteria) this;
        }

        public Criteria andWRainMeasureGreaterThanOrEqualTo(String value) {
            addCriterion("w_rain_measure >=", value, "wRainMeasure");
            return (Criteria) this;
        }

        public Criteria andWRainMeasureLessThan(String value) {
            addCriterion("w_rain_measure <", value, "wRainMeasure");
            return (Criteria) this;
        }

        public Criteria andWRainMeasureLessThanOrEqualTo(String value) {
            addCriterion("w_rain_measure <=", value, "wRainMeasure");
            return (Criteria) this;
        }

        public Criteria andWRainMeasureLike(String value) {
            addCriterion("w_rain_measure like", value, "wRainMeasure");
            return (Criteria) this;
        }

        public Criteria andWRainMeasureNotLike(String value) {
            addCriterion("w_rain_measure not like", value, "wRainMeasure");
            return (Criteria) this;
        }

        public Criteria andWRainMeasureIn(List<String> values) {
            addCriterion("w_rain_measure in", values, "wRainMeasure");
            return (Criteria) this;
        }

        public Criteria andWRainMeasureNotIn(List<String> values) {
            addCriterion("w_rain_measure not in", values, "wRainMeasure");
            return (Criteria) this;
        }

        public Criteria andWRainMeasureBetween(String value1, String value2) {
            addCriterion("w_rain_measure between", value1, value2, "wRainMeasure");
            return (Criteria) this;
        }

        public Criteria andWRainMeasureNotBetween(String value1, String value2) {
            addCriterion("w_rain_measure not between", value1, value2, "wRainMeasure");
            return (Criteria) this;
        }

        public Criteria andWBeforeRmIsNull() {
            addCriterion("w_before_rm is null");
            return (Criteria) this;
        }

        public Criteria andWBeforeRmIsNotNull() {
            addCriterion("w_before_rm is not null");
            return (Criteria) this;
        }

        public Criteria andWBeforeRmEqualTo(String value) {
            addCriterion("w_before_rm =", value, "wBeforeRm");
            return (Criteria) this;
        }

        public Criteria andWBeforeRmNotEqualTo(String value) {
            addCriterion("w_before_rm <>", value, "wBeforeRm");
            return (Criteria) this;
        }

        public Criteria andWBeforeRmGreaterThan(String value) {
            addCriterion("w_before_rm >", value, "wBeforeRm");
            return (Criteria) this;
        }

        public Criteria andWBeforeRmGreaterThanOrEqualTo(String value) {
            addCriterion("w_before_rm >=", value, "wBeforeRm");
            return (Criteria) this;
        }

        public Criteria andWBeforeRmLessThan(String value) {
            addCriterion("w_before_rm <", value, "wBeforeRm");
            return (Criteria) this;
        }

        public Criteria andWBeforeRmLessThanOrEqualTo(String value) {
            addCriterion("w_before_rm <=", value, "wBeforeRm");
            return (Criteria) this;
        }

        public Criteria andWBeforeRmLike(String value) {
            addCriterion("w_before_rm like", value, "wBeforeRm");
            return (Criteria) this;
        }

        public Criteria andWBeforeRmNotLike(String value) {
            addCriterion("w_before_rm not like", value, "wBeforeRm");
            return (Criteria) this;
        }

        public Criteria andWBeforeRmIn(List<String> values) {
            addCriterion("w_before_rm in", values, "wBeforeRm");
            return (Criteria) this;
        }

        public Criteria andWBeforeRmNotIn(List<String> values) {
            addCriterion("w_before_rm not in", values, "wBeforeRm");
            return (Criteria) this;
        }

        public Criteria andWBeforeRmBetween(String value1, String value2) {
            addCriterion("w_before_rm between", value1, value2, "wBeforeRm");
            return (Criteria) this;
        }

        public Criteria andWBeforeRmNotBetween(String value1, String value2) {
            addCriterion("w_before_rm not between", value1, value2, "wBeforeRm");
            return (Criteria) this;
        }

        public Criteria andWShortRadIsNull() {
            addCriterion("w_short_rad is null");
            return (Criteria) this;
        }

        public Criteria andWShortRadIsNotNull() {
            addCriterion("w_short_rad is not null");
            return (Criteria) this;
        }

        public Criteria andWShortRadEqualTo(String value) {
            addCriterion("w_short_rad =", value, "wShortRad");
            return (Criteria) this;
        }

        public Criteria andWShortRadNotEqualTo(String value) {
            addCriterion("w_short_rad <>", value, "wShortRad");
            return (Criteria) this;
        }

        public Criteria andWShortRadGreaterThan(String value) {
            addCriterion("w_short_rad >", value, "wShortRad");
            return (Criteria) this;
        }

        public Criteria andWShortRadGreaterThanOrEqualTo(String value) {
            addCriterion("w_short_rad >=", value, "wShortRad");
            return (Criteria) this;
        }

        public Criteria andWShortRadLessThan(String value) {
            addCriterion("w_short_rad <", value, "wShortRad");
            return (Criteria) this;
        }

        public Criteria andWShortRadLessThanOrEqualTo(String value) {
            addCriterion("w_short_rad <=", value, "wShortRad");
            return (Criteria) this;
        }

        public Criteria andWShortRadLike(String value) {
            addCriterion("w_short_rad like", value, "wShortRad");
            return (Criteria) this;
        }

        public Criteria andWShortRadNotLike(String value) {
            addCriterion("w_short_rad not like", value, "wShortRad");
            return (Criteria) this;
        }

        public Criteria andWShortRadIn(List<String> values) {
            addCriterion("w_short_rad in", values, "wShortRad");
            return (Criteria) this;
        }

        public Criteria andWShortRadNotIn(List<String> values) {
            addCriterion("w_short_rad not in", values, "wShortRad");
            return (Criteria) this;
        }

        public Criteria andWShortRadBetween(String value1, String value2) {
            addCriterion("w_short_rad between", value1, value2, "wShortRad");
            return (Criteria) this;
        }

        public Criteria andWShortRadNotBetween(String value1, String value2) {
            addCriterion("w_short_rad not between", value1, value2, "wShortRad");
            return (Criteria) this;
        }

        public Criteria andWCo2IsNull() {
            addCriterion("w_co2 is null");
            return (Criteria) this;
        }

        public Criteria andWCo2IsNotNull() {
            addCriterion("w_co2 is not null");
            return (Criteria) this;
        }

        public Criteria andWCo2EqualTo(String value) {
            addCriterion("w_co2 =", value, "wCo2");
            return (Criteria) this;
        }

        public Criteria andWCo2NotEqualTo(String value) {
            addCriterion("w_co2 <>", value, "wCo2");
            return (Criteria) this;
        }

        public Criteria andWCo2GreaterThan(String value) {
            addCriterion("w_co2 >", value, "wCo2");
            return (Criteria) this;
        }

        public Criteria andWCo2GreaterThanOrEqualTo(String value) {
            addCriterion("w_co2 >=", value, "wCo2");
            return (Criteria) this;
        }

        public Criteria andWCo2LessThan(String value) {
            addCriterion("w_co2 <", value, "wCo2");
            return (Criteria) this;
        }

        public Criteria andWCo2LessThanOrEqualTo(String value) {
            addCriterion("w_co2 <=", value, "wCo2");
            return (Criteria) this;
        }

        public Criteria andWCo2Like(String value) {
            addCriterion("w_co2 like", value, "wCo2");
            return (Criteria) this;
        }

        public Criteria andWCo2NotLike(String value) {
            addCriterion("w_co2 not like", value, "wCo2");
            return (Criteria) this;
        }

        public Criteria andWCo2In(List<String> values) {
            addCriterion("w_co2 in", values, "wCo2");
            return (Criteria) this;
        }

        public Criteria andWCo2NotIn(List<String> values) {
            addCriterion("w_co2 not in", values, "wCo2");
            return (Criteria) this;
        }

        public Criteria andWCo2Between(String value1, String value2) {
            addCriterion("w_co2 between", value1, value2, "wCo2");
            return (Criteria) this;
        }

        public Criteria andWCo2NotBetween(String value1, String value2) {
            addCriterion("w_co2 not between", value1, value2, "wCo2");
            return (Criteria) this;
        }

        public Criteria andWSunRadIsNull() {
            addCriterion("w_sun_rad is null");
            return (Criteria) this;
        }

        public Criteria andWSunRadIsNotNull() {
            addCriterion("w_sun_rad is not null");
            return (Criteria) this;
        }

        public Criteria andWSunRadEqualTo(String value) {
            addCriterion("w_sun_rad =", value, "wSunRad");
            return (Criteria) this;
        }

        public Criteria andWSunRadNotEqualTo(String value) {
            addCriterion("w_sun_rad <>", value, "wSunRad");
            return (Criteria) this;
        }

        public Criteria andWSunRadGreaterThan(String value) {
            addCriterion("w_sun_rad >", value, "wSunRad");
            return (Criteria) this;
        }

        public Criteria andWSunRadGreaterThanOrEqualTo(String value) {
            addCriterion("w_sun_rad >=", value, "wSunRad");
            return (Criteria) this;
        }

        public Criteria andWSunRadLessThan(String value) {
            addCriterion("w_sun_rad <", value, "wSunRad");
            return (Criteria) this;
        }

        public Criteria andWSunRadLessThanOrEqualTo(String value) {
            addCriterion("w_sun_rad <=", value, "wSunRad");
            return (Criteria) this;
        }

        public Criteria andWSunRadLike(String value) {
            addCriterion("w_sun_rad like", value, "wSunRad");
            return (Criteria) this;
        }

        public Criteria andWSunRadNotLike(String value) {
            addCriterion("w_sun_rad not like", value, "wSunRad");
            return (Criteria) this;
        }

        public Criteria andWSunRadIn(List<String> values) {
            addCriterion("w_sun_rad in", values, "wSunRad");
            return (Criteria) this;
        }

        public Criteria andWSunRadNotIn(List<String> values) {
            addCriterion("w_sun_rad not in", values, "wSunRad");
            return (Criteria) this;
        }

        public Criteria andWSunRadBetween(String value1, String value2) {
            addCriterion("w_sun_rad between", value1, value2, "wSunRad");
            return (Criteria) this;
        }

        public Criteria andWSunRadNotBetween(String value1, String value2) {
            addCriterion("w_sun_rad not between", value1, value2, "wSunRad");
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