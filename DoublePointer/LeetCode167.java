public class LeetCode167 {

    public int[] twoSum(int[] numbers, int target) {

        int i = 0, j = numbers.length - 1;
        while (i < j){
            if(numbers[i] + numbers[j] == target)
                break;
            if(numbers[i] + numbers[j] > target)
                j --;
            else //if(numbers[i] + numbers[j] < target)
                i ++;
        }
        int[] res = new int[2];
        res[0] = i + 1;
        res[1] = j + 1;
        return res;
    }
}
