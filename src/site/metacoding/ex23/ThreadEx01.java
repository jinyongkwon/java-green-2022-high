package site.metacoding.ex23;

public class ThreadEx01 {
    public static void main(String[] args) {
        System.out.println(1);
        try {
            // cpu에게 2초동안 휴식을줌
            Thread.sleep(2000);// 밀리세컨즈 1/1000초
        } catch (Exception e) {
            // 컴퓨터 자체가 뻗을때 발생 = 잠잘때가 아니야!!
            e.printStackTrace();
        }
        System.out.println(2);
    }
}
