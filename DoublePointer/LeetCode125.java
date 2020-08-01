public class LeetCode125 {

    public boolean isPalindrome(String s) {

        int l = 0;
        int r = s.length();
        while (l < r) {
            while (!Character.isAlphabetic(s.charAt(l))) l++;
            while (!Character.isAlphabetic(s.charAt(r))) r--;

            if (l < r)
                if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r)))
                    return false;
            l ++;
            r --;
        }
        return true;
    }
}
