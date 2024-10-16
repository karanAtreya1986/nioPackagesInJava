package com.niopackage.part2;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class SearchingFilesInNioExampleTwo {

	public static void main(String[] args) throws IOException {

		// searching for files ending in pdf
		String glob = "glob:**.pdf";
		// Create path variable and mention the directory to work on.
		String path = "E:/";
		// Match method to be called, it has glob and the path variable as parameter.
		match(glob, path);
	}

	private static void match(String glob, String location) throws IOException {

		// Path matcher – this is needed to match a location. In this path, we can find
		// the file with the extension mentioned in glob variable.
		PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher(glob);

		// Use walkFileTree and give location and file visitor object.
		// This is another method of writing the four methods inside the function itself
		// rather than creating it separately and then creating objects of class and
		// passing the objects as parameter as we did earlier.
		// anonymous inner class concept is used.
		Files.walkFileTree(Paths.get(location), new SimpleFileVisitor<Path>() {

			// VisitFile() is one method – takes in path and basic file attribute. If path
			// matcher matches the path, you specified then print path and keep continuing.

			public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException {
				if (pathMatcher.matches(path)) {
					System.out.println(path);
				}
				return FileVisitResult.CONTINUE;
			}

			// visitFileFailed() – if file not found just do what you feel like. Takes in
			// path and ioexception. We just continue if file not found, or you can dance if
			// you like . 😊
			public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
				return FileVisitResult.CONTINUE;
			}
		});

	}

}
