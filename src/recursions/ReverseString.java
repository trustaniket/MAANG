package recursions;

public class ReverseString {

    public static void main(String[] args) {
        char[] arr = {'h', 'e', 'l', 'l', 'o'};
        reverseInPlace(arr);
        System.out.println(arr);
    }

    private static void reverseInPlace(char[] arr){
        helper(arr, 0, arr.length -1);
    }

    private static void helper(char[] arr, int start, int end){
        if(start >= end)
            return;
        char temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;

        helper(arr, start+1, end -1);
    }
}
