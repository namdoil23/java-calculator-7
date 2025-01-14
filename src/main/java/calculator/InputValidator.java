package calculator;

// 입력 검증 메소드
public class InputValidator {
    // 입력값이 비어 있는지 확인
    public static boolean isInputEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }

    public static void validateIsInputNegative(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다: " + number);
        }
    }
}
