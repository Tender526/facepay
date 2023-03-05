package com.abc.facepay.controller.test;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

public class Algorithm {
    public static void main(String[] args) {
        PriorityQueue<Integer> p = new PriorityQueue<>();

        int[] intarr = new int[]{1,4,8,5,10};
        p = Kthlargest(3, intarr);
        System.out.println(p);

//        String reg = "((([]))";
//        char[] regArr = reg.toCharArray();
//        System.out.println(regArr);
//        System.out.println(compareChar(regArr));
    }

    /**
     *  給定一個字符串，包括大中小括號的字符串，判斷字符串是否有效
     *  成對的匹配則是有效的
     * (1)boolean empty( )方法是判断堆栈是否为空。
     * (2)Object peek( )方法是返回栈顶端的元素，但不从堆栈中移除它。
     * (3)Object pop( )方法是移除堆栈顶部的对象，并作为此函数的值返回该对象。
     * (4)Object push (Object element)方法是把元素压入栈。
     * (5)int search(Object element)方法是返回对象在堆栈中的位置，它是以1为基数。
     */
    public static boolean compareChar(char[] regArr){
        Stack stack = new Stack<Object>();
        Map dict = new HashMap<String,String>();
        dict.put("}","{");
        dict.put("]","[");
        dict.put(")","(");

        String target ;
        for (char c : regArr
        ) {
            if(stack.empty() && dict.containsKey(c+"")){
                return false;
            }

            if(!stack.empty()){
                target  = stack.peek().toString();
                if(target.equals(dict.get(c+"")) ){
                    stack.pop();
                    continue;
                }
            }
            stack.push(c);

        }

        if(stack.empty()){
            return true;
        }

        return false;
    }

    /**
     * 使用栈实现队列的效果
     * 栈是 先进后出
     * 队列是 先进先出
     */
    public static Stack<Integer> stackImpQueqe(){
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        int node = 0;
        while(!s1.empty()){
            s2.push(s1.pop());
        }

        s1.push(node);

        while (!s2.empty()){
            s2.pop();
        }


        return null;
    }

    /**
     * 通过队列获取数组中第K大的数字
     * 优先队列默认排序  最小的在顶部
     *
     */
    public static PriorityQueue<Integer> Kthlargest(int k, int[] nums){
        PriorityQueue<Integer> p = new PriorityQueue<>();

        for (int num: nums
             ) {
            if(p.size()<k){
                p.offer(num);
            }else if(p.peek()<num){
                p.poll();
                p.offer(num);
            }
        }
        return p;
    }
}
