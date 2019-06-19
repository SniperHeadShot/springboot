package com.bat.easyexcel.util;

import com.alibaba.excel.metadata.Font;
import com.alibaba.excel.metadata.TableStyle;
import org.apache.poi.ss.usermodel.IndexedColors;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * 导出的样式工具类
 *
 * @author ZhengYu
 * @version 1.0 2019/6/19 11:25
 **/
public class ExportExcelStyleUtil {

    /**
     * 创建默认列宽
     *
     * @param columnNum 列数
     * @return java.util.Map<java.lang.Integer       ,       java.lang.Integer>
     * @author ZhengYu
     */
    public static Map<Integer, Integer> createColumnWidthMap(int columnNum) {
        Map<Integer, Integer> result = new HashMap<>(columnNum);
        IntStream.range(0, columnNum).forEach(column -> result.put(column, 10000));
        return result;
    }

    /**
     * 表格整体样式
     *
     * @return com.alibaba.excel.metadata.TableStyle
     * @author ZhengYu
     */
    public static TableStyle createTableStyle() {
        TableStyle tableStyle = new TableStyle();
        Font headFont = new Font();
        // 字体加粗
        headFont.setBold(true);
        // 字体大小
        headFont.setFontHeightInPoints((short) 18);
        // 字体
        headFont.setFontName("楷体");
        tableStyle.setTableHeadFont(headFont);
        // 设置单元格背景颜色
        tableStyle.setTableHeadBackGroundColor(IndexedColors.BLUE);

        Font contentFont = new Font();
        contentFont.setBold(true);
        contentFont.setFontHeightInPoints((short) 14);
        contentFont.setFontName("黑体");
        tableStyle.setTableContentFont(contentFont);
        tableStyle.setTableContentBackGroundColor(IndexedColors.WHITE1);
        return tableStyle;
    }
}
