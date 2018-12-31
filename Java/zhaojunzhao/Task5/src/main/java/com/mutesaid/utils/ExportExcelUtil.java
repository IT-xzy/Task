package com.mutesaid.utils;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.mutesaid.pojo.Element;
import com.mutesaid.pojo.PerformanceTree;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;

import java.lang.reflect.Method;
import java.util.ArrayList;

/* Spring Beans 包 */
public class ExportExcelUtil {
    // 表头
    private static final String[] TITLE = {"一级指标", "分值", "二级指标", "分值", "三级指标", "分值", "四级指标", "指标解释", "指标计划值", "实际完成值", "评价标准", "分值", "得分", "差异"};
    // 列宽
    private static final Integer[] WIDTH = {10, 6, 10, 6, 10, 6, 10, 26, 12, 12, 26, 6, 6, 6};
    // 前三级指标字段
    private static final String[] PROPERTIES = {"Name", "Grade"};
    // 四级指标字段
    private static final String[] FOURTH_PROPERTIES = {"Name", "Explain", "Expect", "Actual", "Standard", "Grade", "ActualGrade"};

    private static XSSFWorkbook wb;
    private static XSSFSheet sheet;
    private static XSSFCellStyle contentCellStyle;
    private static XSSFCellStyle failedCellStyle;
    private static XSSFRow[] rowList;

    // 初始化样式
    static {
        wb = new XSSFWorkbook();
        sheet = wb.createSheet("sheet1");

        for (int i = 0; i < WIDTH.length; i++) {
            // 每列列宽固定
            int cellWidth = WIDTH[i] * 256;
            sheet.setColumnWidth(i, cellWidth);
        }
        // 初始化样式
        XSSFCellStyle titleCellStyle = wb.createCellStyle();
        contentCellStyle = wb.createCellStyle();
        failedCellStyle = wb.createCellStyle();
        // 水平、垂直居中
        titleCellStyle.setAlignment(HorizontalAlignment.CENTER);
        titleCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        contentCellStyle.setAlignment(HorizontalAlignment.CENTER);
        contentCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        failedCellStyle.setAlignment(HorizontalAlignment.CENTER);
        failedCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        // 表头背色
        titleCellStyle.setFillForegroundColor((short) 22);
        titleCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        contentCellStyle.setFillForegroundColor((short) 1);
        contentCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        failedCellStyle.setFillForegroundColor((short) 13);
        failedCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        // 自动换行
        titleCellStyle.setWrapText(true);
        contentCellStyle.setWrapText(true);
        failedCellStyle.setWrapText(true);
        // 字体(宋体 10号)
        XSSFFont titleFont = wb.createFont();
        titleFont.setFontName("宋体");
        titleFont.setFontHeightInPoints((short) 10);
        titleFont.setBold(true);
        titleCellStyle.setFont(titleFont);
        XSSFFont contentFont = wb.createFont();
        contentFont.setFontName("宋体");
        contentFont.setFontHeightInPoints((short) 10);
        contentFont.setBold(false);
//      BeanUtils.copyProperties(contentFont, titleFont);
//
//        contentFont.setBold(false);
        contentCellStyle.setFont(contentFont);
        failedCellStyle.setFont(contentFont);
        // 表头内容
        XSSFRow rowTitle = sheet.createRow(1);
        for (int i = 0; i < TITLE.length; i++) {
            XSSFCell cellTitle = rowTitle.createCell(i);
            cellTitle.setCellValue(TITLE[i]);
            cellTitle.setCellStyle(titleCellStyle);
            // 合并单元格，合并单元格样式
            CellRangeAddress region = new CellRangeAddress(1, 2, i, i);
            sheet.addMergedRegion(region);
            setBorder(sheet, region);
        }
    }

    /* 合并单元格边框 */
    private static void setBorder(XSSFSheet sheet, CellRangeAddress region) {
        // 下边框
        RegionUtil.setBorderBottom(BorderStyle.THICK, region, sheet);
        RegionUtil.setBottomBorderColor(0, region, sheet);
        // 右边框
        RegionUtil.setBorderRight(BorderStyle.THICK, region, sheet);
        RegionUtil.setRightBorderColor(0, region, sheet);
        // 上边框
        RegionUtil.setBorderTop(BorderStyle.THICK, region, sheet);
        RegionUtil.setTopBorderColor(0, region, sheet);
        // 左边框
        RegionUtil.setBorderLeft(BorderStyle.THICK, region, sheet);
        RegionUtil.setLeftBorderColor(0, region, sheet);
    }

    /**
     * 单元格边框
     */
    private static void setCellBorder(XSSFCell cell, XSSFCellStyle cellStyle) {
        // 下边框
        cellStyle.setBorderBottom(BorderStyle.THICK);
        cellStyle.setBottomBorderColor((short) 0);
        // 右边框
        cellStyle.setBorderRight(BorderStyle.THICK);
        cellStyle.setRightBorderColor((short) 0);
        // 上边框
        cellStyle.setBorderTop(BorderStyle.THICK);
        cellStyle.setTopBorderColor((short) 0);
        // 左边框
        cellStyle.setBorderLeft(BorderStyle.THICK);
        cellStyle.setLeftBorderColor((short) 0);
    }

