package decorate;

/**
 * 美女装饰着
 * @author wsp
 */
public class BeautyGirlDecorate implements Girl {
    private Girl girl;

    public BeautyGirlDecorate(Girl girl){
        this.girl = girl;
    }

    @Override
    public void dressing() {
        System.out.println("打扮漂亮点");
        girl.dressing();
    }
}
