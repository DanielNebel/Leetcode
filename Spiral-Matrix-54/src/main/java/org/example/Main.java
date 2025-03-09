package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int [] [] m  = {{1,2,3},{4,5,6},{7,8,9}};
        int [] [] m2 = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        List<Integer> n = spiralOrder(m);
        List<Integer> n2 = spiralOrder(m2);

        n.forEach(System.out::println);
        System.out.println("--------------------");
        n2.forEach(System.out::println);
    }

//    public static List<Integer> spiralOrder1(int[][] matrix) {
//        List<Integer> res = new ArrayList<>();
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[0].length && i ==0; j++) {
//                res.add(matrix[i][j]);
//            }
//            for (int j = matrix[0].length-1;i<=matrix.length-1; i++) {
//                if(!res.contains(matrix[i][j])){
//                    res.add(matrix[i][j]);
//                }
//                if(i==matrix.length-1){
//                    int k;
//                    for(k = j--;k>=0;k--){
//                        if(!res.contains(matrix[i][k])){
//                            res.add(matrix[i][k]);
//                        }
//                    }
//                }
//            }
//
//
//        }
//        return res;
//    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> rightEnd = new ArrayList<>();
        List<Integer> leftEnd = new ArrayList<>();
        HashMap<Integer,List<Integer>> middle = new HashMap<Integer,List<Integer>>();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j <= matrix[i].length-1; j++) {
                if(j==0){
                    leftEnd.add(matrix[i][j]);
                }
                else if (j == matrix[i].length - 1) {
                    rightEnd.add(matrix[i][j]);
                }
                else {
                    if(!middle.containsKey(i)){
                        List<Integer> t = new ArrayList<Integer>();
                        t.add(matrix[i][j]);
                        middle.put(i,t);
                    }
                    else {
                        middle.get(i).add(matrix[i][j]);
                    }
                }
            }
        }
        for (int i = 0; i < matrix.length && !middle.isEmpty(); i++) {
            if (i==0) {
                res.add(leftEnd.get(i));
                res.addAll(middle.get(i));
                middle.remove(i);
            }
            else if (i==matrix.length-1) {
                try {
                    Collections.reverse(middle.get(i));
                    res.addAll(middle.get(i));
                    middle.remove(i);
                    res.add(leftEnd.get(i));

                }
                catch (Exception e) {
                    if (!middle.isEmpty()) {
                        i = 0;
                    }
                }
                if (!middle.isEmpty()) {
                    i = 0;
                }
            } else if (!res.containsAll(rightEnd)) {
                rightEnd.forEach(integer -> {
                            if (!res.contains(integer)) {
                                res.add(integer);
                            }
                        }
                );
            }
            else if(!res.containsAll(leftEnd)) {
                leftEnd.forEach(integer -> {
                            if (!res.contains(integer)) {
                                res.add(integer);
                            }
                        }
                );
            }
            else {
                res.addAll(middle.get(i));
                middle.remove(i);
            }

        }

        return res;
    }
}