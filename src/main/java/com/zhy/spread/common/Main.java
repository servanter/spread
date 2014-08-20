package com.zhy.spread.common;

import java.io.IOException;
import java.util.Comparator;
import java.util.TreeMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Main {

    /**
     * 
     * @author ZhangHongyan
     * @param args
     */
    public static void main(String[] args) {
        int[] src = new int[] { 13, 5, 18, 8, 88, 43 };
        maopao(src);
        
        String a = "我是个好人，哈啊哈";
        System.out.println(a.lastIndexOf("个好人"));
        System.out.println(a.substring(2));
        
        TreeMap<String, Object> map = new TreeMap<String, Object>(new Comparator<String>(){

            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
            
        });
        Document document;
        try {
            document = Jsoup.connect("http://spu.taobao.com/spu/3c/spulist.htm?spm=1020.2.500.1.V63QJe&cat=1512").get();
            System.out.println(document.html());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
        
    }
//    public static void insertSort(int[] src) {
//        for(int i = 1 ; i < src.length ;i++){
//            int temp = src[i];
//            int j = i;
//            while(src[j - 1] > temp){
//                src[j] = src[j - 1];
//                j -- ;
//                if(j <= 0){
//                    break;
//                }
//            }
//            src[j] = temp;
//            for(int a : src){
//                System.out.print(a);
//            }
//            
//        }
//    }
    
    
//    public static void selectSort(int src[]){
//        
//        for(int i = 0; i < src.length ; i++){
//            int small = i;
//            int temp = src[i];
//            for(int j = i + 1; j < src.length ;j++){
//                if(src[j] < temp){
//                    small = j;
//                    temp = src[j];
//                }
//            }
//            src[small] = src[i];
//            src[i] = temp;
//            for(int a : src){
//                System.out.print(a + " ");
//            }
//            System.out.println();
//        }
//        
//        
//    }
    
//    public static void selectSort2(int src[]){
//        for(int i = 0 ;i < src.length ; i++){
//            int temp = src[i];
//            int small = i;
//            for(int j = i + 1; j < src.length ; j++){
//                if(src[j] < temp){
//                    temp = src[j];
//                    small = j;
//                }
//            }
//            src[small] = src[i];
//            src[i] = temp;
//            for(int a : src){
//                System.out.print(a + " ");
//            }
//            System.out.println();
//        }
//    }
    
    
//    public static void select3(int[] src){
//        for(int i = 0; i < src.length ;i++){
//            int temp = src[i];
//            int small = i;
//            for(int j = i + 1; j < src.length ;j++){
//                if(src[j] < temp){
//                    temp = src[j];
//                    small = j;
//                }
//            }
//            src[small] = src[i];
//            src[i] = temp;
//            for(int a: src){
//                System.out.print(a + " ");
//            }
//            System.out.println();
//        }
//    }
    
    
//    public static void select4(int src[]){
//        for(int i = 0; i < src.length; i++){
//            int temp = src[i];
//            int small = i;
//            for(int j = i + 1; j < src.length ;j++){
//                if(src[j] < temp){
//                    small = j;
//                    temp = src[j];
//                }
//            }
//            src[small] = src[i];
//            src[i] = temp;
//            for(int a: src){
//                System.out.print(a + ",");
//            }
//            System.out.println();
//        }
//    }
    
//    public static void select(int[] src){
//        for(int i = 0; i < src.length ; i++){
//         
//            int temp = src[i];
//            int small = i;
//            
//            for(int j = i + 1; j < src.length; j++){
//                if(src[j] < temp){
//                    temp = src[j];
//                    small = j;
//                }
//            }
//            src[small] = src[i];
//            src[i] = temp;
//            for(int a :src ){
//                System.out.print(a + ",");
//            }
//            System.out.println();
//        }
//    }
    
//    public static void insert(int src[]){
//        for(int i = 1 ; i < src.length ; i++){
//            int temp = src[i];
//            int j = i;
//            while(src[j-1] > temp){
//                src[j] = src[j - 1];
//                j--;
//                if(j <= 0){
//                    break;
//                }
//            }
//            src[j] = temp;
//            for(int a : src){
//                System.out.print(a  + " ,");
//            }
//            System.out.println();
//            
//        }
//    }
    
    
//    public static void insert(int src[]){
//        for(int i = 1; i < src.length; i++){
//            int temp =  src[i];
//            int j = i;
//            while(src[j -1 ] > temp){
//                src[j] = src[j -1];
//                j--;
//                if(j <= 0){
//                    break;
//                }
//            }
//            src[j] = temp;
//            for(int a : src){
//                System.out.print(a + ",");
//            }
//            System.out.println();
//        }
//    }
    
    
    
//    public static void insert(int src[]){
//        for(int i= 1; i <  src.length;i++){
//            int temp = src[i];
//            int j = i;
//            
//            while(src[j - 1] > temp){
//                src[j] = src[j -1];
//                j--;
//                if(j <= 0){
//                    break;
//                }
//            }
//            src[j] = temp;
//            for(int a : src){
//                System.out.print(a + ",");
//            }
//            System.out.println();
//            
//            
//        }
//    }
//    
//    public static void select(int[] src){
//        for(int i = 0;i < src.length; i++){
//            int temp = src[i];
//            int small = i;
//            for(int j = i + 1; j < src.length ; j++){
//                if(src[j] < temp){
//                    temp = src[j];
//                    small = j;
//                }
//            }
//            src[small] = src[i];
//            src[i] = temp;
//            for(int a : src){
//                System.out.print(a + ",");
//            }
//            System.out.println();
//        }
//    }
    
//    public static void maopao(int src[]){
//        for(int i = 0; i < src.length; i++){
//            for(int j=i+1; j<src.length;j++){
//                if(src[j] < src[i]){
//                    int temp = src[i];
//                    src[i] = src[j];
//                    src[j] = temp;
//                }
//                for(int a : src){
//                    System.out.print(a + "");
//                }
//                System.out.println();
//            }
//        }
//    }
    
//    public static void insert(int[] src){
//        for(int i = 1; i < src.length;i++){
//            int temp = src[i];
//            int j = i;
//            
//            while(src[j -1] > temp){
//                src[j ] = src[j -1 ];
//                j--;
//                if( j<=0){
//                    break;
//                }
//            }
//            src[j] = temp;
//            for(int a : src){
//                System.out.print(a + ",");
//            }
//            System.out.println();
//        }
//    }
    
    
//    public static void insert(int src[]){
//        for(int i = 1;i < src.length ;i++){
//            int temp = src[i];
//            int j = i;
//            
//            while(src[j - 1] > temp){
//                src[j] = src[j - 1];
//                j--;
//                if(j <= 0){
//                    break;
//                }
//            }
//            src[j] = temp;
//            for(int a : src){
//                System.out.print(a);
//            }
//            System.out.println();
//        }
//    }
    
//    public static void select(int src[]){
//        for(int i = 0 ; i < src.length;i++){
//            int small = i;
//            int temp = src[i];
//            for(int j = i + 1 ; j < src.length; j++){
//                if(src[j] < temp){
//                    small = j;
//                    temp = src[j];
//                }
//            }
//            src[small] = src[i];
//            src[i] = temp;
//            for(int a : src){
//                System.out.print(a + ",");
//            }
//            System.out.println();
//        }
//    }
    
//    public static void insert(int src[]){
//        for(int i = 1 ; i < src.length ;i++){
//            int temp = src[i];
//            int j = i;
//            while(src[j - 1] > temp){
//                src[j] = src[j - 1];
//                j--;
//                if(j <= 0){
//                    break;
//                }
//            }
//            src[j] = temp;
//            for(int a: src){
//                System.out.print(a + ",");
//            }
//            System.out.println();
//        }
//    }
//
//    public static void mappao(int src[]){
//        for(int i = 0;i < src.length;i++){
//            for(int j = i+1;j<src.length;i++){
//                if(src[j] < src[i]){
//                    int temp = src[j];
//                    src[j] = src[i];
//                    src[i] = temp;
//                }
//            }
//            for(int a : src){
//                System.out.print(a);
//            }
//            System.out.println();
//        }
//    }
    
    
//    public static void select(int[] src){
//        
//        for(int i = 0 ; i < src.length ;i++){
//            int temp = src[i];
//            int small = i;
//            for(int j = i + 1; j < src.length ;j++){
//                if(src[j] < temp){
//                    temp = src[j];
//                    small = j;
//                }
//            }
//            src[small] = src[i];
//            src[i] = temp;
//            for(int a : src){
//                System.out.print(a + ",");
//            }
//            System.out.println();
//        }
//    }
    
    
//    public static void select(int[] src){
//        for(int i = 0;i < src.length ;i++){
//            int temp = src[i];
//            int small = i;
//            for(int j = i + 1 ; j < src.length; j++){
//                if(src[j] < temp){
//                    temp = src[j];
//                    small = j;
//                }
//            }
//            src[small] = src[i];
//            src[i] = temp;
//            for(int a : src){
//                System.out.print(a + ",");
//            }
//            System.out.println();
//        }
//    }
    
//    public static void insert(int src[]){
//        for(int i = 1 ; i < src.length ;i++){
//            int j = i;
//            int temp = src[i];
//            while(src[j - 1] > temp){
//                src[j] = src[j - 1];
//                j--;
//                if(j <= 0){
//                    break;
//                }
//            }
//            src[j] = temp;
//            
//            for(int a : src){
//                System.out.print(a + ",");
//            }
//            System.out.println();
//        }
//    }
    
    
//    public static void insert(int src[]){
//        for(int i = 1; i < src.length; i++){
//            int j = i;
//            int temp = src[i];
//            while(src[j - 1] > temp){
//                src[j] = src[j - 1];
//                j--;
//                if(j <= 0){
//                    break;
//                }
//            }
//            src[j] = temp;
//            for(int a : src){
//                System.out.print(a + ",");
//            }
//            System.out.println();
//        }
//    }
    
//    public static void maopao(int src[]){
//        for(int i = 0; i < src.length; i++){
//            for(int j = i + 1; j < src.length; j++){
//                if(src[j - 1] > src[j]){
//                    int temp = src[j];
//                    src[j] = src[j - 1];
//                    src[j - 1] = temp;
//                }
//            }
//            for(int a : src){
//                System.out.print(a + ",");
//            }
//            System.out.println();
//        }
//    }
    
    
    
//    public static void maopao(int src[]){
//        for(int i = 0;i < src.length ;i++){
//         for(int j = i + 1; j < src.length; j++){
//             if(src[j - 1] > src[j]){
//                 int temp = src[j];
//                 src[j] = src[j - 1];
//                 src[j - 1] = temp;
//             }
//         }
//         for(int a : src){
//             System.out.print(a + ",");
//         }
//         System.out.println();
//        }
//    }
    
//    public static void select(int src[]){
//        for(int i = 0;i < src.length;i++){
//            int temp = src[i];
//            int small = i;
//            for(int j = i  +1 ;j < src.length ;j++){
//                if (src[j] < temp){
//                    temp = src[j];
//                    small = j;
//                }
//            }
//            src[small] = src[i];
//            src[i] = temp;
//            for(int a: src){
//                System.out.print(a + ",");
//            }
//            System.out.println();
//        }
//    }
    
//    public static void insert(int src[]){
//        for(int i =1 ; i < src.length;i++){
//            int j = i;
//            int temp = src[i];
//            while(src[j - 1] > temp){
//                src[j]  = src[j - 1];
//                j--;
//                if(j<=0){
//                    break;
//                }
//            }
//            src[j] = temp;
//            for(int a: src){
//                System.out.print(a + ",");
//            }
//            System.out.println();
//        }
//    }
    
    
//    public static void select(int src[]){
//        for(int i = 0; i < src.length;i++){
//            int temp = src[i];
//            int small = i;
//            for(int j = i + 1;j < src.length; j++){
//                if(src[j] < temp){
//                    temp = src[j];
//                    small = j;
//                }
//            }
//            src[small] = src[i];
//            src[i] = temp;
//            for(int a: src){
//                System.out.print(a + ",");
//            }
//            System.out.println();
//        }
//    }
    
    
//    public static void insert(int src[]){
//        for(int i = 1; i < src.length;i++){
//            int j = i;
//            int temp = src[i];
//            while(src[j - 1] > temp){
//                src[j] = src[j - 1];
//                j--;
//                if(j <=0){
//                    break;
//                }
//            }
//            src[j] = temp;
//            for(int a : src){
//                System.out.print(a + ",");
//            }
//            System.out.println();
//        }
//    }
    
//    public static void maopao(int src[]){
//        for(int i = 0;i < src.length;i++){
//            for(int j = i + 1; j < src.length; j++){
//                if(src[j - 1] > src[j]){
//                    int temp = src[j - 1];
//                    src[j - 1] = src[j];
//                    src[j] = temp;
//                }
//            }
//            for(int a : src){
//                System.out.print(a + ",");
//            }
//            System.out.println();
//        }
//    }
    
    
//    public static void select(int src[]){
//        for(int i = 0; i < src.length ;i++){
//            int temp = src[i];
//            int small = i;
//            for(int j = i + 1;j < src.length ;j++){
//                if(src[j] < temp){
//                    temp = src[j];
//                    small = j;
//                }
//            }
//            src[small] = src[i];
//            src[i] = temp;
//            for(int a : src){
//                System.out.print(a + ",");
//            }
//            System.out.println();
//        }
//    }
    
    
//    public static void insert(int src[]){
//        for(int i = 1 ;i < src.length;i++){
//            int temp = src[i];
//            int j = i;
//            while(src[j - 1] > temp){
//                src[j] = src[j - 1];
//                j--;
//                if(j <= 0){
//                    break;
//                }
//            }
//            src[j] = temp;
//            for(int a : src){
//                System.out.print(a + ",");
//            }
//            System.out.println();
//        }
//    }
    
    
//    public static void select(int src[]){
//        for(int i = 0; i < src.length; i++){
//            int temp = src[i];
//            int samll = i;
//            for(int j = i + 1;j < src.length; j++){
//            }
//        }
//    }
    
    
    
//    public static void select(int src[]){
//        for(int i = 0 ; i < src.length ; i++){
//            int temp = src[i];
//            int small = i;
//            for(int j = i+ 1; j < src.length ; j++){
//                if(src[j] < temp){
//                    small = j;
//                    temp = src[j];
//                }
//            }
//            src[small] = src[i];
//            src[i] = temp;
//            for(int a: src){
//                System.out.print(a + ",");
//            }
//            System.out.println();
//        }
//    }
    
    
    
//    public static void insert(int src[]) {
//        for (int i = 1; i < src.length; i++) {
//            int j = i;
//            int temp = src[i];
//            while (src[j - 1] > temp) {
//                src[j] = src[j - 1];
//                j--;
//                if (j <= 0) {
//                    break;
//                }
//            }
//            src[j] = temp;
//        }
//        for (int a : src) {
//            System.out.print(a + ",");
//        }
//        System.out.println();
//    }
    
    
    public static void maopao(int src[]){
        for(int i = 0; i < src.length ;i++){
            for(int j = i + 1; j < src.length ; j++){
                if(src[j] < src[j -1]){
                    int temp =src[j];
                    src[j] = src[j - 1];
                    src[j - 1] = temp;
                }
            }
            for(int a : src){
                System.out.print(a + ",");
            }
            System.out.println();
        }
    }
}



