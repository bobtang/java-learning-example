package learning.factorymodel.abstractfactorymodel.concreteproduct;

import learning.factorymodel.abstractfactorymodel.product.UpperClothes;

/**
 * 具体产品（ConcreteProduct)_1 西式上衣
 */
public class WesternUpperClothes extends UpperClothes {
    private int chestSize;
    private int height;
    private String name;

    public WesternUpperClothes(String name, int chestSize, int height) {
        this.name = name;
        this.chestSize = chestSize;
        this.height = height;
    }

    public int getChestSize() {
        return chestSize;
    }

    public int getHeight() {
        return height;
    }

    public String getName() {
        return name;
    }
}
