package com.niopackage.part2;

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

public class DirectoryWatcherExampleTwo {

	public static void main(String[] args) {
		try {
			// Watch service-
			// Api to monitor the files and folders.
			// First create watch service to start watching.
			WatchService watchService = FileSystems.getDefault().newWatchService();
			// Give path where to check and monitor.
			Path dir = Paths.get("E:/");

			// Register events like when to invoke.
			dir.register(watchService, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);

			// Infinite while loop because we want to monitor 24*7*365.
			while (true) {
				// Watch key – gives key which is associated with that event.
				WatchKey key;
				try {
					// Some event happens, capture that and put that into key for monitoring. We
					// used the take() method for capturing the events into key.
					key = watchService.take();
				} catch (InterruptedException ex) {
					// We wrote empty return because if some exception comes, then return that
					// exception, no point going forward.
					return;
				}
				// Enhanced for loop- if any event occurs, hence “?” generic data type added to
				// handle any type of event.
				// Get the event which happened , pollEvent gives the event name.
				for (WatchEvent<?> event : key.pollEvents()) {
					// WatchEvent.kind() – any kind of event occurs, give us the notification.
					WatchEvent.Kind<?> kind = event.kind();
					// Get the path (WatchEvent<Path>). Type cast the event into watchevent<path>.
					// This is for getting the paths and from this path we will know what file is
					// getting modified in that path.
					// Watch event <path> to know the location where the event occurred.
					WatchEvent<Path> ev = (WatchEvent<Path>) event;
					// Get the file name using context().
					Path fileName = ev.context();
					// Print the event name using kind() and print the file
					// name on which something changed.
					System.out.println(kind.name() + ": " + fileName);
				}
				// Reset the key again once an event is found, so fresh event can have fresh
				// key. If no event found, then simply break, and wait for event to come. This
				// step is not mandatory.
				// Reset key. If not true, then break and come out of the loop to continue
				// next run.
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

//Watch service works on files and directories.
//Keys.reset- reset the keys and start afresh. It will return true or false.