package site.metacoding.ex21;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DivideByZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 통신, 사용자 입력 예외처리 !!
        // 사용자에게 받을때는 무조건 넣는게 좋다
        // InputMismatchException

        boolean check = true;
        // 숫자 넣을때 까지 반복해보게끔 만들기
        try {
            int x = sc.nextInt();
            int result = x / 0; // ArithmeticException에러 뜸
            System.out.println("받은 값 : " + x);
            check = false;
        } catch (InputMismatchException e) {
            System.out.println("문자를 넣지마 좀!!");
            e.printStackTrace();
            // 이렇게 잡으면 끝이 없음.
        } catch (ArithmeticException e) { // ArithmeticException catch추가
            System.out.println("0 나누지마 좀!!");
            e.printStackTrace();
        }

    }
}
