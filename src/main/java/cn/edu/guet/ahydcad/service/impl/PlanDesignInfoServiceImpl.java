package cn.edu.guet.ahydcad.service.impl;

import cn.edu.guet.ahydcad.bean.*;
import cn.edu.guet.ahydcad.common.ResponseData;
import cn.edu.guet.ahydcad.mapper.*;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.edu.guet.ahydcad.service.PlanDesignInfoService;
import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Cloud
 * @description 针对表【t_plan_design_info(规划设计评估主表)】的数据库操作Service实现
 * @createDate 2023-07-10 16:44:31
 */
@Service
public class PlanDesignInfoServiceImpl implements PlanDesignInfoService {

    private static Logger logger = LoggerFactory.getLogger(PlanDesignInfoServiceImpl.class);

    @Autowired
    private PlanDesignInfoMapper planDesignInfoMapper;

    @Autowired
    private PlanDesignHistoryRecordMapper historyRecordMapper;

    @Autowired
    private PlanDesignRouteCableMapper routeCableMapper;

    @Autowired
    PlanDesignBusinessRouteMapper businessRouteMapper;

    @Autowired
    private PlanDesignCadDrawingMapper cadDrawingMapper;

    @Autowired
    private PlanDesignConsistencyResultMapper consistencyResultMapper;

    @Autowired
    private PlanDesignExcelRecordMapper excelRecordMapper;

    @Autowired
    private PlanDesignPhysicsRouteMapper physicsRouteMapper;

    @Autowired
    private CartMapper cartMapper;

    @Override
    public int save(PlanDesignInfo planDesignInfo) {
        planDesignInfo.setCreateTime(new Timestamp(System.currentTimeMillis()));
        planDesignInfo.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        planDesignInfoMapper.insert(planDesignInfo);
        return 0;
    }

    @Override
    public String getBillNo() {
        /*
        获取当天日期
         */
        String planBillNumber = null;
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String nowDate = sdf.format(date);

        planBillNumber = planDesignInfoMapper.selectPlanBillNo();
        System.out.println(">>>>>>>>planBillNumer:" + planBillNumber);
        // 数据库没有任何记录
        if (planBillNumber != null) {
            String planBillNo = planBillNumber;
            System.out.println(">>>>>>>>planBillNumer:" + planBillNo);
            String planBillNoDate = planBillNo.substring(9, 17);
            logger.info("planBillNoDate:{}", planBillNoDate);
            logger.info("nowDate:{}", nowDate);
            // 如果不相当，说明当天还没有工单
            if (!nowDate.equals(planBillNoDate)) {
                return "AHYD-PMS-" + nowDate + "-001";
            } else {
                String number = planBillNo.substring(18);
                int no = Integer.parseInt(number);
                no++;
                number = String.valueOf(no);
                if (number.length() == 1) {
                    return "AHYD-PMS-" + planBillNoDate + "-00" + no;
                } else if (number.length() == 2) {
                    return "AHYD-PMS-" + planBillNoDate + "-0" + no;
                } else {
                    return "AHYD-PMS-" + planBillNoDate + "-" + no;
                }
            }
        } else {
            return "AHYD-PMS-" + nowDate + "-001";
        }
    }


