package com.test.apachepoi;

import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteDatatoExcel {

	// Workbook-Sheet-Rows-Cells
	public static void main(String[] args) throws IOException {

		// Creating a workbook object
		XSSFWorkbook workbook = new XSSFWorkbook();

		// Creating a Sheet
		XSSFSheet sheet = workbook.createSheet("TestWrite");

		// Creating a Object type two dimensional array(Heteregenous data)

		Object emp[][] = { { "EmpId", "Name", "Job" }, { 1, "Vinay", 101 }, { 2, "Anitha", 102 }, { 3, "Nayana", 103 }

		};

		int rows = emp.length;

		int cols = emp[0].length;

		for (int i = 0; i < rows; i++) {

			XSSFRow row = sheet.createRow(i);

			for (int j = 0; j < cols; j++) {

				XSSFCell cell = row.createCell(j);
				Object value = emp[i][j];

				if (value instanceof String) {
					cell.setCellValue((String) value);
				}
				if (value instanceof Integer) {
					cell.setCellValue((Integer) value);
				}
				if (value instanceof Boolean) {
					cell.setCellValue((Boolean) value);
				}

			}
		}

		System.out.println("No of Rows are " + rows + " and Cells are " + cols);

		// File Output Stream

		FileOutputStream fos = new FileOutputStream(".\\datafiles\\employee.xlsx");

		// Attaching the workbook to the fos object
		workbook.write(fos);

		// Closing workbook object
		workbook.close();

		// Closing fos object
		fos.close();
		
		System.out.println("Employee file created successfully");

	}

}
