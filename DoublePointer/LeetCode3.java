public class LeetCode3 {

    public int lengthOfLongestSubstring(String s) {
        int[] freq = new int[256];

        int i = 0;
        int j = 0;
        int maxLen = 0;
        while (i < s.length()){
            if(j < s.length() && freq[s.charAt(j)] == 0) {

                maxLen = Math.max(maxLen, j-i+1);
                freq[s.charAt(j)] ++;
                j ++;
            }
            else {
                freq[s.charAt(i)] --;
                i++;
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        new LeetCode3().lengthOfLongestSubstring("abcabcbb");
    }
}
