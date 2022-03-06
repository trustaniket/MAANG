import java.io.Externalizable;

public class CheckAbstraction implements Comparable<CheckAbstraction> {

    public void show(){
        System.out.println("show");
    }

    @Override
    public int compareTo(CheckAbstraction o) {
        return 0;
    }
}


