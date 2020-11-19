package test;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOutNormalized;
import static com.github.stefanbirkner.systemlambda.SystemLambda.withTextFromSystemIn;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.Main;

public class MainTest {

  @Test
  @DisplayName("Expected statements should appear in the console.")
  public void console_displays_expected_text() throws Exception {
    // here's what the "user" will type
    withTextFromSystemIn("Golly gee!", "dagnabbit, sassy")
        .execute(
            () -> {
              // note that the input from the "user" - including the newline create when they press
              // Enter -  is not expected in the output. That's because it's never sent to
              // System.out!
              List<String> expectedOutputParts =
                  List.of(
                      "(Sassbot)> bored now. amuse me, human.",
                      "(You)> ",
                      "(Sassbot)> your lips were saying \"GOLLY GEE!\", but all I heard was \"blah, blah, blah\"",
                      "(You)> ",
                      "(Sassbot)> only dweebs start a sentence with the letter 'd'");

              String whatIsOutput = tapSystemOutNormalized(() -> Main.main(new String[0])).trim();

              assertThat(whatIsOutput).containsSubsequence(expectedOutputParts);
            });
  }
}
