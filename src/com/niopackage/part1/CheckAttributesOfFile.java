package com.niopackage.part1;

import java.nio.file.Path;
import java.nio.file.Paths;

public class CheckAttributesOfFile {

	public static void main(String[] args) {

		// mention the path of the file
		Path path = Paths.get("E:/Files/test1.txt");
		// Print the path attributes
		// get the file name
		System.out.println(path.getFileName());
		// what type of file system -- not of much use
		System.out.println(path.getFileSystem());
		// directory under which the file is present
		System.out.println(path.getParent());
		// grand parent of the file
		System.out.println(path.getRoot());
	}
}
