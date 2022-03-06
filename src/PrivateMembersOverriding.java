public class PrivateMembersOverriding {


}

class Outer{
    private String msg = "Geek for geeks";

    public void fun(){
        System.out.println("Outer fun");
    }
}

class Inner extends Outer{
    public void fun(){
        System.out.println("Accessing private member of outer: ");
    }

    public static void main(String[] args) {
        Outer o = new Inner();

    }

}
