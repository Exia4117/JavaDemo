import org.junit.Test;

public class AlgorithmTest {
    public static int getSum(int a, int b) {
        int result = a ^ b; // 按位加
        int carry = (a & b) << 1; // 计算进位
        if(carry!=0) return  getSum(result,carry); //判断进位与处理
        return result;
    }

    public static char findTheDifference(String s, String t) {
        int[] alph = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alph[(int) (s.charAt(i) - 'a')]++;
            alph[(int) (t.charAt(i) - 'a')]--;
        }
        alph[(int) (t.charAt(t.length() - 1) - 'a')]--;
        int i = 0;
        for (; i < 26; i++) {
            if (alph[i] < 0)
                break;
        }
        return (char) ('a' + i);
    }

    public static void main(String[] args) {
//        System.out.println(getSum(113,981));
        System.out.println(findTheDifference("abcd","abcde"));
    }
}
