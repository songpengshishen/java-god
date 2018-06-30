package factory.abstractfactory;

/**
 * 华为PC工厂
 */
public class HuaweiPcFactory implements PcFactory {
    @Override
    public Mouse createMouse() {
        return new HuaweiMouse();
    }

    @Override
    public KeyBoard createKeyBoard() {
        return new HuaweiKeyBoard();
    }
}
