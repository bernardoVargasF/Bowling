package com.jobsity.greenfield.resources;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileManager{
	
	private static final String PATH = "scores";
	
	public List<String> readFile(String fileName) throws IOException {
		Path file = Paths.get(PATH + File.separator + fileName + ".txt");
		List<String> output = Files.readAllLines(file);
		return output;
	}
}
