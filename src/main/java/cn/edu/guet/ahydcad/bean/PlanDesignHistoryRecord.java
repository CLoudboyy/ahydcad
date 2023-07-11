package cn.edu.guet.ahydcad.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * 规划设计评估历史分析记录表
 * @TableName t_plan_design_history_record
 */
@TableName(value ="t_plan_design_history_record")
public class PlanDesignHistoryRecord implements Serializable {
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
     * 分析编号
     */
    @TableField(value = "analyse_no")
    private String analyseNo;

    /**
     * 分析状态1、正在解析  2、解析完成
     */
    @TableField(value = "analyse_status")
    private Integer analyseStatus;

    /**
     * 分析开始时间（调分析接口开始时间）
     */
    @TableField(value = "analyse_begin_time")
    private Date analyseBeginTime;

    /**
     * 分析结束时间（调分析接口结束时间）
     */
    @TableField(value = "analyse_end_time")
    private Date analyseEndTime;

    /**
     * 分析时长（秒） 单位：秒
     */
    @TableField(value = "analyse_time")
    private Integer analyseTime;

    /**
     * 系统规划CAD图纸附件Id
     */
    @TableField(value = "system_cad_file_id")
    private Integer systemCadFileId;

    /**
     * 系统规划CAD图纸附件名称
     */
    @TableField(value = "system_cad_file_name")
    private String systemCadFileName;

    /**
     * 系统规划CAD图纸附件URL
     */
    @TableField(value = "system_cad_file_url")
    private String systemCadFileUrl;

    /**
     * 系统规划Excel文件附件Id
     */
    @TableField(value = "system_excel_file_id")
    private Integer systemExcelFileId;

    /**
     * 系统规划Excel文件附件名称
     */
    @TableField(value = "system_excel_file_name")
    private String systemExcelFileName;

    /**
     * 系统规划Excel文件附件URL 
     */
    @TableField(value = "system_excel_file_url")
    private String systemExcelFileUrl;

    /**
     * 波道规划Excel文件附件Id
     */
    @TableField(value = "channel_excel_file_id")
    private Integer channelExcelFileId;

    /**
     * 波道规划Excel文件附件名称
     */
    @TableField(value = "channel_excel_file_name")
    private String channelExcelFileName;

    /**
     * 波道规划Excel文件附件URL
     */
    @TableField(value = "channel_excel_file_url")
    private String channelExcelFileUrl;

    /**
     * 分析日志
     */
    @TableField(value = "analyse_log")
    private String analyseLog;

    /**
     * 分析人id
     */
    @TableField(value = "analyse_staff_id")
    private Long analyseStaffId;

    /**
     * 分析人名称
     */
    @TableField(value = "analyse_staff_name")
    private String analyseStaffName;

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
     * 分析编号
     */
    public String getAnalyseNo() {
        return analyseNo;
    }

    /**
     * 分析编号
     */
    public void setAnalyseNo(String analyseNo) {
        this.analyseNo = analyseNo;
    }

    /**
     * 分析状态1、正在解析  2、解析完成
     */
    public Integer getAnalyseStatus() {
        return analyseStatus;
    }

    /**
     * 分析状态1、正在解析  2、解析完成
     */
    public void setAnalyseStatus(Integer analyseStatus) {
        this.analyseStatus = analyseStatus;
    }

    /**
     * 分析开始时间（调分析接口开始时间）
     */
    public Date getAnalyseBeginTime() {
        return analyseBeginTime;
    }

    /**
     * 分析开始时间（调分析接口开始时间）
     */
    public void setAnalyseBeginTime(Date analyseBeginTime) {
        this.analyseBeginTime = analyseBeginTime;
    }

    /**
     * 分析结束时间（调分析接口结束时间）
     */
    public Date getAnalyseEndTime() {
        return analyseEndTime;
    }

    /**
     * 分析结束时间（调分析接口结束时间）
     */
    public void setAnalyseEndTime(Date analyseEndTime) {
        this.analyseEndTime = analyseEndTime;
    }

