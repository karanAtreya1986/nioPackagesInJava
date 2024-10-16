package com.niopackage.part1;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DirectoryStreaming {

	public static void main(String[] args) throws IOException {
		// DirectoryStream iterates over files and returns Path instance for every file.
		// for iterating over directories
		// can work with files inside directories and search at the required directory
		DirectoryStream<Path> stream = null;
		try {
			// declare path where we want to search (directory path)
			Path dir = Paths.get("E:/");
			// We can restrict DirectoryStream to iterate only specific file by providing
			// file extension.
			// file extension to be given within {} not ()
			// if you give extension within (), we get empty output
			stream = Files.newDirectoryStream(dir, "*.{java,txt,dmg,log,exe}");
			for (Path p : stream) {
				// get the file name with the extension from the mentioned directory
				System.out.println(p.getFileName());
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				// DirectoryStream must be closed after iteration otherwise there will be
				// resource leak.
				stream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

}
