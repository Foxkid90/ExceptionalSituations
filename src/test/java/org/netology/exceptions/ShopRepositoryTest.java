package org.netology.exceptions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.netlogy.exceptions.NotFoundException;
import org.netlogy.exceptions.Product;
import org.netlogy.exceptions.ShopRepository;

public class ShopRepositoryTest {

    @Test
    public void shouldRemoveProductSuccess() {
        ShopRepository shopRepo = new ShopRepository();
        Product product1 = new Product(1, "Баскетбольный мяч", 500);
        Product product2 = new Product(2, "Футбольный мяч", 800);
        Product product3 = new Product(3, "Теннисный мяч", 300);

        shopRepo.add(product1);
        shopRepo.add(product2);
        shopRepo.add(product3);

        shopRepo.removeById(2);

        Product[] expected = {product1, product3};
        Product[] actual = shopRepo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGenerateException() {
        ShopRepository shopRepo = new ShopRepository();
        Product product1 = new Product(1, "Баскетбольный мяч", 500);
        Product product2 = new Product(2, "Футбольный мяч", 800);
        Product product3 = new Product(3, "Теннисный мяч", 300);

        shopRepo.add(product1);
        shopRepo.add(product2);
        shopRepo.add(product3);

        Assertions.assertThrows(NotFoundException.class, () -> {shopRepo.removeById(15);
        });


    }
}
