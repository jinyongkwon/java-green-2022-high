package site.metacoding.ex23;

public class ThreadEx04 {
    public static void main(String[] args) {
        // 화살표 함수 = 메서드만 넘기게 해주는 문법 => 코드 가독성이 매우 좋아짐.
        Thread t1 = new Thread(() -> { // 화살표 함수 => 화살표 함수가 들어오면 {}내부 스택을 run()으로 인식함.
            // 이부분이 run 메서드 내부
        });
        t1.start();
        System.out.println("메인쓰레드 종료");
    }
}
