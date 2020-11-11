package test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import main.Sassbot;

class SassbotTests {

  @Nested
  @DisplayName("initialBarb tests")
  class InitialBarbTests {

    @DisplayName("inital barb is what's given in constructor")
    @Test
    public void inital_barb_is_whats_given_in_constructor() {
      String sassyText = "you talkin' to me?";
      Sassbot sassy = new Sassbot(sassyText);
      assertThat(sassy.initialBarb()).isEqualTo(sassyText);

      sassyText = "it's not an attitude, it's the way I am";
      sassy = new Sassbot(sassyText);
      assertThat(sassy.initialBarb()).isEqualTo(sassyText);
    }
  }

  @Nested
  @DisplayName("blahBlahRiposteTo tests")
  class BlahBlahRiposteToTests {

    private Sassbot sassy;

    @BeforeEach
    public void setUp() {
      sassy = new Sassbot("some text");
    }

    @DisplayName("lowercased chat text is all-capped")
    @Test
    public void lowercased_chat_text_is_all_capped() {
      String chatText = "say what?!?";
      String expectedSassiness =
          "your lips were saying \"SAY WHAT?!?\", but all I heard was \"blah, blah, blah\"";

      assertThat(sassy.blahBlahRiposteTo(chatText)).isEqualTo(expectedSassiness);
    }

    @DisplayName("mixed-case chat text is all-capped")
    @Test
    public void mixcased_chat_text_is_all_capped() {
      String chatText = "But I thought we were friends, Sassy.";
      String expectedSassiness =
          "your lips were saying \"BUT I THOUGHT WE WERE FRIENDS, SASSY.\", but all I heard was \"blah, blah, blah\"";

      assertThat(sassy.blahBlahRiposteTo(chatText)).isEqualTo(expectedSassiness);
    }
  }

  @Nested
  @DisplayName("onlyDweebsRiposteTo tests")
  class OnlyDweebsRiposteToTests {
    private Sassbot sassy;

    @BeforeEach
    public void setUp() {
      sassy = new Sassbot("some text");
    }

    @DisplayName("lowercase first letter in chat text")
    @Test
    public void lowercase_first_letter_in_chat_text() {
      String chatText = "whatcha doing on Sunday?";
      String expectedSassiness = "only dweebs start a sentence with the letter 'w'";

      assertThat(sassy.onlyDweebsRiposteTo(chatText)).isEqualTo(expectedSassiness);
    }

    @DisplayName("uppercase first letter in chat text")
    @Test
    public void uppercase_first_letter_in_chat_text() {
      String chatText = "Sassy - you just TOO sassy!";
      String expectedSassiness = "only dweebs start a sentence with the letter 's'";

      assertThat(sassy.onlyDweebsRiposteTo(chatText)).isEqualTo(expectedSassiness);
    }
  }
}