    @Override
    public ResponseData parseCAD() {
//        PlanDesignHistoryRecordExample recordExample = new PlanDesignHistoryRecordExample();
//        recordExample.createCriteria()
//                .andAnalyseStatusEqualTo((byte) 1);
        LambdaQueryWrapper<PlanDesignHistoryRecord> historyRecordLambdaQueryWrapper = new QueryWrapper<PlanDesignHistoryRecord>().lambda();
        historyRecordLambdaQueryWrapper.eq(PlanDesignHistoryRecord::getAnalyseStatus,1);
        List<PlanDesignHistoryRecord> historyRecordList = historyRecordMapper.selectList(historyRecordLambdaQueryWrapper);
        for (PlanDesignHistoryRecord historyRecord : historyRecordList) {
            Map<String, Object> bodyMap = new HashMap<>(1);
            bodyMap.put("analyseNo", historyRecord.getAnalyseNo());
            String queryJson = new Gson().toJson(bodyMap);
            // 调解析接口
            HttpResponse response = null;
            ResponseData responseData = null;
            String remoteUrl = "http://localhost:9999/analysCADQueryResult";
            response = HttpRequest.post(remoteUrl.toString())
                    .body(queryJson)
                    .timeout(5 * 60 * 1000)
                    .execute();
            CadResult cadResult = JSON.parseObject(response.body(), CadResult.class);
            CadData cadData = cadResult.getData();
            List<PlanDesignRouteCable> routeCableList = cadData.getRouteCable();
            routeCableList.stream().forEach(planDesignRouteCable -> {
                planDesignRouteCable.setPlanDesignId(historyRecord.getPlanDesignId());
                planDesignRouteCable.setPlanDesignResultId(historyRecord.getId());
                planDesignRouteCable.setCreateTime(new Timestamp(System.currentTimeMillis()));
                // 调用Mapper的save
                routeCableMapper.insert(planDesignRouteCable);
            });
            List<PlanDesignBusinessRoute> businessRouteList = cadData.getBusinessRoute();
            businessRouteList.stream().forEach(planDesignBusinessRoute -> {
                planDesignBusinessRoute.setPlanDesignId(historyRecord.getPlanDesignId());
                planDesignBusinessRoute.setPlanDesignResultId(historyRecord.getId());
                planDesignBusinessRoute.setCreateTime(new Timestamp(System.currentTimeMillis()));
                // 调用Mapper的save
                businessRouteMapper.insert(planDesignBusinessRoute);
            });
            List<PlanDesignCadDrawing> cadDrawingList = cadData.getCadDrawing();
            cadDrawingList.stream().forEach(planDesignCadDrawing -> {
                planDesignCadDrawing.setPlanDesignId(historyRecord.getPlanDesignId());
                planDesignCadDrawing.setPlanDesignResultId(historyRecord.getId());
                planDesignCadDrawing.setCreateTime(new Timestamp(System.currentTimeMillis()));
                //调用Mapper的save
                cadDrawingMapper.insert(planDesignCadDrawing);
            });
            List<PlanDesignConsistencyResult> consistencyResultList = cadData.getConsistencyResult();
            consistencyResultList.stream().forEach(planDesignConsistencyResult -> {
                planDesignConsistencyResult.setPlanDesignId(historyRecord.getPlanDesignId());
                planDesignConsistencyResult.setPlanDesignResultId(historyRecord.getId());
                planDesignConsistencyResult.setCreateTime(new Timestamp(System.currentTimeMillis()));
                //调用Mapper的save
                consistencyResultMapper.insert(planDesignConsistencyResult);
            });
            List<PlanDesignExcelRecord> excelRecordList = cadData.getExcelRecord();
            excelRecordList.stream().forEach(planDesignExcelRecord -> {
                planDesignExcelRecord.setPlanDesignId(historyRecord.getPlanDesignId());
                planDesignExcelRecord.setPlanDesignResultId(historyRecord.getId());
                planDesignExcelRecord.setCreateTime(new Timestamp(System.currentTimeMillis()));
                //调用Mapper的save
                excelRecordMapper.insert(planDesignExcelRecord);
            });
            List<PlanDesignPhysicsRoute> physicsRouteList = cadData.getPhysicsRoute();
            physicsRouteList.stream().forEach(planDesignPhysicsRoute -> {
                planDesignPhysicsRoute.setPlanDesignId(historyRecord.getPlanDesignId());
                planDesignPhysicsRoute.setPlanDesignResultId(historyRecord.getId());
                planDesignPhysicsRoute.setCreateTime(new Timestamp(System.currentTimeMillis()));
                //调用Mapper的save
                physicsRouteMapper.insert(planDesignPhysicsRoute);
            });
        }
        return ResponseData.ok("解析成功！");
    }

