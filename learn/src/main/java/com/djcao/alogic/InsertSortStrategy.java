package com.djcao.alogic;

/**
 * 类型：插入排序
 * 时间复杂度：N^2
 * 空间复杂度：1
 * 思想：首先我们认为第一个元素是有序的，再把第二个元素与有序的部分从头比较，直到发现大于第二个元素的元素，
 * 把有序部分的大于等于当前位置的元素右移一位，把第二个元素插入到当前位置。依次比较，直到全部有序。
 * @author djcao
 * @date 2020-04-29 2:06
 */
public class InsertSortStrategy extends AbstractSortStrategy implements SortStrategy {

    @Override
    public void sort(Comparable[] a) {
        int length = a.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (less(a[i], a[j])) {
                    for (int k = i; k > j; k--) {
                        exch(a,k-1,k);
                    }
                    break;
                }
            }
        }
    }
}
