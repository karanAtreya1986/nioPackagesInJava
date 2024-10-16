package com.niopackage.part1;

//import these three manually
//else it doesnt come.
//this is for watching on creation, deletion, modification.
//used for changes at file and directory level
import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class DirectoryWatcher {
	// By heart, some parts of code like watch service.

	public static void main(String[] args) {
		try {
			// Watchservice – to watch the location constantly.
			// works at folder and file levels.
			// mention the directory you want to watch
			// whatever file or sub directory you created, modified or deleted inside that
			// directory will be watched
			WatchService watchService = FileSystems.getDefault().newWatchService();
			Path dir = Paths.get("E:/");

			// Register event on when to watch-
			// We need to watch during creation, update and delete.

			dir.register(watchService, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);

			// We need infinite while loop to check continuously
			// Use infinite while loop to watch the events 365*7*24-
			// If somebody changes, anything, how will I know. This logic is present in the
			// while loop.

			while (true) {
				// Watchkey – to check and get to know if somebody changed something.
				// The below code will give file which is being modified or deleted or created.
				// Created watchkey.
				WatchKey key;
				try {
					// To get the key, use take() method of watchService.
					// Key is nothing but the file which is being modified or created or deleted.
					key = watchService.take();
				} catch (InterruptedException ex) {
					return;// if error return nothing
					// or you can write
//					ex.printStackTrace();
				}
				// Watch event-
				// Whatever event has happened, give me file name where
				// the event has happened.
				// we used generics <?> because we are just worried about the
				// events and not the type of events which have happened.

				for (WatchEvent<?> event : key.pollEvents()) {
					// Capture the event. Any kind of event -> capture it.
					WatchEvent.Kind<?> kind = event.kind();
					// Capture the location of file.
					WatchEvent<Path> ev = (WatchEvent<Path>) event;
					// captures the file name/path of the file on which event occurred.
					Path fileName = ev.context();
//					get the event name using kind.name() and print the filename.
					System.out.println(kind.name() + ": " + fileName);
				}
				// Reset key-
				// This is not mandatory to write as you will see in later lectures.
				// This is for being more professional in coding.

				boolean valid = key.reset();
				if (!valid) {
					break;
				}
			}
		} catch (IOException ex) {
			System.err.println(ex);
		}
	}

}
