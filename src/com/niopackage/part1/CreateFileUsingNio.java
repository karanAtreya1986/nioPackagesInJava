package com.niopackage.part1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CreateFileUsingNio {

	public static void main(String[] args) throws IOException {

		// using files.createfile -- pass in the path where the file is to be created
		// it returns path.
		// empty file is created.
		Path p1 = Files.createFile(Paths.get("E:/Files/tester1.txt"));
	}

}
