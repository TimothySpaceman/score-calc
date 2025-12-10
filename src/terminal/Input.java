package terminal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;

public class Input {
    Scanner scanner = new Scanner(System.in);

    public String readLine() {
        return scanner.nextLine();
    }

    public <T> T getValue(
            String message,
            Function<String, T> parser,
            Predicate<T> validator
    ) {
        return getValue(message, parser, validator, "Please, input valid data");
    }

    public <T> T getValue(
            String message,
            Function<String, T> parser,
            Predicate<T> validator,
            String errorMessage
    ) {
        if (message != null && !message.isEmpty()) {
            System.out.println(message);
        }

        T value = null;
        boolean isValid;
        do {
            System.out.print("> ");
            try {
                value = parser.apply(readLine());
                isValid = validator.test(value);
            } catch (Exception e) {
                isValid = false;
            }
            if (!isValid) {
                System.out.println(errorMessage);
            }
        } while (!isValid);

        System.out.println(message);
        return value;
    }

    public <T> List<T> getValues(
            String message,
            Function<String, T> parser,
            Predicate<T> validator
    ) {
        return getValues(message, parser, validator, "Please, input valid data");
    }

    public <T> List<T> getValues(
            String message,
            Function<String, T> parser,
            Predicate<T> validator,
            String errorMessage
    ) {
        if (message != null && !message.isEmpty()) {
            System.out.println(message);
        }

        List<T> values = new ArrayList<>();

        while (true) {
            System.out.print("> ");
            String input = readLine();

            try {
                T value = parser.apply(input);
                if (value == null) {
                    System.out.println();
                    break;
                }

                if (validator.test(value)) {
                    values.add(value);
                    continue;
                }
            } catch (Exception e) {
            }

            System.out.println(errorMessage);
        }

        return values;
    }

}
