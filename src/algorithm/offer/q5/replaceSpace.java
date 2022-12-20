package algorithm.offer.q5;

class Solution {
    // public String replaceSpace(String s) {
    //     if (s == null || s.length() == 0) {
    //         return s;
    //     }

    //     StringBuilder sb  = new StringBuilder();
    //     for (int i = 0; i < s.length(); i++) {
    //         if (s.charAt(i) == ' ') {
    //             sb.append("%20");
    //             continue;
    //         }
    //         sb.append(s.charAt(i));
    //     }
    //     return sb.toString();
    // }

    // // 字符數組
    // public String replaceSpace(String s) {
    //     if (s == null || s.length() == 0) {
    //         return s;
    //     }

    //     char[] charArray = new char[s.length() * 3];
    //     int size = 0;
    //     for (int i = 0; i < s.length(); i++) {
    //         if (s.charAt(i) == ' ') {
    //             charArray[size++] = '%';
    //             charArray[size++] = '2';
    //             charArray[size++] = '0';
    //             continue;
    //         }
    //         charArray[size++] = s.charAt(i);
    //     }
    //     return new String(charArray, 0, size);
    // }

    public String replaceSpace(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        return s.replace(" ", "%20");
    }
}