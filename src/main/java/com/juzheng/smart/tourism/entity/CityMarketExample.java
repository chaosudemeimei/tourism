package com.juzheng.smart.tourism.entity;

import java.util.ArrayList;
import java.util.List;

public class CityMarketExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CityMarketExample() {
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

        public Criteria andMarketIdIsNull() {
            addCriterion("market_id is null");
            return (Criteria) this;
        }

        public Criteria andMarketIdIsNotNull() {
            addCriterion("market_id is not null");
            return (Criteria) this;
        }

        public Criteria andMarketIdEqualTo(Integer value) {
            addCriterion("market_id =", value, "marketId");
            return (Criteria) this;
        }

        public Criteria andMarketIdNotEqualTo(Integer value) {
            addCriterion("market_id <>", value, "marketId");
            return (Criteria) this;
        }

        public Criteria andMarketIdGreaterThan(Integer value) {
            addCriterion("market_id >", value, "marketId");
            return (Criteria) this;
        }

        public Criteria andMarketIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("market_id >=", value, "marketId");
            return (Criteria) this;
        }

        public Criteria andMarketIdLessThan(Integer value) {
            addCriterion("market_id <", value, "marketId");
            return (Criteria) this;
        }

        public Criteria andMarketIdLessThanOrEqualTo(Integer value) {
            addCriterion("market_id <=", value, "marketId");
            return (Criteria) this;
        }

        public Criteria andMarketIdIn(List<Integer> values) {
            addCriterion("market_id in", values, "marketId");
            return (Criteria) this;
        }

        public Criteria andMarketIdNotIn(List<Integer> values) {
            addCriterion("market_id not in", values, "marketId");
            return (Criteria) this;
        }

        public Criteria andMarketIdBetween(Integer value1, Integer value2) {
            addCriterion("market_id between", value1, value2, "marketId");
            return (Criteria) this;
        }

        public Criteria andMarketIdNotBetween(Integer value1, Integer value2) {
            addCriterion("market_id not between", value1, value2, "marketId");
            return (Criteria) this;
        }

        public Criteria andMarketScoreIsNull() {
            addCriterion("market_score is null");
            return (Criteria) this;
        }

        public Criteria andMarketScoreIsNotNull() {
            addCriterion("market_score is not null");
            return (Criteria) this;
        }

        public Criteria andMarketScoreEqualTo(String value) {
            addCriterion("market_score =", value, "marketScore");
            return (Criteria) this;
        }

        public Criteria andMarketScoreNotEqualTo(String value) {
            addCriterion("market_score <>", value, "marketScore");
            return (Criteria) this;
        }

        public Criteria andMarketScoreGreaterThan(String value) {
            addCriterion("market_score >", value, "marketScore");
            return (Criteria) this;
        }

        public Criteria andMarketScoreGreaterThanOrEqualTo(String value) {
            addCriterion("market_score >=", value, "marketScore");
            return (Criteria) this;
        }

        public Criteria andMarketScoreLessThan(String value) {
            addCriterion("market_score <", value, "marketScore");
            return (Criteria) this;
        }

        public Criteria andMarketScoreLessThanOrEqualTo(String value) {
            addCriterion("market_score <=", value, "marketScore");
            return (Criteria) this;
        }

        public Criteria andMarketScoreLike(String value) {
            addCriterion("market_score like", value, "marketScore");
            return (Criteria) this;
        }

        public Criteria andMarketScoreNotLike(String value) {
            addCriterion("market_score not like", value, "marketScore");
            return (Criteria) this;
        }

        public Criteria andMarketScoreIn(List<String> values) {
            addCriterion("market_score in", values, "marketScore");
            return (Criteria) this;
        }

        public Criteria andMarketScoreNotIn(List<String> values) {
            addCriterion("market_score not in", values, "marketScore");
            return (Criteria) this;
        }

        public Criteria andMarketScoreBetween(String value1, String value2) {
            addCriterion("market_score between", value1, value2, "marketScore");
            return (Criteria) this;
        }

        public Criteria andMarketScoreNotBetween(String value1, String value2) {
            addCriterion("market_score not between", value1, value2, "marketScore");
            return (Criteria) this;
        }

        public Criteria andMarketContentIsNull() {
            addCriterion("market_content is null");
            return (Criteria) this;
        }

        public Criteria andMarketContentIsNotNull() {
            addCriterion("market_content is not null");
            return (Criteria) this;
        }

        public Criteria andMarketContentEqualTo(String value) {
            addCriterion("market_content =", value, "marketContent");
            return (Criteria) this;
        }

        public Criteria andMarketContentNotEqualTo(String value) {
            addCriterion("market_content <>", value, "marketContent");
            return (Criteria) this;
        }

        public Criteria andMarketContentGreaterThan(String value) {
            addCriterion("market_content >", value, "marketContent");
            return (Criteria) this;
        }

        public Criteria andMarketContentGreaterThanOrEqualTo(String value) {
            addCriterion("market_content >=", value, "marketContent");
            return (Criteria) this;
        }

        public Criteria andMarketContentLessThan(String value) {
            addCriterion("market_content <", value, "marketContent");
            return (Criteria) this;
        }

        public Criteria andMarketContentLessThanOrEqualTo(String value) {
            addCriterion("market_content <=", value, "marketContent");
            return (Criteria) this;
        }

        public Criteria andMarketContentLike(String value) {
            addCriterion("market_content like", value, "marketContent");
            return (Criteria) this;
        }

        public Criteria andMarketContentNotLike(String value) {
            addCriterion("market_content not like", value, "marketContent");
            return (Criteria) this;
        }

        public Criteria andMarketContentIn(List<String> values) {
            addCriterion("market_content in", values, "marketContent");
            return (Criteria) this;
        }

        public Criteria andMarketContentNotIn(List<String> values) {
            addCriterion("market_content not in", values, "marketContent");
            return (Criteria) this;
        }

        public Criteria andMarketContentBetween(String value1, String value2) {
            addCriterion("market_content between", value1, value2, "marketContent");
            return (Criteria) this;
        }

        public Criteria andMarketContentNotBetween(String value1, String value2) {
            addCriterion("market_content not between", value1, value2, "marketContent");
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