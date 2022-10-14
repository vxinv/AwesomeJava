package org.vxinv.algorithm.递归.q0806汉诺塔问题;

import java.util.List;

class Solution {
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        int n = A.size();
        move(n,A,B,C);
    }
    void move(int n,List<Integer> A, List<Integer> B, List<Integer> C){
        if(n==1){
            C.add(A.remove(A.size()-1));
            return;
        }
        move(n-1,A,C,B);
        C.add(A.remove(A.size()-1));
        move(n-1,B,A,C);
    }
}