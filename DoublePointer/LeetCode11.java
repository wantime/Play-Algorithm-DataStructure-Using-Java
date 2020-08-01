public class LeetCode11 {

    public int maxArea(int[] height) {

        int l = 0;
        int r = height.length - 1;
        int maxVolume = 0;
        while (l < r){

            int h = Math.min(height[l], height[r]);
            maxVolume = Math.max(maxVolume, (r - l) * h);

            if( h == height[l])
                l ++;
            else
                r --;
        }
        return maxVolume;
    }
}
