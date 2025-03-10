package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[][] m = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] m2 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int[][] m3 = {{1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };
//        List<Integer> n = spiralOrder(m);
//        List<Integer> n2 = spiralOrder(m2);
        List<Integer> n3 = spiralOrder(m3);

//        n.forEach(System.out::println);
        System.out.println("--------------------");
//        n2.forEach(System.out::println);
        n3.forEach(System.out::println);
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

//    public static List<Integer> spiralOrder(int[][] matrix) {
//        List<Integer> rightEnd = new ArrayList<>();
//        List<Integer> leftEnd = new ArrayList<>();
//        HashMap<Integer,List<Integer>> middle = new HashMap<Integer,List<Integer>>();
//        List<Integer> res = new ArrayList<>();
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j <= matrix[i].length-1; j++) {
//                if(j==0){
//                    leftEnd.add(matrix[i][j]);
//                }
//                else if (j == matrix[i].length - 1) {
//                    rightEnd.add(matrix[i][j]);
//                }
//                else {
//                    if(!middle.containsKey(i)){
//                        List<Integer> t = new ArrayList<Integer>();
//                        t.add(matrix[i][j]);
//                        middle.put(i,t);
//                    }
//                    else {
//                        middle.get(i).add(matrix[i][j]);
//                    }
//                }
//            }
//        }
//        for (int i = 0; i < matrix.length && !middle.isEmpty(); i++) {
//            if (i==0) {
//                res.add(leftEnd.get(i));
//                res.addAll(middle.get(i));
//                middle.remove(i);
//            }
//            else if (i==matrix.length-1) {
//                try {
//                    Collections.reverse(middle.get(i));
//                    res.addAll(middle.get(i));
//                    middle.remove(i);
//                    res.add(leftEnd.get(i));
//
//                }
//                catch (Exception e) {
//                    if (!middle.isEmpty()) {
//                        i = 0;
//                    }
//                }
//                if (!middle.isEmpty()) {
//                    i = 0;
//                }
//            } else if (!res.containsAll(rightEnd)) {
//                rightEnd.forEach(integer -> {
//                            if (!res.contains(integer)) {
//                                res.add(integer);
//                            }
//                        }
//                );
//            }
//            else if(!res.containsAll(leftEnd) && i == matrix.length-1) {
//                leftEnd.forEach(integer -> {
//                            if (!res.contains(integer)) {
//                                res.add(integer);
//                            }
//                        }
//                );
//            }
//            else {
//                res.addAll(middle.get(i));
//                middle.remove(i);
//            }
//
//        }
//
//        return res;
//    }


    public static List<Integer> spiralOrder(int[][] matrix) {
        // repeat the crircle motion over and over again and delete it out of the matrix
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == 0) {
                    if (matrix[i][j] != -101) {
                        res.add(matrix[i][j]);
                        matrix[i][j] = -101;
                    }
                } else if (i == matrix.length - 1) {
                    for (int k = matrix[i].length - 1; k >= 0; k--) {
                        if (matrix[i][k] != -101) {
                            res.add(matrix[i][k]);
                            matrix[i][k] = -101;
                        }
                    }
                    for (int k = 0; i > 0; i--) {
                        if (matrix[i][k] != -101) {
                            res.add(matrix[i][k]);
                            matrix[i][k] = -101;
                        }
                    }
                    int[][] newMatrix = {{-101,-101}, {-101,-101}};
                    if (matrix.length >=2 && matrix[0].length >=2) {
                        newMatrix = new int[matrix.length - 2][matrix[0].length - 2];
                        for (int k = 0; k < newMatrix.length; k++) {
                            Arrays.fill(newMatrix[k], -101);
                        }
                    }
                    for (int k = 0; k < matrix.length && newMatrix.length > 0; k++) {
                        for (int l = 0; l < matrix[k].length; l++) {
                            if (matrix[k][l] != -101) {
                                newMatrix[k - 1][l - 1] = matrix[k][l];
                                matrix[k][l] = -101;
                            }
                        }
                    }
                    matrix = newMatrix;
                    List<Integer> temp = spiralOrder(matrix);
                    if (!temp.isEmpty()) {
                        res.addAll(temp);
                    } else {
                        return res;
                    }

                } else {
                    if (matrix[i][j] != -101) {
                        res.add(matrix[i][matrix[i].length - 1]);
                        matrix[i][matrix[i].length - 1] = -101;
                    }
                    break;
                }
            }
        }
        return res;
    }
}