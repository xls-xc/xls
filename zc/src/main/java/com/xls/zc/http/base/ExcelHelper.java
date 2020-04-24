/*
package com.xls.zc.http.base;


import jxl.Workbook;
import jxl.write.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.List;

*/
/**
 * @copyright
 * @license    
 * @link       
 *
 * 导出Excel文件类
 * 
 * @author zxy
 * Created 2017/4/13 11:07
 *//*

public class ExcelHelper {

    private WritableWorkbook wwb = null;
    private Workbook wb = null;
    private WritableSheet ws = null;
    private ByteArrayOutputStream outStream =new ByteArrayOutputStream();
    private WritableCellFormat wcf = null;

    */
/**
     * 构造方法，创建空的excel表，默认读取第一个sheet
     *//*

    public ExcelHelper(){
        try{
            wwb = Workbook.createWorkbook(outStream);
            wwb.createSheet("sheet1", 1);
            ws = wwb.getSheet(0);
            WritableFont wfont = new WritableFont(WritableFont.createFont("宋体"), 12);
            wcf = new WritableCellFormat(wfont);
            // 设置居中
            wcf.setAlignment(jxl.format.Alignment.CENTRE);
            // 设置单元格的背景颜色
            wcf.setBackground(jxl.format.Colour.BLACK);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    */
/**
     * 构造方法,根据输入流，初始化Excel，默认读取第一个sheet
     * @param is
     *//*

    public ExcelHelper(InputStream is) {
        try {
            wb = Workbook.getWorkbook(is);
            wwb = Workbook.createWorkbook(outStream, wb);
            WritableFont wfont = new WritableFont(WritableFont.createFont("宋体"), 12);
            wcf = new WritableCellFormat(wfont);
            // 设置居中
            wcf.setAlignment(jxl.format.Alignment.CENTRE);
            // 设置单元格的背景颜色
            wcf.setBackground(jxl.format.Colour.BLACK);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    */
/**
     * 设置样式
     *//*

    public void setCellFormat(){

    }
    */
/**
     * 设置当前操作sheet名称
     * @param sheetName
     *//*

    public void setSheetName(String sheetName){
        ws.setName(sheetName);
    }
    */
/**
     * 创建新的sheet，并把操作定位到当前sheet
     * @param sheetName
     *//*

    public void createSheet(String sheetName){
        int t=wwb.getNumberOfSheets();
        try {
            wwb.createSheet(sheetName, t);
            ws=wwb.getSheet(t);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    */
/**
     * 设置当前操作sheet，如果不存在，创建新的sheet
     * @param sheetNum
     *//*

    public void setSheet(int sheetNum){
        if(sheetNum>=wwb.getNumberOfSheets()){
            int t=wwb.getNumberOfSheets();
            try {
                wwb.createSheet("sheet"+t, t);
                ws=wwb.getSheet(t);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            ws = wwb.getSheet(sheetNum);
        }
    }
    */
/**
     * 返回sheet数
     * @return
     *//*

    public int getNumberOfSheets(){
        return wwb.getNumberOfSheets();
    }
    */
/**
     * 返回当前sheet行数
     * @return int
     *//*

    public int getRows(){
        return ws.getRows();
    }

    */
/**
     * 返回当前sheet列数
     * @return int
     *//*

    public int getColumns(){
        return ws.getColumns();
    }
    */
/**
     * 合并单元格
     * @param col1
     * @param row1
     * @param col2
     * @param row2
     *//*

    public void mergeCells(int col1,int row1,int col2,int row2){
        try {
            ws.mergeCells(col1, row1, col2, row2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    */
/**
     * 设置单元格大小，width、height为0则不做修改
     * @param col
     * @param row
     * @param width
     * @param height
     *//*

    public void setCellSize(int col,int row,int width,int height){
        try {
            ws.setColumnView(col, width);
            ws.setRowView(row, height);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    */
/**
     * 删除行
     * @param row
     *//*

    public void removeRow(int row){
        try {
            ws.removeRow(row);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    */
/**
     * 删除列
     * @param col
     *//*

    public void removeColumn(int col){
        try {
            ws.removeColumn(col);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    */
/**
     * 设置Header
     * @param header
     *//*

    public void setHeader(String[] header){
        try {
            for(int j=0; j<header.length; j++){
                this.addCell(j, 0, header[j]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    */
/**
     * 增加Row
     * @param dataList
     *//*

    public void addRow(List<String[]> dataList){
        try {
            for(int i=0; i<dataList.size();i++){
                for(int j=0; j<dataList.get(i).length; j++){
                    this.addCell(j, i+1, dataList.get(i)[j]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    */
/**
     * 增加Cell
     * @param col
     * @param row
     * @param str
     *//*

    public void addCell(int col,int row,String str){
        try {
            ws.addCell(new Label(col,row,str));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    */
/**
     * 增加Cell，设置字大小
     * @param col
     * @param row
     * @param str
     * @param size
     *//*

    public void addCell(int col,int row,String str,int size){
        WritableCellFormat wcf=new WritableCellFormat(new WritableFont(WritableFont.ARIAL,size));
        try {
            ws.addCell(new Label(col,row,str,wcf));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    */
/**
     * 写Excel
     *//*

    public void write(){
        try{
            wwb.write();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    */
/**
     * 返回输出
     * @return ByteArrayOutputStream
     *//*

    public ByteArrayOutputStream outExcel(){
        try{
            if(wb!=null){
                wb.close();
            }
            if(wwb!=null){
                wwb.close();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return outStream;
    }
    */
/**
     * 创建Excel
     * @param response
     * @param fileName
     * @throws Exception
     *//*

    public void createExcel(HttpServletResponse response, String fileName) throws Exception {
        if (fileName==null || fileName.length()<=0) {
            fileName = ShopHelper.getCurrentTimestamp().toString();
        }
        ByteArrayOutputStream outStream = this.outExcel();
        response.reset();
        response.setContentType("application/x-msdownload");
        response.setHeader("Content-Disposition", "attachment;   filename=" + new String((fileName+".xls").getBytes(), "iso8859-1"));
        ServletOutputStream sos = response.getOutputStream();
        outStream.writeTo(sos);
    }
}*/
