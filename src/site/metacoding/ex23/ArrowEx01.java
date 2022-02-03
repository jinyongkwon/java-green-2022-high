package site.metacoding.ex23;

interface Remocon {
    public abstract void on();

    public abstract void off();
}

class Samsung {

    public void 수리를위한테스트(Remocon r) {
        r.on();
    }
}

// 화살표 함수는 추상메서드가 2개이상이면 사용을 못함.
// 추상메서드가 2개이상이면 익명클래스를 사용.
public class ArrowEx01 {
    public static void main(String[] args) {
        Samsung s = new Samsung();
        s.수리를위한테스트(new Remocon() {

            @Override
            public void on() {
                // TODO Auto-generated method stub

            }

            @Override
            public void off() {
                // TODO Auto-generated method stub

            }

        });
    }
}
