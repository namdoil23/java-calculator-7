package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = InputReader.readInput();

        // 빈 입력값일 경우 결과를 0으로 반환
        if (InputValidator.isInputEmpty(input)) {
            System.out.println("result : 0");
            return;
        }
        int result = String(input);
        System.out.println("result : " + result);
    }

    public static int getSeparatorAndNumbers(String input) {
        String delimiter = ",|:";
        String numbers = input;

        Matcher matcher = Pattern.compile("//(.)\\\\n(.*)").matcher(input);
        if (matcher.matches()) {
            delimiter = Pattern.quote(matcher.group(1));
            numbers = matcher.group(2);
        }

        return sumNumber(numbers, delimiter);
    }

    private static int sumNumber(String numbers, String delimiter) {
        String[] tokens = separateNumber(numbers, delimiter);
        int sum = 0;

        for (String token : tokens) {
            if (!token.isEmpty()) {
                int number = convertNumber(token);
                sum += number;
            }
        }
        return sum;
    }

    private static String[] separateNumber(String numbers, String delimiter) {
        return numbers.split(delimiter);
    }

    private static int convertNumber(String token) {
        int number = Integer.parseInt(token);
        validateIsInputNegative(number);
        return number;
    }

    // 입력값이 비어 있는지 확인
    private static boolean isInputEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }

    private static void validateIsInputNegative(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다: " + number);
        }
    }
}