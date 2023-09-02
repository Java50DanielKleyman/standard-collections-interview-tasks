package telran.interviews;

import java.util.Arrays;
import java.util.Collections;

import java.util.stream.Collectors;

public class InterviewTasks {

	public static void main(String[] args) {
		int[] test = { 1, 2, 3, 4, 5 };
		displayShuffled(test);

	}

	static public void displayShuffled(int[] ar) {
		Arrays.stream(ar).boxed().collect(Collectors.collectingAndThen(Collectors.toList(), list -> {
			Collections.shuffle(list);
			return list;
		})).forEach(System.out::println);
	}
}
