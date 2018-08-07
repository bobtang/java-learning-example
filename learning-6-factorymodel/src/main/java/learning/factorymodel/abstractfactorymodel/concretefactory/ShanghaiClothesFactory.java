package learning.factorymodel.abstractfactorymodel.concretefactory;

import learning.factorymodel.abstractfactorymodel.abstractfactory.ClothesFactory;
import learning.factorymodel.abstractfactorymodel.concreteproduct.WesternTrousers;
import learning.factorymodel.abstractfactorymodel.concreteproduct.WesternUpperClothes;
import learning.factorymodel.abstractfactorymodel.product.Trousers;
import learning.factorymodel.abstractfactorymodel.product.UpperClothes;

/**
 * 具体工厂-上海衣服工厂
 */
public class ShanghaiClothesFactory extends ClothesFactory {
    public UpperClothes createUpperClothes(int chestSize, int height) {
        return new WesternUpperClothes("上海牌牛仔上衣", chestSize, height);
    }

    public Trousers createTrousers(int waistSize, int height) {
        return new WesternTrousers("上海牌牛仔裤", waistSize, height);
    }
}
