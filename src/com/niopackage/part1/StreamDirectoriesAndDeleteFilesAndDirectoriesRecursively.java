package com.niopackage.part1;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;

public class StreamDirectoriesAndDeleteFilesAndDirectoriesRecursively extends SimpleFileVisitor<Path> {

	public FileVisitResult visitFile(Path file, BasicFileAttributes attributes) throws IOException {
		Files.delete(file);
		Path p1 = file.getParent();// gives the directory or folder under which the file is present
		Path f1 = file.getFileName(); // get the name of the file
		System.out.println("files deleted are " + f1);
		return FileVisitResult.CONTINUE; // continue operation until all deleted
	}

	public FileVisitResult postVisitDirectory(Path directory, IOException ioe) throws IOException {
		Files.delete(directory);
		Path d1 = directory.getFileName(); // get directory name
		System.out.println("Check if directories and files both are deleted " + d1);
		return FileVisitResult.CONTINUE; // continue operation until all deleted
	}

	public static void main(String[] args) {
		Path pp1 = Paths.get("E:/", "Tester");
		StreamDirectoriesAndDeleteFilesAndDirectoriesRecursively dd1 = new StreamDirectoriesAndDeleteFilesAndDirectoriesRecursively();
		try {
			// walk file tree will give the location of the starting directory
			Path pp2 = Files.walkFileTree(pp1, dd1);
			System.out.println("Lets see what is deleted now " + pp2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
