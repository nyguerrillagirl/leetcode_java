package LeetCode_67;

// 1. 3ms , 24.73%
public class Solution {
    private static final int zero = "0".codePointAt(0);

    public String addBinary(String a, String b) {
        int positionA = a.length()-1;
        int positionB = b.length()-1;
        int carry = 0; /* holds the current carry value */
        StringBuffer result = new StringBuffer();
        while (positionA >= 0 || positionB >= 0) {
            int sum = carry;
            if (positionA >= 0) {
                sum += a.charAt(positionA) - zero;
                --positionA;
            }
            if (positionB >= 0) {
                sum += b.charAt(positionB) - zero;
                --positionB;
            }
            if (sum > 1) {
                carry = 1;
                sum -= 2;
                result.append(sum);
            } else {
                carry = 0;
                result.append(sum);
            }
        }
        if (carry != 0) {
            result.append(carry);
        }
        StringBuffer reverseStr = new StringBuffer();
        for (int i = result.length()-1; i >= 0; i--) {
            reverseStr.append(result.charAt(i));
        }
        return reverseStr.toString();

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String a = "1100";
        String b = "10";
        // 11 + 10 = 101
        System.out.println(solution.addBinary(a, b));
    }
}
