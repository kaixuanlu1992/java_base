package desgin_pattern.build;
/*
建造者模式：将产品的内部表象【建造者角色】与产品的生产过程【导演角色】分隔开，从而使一个建造过程生成具有不同内部表象的产品表象。
用途：用于构建复杂的对象或者生成的产品对象的属性相互依赖
 */
public class Client {
    public static void main(String[] args) {
        InsuranceContract.ConcreteBuilder builder = new InsuranceContract.ConcreteBuilder("9527", 623L, 4156L);
        InsuranceContract contract = builder.setPersonName("小明").setOtherData("test").build();
        contract.someOperation();
    }
}
