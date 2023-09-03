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
		Map<String, String> sorted = map.tailMap(prefix.toLowerCase());
//		List<String> list = new ArrayList<String>(sorted.values());
		 List<String> list = new ArrayList<>();
		 for (Map.Entry<String, String> entry : sorted.entrySet()) {
		        String key = entry.getKey();
		        if (key.startsWith(prefix.toLowerCase())) {
		            list.add(entry.getValue());
		        } else {
		            break;
		        }
		    }
		
		return list;
	}

}
