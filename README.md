# BuilderPattern
设计模式之建造者模式

**将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示。**   
其核心是基本方法的调用顺序安排，也就是零件的装配，顺序不同产生的对象也不同

# BuilderPattern
#### 设计模式之建造者模式
[Demo github地址:【BuilderPattern】](https://github.com/elspet/BuilderPattern)
**将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示。**其核心是基本方法的调用顺序安排，也就是零件的装配，顺序不同产生的对象也不同

```
目录：
A、建造者模式的优点
B、使用场景

一、抽象茶叶建造者
二、具体茶叶建造者
三、抽象制茶模型
四、红茶实现模型
五、制茶大师，给出专业的制茶工序
六、客户提需求，要 “两份红茶，三份白茶”
```

#### A、建造者模式的优点
+ 封装性
+ 独立，容易扩展
+ 便于控制细节风险，对建造过程逐步细化

#### B、使用场景
+ 相同的方法，不同的执行顺序产生不同的结果
+ 多个部件或零件，可以配置到多个对象中，产生不同的结果
+ 产品类中的调用顺序不同会产生不同的效果时

#### 一、抽象茶叶建造者
```java
/**
 * 抽象茶叶建造者
 * @author Lisa
 * @date 2018/9/18
 */
public abstract class AbstractTeaBuilder   {
    /**
     * 设置制茶顺序
     * @param sequence
     */
    public abstract void setSequence(ArrayList<String> sequence);
    /**
     * 获取茶叶
     * @return
     */
    public abstract TeaModel getTeaModel();
}
```

#### 二、具体茶叶建造者
```java
/**
 * 红茶建造者
 * @author Lisa
 * @date 2018/9/18
 */
public class BlackTeaBuilder extends AbstractTeaBuilder   {

    BlackTeaModel blackTeaModel = new BlackTeaModel();

    @Override
    public void setSequence(ArrayList<String> sequence) {
        this.blackTeaModel.setSequence(sequence);
    }

    @Override
    public TeaModel getTeaModel() {
        return this.blackTeaModel;
    }
}
```
#### 三、抽象制茶模型
+ 3.1、配置
```java 
/**
 * 配置
 * @author Lisa
 * @date 2018/9/18
 */

public class AppConfigs   {

    /**
     * 采摘
     */
    public static final String BAKING = "baking";
    /**
     * 萎调
     */
    public static final String DETERIORATION = "deterioration";
    /**
     * 揉捻
     */
    public static final String ROLLING = "rolling";
    /**
     * 烘干
     */
    public static final String DRY = "dry";
    /**
     * 发酵
     */
    public static final String FERMENTATION = "fermentation";
    /**
     * 保存
     */
    public static final String SAVE = "save";
}
```
+ 2、抽象制茶模型
```java
/**
 * 抽象制茶模型
 * @author Lisa
 */
public abstract class TeaModel {
    /**
     * 采摘
     */
    public abstract void baking();
    /**
     * 萎调
     */
    public abstract void deterioration();
    /**
     * 揉捻
     */
    public abstract void rolling();
    /**
     * 烘干
     */
    public abstract void dry();
    /**
     * 发酵
     */
    public abstract void fermentation();
    /**
     * 保存
     */
    public abstract void save();

    private ArrayList<String> sequence = new ArrayList<>();

    final public void setSequence(ArrayList<String> sequence) {
        this.sequence = sequence;
    }

    final public void make() {
        for (int i = 0; i < sequence.size(); i++) {
            String action = this.sequence.get(i);
            switch (action) {
                case AppConfigs.BAKING:
                    this.baking();
                    break;
                case AppConfigs.DETERIORATION:
                    this.deterioration();
                    break;
                case AppConfigs.DRY:
                    this.dry();
                    break;
                case AppConfigs.FERMENTATION:
                    this.fermentation();
                    break;
                case AppConfigs.ROLLING:
                    this.rolling();
                    break;
                case AppConfigs.SAVE:
                    this.save();
                    break;
                default:
                    System.out.println("未知操作");
                    break;
            }
        }
    }
}
```
#### 四、红茶实现模型
```java
/**
 * 红茶
 * @author Lisa
 * @date 2018/9/18
 */
public class BlackTeaModel extends TeaModel {

    @Override
    public void baking() {
        System.out.println("红茶：采摘");
    }

    @Override
    public void deterioration() {
        System.out.println("红茶：萎调");
    }

    @Override
    public void rolling() {
        System.out.println("红茶：揉捻");
    }

    @Override
    public void dry() {
        System.out.println("红茶：烘干");
    }

    @Override
    public void fermentation() {
        System.out.println("红茶：发酵");
    }

    @Override
    public void save() {
        System.out.println("红茶：保存");
    }
}
```

#### 五、制茶大师，给出专业的制茶工序
```java
/**
 * 制茶大师，给出制茶工序
 * @author Lisa
 * @date 2018/9/18
 */
public class TeaMakeDirector   {

    private ArrayList<String> sequence = new ArrayList<>();
    private WhiteTeaBuilder whiteTeaBuilder = new WhiteTeaBuilder();
    private BlackTeaBuilder blackTeaBuilder = new BlackTeaBuilder();
    /**
     * 白茶制作工序 ：采摘 → 萎调 → 烘干 → 保存
     * @return、
     */
    public WhiteTeaModel makeWhiteTea(){
        this.sequence.clear();
        this.sequence.add(AppConfigs.BAKING);
        this.sequence.add(AppConfigs.DETERIORATION);
        this.sequence.add(AppConfigs.DRY);
        this.sequence.add(AppConfigs.SAVE);
        this.whiteTeaBuilder.setSequence(this.sequence);
        return (WhiteTeaModel) this.whiteTeaBuilder.getTeaModel();
    }
    /**
     * 红茶制作工序 ：采摘 → 萎调 → 揉捻 → 发酵 → 干燥
     * @return
     */
    public BlackTeaModel makeBlackTea(){
        this.sequence.clear();
        this.sequence.add(AppConfigs.BAKING);
        this.sequence.add(AppConfigs.DETERIORATION);
        this.sequence.add(AppConfigs.ROLLING);
        this.sequence.add(AppConfigs.FERMENTATION);
        this.sequence.add(AppConfigs.DRY);
        this.blackTeaBuilder.setSequence(this.sequence);
        return (BlackTeaModel) this.blackTeaBuilder.getTeaModel();
    }
}
```
#### 六、客户提需求，要 “两份红茶，三份白茶”
```java
/**
 * 客户提需求，两份红茶，三份白茶
 * @author Lisa
 * @date 2018/9/18
 */
public class Client   {

    public static void main(String[] args){
        int blackNum = 2;
        int whiteNum = 3;
        TeaMakeDirector teaMaker = new TeaMakeDirector();
        for (int i=0;i<blackNum;i++){
            System.out.println("-----制作红茶-----");
            teaMaker.makeBlackTea().make();
        }
        System.out.println("-------------------------");
        for (int i=0;i<whiteNum;i++){
            System.out.println("-----制作白茶-----");
            teaMaker.makeWhiteTea().make();
        }
    }
}
```
