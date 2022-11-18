import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.INH.*;

public class ManagerTest {
    Repository repo = new Repository();
    Manager manager = new Manager(repo);

    Product item1 = new Product(1, "Поворская книга", 56);
    Product item2 = new Product(2, "Samsung Galaxy S22", 97_000);
    Product item3 = new Product(3, "Тетрадь", 34);
    Product item4 = new Product(4, "Iphone 14 pro", 125_000);


    @Test
    public void shouldSearchByName() {

        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);

        Product[] expected = {item3};
        Product[] actual = manager.searchBy("Тетрадь");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotSearchByWrongName() {

        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);

        Product[] expected = {};
        Product[] actual = manager.searchBy("Т345");
        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    public void constructorZeroTest() {
        Product item5 = new Product();
        item5.getName();
        Assertions.assertEquals( null,item5.getName());
    }

    @Test
    public void bookClassTest(){
        Book item6 = new Book();
        item6.setAuthor("Lenin");
        Assertions.assertEquals("Lenin",item6.getAuthor());
    }

    @Test
    public void smartphoneClassTest(){
        Smartphone item7 = new Smartphone();
        item7.setManufacturer("Nokia");
        Assertions.assertEquals("Nokia",item7.getManufacturer());
    }
}
