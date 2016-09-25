package com.github.nhirakawa;

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
}
