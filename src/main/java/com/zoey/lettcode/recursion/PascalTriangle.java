package com.zoey.lettcode.recursion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// 杨辉三角
public class PascalTriangle {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        res.add(1);

        if (rowIndex == 0) return res;

        List<Integer> list = getRow(rowIndex-1);
        // Iterator<Integer> iterator = list.iterator();
        for (int i = 0; i < list.size() - 1; i ++) {
            int a = list.get(i);
            int b = list.get(i + 1);
            // System.out.println(a + b);
            res.add(a+b);
        }
        res.add(1);
        return res;
    }

    public static void main(String[] args) {
        List<Integer> list = new PascalTriangle().getRow(3);
        for (int i: list) System.out.println(i);
    }
}
