package com.niopackage.part1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DeleteDirectoryUsingNio {

	public static void main(String[] args) throws IOException {

		// give the directory path
		// directory should not have sub directories
		// directory should not have files
		// directory should be empty to be deleted
		Path p2 = Paths.get("E:/Files/Test3");
		Files.delete(p2);
		System.out.println("directory is deleted " + p2);
	}

}
