package com.niopackage.part2;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

import com.niopackage.part1.SimpleFileVisitorClass;

//Java has given simpleFileVisitor() api.
//Extend it.
//You get pre-defined methods like –
//preVisitDirectory()
//postVisitDirectory()
//visitFile()
//visitFileFailed()
//walkFileTree() method is present and is given by java. With this method also, 
//you can access all the above four methods.

//Extend simplefilevisitor and it takes in path as argument.
//Path is interface.
public class DirectoryDeleteUsingSimpleFileVisitor extends SimpleFileVisitor<Path> {

	// Visitfile is the method. Takes in path and basicfileattributes. If file is
	// encountered, delete it from the path. Printout the deleted file name in
	// console. Keep continuing the operation recursively.
	public FileVisitResult visitFile(Path file, BasicFileAttributes attributes) throws IOException {
		Files.delete(file);
		System.out.println(file.getFileName() + " deleted.");
		return FileVisitResult.CONTINUE;
	}

	// Another method – postvisitdirectory. Give path and ioexception object. Same
	// operation as files.
	public FileVisitResult postVisitDirectory(Path directory, IOException ioe) throws IOException {
		Files.delete(directory);
		System.out.println(directory.getFileName() + " directory deleted.");
		return FileVisitResult.CONTINUE;
	}

	public static void main(String[] args) throws IOException {

		// Give path of directory in main method. In D drive, we have the test folder.
		// this folder has sub directories and many files under it
		Path directoryPath = Paths.get("D:/", "test");
		// Create object of class in main method. We need to give this object to
		// walkfiletree method.
		DirectoryDeleteUsingSimpleFileVisitor deleteVisitor = new DirectoryDeleteUsingSimpleFileVisitor();
		// Walkfiletree method is created. Give directory path and object of the class.
		// Walkfiletree method contains methods for traversing files and folders
		// recursively.
		// All folders, sub folders and files under test including test will be deleted.
		Files.walkFileTree(directoryPath, deleteVisitor);
	}

	// How walkfiletree works-
	// When we call walkfiletree method, the methods of the parent class
	// simplefilevisitor are automatically called. We need to give objects of the
	// class where these simplefilevisitor methods are written so that these methods
	// can be invoked
	// (called), in our case it’s the same class (deleteVisitor).

}
