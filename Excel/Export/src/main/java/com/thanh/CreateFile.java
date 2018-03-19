package com.thanh;/*
  By Chi Can Em  19-03-2018
 */

import com.thanh.mode.Customer;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CreateFile {
    private static HSSFCellStyle createStyleForTitle(HSSFWorkbook workbook) {
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        HSSFCellStyle style = workbook.createCellStyle();
        style.setFont(font);
        return style;
    }

    public static void main(String[] args) throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        //set name hien thi file
        HSSFSheet sheet = workbook.createSheet("customer's GST number");

        //list du lieu can export
        List<Customer> customers = new ArrayList<Customer>();
        //customers = CustomerDao.getList();
        Customer customer = new Customer();
        customer.setId("1");
        customer.setName("name");
        customer.setGst("gst");
        customers.add(customer);

        //set rownum bat dau
        int rownum = 0;
        Cell cell;
        Row row;
        HSSFCellStyle style = createStyleForTitle(workbook);
        row = sheet.createRow(rownum);
            // set name va kieu du lieu cac cot
        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue("Customer No");
        cell.setCellStyle(style);

        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue("Customer Name");
        cell.setCellStyle(style);

        cell = row.createCell(2, CellType.STRING);
        cell.setCellValue("GST Number");
        cell.setCellStyle(style);

        // vong lap de dien du lieu vao
        for (Customer customer1 : customers) {
            // song 1 dong
            rownum++;
            row = sheet.createRow(rownum);
            // them du lieu
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue(customer1.getId());

            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue(customer1.getName());

            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue(customer1.getGst());
        }
        // set duong dan file export
        File file = new File("D:/XI-5381.xls");

        // get duong dan chuan
        file.getParentFile().mkdirs();
        // tao mot FileOutputStream
        FileOutputStream outFile = null;
        try {

            // truyen duong dan export file
            outFile = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //export file
        workbook.write(outFile);
        System.out.println("Created file: " + file.getAbsolutePath());
    }
}
