package com.niopackage.part1;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadingFileClubbedLegacyWithNio {

	public static void main(String[] args) throws IOException {

		// mention the path of the file
		Path path = Paths.get("E:/Files/test1.txt");
		// path.tofile returns file from java.io package
		File f1 = path.toFile();
		// Read File with the help of Path
		// use buffer reader from java.io
//		BufferedReader reader = Files.newBufferedReader(path);
//		String s = null;
//		while ((s = reader.readLine()) != null) {
//			System.out.println(s);
//		}

		// you can also mention the content format in file like below
//		BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8);
//		String s = null;
//		while ((s = reader.readLine()) != null) {
//			System.out.println(s);
//		}

		// we can use charset abstract class
		// use forname method and set the character format also
//		BufferedReader reader = Files.newBufferedReader(path, Charset.forName("UTF-8"));
//		String s = null;
//		while ((s = reader.readLine()) != null) {
//			System.out.println(s);
//		}

		// note that the character set should be correct
		// anything wrong in that will throw this exception
		BufferedReader reader = Files.newBufferedReader(path, Charset.forName("UTF 8"));
		String s = null;
		while ((s = reader.readLine()) != null) {
			System.out.println(s);
		}
	}
}
