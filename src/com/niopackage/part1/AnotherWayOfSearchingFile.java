package com.niopackage.part1;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class AnotherWayOfSearchingFile extends SimpleFileVisitor<Path> {

	static PathMatcher pm1;

	public static void main(String[] args) throws IOException {
		String globString = "glob:**.txt";
		String pathString = "E:/";
		match(globString, pathString);
	}

	// have you noticed, now the method definition seems fine because we get the
	// override option.
	@Override
	public FileVisitResult visitFile(Path p2, BasicFileAttributes attrs) throws IOException {
		if (pm1.matches(p2)) {
			System.out.println("Paths " + p2);
		}
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFileFailed(Path p2, IOException exc) throws IOException {
		return FileVisitResult.CONTINUE;
	}

	public static void match(String glob, String location) throws IOException {
		pm1 = FileSystems.getDefault().getPathMatcher(glob);
		AnotherWayOfSearchingFile sf1 = new AnotherWayOfSearchingFile();
		// instead of using anonymous inner class,
		// we created object of class which extended simplefilevisitor class
		// so the idea is second parameter should extend simplefilevisitor
		Path p1 = Files.walkFileTree(Paths.get(location), sf1);
		System.out.println("first file or folder in path is " + p1);

	}

}
