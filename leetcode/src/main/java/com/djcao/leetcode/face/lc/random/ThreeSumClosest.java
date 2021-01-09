package com.djcao.leetcode.face.lc.random;

class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        return choose(nums,0,target,0,nums[0]+nums[1]+nums[2],0); 
    }

    public int choose(int[] nums,int i, int target, int num,int close,int sum){
        if(i < nums.length){
            int cur = nums[i];
            int notChoose = choose(nums,i+1,target,num,close,sum);
            int m =0;
            int n = 0;
            if(num==2){
                m = sum + cur;
            }else{
                m = choose(nums,i+1,target,num+1,close,sum+cur);
            }
            int x = delta(target,notChoose);
            n = delta(target,m);
            int k = delta(target,close);

            close = x < n ? x < k ? notChoose : close : n < k ? m : close;
        }
        return close;
    }

    private int delta(int target, int x){
        return Math.abs(target - x);
    }

    public static void main(String[] args) {
        ThreeSumClosest t = new ThreeSumClosest();
        int[] x = {-1, 2, 1, -4};
        System.out.println(t.threeSumClosest(x, 1));
    }
}