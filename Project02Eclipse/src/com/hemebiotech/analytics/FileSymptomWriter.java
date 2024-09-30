package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Simple brute force implementation
 *
 */
public class FileSymptomWriter implements ISymptomWriter {

	private String filepath;

	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it,
	 *                 one per line
	 */
	public FileSymptomWriter(String filepath) {
		this.filepath = filepath;
	}

	@Override
	public void writeSymptoms(Map<String, Integer> symptoms) {
		try {
			FileWriter writer = new FileWriter(filepath);
			symptoms.forEach((symptom, counter) -> {
				try {
					writer.write(symptom + ": " + counter + "\n");
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
