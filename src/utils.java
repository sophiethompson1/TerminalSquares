public class utils {

  public static boolean isRed(String string) {
    return string.equals("red") || string.equals("RED") || string.equals("R") || string.equals("r")
            || string.equals("Red");
  }

  public static boolean isBlue(String string) {
    return string.equals("blue") || string.equals("BLUE") || string.equals("Blue") || string.equals("b")
            || string.equals("B");
  }

  public static boolean isColour(String string) {
    return isBlue(string) || isRed(string);
  }


}