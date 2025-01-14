package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// 문자열 파싱 및 계산
public class StringParser {

    // 문자열 파싱 및 계산
    public static int parseAndCalculate(String input) {
        String delimiter = ",|:"; // 기본 구분자
        String numbers = input;

        // 커스텀 구분자 확인
        Matcher matcher = Pattern.compile("//(.)\\n(.*)").matcher(input);
        if (matcher.matches()) {
            delimiter = Pattern.quote(matcher.group(1));
            numbers = matcher.group(2);
        }

        return sumNumber(numbers, delimiter);
    }

    // 숫자 합산
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

    // 숫자 분리
    private static String[] separateNumber(String numbers, String delimiter) {
        return numbers.split(delimiter);
    }

    // 숫자 변환
    private static int convertNumber(String token) {
        try {
            int number = Integer.parseInt(token.trim());
            InputValidator.validateIsInputNegative(number);
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바르지 않은 숫자 입력: " + token, e);
        }
    }
}

