import rating.Score;
import rating.Stats;
import terminal.Terminal;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Terminal t = new Terminal();

        System.out.println("Welcome to score stats calculator!");
        System.out.println("To proceed with the stats, please enter score points.");
        System.out.println("Use dots to separate decimals. To finish input, press enter.");

        Function<String, Score> parser = (String s) -> {
            if (s == null || s.isEmpty()) return null;
            return Score.fromString(s);
        };
        Predicate<Score> validator = (Score s) -> s.getValue() >= 0 && s.getValue() <= 100;

        List<Score> scores = t.in.getValues("Score points:", parser, validator);
        Stats stats = Stats.of(scores);

        System.out.println("Here's the stats:");
        System.out.printf("Min: %.2f\nMax: %.2f\nSum: %.2f\nAvg: %.2f\n", stats.min, stats.max, stats.sum, stats.avg);
    }
}