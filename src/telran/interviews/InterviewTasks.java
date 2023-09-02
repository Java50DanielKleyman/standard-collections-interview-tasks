package telran.interviews;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class InterviewTasks {
	
	public record DateRole(LocalDate date, String role) {
		
	}
	static public List<DateRole> rolesInDates(List<DateRole> datesRoles, List<LocalDate> dates){
				
		return datesRoles;
		
	}
	static public void displayShuffled(int[] ar) {
		Arrays.stream(ar).boxed().collect(Collectors.collectingAndThen(Collectors.toList(), list -> {
			Collections.shuffle(list);
			return list;
		})).forEach(System.out::println);
	}
}
