package com.niopackage.part1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.FileTime;

public class BasicFileAttributesExampleThree {

	// To access more properties and methods for the file classes.

	public static void main(String[] args) throws IOException {

		// in path give the folder name and the file name to work on.
		Path path = Paths.get("E:/Tester2", "ewrwerwer.rtf");
		// to access all attributes of the file in this class, we need to define this.
		BasicFileAttributeView basicFileAttributeView = Files.getFileAttributeView(path, BasicFileAttributeView.class);
		// to read all existing attributes in the file, so we can start using them.
		java.nio.file.attribute.BasicFileAttributes attributes = basicFileAttributeView.readAttributes();

		FileTime lastAccessTime = attributes.lastAccessTime();
		System.out.println("Last access time of the file was " + lastAccessTime);
		FileTime lastModifiedTime = attributes.lastModifiedTime();
		System.out.println("Last Modified time of the file was " + lastModifiedTime);
		FileTime creationTime = attributes.creationTime();
		System.out.println("Creation Time of the file was " + creationTime);
	}
//very important notes in nio.
//We can directly print out the FileTime objects without needing to use the new keyword. 
//It will print the value not the memory address.
}
