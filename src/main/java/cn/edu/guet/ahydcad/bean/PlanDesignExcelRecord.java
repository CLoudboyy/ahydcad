package cn.edu.guet.ahydcad.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * Excel文件解析清单表
 * @TableName t_plan_design_excel_record
 */
@TableName(value ="t_plan_design_excel_record")
public class PlanDesignExcelRecord implements Serializable {
    /**
     * 编号
     */
    @TableId(value = "Id", type = IdType.AUTO)
    private Long id;

    /**
     * 规划设计工单主表id
     */
    @TableField(value = "plan_design_id")
    private Long planDesignId;

    /**
     * 规划设计评估历史分析记录表id
     */
    @TableField(value = "plan_design_result_id")
    private Long planDesignResultId;

    /**
     * 系统名称
     */
    @TableField(value = "sys_name")
    private String sysName;

    /**
     * 光缆段名称
     */
    @TableField(value = "cable_seg_name")
    private String cableSegName;

    /**
     * A端站点
     */
    @TableField(value = "station_a")
    private String stationA;

    /**
     * A站点类型
     */
    @TableField(value = "station_type_a")
    private String stationTypeA;

    /**
     * Z端站点
     */
    @TableField(value = "station_z")
    private String stationZ;

    /**
     * Z站点类型
     */
    @TableField(value = "station_type_z")
    private String stationTypeZ;

    /**
     * 光纤信息
     */
    @TableField(value = "cable_name")
    private String cableName;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    public Long getId() {
        return id;
    }

    /**
     * 编号
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 规划设计工单主表id
     */
    public Long getPlanDesignId() {
        return planDesignId;
    }

    /**
     * 规划设计工单主表id
     */
    public void setPlanDesignId(Long planDesignId) {
        this.planDesignId = planDesignId;
    }

    /**
     * 规划设计评估历史分析记录表id
     */
    public Long getPlanDesignResultId() {
        return planDesignResultId;
    }

    /**
     * 规划设计评估历史分析记录表id
     */
    public void setPlanDesignResultId(Long planDesignResultId) {
        this.planDesignResultId = planDesignResultId;
    }

    /**
     * 系统名称
     */
    public String getSysName() {
        return sysName;
    }

    /**
     * 系统名称
     */
    public void setSysName(String sysName) {
        this.sysName = sysName;
    }

    /**
     * 光缆段名称
     */
    public String getCableSegName() {
        return cableSegName;
    }

    /**
     * 光缆段名称
     */
    public void setCableSegName(String cableSegName) {
        this.cableSegName = cableSegName;
    }

    /**
     * A端站点
     */
    public String getStationA() {
        return stationA;
    }

    /**
     * A端站点
     */
    public void setStationA(String stationA) {
        this.stationA = stationA;
    }

    /**
     * A站点类型
     */
    public String getStationTypeA() {
        return stationTypeA;
    }

    /**
     * A站点类型
     */
    public void setStationTypeA(String stationTypeA) {
        this.stationTypeA = stationTypeA;
    }

    /**
     * Z端站点
     */
    public String getStationZ() {
        return stationZ;
    }

    /**
     * Z端站点
     */
    public void setStationZ(String stationZ) {
        this.stationZ = stationZ;
    }

    /**
     * Z站点类型
     */
    public String getStationTypeZ() {
        return stationTypeZ;
    }

    /**
     * Z站点类型
     */
    public void setStationTypeZ(String stationTypeZ) {
        this.stationTypeZ = stationTypeZ;
    }

    /**
     * 光纤信息
     */
    public String getCableName() {
        return cableName;
    }

    /**
     * 光纤信息
     */
    public void setCableName(String cableName) {
        this.cableName = cableName;
    }

    /**
     * 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}