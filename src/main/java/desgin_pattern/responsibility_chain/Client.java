package desgin_pattern.responsibility_chain;
/*
责任链模式：很多对象由每一个对象对其下家的引用而连接起来形成一条链。请求在这个链上传递，直到链上的某一个对象决定处理此请求。
包含连个角色：抽象处理者、具体处理者
 */
public class Client {
    public static void main(String[] args) {
        Handler pm=new ProjectManager();
        Handler gm=new GeneralManager();
        Handler dm=new DeptManager();
        pm.setNextHandler(dm);
        dm.setNextHandler(gm);

        String str=pm.handleFeeRequest("张三",300);
        System.out.println("test1 = " + str);
    }
}
