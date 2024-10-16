package com.niopackage.part1;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AboutNioClassesAndUses {

	public static void main(String[] args) throws IOException {

		// Path is interface.
		// Paths is class implementing that path interface.
		// Path and paths deals with file locations only.

		// mention path of file
		Path path = Paths.get("E:/Files/test1.txt");
		// get the file name
//		System.out.println(path.getFileName());
		// what type of file system -- not of much use
//		System.out.println(path.getFileSystem());
		// directory under which the file is present
//		System.out.println(path.getParent());
		// grand parent of the file
//		System.out.println(path.getRoot());

		// nio clubbed with io
		File f1 = path.toFile();
//		System.out.println(f1.getAbsolutePath());

		// how to use buffer reader from the java io package.
		// clubbed with nio package
//		BufferedReader bReader = Files.newBufferedReader(path);
//		String str = null;
//		while ((str = bReader.readLine()) != null) {
//			System.out.println(str);
//		}

		// specify the type of characters you want to read
//		BufferedReader bReader = Files.newBufferedReader(path, StandardCharsets.UTF_8);
//		String str = null;
//		while ((str = bReader.readLine()) != null) {
//			System.out.println(str);
//		}

		// create files directly using createfile method
		// pass in the location where you want to create
		// pass in the name of the file with extension
		// use files class
//		Path p1 = Files.createFile(Paths.get("E:/Files/tester1111.pdf"));
//		System.out.println("file created in path " + p1);

		// best part in nio
		// In nio package, we can directly print values of paths class variable and
		// other variables created of other file classes. This will not return memory
		// address but it will return the actual value.

		// create directories
		// using another way to write the paths.
//		Path p2 = Files.createDirectory(Paths.get("E:/", "Tester2222"));
//		System.out.println("directory created at location " + p2);

		// create sub directories
		// use createdirectories not create directory
		// this will keep adding the sub directories
//		Path p2 = Files.createDirectories(Paths.get("E:/", "Tester2222/t1/t2/t3/t4"));
//		System.out.println("directory created at location " + p2);

		// we get no such file exception when using create directory for creating
		// multiple directories.
//		Path p2 = Files.createDirectory(Paths.get("E:/", "t6/t7/t8/t9"));
//		System.out.println("directory created at location " + p2);

		// delete directories
		// only last sub directory deleted
		// directories have to be empty for it to be deleted
		Path p3 = Files.createDirectories(Paths.get("E:/", "t6/t7/t8/t9"));
		Files.delete(p3);
		System.out.println("deleted directories ");
	}

}
