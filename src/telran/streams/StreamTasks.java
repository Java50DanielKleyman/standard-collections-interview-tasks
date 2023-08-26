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
	public void printDigitStatistics1() {
		List<Integer> numbers = new Random().ints(NUMBERS, 0, Integer.MAX_VALUE)
				.boxed()
				.collect(Collectors.toList());
		Map<Integer, Long> map = numbers.stream()
			 	.flatMap(i -> splitToDigits(i).stream())
				.collect(Collectors.groupingBy(i -> i, Collectors.counting()));	

		map.entrySet().stream().sorted((e1, e2) -> {
			int res = Long.compare(e2.getValue(), e1.getValue());
			if (res == 0) {
				res = e1.getKey().compareTo(e2.getKey());
			}
			return res;
		}).forEach(e -> System.out.printf("%d -> %d\n", e.getKey(), e.getValue()));

	}
	private List<Integer> splitToDigits(Integer number){
		if(number < 10) {
			return Stream.of(number).collect(Collectors.toList());
		} else {
			Integer lastDigit = number % 10;
			Integer remainingDigits = number / 10;
			List<Integer>  restDigits = splitToDigits(remainingDigits);
			restDigits.add(lastDigit);
			return restDigits;
		}				
	}
}
