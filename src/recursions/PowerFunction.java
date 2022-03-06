package recursions;

public class PowerFunction {

    public double myPow(double x, int n) {
        long pow = n;

        if(n < 0){
            x = 1 / x;
            pow = -pow;
        }

        return fastPower(x, pow);
    }

    private double fastPower(double x, long n){
        if(n == 0)
            return 1;

        double half = fastPower(x, n/2);
        if(n % 2 == 0)
            return half * half;
        else
            return half * half * x;
    }

    public static void main(String[] args) {
        PowerFunction powerFunction = new PowerFunction();
        double power = powerFunction.myPow(2, 20);
        System.out.println(power);

    }
}
