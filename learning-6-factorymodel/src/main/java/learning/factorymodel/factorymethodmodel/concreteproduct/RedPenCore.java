package learning.factorymodel.factorymethodmodel.concreteproduct;

import learning.factorymodel.factorymethodmodel.product.PenCore;

/**
 * 具体产品（ConcreteProduct）_1
 */
public class RedPenCore extends PenCore {
    public RedPenCore() {
        color = "红色";
    }

    public void writeWord(String s) {
        System.out.println("写出" + color + "的字:" + "\u001b[1;31m" + s + "\u001b[0m");
    }
}
