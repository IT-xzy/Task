package com.jnshutask.pojo.example;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class TaLoginExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public TaLoginExample() {
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

        public Criteria andLoginIdIsNull() {
            addCriterion("login_id is null");
            return (Criteria) this;
        }

        public Criteria andLoginIdIsNotNull() {
            addCriterion("login_id is not null");
            return (Criteria) this;
        }

        public Criteria andLoginIdEqualTo(Long value) {
            addCriterion("login_id =", value, "loginId");
            return (Criteria) this;
        }

        public Criteria andLoginIdNotEqualTo(Long value) {
            addCriterion("login_id <>", value, "loginId");
            return (Criteria) this;
        }

        public Criteria andLoginIdGreaterThan(Long value) {
            addCriterion("login_id >", value, "loginId");
            return (Criteria) this;
        }

        public Criteria andLoginIdGreaterThanOrEqualTo(Long value) {
            addCriterion("login_id >=", value, "loginId");
            return (Criteria) this;
        }

        public Criteria andLoginIdLessThan(Long value) {
            addCriterion("login_id <", value, "loginId");
            return (Criteria) this;
        }

        public Criteria andLoginIdLessThanOrEqualTo(Long value) {
            addCriterion("login_id <=", value, "loginId");
            return (Criteria) this;
        }

        public Criteria andLoginIdIn(List<Long> values) {
            addCriterion("login_id in", values, "loginId");
            return (Criteria) this;
        }

        public Criteria andLoginIdNotIn(List<Long> values) {
            addCriterion("login_id not in", values, "loginId");
            return (Criteria) this;
        }

        public Criteria andLoginIdBetween(Long value1, Long value2) {
            addCriterion("login_id between", value1, value2, "loginId");
            return (Criteria) this;
        }

        public Criteria andLoginIdNotBetween(Long value1, Long value2) {
            addCriterion("login_id not between", value1, value2, "loginId");
            return (Criteria) this;
        }

        public Criteria andLoginAccountIsNull() {
            addCriterion("login_account is null");
            return (Criteria) this;
        }

        public Criteria andLoginAccountIsNotNull() {
            addCriterion("login_account is not null");
            return (Criteria) this;
        }

        public Criteria andLoginAccountEqualTo(String value) {
            addCriterion("login_account =", value, "loginAccount");
            return (Criteria) this;
        }

        public Criteria andLoginAccountNotEqualTo(String value) {
            addCriterion("login_account <>", value, "loginAccount");
            return (Criteria) this;
        }

        public Criteria andLoginAccountGreaterThan(String value) {
            addCriterion("login_account >", value, "loginAccount");
            return (Criteria) this;
        }

        public Criteria andLoginAccountGreaterThanOrEqualTo(String value) {
            addCriterion("login_account >=", value, "loginAccount");
            return (Criteria) this;
        }

        public Criteria andLoginAccountLessThan(String value) {
            addCriterion("login_account <", value, "loginAccount");
            return (Criteria) this;
        }

        public Criteria andLoginAccountLessThanOrEqualTo(String value) {
            addCriterion("login_account <=", value, "loginAccount");
            return (Criteria) this;
        }

        public Criteria andLoginAccountLike(String value) {
            addCriterion("login_account like", value, "loginAccount");
            return (Criteria) this;
        }

        public Criteria andLoginAccountNotLike(String value) {
            addCriterion("login_account not like", value, "loginAccount");
            return (Criteria) this;
        }

        public Criteria andLoginAccountIn(List<String> values) {
            addCriterion("login_account in", values, "loginAccount");
            return (Criteria) this;
        }

        public Criteria andLoginAccountNotIn(List<String> values) {
            addCriterion("login_account not in", values, "loginAccount");
            return (Criteria) this;
        }

        public Criteria andLoginAccountBetween(String value1, String value2) {
            addCriterion("login_account between", value1, value2, "loginAccount");
            return (Criteria) this;
        }

        public Criteria andLoginAccountNotBetween(String value1, String value2) {
            addCriterion("login_account not between", value1, value2, "loginAccount");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordIsNull() {
            addCriterion("login_password is null");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordIsNotNull() {
            addCriterion("login_password is not null");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordEqualTo(String value) {
            addCriterion("login_password =", value, "loginPassword");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordNotEqualTo(String value) {
            addCriterion("login_password <>", value, "loginPassword");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordGreaterThan(String value) {
            addCriterion("login_password >", value, "loginPassword");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("login_password >=", value, "loginPassword");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordLessThan(String value) {
            addCriterion("login_password <", value, "loginPassword");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordLessThanOrEqualTo(String value) {
            addCriterion("login_password <=", value, "loginPassword");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordLike(String value) {
            addCriterion("login_password like", value, "loginPassword");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordNotLike(String value) {
            addCriterion("login_password not like", value, "loginPassword");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordIn(List<String> values) {
            addCriterion("login_password in", values, "loginPassword");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordNotIn(List<String> values) {
            addCriterion("login_password not in", values, "loginPassword");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordBetween(String value1, String value2) {
            addCriterion("login_password between", value1, value2, "loginPassword");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordNotBetween(String value1, String value2) {
            addCriterion("login_password not between", value1, value2, "loginPassword");
            return (Criteria) this;
        }

        public Criteria andLoginNameIsNull() {
            addCriterion("login_name is null");
            return (Criteria) this;
        }

        public Criteria andLoginNameIsNotNull() {
            addCriterion("login_name is not null");
            return (Criteria) this;
        }

        public Criteria andLoginNameEqualTo(String value) {
            addCriterion("login_name =", value, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameNotEqualTo(String value) {
            addCriterion("login_name <>", value, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameGreaterThan(String value) {
            addCriterion("login_name >", value, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameGreaterThanOrEqualTo(String value) {
            addCriterion("login_name >=", value, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameLessThan(String value) {
            addCriterion("login_name <", value, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameLessThanOrEqualTo(String value) {
            addCriterion("login_name <=", value, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameLike(String value) {
            addCriterion("login_name like", value, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameNotLike(String value) {
            addCriterion("login_name not like", value, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameIn(List<String> values) {
            addCriterion("login_name in", values, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameNotIn(List<String> values) {
            addCriterion("login_name not in", values, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameBetween(String value1, String value2) {
            addCriterion("login_name between", value1, value2, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameNotBetween(String value1, String value2) {
            addCriterion("login_name not between", value1, value2, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginPictureIsNull() {
            addCriterion("login_picture is null");
            return (Criteria) this;
        }

        public Criteria andLoginPictureIsNotNull() {
            addCriterion("login_picture is not null");
            return (Criteria) this;
        }

        public Criteria andLoginPictureEqualTo(String value) {
            addCriterion("login_picture =", value, "loginPicture");
            return (Criteria) this;
        }

        public Criteria andLoginPictureNotEqualTo(String value) {
            addCriterion("login_picture <>", value, "loginPicture");
            return (Criteria) this;
        }

        public Criteria andLoginPictureGreaterThan(String value) {
            addCriterion("login_picture >", value, "loginPicture");
            return (Criteria) this;
        }

        public Criteria andLoginPictureGreaterThanOrEqualTo(String value) {
            addCriterion("login_picture >=", value, "loginPicture");
            return (Criteria) this;
        }

        public Criteria andLoginPictureLessThan(String value) {
            addCriterion("login_picture <", value, "loginPicture");
            return (Criteria) this;
        }

        public Criteria andLoginPictureLessThanOrEqualTo(String value) {
            addCriterion("login_picture <=", value, "loginPicture");
            return (Criteria) this;
        }

        public Criteria andLoginPictureLike(String value) {
            addCriterion("login_picture like", value, "loginPicture");
            return (Criteria) this;
        }

        public Criteria andLoginPictureNotLike(String value) {
            addCriterion("login_picture not like", value, "loginPicture");
            return (Criteria) this;
        }

        public Criteria andLoginPictureIn(List<String> values) {
            addCriterion("login_picture in", values, "loginPicture");
            return (Criteria) this;
        }

        public Criteria andLoginPictureNotIn(List<String> values) {
            addCriterion("login_picture not in", values, "loginPicture");
            return (Criteria) this;
        }

        public Criteria andLoginPictureBetween(String value1, String value2) {
            addCriterion("login_picture between", value1, value2, "loginPicture");
            return (Criteria) this;
        }

        public Criteria andLoginPictureNotBetween(String value1, String value2) {
            addCriterion("login_picture not between", value1, value2, "loginPicture");
            return (Criteria) this;
        }

        public Criteria andLoginSaltIsNull() {
            addCriterion("login_salt is null");
            return (Criteria) this;
        }

        public Criteria andLoginSaltIsNotNull() {
            addCriterion("login_salt is not null");
            return (Criteria) this;
        }

        public Criteria andLoginSaltEqualTo(String value) {
            addCriterion("login_salt =", value, "loginSalt");
            return (Criteria) this;
        }

        public Criteria andLoginSaltNotEqualTo(String value) {
            addCriterion("login_salt <>", value, "loginSalt");
            return (Criteria) this;
        }

        public Criteria andLoginSaltGreaterThan(String value) {
            addCriterion("login_salt >", value, "loginSalt");
            return (Criteria) this;
        }

        public Criteria andLoginSaltGreaterThanOrEqualTo(String value) {
            addCriterion("login_salt >=", value, "loginSalt");
            return (Criteria) this;
        }

        public Criteria andLoginSaltLessThan(String value) {
            addCriterion("login_salt <", value, "loginSalt");
            return (Criteria) this;
        }

        public Criteria andLoginSaltLessThanOrEqualTo(String value) {
            addCriterion("login_salt <=", value, "loginSalt");
            return (Criteria) this;
        }

        public Criteria andLoginSaltLike(String value) {
            addCriterion("login_salt like", value, "loginSalt");
            return (Criteria) this;
        }

        public Criteria andLoginSaltNotLike(String value) {
            addCriterion("login_salt not like", value, "loginSalt");
            return (Criteria) this;
        }

        public Criteria andLoginSaltIn(List<String> values) {
            addCriterion("login_salt in", values, "loginSalt");
            return (Criteria) this;
        }

        public Criteria andLoginSaltNotIn(List<String> values) {
            addCriterion("login_salt not in", values, "loginSalt");
            return (Criteria) this;
        }

        public Criteria andLoginSaltBetween(String value1, String value2) {
            addCriterion("login_salt between", value1, value2, "loginSalt");
            return (Criteria) this;
        }

        public Criteria andLoginSaltNotBetween(String value1, String value2) {
            addCriterion("login_salt not between", value1, value2, "loginSalt");
            return (Criteria) this;
        }

        public Criteria andLoginMobileIsNull() {
            addCriterion("login_mobile is null");
            return (Criteria) this;
        }

        public Criteria andLoginMobileIsNotNull() {
            addCriterion("login_mobile is not null");
            return (Criteria) this;
        }

        public Criteria andLoginMobileEqualTo(String value) {
            addCriterion("login_mobile =", value, "loginMobile");
            return (Criteria) this;
        }

        public Criteria andLoginMobileNotEqualTo(String value) {
            addCriterion("login_mobile <>", value, "loginMobile");
            return (Criteria) this;
        }

        public Criteria andLoginMobileGreaterThan(String value) {
            addCriterion("login_mobile >", value, "loginMobile");
            return (Criteria) this;
        }

        public Criteria andLoginMobileGreaterThanOrEqualTo(String value) {
            addCriterion("login_mobile >=", value, "loginMobile");
            return (Criteria) this;
        }

        public Criteria andLoginMobileLessThan(String value) {
            addCriterion("login_mobile <", value, "loginMobile");
            return (Criteria) this;
        }

        public Criteria andLoginMobileLessThanOrEqualTo(String value) {
            addCriterion("login_mobile <=", value, "loginMobile");
            return (Criteria) this;
        }

        public Criteria andLoginMobileLike(String value) {
            addCriterion("login_mobile like", value, "loginMobile");
            return (Criteria) this;
        }

        public Criteria andLoginMobileNotLike(String value) {
            addCriterion("login_mobile not like", value, "loginMobile");
            return (Criteria) this;
        }

        public Criteria andLoginMobileIn(List<String> values) {
            addCriterion("login_mobile in", values, "loginMobile");
            return (Criteria) this;
        }

        public Criteria andLoginMobileNotIn(List<String> values) {
            addCriterion("login_mobile not in", values, "loginMobile");
            return (Criteria) this;
        }

        public Criteria andLoginMobileBetween(String value1, String value2) {
            addCriterion("login_mobile between", value1, value2, "loginMobile");
            return (Criteria) this;
        }

        public Criteria andLoginMobileNotBetween(String value1, String value2) {
            addCriterion("login_mobile not between", value1, value2, "loginMobile");
            return (Criteria) this;
        }

        public Criteria andLoginMailIsNull() {
            addCriterion("login_mail is null");
            return (Criteria) this;
        }

        public Criteria andLoginMailIsNotNull() {
            addCriterion("login_mail is not null");
            return (Criteria) this;
        }

        public Criteria andLoginMailEqualTo(String value) {
            addCriterion("login_mail =", value, "loginMail");
            return (Criteria) this;
        }

        public Criteria andLoginMailNotEqualTo(String value) {
            addCriterion("login_mail <>", value, "loginMail");
            return (Criteria) this;
        }

        public Criteria andLoginMailGreaterThan(String value) {
            addCriterion("login_mail >", value, "loginMail");
            return (Criteria) this;
        }

        public Criteria andLoginMailGreaterThanOrEqualTo(String value) {
            addCriterion("login_mail >=", value, "loginMail");
            return (Criteria) this;
        }

        public Criteria andLoginMailLessThan(String value) {
            addCriterion("login_mail <", value, "loginMail");
            return (Criteria) this;
        }

        public Criteria andLoginMailLessThanOrEqualTo(String value) {
            addCriterion("login_mail <=", value, "loginMail");
            return (Criteria) this;
        }

        public Criteria andLoginMailLike(String value) {
            addCriterion("login_mail like", value, "loginMail");
            return (Criteria) this;
        }

        public Criteria andLoginMailNotLike(String value) {
            addCriterion("login_mail not like", value, "loginMail");
            return (Criteria) this;
        }

        public Criteria andLoginMailIn(List<String> values) {
            addCriterion("login_mail in", values, "loginMail");
            return (Criteria) this;
        }

        public Criteria andLoginMailNotIn(List<String> values) {
            addCriterion("login_mail not in", values, "loginMail");
            return (Criteria) this;
        }

        public Criteria andLoginMailBetween(String value1, String value2) {
            addCriterion("login_mail between", value1, value2, "loginMail");
            return (Criteria) this;
        }

        public Criteria andLoginMailNotBetween(String value1, String value2) {
            addCriterion("login_mail not between", value1, value2, "loginMail");
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