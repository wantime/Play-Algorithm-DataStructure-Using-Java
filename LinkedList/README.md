## 经典的链表问题
[Q1:链表中环的检测](https://leetcode-cn.com/problems/linked-list-cycle/)
[Q2:两个有序链表的合并](https://leetcode-cn.com/problems/merge-two-sorted-lists/)
[Q3:删除链表倒数第n个节点](https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/)
[Q4:求链表的中间节点](https://leetcode-cn.com/problems/middle-of-the-linked-list/submissions/)

## LeetCode链表问题

[2 两数相加](https://leetcode-cn.com/problems/add-two-numbers/)
这道题由于是逆序存储，也就是第一位存的是个位数，第二位是十位，依此类推
因此可以每次取出两个链表的当前数，相加之后取10的模存入需要返回的链表。然后对和除以10取整，参与到下一次加法中

[24 两两交换链表中的节点](https://leetcode-cn.com/problems/swap-nodes-in-pairs/)

[25 以k个节点为一组反转链表中的节点](https://leetcode-cn.com/problems/reverse-nodes-in-k-group/)

[61 旋转链表](https://leetcode-cn.com/problems/rotate-list/)
只需要找到倒数第k个元素，将它作为新的头结点，并且该链表的尾巴应该连接上开始的头结点

[82 删除排序链表中的重复元素2](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/)
这道题用了两层循环，一个变量Num记录数字出现的次数，指针p指向下一个不重复的元素

[83 去除排序链表中的重复元素](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/)  

[86 分割链表](https://leetcode-cn.com/problems/partition-list/)  

[92 反转链表2](https://leetcode-cn.com/problems/reverse-linked-list-ii/)  
相比而言，反转链表2要难一些，因为给出了需要反转的区间，思路是移动prev.next的指针，把cur后面的元素，一个一个插到prev后面  

[143 重排链表](https://leetcode-cn.com/problems/reorder-list/)
使用反转链表的方法，反转后半段

[203 删除节点](https://leetcode-cn.com/problems/remove-linked-list-elements/)
使用虚拟头结点（哨兵）来优化代码，统一逻辑

[206 经典的反转链表](https://leetcode-cn.com/problems/reverse-linked-list/)  

[234 回文链表](https://leetcode-cn.com/problems/palindrome-linked-list/)  
这道题有两种解法，第一种是把链表头到中部位置的节点进行反转，然后从和后半段进行对比  
第二种是反转后半段，和前半段进行对比  

[328 奇偶链表](https://leetcode-cn.com/problems/odd-even-linked-list/comments/)
原地算法，O(n)时间复杂度，使用两个尾指针，判断当前指针的节点应该加入哪一类,有点快排的感觉

[445 两数相加2](https://leetcode-cn.com/problems/add-two-numbers-ii/)  
这道题根第2题很相似，但是有一点不一样，数字是顺序存储的，可以写一个反转链表的辅助函数帮忙
也可以使用栈这种结构解决该问题



