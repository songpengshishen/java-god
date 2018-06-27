/**
 * 一:尾递归:
 * 尾递归是指程序递归的调用发生在函数的尾部,或者说是函数执行的最后一个语句,且递归后返回的值不是表达式的一部分是一个特定的值.
 * 尾递归的好处:因为尾递归在当前程序执行函数的尾部并且返回的是一个特定值.所以尾递归回归时函数不需要做其它操作(没有下文了).这样程序执行尾递归时,不需要像
 * 线性递归那样添加栈帧保存变量以及回归时收缩当前栈(弹栈帧).而是直接替代当前栈帧就可以.所以尾递归效率更高,也可以避免栈溢出.
 * 不过尾递归都需要编译器支持和优化.
 *
 * 二:递归和迭代,尾递归的个人理解:递归和迭代在转换成汇编或机器语言时都会转换成跳转指令,区别在于普通递归需要保存当前调用者的局部变量,新建一个栈帧保存被调用者的执行环境并压栈.所以
 * 内存消耗高,频繁压栈性能也低.而迭代和尾递归则直接覆盖或者说替代当前栈帧的执行环境接着执行.所以内存消耗低,效率也更高不需要频繁的压栈和弹栈.
 *
 * 三:简单的理解:
 * 尾递归 程序执行时进入下一个递归时不再需要上一次的执行环境了,所以可以直接覆盖.
 * 线性递归 程序执行时进入下一个递归时需要上一次的执行环境了,所以要保存局部变量添加栈帧.
 * 尾递归的难点:把普通递归变为尾递归是一个实现难点.
 * note:java 没有实现尾递归.
 */
public class TailRecursion {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int i  = recursion(1000);
        System.out.printf((System.currentTimeMillis()-startTime)+"");
    }

    /**
     * 普通递归
     * @param i
     */
    public static int recursion(int i){
        if(i == 1){
            return i;
        }
        return i+recursion(i-1);
    }


    /**
     * 尾递归
     * @param i
     */
    public static int Tailrecursion(int i,int y){
      if(i == 0){
          return y;
      }
      return Tailrecursion(i-1,y+i);
    }


}
