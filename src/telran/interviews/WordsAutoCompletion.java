package telran.interviews;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class WordsAutoCompletion implements Words {
	TreeMap<String, String> map = new TreeMap<String, String>();

	@Override
	public boolean addWord(String word) {
		boolean res = false;
		if (!map.containsKey(word.toLowerCase())) {
			map.put(word.toLowerCase(), word);
			res = true;
		}
		return res;
	}

	@Override
	public List<String> getWordsByPrefix(String prefix) {
		prefix = prefix.toLowerCase();
		TreeMap<String, String> subMap = new TreeMap<>(map.subMap(prefix, true, prefix + Character.MAX_VALUE, true));
		return new ArrayList<>(subMap.values());
	}

}
