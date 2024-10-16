package com.niopackage.part2;

import java.io.IOException;

//Simple file visitor-
//When traversing a particular directory completely and recursively.
//lets Delete all directories and sub directories.
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

import com.niopackage.part1.SimpleFileVisitorClass;

//Extend the class “simple file visitor” and specify “path” interface as its argument.
//This will work on the Directory mentioned in the path, plus all subfolders under the directory.
public class SimpleFileVisitorWithoutAnonymousClass extends SimpleFileVisitor<Path> {

	// Visitfile() – takes in path and basicfileattribute object.
	// We are deleting directory and give the path. Print what has been deleted.
	// Keep continuing till all not deleted.

	public FileVisitResult visitFile(Path file, BasicFileAttributes attributes) throws IOException {
		Files.delete(file);
		System.out.println(file.getFileName() + " deleted.");
		return FileVisitResult.CONTINUE;
	}

	// Postvisitdirectory() – give path and io exception object. Same steps as file.
	public FileVisitResult postVisitDirectory(Path directory, IOException ioe) throws IOException {
		Files.delete(directory);
		System.out.println(directory.getFileName() + " directory deleted.");
		return FileVisitResult.CONTINUE;
	}

	public static void main(String[] args) throws IOException {

		Path directoryPath = Paths.get("D:/", "test");
		// Create object of your class because we need to pass to walkfiletree to use
		// the methods of simplefilevisitor in our class.
		SimpleFileVisitorWithoutAnonymousClass deleteVisitor = new SimpleFileVisitorWithoutAnonymousClass();
		// Walkfiletree needs path and our object (the visitor who will visit).
		// Walkfiletree will automatically invoke the four methods which are part of
		// simplefilevisitor api.
		Files.walkFileTree(directoryPath, deleteVisitor);
	}

	// Everything happens on D drive. All directories and sub directories under
	// “test folder” are deleted. Even “test folder” is deleted.
	// Recursively go into directory and perform some operations on all files and
	// sub files or all directories and sub directories -> use the simplefilevisitor
	// api.
	// Use the four methods and accomplish anything you want.

	// Four methods of simplefilevisitor-
	// Visitfile- called for every file visited during the walk tree. Only for files
	// not directories.
	// Postvisitdirectory() - just after visiting directory.
	// Previsitdirectory() – opposite to postvisitdirectory.
	// Visitfilefailed() – visiting file fails due to some reason.
	// Walkfiletree()- for working with files and directories recursively. Takes in
	// path and the object of the class (visitor who will visit the files and
	// directories).

}
