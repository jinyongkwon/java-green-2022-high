package site.metacoding.ex23;

// 스레드가 컨텍스트 스위칭할때는 내부적으로 0.00000001초라도 졸고 넘어간다.
// 하나의 프로세스안에 여러개의 스레드가 동작한다.
// 스레드 일시 정지 하는 법

// 2초씩 자고 움직인다.
class Monster {
    int x = 10;
    int speed = 1; // 1초마다
    boolean isActive = true;
}

class Host {
    int x = 0;
    int speed = 2; // 1초마다
    boolean isActive = true;
}

// 실습 -> Host의 speed를 로 만들고, Monster는 잠자지 않는다.

public class ThreadEx05 {
    public static void main(String[] args) {
        Monster m = new Monster();
        Host h = new Host();
        System.out.println("게임 시작");
        Thread t1 = new Thread(() -> {
            while (true) {
                try {
                    m.x = m.speed + m.x;
                    System.out.println("Monster의 위치는 : " + m.x);
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (m.isActive == false) {
                    break;
                }
            }
        });
        Thread t2 = new Thread(() -> {
            while (true) {
                try {
                    h.x = h.speed + h.x;
                    System.out.println("host의 위치는 : " + h.x);
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (h.isActive == false) {
                    break;
                }
            }
        });
        t1.start();
        t2.start();
        while (true) { // while을 돌면서 sleep를 쓰지 않으면 최대퍼포먼스를 쓰기때문에 다른 쓰레드로 넘어가지 못함.
            if (h.x >= m.x) { // 충돌감지 할때는 같다고하면 절대 안된다. => 충돌이 안날수도 있기때문!!
                System.out.println("================");
                System.out.println("몬스터가 죽었어요");
                System.out.println("게임 끝");
                h.isActive = false;
                m.isActive = false;
                break;
            } else { // sysout 할때도 잠깐 쉰다 => CPU에서 일하는게 아니라 모니터에서 출력하는것이라 잠깐 쉰다.
                System.out.println("================");
                System.out.println("게임 진행 중");
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
