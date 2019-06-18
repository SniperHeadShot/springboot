package com.bat.easyexcel.service.impl;

import com.bat.easyexcel.entity.ExportDTO;
import com.bat.easyexcel.service.ExportExcelService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Excel 导出接口
 *
 * @author ZhengYu
 * @version 1.0 2019/6/18 14:40
 **/
@Service
public class ExportExcelServiceImpl implements ExportExcelService {

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
     * @param exportDTOList 待导出数据
     * @author ZhengYu
     */
    @Override
    public void exportWithExcel(List<ExportDTO> exportDTOList) {

    }
}
