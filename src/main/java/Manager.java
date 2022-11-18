import ru.netology.INH.*;

public class Manager {

//    protected String productName;
//    protected String searchingText;


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
        for (Product product : repo.getItems()) {
            if (matches(product, text)) {
                 result = new Product[]{product};
//                Product[] tmp = new Product[1];
//                tmp[0] = product;
                return result;
            }
        }
        return result;
    }
}
