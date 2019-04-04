package romannumberconverter;

import org.junit.Test;
import org.junit.Before;

import static org.assertj.core.api.Assertions.*;

public class RomanTest {

  Roman test;

  @Before
  public void setup() {
    test = new Roman();
  }

  @Test
  public void checkCaract() {
    assertThat(test.convert("X"))
      .isEqualTo(10);
  }

  @Test
  public void checkNonReconnu() {
    assertThatThrownBy(() -> assertThat(test.convert("p")))
      .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  public void checkALaSuite() {
    assertThat(test.convert("XX"))
      .isEqualTo(20);
  }

  @Test
  public void checkNombre() {
    assertThat(test.convert(10))
      .isEqualTo("X");
  }

  @Test
  public void checkNombreInconnu() {
    assertThatThrownBy(() -> assertThat(test.convert(6)))
      .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  public void checkGroupement3() {
    assertThat(test.convert("CXXX"))
      .isEqualTo(130);
  }
  @Test
  public void checkGroupement5() {
    assertThatThrownBy(() -> assertThat(test.convert("CXXXX")))
      .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  public void checkLudo() {
    assertThatThrownBy(() -> assertThat(test.convert("CIIX")))
      .isInstanceOf(IllegalArgumentException.class);
  }
  @Test
  public void checkLudo2() {
    assertThat(test.convert("XIC"))
      .isEqualTo(109);
  }





/*
  @Test
  public void check_null() {
    assertThatThrownBy(() -> hello.hello(null))
      .isInstanceOf(IllegalArgumentException.class)
      .hasMessageContaining("cannot be null");
  }*/
}
