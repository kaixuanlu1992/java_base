package desgin_pattern.Visitor;

public class WorkerOfPharmacy extends Visitor {
    @Override
    public void visitor(MedicineA a) {
        System.out.println("药房工作者：" + name + "拿药 ：" + a.getName());
    }

    @Override
    public void visitor(MedicineB b) {
        System.out.println("药房工作者：" + name + "拿药 ：" + b.getName());
    }
}
