## 哈希表相关问题

[1 Two Sum](https://leetcode-cn.com/problems/two-sum/)  

[15 Three Sum](https://leetcode-cn.com/problems/3sum/)  

[16 3 sum Closet](https://leetcode-cn.com/problems/3sum-closest/)  

[18 Four Sum](https://leetcode-cn.com/problems/4sum/)  

[454 4 Sum II](https://leetcode-cn.com/problems/4sum-ii/)  
这道题是求元组的数目，在用map进行存储时，第一个存两个数的和，第二个存可以得出该sum的组合数，这样在第二次遍历时，就可以直接获得该组合的元组数


[36 判断数独是否有效](https://leetcode-cn.com/problems/valid-sudoku/)有趣的问题，使用三个二维矩阵当作哈希表来进行判断，其中给9个方块分块的小技巧很有意思:i/3 * 3 + j/3

[49 Anagram Group](https://leetcode-cn.com/problems/group-anagrams/)  
Anagram单词排序后都是一样的

[242 Valid Anagram](https://leetcode-cn.com/problems/valid-anagram/)  
使用哈希表(考虑是字母，使用了128的一维数组)，对两个词中字母的频率进行计算就行

[290 Word Pattern](https://leetcode-cn.com/problems/word-pattern/)  
相比单词规律2，这道题简单很多，先把单词按空格切分，然后用map进行映射一一比对

[202 Happy Number](https://leetcode-cn.com/problems/happy-number/)  
用set记录每次计算的结果，当进入循环时，set中会有记录

