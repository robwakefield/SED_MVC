package ic.doc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RPCguiTest {

  private final TextView txtView = new TextView();
  private final Model model = new Model();

  @Test
  public void canAdd() {
    model.addObserver(txtView);
    model.push(2);
    model.push(4);
    model.add();
    assertEquals(txtView.getStackString(), "6");
  }

  @Test
  public void canSubtract() {
    model.addObserver(txtView);
    model.push(2);
    model.push(4);
    model.sub();
    assertEquals(txtView.getStackString(), "2");
  }

  @Test
  public void canAddAndSubtract() {
    model.addObserver(txtView);
    model.push(5);
    model.push(3);
    model.add();
    model.push(3);
    model.push(1);
    model.add();
    model.sub();
    assertEquals(txtView.getStackString(), "-4");
  }

  @Test
  public void ignoresRepeatedAdd() {
    model.addObserver(txtView);
    model.push(3);
    model.push(3);
    model.add();
    model.add();
    assertEquals(txtView.getStackString(), "6");
  }

  @Test
  public void ignoresPreviousRepeatedAdd() {
    model.addObserver(txtView);
    model.add();
    model.add();
    model.push(2);
    model.push(2);
    model.add();
    assertEquals(txtView.getStackString(), "4");
  }

  @Test
  public void ignoresRepeatedSubtract() {
    model.addObserver(txtView);
    model.push(2);
    model.push(2);
    model.sub();
    model.sub();
    assertEquals(txtView.getStackString(), "0");
  }

  @Test
  public void ignoresPreviousRepeatedSubtract() {
    model.addObserver(txtView);
    model.sub();
    model.sub();
    model.push(2);
    model.push(2);
    model.sub();
    assertEquals(txtView.getStackString(), "0");
  }

  @Test
  public void clears() {
    model.addObserver(txtView);
    model.push(2);
    model.push(2);
    model.add();
    model.clear();
    assertEquals(txtView.getStackString(), "");
  }

  @Test
  public void printsStackCorrectly() {
    model.addObserver(txtView);
    model.push(3);
    model.push(2);
    assertEquals(txtView.getStackString(), "3 2");
  }

}
