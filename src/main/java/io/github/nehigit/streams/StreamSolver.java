package io.github.nehigit.streams;

import java.util.List;

public class StreamSolver {
    public static void zadanie1() {
        /*
        1. Mamy listę liczb. Napisz strumień, który wyliczy średnią liczb pomijając
        liczby kończące się cyfrą 9 oraz cyfrą 7.

        Przykład [45, 39, 17, 25, 10, 4] -> 21.0
         */

        final List<Integer> ints = List.of(
                45, 39, 17, 25, 10, 4
        );

        System.out.println("Zadanie 1:");

        ints.stream()
                .filter(num -> {
                    int lastDigit = num % 10;
                    return lastDigit != 9 && lastDigit != 7;
                })
                .mapToInt(Integer::intValue)
                .average()
                .ifPresent(System.out::println);
    }

    public static void zadanie2() {
        /*
        2. Mamy listę liczb. Napisz strumień, który wypisuje liczby podniesione do kwadratu i powiększone o 9,
        pomijając wyniki zawierające cyfrę 9.

        Przykład [3, 10, 9, 4] -> [18, 25]
        3 -> 3^2 + 9 -> 18
        10 -> 10^2 + 9 -> 109 - zawiera cyfrę 9
        9 -> 9^2 + 9 -> 90 - zawiera cyfrę 9
        4 -> 4^2 + 9 -> 25
         */

        final List<Integer> ints = List.of(
                3, 10, 9, 4
        );

        System.out.println("\nZadanie 2:");

        ints.stream()
                .map(num -> (num * num) + 9)
                .filter(num -> !String.valueOf(num).contains("9"))
                .forEach(System.out::println);
    }

    public static void zadanie3() {
        /*
        3. Mamy listę stringów. Napisz strumień który na koniec każdego stringa doda "y" i wypisze te stringi,
        pomijając te które zawierają "yy" w dowolnym miejscu.

        Przykład ["aa", "cy", "b", "yycd", "c"] -> ["aay", "by", "cy"]
         */

        final List<String> strings = List.of(
                "aa", "cy", "b", "yycd", "c"
        );

        System.out.println("\nZadanie 3:");

        strings.stream()
                .map(s -> s + "y")
                .filter(s -> !s.contains("yy"))
                .forEach(System.out::println);
    }
}
