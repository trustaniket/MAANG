import java.util.HashMap;
import java.util.Map;

public class TestEnumClass {

    public static void main(String[] args) {

        String abc = "FR_1234556_FDGS_434";
        System.out.println(abc.startsWith("FR"));

        Map<Long, Boolean> map = new HashMap<>();

        boolean myName = true;
        myName = map.get(1l);
        System.out.println(myName);
    }
}
