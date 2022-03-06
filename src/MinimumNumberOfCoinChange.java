import java.util.Arrays;

public class MinimumNumberOfCoinChange {

    public static void main(String[] args) {
        System.out.println(minNumberOfCoinsForChange(7, new int[]{1,5,10}));
    }

    public static int minNumberOfCoinsForChange(int n, int[] denoms) {
        int[] numOfCoins = new int[n+1];
        Arrays.fill(numOfCoins, Integer.MAX_VALUE);
        int toCompare;
        numOfCoins[0] = 0;

        for(int denom : denoms){
            for(int i = 0; i < numOfCoins.length; i++){
                if(denom <= i){
                    if(numOfCoins[i - denom] == Integer.MAX_VALUE){
                       toCompare = numOfCoins[i - denom];
                    }else {
                        toCompare = numOfCoins[i - denom] + 1;
                    }

                    numOfCoins[i] = Math.min(numOfCoins[i], toCompare);
                }
            }
        }
        return numOfCoins[n] != Integer.MAX_VALUE ? numOfCoins[n] : -1;
    }
}
