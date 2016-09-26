package com.github.nhirakawa;

import java.math.BigInteger;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.LongStream;

public class MathUtils {

  private static final Map<Long, BigInteger> FIBONACCI_MEMO = new HashMap<>();

  private MathUtils() {
  }

  public static BigInteger fibonacci(long n) {
    if (n < 0) {
      throw new IllegalArgumentException(String.format("%d is less than 0", n));
    }
    if (n == 0 || n == 1) {
      return BigInteger.ONE;
    }
    return FIBONACCI_MEMO.computeIfAbsent(n, integer -> fibonacci(n - 1).add(fibonacci(n - 2)));
  }

  public static boolean isPrime(long n) {
    if (n < 1) {
      throw new IllegalArgumentException(String.format("%d is less than 1", n));
    }

    if (n == 1 || n == 2) {
      return true;
    }
    if (n % 2 == 0) {
      return false;
    }

    for (long l = 3; l * l <= n; l += 2) {
      if (n % l == 0) {
        return false;
      }
    }

    return true;
  }

  public static Set<Long> getDivisors(long n) {
    if (n < 1) {
      throw new IllegalArgumentException(String.format("%d is less than 1", n));
    }

    Set<Long> factors = new HashSet<>();

    for (long l = 1; l * l <= n; l++) {
      if (n % l == 0) {
        factors.add(l);
        factors.add(n / l);
      }
    }
    return factors;
  }

  public static Set<Long> getProperDivisors(long n) {
    Set<Long> allDivisors = getDivisors(n);
    allDivisors.remove(n);
    return allDivisors;
  }

  public static long square(long num) {
    return num * num;
  }

  public static long max(long... numbers) {
    return max(LongStream.of(numbers));
  }

  public static long max(Collection<Long> numbers) {
    return max(numbers.stream().mapToLong(Long::new));
  }

  public static long max(LongStream stream) {
    return stream.reduce(Long.MIN_VALUE, Math::max);
  }

  public static long sum(long... numbers) {
    return sum(LongStream.of(numbers));
  }

  public static long sum(Collection<Long> numbers) {
    return sum(numbers.stream().mapToLong(Long::new));
  }

  private static long sum(LongStream stream) {
    return stream.sum();
  }

  public static long product(long... numbers) {
    return product(LongStream.of(numbers));
  }

  public static long product(Collection<Long> numbers) {
    return product(numbers.stream().mapToLong(Long::new));
  }

  public static long product(LongStream stream) {
    return stream.reduce(1L, (a, b) -> a * b);
  }

  public static boolean isPythagorean(long a, long b, long c) {
    return !(a == 0 || b == 0 || c == 0) && square(a) + square(b) == square(c);
  }

  public static boolean isPerfect(long n) {
    return sum(getProperDivisors(n)) == n;
  }

  public static boolean isAbundant(long n) {
    return sum(getProperDivisors(n)) > n;
  }

  public static boolean isDeficient(long n) {
    return sum(getProperDivisors(n)) < n;
  }

}
