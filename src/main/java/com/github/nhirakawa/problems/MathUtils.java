package com.github.nhirakawa.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MathUtils {

  private static final Map<Long, Long> FIBONACCI_MEMO = new HashMap<>();

  private MathUtils() {
  }

  public static long fibonacci(long n) {
    if (n < 1) {
      throw new IllegalArgumentException(String.format("%d is less than 1", n));
    }
    if (n == 1 || n == 2) {
      return n;
    }
    return FIBONACCI_MEMO.computeIfAbsent(n, integer -> fibonacci(n - 1) + fibonacci(n - 2));
  }

  public static boolean isPrime(long n) {
    if (n < 1) {
      throw new IllegalArgumentException(String.format("%d is less than 1", n));
    }

    if (n == 1) {
      return true;
    }

    for (long l = 2; l < Math.ceil(Math.sqrt(n)); l++) {
      if (n % l == 0) {
        return false;
      }
    }

    return true;
  }

  public static Set<Long> getFactors(long n) {
    if (n < 1) {
      throw new IllegalArgumentException(String.format("%d is less than 1", n));
    }

    Set<Long> factors = new HashSet<>();

    for (long l = 1; l < Math.ceil(Math.sqrt(n)); l++) {
      if (n % l == 0) {
        factors.add(l);
        factors.add(n / l);
      }
    }
    return factors;
  }

}