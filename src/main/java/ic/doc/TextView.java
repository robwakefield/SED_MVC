package ic.doc;

public class TextView implements Updatable {

  private String stackString;

  public String getStackString() {
    return stackString;
  }

  @Override
  public void update(Model model) {
    stackString = model.stackToString();
  }
}
