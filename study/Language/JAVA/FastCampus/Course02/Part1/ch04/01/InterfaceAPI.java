package fc.java.course2.part1;
import fc.java.model2.*;

public class InterfaceAPI {
    public static void main(String[] args) {
        CC cc = new BB();
        // BB 의 x,y,z 가 동작 => 동적 바인딩
        cc.x();
        cc.y();
        cc.z();
    }
}
