package desgin_pattern.composite;

public class HRDepartment extends Company {
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

    public HRDepartment() {
    }

    public HRDepartment(String name) {
        super(name);
    }
}
