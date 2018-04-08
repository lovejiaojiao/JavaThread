package com.ganggangnet.base.sync004;

/**
 * 进行数据二分法查找要求数据是有序的
 * */
public class BinarySearch {
    public static void main(String args[]) {
        int nums[] = {1,2,3,4,5,6,7,8,9,10};
        int key = 4;
        if(rank(key,nums)!=-1){
            System.out.println("有值==="+rank(key,nums));
        }else {
            System.out.println("没有找到！");
        }
    }

    public static int rank(int ker,int nums[]){
        //第一步，确定查找范围，上下界
        int low = 0;//上界
        int high = nums.length-1;//下届

        ///未查找到返回以下这个值
        int noFind = 0;

        //然后就是一个while循环循环查找,条件是上界小于或者等于下界
        while(low<=high){
            //一，确定二分中点
            //二分中点=数组左边界+（右边界-左边界）/2;
            int mid = low + (high-low)/2;
            System.out.println("二分中点="+mid);
            if(nums[mid]>ker){
                //证明key在[low,mid-1]这个区间
                //因为num[mid]已经判断过了，所以下界要减一，
                high=mid-1;
                System.out.println("上界="+high);
            }else if(nums[mid]<ker){
                low=mid+1;
                System.out.println("下界="+low);
            }else {
                return mid;
            }
        }
        return noFind;
    }
}
