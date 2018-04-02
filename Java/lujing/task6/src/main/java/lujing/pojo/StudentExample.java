package lujing.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StudentExample() {
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andQqNumIsNull() {
            addCriterion("qq_num is null");
            return (Criteria) this;
        }

        public Criteria andQqNumIsNotNull() {
            addCriterion("qq_num is not null");
            return (Criteria) this;
        }

        public Criteria andQqNumEqualTo(String value) {
            addCriterion("qq_num =", value, "qqNum");
            return (Criteria) this;
        }

        public Criteria andQqNumNotEqualTo(String value) {
            addCriterion("qq_num <>", value, "qqNum");
            return (Criteria) this;
        }

        public Criteria andQqNumGreaterThan(String value) {
            addCriterion("qq_num >", value, "qqNum");
            return (Criteria) this;
        }

        public Criteria andQqNumGreaterThanOrEqualTo(String value) {
            addCriterion("qq_num >=", value, "qqNum");
            return (Criteria) this;
        }

        public Criteria andQqNumLessThan(String value) {
            addCriterion("qq_num <", value, "qqNum");
            return (Criteria) this;
        }

        public Criteria andQqNumLessThanOrEqualTo(String value) {
            addCriterion("qq_num <=", value, "qqNum");
            return (Criteria) this;
        }

        public Criteria andQqNumLike(String value) {
            addCriterion("qq_num like", value, "qqNum");
            return (Criteria) this;
        }

        public Criteria andQqNumNotLike(String value) {
            addCriterion("qq_num not like", value, "qqNum");
            return (Criteria) this;
        }

        public Criteria andQqNumIn(List<String> values) {
            addCriterion("qq_num in", values, "qqNum");
            return (Criteria) this;
        }

        public Criteria andQqNumNotIn(List<String> values) {
            addCriterion("qq_num not in", values, "qqNum");
            return (Criteria) this;
        }

        public Criteria andQqNumBetween(String value1, String value2) {
            addCriterion("qq_num between", value1, value2, "qqNum");
            return (Criteria) this;
        }

        public Criteria andQqNumNotBetween(String value1, String value2) {
            addCriterion("qq_num not between", value1, value2, "qqNum");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andPerTimeIsNull() {
            addCriterion("per_time is null");
            return (Criteria) this;
        }

        public Criteria andPerTimeIsNotNull() {
            addCriterion("per_time is not null");
            return (Criteria) this;
        }

        public Criteria andPerTimeEqualTo(Date value) {
            addCriterion("per_time =", value, "perTime");
            return (Criteria) this;
        }

        public Criteria andPerTimeNotEqualTo(Date value) {
            addCriterion("per_time <>", value, "perTime");
            return (Criteria) this;
        }

        public Criteria andPerTimeGreaterThan(Date value) {
            addCriterion("per_time >", value, "perTime");
            return (Criteria) this;
        }

        public Criteria andPerTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("per_time >=", value, "perTime");
            return (Criteria) this;
        }

        public Criteria andPerTimeLessThan(Date value) {
            addCriterion("per_time <", value, "perTime");
            return (Criteria) this;
        }

        public Criteria andPerTimeLessThanOrEqualTo(Date value) {
            addCriterion("per_time <=", value, "perTime");
            return (Criteria) this;
        }

        public Criteria andPerTimeIn(List<Date> values) {
            addCriterion("per_time in", values, "perTime");
            return (Criteria) this;
        }

        public Criteria andPerTimeNotIn(List<Date> values) {
            addCriterion("per_time not in", values, "perTime");
            return (Criteria) this;
        }

        public Criteria andPerTimeBetween(Date value1, Date value2) {
            addCriterion("per_time between", value1, value2, "perTime");
            return (Criteria) this;
        }

        public Criteria andPerTimeNotBetween(Date value1, Date value2) {
            addCriterion("per_time not between", value1, value2, "perTime");
            return (Criteria) this;
        }

        public Criteria andGradSchoolIsNull() {
            addCriterion("grad_school is null");
            return (Criteria) this;
        }

        public Criteria andGradSchoolIsNotNull() {
            addCriterion("grad_school is not null");
            return (Criteria) this;
        }

        public Criteria andGradSchoolEqualTo(String value) {
            addCriterion("grad_school =", value, "gradSchool");
            return (Criteria) this;
        }

        public Criteria andGradSchoolNotEqualTo(String value) {
            addCriterion("grad_school <>", value, "gradSchool");
            return (Criteria) this;
        }

        public Criteria andGradSchoolGreaterThan(String value) {
            addCriterion("grad_school >", value, "gradSchool");
            return (Criteria) this;
        }

        public Criteria andGradSchoolGreaterThanOrEqualTo(String value) {
            addCriterion("grad_school >=", value, "gradSchool");
            return (Criteria) this;
        }

        public Criteria andGradSchoolLessThan(String value) {
            addCriterion("grad_school <", value, "gradSchool");
            return (Criteria) this;
        }

        public Criteria andGradSchoolLessThanOrEqualTo(String value) {
            addCriterion("grad_school <=", value, "gradSchool");
            return (Criteria) this;
        }

        public Criteria andGradSchoolLike(String value) {
            addCriterion("grad_school like", value, "gradSchool");
            return (Criteria) this;
        }

        public Criteria andGradSchoolNotLike(String value) {
            addCriterion("grad_school not like", value, "gradSchool");
            return (Criteria) this;
        }

        public Criteria andGradSchoolIn(List<String> values) {
            addCriterion("grad_school in", values, "gradSchool");
            return (Criteria) this;
        }

        public Criteria andGradSchoolNotIn(List<String> values) {
            addCriterion("grad_school not in", values, "gradSchool");
            return (Criteria) this;
        }

        public Criteria andGradSchoolBetween(String value1, String value2) {
            addCriterion("grad_school between", value1, value2, "gradSchool");
            return (Criteria) this;
        }

        public Criteria andGradSchoolNotBetween(String value1, String value2) {
            addCriterion("grad_school not between", value1, value2, "gradSchool");
            return (Criteria) this;
        }

        public Criteria andDailyLinkIsNull() {
            addCriterion("daily_link is null");
            return (Criteria) this;
        }

        public Criteria andDailyLinkIsNotNull() {
            addCriterion("daily_link is not null");
            return (Criteria) this;
        }

        public Criteria andDailyLinkEqualTo(String value) {
            addCriterion("daily_link =", value, "dailyLink");
            return (Criteria) this;
        }

        public Criteria andDailyLinkNotEqualTo(String value) {
            addCriterion("daily_link <>", value, "dailyLink");
            return (Criteria) this;
        }

        public Criteria andDailyLinkGreaterThan(String value) {
            addCriterion("daily_link >", value, "dailyLink");
            return (Criteria) this;
        }

        public Criteria andDailyLinkGreaterThanOrEqualTo(String value) {
            addCriterion("daily_link >=", value, "dailyLink");
            return (Criteria) this;
        }

        public Criteria andDailyLinkLessThan(String value) {
            addCriterion("daily_link <", value, "dailyLink");
            return (Criteria) this;
        }

        public Criteria andDailyLinkLessThanOrEqualTo(String value) {
            addCriterion("daily_link <=", value, "dailyLink");
            return (Criteria) this;
        }

        public Criteria andDailyLinkLike(String value) {
            addCriterion("daily_link like", value, "dailyLink");
            return (Criteria) this;
        }

        public Criteria andDailyLinkNotLike(String value) {
            addCriterion("daily_link not like", value, "dailyLink");
            return (Criteria) this;
        }

        public Criteria andDailyLinkIn(List<String> values) {
            addCriterion("daily_link in", values, "dailyLink");
            return (Criteria) this;
        }

        public Criteria andDailyLinkNotIn(List<String> values) {
            addCriterion("daily_link not in", values, "dailyLink");
            return (Criteria) this;
        }

        public Criteria andDailyLinkBetween(String value1, String value2) {
            addCriterion("daily_link between", value1, value2, "dailyLink");
            return (Criteria) this;
        }

        public Criteria andDailyLinkNotBetween(String value1, String value2) {
            addCriterion("daily_link not between", value1, value2, "dailyLink");
            return (Criteria) this;
        }

        public Criteria andStatementIsNull() {
            addCriterion("statement is null");
            return (Criteria) this;
        }

        public Criteria andStatementIsNotNull() {
            addCriterion("statement is not null");
            return (Criteria) this;
        }

        public Criteria andStatementEqualTo(String value) {
            addCriterion("statement =", value, "statement");
            return (Criteria) this;
        }

        public Criteria andStatementNotEqualTo(String value) {
            addCriterion("statement <>", value, "statement");
            return (Criteria) this;
        }

        public Criteria andStatementGreaterThan(String value) {
            addCriterion("statement >", value, "statement");
            return (Criteria) this;
        }

        public Criteria andStatementGreaterThanOrEqualTo(String value) {
            addCriterion("statement >=", value, "statement");
            return (Criteria) this;
        }

        public Criteria andStatementLessThan(String value) {
            addCriterion("statement <", value, "statement");
            return (Criteria) this;
        }

        public Criteria andStatementLessThanOrEqualTo(String value) {
            addCriterion("statement <=", value, "statement");
            return (Criteria) this;
        }

        public Criteria andStatementLike(String value) {
            addCriterion("statement like", value, "statement");
            return (Criteria) this;
        }

        public Criteria andStatementNotLike(String value) {
            addCriterion("statement not like", value, "statement");
            return (Criteria) this;
        }

        public Criteria andStatementIn(List<String> values) {
            addCriterion("statement in", values, "statement");
            return (Criteria) this;
        }

        public Criteria andStatementNotIn(List<String> values) {
            addCriterion("statement not in", values, "statement");
            return (Criteria) this;
        }

        public Criteria andStatementBetween(String value1, String value2) {
            addCriterion("statement between", value1, value2, "statement");
            return (Criteria) this;
        }

        public Criteria andStatementNotBetween(String value1, String value2) {
            addCriterion("statement not between", value1, value2, "statement");
            return (Criteria) this;
        }

        public Criteria andPresenterIsNull() {
            addCriterion("presenter is null");
            return (Criteria) this;
        }

        public Criteria andPresenterIsNotNull() {
            addCriterion("presenter is not null");
            return (Criteria) this;
        }

        public Criteria andPresenterEqualTo(String value) {
            addCriterion("presenter =", value, "presenter");
            return (Criteria) this;
        }

        public Criteria andPresenterNotEqualTo(String value) {
            addCriterion("presenter <>", value, "presenter");
            return (Criteria) this;
        }

        public Criteria andPresenterGreaterThan(String value) {
            addCriterion("presenter >", value, "presenter");
            return (Criteria) this;
        }

        public Criteria andPresenterGreaterThanOrEqualTo(String value) {
            addCriterion("presenter >=", value, "presenter");
            return (Criteria) this;
        }

        public Criteria andPresenterLessThan(String value) {
            addCriterion("presenter <", value, "presenter");
            return (Criteria) this;
        }

        public Criteria andPresenterLessThanOrEqualTo(String value) {
            addCriterion("presenter <=", value, "presenter");
            return (Criteria) this;
        }

        public Criteria andPresenterLike(String value) {
            addCriterion("presenter like", value, "presenter");
            return (Criteria) this;
        }

        public Criteria andPresenterNotLike(String value) {
            addCriterion("presenter not like", value, "presenter");
            return (Criteria) this;
        }

        public Criteria andPresenterIn(List<String> values) {
            addCriterion("presenter in", values, "presenter");
            return (Criteria) this;
        }

        public Criteria andPresenterNotIn(List<String> values) {
            addCriterion("presenter not in", values, "presenter");
            return (Criteria) this;
        }

        public Criteria andPresenterBetween(String value1, String value2) {
            addCriterion("presenter between", value1, value2, "presenter");
            return (Criteria) this;
        }

        public Criteria andPresenterNotBetween(String value1, String value2) {
            addCriterion("presenter not between", value1, value2, "presenter");
            return (Criteria) this;
        }

        public Criteria andLearnFromIsNull() {
            addCriterion("learn_from is null");
            return (Criteria) this;
        }

        public Criteria andLearnFromIsNotNull() {
            addCriterion("learn_from is not null");
            return (Criteria) this;
        }

        public Criteria andLearnFromEqualTo(String value) {
            addCriterion("learn_from =", value, "learnFrom");
            return (Criteria) this;
        }

        public Criteria andLearnFromNotEqualTo(String value) {
            addCriterion("learn_from <>", value, "learnFrom");
            return (Criteria) this;
        }

        public Criteria andLearnFromGreaterThan(String value) {
            addCriterion("learn_from >", value, "learnFrom");
            return (Criteria) this;
        }

        public Criteria andLearnFromGreaterThanOrEqualTo(String value) {
            addCriterion("learn_from >=", value, "learnFrom");
            return (Criteria) this;
        }

        public Criteria andLearnFromLessThan(String value) {
            addCriterion("learn_from <", value, "learnFrom");
            return (Criteria) this;
        }

        public Criteria andLearnFromLessThanOrEqualTo(String value) {
            addCriterion("learn_from <=", value, "learnFrom");
            return (Criteria) this;
        }

        public Criteria andLearnFromLike(String value) {
            addCriterion("learn_from like", value, "learnFrom");
            return (Criteria) this;
        }

        public Criteria andLearnFromNotLike(String value) {
            addCriterion("learn_from not like", value, "learnFrom");
            return (Criteria) this;
        }

        public Criteria andLearnFromIn(List<String> values) {
            addCriterion("learn_from in", values, "learnFrom");
            return (Criteria) this;
        }

        public Criteria andLearnFromNotIn(List<String> values) {
            addCriterion("learn_from not in", values, "learnFrom");
            return (Criteria) this;
        }

        public Criteria andLearnFromBetween(String value1, String value2) {
            addCriterion("learn_from between", value1, value2, "learnFrom");
            return (Criteria) this;
        }

        public Criteria andLearnFromNotBetween(String value1, String value2) {
            addCriterion("learn_from not between", value1, value2, "learnFrom");
            return (Criteria) this;
        }

        public Criteria andCreateAtIsNull() {
            addCriterion("create_at is null");
            return (Criteria) this;
        }

        public Criteria andCreateAtIsNotNull() {
            addCriterion("create_at is not null");
            return (Criteria) this;
        }

        public Criteria andCreateAtEqualTo(Long value) {
            addCriterion("create_at =", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtNotEqualTo(Long value) {
            addCriterion("create_at <>", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtGreaterThan(Long value) {
            addCriterion("create_at >", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtGreaterThanOrEqualTo(Long value) {
            addCriterion("create_at >=", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtLessThan(Long value) {
            addCriterion("create_at <", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtLessThanOrEqualTo(Long value) {
            addCriterion("create_at <=", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtIn(List<Long> values) {
            addCriterion("create_at in", values, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtNotIn(List<Long> values) {
            addCriterion("create_at not in", values, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtBetween(Long value1, Long value2) {
            addCriterion("create_at between", value1, value2, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtNotBetween(Long value1, Long value2) {
            addCriterion("create_at not between", value1, value2, "createAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtIsNull() {
            addCriterion("update_at is null");
            return (Criteria) this;
        }

        public Criteria andUpdateAtIsNotNull() {
            addCriterion("update_at is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateAtEqualTo(Long value) {
            addCriterion("update_at =", value, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtNotEqualTo(Long value) {
            addCriterion("update_at <>", value, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtGreaterThan(Long value) {
            addCriterion("update_at >", value, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtGreaterThanOrEqualTo(Long value) {
            addCriterion("update_at >=", value, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtLessThan(Long value) {
            addCriterion("update_at <", value, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtLessThanOrEqualTo(Long value) {
            addCriterion("update_at <=", value, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtIn(List<Long> values) {
            addCriterion("update_at in", values, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtNotIn(List<Long> values) {
            addCriterion("update_at not in", values, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtBetween(Long value1, Long value2) {
            addCriterion("update_at between", value1, value2, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtNotBetween(Long value1, Long value2) {
            addCriterion("update_at not between", value1, value2, "updateAt");
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