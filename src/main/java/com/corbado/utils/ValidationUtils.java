package com.corbado.utils;

import java.util.stream.Stream;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/** Utility class for validation logic. */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ValidationUtils {

  /**
   * Validate not empty.
   *
   * @param args the fields to validate
   */
  public static void validateNotEmpty(final String... args) {
    Stream.of(args)
        .filter(arg -> arg == null || arg.isEmpty())
        .findAny()
        .ifPresent(
            arg -> {
              throw new IllegalArgumentException(
                  "Argument '" + arg + "' must not be null or empty");
            });
  }
}
