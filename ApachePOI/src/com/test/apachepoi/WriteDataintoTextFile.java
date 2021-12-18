package com.test.apachepoi;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteDataintoTextFile {

	public static void main(String[] args) throws IOException {
		
		FileWriter fw = new FileWriter(".\\datafiles\\writeText.txt");
		
		BufferedWriter bw = new BufferedWriter(fw);
		
		bw.write("Hello World\n");
		bw.write("Hello Selenim\n");
		bw.write("Hello Selenim Cucumber");
		
		bw.close();

	}

}
