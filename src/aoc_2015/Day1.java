package aoc_2015;

public class Day1 {

  int part1(char[] input) {
    int res = 0;
    for (char c : input) {
      if (c == '(') {
        res++;
      } else if (c == ')') {
        res--;
      }
    }
    return res;
  }


  Integer part2(char[] input) {
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
    return null;
  }

  public static void main(String[] args) {
    Day1 day1 = new Day1();
    char[] input = args[0].toCharArray();
    System.out.println(day1.part1(input));
    System.out.println(day1.part2(input));
  }
}
