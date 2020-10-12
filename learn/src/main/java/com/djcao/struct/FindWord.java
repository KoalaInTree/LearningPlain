/*
package com.djcao.struct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.tuple.MutablePair;

*/
/**
 * @author djcao
 * @workcode BG389966
 * @date 2020/9/6
 *//*

public class FindWord {
    public static void main(String[] args) {
        char[][] words = {
            "this".toCharArray(),
            "that".toCharArray(),
            "ksap".toCharArray(),
            "sksn".toCharArray()
        };

        String[] w = {"this", "that", "than","sap","s"};
        Map<String, MutablePair<Integer, Integer>[]> stringMap = find(words, w);
        List<String> collect = stringMap.entrySet().stream().filter(x -> x.getValue() != null)
            .map(x -> Arrays.stream(x.getValue())
                .map(y -> words[y.getLeft()][y.getRight()])
                .map(character -> String.valueOf(character.charValue())).reduce((a, b) ->
                    a + b).get()).collect(Collectors.toList());
        System.out.println(collect);
    }

    public static Map<String, MutablePair<Integer, Integer>[]> find(char[][] words, String[] w) {
        var res = new HashMap<String, MutablePair<Integer, Integer>[]>();
        for (int i = 0; i < w.length; i++) {
            for (int j = 0; j < words.length; j++) {
                for (int k = 0; k < words[j].length; k++) {
                    MutablePair<Integer, Integer>[] one = findOne(words, w[i].toCharArray(),
                        new MutablePair<>(j, k));
                    if (one != null) {
                        res.put(w[i], one);
                    }
                }
            }

        }
        return res;
    }

    private static MutablePair<Integer, Integer>[] findOne(char[][] words, char[] w,
        MutablePair<Integer, Integer> first) {
        List<MutablePair<Integer, Integer>> recurse = recurse(words, w, 0, first,
            cur -> new MutablePair(cur.getLeft(), cur.getRight() + 1));
        if (recurse != null) {
            return recurse.toArray(new MutablePair[recurse.size()]);
        }
        List<MutablePair<Integer, Integer>> recurse2 = recurse(words, w, 0, first,
            cur -> new MutablePair(cur.getLeft() + 1, cur.getRight()));
        if (recurse2 != null) {
            return recurse2.toArray(new MutablePair[recurse2.size()]);
        }

        List<MutablePair<Integer, Integer>> recurse1 = recurse(words, w, 0, first,
            cur -> new MutablePair(cur.getLeft() + 1, cur.getRight() + 1));
        if (recurse1 != null) {
            return recurse1.toArray(new MutablePair[recurse1.size()]);
        }
        return null;
    }

    public static List<MutablePair<Integer, Integer>> recurse(char[][] words, char[] w, int index,
        MutablePair<Integer, Integer> cur, NextGeneration nextGeneration) {

        if (cur.getLeft() < words.length && cur.getRight() < words[cur.getLeft()].length) {
            if (w[index++] == words[cur.getLeft()][cur.getRight()]) {
                var res = Lists.newArrayList(cur);
                if (index == w.length) {
                    return res;
                }else {
                    List<MutablePair<Integer, Integer>> recurse;
                    if ((recurse = recurse(words, w, index,
                        nextGeneration.getNext(cur), nextGeneration)) != null) {
                        res.addAll(recurse);
                        return res;
                    }
                }
            }
            return null;
        }
        return null;
    }

    private interface NextGeneration {
        MutablePair<Integer, Integer> getNext(MutablePair<Integer, Integer> cur);
    }
}
*/
