package telran.interviews;

import java.util.Collection;
import java.util.List;

public interface Words {
	boolean addWord(String word);

	Collection<String> getWordsByPrefix(String prefix);
}
