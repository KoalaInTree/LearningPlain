package com.djcao.alogic;

/**
 * 类型：选择排序
 * 时间复杂度：N^2
 * 空间复杂度：1
 * 思想：首次扫描数组获取到最小元素的，与第一个元素交换。其次，在剩余的元素中找到最小的元素，与第二个元素交换。直到全部交换完成。
 * @author djcao
 * @date 2020-04-29 2:06
 */
public class SelectSortStrategy extends AbstractSortStrategy implements SortStrategy {

    @Override
    public void sort(Comparable[] a) {
        int length = a.length;
        int now = 0;
        for (int i = 0; i < length; i++) {
            now = i;
            for (int j = i; j < length; j++) {
                if (less(a[j], a[now])) {
                    now=j;
                }
            }
            exch(a,i,now);
        }
    }
}