    /**
     * 分析时长（秒） 单位：秒
     */
    public Integer getAnalyseTime() {
        return analyseTime;
    }

    /**
     * 分析时长（秒） 单位：秒
     */
    public void setAnalyseTime(Integer analyseTime) {
        this.analyseTime = analyseTime;
    }

    /**
     * 系统规划CAD图纸附件Id
     */
    public Integer getSystemCadFileId() {
        return systemCadFileId;
    }

    /**
     * 系统规划CAD图纸附件Id
     */
    public void setSystemCadFileId(Integer systemCadFileId) {
        this.systemCadFileId = systemCadFileId;
    }

    /**
     * 系统规划CAD图纸附件名称
     */
    public String getSystemCadFileName() {
        return systemCadFileName;
    }

    /**
     * 系统规划CAD图纸附件名称
     */
    public void setSystemCadFileName(String systemCadFileName) {
        this.systemCadFileName = systemCadFileName;
    }

    /**
     * 系统规划CAD图纸附件URL
     */
    public String getSystemCadFileUrl() {
        return systemCadFileUrl;
    }

    /**
     * 系统规划CAD图纸附件URL
     */
    public void setSystemCadFileUrl(String systemCadFileUrl) {
        this.systemCadFileUrl = systemCadFileUrl;
    }

    /**
     * 系统规划Excel文件附件Id
     */
    public Integer getSystemExcelFileId() {
        return systemExcelFileId;
    }

    /**
     * 系统规划Excel文件附件Id
     */
    public void setSystemExcelFileId(Integer systemExcelFileId) {
        this.systemExcelFileId = systemExcelFileId;
    }

    /**
     * 系统规划Excel文件附件名称
     */
    public String getSystemExcelFileName() {
        return systemExcelFileName;
    }

    /**
     * 系统规划Excel文件附件名称
     */
    public void setSystemExcelFileName(String systemExcelFileName) {
        this.systemExcelFileName = systemExcelFileName;
    }

    /**
     * 系统规划Excel文件附件URL 
     */
    public String getSystemExcelFileUrl() {
        return systemExcelFileUrl;
    }

    /**
     * 系统规划Excel文件附件URL 
     */
    public void setSystemExcelFileUrl(String systemExcelFileUrl) {
        this.systemExcelFileUrl = systemExcelFileUrl;
    }

    /**
     * 波道规划Excel文件附件Id
     */
    public Integer getChannelExcelFileId() {
        return channelExcelFileId;
    }

    /**
     * 波道规划Excel文件附件Id
     */
    public void setChannelExcelFileId(Integer channelExcelFileId) {
        this.channelExcelFileId = channelExcelFileId;
    }

    /**
     * 波道规划Excel文件附件名称
     */
    public String getChannelExcelFileName() {
        return channelExcelFileName;
    }

    /**
     * 波道规划Excel文件附件名称
     */
    public void setChannelExcelFileName(String channelExcelFileName) {
        this.channelExcelFileName = channelExcelFileName;
    }

    /**
     * 波道规划Excel文件附件URL
     */
    public String getChannelExcelFileUrl() {
        return channelExcelFileUrl;
    }

    /**
     * 波道规划Excel文件附件URL
     */
    public void setChannelExcelFileUrl(String channelExcelFileUrl) {
        this.channelExcelFileUrl = channelExcelFileUrl;
    }

    /**
     * 分析日志
     */
    public String getAnalyseLog() {
        return analyseLog;
    }

    /**
     * 分析日志
     */
    public void setAnalyseLog(String analyseLog) {
        this.analyseLog = analyseLog;
    }

    /**
     * 分析人id
     */
    public Long getAnalyseStaffId() {
        return analyseStaffId;
    }

    /**
     * 分析人id
     */
    public void setAnalyseStaffId(Long analyseStaffId) {
        this.analyseStaffId = analyseStaffId;
    }

    /**
     * 分析人名称
     */
    public String getAnalyseStaffName() {
        return analyseStaffName;
    }

    /**
     * 分析人名称
     */
    public void setAnalyseStaffName(String analyseStaffName) {
        this.analyseStaffName = analyseStaffName;
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