package com.dse.reservoir.api.zlgl.wdzl.upOrDownload.pojo;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Xll on 2017/6/29.
 *  问题清单实体
 * @Company 深圳市东深电子股份有限公司
 */
@Entity
@Table(name = "DSE_QUESTION")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class QuestionModel implements java.io.Serializable  {
    private static final long serialVersionUID = 1L;

    private String Q_CODE;  //问题编号
    private String Q_TYPE;  //问题类型(1-安全鉴定，2-安全评估，3-巡视检查)
    private String Q_DEPT;  //责任部门
    private String Q_QUESTION;  //存在问题
    private String Q_ADDVICE;  //处理建议
    private String Q_DEAL;  //处理措施
    private Date Q_FINISH;  //计划完成时间
    private String Q_PEOPLE;  //责任人
    private String Q_MARCH;  //进展情况
    private Date Q_TIME;  //完成时间
    private String Q_CONFIRM;  //完成确认人

    @Id
    @Column(name = "Q_CODE" ,  length = 32  )
    @GenericGenerator(name="uuid_s",strategy="uuid")
    @GeneratedValue(generator="uuid_s")
    public String getQ_CODE() {
        return Q_CODE;
    }

    public void setQ_CODE(String q_CODE) {
        Q_CODE = q_CODE;
    }

    @Column(name = "Q_TYPE" ,  length = 1   )
    @Length(min=0, max=1, message="问题类型长度只能为1")
    public String getQ_TYPE() {
        return Q_TYPE;
    }

    public void setQ_TYPE(String q_TYPE) {
        Q_TYPE = q_TYPE;
    }

    @Column(name = "Q_DEPT" ,  length = 30   )
    @Length(min=0, max=30, message="责任部门必须介于 0 和 30 之间")
    public String getQ_DEPT() {
        return Q_DEPT;
    }

    public void setQ_DEPT(String q_DEPT) {
        Q_DEPT = q_DEPT;
    }

    @Column(name = "Q_QUESTION" ,  length = 200   )
    @Length(min=0, max=200, message="存在问题必须介于 0 和 200 之间")
    public String getQ_QUESTION() {
        return Q_QUESTION;
    }

    public void setQ_QUESTION(String q_QUESTION) {
        Q_QUESTION = q_QUESTION;
    }

    @Column(name = "Q_ADDVICE" ,  length = 200   )
    @Length(min=0, max=200, message="处理建议必须介于 0 和 200 之间")
    public String getQ_ADDVICE() {
        return Q_ADDVICE;
    }

    public void setQ_ADDVICE(String q_ADDVICE) {
        Q_ADDVICE = q_ADDVICE;
    }

    @Column(name = "Q_DEAL" ,  length = 200   )
    @Length(min=0, max=200, message="处理措施必须介于 0 和 200 之间")
    public String getQ_DEAL() {
        return Q_DEAL;
    }

    public void setQ_DEAL(String q_DEAL) {
        Q_DEAL = q_DEAL;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "Q_FINISH" ,  length = 23   )
    public Date getQ_FINISH() {
        return Q_FINISH;
    }

    public void setQ_FINISH(Date q_FINISH) {
        Q_FINISH = q_FINISH;
    }

    @Column(name = "Q_PEOPLE" ,  length = 20   )
    @Length(min=0, max=20, message="责任人必须介于 0 和 20 之间")
    public String getQ_PEOPLE() {
        return Q_PEOPLE;
    }

    public void setQ_PEOPLE(String q_PEOPLE) {
        Q_PEOPLE = q_PEOPLE;
    }

    @Column(name = "Q_MARCH" ,  length = 200   )
    @Length(min=0, max=200, message="进展情况必须介于 0 和 200 之间")
    public String getQ_MARCH() {
        return Q_MARCH;
    }

    public void setQ_MARCH(String q_MARCH) {
        Q_MARCH = q_MARCH;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "Q_TIME" ,  length = 23   )
    public Date getQ_TIME() {
        return Q_TIME;
    }

    public void setQ_TIME(Date q_TIME) {
        Q_TIME = q_TIME;
    }

    @Column(name = "Q_CONFIRM" ,  length = 20   )
    @Length(min=0, max=20, message="完成确认人必须介于 0 和 20 之间")
    public String getQ_CONFIRM() {
        return Q_CONFIRM;
    }

    public void setQ_CONFIRM(String q_CONFIRM) {
        Q_CONFIRM = q_CONFIRM;
    }
}
