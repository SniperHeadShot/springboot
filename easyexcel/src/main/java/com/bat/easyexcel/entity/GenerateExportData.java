package com.bat.easyexcel.entity;

import com.alibaba.excel.metadata.BaseRowModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * EasyExcel 导入导出 通用数据对象实体类
 *
 * @author ZhengYu
 * @version 1.0 2019/6/19 10:25
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GenerateExportData {

    private String sheetName;

    private Class clazz;

    private List<? extends BaseRowModel> exportData;

    private Map<Integer, Integer> columnWidthMap;

    private List<List<String>> head;

    /**
     * 生成默认的表头
     *
     * @return java.util.List<java.util.List       <       java.lang.String>>
     * @author ZhengYu
     */
    public List<List<String>> getExportExcelHead() {
//        List<String> singleRowValue = new ArrayList<>();
//        Arrays.stream(clazz.getDeclaredFields()).forEach(field -> {
//            ExcelProperty excelProperty = field.getAnnotation(ExcelProperty.class);
//            System.out.println(Arrays.toString(excelProperty.value()));
//        });
        // TODO 利用反射获取注解名称

        return new ArrayList<List<String>>() {{
            add(new ArrayList<String>() {{
                add("序号");
                add("姓名");
                add("性别");
                add("生日");
                add("电话");
                add("住址");
            }});
        }};
    }
}
