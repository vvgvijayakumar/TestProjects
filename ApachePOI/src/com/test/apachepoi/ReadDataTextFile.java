package com.test.apachepoi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ReadDataTextFile {

	public static void main(String[] args) throws IOException {

		// Approach 1 : Using FileReader and BufferReader Class

		// Location of text file
		FileReader fread = new FileReader(".\\Testdemo.txt");

		BufferedReader br = new BufferedReader(fread);

		String str;

		while ((str = br.readLine()) != null) {

			System.out.println(str);

		}

		br.close();

		System.out.println("----------------------");

		// Approach 2 : Using Scanner and File

		File file = new File(".\\Testdemo.txt");

		Scanner scan = new Scanner(file);

		String str1 = "";

//		while (scan.hasNextLine()) {
//
//			System.out.println(scan.nextLine());
//
//		}

		// Approach 3 :
		System.out.println("------------------");

		scan.useDelimiter("\\Z");
		System.out.println(scan.next());

	}

}
