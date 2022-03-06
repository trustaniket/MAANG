package recursions;

public class KthGrammarRec {

    public int kthGrammar(int n, int k) {
        if(n == 1 && k == 1)
            return 0;
        int pow = (int)Math.pow(2, (n-1))/2;
        if(k <= pow){
            return kthGrammar(n-1, k);
        } else{
            int t = kthGrammar(n-1, k - pow);
            return t^1;
        }
    }

    public static void main(String[] args) {
        KthGrammarRec rec = new KthGrammarRec();
        int out = rec.kthGrammar(5, 6);
        System.out.println(out);
    }
}
