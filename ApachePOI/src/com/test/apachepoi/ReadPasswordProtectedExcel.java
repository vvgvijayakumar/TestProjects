package com.test.apachepoi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadPasswordProtectedExcel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		String excepPath = ".\\datafiles\\customers.xlsx";

		// File Input stream to read the data

		FileInputStream input = new FileInputStream(excepPath);

		String password = "test123";

		XSSFWorkbook xssfw = (XSSFWorkbook) WorkbookFactory.create(input, password);

		// Get sheet by name
		XSSFSheet sheet = xssfw.getSheet("customers");

		// Get sheet by index
		XSSFSheet sheet1 = xssfw.getSheetAt(0);

		int rows = sheet.getLastRowNum();

		System.out.println(rows);

		int cols = sheet.getRow(1).getLastCellNum();

		System.out.println(cols);

		for (int r = 0; r <= rows; r++) {

			XSSFRow row = sheet.getRow(r);
			for (int c = 0; c < cols; c++) {
				XSSFCell cellvalue = row.getCell(c);

				switch (cellvalue.getCellType()) {

				case STRING:
					System.out.print(cellvalue.getStringCellValue());
					break;
				case NUMERIC:
					System.out.print(cellvalue.getNumericCellValue());
					break;
				case BOOLEAN:
					System.out.print(cellvalue.getBooleanCellValue());
					break;

				}

				System.out.print("|");

			}
			System.out.println();
		}

		xssfw.close();
		input.close();

	}

}
