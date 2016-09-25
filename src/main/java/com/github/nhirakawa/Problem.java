package com.github.nhirakawa;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.List;

import com.google.common.io.Resources;

public abstract class Problem {

  protected List<String> resource;

  public Problem() {
    try {
      URL url = Resources.getResource(String.format("%s.txt", getClass().getSimpleName().toLowerCase()));
      resource = Resources.readLines(url, Charset.defaultCharset());
    } catch (IllegalArgumentException e) {
      resource = Collections.emptyList();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public abstract Answer solve();
}
