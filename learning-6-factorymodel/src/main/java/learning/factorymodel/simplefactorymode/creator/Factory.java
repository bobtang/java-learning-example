package learning.factorymodel.simplefactorymode.creator;

import learning.factorymodel.simplefactorymode.concreteproduct.WindowBig;
import learning.factorymodel.simplefactorymode.concreteproduct.WindowSmall;
import learning.factorymodel.simplefactorymode.product.Window;

/**
 * 工厂类
 */
public class Factory {
    public Window CreateWindow(String type) {
        if (type.equals("Big")) {
            return new WindowBig();
        } else if (type.equals("Small")) {
            return new WindowSmall();
        } else {
            return new WindowBig();
        }
    }
}