package telran.interviews;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class InterviewTasks {

	public record DateRole(LocalDate date, String role) {

	}

	static public List<DateRole> rolesInDates(List<DateRole> datesRoles, List<LocalDate> dates) {
		return dates.stream().map(date -> checkDate(datesRoles, date)).collect(Collectors.toList());
	}

	private static DateRole checkDate(List<DateRole> datesRoles, LocalDate date) {
		return datesRoles.stream()
				.filter(dateRole -> date.isAfter(dateRole.date))
				.collect(Collectors.collectingAndThen(Collectors.toList(), list -> 
				list.isEmpty() ? new DateRole(date, null) 
				: new DateRole(date, list.get(list.size() - 1).role)));
	}

	static public void displayShuffled(int[] ar) {
		Arrays.stream(ar).boxed().collect(Collectors.collectingAndThen(Collectors.toList(), list -> {
			Collections.shuffle(list);
			return list;
		})).forEach(System.out::println);
	}
}
