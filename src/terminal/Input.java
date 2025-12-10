package terminal;

import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;

public class Input {
    Scanner scanner = new Scanner(System.in);

    public String readLine() {
        return scanner.nextLine();
    }

    public <T> T getValue(String message, Function<String, T> parser, Predicate<T> validator) {
        if (message != null && !message.isEmpty()) {
            System.out.println(message);
        }

        T value;
        boolean isValid;
        do {
            System.out.print("> ");
            value = parser.apply(readLine());
            isValid = validator.test(value);
            if (!isValid) {
                System.out.println("Please, input valid data");
            }
        } while (!isValid);

        System.out.println();
        return value;
    }
}
