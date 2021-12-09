package com.test.apachepoi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadFormulaCellData {

	public static void main(String[] args) throws IOException {

		String excelpath = ".\\datafiles\\readformula.xlsx";

		// Reading File
		FileInputStream fis = new FileInputStream(excelpath);

		// Extract Workbook
		XSSFWorkbook xssf = new XSSFWorkbook(fis);

		// Extract Sheet
		XSSFSheet sheet = xssf.getSheetAt(0);

		int rows = sheet.getLastRowNum();

		System.out.println(rows);

		int cols = sheet.getRow(0).getLastCellNum();

		System.out.println(cols);

		for (int r = 0; r < rows; r++) {

			XSSFRow row = sheet.getRow(r);

			for (int c = 0; c < cols; c++) {

				XSSFCell cell = row.getCell(c);
				switch (cell.getCellType()) {
				case STRING:
					System.out.print(cell.getStringCellValue());
					break;
				case NUMERIC:
					System.out.print(cell.getNumericCellValue());
					break;
				case BOOLEAN:
					System.out.print(cell.getBooleanCellValue());
					break;
				case FORMULA:
					System.out.print(cell.getNumericCellValue());
					break;
				}

				System.out.print("|");

			}

			System.out.println();

		}

		fis.close();

	}

}
