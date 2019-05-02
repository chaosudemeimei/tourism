package com.juzheng.smart.tourism.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CityEatExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CityEatExample() {
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

        public Criteria andEatIdIsNull() {
            addCriterion("eat_id is null");
            return (Criteria) this;
        }

        public Criteria andEatIdIsNotNull() {
            addCriterion("eat_id is not null");
            return (Criteria) this;
        }

        public Criteria andEatIdEqualTo(Integer value) {
            addCriterion("eat_id =", value, "eatId");
            return (Criteria) this;
        }

        public Criteria andEatIdNotEqualTo(Integer value) {
            addCriterion("eat_id <>", value, "eatId");
            return (Criteria) this;
        }

        public Criteria andEatIdGreaterThan(Integer value) {
            addCriterion("eat_id >", value, "eatId");
            return (Criteria) this;
        }

        public Criteria andEatIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("eat_id >=", value, "eatId");
            return (Criteria) this;
        }

        public Criteria andEatIdLessThan(Integer value) {
            addCriterion("eat_id <", value, "eatId");
            return (Criteria) this;
        }

        public Criteria andEatIdLessThanOrEqualTo(Integer value) {
            addCriterion("eat_id <=", value, "eatId");
            return (Criteria) this;
        }

        public Criteria andEatIdIn(List<Integer> values) {
            addCriterion("eat_id in", values, "eatId");
            return (Criteria) this;
        }

        public Criteria andEatIdNotIn(List<Integer> values) {
            addCriterion("eat_id not in", values, "eatId");
            return (Criteria) this;
        }

        public Criteria andEatIdBetween(Integer value1, Integer value2) {
            addCriterion("eat_id between", value1, value2, "eatId");
            return (Criteria) this;
        }

        public Criteria andEatIdNotBetween(Integer value1, Integer value2) {
            addCriterion("eat_id not between", value1, value2, "eatId");
            return (Criteria) this;
        }

        public Criteria andEatNameIsNull() {
            addCriterion("eat_name is null");
            return (Criteria) this;
        }

        public Criteria andEatNameIsNotNull() {
            addCriterion("eat_name is not null");
            return (Criteria) this;
        }

        public Criteria andEatNameEqualTo(String value) {
            addCriterion("eat_name =", value, "eatName");
            return (Criteria) this;
        }

        public Criteria andEatNameNotEqualTo(String value) {
            addCriterion("eat_name <>", value, "eatName");
            return (Criteria) this;
        }

        public Criteria andEatNameGreaterThan(String value) {
            addCriterion("eat_name >", value, "eatName");
            return (Criteria) this;
        }

        public Criteria andEatNameGreaterThanOrEqualTo(String value) {
            addCriterion("eat_name >=", value, "eatName");
            return (Criteria) this;
        }

        public Criteria andEatNameLessThan(String value) {
            addCriterion("eat_name <", value, "eatName");
            return (Criteria) this;
        }

        public Criteria andEatNameLessThanOrEqualTo(String value) {
            addCriterion("eat_name <=", value, "eatName");
            return (Criteria) this;
        }

        public Criteria andEatNameLike(String value) {
            addCriterion("eat_name like", value, "eatName");
            return (Criteria) this;
        }

        public Criteria andEatNameNotLike(String value) {
            addCriterion("eat_name not like", value, "eatName");
            return (Criteria) this;
        }

        public Criteria andEatNameIn(List<String> values) {
            addCriterion("eat_name in", values, "eatName");
            return (Criteria) this;
        }

        public Criteria andEatNameNotIn(List<String> values) {
            addCriterion("eat_name not in", values, "eatName");
            return (Criteria) this;
        }

        public Criteria andEatNameBetween(String value1, String value2) {
            addCriterion("eat_name between", value1, value2, "eatName");
            return (Criteria) this;
        }

        public Criteria andEatNameNotBetween(String value1, String value2) {
            addCriterion("eat_name not between", value1, value2, "eatName");
            return (Criteria) this;
        }

        public Criteria andEatIntroduceIsNull() {
            addCriterion("eat_introduce is null");
            return (Criteria) this;
        }

        public Criteria andEatIntroduceIsNotNull() {
            addCriterion("eat_introduce is not null");
            return (Criteria) this;
        }

        public Criteria andEatIntroduceEqualTo(String value) {
            addCriterion("eat_introduce =", value, "eatIntroduce");
            return (Criteria) this;
        }

        public Criteria andEatIntroduceNotEqualTo(String value) {
            addCriterion("eat_introduce <>", value, "eatIntroduce");
            return (Criteria) this;
        }

        public Criteria andEatIntroduceGreaterThan(String value) {
            addCriterion("eat_introduce >", value, "eatIntroduce");
            return (Criteria) this;
        }

        public Criteria andEatIntroduceGreaterThanOrEqualTo(String value) {
            addCriterion("eat_introduce >=", value, "eatIntroduce");
            return (Criteria) this;
        }

        public Criteria andEatIntroduceLessThan(String value) {
            addCriterion("eat_introduce <", value, "eatIntroduce");
            return (Criteria) this;
        }

        public Criteria andEatIntroduceLessThanOrEqualTo(String value) {
            addCriterion("eat_introduce <=", value, "eatIntroduce");
            return (Criteria) this;
        }

        public Criteria andEatIntroduceLike(String value) {
            addCriterion("eat_introduce like", value, "eatIntroduce");
            return (Criteria) this;
        }

        public Criteria andEatIntroduceNotLike(String value) {
            addCriterion("eat_introduce not like", value, "eatIntroduce");
            return (Criteria) this;
        }

        public Criteria andEatIntroduceIn(List<String> values) {
            addCriterion("eat_introduce in", values, "eatIntroduce");
            return (Criteria) this;
        }

        public Criteria andEatIntroduceNotIn(List<String> values) {
            addCriterion("eat_introduce not in", values, "eatIntroduce");
            return (Criteria) this;
        }

        public Criteria andEatIntroduceBetween(String value1, String value2) {
            addCriterion("eat_introduce between", value1, value2, "eatIntroduce");
            return (Criteria) this;
        }

        public Criteria andEatIntroduceNotBetween(String value1, String value2) {
            addCriterion("eat_introduce not between", value1, value2, "eatIntroduce");
            return (Criteria) this;
        }

        public Criteria andEatPriceIsNull() {
            addCriterion("eat_price is null");
            return (Criteria) this;
        }

        public Criteria andEatPriceIsNotNull() {
            addCriterion("eat_price is not null");
            return (Criteria) this;
        }

        public Criteria andEatPriceEqualTo(BigDecimal value) {
            addCriterion("eat_price =", value, "eatPrice");
            return (Criteria) this;
        }

        public Criteria andEatPriceNotEqualTo(BigDecimal value) {
            addCriterion("eat_price <>", value, "eatPrice");
            return (Criteria) this;
        }

        public Criteria andEatPriceGreaterThan(BigDecimal value) {
            addCriterion("eat_price >", value, "eatPrice");
            return (Criteria) this;
        }

        public Criteria andEatPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("eat_price >=", value, "eatPrice");
            return (Criteria) this;
        }

        public Criteria andEatPriceLessThan(BigDecimal value) {
            addCriterion("eat_price <", value, "eatPrice");
            return (Criteria) this;
        }

        public Criteria andEatPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("eat_price <=", value, "eatPrice");
            return (Criteria) this;
        }

        public Criteria andEatPriceIn(List<BigDecimal> values) {
            addCriterion("eat_price in", values, "eatPrice");
            return (Criteria) this;
        }

        public Criteria andEatPriceNotIn(List<BigDecimal> values) {
            addCriterion("eat_price not in", values, "eatPrice");
            return (Criteria) this;
        }

        public Criteria andEatPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("eat_price between", value1, value2, "eatPrice");
            return (Criteria) this;
        }

        public Criteria andEatPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("eat_price not between", value1, value2, "eatPrice");
            return (Criteria) this;
        }

        public Criteria andEatKeywordsIsNull() {
            addCriterion("eat_keywords is null");
            return (Criteria) this;
        }

        public Criteria andEatKeywordsIsNotNull() {
            addCriterion("eat_keywords is not null");
            return (Criteria) this;
        }

        public Criteria andEatKeywordsEqualTo(String value) {
            addCriterion("eat_keywords =", value, "eatKeywords");
            return (Criteria) this;
        }

        public Criteria andEatKeywordsNotEqualTo(String value) {
            addCriterion("eat_keywords <>", value, "eatKeywords");
            return (Criteria) this;
        }

        public Criteria andEatKeywordsGreaterThan(String value) {
            addCriterion("eat_keywords >", value, "eatKeywords");
            return (Criteria) this;
        }

        public Criteria andEatKeywordsGreaterThanOrEqualTo(String value) {
            addCriterion("eat_keywords >=", value, "eatKeywords");
            return (Criteria) this;
        }

        public Criteria andEatKeywordsLessThan(String value) {
            addCriterion("eat_keywords <", value, "eatKeywords");
            return (Criteria) this;
        }

        public Criteria andEatKeywordsLessThanOrEqualTo(String value) {
            addCriterion("eat_keywords <=", value, "eatKeywords");
            return (Criteria) this;
        }

        public Criteria andEatKeywordsLike(String value) {
            addCriterion("eat_keywords like", value, "eatKeywords");
            return (Criteria) this;
        }

        public Criteria andEatKeywordsNotLike(String value) {
            addCriterion("eat_keywords not like", value, "eatKeywords");
            return (Criteria) this;
        }

        public Criteria andEatKeywordsIn(List<String> values) {
            addCriterion("eat_keywords in", values, "eatKeywords");
            return (Criteria) this;
        }

        public Criteria andEatKeywordsNotIn(List<String> values) {
            addCriterion("eat_keywords not in", values, "eatKeywords");
            return (Criteria) this;
        }

        public Criteria andEatKeywordsBetween(String value1, String value2) {
            addCriterion("eat_keywords between", value1, value2, "eatKeywords");
            return (Criteria) this;
        }

        public Criteria andEatKeywordsNotBetween(String value1, String value2) {
            addCriterion("eat_keywords not between", value1, value2, "eatKeywords");
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