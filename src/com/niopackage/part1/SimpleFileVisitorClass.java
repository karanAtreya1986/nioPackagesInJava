package com.niopackage.part1;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;

//extend simple file visitor to get its methods
public class SimpleFileVisitorClass extends SimpleFileVisitor<Path> {

	// Simple file visitor is a class.
	// It has four methods.
	// We need to extend simplefilevisitor class to get these methods:
	// preVisitDirectory – before doing anything on directory.
	// postVisitDirectory – after doing something on directory.
	// visitFile – files visited during the code run.
	// vistFileFailed – if visiting of file failed.

	// visit the file
	// pass in the location using path and the basic file attributes
	// delete the file
	// get the file name which is deleted
	// continue this operation until all files are visited and deleted

	public FileVisitResult visitFile(Path file, BasicFileAttributes attributes) throws IOException {
		Files.delete(file);
		System.out.println(file.getFileName() + " deleted.");
		return FileVisitResult.CONTINUE;
	}

	// same operation for all directories and sub directories
	// we are deleting them one by one
	// strange working, directories cannot be deleted if its not empty
	public FileVisitResult postVisitDirectory(Path directory, IOException ioe) throws IOException {
//		Files.deleteIfExists(directory);
		Files.delete(directory);
		System.out.println(directory.getFileName() + " directory deleted.");
		return FileVisitResult.CONTINUE;
	}

	public static void main(String[] args) throws IOException {

		/**
		 * There are two methods available in Files class using which we can delete
		 * files. The methods are delete(Path) and deleteIfExists(Path).
		 * deleteIfExists(Path) method does not throw exception when the file does not
		 * exists. It just fails silently. When we attempt to delete a directory, it
		 * should be empty to be deleted. Therefore we should delete all files and
		 * sub-directories that are inside a directory before deleting it.
		 */
		Path directoryPath = Paths.get("E:/", "Files");
		SimpleFileVisitorClass deleteVisitor = new SimpleFileVisitorClass();

		// use walkfiletree from files
		// pass in the directory path and the simple file visitor class to perform the
		// desired operations.
		Files.walkFileTree(directoryPath, deleteVisitor);
	}

}
