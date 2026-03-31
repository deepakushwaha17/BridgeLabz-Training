package com.junit.practice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

import org.junit.jupiter.api.Test;

public class FileProcessorTest {
	
	String filename = "TestFile.txt";
	
	FileProcessor processor  = new FileProcessor();
	
	@Test
	void testWriter() throws IOException {
		assertTrue(processor.writeToFile(filename, "Hello World!"));
	}
	
	@Test
	void testReader() throws IOException {
		assertEquals("Hello World!" , processor.readFromFile(filename));
	}
}
