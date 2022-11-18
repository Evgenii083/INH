import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.INH.*;

public class RepositoryTest {
    Product item1 = new Product(1, "Поворская книга", 56);
    Product item2 = new Product(2, "Samsung Galaxy S22", 97_000);
    Product item3 = new Product(3,"Тетрадь",34);
    Product item4 = new Product(4, "Iphone 14 pro", 125_000);


    @Test
    public void shouldSaveItems(){
        Repository repo = new Repository();

        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
        repo.save(item4);

        Product[] expected = {item1,item2,item3,item4};
        Product[] actual = repo.getItems();

        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    public void shouldDeleteById(){
        Repository repo = new Repository();

        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
        repo.save(item4);

        repo.removeById(3);

        Product[] expected = {item1,item2,item4};
        Product[] actual = repo.getItems();
        Assertions.assertArrayEquals(expected,actual);
    }
}
