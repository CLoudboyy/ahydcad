package cn.edu.guet.ahydcad.mapper;

import cn.edu.guet.ahydcad.bean.PlanDesignDTO;
import cn.edu.guet.ahydcad.bean.PlanDesignInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author Cloud
* @description 针对表【t_plan_design_info(规划设计评估主表)】的数据库操作Mapper
* @createDate 2023-07-10 16:44:31
* @Entity cn.edu.guet.ahydcad.bean.PlanDesignInfo
*/
@Mapper
public interface PlanDesignInfoMapper extends BaseMapper<PlanDesignInfo> {
    /**
     * 获取工单号
     */
    String selectPlanBillNo();

    List<PlanDesignInfo> searchBill(PlanDesignDTO planDesignDTO);

    int countSearchBill(PlanDesignDTO planDesignDTO);
}




