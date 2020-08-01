## 双指针问题

### 同向指针问题
BinarySearch：二分搜索，典型的双指针问题，循环不变量，变量的定义，边界的考虑

[26 删除重复元素](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/)


[27 删除元素](https://leetcode-cn.com/problems/remove-element/comments/)
快慢指针

[75 Sort Colors](https://leetcode-cn.com/problems/sort-colors/)
Three-ways Quick Sort 

[80 删除重复元素2	](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/)

[88 Merge Sorted Array](https://leetcode-cn.com/problems/merge-sorted-array/)  
Merge Sort

[215 Kth Largest Element in an Array](https://leetcode-cn.com/problems/kth-largest-element-in-an-array/)  
Quick Sort，这道题如果是维护一个动态的数组（不断有元素进来或者出去），用最小堆应该是最好的选择，维护k个元素，当新来的元素比最小的元素大时，就替换掉堆顶的元素，进行siftDown操作，这样每次堆顶都是第K大的元素。
但快排的方法应该是更快一些，在LeetCode上我先进行了最原始的快排，然后依次进行减少交换次数，增加随机步骤等优化，运行速度也有可见的提升。

[283 移动零](https://leetcode-cn.com/problems/move-zeroes/)  
使用双指针，快慢指针

### 对撞指针问题
[167 Two Sum II - Input array is sorted](https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/)  
对撞指针的问题一般除了指针本身，个人觉得指针移动的条件也非常重要

[125 Valid Palindrome](https://leetcode-cn.com/problems/valid-palindrome/)

[11 Container With Most Water](https://leetcode-cn.com/problems/container-with-most-water/)

### 滑动窗口
[209 Minimum Size Subarray Sum](https://leetcode-cn.com/problems/minimum-size-subarray-sum/)  
[3 Longest Substring Without Repeating Characters](https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/)  
[438 Find All Anagrams in a String](https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/)  
[28 实现strStr()](https://leetcode-cn.com/problems/implement-strstr/)  
