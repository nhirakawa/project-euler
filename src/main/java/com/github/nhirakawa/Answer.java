package com.github.nhirakawa;

import java.util.Objects;

import com.google.common.base.MoreObjects;

public class Answer<T> {

  private final T value;

  public Answer(T value) {
    this.value = value;
  }

  public T get() {
    return value;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(getClass())
        .add("type", value.getClass().getCanonicalName())
        .add("value", value)
        .toString();
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Answer)) {
      return false;
    }
    Answer<?> answer = (Answer<?>) o;
    return this.value.equals(answer.value);
  }
}
