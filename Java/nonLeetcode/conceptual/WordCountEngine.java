package conceptual;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class WordCountEngine {

  static String[][] wordCountEngine(String document) {
    String replacedStr = document.toLowerCase().replaceAll("[.'!:,;?]", "");
    String[] strArr = replacedStr.split("[ ]+");
  
    LinkedHashMap<String, Integer> freq = new LinkedHashMap<>();
    for(String str :strArr){
      freq.put(str, freq.getOrDefault(str, 0)+1);
    }
    String[][] sortedArray = sortMapByValues(freq);
    return sortedArray;
  }
  private static String[][] sortMapByValues( Map<String, Integer> freq){
    List<Map.Entry<String, Integer>> sortedEntries = freq.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toList());
    String[][] sortedArray = sortedEntries.stream()
                .map(entry -> 
                     new String[]{entry.getKey(), entry.getValue().toString()})
                .toArray(String[][]::new);
        return sortedArray;
  }

  public static void main(String[] args) {
    String str = "Every book is a quotation; and every     house is a quotation out of all forests, and mines, and stone quarries; and every man is a quotation from all his ancestors. ";
    String[][] ans = wordCountEngine(str);
    for(String[] a: ans){
      System.out.println("{" + a[0] + "=" + a[1] + "}");
    }
  }


}