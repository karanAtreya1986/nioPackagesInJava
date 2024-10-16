package com.niopackage.part1;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;

public class SimpleFileVisitorUsingChatGPT extends SimpleFileVisitor<Path> {

	// Override the visitFile method to delete the file
	public FileVisitResult visitFile(Path file, BasicFileAttributes attributes) throws IOException {
		try {
			Files.delete(file);
			System.out.println(file.getFileName() + " deleted.");
		} catch (IOException e) {
			System.err.println("Unable to delete file: " + file.getFileName() + ". " + e.getMessage());
		}
		return FileVisitResult.CONTINUE;
	}

	// Override postVisitDirectory to delete the directory after files have been
	// visited
	@Override
	public FileVisitResult postVisitDirectory(Path directory, IOException ioe) throws IOException {
		if (ioe == null) {
			try {
				Files.delete(directory);
				System.out.println(directory.getFileName() + " directory deleted.");
			} catch (IOException e) {
				System.err.println("Unable to delete directory: " + directory.getFileName() + ". " + e.getMessage());
			}
		} else {
			// Directory iteration failed
			throw ioe;
		}
		return FileVisitResult.CONTINUE;
	}

	public static void main(String[] args) throws IOException {
		// Specify the directory to delete
		Path directoryPath = Paths.get("E:/", "Files");
		SimpleFileVisitorClass deleteVisitor = new SimpleFileVisitorClass();

		// Walk the file tree and delete files and directories
		Files.walkFileTree(directoryPath, deleteVisitor);
	}
}
