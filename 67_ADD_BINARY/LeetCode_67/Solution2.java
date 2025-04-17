package LeetCode_67;

public class Solution2 {
    private static final int zero = "0".codePointAt(0);

    /*
    private final static String[][] sumWithCarry0 = { {"0", "1"}, {"1", "0"}};
    private final static int[][] carryWithCarry0 = { {0, 0}, {0, 1}};

    private final static String[][] sumWithCarry1 = { {"1", "0"}, {"0", "1"}};
    private final static int[][] carryWithCarry1 = { {0, 1}, {1, 1}};
    */

    private static int[][] sumWithCarry0 = new int[50][50];
    private final static int[][] carryWithCarry0 = new int[50][50];
    private static int[][] sumWithCarry1 = new int[50][50];
    private final static int[][] carryWithCarry1 = new int[50][50];

    public static void  initializeArrays() {
        sumWithCarry0[48][49] = 1;
        sumWithCarry0[49][48] = 1;
        carryWithCarry0[49][49] = 1;

        sumWithCarry1[48][48] = 1;
        sumWithCarry1[49][49] = 1;
        carryWithCarry1[48][49] = 1;
        carryWithCarry1[49][48] = 1;
        carryWithCarry1[49][49] = 1;

    }
    public static int addWithCarry(int a, int b, int carry) {
        if (carry == 0) {
            return sumWithCarry0[a][b];
        } else {
            return sumWithCarry1[a][b];
        }
    }
    public static void main(String[] args) {
        int carry = 0;
        char a = '0';
        char b = '0';

        StringBuffer sb = new StringBuffer();

        initializeArrays();
        char sum = '0';
        char newCarry = '0';
        char bitValue = 48;
        if (carry == 0) {
            sum += sumWithCarry0[(int)a][(int)b];
            newCarry += carryWithCarry0[(int)a][(int)b];
        } else {
            // carry = 1
            sum += sumWithCarry1[(int)a][(int)b];
            newCarry += carryWithCarry1[(int)a][(int)b];
        }

        System.out.println("sum: " + sum);
        System.out.println("new carry: " + newCarry);

        sb.append(sum);
        if (newCarry == '1') {
            sb.append(newCarry);
        }

        StringBuffer reverseStr = new StringBuffer();
        for (int i = sb.length()-1; i >= 0; i--) {
            reverseStr.append(sb.charAt(i));
        }
        System.out.println("result: " + reverseStr);
        /*
        StringBuffer result = new StringBuffer("11001");
        StringBuffer reverseStr = new StringBuffer();
        for (int i = result.length()-1; i >= 0; i--) {
            reverseStr.append(result.charAt(i));
        }
        System.out.println("reverse string: " + reverseStr);

        System.out.println("0 char #: " + (int) a);
        System.out.println("1 char #: " + (int) b);
        */
        /*System.out.println(sumWithCarry0[0][0]); */
        // char 0 = 48, char 1 = 49

    }
}
