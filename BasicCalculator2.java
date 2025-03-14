import java.util.Stack;

/*
 * TC: O(n) where n is the length of the expression
 * SC: O(n)
 */
public class BasicCalculator2 {
    public int calculate(String s) {
        Stack<Integer> operands = new Stack<>();
        int n = 0;
        char operator = '+';
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // skip spaces (except for the last character)
            if(i != s.length() - 1 && c == ' ') continue;
            // if digit, calculate the number
            if(Character.isDigit(c)) {
                n = n * 10 + s.charAt(i) - '0';
            }
            // if operator or end of string, push to stack based on operator
            if(!Character.isDigit(c) || i == s.length() - 1) {
                if(operator == '+') {
                    operands.push(n);
                } else if(operator == '-') {
                    operands.push(-n);
                } else if(operator == '*') {
                    operands.push(operands.pop() * n);
                } else {
                    operands.push(operands.pop() / n);
                }
                operator = c;
                n = 0;
            }
        }
        // add the remaining elements in stack to get the result
        int result = operands.pop();
        while(!operands.isEmpty()) {
            result += operands.pop();
        }
        return result;
    }
}