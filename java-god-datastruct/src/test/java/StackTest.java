
import com.wsp.java.god.datastruct.list.MyStack;

import java.util.Iterator;
import java.util.Stack;

/**
 * 堆栈测试类
 */
public class StackTest {


    public static void main(String args[]){
        MyStack<String> s0 = new MyStack<String>();
        Stack s1 = new Stack();
        //testPushAndPop(s0);
        //clearStack(s0);
        iteratorStack(s0);
    }

    public static void testPushAndPop(MyStack stack){
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        System.out.println(stack.size());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.size());
    }


    public static void clearStack(MyStack<String> stack){
        stack.push("aa");
        System.out.println(stack.size());
        stack.clear();
        System.out.println(stack.size());
    }

    public static void iteratorStack(MyStack<String> stack){
        stack.push("a");
        stack.push("b");
        stack.push("c");
        Iterator it =  stack.iterator();
        while (it.hasNext()){
            System.out.println(it.next()+"a");
        }
    }
}
