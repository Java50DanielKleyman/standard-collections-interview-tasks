package add14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class NestedIteratorTest {

	public static void main(String[] args) {
		
		// prepare nested collections
		LinkedList<Object> stringDoubleList = new LinkedList<>();
		stringDoubleList.add(new ArrayList<String>(Arrays.asList("qwe11", null, "qwe12", "qwe13")));
		stringDoubleList.add(new LinkedList<String>(Arrays.asList("qwe21", "qwe22")));
		stringDoubleList.add("qwe31");
		stringDoubleList.add(new String[]{"qwe41", "qwe42","qwe43"});
		String[][] array2d = new String[][]{{"asd1","asd2"},{"asd3"}};
		
		NestedIterator<String> it = new NestedIterator<>(Arrays.asList("xxx","yyy"), stringDoubleList, null, array2d);
		LinkedList<String> collector = new LinkedList<>();
		for (String s : it) {
			collector.add(s);
		}
		
		List<String> target = Arrays.asList("xxx","yyy","qwe11", null,"qwe12","qwe13","qwe21","qwe22","qwe31","qwe41","qwe42","qwe43", null,"asd1","asd2","asd3");
		if (! collector.equals(target)) {
			System.out.println("Failure:");
			System.out.println(collector);
			System.out.println(target);
			return;
		}
		System.out.println("Success");
	}	
}