package com.bat.easyexcel.service;

import com.bat.easyexcel.entity.ExportDTO;

import java.util.List;

/**
 * Excel 导出接口
 *
 * @author ZhengYu
 * @version 1.0 2019/6/18 14:40
 **/
public interface ExportExcelService {

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
     * @param exportDTOList 待导出数据
     * @author ZhengYu
     */
    void exportWithExcel(List<ExportDTO> exportDTOList);
}
