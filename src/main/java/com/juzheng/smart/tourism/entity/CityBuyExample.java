package com.juzheng.smart.tourism.entity;

import java.util.ArrayList;
import java.util.List;

public class CityBuyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CityBuyExample() {
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

        public Criteria andBuyIdIsNull() {
            addCriterion("buy_id is null");
            return (Criteria) this;
        }

        public Criteria andBuyIdIsNotNull() {
            addCriterion("buy_id is not null");
            return (Criteria) this;
        }

        public Criteria andBuyIdEqualTo(Integer value) {
            addCriterion("buy_id =", value, "buyId");
            return (Criteria) this;
        }

        public Criteria andBuyIdNotEqualTo(Integer value) {
            addCriterion("buy_id <>", value, "buyId");
            return (Criteria) this;
        }

        public Criteria andBuyIdGreaterThan(Integer value) {
            addCriterion("buy_id >", value, "buyId");
            return (Criteria) this;
        }

        public Criteria andBuyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("buy_id >=", value, "buyId");
            return (Criteria) this;
        }

        public Criteria andBuyIdLessThan(Integer value) {
            addCriterion("buy_id <", value, "buyId");
            return (Criteria) this;
        }

        public Criteria andBuyIdLessThanOrEqualTo(Integer value) {
            addCriterion("buy_id <=", value, "buyId");
            return (Criteria) this;
        }

        public Criteria andBuyIdIn(List<Integer> values) {
            addCriterion("buy_id in", values, "buyId");
            return (Criteria) this;
        }

        public Criteria andBuyIdNotIn(List<Integer> values) {
            addCriterion("buy_id not in", values, "buyId");
            return (Criteria) this;
        }

        public Criteria andBuyIdBetween(Integer value1, Integer value2) {
            addCriterion("buy_id between", value1, value2, "buyId");
            return (Criteria) this;
        }

        public Criteria andBuyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("buy_id not between", value1, value2, "buyId");
            return (Criteria) this;
        }

        public Criteria andBuyNameIsNull() {
            addCriterion("buy_name is null");
            return (Criteria) this;
        }

        public Criteria andBuyNameIsNotNull() {
            addCriterion("buy_name is not null");
            return (Criteria) this;
        }

        public Criteria andBuyNameEqualTo(String value) {
            addCriterion("buy_name =", value, "buyName");
            return (Criteria) this;
        }

        public Criteria andBuyNameNotEqualTo(String value) {
            addCriterion("buy_name <>", value, "buyName");
            return (Criteria) this;
        }

        public Criteria andBuyNameGreaterThan(String value) {
            addCriterion("buy_name >", value, "buyName");
            return (Criteria) this;
        }

        public Criteria andBuyNameGreaterThanOrEqualTo(String value) {
            addCriterion("buy_name >=", value, "buyName");
            return (Criteria) this;
        }

        public Criteria andBuyNameLessThan(String value) {
            addCriterion("buy_name <", value, "buyName");
            return (Criteria) this;
        }

        public Criteria andBuyNameLessThanOrEqualTo(String value) {
            addCriterion("buy_name <=", value, "buyName");
            return (Criteria) this;
        }

        public Criteria andBuyNameLike(String value) {
            addCriterion("buy_name like", value, "buyName");
            return (Criteria) this;
        }

        public Criteria andBuyNameNotLike(String value) {
            addCriterion("buy_name not like", value, "buyName");
            return (Criteria) this;
        }

        public Criteria andBuyNameIn(List<String> values) {
            addCriterion("buy_name in", values, "buyName");
            return (Criteria) this;
        }

        public Criteria andBuyNameNotIn(List<String> values) {
            addCriterion("buy_name not in", values, "buyName");
            return (Criteria) this;
        }

        public Criteria andBuyNameBetween(String value1, String value2) {
            addCriterion("buy_name between", value1, value2, "buyName");
            return (Criteria) this;
        }

        public Criteria andBuyNameNotBetween(String value1, String value2) {
            addCriterion("buy_name not between", value1, value2, "buyName");
            return (Criteria) this;
        }

        public Criteria andBuyAddressIsNull() {
            addCriterion("buy_address is null");
            return (Criteria) this;
        }

        public Criteria andBuyAddressIsNotNull() {
            addCriterion("buy_address is not null");
            return (Criteria) this;
        }

        public Criteria andBuyAddressEqualTo(String value) {
            addCriterion("buy_address =", value, "buyAddress");
            return (Criteria) this;
        }

        public Criteria andBuyAddressNotEqualTo(String value) {
            addCriterion("buy_address <>", value, "buyAddress");
            return (Criteria) this;
        }

        public Criteria andBuyAddressGreaterThan(String value) {
            addCriterion("buy_address >", value, "buyAddress");
            return (Criteria) this;
        }

        public Criteria andBuyAddressGreaterThanOrEqualTo(String value) {
            addCriterion("buy_address >=", value, "buyAddress");
            return (Criteria) this;
        }

        public Criteria andBuyAddressLessThan(String value) {
            addCriterion("buy_address <", value, "buyAddress");
            return (Criteria) this;
        }

        public Criteria andBuyAddressLessThanOrEqualTo(String value) {
            addCriterion("buy_address <=", value, "buyAddress");
            return (Criteria) this;
        }

        public Criteria andBuyAddressLike(String value) {
            addCriterion("buy_address like", value, "buyAddress");
            return (Criteria) this;
        }

        public Criteria andBuyAddressNotLike(String value) {
            addCriterion("buy_address not like", value, "buyAddress");
            return (Criteria) this;
        }

        public Criteria andBuyAddressIn(List<String> values) {
            addCriterion("buy_address in", values, "buyAddress");
            return (Criteria) this;
        }

        public Criteria andBuyAddressNotIn(List<String> values) {
            addCriterion("buy_address not in", values, "buyAddress");
            return (Criteria) this;
        }

        public Criteria andBuyAddressBetween(String value1, String value2) {
            addCriterion("buy_address between", value1, value2, "buyAddress");
            return (Criteria) this;
        }

        public Criteria andBuyAddressNotBetween(String value1, String value2) {
            addCriterion("buy_address not between", value1, value2, "buyAddress");
            return (Criteria) this;
        }

        public Criteria andBuyKeywordsIsNull() {
            addCriterion("buy_keywords is null");
            return (Criteria) this;
        }

        public Criteria andBuyKeywordsIsNotNull() {
            addCriterion("buy_keywords is not null");
            return (Criteria) this;
        }

        public Criteria andBuyKeywordsEqualTo(String value) {
            addCriterion("buy_keywords =", value, "buyKeywords");
            return (Criteria) this;
        }

        public Criteria andBuyKeywordsNotEqualTo(String value) {
            addCriterion("buy_keywords <>", value, "buyKeywords");
            return (Criteria) this;
        }

        public Criteria andBuyKeywordsGreaterThan(String value) {
            addCriterion("buy_keywords >", value, "buyKeywords");
            return (Criteria) this;
        }

        public Criteria andBuyKeywordsGreaterThanOrEqualTo(String value) {
            addCriterion("buy_keywords >=", value, "buyKeywords");
            return (Criteria) this;
        }

        public Criteria andBuyKeywordsLessThan(String value) {
            addCriterion("buy_keywords <", value, "buyKeywords");
            return (Criteria) this;
        }

        public Criteria andBuyKeywordsLessThanOrEqualTo(String value) {
            addCriterion("buy_keywords <=", value, "buyKeywords");
            return (Criteria) this;
        }

        public Criteria andBuyKeywordsLike(String value) {
            addCriterion("buy_keywords like", value, "buyKeywords");
            return (Criteria) this;
        }

        public Criteria andBuyKeywordsNotLike(String value) {
            addCriterion("buy_keywords not like", value, "buyKeywords");
            return (Criteria) this;
        }

        public Criteria andBuyKeywordsIn(List<String> values) {
            addCriterion("buy_keywords in", values, "buyKeywords");
            return (Criteria) this;
        }

        public Criteria andBuyKeywordsNotIn(List<String> values) {
            addCriterion("buy_keywords not in", values, "buyKeywords");
            return (Criteria) this;
        }

        public Criteria andBuyKeywordsBetween(String value1, String value2) {
            addCriterion("buy_keywords between", value1, value2, "buyKeywords");
            return (Criteria) this;
        }

        public Criteria andBuyKeywordsNotBetween(String value1, String value2) {
            addCriterion("buy_keywords not between", value1, value2, "buyKeywords");
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