package com.niopackage.part1;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LegacyFileSystemClubbedWithNio {

	public static void main(String[] args) {

		// mention the path of the file
		Path path = Paths.get("E:/Files/test1.txt");
		// path.tofile returns file from java.io package
		File f1 = path.toFile();
		// gets the complete path from root directory of the file
		System.out.println(f1.getAbsoluteFile());
	}
}
