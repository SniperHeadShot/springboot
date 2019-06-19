package com.bat.easyexcel.service;

import javax.servlet.http.HttpServletResponse;

/**
 * Excel 导出接口
 *
 * @author ZhengYu
 * @version 1.0 2019/6/18 14:40
 **/
public interface ExcelOperateService {

    /**
     * 导入数据
     *
     * @param filePath 文件路径
     * @author ZhengYu
     */
    void importWithExcel(String filePath);

    /**
     * 导出数据
     *
     * @param response 响应体
     * @author ZhengYu
     */
    void exportWithExcel(HttpServletResponse response);
}
