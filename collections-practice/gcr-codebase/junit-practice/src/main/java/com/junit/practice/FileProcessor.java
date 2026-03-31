package com.junit.practice;

import java.io.*;

public class FileProcessor {
	
	public boolean writeToFile(String filename, String content) throws IOException {
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename))){
			bw.write(content);		
		}
		return true;
	}
	
	public String readFromFile(String filename)throws IOException {
		StringBuilder sb = new StringBuilder();
		try(BufferedReader br = new BufferedReader(new FileReader(filename))){
			String line;
			while((line = br.readLine()) != null) {
				sb.append(line);
			}
		}
		return sb.toString();
	}

}