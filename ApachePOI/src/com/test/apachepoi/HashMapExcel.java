package com.test.apachepoi;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class HashMapExcel {

	public static void main(String[] args) throws IOException {

		XSSFWorkbook xssw = new XSSFWorkbook();

		XSSFSheet sheet = xssw.createSheet("student data");

		Map<String, String> hmap = new HashMap<String, String>();

		hmap.put("101", "John");
		hmap.put("102", "John");
		hmap.put("103", "Naina");
		hmap.put("104", "Chinmay");

		int rowno = 0;

		for (Map.Entry entry : hmap.entrySet()) {

			XSSFRow row = sheet.createRow(rowno);

			row.createCell(0).setCellValue((String) entry.getKey());
			row.createCell(1).setCellValue((String) entry.getValue());

			rowno++;

		}

		FileOutputStream fos = new FileOutputStream(".\\datafiles\\student.xlsx");
		xssw.write(fos);

		xssw.close();
		fos.close();
		System.out.println("Excel written successfully");

	}

}
