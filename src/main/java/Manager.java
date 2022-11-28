import ru.netology.INH.*;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Manager {
    Product items = new Product();
    private Repository repo;

    public Manager(Repository repo) {
        this.repo = repo;
    }

    public void add(Product items) {
        repo.save(items);
    }

    public boolean matches(Product product, String search) {
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repo.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[result.length] = product;
                result = tmp;
            }
        }
        return result;
    }
}
