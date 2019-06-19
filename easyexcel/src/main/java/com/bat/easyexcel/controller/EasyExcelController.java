package com.bat.easyexcel.controller;

import com.bat.easyexcel.service.ExcelOperateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * 测试导入导出功能
 *
 * @author ZhengYu
 * @version 1.0 2019/6/19 12:37
 **/
@RestController
public class EasyExcelController {

    @Autowired
    private ExcelOperateService excelOperateService;

    @GetMapping("/export")
    public void excelExport(HttpServletResponse response) {
        excelOperateService.exportWithExcel(response);
    }
}
