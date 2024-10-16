package com.niopackage.part1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CreateSubDirectoryUsingNio {

	public static void main(String[] args) throws IOException {

		// creates empty sub directories.
		Path p1 = Files.createDirectories(Paths.get("E:/Files/Tester2/Tester3/Tester4/Tester5"));
		System.out.println("directory created in path " + p1);
	}

}
