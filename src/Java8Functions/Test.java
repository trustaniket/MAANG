package Java8Functions;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Test {

    private List<MyTestClass> check;

    public List<MyTestClass> getCheck() {
        return check;
    }

    public void setCheck(List<MyTestClass> check) {
        this.check = check;
    }

    public static void main(String[] args) {
        //System.out.println(5/3);
        Test test  = new Test();
        MyTestClass testClass = new MyTestClass();
        testClass.name = "aniket";
        List<MyTestClass> list = new ArrayList<>();
        list.add(testClass);
        test.setCheck(list);
        Optional.ofNullable(test.getCheck()).ifPresent(data -> Optional.ofNullable(data.get(0).name).ifPresent(name -> System.out.println(name)));

        System.out.println("Flower".indexOf("Flo"));


    }

    private static class MyTestClass {
        String name;


    }
}
