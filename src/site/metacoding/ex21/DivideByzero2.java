package site.metacoding.ex21;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DivideByzero2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 통신, 사용자 입력 예외처리 !!
        // 사용자에게 받을때는 무조건 넣는게 좋다
        // InputMismatchException

        boolean check = true;

        // 숫자 넣을때 까지 반복해보게끔 만들기
        while (check) {
            try {
                int x = sc.nextInt(); // 가를 넣으면 버퍼가 비어지지 않아서 스캐너가 망가짐.
                System.out.println("받은 값 : " + x);
                check = false;
            } catch (Exception e) { // 이게 가장 좋은 예외처리 방법
                System.out.println("============");
                System.out.println(e.getMessage());
                System.out.println("============");
                e.printStackTrace();
                // sc = new Scanner(System.in); // 1. 스캐너를 다시 만드는 방법'
                sc.nextLine(); // 2. Buffer를 다시 비워준다. // 무조건 버퍼를 비워!
            }
        }
    }
}
