package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AnalyticsCounter {

	private ISymptomReader reader;
	private ISymptomWriter writer;

	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}

	public List<String> getSymptoms() {
		return reader.getSymptoms();
	}

	public Map<String, Integer> countSymptoms(List<String> symptoms) {

		Map<String, Integer> results = new HashMap<>();

		symptoms.forEach(symptom -> {

			Integer counter = 0;

			if (results.containsKey(symptom)) {
				counter = results.get(symptom);
			}

			counter++;

			results.put(symptom, counter);

		});

		return results;
	}

	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		return symptoms.entrySet()
				.stream()
				.sorted(Map.Entry.<String, Integer>comparingByValue())
				.collect(Collectors.toMap(
						Map.Entry::getKey,
						Map.Entry::getValue,
						(e1, e2) -> e1,
						LinkedHashMap::new));
	}

	public void writeSymptoms(Map<String, Integer> symptoms) {
		writer.writeSymptoms(symptoms);
	}

}
