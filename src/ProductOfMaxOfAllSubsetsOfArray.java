import java.util.Arrays;

public class ProductOfMaxOfAllSubsetsOfArray {

    static long maximumProduct(int arr[], int N)
    {
        long mod = 1000000007;

        // Sort the given array arr[]
        Arrays.sort(arr);

        // Stores the power of 2
        long power[] = new long[N + 1];
        power[0] = 1;

        // Calculate the power of 2
        for(int i = 1; i <= N; i++)
        {
            power[i] = 2 * power[i - 1];
            power[i] %= mod;
        }

        // Stores the resultant product
        long result = 1;

        // Traverse the array from the back
        for(int i = N - 1; i > 0; i--)
        {

            // Find the value of 2^i - 1
            long value = (power[i] - 1);

            // Iterate value number of times
            for(int j = 0; j < value; j++)
            {

                // Multiply value with
                // the result
                result *= arr[i];
                result %= mod;
            }
        }

        // Calculate the product of array
        // elements with result to consider
        // the subset of size 1
        for(int i = 0; i < N; i++)
        {
            result *= arr[i];
            result %= mod;
        }

        // Return the resultant product
        return result;
    }

    // Driver Code
    public static void main(String[] args)
    {
        int arr[] = { 1, 2, 3 };
        int N = arr.length;

        System.out.println(maximumProduct(arr, N));
    }
}
