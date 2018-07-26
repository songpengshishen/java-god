package com.wsp.java.god.algorithm.interview.reverseString;

import java.util.Stack;

/**
 * 递归逆序字符串,并排除相隔之间的重复字符,如  “aabccdaf” 返回  "fadcba"
 *
 * @author wsp
 */
public class ReverseString {


    public String reverseString(String str) {
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<String>();
        for(int i = str.length()-1;i>=0;i--){
            String temp = str.substring(i,i+1);
            if(!stack.isEmpty()&&!temp.equals(stack.peek())){
                sb.append(temp);
            }else if(stack.isEmpty()){
                sb.append(temp);
            }
            stack.push(temp);
        }
        return sb.toString();
    }





}
