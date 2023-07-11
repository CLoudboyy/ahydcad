package cn.edu.guet.ahydcad.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * 规划设计评估主表
 * @TableName t_plan_design_info
 */
@TableName(value ="t_plan_design_info")
public class PlanDesignInfo implements Serializable {
    /**
     * 编号
     */
    @TableId(value = "Id", type = IdType.AUTO)
    private Long id;

    /**
     * 规划工单编号
     */
    @TableField(value = "plan_bill_no")
    private String planBillNo;

    /**
     * 规划设计名称
     */
    @TableField(value = "plan_design_name")
    private String planDesignName;

    /**
     * 设计单位
     */
    @TableField(value = "design_company")
    private String designCompany;

    /**
     * 类名 业务类型，枚举：1、 OTN业务
     */
    @TableField(value = "spec_id")
    private Integer specId;

    /**
     * 项目总负责人
     */
    @TableField(value = "project_director")
    private String projectDirector;

    /**
     * 专业负责人
     */
    @TableField(value = "spec_leader")
    private String specLeader;

    /**
     * 设计人
     */
    @TableField(value = "designer")
    private String designer;

    /**
     * 校审人 当前用户
     */
    @TableField(value = "reviewer")
    private String reviewer;

    /**
     * 工单来源 枚举：1自建（默认） 2外部工单
     */
    @TableField(value = "source")
    private Integer source;

    /**
     * 系统规划CAD图纸附件Id
     */
    @TableField(value = "system_cad_file_id")
    private Integer systemCadFileId;

    /**
     * 系统规划CAD文件名
     */
    @TableField(value = "system_cad_file_name")
    private String systemCadFileName;

    /**
     * 系统规划CAD文件URL
     */
    @TableField(value = "system_cad_file_url")
    private String systemCadFileUrl;

    /**
     * 系统规划Excel文件附件Id
     */
    @TableField(value = "system_excel_file_id")
    private Integer systemExcelFileId;

    /**
     * 系统规划Excel文件附件名
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
     * 波道规划Excel文件附件名
     */
    @TableField(value = "channel_excel_file_name")
    private String channelExcelFileName;

    /**
     * 波道规划Excel文件附件URL
     */
    @TableField(value = "channel_excel_file_url")
    private String channelExcelFileUrl;

    /**
     * CAD图纸坐标(左)
     */
    @TableField(value = "cad_coord_left")
    private Integer cadCoordLeft;

    /**
     * CAD图纸坐标(上)
     */
    @TableField(value = "cad_coord_top")
    private Integer cadCoordTop;

    /**
     * CAD图纸坐标(右)
     */
    @TableField(value = "cad_coord_right")
    private Integer cadCoordRight;

    /**
     * CAD图纸坐标(下)
     */
    @TableField(value = "cad_coord_bottom")
    private Integer cadCoordBottom;

    /**
     * 工单创建人id
     */
    @TableField(value = "staff_id")
    private Integer staffId;

    /**
     * 工单创建人名称
     */
    @TableField(value = "staff_name")
    private String staffName;

    /**
     * 设计新建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    private Date updateTime;

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
     * 规划工单编号
     */
    public String getPlanBillNo() {
        return planBillNo;
    }

    /**
     * 规划工单编号
     */
    public void setPlanBillNo(String planBillNo) {
        this.planBillNo = planBillNo;
    }

    /**
     * 规划设计名称
     */
    public String getPlanDesignName() {
        return planDesignName;
    }

    /**
     * 规划设计名称
     */
    public void setPlanDesignName(String planDesignName) {
        this.planDesignName = planDesignName;
    }

    /**
     * 设计单位
     */
    public String getDesignCompany() {
        return designCompany;
    }

    /**
     * 设计单位
     */
    public void setDesignCompany(String designCompany) {
        this.designCompany = designCompany;
    }

    /**
     * 类名 业务类型，枚举：1、 OTN业务
     */
    public Integer getSpecId() {
        return specId;
    }

    /**
     * 类名 业务类型，枚举：1、 OTN业务
     */
    public void setSpecId(Integer specId) {
        this.specId = specId;
    }

    /**
     * 项目总负责人
     */
    public String getProjectDirector() {
        return projectDirector;
    }

    /**
     * 项目总负责人
     */
    public void setProjectDirector(String projectDirector) {
        this.projectDirector = projectDirector;
    }

    /**
     * 专业负责人
     */
    public String getSpecLeader() {
        return specLeader;
    }

    /**
     * 专业负责人
     */
    public void setSpecLeader(String specLeader) {
        this.specLeader = specLeader;
    }

