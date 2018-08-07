package learning.factorymodel.abstractfactorymodel.concretefactory;

import learning.factorymodel.abstractfactorymodel.abstractfactory.ClothesFactory;
import learning.factorymodel.abstractfactorymodel.concreteproduct.WesternTrousers;
import learning.factorymodel.abstractfactorymodel.concreteproduct.WesternUpperClothes;
import learning.factorymodel.abstractfactorymodel.product.Trousers;
import learning.factorymodel.abstractfactorymodel.product.UpperClothes;

/**
 * 具体工厂-北京衣服工厂
 */
public class BeijingClothesFactory extends ClothesFactory {
    public UpperClothes createUpperClothes(int chestSize, int height) {
        return new WesternUpperClothes("北京牌西服上衣", chestSize, height);
    }

    public Trousers createTrousers(int waistSize, int height) {
        return new WesternTrousers("北京牌西服裤子", waistSize, height);
    }
}
