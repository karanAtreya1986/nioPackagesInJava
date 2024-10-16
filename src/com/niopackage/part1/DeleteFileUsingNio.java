package com.niopackage.part1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DeleteFileUsingNio {

	public static void main(String[] args) throws IOException {

		// give the path of the file
		Path p2 = Paths.get("E:/Files/Tester1.txt");
		// use delete from files and pass in the path
		Files.delete(p2);
		System.out.println("file is deleted " + p2);
	}

}
