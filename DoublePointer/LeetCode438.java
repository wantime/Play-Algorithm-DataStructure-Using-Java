import java.util.ArrayList;
import java.util.List;

public class LeetCode438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList();
        if(s.length() < p.length())
            return res;
        assert p.length() > 0;

        char[] arrS = s.toCharArray();
        char[] arrP = p.toCharArray();

        // 定义一个 needs 数组来看 arrP 中包含元素的个数
        int[] freq_p = new int[26];
        // 定义一个 window 数组来看滑动窗口中是否有 arrP 中的元素，并记录出现的个数
        int[] freq_s = new int[26];

        // 先将 arrP 中的元素保存到 needs 数组中
        for (int i = 0; i < arrP.length; i++) {
            freq_p[arrP[i] - 'a'] ++;
        }
        // 在s[l...r]中的元素与p进行比对，一开始这个区间里没有元素，所以r为-1
        int l = 0;
        int r = -1;
        //Sliding window: s[l...r] r - l + 1<= p.length()
        //if freq_s[r] < freq_p[r] r++
        //if freq_s[r] > freq_p[r]  freq_s[l]-- && l++，也就是窗口左边界移动
        //if freq_s[r] == freq_[r]
        //if r - l + 1 == p.length()
        //res.add(l) && l++ && freq_s[l]--
        // 右窗口开始不断向右移动
        while ( r + 1 < arrS.length ) {

            if( r - l + 1 < arrP.length )
                freq_s[arrS[++r] - 'a'] ++;

            while( freq_s[arrS[r] - 'a'] > freq_p[arrS[r] - 'a'] && l < arrS.length)
                freq_s[arrS[l++] - 'a'] --;

            if( r - l + 1 == arrP.length ){
                res.add(l);
                freq_s[arrS[l++] - 'a'] --;
            }
        }
        return res;
    }
}
