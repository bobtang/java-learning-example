package learning.factorymodel.factorymethodmodel.concreteproduct;

import learning.factorymodel.factorymethodmodel.product.PenCore;

/**
 * 具体产品（ConcreteProduct）_2
 */
public class BluePenCore extends PenCore {
    public BluePenCore() {
        color = "蓝色";
    }

    public void writeWord(String s) {
        System.out.println("写出" + color + "的字:" + "\u001b[1;34m" + s +"\u001b[0m");
    }
}
