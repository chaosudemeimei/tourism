package com.juzheng.smart.tourism.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CityPlayExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CityPlayExample() {
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

        public Criteria andPlayIdIsNull() {
            addCriterion("play_id is null");
            return (Criteria) this;
        }

        public Criteria andPlayIdIsNotNull() {
            addCriterion("play_id is not null");
            return (Criteria) this;
        }

        public Criteria andPlayIdEqualTo(Integer value) {
            addCriterion("play_id =", value, "playId");
            return (Criteria) this;
        }

        public Criteria andPlayIdNotEqualTo(Integer value) {
            addCriterion("play_id <>", value, "playId");
            return (Criteria) this;
        }

        public Criteria andPlayIdGreaterThan(Integer value) {
            addCriterion("play_id >", value, "playId");
            return (Criteria) this;
        }

        public Criteria andPlayIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("play_id >=", value, "playId");
            return (Criteria) this;
        }

        public Criteria andPlayIdLessThan(Integer value) {
            addCriterion("play_id <", value, "playId");
            return (Criteria) this;
        }

        public Criteria andPlayIdLessThanOrEqualTo(Integer value) {
            addCriterion("play_id <=", value, "playId");
            return (Criteria) this;
        }

        public Criteria andPlayIdIn(List<Integer> values) {
            addCriterion("play_id in", values, "playId");
            return (Criteria) this;
        }

        public Criteria andPlayIdNotIn(List<Integer> values) {
            addCriterion("play_id not in", values, "playId");
            return (Criteria) this;
        }

        public Criteria andPlayIdBetween(Integer value1, Integer value2) {
            addCriterion("play_id between", value1, value2, "playId");
            return (Criteria) this;
        }

        public Criteria andPlayIdNotBetween(Integer value1, Integer value2) {
            addCriterion("play_id not between", value1, value2, "playId");
            return (Criteria) this;
        }

        public Criteria andPlayNameIsNull() {
            addCriterion("play_name is null");
            return (Criteria) this;
        }

        public Criteria andPlayNameIsNotNull() {
            addCriterion("play_name is not null");
            return (Criteria) this;
        }

        public Criteria andPlayNameEqualTo(String value) {
            addCriterion("play_name =", value, "playName");
            return (Criteria) this;
        }

        public Criteria andPlayNameNotEqualTo(String value) {
            addCriterion("play_name <>", value, "playName");
            return (Criteria) this;
        }

        public Criteria andPlayNameGreaterThan(String value) {
            addCriterion("play_name >", value, "playName");
            return (Criteria) this;
        }

        public Criteria andPlayNameGreaterThanOrEqualTo(String value) {
            addCriterion("play_name >=", value, "playName");
            return (Criteria) this;
        }

        public Criteria andPlayNameLessThan(String value) {
            addCriterion("play_name <", value, "playName");
            return (Criteria) this;
        }

        public Criteria andPlayNameLessThanOrEqualTo(String value) {
            addCriterion("play_name <=", value, "playName");
            return (Criteria) this;
        }

        public Criteria andPlayNameLike(String value) {
            addCriterion("play_name like", value, "playName");
            return (Criteria) this;
        }

        public Criteria andPlayNameNotLike(String value) {
            addCriterion("play_name not like", value, "playName");
            return (Criteria) this;
        }

        public Criteria andPlayNameIn(List<String> values) {
            addCriterion("play_name in", values, "playName");
            return (Criteria) this;
        }

        public Criteria andPlayNameNotIn(List<String> values) {
            addCriterion("play_name not in", values, "playName");
            return (Criteria) this;
        }

        public Criteria andPlayNameBetween(String value1, String value2) {
            addCriterion("play_name between", value1, value2, "playName");
            return (Criteria) this;
        }

        public Criteria andPlayNameNotBetween(String value1, String value2) {
            addCriterion("play_name not between", value1, value2, "playName");
            return (Criteria) this;
        }

        public Criteria andPlayAddressIsNull() {
            addCriterion("play_address is null");
            return (Criteria) this;
        }

        public Criteria andPlayAddressIsNotNull() {
            addCriterion("play_address is not null");
            return (Criteria) this;
        }

        public Criteria andPlayAddressEqualTo(String value) {
            addCriterion("play_address =", value, "playAddress");
            return (Criteria) this;
        }

        public Criteria andPlayAddressNotEqualTo(String value) {
            addCriterion("play_address <>", value, "playAddress");
            return (Criteria) this;
        }

        public Criteria andPlayAddressGreaterThan(String value) {
            addCriterion("play_address >", value, "playAddress");
            return (Criteria) this;
        }

        public Criteria andPlayAddressGreaterThanOrEqualTo(String value) {
            addCriterion("play_address >=", value, "playAddress");
            return (Criteria) this;
        }

        public Criteria andPlayAddressLessThan(String value) {
            addCriterion("play_address <", value, "playAddress");
            return (Criteria) this;
        }

        public Criteria andPlayAddressLessThanOrEqualTo(String value) {
            addCriterion("play_address <=", value, "playAddress");
            return (Criteria) this;
        }

        public Criteria andPlayAddressLike(String value) {
            addCriterion("play_address like", value, "playAddress");
            return (Criteria) this;
        }

        public Criteria andPlayAddressNotLike(String value) {
            addCriterion("play_address not like", value, "playAddress");
            return (Criteria) this;
        }

        public Criteria andPlayAddressIn(List<String> values) {
            addCriterion("play_address in", values, "playAddress");
            return (Criteria) this;
        }

        public Criteria andPlayAddressNotIn(List<String> values) {
            addCriterion("play_address not in", values, "playAddress");
            return (Criteria) this;
        }

        public Criteria andPlayAddressBetween(String value1, String value2) {
            addCriterion("play_address between", value1, value2, "playAddress");
            return (Criteria) this;
        }

        public Criteria andPlayAddressNotBetween(String value1, String value2) {
            addCriterion("play_address not between", value1, value2, "playAddress");
            return (Criteria) this;
        }

        public Criteria andPlayPriceIsNull() {
            addCriterion("play_price is null");
            return (Criteria) this;
        }

        public Criteria andPlayPriceIsNotNull() {
            addCriterion("play_price is not null");
            return (Criteria) this;
        }

        public Criteria andPlayPriceEqualTo(BigDecimal value) {
            addCriterion("play_price =", value, "playPrice");
            return (Criteria) this;
        }

        public Criteria andPlayPriceNotEqualTo(BigDecimal value) {
            addCriterion("play_price <>", value, "playPrice");
            return (Criteria) this;
        }

        public Criteria andPlayPriceGreaterThan(BigDecimal value) {
            addCriterion("play_price >", value, "playPrice");
            return (Criteria) this;
        }

        public Criteria andPlayPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("play_price >=", value, "playPrice");
            return (Criteria) this;
        }

        public Criteria andPlayPriceLessThan(BigDecimal value) {
            addCriterion("play_price <", value, "playPrice");
            return (Criteria) this;
        }

        public Criteria andPlayPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("play_price <=", value, "playPrice");
            return (Criteria) this;
        }

        public Criteria andPlayPriceIn(List<BigDecimal> values) {
            addCriterion("play_price in", values, "playPrice");
            return (Criteria) this;
        }

        public Criteria andPlayPriceNotIn(List<BigDecimal> values) {
            addCriterion("play_price not in", values, "playPrice");
            return (Criteria) this;
        }

        public Criteria andPlayPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("play_price between", value1, value2, "playPrice");
            return (Criteria) this;
        }

        public Criteria andPlayPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("play_price not between", value1, value2, "playPrice");
            return (Criteria) this;
        }

        public Criteria andPlayKeywordsIsNull() {
            addCriterion("play_keywords is null");
            return (Criteria) this;
        }

        public Criteria andPlayKeywordsIsNotNull() {
            addCriterion("play_keywords is not null");
            return (Criteria) this;
        }

        public Criteria andPlayKeywordsEqualTo(String value) {
            addCriterion("play_keywords =", value, "playKeywords");
            return (Criteria) this;
        }

        public Criteria andPlayKeywordsNotEqualTo(String value) {
            addCriterion("play_keywords <>", value, "playKeywords");
            return (Criteria) this;
        }

        public Criteria andPlayKeywordsGreaterThan(String value) {
            addCriterion("play_keywords >", value, "playKeywords");
            return (Criteria) this;
        }

        public Criteria andPlayKeywordsGreaterThanOrEqualTo(String value) {
            addCriterion("play_keywords >=", value, "playKeywords");
            return (Criteria) this;
        }

        public Criteria andPlayKeywordsLessThan(String value) {
            addCriterion("play_keywords <", value, "playKeywords");
            return (Criteria) this;
        }

        public Criteria andPlayKeywordsLessThanOrEqualTo(String value) {
            addCriterion("play_keywords <=", value, "playKeywords");
            return (Criteria) this;
        }

        public Criteria andPlayKeywordsLike(String value) {
            addCriterion("play_keywords like", value, "playKeywords");
            return (Criteria) this;
        }

        public Criteria andPlayKeywordsNotLike(String value) {
            addCriterion("play_keywords not like", value, "playKeywords");
            return (Criteria) this;
        }

        public Criteria andPlayKeywordsIn(List<String> values) {
            addCriterion("play_keywords in", values, "playKeywords");
            return (Criteria) this;
        }

        public Criteria andPlayKeywordsNotIn(List<String> values) {
            addCriterion("play_keywords not in", values, "playKeywords");
            return (Criteria) this;
        }

        public Criteria andPlayKeywordsBetween(String value1, String value2) {
            addCriterion("play_keywords between", value1, value2, "playKeywords");
            return (Criteria) this;
        }

        public Criteria andPlayKeywordsNotBetween(String value1, String value2) {
            addCriterion("play_keywords not between", value1, value2, "playKeywords");
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