    /* 合并单元格 */
    private static void merge(int firstRow, int lastRow, int firstCol, int lastCol) {
        CellRangeAddress region = new CellRangeAddress(firstRow, lastRow, firstCol, lastCol);
        sheet.addMergedRegion(region);
        setBorder(sheet, region);
    }

    /**
     * 写入数据
     *
     * @param performances 根节点数组
     * @param row          开始写入的行数
     * @param separated    列的偏移数
     */
    private static void setData(ArrayList<Element> performances, int row, int separated) {
        // 遍历所有根节点
        for (int i = 0; i < performances.size(); i++) {
            // 每次从根节点深入，写入数据的列数都要偏移，同级的根节点还要从相同的地方写入
            int flag = separated;
            Element element = performances.get(i);
            // 获取当前根节点的所有叶子节点，做合并单元格用
            ArrayList treeList = new ArrayList();
            PerformanceTree.getTreeList(element, treeList);
            int height = treeList.size();
            try {
                // time记录写入多少次数据，即列的偏移量
                int time = 0;
                // 判断是否是叶子节点
                // 四级节点和前三级节点遍历不同的属性
                if (height == 0) {
                    // 标记成绩是否达标
                    int flag2 = 0;
                    if (element.getActualGrade() != null && element.getActualGrade() < element.getGrade()) {
                        flag2 = 1;
                    }

                    for (int j = 0; j < FOURTH_PROPERTIES.length; j++) {
                        Method m = element.getClass().getMethod("get" + FOURTH_PROPERTIES[j]);
                        Object value = m.invoke(element);
                        if (value != null) {
                            if (rowList[row + i] == null) {
                                rowList[row + i] = sheet.createRow(row + i);
                            }
                            XSSFCell cellContent = rowList[row + i].createCell(j + separated);
                            if (flag2 == 1) {
                                cellContent.setCellStyle(failedCellStyle);
                                cellContent.setCellValue(value.toString());
                                setCellBorder(cellContent, failedCellStyle);
                            } else {
                                cellContent.setCellStyle(contentCellStyle);
                                cellContent.setCellValue(value.toString());
                                setCellBorder(cellContent, contentCellStyle);
                            }
                            time++;
                        }
                    }
                } else {
                    for (int j = 0; j < PROPERTIES.length; j++) {
                        Method m = element.getClass().getMethod("get" + PROPERTIES[j]);
                        Object value = m.invoke(element);
                        if (value != null) {
                            if (rowList[row] == null) {
                                rowList[row] = sheet.createRow(row);
                            }
                            XSSFCell cellContent = rowList[row].createCell(j + separated);
                            cellContent.setCellStyle(contentCellStyle);
                            cellContent.setCellValue(value.toString());
                            // 单行不用合并单元格
                            if (height < 2) {
                                setCellBorder(cellContent, contentCellStyle);
                            }
                            time++;
                        }
                    }
                }
                separated += time;
                // 递归调用该节点下的子节点
                setData(element.getChrildren(), row, separated);
                // 复原偏移量
                separated = flag;
            } catch (Exception e) {
                e.printStackTrace();
            }
            row += height;
        }
    }

    public static void mergeCell(ArrayList<Element> performances, int row, int separated) {
        for (int i = 0; i < performances.size(); i++) {
            int flag = separated;
            Element element = performances.get(i);
            ArrayList treeList = new ArrayList();
            PerformanceTree.getTreeList(element, treeList);
            int height = treeList.size();
            // 判断是否是叶子节点
            try {
                int time = 0;
                // 判断是否需要合并单元格
                if (height > 0) {
                    for (int j = 0; j < PROPERTIES.length; j++) {
                        Method m = element.getClass().getMethod("get" + PROPERTIES[j]);
                        Object value = m.invoke(element);
                        if (value != null) {
                            if (height > 1) {
                                merge(row, row + height - 1, j + separated, j + separated);
                            }
                            time++;
                        }
                    }
                }
                separated += time;
                mergeCell(element.getChrildren(), row, separated);
                separated = flag;
            } catch (Exception e) {
                e.printStackTrace();
            }
            row += height;
        }
    }

    public static XSSFWorkbook getWb(ArrayList<Element> performances, String sheetName) {
        wb.setSheetName(0, sheetName);
        // 每行的 XSSFRow 只能创建一次
        ArrayList<Element> children = new ArrayList<>();
        for (Element element : performances) {
            PerformanceTree.getTreeList(element, children);
        }
        rowList = new XSSFRow[children.size() + 3];
        setData(performances, 3, 0);
        mergeCell(performances, 3, 0);
        return wb;
    }
}
