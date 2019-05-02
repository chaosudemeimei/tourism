package com.juzheng.smart.tourism.entity;

import java.util.ArrayList;
import java.util.List;

public class CityWeatherExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CityWeatherExample() {
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

        public Criteria andWeatherIdIsNull() {
            addCriterion("weather_id is null");
            return (Criteria) this;
        }

        public Criteria andWeatherIdIsNotNull() {
            addCriterion("weather_id is not null");
            return (Criteria) this;
        }

        public Criteria andWeatherIdEqualTo(Integer value) {
            addCriterion("weather_id =", value, "weatherId");
            return (Criteria) this;
        }

        public Criteria andWeatherIdNotEqualTo(Integer value) {
            addCriterion("weather_id <>", value, "weatherId");
            return (Criteria) this;
        }

        public Criteria andWeatherIdGreaterThan(Integer value) {
            addCriterion("weather_id >", value, "weatherId");
            return (Criteria) this;
        }

        public Criteria andWeatherIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("weather_id >=", value, "weatherId");
            return (Criteria) this;
        }

        public Criteria andWeatherIdLessThan(Integer value) {
            addCriterion("weather_id <", value, "weatherId");
            return (Criteria) this;
        }

        public Criteria andWeatherIdLessThanOrEqualTo(Integer value) {
            addCriterion("weather_id <=", value, "weatherId");
            return (Criteria) this;
        }

        public Criteria andWeatherIdIn(List<Integer> values) {
            addCriterion("weather_id in", values, "weatherId");
            return (Criteria) this;
        }

        public Criteria andWeatherIdNotIn(List<Integer> values) {
            addCriterion("weather_id not in", values, "weatherId");
            return (Criteria) this;
        }

        public Criteria andWeatherIdBetween(Integer value1, Integer value2) {
            addCriterion("weather_id between", value1, value2, "weatherId");
            return (Criteria) this;
        }

        public Criteria andWeatherIdNotBetween(Integer value1, Integer value2) {
            addCriterion("weather_id not between", value1, value2, "weatherId");
            return (Criteria) this;
        }

        public Criteria andMaxTemIsNull() {
            addCriterion("max_tem is null");
            return (Criteria) this;
        }

        public Criteria andMaxTemIsNotNull() {
            addCriterion("max_tem is not null");
            return (Criteria) this;
        }

        public Criteria andMaxTemEqualTo(String value) {
            addCriterion("max_tem =", value, "maxTem");
            return (Criteria) this;
        }

        public Criteria andMaxTemNotEqualTo(String value) {
            addCriterion("max_tem <>", value, "maxTem");
            return (Criteria) this;
        }

        public Criteria andMaxTemGreaterThan(String value) {
            addCriterion("max_tem >", value, "maxTem");
            return (Criteria) this;
        }

        public Criteria andMaxTemGreaterThanOrEqualTo(String value) {
            addCriterion("max_tem >=", value, "maxTem");
            return (Criteria) this;
        }

        public Criteria andMaxTemLessThan(String value) {
            addCriterion("max_tem <", value, "maxTem");
            return (Criteria) this;
        }

        public Criteria andMaxTemLessThanOrEqualTo(String value) {
            addCriterion("max_tem <=", value, "maxTem");
            return (Criteria) this;
        }

        public Criteria andMaxTemLike(String value) {
            addCriterion("max_tem like", value, "maxTem");
            return (Criteria) this;
        }

        public Criteria andMaxTemNotLike(String value) {
            addCriterion("max_tem not like", value, "maxTem");
            return (Criteria) this;
        }

        public Criteria andMaxTemIn(List<String> values) {
            addCriterion("max_tem in", values, "maxTem");
            return (Criteria) this;
        }

        public Criteria andMaxTemNotIn(List<String> values) {
            addCriterion("max_tem not in", values, "maxTem");
            return (Criteria) this;
        }

        public Criteria andMaxTemBetween(String value1, String value2) {
            addCriterion("max_tem between", value1, value2, "maxTem");
            return (Criteria) this;
        }

        public Criteria andMaxTemNotBetween(String value1, String value2) {
            addCriterion("max_tem not between", value1, value2, "maxTem");
            return (Criteria) this;
        }

        public Criteria andMinTemIsNull() {
            addCriterion("min_tem is null");
            return (Criteria) this;
        }

        public Criteria andMinTemIsNotNull() {
            addCriterion("min_tem is not null");
            return (Criteria) this;
        }

        public Criteria andMinTemEqualTo(String value) {
            addCriterion("min_tem =", value, "minTem");
            return (Criteria) this;
        }

        public Criteria andMinTemNotEqualTo(String value) {
            addCriterion("min_tem <>", value, "minTem");
            return (Criteria) this;
        }

        public Criteria andMinTemGreaterThan(String value) {
            addCriterion("min_tem >", value, "minTem");
            return (Criteria) this;
        }

        public Criteria andMinTemGreaterThanOrEqualTo(String value) {
            addCriterion("min_tem >=", value, "minTem");
            return (Criteria) this;
        }

        public Criteria andMinTemLessThan(String value) {
            addCriterion("min_tem <", value, "minTem");
            return (Criteria) this;
        }

        public Criteria andMinTemLessThanOrEqualTo(String value) {
            addCriterion("min_tem <=", value, "minTem");
            return (Criteria) this;
        }

        public Criteria andMinTemLike(String value) {
            addCriterion("min_tem like", value, "minTem");
            return (Criteria) this;
        }

        public Criteria andMinTemNotLike(String value) {
            addCriterion("min_tem not like", value, "minTem");
            return (Criteria) this;
        }

        public Criteria andMinTemIn(List<String> values) {
            addCriterion("min_tem in", values, "minTem");
            return (Criteria) this;
        }

        public Criteria andMinTemNotIn(List<String> values) {
            addCriterion("min_tem not in", values, "minTem");
            return (Criteria) this;
        }

        public Criteria andMinTemBetween(String value1, String value2) {
            addCriterion("min_tem between", value1, value2, "minTem");
            return (Criteria) this;
        }

        public Criteria andMinTemNotBetween(String value1, String value2) {
            addCriterion("min_tem not between", value1, value2, "minTem");
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

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
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