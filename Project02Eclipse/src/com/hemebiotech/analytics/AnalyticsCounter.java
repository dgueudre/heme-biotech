package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AnalyticsCounter {

	public static void main(String[] args) throws Exception {

		Map<String, Integer> results = new HashMap<>();

		BufferedReader reader = new BufferedReader(new FileReader("symptoms.txt"));
		String inputSymptom = reader.readLine();

		while (inputSymptom != null) {

			Integer counter = 0;

			if (results.containsKey(inputSymptom)) {
				counter = results.get(inputSymptom);
			}

			counter++;

			results.put(inputSymptom, counter);

			inputSymptom = reader.readLine();
		}

		reader.close();

		FileWriter writer = new FileWriter("result.out");

		results.forEach((symptom, counter) -> {
			try {
				writer.write(symptom + ": " + counter + "\n");
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		writer.close();
	}
}
