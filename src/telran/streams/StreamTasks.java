package telran.streams;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTasks {
	private static final int NUMBERS = 1000000;

	public void printDigitStatistics() {
		String numbers = new Random().ints(NUMBERS, 0, Integer.MAX_VALUE)
				.boxed()
				.map(Object::toString)
				.collect(Collectors.joining());

		Map<Character, Long> map = numbers.chars()
				.mapToObj(ch -> (char) ch)
				.collect(Collectors.groupingBy(ch -> ch, Collectors.counting()));
		map.entrySet().stream().sorted((e1, e2) -> {
			int res = Long.compare(e2.getValue(), e1.getValue());
			if (res == 0) {
				res = e1.getKey().compareTo(e2.getKey());
			}
			return res;
		}).forEach(e -> System.out.printf("%s -> %d\n", e.getKey(), e.getValue()));

	}
}
