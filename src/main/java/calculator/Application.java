package calculator;



public class Application {

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = InputReader.readInput();

        // 빈 입력값 처리
        if (InputValidator.isInputEmpty(input)) {
            System.out.println("result : 0");
            return;
        }

        try {
            int result = StringParser.parseAndCalculate(input);
            System.out.println("result : " + result);
        } catch (IllegalArgumentException e) {
            System.err.println("에러: " + e.getMessage());
        }
    }
}
