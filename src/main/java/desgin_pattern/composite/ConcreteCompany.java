package desgin_pattern.composite;

import java.util.ArrayList;
import java.util.List;

//composite角色
public class ConcreteCompany extends Company {
    private List<Company>list;

    public ConcreteCompany() {
        this.list = new ArrayList<Company>();
    }

    public ConcreteCompany(String name) {
        super(name);
        this.list = new ArrayList<Company>();
    }

    @Override
    public void add(Company company) {
        list.add(company);
    }

    @Override
    public void remove(Company company) {
        list.remove(company);
    }

    @Override
    public void display(int depth) {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < depth; i++) {
            sb.append("-");
        }
        System.out.println(new String(sb) + this.getName());
        for (Company c : list) {
            c.display(depth + 2);
        }
    }

}
