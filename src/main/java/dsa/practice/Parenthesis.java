package dsa.practice;

import java.util.ArrayList;
import java.util.List;

public class Parenthesis {
    List<String> ans;
    void generateParenthesis(int n, int opened, int closed, StringBuilder cur) {
        if (2*n == cur.length()) {
            ans.add(cur.toString());
//
            return;
        }
        if (opened<n) {
            cur.append("(");
            generateParenthesis(n, opened+1, closed, cur);
            cur.setLength(cur.length() - 1);
        }

        if (opened> closed) {
            cur.append(")");
            generateParenthesis(n, opened, closed+1, cur);
            cur.setLength(cur.length() - 1);
        }
    }
    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        generateParenthesis(n, 0, 0, new StringBuilder());
        return ans;
    }
}
