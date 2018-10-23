package com.jnshuboot.pojo;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

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

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
        return offset;
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

        public Criteria andQqIsNull() {
            addCriterion("qq is null");
            return (Criteria) this;
        }

        public Criteria andQqIsNotNull() {
            addCriterion("qq is not null");
            return (Criteria) this;
        }

        public Criteria andQqEqualTo(Integer value) {
            addCriterion("qq =", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotEqualTo(Integer value) {
            addCriterion("qq <>", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqGreaterThan(Integer value) {
            addCriterion("qq >", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqGreaterThanOrEqualTo(Integer value) {
            addCriterion("qq >=", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLessThan(Integer value) {
            addCriterion("qq <", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLessThanOrEqualTo(Integer value) {
            addCriterion("qq <=", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqIn(List<Integer> values) {
            addCriterion("qq in", values, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotIn(List<Integer> values) {
            addCriterion("qq not in", values, "qq");
            return (Criteria) this;
        }

        public Criteria andQqBetween(Integer value1, Integer value2) {
            addCriterion("qq between", value1, value2, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotBetween(Integer value1, Integer value2) {
            addCriterion("qq not between", value1, value2, "qq");
            return (Criteria) this;
        }

        public Criteria andStudyTypeIsNull() {
            addCriterion("study_type is null");
            return (Criteria) this;
        }

        public Criteria andStudyTypeIsNotNull() {
            addCriterion("study_type is not null");
            return (Criteria) this;
        }

        public Criteria andStudyTypeEqualTo(String value) {
            addCriterion("study_type =", value, "studyType");
            return (Criteria) this;
        }

        public Criteria andStudyTypeNotEqualTo(String value) {
            addCriterion("study_type <>", value, "studyType");
            return (Criteria) this;
        }

        public Criteria andStudyTypeGreaterThan(String value) {
            addCriterion("study_type >", value, "studyType");
            return (Criteria) this;
        }

        public Criteria andStudyTypeGreaterThanOrEqualTo(String value) {
            addCriterion("study_type >=", value, "studyType");
            return (Criteria) this;
        }

        public Criteria andStudyTypeLessThan(String value) {
            addCriterion("study_type <", value, "studyType");
            return (Criteria) this;
        }

        public Criteria andStudyTypeLessThanOrEqualTo(String value) {
            addCriterion("study_type <=", value, "studyType");
            return (Criteria) this;
        }

        public Criteria andStudyTypeLike(String value) {
            addCriterion("study_type like", value, "studyType");
            return (Criteria) this;
        }

        public Criteria andStudyTypeNotLike(String value) {
            addCriterion("study_type not like", value, "studyType");
            return (Criteria) this;
        }

        public Criteria andStudyTypeIn(List<String> values) {
            addCriterion("study_type in", values, "studyType");
            return (Criteria) this;
        }

        public Criteria andStudyTypeNotIn(List<String> values) {
            addCriterion("study_type not in", values, "studyType");
            return (Criteria) this;
        }

        public Criteria andStudyTypeBetween(String value1, String value2) {
            addCriterion("study_type between", value1, value2, "studyType");
            return (Criteria) this;
        }

        public Criteria andStudyTypeNotBetween(String value1, String value2) {
            addCriterion("study_type not between", value1, value2, "studyType");
            return (Criteria) this;
        }

        public Criteria andJoinTimeIsNull() {
            addCriterion("join_time is null");
            return (Criteria) this;
        }

        public Criteria andJoinTimeIsNotNull() {
            addCriterion("join_time is not null");
            return (Criteria) this;
        }

        public Criteria andJoinTimeEqualTo(Long value) {
            addCriterion("join_time =", value, "joinTime");
            return (Criteria) this;
        }

        public Criteria andJoinTimeNotEqualTo(Long value) {
            addCriterion("join_time <>", value, "joinTime");
            return (Criteria) this;
        }

        public Criteria andJoinTimeGreaterThan(Long value) {
            addCriterion("join_time >", value, "joinTime");
            return (Criteria) this;
        }

        public Criteria andJoinTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("join_time >=", value, "joinTime");
            return (Criteria) this;
        }

        public Criteria andJoinTimeLessThan(Long value) {
            addCriterion("join_time <", value, "joinTime");
            return (Criteria) this;
        }

        public Criteria andJoinTimeLessThanOrEqualTo(Long value) {
            addCriterion("join_time <=", value, "joinTime");
            return (Criteria) this;
        }

        public Criteria andJoinTimeIn(List<Long> values) {
            addCriterion("join_time in", values, "joinTime");
            return (Criteria) this;
        }

        public Criteria andJoinTimeNotIn(List<Long> values) {
            addCriterion("join_time not in", values, "joinTime");
            return (Criteria) this;
        }

        public Criteria andJoinTimeBetween(Long value1, Long value2) {
            addCriterion("join_time between", value1, value2, "joinTime");
            return (Criteria) this;
        }

        public Criteria andJoinTimeNotBetween(Long value1, Long value2) {
            addCriterion("join_time not between", value1, value2, "joinTime");
            return (Criteria) this;
        }

        public Criteria andUniversityIsNull() {
            addCriterion("university is null");
            return (Criteria) this;
        }

        public Criteria andUniversityIsNotNull() {
            addCriterion("university is not null");
            return (Criteria) this;
        }

        public Criteria andUniversityEqualTo(String value) {
            addCriterion("university =", value, "university");
            return (Criteria) this;
        }

        public Criteria andUniversityNotEqualTo(String value) {
            addCriterion("university <>", value, "university");
            return (Criteria) this;
        }

        public Criteria andUniversityGreaterThan(String value) {
            addCriterion("university >", value, "university");
            return (Criteria) this;
        }

        public Criteria andUniversityGreaterThanOrEqualTo(String value) {
            addCriterion("university >=", value, "university");
            return (Criteria) this;
        }

        public Criteria andUniversityLessThan(String value) {
            addCriterion("university <", value, "university");
            return (Criteria) this;
        }

        public Criteria andUniversityLessThanOrEqualTo(String value) {
            addCriterion("university <=", value, "university");
            return (Criteria) this;
        }

        public Criteria andUniversityLike(String value) {
            addCriterion("university like", value, "university");
            return (Criteria) this;
        }

        public Criteria andUniversityNotLike(String value) {
            addCriterion("university not like", value, "university");
            return (Criteria) this;
        }

        public Criteria andUniversityIn(List<String> values) {
            addCriterion("university in", values, "university");
            return (Criteria) this;
        }

        public Criteria andUniversityNotIn(List<String> values) {
            addCriterion("university not in", values, "university");
            return (Criteria) this;
        }

        public Criteria andUniversityBetween(String value1, String value2) {
            addCriterion("university between", value1, value2, "university");
            return (Criteria) this;
        }

        public Criteria andUniversityNotBetween(String value1, String value2) {
            addCriterion("university not between", value1, value2, "university");
            return (Criteria) this;
        }

        public Criteria andStudyIdIsNull() {
            addCriterion("study_id is null");
            return (Criteria) this;
        }

        public Criteria andStudyIdIsNotNull() {
            addCriterion("study_id is not null");
            return (Criteria) this;
        }

        public Criteria andStudyIdEqualTo(String value) {
            addCriterion("study_id =", value, "studyId");
            return (Criteria) this;
        }

        public Criteria andStudyIdNotEqualTo(String value) {
            addCriterion("study_id <>", value, "studyId");
            return (Criteria) this;
        }

        public Criteria andStudyIdGreaterThan(String value) {
            addCriterion("study_id >", value, "studyId");
            return (Criteria) this;
        }

        public Criteria andStudyIdGreaterThanOrEqualTo(String value) {
            addCriterion("study_id >=", value, "studyId");
            return (Criteria) this;
        }

        public Criteria andStudyIdLessThan(String value) {
            addCriterion("study_id <", value, "studyId");
            return (Criteria) this;
        }

        public Criteria andStudyIdLessThanOrEqualTo(String value) {
            addCriterion("study_id <=", value, "studyId");
            return (Criteria) this;
        }

        public Criteria andStudyIdLike(String value) {
            addCriterion("study_id like", value, "studyId");
            return (Criteria) this;
        }

        public Criteria andStudyIdNotLike(String value) {
            addCriterion("study_id not like", value, "studyId");
            return (Criteria) this;
        }

        public Criteria andStudyIdIn(List<String> values) {
            addCriterion("study_id in", values, "studyId");
            return (Criteria) this;
        }

        public Criteria andStudyIdNotIn(List<String> values) {
            addCriterion("study_id not in", values, "studyId");
            return (Criteria) this;
        }

        public Criteria andStudyIdBetween(String value1, String value2) {
            addCriterion("study_id between", value1, value2, "studyId");
            return (Criteria) this;
        }

        public Criteria andStudyIdNotBetween(String value1, String value2) {
            addCriterion("study_id not between", value1, value2, "studyId");
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

        public Criteria andSlogenIsNull() {
            addCriterion("slogen is null");
            return (Criteria) this;
        }

        public Criteria andSlogenIsNotNull() {
            addCriterion("slogen is not null");
            return (Criteria) this;
        }

        public Criteria andSlogenEqualTo(String value) {
            addCriterion("slogen =", value, "slogen");
            return (Criteria) this;
        }

        public Criteria andSlogenNotEqualTo(String value) {
            addCriterion("slogen <>", value, "slogen");
            return (Criteria) this;
        }

        public Criteria andSlogenGreaterThan(String value) {
            addCriterion("slogen >", value, "slogen");
            return (Criteria) this;
        }

        public Criteria andSlogenGreaterThanOrEqualTo(String value) {
            addCriterion("slogen >=", value, "slogen");
            return (Criteria) this;
        }

        public Criteria andSlogenLessThan(String value) {
            addCriterion("slogen <", value, "slogen");
            return (Criteria) this;
        }

        public Criteria andSlogenLessThanOrEqualTo(String value) {
            addCriterion("slogen <=", value, "slogen");
            return (Criteria) this;
        }

        public Criteria andSlogenLike(String value) {
            addCriterion("slogen like", value, "slogen");
            return (Criteria) this;
        }

        public Criteria andSlogenNotLike(String value) {
            addCriterion("slogen not like", value, "slogen");
            return (Criteria) this;
        }

        public Criteria andSlogenIn(List<String> values) {
            addCriterion("slogen in", values, "slogen");
            return (Criteria) this;
        }

        public Criteria andSlogenNotIn(List<String> values) {
            addCriterion("slogen not in", values, "slogen");
            return (Criteria) this;
        }

        public Criteria andSlogenBetween(String value1, String value2) {
            addCriterion("slogen between", value1, value2, "slogen");
            return (Criteria) this;
        }

        public Criteria andSlogenNotBetween(String value1, String value2) {
            addCriterion("slogen not between", value1, value2, "slogen");
            return (Criteria) this;
        }

        public Criteria andMasterIsNull() {
            addCriterion("master is null");
            return (Criteria) this;
        }

        public Criteria andMasterIsNotNull() {
            addCriterion("master is not null");
            return (Criteria) this;
        }

        public Criteria andMasterEqualTo(String value) {
            addCriterion("master =", value, "master");
            return (Criteria) this;
        }

        public Criteria andMasterNotEqualTo(String value) {
            addCriterion("master <>", value, "master");
            return (Criteria) this;
        }

        public Criteria andMasterGreaterThan(String value) {
            addCriterion("master >", value, "master");
            return (Criteria) this;
        }

        public Criteria andMasterGreaterThanOrEqualTo(String value) {
            addCriterion("master >=", value, "master");
            return (Criteria) this;
        }

        public Criteria andMasterLessThan(String value) {
            addCriterion("master <", value, "master");
            return (Criteria) this;
        }

        public Criteria andMasterLessThanOrEqualTo(String value) {
            addCriterion("master <=", value, "master");
            return (Criteria) this;
        }

        public Criteria andMasterLike(String value) {
            addCriterion("master like", value, "master");
            return (Criteria) this;
        }

        public Criteria andMasterNotLike(String value) {
            addCriterion("master not like", value, "master");
            return (Criteria) this;
        }

        public Criteria andMasterIn(List<String> values) {
            addCriterion("master in", values, "master");
            return (Criteria) this;
        }

        public Criteria andMasterNotIn(List<String> values) {
            addCriterion("master not in", values, "master");
            return (Criteria) this;
        }

        public Criteria andMasterBetween(String value1, String value2) {
            addCriterion("master between", value1, value2, "master");
            return (Criteria) this;
        }

        public Criteria andMasterNotBetween(String value1, String value2) {
            addCriterion("master not between", value1, value2, "master");
            return (Criteria) this;
        }
    }

    /**
     */
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