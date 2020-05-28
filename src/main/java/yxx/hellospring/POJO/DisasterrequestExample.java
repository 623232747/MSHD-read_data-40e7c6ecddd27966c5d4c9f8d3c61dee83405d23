/*
Author：王梓彧
DateTime：2020/5/11 4:35
Iteration：第二次迭代
 */
package yxx.hellospring.POJO;

import java.util.ArrayList;
import java.util.List;

public class DisasterrequestExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DisasterrequestExample() {
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
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("ID like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("ID not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("ID not between", value1, value2, "id");
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

        public Criteria andDisastertypeIsNull() {
            addCriterion("disasterType is null");
            return (Criteria) this;
        }

        public Criteria andDisastertypeIsNotNull() {
            addCriterion("disasterType is not null");
            return (Criteria) this;
        }

        public Criteria andDisastertypeEqualTo(String value) {
            addCriterion("disasterType =", value, "disastertype");
            return (Criteria) this;
        }

        public Criteria andDisastertypeNotEqualTo(String value) {
            addCriterion("disasterType <>", value, "disastertype");
            return (Criteria) this;
        }

        public Criteria andDisastertypeGreaterThan(String value) {
            addCriterion("disasterType >", value, "disastertype");
            return (Criteria) this;
        }

        public Criteria andDisastertypeGreaterThanOrEqualTo(String value) {
            addCriterion("disasterType >=", value, "disastertype");
            return (Criteria) this;
        }

        public Criteria andDisastertypeLessThan(String value) {
            addCriterion("disasterType <", value, "disastertype");
            return (Criteria) this;
        }

        public Criteria andDisastertypeLessThanOrEqualTo(String value) {
            addCriterion("disasterType <=", value, "disastertype");
            return (Criteria) this;
        }

        public Criteria andDisastertypeLike(String value) {
            addCriterion("disasterType like", value, "disastertype");
            return (Criteria) this;
        }

        public Criteria andDisastertypeNotLike(String value) {
            addCriterion("disasterType not like", value, "disastertype");
            return (Criteria) this;
        }

        public Criteria andDisastertypeIn(List<String> values) {
            addCriterion("disasterType in", values, "disastertype");
            return (Criteria) this;
        }

        public Criteria andDisastertypeNotIn(List<String> values) {
            addCriterion("disasterType not in", values, "disastertype");
            return (Criteria) this;
        }

        public Criteria andDisastertypeBetween(String value1, String value2) {
            addCriterion("disasterType between", value1, value2, "disastertype");
            return (Criteria) this;
        }

        public Criteria andDisastertypeNotBetween(String value1, String value2) {
            addCriterion("disasterType not between", value1, value2, "disastertype");
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

        public Criteria andOUrlIsNull() {
            addCriterion("o_URL is null");
            return (Criteria) this;
        }

        public Criteria andOUrlIsNotNull() {
            addCriterion("o_URL is not null");
            return (Criteria) this;
        }

        public Criteria andOUrlEqualTo(String value) {
            addCriterion("o_URL =", value, "oUrl");
            return (Criteria) this;
        }

        public Criteria andOUrlNotEqualTo(String value) {
            addCriterion("o_URL <>", value, "oUrl");
            return (Criteria) this;
        }

        public Criteria andOUrlGreaterThan(String value) {
            addCriterion("o_URL >", value, "oUrl");
            return (Criteria) this;
        }

        public Criteria andOUrlGreaterThanOrEqualTo(String value) {
            addCriterion("o_URL >=", value, "oUrl");
            return (Criteria) this;
        }

        public Criteria andOUrlLessThan(String value) {
            addCriterion("o_URL <", value, "oUrl");
            return (Criteria) this;
        }

        public Criteria andOUrlLessThanOrEqualTo(String value) {
            addCriterion("o_URL <=", value, "oUrl");
            return (Criteria) this;
        }

        public Criteria andOUrlLike(String value) {
            addCriterion("o_URL like", value, "oUrl");
            return (Criteria) this;
        }

        public Criteria andOUrlNotLike(String value) {
            addCriterion("o_URL not like", value, "oUrl");
            return (Criteria) this;
        }

        public Criteria andOUrlIn(List<String> values) {
            addCriterion("o_URL in", values, "oUrl");
            return (Criteria) this;
        }

        public Criteria andOUrlNotIn(List<String> values) {
            addCriterion("o_URL not in", values, "oUrl");
            return (Criteria) this;
        }

        public Criteria andOUrlBetween(String value1, String value2) {
            addCriterion("o_URL between", value1, value2, "oUrl");
            return (Criteria) this;
        }

        public Criteria andOUrlNotBetween(String value1, String value2) {
            addCriterion("o_URL not between", value1, value2, "oUrl");
            return (Criteria) this;
        }

        public Criteria andRequestUnitIsNull() {
            addCriterion("\"request unit\" is null");
            return (Criteria) this;
        }

        public Criteria andRequestUnitIsNotNull() {
            addCriterion("\"request unit\" is not null");
            return (Criteria) this;
        }

        public Criteria andRequestUnitEqualTo(String value) {
            addCriterion("\"request unit\" =", value, "requestUnit");
            return (Criteria) this;
        }

        public Criteria andRequestUnitNotEqualTo(String value) {
            addCriterion("\"request unit\" <>", value, "requestUnit");
            return (Criteria) this;
        }

        public Criteria andRequestUnitGreaterThan(String value) {
            addCriterion("\"request unit\" >", value, "requestUnit");
            return (Criteria) this;
        }

        public Criteria andRequestUnitGreaterThanOrEqualTo(String value) {
            addCriterion("\"request unit\" >=", value, "requestUnit");
            return (Criteria) this;
        }

        public Criteria andRequestUnitLessThan(String value) {
            addCriterion("\"request unit\" <", value, "requestUnit");
            return (Criteria) this;
        }

        public Criteria andRequestUnitLessThanOrEqualTo(String value) {
            addCriterion("\"request unit\" <=", value, "requestUnit");
            return (Criteria) this;
        }

        public Criteria andRequestUnitLike(String value) {
            addCriterion("\"request unit\" like", value, "requestUnit");
            return (Criteria) this;
        }

        public Criteria andRequestUnitNotLike(String value) {
            addCriterion("\"request unit\" not like", value, "requestUnit");
            return (Criteria) this;
        }

        public Criteria andRequestUnitIn(List<String> values) {
            addCriterion("\"request unit\" in", values, "requestUnit");
            return (Criteria) this;
        }

        public Criteria andRequestUnitNotIn(List<String> values) {
            addCriterion("\"request unit\" not in", values, "requestUnit");
            return (Criteria) this;
        }

        public Criteria andRequestUnitBetween(String value1, String value2) {
            addCriterion("\"request unit\" between", value1, value2, "requestUnit");
            return (Criteria) this;
        }

        public Criteria andRequestUnitNotBetween(String value1, String value2) {
            addCriterion("\"request unit\" not between", value1, value2, "requestUnit");
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