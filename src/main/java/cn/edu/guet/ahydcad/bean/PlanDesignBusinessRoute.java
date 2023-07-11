package cn.edu.guet.ahydcad.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * 业务同路由分析表
 * @TableName t_plan_design_business_route
 */
@TableName(value ="t_plan_design_business_route")
public class PlanDesignBusinessRoute implements Serializable {
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
     * 环信息
     */
    @TableField(value = "circle_name")
    private String circleName;

    /**
     * 
     */
    @TableField(value = "business_type")
    private String businessType;

    /**
     * 业务波道
     */
    @TableField(value = "business_channel")
    private String businessChannel;

    /**
     * A端站点
     */
    @TableField(value = "station_a")
    private String stationA;

    /**
     * Z端站点
     */
    @TableField(value = "station_z")
    private String stationZ;

    /**
     * 电路性质：政企，其他
     */
    @TableField(value = "business_character")
    private String businessCharacter;

    /**
     * 主路由
     */
    @TableField(value = "main_route")
    private String mainRoute;

    /**
     * 备路由
     */
    @TableField(value = "backup_route")
    private String backupRoute;

    /**
     * 同路由详情
     */
    @TableField(value = "same_route_detail")
    private String sameRouteDetail;

    /**
     * 同站点信息
     */
    @TableField(value = "same_station_name")
    private String sameStationName;

    /**
     * 是否同路由
     */
    @TableField(value = "is_same_route")
    private Integer isSameRoute;

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
     * 环信息
     */
    public String getCircleName() {
        return circleName;
    }

    /**
     * 环信息
     */
    public void setCircleName(String circleName) {
        this.circleName = circleName;
    }

    /**
     * 
     */
    public String getBusinessType() {
        return businessType;
    }

    /**
     * 
     */
    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    /**
     * 业务波道
     */
    public String getBusinessChannel() {
        return businessChannel;
    }

    /**
     * 业务波道
     */
    public void setBusinessChannel(String businessChannel) {
        this.businessChannel = businessChannel;
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
     * 电路性质：政企，其他
     */
    public String getBusinessCharacter() {
        return businessCharacter;
    }

    /**
     * 电路性质：政企，其他
     */
    public void setBusinessCharacter(String businessCharacter) {
        this.businessCharacter = businessCharacter;
    }

    /**
     * 主路由
     */
    public String getMainRoute() {
        return mainRoute;
    }

    /**
     * 主路由
     */
    public void setMainRoute(String mainRoute) {
        this.mainRoute = mainRoute;
    }

    /**
     * 备路由
     */
    public String getBackupRoute() {
        return backupRoute;
    }

    /**
     * 备路由
     */
    public void setBackupRoute(String backupRoute) {
        this.backupRoute = backupRoute;
    }

    /**
     * 同路由详情
     */
    public String getSameRouteDetail() {
        return sameRouteDetail;
    }

    /**
     * 同路由详情
     */
    public void setSameRouteDetail(String sameRouteDetail) {
        this.sameRouteDetail = sameRouteDetail;
    }

    /**
     * 同站点信息
     */
    public String getSameStationName() {
        return sameStationName;
    }

    /**
     * 同站点信息
     */
    public void setSameStationName(String sameStationName) {
        this.sameStationName = sameStationName;
    }

    /**
     * 是否同路由
     */
    public Integer getIsSameRoute() {
        return isSameRoute;
    }

    /**
     * 是否同路由
     */
    public void setIsSameRoute(Integer isSameRoute) {
        this.isSameRoute = isSameRoute;
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