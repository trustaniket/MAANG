package recursions;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {



        public static void main(String[] args) {
            GenerateParenthesis generateParenthesis = new GenerateParenthesis();
            generateParenthesis.generateParenthesis(3);
        }
        public List<String> generateParenthesis(int n) {
            List<String> ans = new ArrayList<>();
            backtrack(ans, new StringBuilder(), 0, 0, n);
            return ans;
        }

        private void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max){
            if (cur.length() == max * 2) {
                ans.add(cur.toString());
                return;
            }

            if (open < max) {
                cur.append("(");
                backtrack(ans, cur, open+1, close, max);
                cur.deleteCharAt(cur.length() - 1);
            }
            if (close < open) {
                cur.append(")");
                backtrack(ans, cur, open, close+1, max);
                cur.deleteCharAt(cur.length() - 1);
            }
        }

}
