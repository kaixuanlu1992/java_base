package desgin_pattern.composite;
/*
组合模式：也叫做部分整体模式，将对象组合成树形结构以表示“部分整体”的层次结构。组合模式使得用户对单个对象和使用具有一致性。
3个角色：
Component 是组合中的对象声明接口，在适当的情况下，实现所有类共有接口的默认行为。声明一个接口用于访问和管理Component子部件。
Leaf 在组合中表示叶子结点对象，叶子结点没有子结点。
Composite 定义有枝节点行为，用来存储子部件，在Component接口中实现与子部件有关操作，如增加(add)和删除 (remove)等。
 */
public class Client {
    public static void main(String[] args) {
        Company company=new ConcreteCompany("北京总公司");
        company.add(new FinanceDepartment("总公司财务部"));
        company.add(new HRDepartment("总公司人力资源部"));

        Company shandongCom = new ConcreteCompany("山东分公司");
        shandongCom.add(new HRDepartment("山东分公司人力资源部"));
        shandongCom.add(new FinanceDepartment("山东分公司账务部"));

        Company zaozhuangCom = new ConcreteCompany("枣庄办事处");
        zaozhuangCom.add(new FinanceDepartment("枣庄办事处财务部"));
        zaozhuangCom.add(new HRDepartment("枣庄办事处人力资源部"));

        Company jinanCom = new ConcreteCompany("济南办事处");
        jinanCom.add(new FinanceDepartment("济南办事处财务部"));
        jinanCom.add(new HRDepartment("济南办事处人力资源部"));

        shandongCom.add(jinanCom);
        shandongCom.add(zaozhuangCom);

        Company huadongCom = new ConcreteCompany("上海华东分公司");
        huadongCom.add(new HRDepartment("上海华东分公司人力资源部"));
        huadongCom.add(new FinanceDepartment("上海华东分公司账务部"));

        Company hangzhouCom = new ConcreteCompany("杭州办事处");
        hangzhouCom.add(new FinanceDepartment("杭州办事处财务部"));
        hangzhouCom.add(new HRDepartment("杭州办事处人力资源部"));

        Company nanjingCom = new ConcreteCompany("南京办事处");
        nanjingCom.add(new FinanceDepartment("南京办事处财务部"));
        nanjingCom.add(new HRDepartment("南京办事处人力资源部"));

        huadongCom.add(hangzhouCom);
        huadongCom.add(nanjingCom);

        company.add(shandongCom);
        company.add(huadongCom);

        company.display(0);

    }
}
