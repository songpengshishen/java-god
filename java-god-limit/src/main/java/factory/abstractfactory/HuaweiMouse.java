package factory.abstractfactory;

/**
 * 华为鼠标
 */
public class HuaweiMouse implements Mouse {

    @Override
    public void move() {
        System.out.println("华为在移动");
    }
}
