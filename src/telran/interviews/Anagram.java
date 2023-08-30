package telran.interviews;

import java.util.Map;
import java.util.stream.Collectors;

public class Anagram {
	public static boolean isAnagram(String str, String anagram) {
		Map<Character, Long> mapStr = str.chars().mapToObj(ch -> (char) ch)
				.collect(Collectors.groupingBy(ch -> ch, Collectors.counting()));
		Map<Character, Long> mapAnagram = anagram.chars().mapToObj(ch -> (char) ch)
				.collect(Collectors.groupingBy(ch -> ch, Collectors.counting()));
		if (mapStr.size() != mapAnagram.size()) {
			return false;
		}		
		for (int i = 0; i < str.length(); i++) {
			if (mapStr.get(anagram.charAt(i)) == null
					|| mapStr.get(anagram.charAt(i)) != mapAnagram.get(anagram.charAt(i))) {
				return false;
			}
		}
		return true;
	}
}