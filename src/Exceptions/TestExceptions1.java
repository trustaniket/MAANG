package Exceptions;

import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TestExceptions1 {

    class Item {
        int num;
        int index;
    }

    public static void main(String[] args) {
        //TestExceptions1 testExceptions1 = new TestExceptions1();
        //testExceptions1.show();
        PriorityQueue<Item> q = new PriorityQueue<>();

        System.out.println(q.peek());
    }

    public void show()  {
        try{
            show2();
        } catch (NullPointerException e){
            throw e;
        }
        catch (Exception e){
            System.out.println("I am here");
        }
    }

    public void show2()  {
        throw new NullPointerException();
    }
}
