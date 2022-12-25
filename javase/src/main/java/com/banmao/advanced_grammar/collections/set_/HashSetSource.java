package com.banmao.advanced_grammar.collections.set_;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/11/18 下午8:38
 * @description hashset源码
 */
@SuppressWarnings({"all"})
public class HashSetSource {

    public static void main(String[] args) {

        int h = "java".hashCode();
        System.out.println("h=" + h);
        int i = h ^ (h >>> 16);
        System.out.println(i);

        int i1 = (h = "java".hashCode()) ^ (h >>> 16);
        System.out.println("i1=" + i1);
        HashSet hashset = new HashSet();
        hashset.add("java");
        hashset.add("php");
        hashset.add("java");
        System.out.println("set=" + hashset);

        // add方法中的hash方法计算如下：
        // 解析：^运算符为按位异或，比较不同时结果为1，否则为0
        // 通过将hashcode的低16位与高16位进行异或运算。将高位与低位的特征组合起来，降低哈希冲突的概率。
        // (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);

        // hashmap中，定义到hash桶的位置，是以数组的长度减1，再与hash值相与得到的。比如index = (n-1) & hash
        // (n-1) & hash等价与 hash % n，所以也称为：hash与数组长度取余

        // 如果一开始，hashset为空，则创建默认大小的hash表
        // 阈值的作用在于，当数组（hash桶）的长度到达12（包括等于）时，就会考虑扩容
        // newCap = DEFAULT_INITIAL_CAPACITY; // 默认为16个大小
        // newThr = (int)(DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);  // threshold阈值=0.75 * 16 = 12

        /*
        HashMap.Node<K,V>[] tab; HashMap.Node<K,V> p; int n, i;
        if ((tab = table) == null || (n = tab.length) == 0)
            // 说明：当table表为空时，进行初始化
            n = (tab = resize()).length;
        if ((p = tab[i = (n - 1) & hash]) == null)
            // i = (n - 1) & hash确定元素的桶位置，如果当前要插入的元素的位置等于空。则直接将此元素插入
            tab[i] = newNode(hash, key, value, null);
        else {
            // 当前要插入的元素的位置已经存在元素了
            HashMap.Node<K,V> e; K k;
            if (p.hash == hash &&
                    ((k = p.key) == key || (key != null && key.equals(k))))
                // 满足两个条件
                // （1）如果要插入元素的hash值相等，或者
                // （2）准备加入的key与当前要插入位置的第一个元素的key相等
                // 则将当前要插入位置的第一个元素赋值给e，下面会判断是否需要覆盖值。
                e = p;
            else if (p instanceof HashMap.TreeNode)
                // 如果不满足上面两个条件，则判断当前是否是一颗红黑树，则用红黑树的方式比较
                e = ((HashMap.TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
            else {
                // 循环比较，比较当前桶里面的链表的所有元素，是否等于当前要插入的元素。如果都不相同，则插入到链表尾部。
                // 如果存在相等的元素，则break。
                for (int binCount = 0; ; ++binCount) {
                    if ((e = p.next) == null) {
                        p.next = newNode(hash, key, value, null);
                        // 注意，将元素添加到链表后，立即判断该链表是否已经达到8个结点。
                        // 如果达到，就对当前这个链表进行树化（treeifyBin）
                        // 注意，在转成红黑树时，要进行判断，如果该数组的大小小于64，要先进行扩容。
                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                            treeifyBin(tab, hash);
                        break;
                    }
                    if (e.hash == hash &&
                            ((k = e.key) == key || (key != null && key.equals(k))))
                        break;
                    p = e;
                }
            }
            if (e != null) { // existing mapping for key
                V oldValue = e.value;
                if (!onlyIfAbsent || oldValue == null)
                    e.value = value;
                afterNodeAccess(e);
                return oldValue;
            }
        }
        ++modCount;
        if (++size > threshold)
            // 重点说明：是map中的元素个数达到12个后，就会发生扩容，而不是数组的下标被使用了12个下标。
            resize();
        afterNodeInsertion(evict);
        return null;
        */

        /* 代码段2
        if (tab == null || (n = tab.length) < MIN_TREEIFY_CAPACITY)
            resize();*/
    }
}