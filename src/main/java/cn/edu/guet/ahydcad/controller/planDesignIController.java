package cn.edu.guet.ahydcad.controller;

import cn.edu.guet.ahydcad.bean.PlanDesignInfo;
import cn.edu.guet.ahydcad.bean.PlanDesignInfoQueryDto;
import cn.edu.guet.ahydcad.common.ResponseData;
import cn.edu.guet.ahydcad.service.PlanDesignInfoService;

import cn.edu.guet.ahydcad.service.impl.PlanDesignInfoServiceImpl;
import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.gson.Gson;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;

/**
 * @Author huangzhouyu
 * @Data 2023/7/10 16:38
 */
@RestController
public class planDesignIController {

    private static Logger logger = LoggerFactory.getLogger(PlanDesignInfoServiceImpl.class);

    @Autowired
    private PlanDesignInfoService planDesignInfoService;

    @GetMapping("/loadBooksData")
    @ResponseBody
    public ResponseData loadBooksData(){
        return ResponseData.ok(planDesignInfoService.selectBooks());
    }

    /**
     * 保存工单
     *
     * @param planDesignInfo
     * @return
     */
    @PostMapping("/createBill")
    public ResponseData createBill(@RequestBody PlanDesignInfo planDesignInfo) {
        planDesignInfoService.save(planDesignInfo);
        return ResponseData.ok("工单创建成功！");
    }

    /**
     * 保存并分析
     *
     * @param planDesignInfo
     * @return
     */
    @PostMapping("/createBillAndAnalyse")
    @ResponseBody
    public ResponseData createBillAndAnalyse(@RequestBody PlanDesignInfo planDesignInfo) {
        logger.info("创建工单：{}", planDesignInfo);
        return planDesignInfoService.createBillAndAnalyse(planDesignInfo);
    }

    @GetMapping("/getBillNo")
    public String getBillNo() {
        return planDesignInfoService.getBillNo();
    }

    @PostMapping("/searchBill")
    public ResponseData searchBill(@RequestBody PlanDesignInfoQueryDto queryDto) {
        IPage<PlanDesignInfo> designInfoIPage = planDesignInfoService.searchBill(queryDto);
        return ResponseData.ok(designInfoIPage);
    }

    @RequestMapping("/parseCAD.do")
    @ResponseBody
    public ResponseData parseCAD() {
        return planDesignInfoService.parseCAD();
    }

    @PostMapping("/upload")
    public ResponseData upload(HttpServletRequest request, HttpServletResponse response) {
        String dir = System.getProperty("user.dir");
        dir = dir.substring(0, dir.lastIndexOf("\\"));
        Gson gson = new Gson();
        String realPath = dir + "\\webapps\\upload";
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if (isMultipart == true) {
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            List<FileItem> items = null;
            try {
                items = upload.parseRequest(request);
            } catch (FileUploadException e) {
                e.printStackTrace();
            }
            Iterator<FileItem> itr = items.iterator();
            while (itr.hasNext()) {
                FileItem item = (FileItem) itr.next();
                if (!item.isFormField()) {
                    File fullFile = new File(item.getName());
                    File savedFile = new File(realPath + "/", fullFile.getName());
                    try {
                        item.write(savedFile);
                        String url = "http://localhost:8080/upload/" + fullFile.getName();
                        String[] strs = {url};
                        return ResponseData.ok(strs);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            System.out.print("the enctype must be multipart/form-data");
        }
        return null;
    }

}
