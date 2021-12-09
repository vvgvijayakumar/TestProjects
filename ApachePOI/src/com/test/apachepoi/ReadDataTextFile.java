package com.test.apachepoi;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadDataTextFile {

	public static void main(String[] args) throws IOException {

		// Approach 1 : Usinf FileReader and BufferReader Class

		FileReader fread = new FileReader(".\\Testdemo.txt");

		BufferedReader br = new BufferedReader(fread);

		String str;

		while ((str = br.readLine()) != null) {

			System.out.println(str);

		}

		br.close();

	}

}
