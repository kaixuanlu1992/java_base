package desgin_pattern.composite;
//叶子角色
public class FinanceDepartment extends Company {
    @Override
    public void add(Company company) {

    }

    @Override
    public void remove(Company company) {

    }

    @Override
    public void display(int depth) {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < depth; i++) {
            sb.append("-");
        }
        System.out.println(new String(sb) + this.getName());
    }

    public FinanceDepartment(String name) {
        super(name);
    }

    public FinanceDepartment() {
    }
}
