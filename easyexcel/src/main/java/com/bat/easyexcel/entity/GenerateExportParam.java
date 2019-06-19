package com.bat.easyexcel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.OutputStream;
import java.util.List;

/**
 * EasyExcel 导入导出 通用参数实体类
 *
 * @author ZhengYu
 * @version 1.0 2019/6/19 10:09
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GenerateExportParam {

    private OutputStream outputStream;

    private List<GenerateExportData> exportData;
}
