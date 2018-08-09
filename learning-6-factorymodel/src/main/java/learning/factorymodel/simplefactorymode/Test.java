package learning.factorymodel.simplefactorymode;

import learning.factorymodel.simplefactorymode.creator.Factory;
import learning.factorymodel.simplefactorymode.product.Window;

public class Test {
    // The Main function only for our test
    public static void main(String[] args) {
        Factory myFactory = new Factory();
        Window myBigWindow = myFactory.createWindow("Big");
        myBigWindow.func();

        Window mySmallWindow = myFactory.createWindow("Small");
        mySmallWindow.func();
    }
}