    /**
     * 设计人
     */
    public String getDesigner() {
        return designer;
    }

    /**
     * 设计人
     */
    public void setDesigner(String designer) {
        this.designer = designer;
    }

    /**
     * 校审人 当前用户
     */
    public String getReviewer() {
        return reviewer;
    }

    /**
     * 校审人 当前用户
     */
    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    /**
     * 工单来源 枚举：1自建（默认） 2外部工单
     */
    public Integer getSource() {
        return source;
    }

    /**
     * 工单来源 枚举：1自建（默认） 2外部工单
     */
    public void setSource(Integer source) {
        this.source = source;
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
     * 系统规划CAD文件名
     */
    public String getSystemCadFileName() {
        return systemCadFileName;
    }

    /**
     * 系统规划CAD文件名
     */
    public void setSystemCadFileName(String systemCadFileName) {
        this.systemCadFileName = systemCadFileName;
    }

    /**
     * 系统规划CAD文件URL
     */
    public String getSystemCadFileUrl() {
        return systemCadFileUrl;
    }

    /**
     * 系统规划CAD文件URL
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
     * 系统规划Excel文件附件名
     */
    public String getSystemExcelFileName() {
        return systemExcelFileName;
    }

    /**
     * 系统规划Excel文件附件名
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
     * 波道规划Excel文件附件名
     */
    public String getChannelExcelFileName() {
        return channelExcelFileName;
    }

    /**
     * 波道规划Excel文件附件名
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
     * CAD图纸坐标(左)
     */
    public Integer getCadCoordLeft() {
        return cadCoordLeft;
    }

    /**
     * CAD图纸坐标(左)
     */
    public void setCadCoordLeft(Integer cadCoordLeft) {
        this.cadCoordLeft = cadCoordLeft;
    }

    /**
     * CAD图纸坐标(上)
     */
    public Integer getCadCoordTop() {
        return cadCoordTop;
    }

    /**
     * CAD图纸坐标(上)
     */
    public void setCadCoordTop(Integer cadCoordTop) {
        this.cadCoordTop = cadCoordTop;
    }

    /**
     * CAD图纸坐标(右)
     */
    public Integer getCadCoordRight() {
        return cadCoordRight;
    }

    /**
     * CAD图纸坐标(右)
     */
    public void setCadCoordRight(Integer cadCoordRight) {
        this.cadCoordRight = cadCoordRight;
    }

    /**
     * CAD图纸坐标(下)
     */
    public Integer getCadCoordBottom() {
        return cadCoordBottom;
    }

    /**
     * CAD图纸坐标(下)
     */
    public void setCadCoordBottom(Integer cadCoordBottom) {
        this.cadCoordBottom = cadCoordBottom;
    }

    /**
     * 工单创建人id
     */
    public Integer getStaffId() {
        return staffId;
    }

    /**
     * 工单创建人id
     */
    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    /**
     * 工单创建人名称
     */
    public String getStaffName() {
        return staffName;
    }

    /**
     * 工单创建人名称
     */
    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    /**
     * 设计新建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设计新建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "PlanDesignInfo{" +
                "id=" + id +
                ", planBillNo='" + planBillNo + '\'' +
                ", planDesignName='" + planDesignName + '\'' +
                ", designCompany='" + designCompany + '\'' +
                ", specId=" + specId +
                ", projectDirector='" + projectDirector + '\'' +
                ", specLeader='" + specLeader + '\'' +
                ", designer='" + designer + '\'' +
                ", reviewer='" + reviewer + '\'' +
                ", source=" + source +
                ", systemCadFileId=" + systemCadFileId +
                ", systemCadFileName='" + systemCadFileName + '\'' +
                ", systemCadFileUrl='" + systemCadFileUrl + '\'' +
                ", systemExcelFileId=" + systemExcelFileId +
                ", systemExcelFileName='" + systemExcelFileName + '\'' +
                ", systemExcelFileUrl='" + systemExcelFileUrl + '\'' +
                ", channelExcelFileId=" + channelExcelFileId +
                ", channelExcelFileName='" + channelExcelFileName + '\'' +
                ", channelExcelFileUrl='" + channelExcelFileUrl + '\'' +
                ", cadCoordLeft=" + cadCoordLeft +
                ", cadCoordTop=" + cadCoordTop +
                ", cadCoordRight=" + cadCoordRight +
                ", cadCoordBottom=" + cadCoordBottom +
                ", staffId=" + staffId +
                ", staffName='" + staffName + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}