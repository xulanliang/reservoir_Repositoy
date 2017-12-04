package com.dse.reservoir.api.sgxc.wrchktask.pojo;
import com.dse.common.util.StringUtil;
import com.dse.reservoir.api.util.DateUtil;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;


/**
 * @Description:实体 巡查任务
 * @Copyright:
 * @Company:
 * @author
 * @version 1.0 2017-08-08
 */
@Entity
@Table(name = "WR_CHK_TASK")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class WrchkTaskModel implements java.io.Serializable {

    public WrchkTaskModel() {
        super();
    }

    private static final long serialVersionUID = 1L;
    /**
     *编码
     */
    private String ck_tk_id ;
    /**
     *名称描述
     */
    private String ck_tk_desc;
    /**
     *巡检对象编码
     */
    private String ck_obj_id;
    private String ck_obj_id_name;

    /**
     *制定人
     */
    private String create_user;
    /**
     *制定日期
     */
    private Date create_date;
    /**
     *起始日期
     */
    private Date ck_begin;
    /**
     *结束日期
     */
    private Date ck_end;

    /**
     *管理部门(深圳部,雁田部,桥头部,塘厦部)
     */
    private String ck_org;
    private String ck_org_name;
    /**
     *巡查类型 (日常巡视,日常检查,定期巡检,特别巡检)
     */
    private String ck_type;
    private String ck_type_name;

    /**
     *巡查人员
     */
    private String ck_users;
    /**
     *巡查周期
     */
    private String ck_cycle;
    private String ck_cycle_name;
    /**
     *巡查次数
     */
    private Integer ck_frequency;
    /**
     *间隔小时
     */
    private Integer ck_int_hours;
    /**
     *状态(0:不活动 ;   1:启用状态 ; 2:暂停状态)
     */
    private String status;
    private String status_name;
    /**
     *创建时间
     */
    private Date ts;
    /**
     *备注
     */
    private String nt;
    /**
     *最后一次生成数据时间(后台生成数据时记录最后一次时间)
     */
    private Date last_create_date;
    private String last_create_dateStr;

    private  String ck_object;
    private  String ck_object_name;

    private String taskids;

    @Id
    @Column(name = "CK_TK_ID", nullable = false, precision = 32, scale = 0   )
    @NotNull(message="编码不能为空")
    public String getCk_tk_id() {
        return ck_tk_id;
    }

    public void setCk_tk_id(String ck_tk_id) {
        this.ck_tk_id = ck_tk_id;
    }
    @Column(name = "CK_BEGIN")
    public Date getCk_begin() {
        return ck_begin;
    }

    public void setCk_begin(Date ck_begin) {
        this.ck_begin = ck_begin;
    }
    @Column(name = "CK_CYCLE")
    public String getCk_cycle() {
        return ck_cycle;
    }

    public void setCk_cycle(String ck_cycle) {
        this.ck_cycle = ck_cycle;
    }
    @Column(name = "CK_END")
    public Date getCk_end() {
        return ck_end;
    }

    public void setCk_end(Date ck_end) {
        this.ck_end = ck_end;
    }
    @Column(name = "CK_FREQUENCY")
    public Integer getCk_frequency() {
        return ck_frequency;
    }

    public void setCk_frequency(Integer ck_frequency) {
        this.ck_frequency = ck_frequency;
    }
    @Column(name = "CK_INT_HOURS")
    public Integer getCk_int_hours() {
        return ck_int_hours;
    }

    public void setCk_int_hours(Integer ck_int_hours) {
        this.ck_int_hours = ck_int_hours;
    }
    @Column(name = "CK_OBJ_ID")
    public String getCk_obj_id() {
        return ck_obj_id;
    }

    public void setCk_obj_id(String ck_obj_id) {
        this.ck_obj_id = ck_obj_id;
    }

    @Column(name = "CK_TK_DESC")
    public String getCk_tk_desc() {
        return ck_tk_desc;
    }

    public void setCk_tk_desc(String ck_tk_desc) {
        this.ck_tk_desc = ck_tk_desc;
    }

    @Column(name = "CK_USERS")
    public String getCk_users() {
        return ck_users;
    }

    public void setCk_users(String ck_users) {
        this.ck_users = ck_users;
    }
    @Column(name = "CREATE_DATE")
    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }
    @Column(name = "CREATE_USER")
    public String getCreate_user() {
        return create_user;
    }

    public void setCreate_user(String create_user) {
        this.create_user = create_user;
    }
    @Column(name = "LAST_CREATE_DATE")
    public Date getLast_create_date() {
        return last_create_date;
    }

    public void setLast_create_date(Date last_create_date) {
        this.last_create_date = last_create_date;
    }
    @Column(name = "STATUS")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Column(name = "CK_ORG")
    public String getCk_org() {
        return ck_org;
    }

    public void setCk_org(String ck_org) {
        this.ck_org = ck_org;
    }

    @Column(name = "CK_TYPE")
    public String getCk_type() {
        return ck_type;
    }

    public void setCk_type(String ck_type) {
        this.ck_type = ck_type;
    }


    @Column(name = "NT")
    public String getNt() {
        return nt;
    }

    public void setNt(String nt) {
        this.nt = nt;
    }

    @Column(name = "TS")
    public Date getTs() {
        return ts;
    }

    public void setTs(Date ts) {
        this.ts = ts;
    }

    @Transient
    public String getCk_org_name() {
        return ck_org_name;
    }

    public void setCk_org_name(String ck_org_name) {
        this.ck_org_name = ck_org_name;
    }
    @Transient
    public String getCk_type_name() {
        return ck_type_name;
    }

    public void setCk_type_name(String ck_type_name) {
        this.ck_type_name = ck_type_name;
    }

    @Transient
    public String getCk_obj_id_name() {
        return ck_obj_id_name;
    }

    public void setCk_obj_id_name(String ck_obj_id_name) {
        this.ck_obj_id_name = ck_obj_id_name;
    }
    @Transient
    public String getCk_object() {
        return ck_object;
    }

    public void setCk_object(String ck_object) {
        this.ck_object = ck_object;
    }
    @Transient
    public String getStatus_name() {
        return status_name;
    }

    public void setStatus_name(String status_name) {
        this.status_name = status_name;
    }
    @Transient
    public String getCk_cycle_name() {
        return ck_cycle_name;
    }

    public void setCk_cycle_name(String ck_cycle_name) {
        this.ck_cycle_name = ck_cycle_name;
    }
    @Transient
    public String getLast_create_dateStr() {
        if(!StringUtil.isNotEmpty(last_create_dateStr)){
            if(this.last_create_date!=null){
                last_create_dateStr=DateUtil.dateToStr(this.last_create_date,DateUtil.DATE_MASK);
            }
        }
        return last_create_dateStr;
    }

    public void setLast_create_dateStr(String last_create_dateStr) {
        this.last_create_dateStr = last_create_dateStr;
    }

    //Column(name = "JSRNAME" ,  length = 50   )
    //Length(min=0, max=50, message="入库签收人员长度必须介于 0 和 50 之间")
    //Column(name = "CKID",  nullable = false, precision = 16, scale = 0   )

    @Transient
    public String getTaskids() {
        return taskids;
    }

    public void setTaskids(String taskids) {
        this.taskids = taskids;
    }

    public void calcLastCreateDate(){

        if(WrchkTaskVo.CYCLE_001.equalsIgnoreCase(this.getCk_cycle())){//按年

        }else if(WrchkTaskVo.CYCLE_002.equalsIgnoreCase(this.getCk_cycle())){//按半年

        }else if(WrchkTaskVo.CYCLE_003.equalsIgnoreCase(this.getCk_cycle())){//按季

        }else if(WrchkTaskVo.CYCLE_004.equalsIgnoreCase(this.getCk_cycle())){//按月

        }else if(WrchkTaskVo.CYCLE_005.equalsIgnoreCase(this.getCk_cycle())){//按周

        }else if(WrchkTaskVo.CYCLE_006.equalsIgnoreCase(this.getCk_cycle())){ //按天

        }
    }
    @Transient
    public String getCk_object_name() {
        return ck_object_name;
    }

    public void setCk_object_name(String ck_object_name) {
        this.ck_object_name = ck_object_name;
    }
}
