package aoc_2015;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Day2 {

  record Dimensions(int l, int w, int h) {
  }

  Integer part1(List<Dimensions> dimensionsList) {
    return dimensionsList.stream()
      .map(dimensions -> {
        int area1 = dimensions.l * dimensions.w;
        int area2 = dimensions.l * dimensions.h;
        int area3 = dimensions.w * dimensions.h;
        int surfaceArea = 2 * area1 + 2 * area2 + 2 * area3;
        int extra = Math.min(Math.min(area1, area2), area3);
        return surfaceArea + extra;
      })
      .reduce(Integer::sum)
      .orElseThrow(RuntimeException::new);
  }

  Integer part2(List<Dimensions> dimensionsList) {
    return dimensionsList.stream()
      .map(dimensions -> {
        List<Integer> list = Stream.of(dimensions.l, dimensions.w, dimensions.h)
          .sorted()
          .limit(2)
          .toList();
        Integer smallest = list.get(0);
        Integer secondSmallest = list.get(1);
        return (smallest + smallest + secondSmallest + secondSmallest) + (dimensions.l * dimensions.w * dimensions.h);
      })
      .reduce(Integer::sum)
      .orElseThrow(RuntimeException::new);
  }

  public static void main(String[] args) {
    List<Dimensions> dimensionsList = Arrays.stream(args)
      .map(arg -> {
        String[] xes = arg.split("x");
        return new Dimensions(Integer.parseInt(xes[0]), Integer.parseInt(xes[1]), Integer.parseInt(xes[2]));
      })
      .toList();
    Day2 day2 = new Day2();
    System.out.println(day2.part1(dimensionsList));
    System.out.println(day2.part2(dimensionsList));
  }
}
