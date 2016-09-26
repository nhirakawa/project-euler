package com.github.nhirakawa.problems;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.github.nhirakawa.Answer;
import com.github.nhirakawa.Problem;

public class Problem22 extends Problem {

  private static final Map<Character, Long> CHAR_MAP = getCharMap();

  private final Map<Integer, String> names;

  public Problem22() {
    super();
    Collections.sort(resource);
    int index = 1;
    names = new HashMap<>();
    for (String name : resource) {
      names.put(index++, name);
    }
  }

  @Override
  public Answer solve() {
    long sum = 0;
    for (Entry<Integer, String> name : names.entrySet()) {
      sum += name.getKey() * getScore(name.getValue());
    }
    return new Answer<>(sum);
  }

  private static long getScore(String name) {
    long sum = 0;
    for(char c : name.toCharArray()){
      sum += CHAR_MAP.get(c);
    }
    return sum;
  }

  private static Map<Character, Long> getCharMap() {
    Map<Character, Long> charMap = new HashMap<>();
    for (int i = 65; i < 91; i++) {
      charMap.put(Character.toChars(i)[0], (long) i - 65 + 1);
    }
    return charMap;
  }

}
