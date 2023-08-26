package telran.streams;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTasks {
	private static final int NUMBERS = 1000000;

	public void printDigitStatistics() {
		List<Integer> listNumbers = new Random().ints(NUMBERS, 0, Integer.MAX_VALUE).boxed().toList();
		Map<Integer, Long> map = listNumbers.stream()
				.collect(Collectors.groupingBy(i -> i, Collectors.counting()));
		map.entrySet().stream().sorted((e2, e1) -> {
			int res = Long.compare(e2.getValue(), e1.getValue());
			if (res == 0) {
				res = e1.getKey().compareTo(e2.getKey());
			}
			return res;
		})
		.filter(entry -> entry.getKey() < 10)
		.forEach(e -> System.out.printf("%d -> %d\n", e.getKey(), e.getValue()));

	}
}
