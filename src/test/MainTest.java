import static org.junit.Assert.assertEquals;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Assessment: MainTest")
public class MainTest {

  @Test
  @DisplayName("describe the test")
  public void describe_the_test() {
    assertThat(true).isFalse();
  }

}
