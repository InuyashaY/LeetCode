package yzl.swu.leetcode;

import java.util.Random;

import static java.util.Objects.hash;

public class Sort {
    public static void main(String[] args) {
        int array_len = 1000_00;
        int[] source = new int[array_len];
        int[] array = new int[array_len];
        //创建随机数组
        for (int i=0;i<array_len;i++){
            source[i] = Math.abs(new Random().nextInt());
        }
        //快速排序
        System.arraycopy(source,0,array,0,array_len);
        long start = System.nanoTime();
        quickSort(array,0,array_len-1);
        System.out.println("quickSort--time = "+(System.nanoTime()-start));

        //冒泡排序
        System.arraycopy(source,0,array,0,array_len);
        start = System.nanoTime();
        BubbleSort(array,0,array_len-1);
        System.out.println("BubbleSort--time = "+(System.nanoTime()-start));

        //合并排序
        System.arraycopy(source,0,array,0,array_len);
        start = System.nanoTime();
        int[] b = new int[array_len];
        mergeSort(array,b,0,array_len-1);
        System.out.println("mergeSort--time = "+(System.nanoTime()-start));
//        for (int k = 0; k<array.length;k++){
//            System.out.printf(" "+array[k]);
//        }

    }


    //快速排序
    static void quickSort(int[] array,int p, int r){
        if (p < r){
            int q = Partition(array,p,r);
//            for (int k = 0; k<array.length;k++){
//                System.out.printf(" "+array[k]);
//            }
//            System.out.printf("\n");
            quickSort(array,p,q-1);
            quickSort(array,q+1,r);
        }
    }

    static int Partition(int[] array,int p,int r){
        int i = p;
        int j = r+1;
        int index = p;
        int x = array[index];
        while (true){
            while (array[++i]<x && i<r);
            //System.out.printf("index="+index+" i="+i+" j="+j+" array=");
//            for (int k = 0; k<array.length;k++){
//                System.out.printf(" "+array[k]);
//            }
            while (array[--j]>x && j > p);
            if (i >= j) break;
            swap(array,i,j);
        }
        array[index] = array[j];
        array[j] = x;
        return j;
    }

    static void swap(int[] array, int aIndex , int bIndex){
        Integer temp = null;
        temp = array[aIndex];
        array[aIndex] = array[bIndex];
        array[bIndex] = temp;
    }


    //合并排序
    static void mergeSort(int[]a,int[] b,int left,int right){
        // 这里和二分搜索有点像，就是每次将数组划分成两段
        if(left<right) {
            int mid = (left + right) / 2;
            mergeSort(a,b,left, mid);
            mergeSort(a,b,mid + 1, right);
            merge2(a,b,left, mid, right);
            copy(a, b, left, right);
        }
    }
    private static void copy(int[] a, int[] b, int left, int right) {
        for(int i=left;i<=right;i++)
            a[i]=b[i];

    }

    public static void merge2(int[] a,int[] b,int left, int mid, int right) {

        int start=left;
        int temp=mid+1;
        int index=left;
        while((start<=mid)&&(temp<=right)){//两段数组，一个从left到mid，一个从mid+1到right，每次把小的赋值给数组b
            if(a[start]<=a[temp]){
                b[index++]=a[start++];
            }
            else{
                b[index++]=a[temp++];
            }
        }
        if(start>mid){
            for(int i=temp;i<=right;i++)
                b[index++]=a[i];
        }else{
            for(int i=start;i<=mid;i++)
                b[index++]=a[i];
        }


    }





    static void MergeSort(int[] array,int n){
        int[] b = new int[n];
        int s = 1;
        while (s < n){
            mergePass(array,b,s,n);
            s += s;
            mergePass(b,array,s,n);
            s += s;
        }
    }

    static void mergePass(int[] x,int[] y,int s, int n){
        int i = 0;
        while (i <= n-2*s){
            merge(x,y,i,i+s-1,i+2*s-1);
            i = i+2*s;
        }
        if (i+s < n){
            merge(x,y,i,i+s-1,n-1);
        }else {
            for (int j=i; j<=n-1; j++){
                y[j] = x[j];
            }
        }
    }

    static void merge(int[] c,int[] d,int l,int m,int r){
        int i =1,j=m+1,k=1;
        while ((i<=m) && (j <= r)){
            if (c[i] <= c[j])
                d[k++] = c[i++];
            else
                d[k++] = c[j++];
            if (i > m){
                for (int q=j; q<=r; q++)
                    d[k++] = c[q];
            }else {
                for (int q=i; q<=m; q++)
                    d[k++] = c[q];
            }
        }
    }

    //冒泡排序
    static void BubbleSort(int[] array, int start,int end){

        int minIndex = 0;
        for(int i = 0; i<=end; i++){
            minIndex = i;
            for (int j=i; j<=end; j++){
               minIndex = array[j]<array[minIndex]?j:minIndex;
            }
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }
}
