package com.bat.easyexcel.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 导出类映射实体
 *
 * @author ZhengYu
 * @version 1.0 2019/6/18 14:39
 **/
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class ExportDTO extends BaseRowModel implements Serializable {

    @ExcelProperty(index = 0, value = "序号")
    private Integer number;

    @ExcelProperty(index = 1, value = "姓名")
    private String username;

    @ExcelProperty(index = 2, value = "性别")
    private String sex;

    @ExcelProperty(index = 3, value = "生日", format = "yyyy-MM-dd")
    private String birthday;

    @ExcelProperty(index = 4, value = "电话")
    private String phone;

    @ExcelProperty(index = 5, value = "住址")
    private String address;
}
