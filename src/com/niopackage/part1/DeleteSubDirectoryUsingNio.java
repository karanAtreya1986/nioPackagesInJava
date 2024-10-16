package com.niopackage.part1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DeleteSubDirectoryUsingNio {

	public static void main(String[] args) throws IOException {

		// it will only delete the last sub directory not the others.
		Path p2 = Paths.get("E:/Files/Tester2/Tester3/Tester4/Tester5");
		Files.delete(p2);
		System.out.println("directory is deleted " + p2);
	}

}
