package mechanisms;

import utils.AnalysisUtils;

import java.util.*;
import java.util.regex.Matcher;

public class WordsMechanism {

    public void countTop10words(String text) {
        text = text.replaceAll("[!?,\'\":;*#.]", "");
        String[] words = text.split("\\s+");
        HashMap<String, Integer> wordToCountNumber = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i].toUpperCase();
            wordToCountNumber.putIfAbsent(word, 0);
            if (wordToCountNumber.containsKey(word.toUpperCase())) {
                System.out.println("WOoW!");
            }
            wordToCountNumber.computeIfPresent(word, (key, value) -> ++value);
        }
//        HashMap<String, Integer> hashMap  sortByValue(wordToCountNumber);
//        wordToCountNumber.((key, value) -> System.out.println(key + " -> " + value));
//        List<Integer> numberOfWords = new ArrayList<>( wordToCountNumber.values());
//        numberOfWords.sort(Comparator.reverseOrder());
//        for (int i = 10; i < 0 ; i--) {
//            numberOfWords.get(i)
//        }

    }

    public <K, V extends Comparable<? super V>> Map<K, V>
    sortByValue(final Map<K, V> map) {
        List<Map.Entry<K, V>> list = new LinkedList<Map.Entry<K, V>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
            public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        Map<K, V> result = new LinkedHashMap<K, V>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }


}
