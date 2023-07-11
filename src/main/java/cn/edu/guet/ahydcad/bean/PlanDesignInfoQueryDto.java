package cn.edu.guet.ahydcad.bean;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * @Author liwei
 * @Date 2023/7/11 09:48
 * @Version 1.0
 */
public class PlanDesignInfoQueryDto extends Page {
    private String planDesignName;

    /**
     * 类名 业务类型，枚举：1、 OTN业务
     */
    private Integer specId;

    /**
     * 设计人
     */
    private String designer;

    /**
     * 设计创建时间
     */
    private List<String> createTime;

    public String getPlanDesignName() {
        return planDesignName;
    }

    public void setPlanDesignName(String planDesignName) {
        this.planDesignName = planDesignName;
    }

    public Integer getSpecId() {
        return specId;
    }

    public void setSpecId(Integer specId) {
        this.specId = specId;
    }

    public String getDesigner() {
        return designer;
    }

    public void setDesigner(String designer) {
        this.designer = designer;
    }

    public List<String> getCreateTime() {
        return createTime;
    }

    public void setCreateTime(List<String> createTime) {
        this.createTime = createTime;
    }

}
