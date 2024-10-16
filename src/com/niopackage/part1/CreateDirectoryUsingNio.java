package com.niopackage.part1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CreateDirectoryUsingNio {

	public static void main(String[] args) throws IOException {

		// similar to create files
		// creates empty directory
		Path p1 = Files.createDirectories(Paths.get("E:/Files/Tester2"));
		System.out.println("directory created in path " + p1);
	}

}
