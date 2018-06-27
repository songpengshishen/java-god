

import com.wsp.java.god.datastruct.list.MyQueue;
import com.wsp.java.god.datastruct.list.MyStack;

import java.util.Iterator;

/**
 * 队列测试类
 */
public class QueueTest {


    public static void main(String args[]){
        MyQueue<String> queue = new MyQueue<>();
        //testEnqueueAndDeQueue(queue);
        iteratorQueue(queue);

    }

    public static void testEnqueueAndDeQueue(MyQueue<String> queue){
         queue.enQueue("a");
         queue.enQueue("b");
         queue.enQueue("c");
         queue.enQueue("d");
         queue.enQueue("e");
         queue.enQueue("f");
         queue.enQueue("g");
         queue.enQueue("h");
         queue.enQueue("i");
         queue.enQueue("j");
         String val1 = queue.deQueue();
         String val2 = queue.deQueue();
         String val3 = queue.deQueue();
         queue.enQueue("k");
         String val4 = queue.deQueue();
         queue.deQueue();
         queue.deQueue();
         queue.deQueue();
         queue.deQueue();
         queue.deQueue();
         String last = queue.deQueue();
         queue.deQueue();
    }


    public static void clearQueue(MyStack<String> stack){
        stack.push("aa");
        System.out.println(stack.size());
        stack.clear();
        System.out.println(stack.size());
    }

    public static void iteratorQueue(MyQueue<String> queue){
        queue.enQueue("a");
        queue.enQueue("b");
        queue.enQueue("c");
        queue.enQueue("d");
        queue.enQueue("e");
        queue.enQueue("f");
        queue.enQueue("g");
        queue.enQueue("h");
        queue.enQueue("i");
        queue.enQueue("j");
        queue.deQueue();
        queue.deQueue();
        queue.enQueue("k");
        Iterator<String> it =  queue.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}
