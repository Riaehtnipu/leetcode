package algorithm.offer.q64;

class Solution {

    // 不做参数校验了，因为需要if
    // public int sumNums(int n) {
    //     // 从if演化过来，无关变量是用来通过编译的
    //     boolean flag = (n > 1) && (n += sumNums(n - 1)) > 0;
    //     return n;
    // }

    // public int sumNums(int n) {
    //     return sum(n, 0);
    // }

    // // 求1到n，再加total的值
    // int sum(int n, int total) {
    //     boolean flag = (n > 0) && (total = sum(n - 1, n + total)) > 0;
    //     return total;
    // }

    public int sumNums(int n) {
        int a = 1 + n;
        int b = n;

        int res = 0;

        // 编译用
        boolean flag;

        flag = ((b & 1) == 1) && (res += a) > 0;
        a <<= 1;
        b >>= 1;

        flag = ((b & 1) == 1) && (res += a) > 0;
        a <<= 1;
        b >>= 1;

        flag = ((b & 1) == 1) && (res += a) > 0;
        a <<= 1;
        b >>= 1;

        flag = ((b & 1) == 1) && (res += a) > 0;
        a <<= 1;
        b >>= 1;

        flag = ((b & 1) == 1) && (res += a) > 0;
        a <<= 1;
        b >>= 1;

        flag = ((b & 1) == 1) && (res += a) > 0;
        a <<= 1;
        b >>= 1;

        flag = ((b & 1) == 1) && (res += a) > 0;
        a <<= 1;
        b >>= 1;

        flag = ((b & 1) == 1) && (res += a) > 0;
        a <<= 1;
        b >>= 1;

        flag = ((b & 1) == 1) && (res += a) > 0;
        a <<= 1;
        b >>= 1;

        flag = ((b & 1) == 1) && (res += a) > 0;
        a <<= 1;
        b >>= 1;

        flag = ((b & 1) == 1) && (res += a) > 0;
        a <<= 1;
        b >>= 1;

        flag = ((b & 1) == 1) && (res += a) > 0;
        a <<= 1;
        b >>= 1;

        flag = ((b & 1) == 1) && (res += a) > 0;
        a <<= 1;
        b >>= 1;

        flag = ((b & 1) == 1) && (res += a) > 0;
        a <<= 1;
        b >>= 1;

        return res >> 1;
    }
}
