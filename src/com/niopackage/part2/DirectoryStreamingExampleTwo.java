package com.niopackage.part2;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DirectoryStreamingExampleTwo {
	// Search for all files with different extensions under a directory
	public static void main(String[] args) throws IOException {

		// Use directory stream. or
		// Create directory stream instance.
		DirectoryStream<Path> stream = null;

		// Path class object is created and location where to search, is mentioned as
		// parameter.
		Path dir = Paths.get("E:/");

		// Give type of files (extensions) you want to search.
		// Initialise directory stream. Give path of the directory and extensions to
		// search.
		stream = Files.newDirectoryStream(dir, "*.{java,txt,dmg,log,exe}");
		// Enhanced for loop. Print all file names.
		for (Path p : stream) {

			// Print those file names.
			System.out.println(p.getFileName());
		}
		// Close stream for better practice. Will close all objects if open.
		stream.close();

	}
}

// Directory stream can search at a directory level you specify. No recursive
// search can be done for sub folders and stuff.
//To go recursively into sub folders and files use simplefilevisitor and walkfiletree.