    @Override
    public ResponseData createBillAndAnalyse(PlanDesignInfo planDesignInfo) {
        /*
            1、保存工单信息
             */
        planDesignInfo.setCreateTime(new Timestamp(System.currentTimeMillis()));
        planDesignInfo.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        planDesignInfoMapper.insert(planDesignInfo);
            /*
            2、分析工单
             */
        Map<String, Object> map = new HashMap<>(8);
        map.put("systemCADFilePath", planDesignInfo.getSystemCadFileUrl());
        map.put("systemExcelFilePath", planDesignInfo.getSystemExcelFileUrl());
        map.put("channelExcelFilePath", planDesignInfo.getChannelExcelFileUrl());
        map.put("planBillNo", planDesignInfo.getPlanBillNo());
        map.put("cadCoordLeft", planDesignInfo.getCadCoordLeft());
        map.put("cadCoordTop", planDesignInfo.getCadCoordTop());
        map.put("cadCoordRight", planDesignInfo.getCadCoordRight());
        map.put("cadCoordBottom", planDesignInfo.getCadCoordBottom());


        String queryJson = new Gson().toJson(map);
        Map<String, String> heads = new HashMap<>(1);
        heads.put("Content-Type", "application/json;charset=UTF-8");
        HttpResponse response = HttpRequest.post("http://localhost:9999/analysCADCallApi")
                .headerMap(heads, false)
                .body(queryJson)
                .timeout(5 * 60 * 100)
                .execute();
        ResponseData responseData = new Gson().fromJson(response.body(), ResponseData.class);
        logger.info(responseData.getCode() + "");
        logger.info(responseData.getMessage());
        logger.info(responseData.getData() + "");


        /*
        将analyseNo、plan_design_no、create_time和analyse_status存入planDesignHistoryRecord表中
         */
        Map<String, Object> dataMap = (Map<String, Object>) responseData.getData();
        String analyseNo = (String) dataMap.get("analyseNo");
        String planBillNo = (String) dataMap.get("planBillNo");
        logger.info("planBillNo:{}", planBillNo);
        LambdaQueryWrapper<PlanDesignInfo> infoLambdaQueryWrapper = new QueryWrapper<PlanDesignInfo>().lambda();
        infoLambdaQueryWrapper.eq(PlanDesignInfo::getPlanBillNo,planBillNo);
        List<PlanDesignInfo> planDesignInfoList = planDesignInfoMapper.selectList(infoLambdaQueryWrapper);
        System.out.println(planDesignInfoList.size());
        Long planDesignId = planDesignInfoList.get(0).getId();
        PlanDesignHistoryRecord planDesignHistoryRecord = new PlanDesignHistoryRecord();
        planDesignHistoryRecord.setPlanDesignId(planDesignId);
        planDesignHistoryRecord.setAnalyseNo(analyseNo);
        // 创建时间
        long now = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = sdf.format(new Date(now));
        Timestamp createTime = Timestamp.valueOf(formattedDate);
        planDesignHistoryRecord.setCreateTime(createTime);
        planDesignHistoryRecord.setAnalyseStatus(1);

        historyRecordMapper.insert(planDesignHistoryRecord);

        return responseData;
    }

    @Override
    public IPage<PlanDesignInfo> searchBill(PlanDesignInfoQueryDto queryDto) {
        Page<PlanDesignInfo> page = new Page<>();
        page.setSize(queryDto.getSize());
        page.setCurrent(queryDto.getCurrent());

        QueryWrapper<PlanDesignInfo> queryWrapper = new QueryWrapper<>();
        if (!StringUtils.isBlank(queryDto.getPlanDesignName())) {
            queryWrapper.like("plan_design_name", queryDto.getPlanDesignName());
        }
        if (queryDto.getSpecId() != null) {
            queryWrapper.eq("spec_id", queryDto.getSpecId());
        }
        if (!StringUtils.isBlank(queryDto.getDesigner())) {
            queryWrapper.like("designer", queryDto.getDesigner());
        }
        if (CollectionUtil.isNotEmpty(queryDto.getCreateTime())) {
            queryWrapper.between("create_time", queryDto.getCreateTime().get(0), queryDto.getCreateTime().get(1));
        }
        return planDesignInfoMapper.selectPage(page, queryWrapper);
    }

    @Override
    public List<Cart> selectBooks() {
        List<Cart> cartList = cartMapper.selectList(null);
        return cartList;
    }
}




