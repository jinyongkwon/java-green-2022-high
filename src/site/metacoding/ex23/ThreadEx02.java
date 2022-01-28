package site.metacoding.ex23;

class NewWorker implements Runnable {

    // 타겟
    @Override
    public void run() {
        for (int i = 1; i < 6; i++) {
            try {
                System.out.println("뉴워커스레드 : " + i);
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

public class ThreadEx02 {

    // MainThread의 타겟은 main 메서드
    // 타겟 = task : 임무
    public static void main(String[] args) {

        // 일의 순서가 없는걸 비동기 프로그램이라함.
        // NewWorker 생성
        Thread NewWorker = new Thread(new NewWorker());
        NewWorker.start(); // run() 메서드 호출
        // 메인과 런이 같이실행됨

        for (int i = 1; i < 6; i++) {
            try {
                System.out.println("메인스레드 : " + i);
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
