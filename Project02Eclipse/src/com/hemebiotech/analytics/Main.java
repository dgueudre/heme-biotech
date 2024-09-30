package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Main {


	public static void main(String[] args) {

        ISymptomReader reader = new FileSymptomReader("symptoms.txt");
        ISymptomWriter writer = new FileSymptomWriter("result.out");

        AnalyticsCounter counter = new AnalyticsCounter(reader, writer);

        List<String> symptoms = counter.getSymptoms();

        Map<String, Integer> results = counter.countSymptoms(symptoms);

        Map<String, Integer> sortedResults = counter.sortSymptoms(results);

        counter.writeSymptoms(sortedResults);
	}
}
