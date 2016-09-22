package com.github.nhirakawa.problems;

import java.util.HashMap;
import java.util.Map;

public class MathUtils {

  private static final Map<Long, Long> FIBONACCI_MEMO = new HashMap<>();

  private MathUtils() {
  }

  public static long fibonacci(long i) {
    if (i < 1) {
      throw new IllegalArgumentException(String.format("%d is less than 1", i));
    }
    if (i == 1 || i == 2) {
      return i;
    }
    return FIBONACCI_MEMO.computeIfAbsent(i, integer -> fibonacci(i - 1) + fibonacci(i - 2));
  }

}
