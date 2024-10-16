package com.niopackage.part1;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;

public class SearchingFilesInNio {

	// glob is the new datatype for nio.
	// glob stands for global.
	// path matcher will match the paths for us.

	public static void main(String[] args) throws IOException {
		// matches for all files ending with .txt.
		// the glob syntax is strict
		// one extra space and we get error
		String glob = "glob: **.pdf";
		String path = "E:/";
		match(glob, path);
	}

	private static void match(String glob, String location) throws IOException {
		// use file systems.getdefault method and call getpathmatcher method and pass in
		// glob
		PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher(glob);

		// this is kind of inner class concept -- anonymous inner class
		// we pass location and simple file visitor directly
		Files.walkFileTree(Paths.get(location), new SimpleFileVisitor<Path>() {

			// visit file method as earlier
			public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException {
				if (pathMatcher.matches(path)) {
					System.out.println(path);
				}
				return FileVisitResult.CONTINUE;
			}

			// what to do when visit fails
			// as of not we are not handling failures, just writing continue
			public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
				return FileVisitResult.CONTINUE;
			}
		});

	}

}
