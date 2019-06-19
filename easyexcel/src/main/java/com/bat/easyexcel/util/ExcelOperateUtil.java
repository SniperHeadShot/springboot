package com.bat.easyexcel.util;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.fastjson.JSONObject;
import com.bat.easyexcel.config.TempExcelConfig;
import com.bat.easyexcel.entity.ExportDTO;
import com.bat.easyexcel.entity.GenerateExportParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * EasyExcel 操作工具类
 *
 * @author ZhengYu
 * @version 1.0 2019/6/19 9:33
 **/
public class ExcelOperateUtil {

    private final static Logger logger = LoggerFactory.getLogger(ExcelOperateUtil.class);

    /**
     * 导出
     *
     * @param generateExportParam 参数实体
     * @author ZhengYu
     */
    public static void writeExcel(GenerateExportParam generateExportParam) throws IOException {
        logger.info("入参 ===>：{}", JSONObject.toJSONString(generateExportParam));
        OutputStream outputStream = generateExportParam.getOutputStream();
        ExcelWriter writer = EasyExcelFactory.getWriter(outputStream, ExcelTypeEnum.XLSX, true);

        AtomicInteger atomicInteger = new AtomicInteger(1);
        generateExportParam.getExportData().forEach(generateExportData -> {
            Sheet sheet = new Sheet(atomicInteger.getAndIncrement(), TempExcelConfig.HEAD_LINE_NUMBER, ExportDTO.class, generateExportData.getSheetName(), null);
            sheet.setTableStyle(ExportExcelStyleUtil.createTableStyle());
            writer.write(generateExportData.getExportData(), sheet);
        });
        writer.finish();
        outputStream.close();
    }
}
