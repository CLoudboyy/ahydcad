package cn.edu.guet.ahydcad.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * 系统规划一致性校验比对结果表
 * @TableName t_plan_design_consistency_result
 */
@TableName(value ="t_plan_design_consistency_result")
public class PlanDesignConsistencyResult implements Serializable {
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
     * CAD图纸识别（数量）
     */
    @TableField(value = "analys_cad_num")
    private Integer analysCadNum;

    /**
     * Excel文件解析（数量）
     */
    @TableField(value = "analys_excel_num")
    private Integer analysExcelNum;

    /**
     * 分析结果 枚举，1一致，2不一致
     */
    @TableField(value = "analys_result")
    private String analysResult;

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
     * CAD图纸识别（数量）
     */
    public Integer getAnalysCadNum() {
        return analysCadNum;
    }

    /**
     * CAD图纸识别（数量）
     */
    public void setAnalysCadNum(Integer analysCadNum) {
        this.analysCadNum = analysCadNum;
    }

    /**
     * Excel文件解析（数量）
     */
    public Integer getAnalysExcelNum() {
        return analysExcelNum;
    }

    /**
     * Excel文件解析（数量）
     */
    public void setAnalysExcelNum(Integer analysExcelNum) {
        this.analysExcelNum = analysExcelNum;
    }

    /**
     * 分析结果 枚举，1一致，2不一致
     */
    public String getAnalysResult() {
        return analysResult;
    }

    /**
     * 分析结果 枚举，1一致，2不一致
     */
    public void setAnalysResult(String analysResult) {
        this.analysResult = analysResult;
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