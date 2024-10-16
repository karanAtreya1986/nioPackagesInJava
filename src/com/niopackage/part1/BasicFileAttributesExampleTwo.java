package com.niopackage.part1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.FileTime;

public class BasicFileAttributesExampleTwo {

	public static void main(String[] args) throws IOException {

		// BasicFileAttributeView – works on windows, Linux but not for mac.
		// Java.nio only works with 1.7 and above.
		Path p1 = Paths.get("E:/Files/abc.txt");
		// we specify this step so that all attributes can be read by this class
		BasicFileAttributeView bView = Files.getFileAttributeView(p1, BasicFileAttributeView.class);
		// this is reading all the attributes and storing in a variable.
		java.nio.file.attribute.BasicFileAttributes basicAttr = bView.readAttributes();

		// using basicattr now access all properties
		FileTime filecreationTime = basicAttr.creationTime();
		System.out.println("Creation time of the file is " + filecreationTime);

		FileTime lastAccessTime = basicAttr.lastAccessTime();
		System.out.println("Last access time of the file was " + lastAccessTime);

		FileTime lastModifiedTime = basicAttr.lastModifiedTime();
		System.out.println("Last Modified time of the file was " + lastModifiedTime);

	}

}
