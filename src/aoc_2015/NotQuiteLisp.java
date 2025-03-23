package aoc_2015;

public class NotQuiteLisp {

  int solve(char[] input) {
    int res = 0;
    for (int i = 0; i < input.length; i++) {
      char c = input[i];
      if (c == '(') {
        res++;
      } else if (c == ')') {
        res--;
      }

      if (res == -1) {
        return i + 1;
      }
    }
    return res;
  }

  public static void main(String[] args) {
    System.out.println(new NotQuiteLisp().solve(args[0].toCharArray()));
  }
}
