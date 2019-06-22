package com.bat.easyexcel.service.impl;

import com.bat.easyexcel.entity.ExportDTO;
import com.bat.easyexcel.entity.GenerateExportData;
import com.bat.easyexcel.entity.GenerateExportParam;
import com.bat.easyexcel.exception.ExcelOperateException;
import com.bat.easyexcel.service.EasyExcelOperateService;
import com.bat.easyexcel.util.ExcelOperateUtil;
import com.bat.easyexcel.util.ExportExcelStyleUtil;
import com.bat.easyexcel.util.TempExcelDataUtil;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 * Excel 导出接口
 *
 * @author ZhengYu
 * @version 1.0 2019/6/18 14:40
 **/
@Service
public class EasyEasyExcelOperateServiceImpl implements EasyExcelOperateService {

    /**
     * 导入数据
     *
     * @param filePath 文件路径
     * @author ZhengYu
     */
    @Override
    public void importWithExcel(String filePath) {

    }

    /**
     * 导出数据
     *
     * @param response 响应体
     * @author ZhengYu
     */
    @Override
    public void exportWithExcel(HttpServletResponse response) {
        try {
//            File file = new File("D:\\testExport.xlsx");
//            if (!file.exists()) {
//                boolean newFileFlag = file.createNewFile();
//                if (!newFileFlag) {
//                    System.out.println("出错");
//                }
//            }
//            OutputStream out = new FileOutputStream(file);
            String fileName = "导出测试";
            ExcelOperateUtil.writeExcel(new GenerateExportParam(getOutputStream(fileName, response), new ArrayList<GenerateExportData>() {{
                add(new GenerateExportData("测试Sheet", ExportDTO.class, TempExcelDataUtil.getExportTestData(50), ExportExcelStyleUtil.createColumnWidthMap(6), null));
            }}));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static OutputStream getOutputStream(String fileName, HttpServletResponse response) {
        //创建本地文件
        String filePath = fileName + ".xlsx";
        File dbfFile = new File(filePath);
        try {
            if (!dbfFile.exists() || dbfFile.isDirectory()) {
                dbfFile.createNewFile();
            }
            fileName = new String(filePath.getBytes(), StandardCharsets.ISO_8859_1);
            response.addHeader("Content-Disposition", "filename=" + fileName);
            return response.getOutputStream();
        } catch (IOException e) {
            throw new ExcelOperateException("创建文件失败！");
        }
    }
}
