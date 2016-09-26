package com.github.nhirakawa;

import static com.github.nhirakawa.MathUtils.fibonacci;
import static com.github.nhirakawa.MathUtils.getDivisors;
import static com.github.nhirakawa.MathUtils.getProperDivisors;
import static com.github.nhirakawa.MathUtils.isAbundant;
import static com.github.nhirakawa.MathUtils.isDeficient;
import static com.github.nhirakawa.MathUtils.isPerfect;
import static com.github.nhirakawa.MathUtils.isPrime;
import static com.github.nhirakawa.MathUtils.isPythagorean;
import static com.github.nhirakawa.MathUtils.max;
import static com.github.nhirakawa.MathUtils.product;
import static com.github.nhirakawa.MathUtils.square;
import static com.github.nhirakawa.MathUtils.sum;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;

import java.math.BigInteger;
import java.util.Collections;

import org.junit.Test;

import com.google.common.collect.Lists;

public class MathUtilsTest {

  @Test
  public void testFibonacci() {
    assertThat(fibonacci(0)).isEqualTo(BigInteger.valueOf(1));
    assertThat(fibonacci(1)).isEqualTo(BigInteger.valueOf(1));
    assertThat(fibonacci(2)).isEqualTo(BigInteger.valueOf(2));
    assertThat(fibonacci(3)).isEqualTo(BigInteger.valueOf(3));
    assertThat(fibonacci(4)).isEqualTo(BigInteger.valueOf(5));
  }

  @Test
  public void testSquare() {
    assertThat(square(2)).isEqualTo(4);
    assertThat(square(4)).isEqualTo(16);
    assertThat(square(5)).isEqualTo(25);
    assertThat(square(10)).isEqualTo(100);
  }

  @Test
  public void testGetDivisors() {
    assertThat(getDivisors(2)).contains(1L, 2L);
    assertThat(getDivisors(25)).contains(1L, 5L, 25L);
    assertThat(getDivisors(19)).contains(1L, 19L);
    assertThat(getDivisors(24)).contains(1L, 2L, 3L, 4L, 6L, 8L, 12L, 24L);
  }

  @Test
  public void testGetProperDivisors() {
    assertThat(getProperDivisors(4)).contains(1L, 2L);
    assertThat(getProperDivisors(9)).contains(1L, 3L);
    assertThat(getProperDivisors(13L)).containsExactly(1L);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGetFactorsException() {
    getDivisors(0);
  }

  @Test
  public void testIsPrime() {
    assertThat(isPrime(2)).isTrue();
    assertThat(isPrime(19)).isTrue();
    assertFalse(isPrime(25));
    assertThat(isPrime(25)).isFalse();
    assertThat(isPrime(300)).isFalse();
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIsPrimeException() {
    isPrime(-1);
  }

  @Test
  public void testMax() {
    assertThat(max(1, 2, 3)).isEqualTo(3);
    assertThat(max(2)).isEqualTo(2);
    assertThat(max(0)).isEqualTo(0);

    assertThat(max(Collections.emptyList())).isEqualTo(Long.MIN_VALUE);
    assertThat(max(Lists.newArrayList(1L))).isEqualTo(1);
    assertThat(max(Lists.newArrayList(1L, 2L, 3L))).isEqualTo(3);
  }

  @Test
  public void testSum() {
    assertThat(sum()).isEqualTo(0);
    assertThat(sum(1, 2, 3)).isEqualTo(6);
    assertThat(sum(1)).isEqualTo(1);

    assertThat(sum(Lists.newArrayList())).isEqualTo(0);
    assertThat(sum(Lists.newArrayList(1L, 2L, 3L))).isEqualTo(6);
    assertThat(sum(Lists.newArrayList(1L))).isEqualTo(1);

    assertThat(sum(-1, 1)).isEqualTo(0);
  }

  @Test
  public void testProduct() {
    assertThat(product(1, 2)).isEqualTo(2);
    assertThat(product()).isEqualTo(1);

    assertThat(product(-1, 1)).isEqualTo(-1);

    assertThat(product(Lists.newArrayList(1L, 2L, 3L))).isEqualTo(6);
  }

  @Test
  public void testIsPythagorean() {
    assertThat(isPythagorean(3, 4, 5)).isTrue();
    assertThat(isPythagorean(1, 2, 3)).isFalse();
    assertThat(isPythagorean(0, 0, 0)).isFalse();
    assertThat(isPythagorean(5, 12, 13)).isTrue();
  }

  @Test
  public void testIsPerfect() {
    assertThat(isPerfect(28)).isTrue();
    assertThat(isPerfect(27)).isFalse();
  }

  @Test
  public void testIsDeficient() {
    assertThat(isDeficient(28)).isFalse();
    assertThat(isDeficient(2)).isTrue();
  }

  @Test
  public void testIsAbundant() {
    assertThat(isAbundant(12)).isTrue();
    assertThat(isAbundant(28)).isFalse();
  }
}
