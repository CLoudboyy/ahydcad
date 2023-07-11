package cn.edu.guet.ahydcad.service;

import cn.edu.guet.ahydcad.bean.Cart;
import cn.edu.guet.ahydcad.bean.PlanDesignDTO;
import cn.edu.guet.ahydcad.bean.PlanDesignInfo;
import cn.edu.guet.ahydcad.bean.PlanDesignInfoQueryDto;
import cn.edu.guet.ahydcad.common.ResponseData;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author Cloud
* @description 针对表【t_plan_design_info(规划设计评估主表)】的数据库操作Service
* @createDate 2023-07-10 16:44:31
*/
public interface PlanDesignInfoService {

    int save(PlanDesignInfo planDesignInfo);

    String getBillNo();

    ResponseData parseCAD();

    ResponseData createBillAndAnalyse(PlanDesignInfo planDesignInfo);

    IPage<PlanDesignInfo> searchBill(PlanDesignInfoQueryDto queryDto);

    List<Cart> selectBooks();
}
