public class LeetCode88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;  //nums1的指针，指向未放入新数组的第一个元素
        int j = 0;  //nums2的指针，同样指向第一个元素
        int[] tmp = new int[m+n];  //临时数组，用来存放比较过后的数据
        for(int k = 0; k < m + n; k ++) {
            //四种情况
            //首先判断是否到达两个数组的边界
            //第一个数组越界
            if (i > m - 1)
                tmp[k] = nums2[j++];
                //第二个数组越界
            else if (j > n -1 )
                tmp[k] = nums1[i++];
                //nums1[i] < nums2[j]的情况
            else if (nums1[i] < nums2[j])
                tmp[k] = nums1[i++];
            else {//nums1[i] >= nums2[j]
                assert nums1[i] >= nums2[j];
                tmp[k] = nums2[j++];
            }
        }
        for( i = 0; i < m + n; i ++){
            nums1[i] = tmp[i];
        }
    }
}
