package learning.factorymodel.abstractfactorymodel;

import learning.factorymodel.abstractfactorymodel.abstractfactory.ClothesFactory;
import learning.factorymodel.abstractfactorymodel.concretefactory.BeijingClothesFactory;
import learning.factorymodel.abstractfactorymodel.concretefactory.ShanghaiClothesFactory;
import learning.factorymodel.abstractfactorymodel.product.Trousers;
import learning.factorymodel.abstractfactorymodel.product.UpperClothes;
import learning.factorymodel.factorymethodmodel.concretecreator.BlackBallPen;
import learning.factorymodel.factorymethodmodel.concretecreator.BlueBallPen;
import learning.factorymodel.factorymethodmodel.concretecreator.RedBallPen;
import learning.factorymodel.factorymethodmodel.creator.BallPen;
import learning.factorymodel.factorymethodmodel.product.PenCore;

/**
 * 应用-商店
 */
public class Shop {
    UpperClothes cloth;
    Trousers trouser;

    public void giveSuit(ClothesFactory factory, int chestSize, int waistSize, int height) {
        cloth = factory.createUpperClothes(chestSize, height);
        trouser = factory.createTrousers(waistSize, height);
        showMess();
    }

    private void showMess() {
        System.out.println("<套装信息>");
        System.out.println(cloth.getName() + ":");
        System.out.print("胸围:" + cloth.getChestSize());
        System.out.println("身高:" + cloth.getHeight());
        System.out.println(trouser.getName() + ":");
        System.out.print("腰围:" + trouser.getWaistSize());
        System.out.println("身高:" + trouser.getHeight());
    }

    public static void main(String args[]) {
        Shop shop = new Shop();
        shop.giveSuit(new BeijingClothesFactory(), 1, 2, 3);
        shop.giveSuit(new ShanghaiClothesFactory(), 10, 20, 30);

    }
}
