package org.netology.exceptions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.netlogy.exceptions.AlreadyExistsException;
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
    public void shouldGenerateExceptionNotFound() {
        ShopRepository shopRepo = new ShopRepository();
        Product product1 = new Product(1, "Баскетбольный мяч", 500);
        Product product2 = new Product(2, "Футбольный мяч", 800);
        Product product3 = new Product(3, "Теннисный мяч", 300);

        shopRepo.add(product1);
        shopRepo.add(product2);
        shopRepo.add(product3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            shopRepo.removeById(15);
        });
    }

    @Test
    public void shouldAddNewProductSuccess() {
        ShopRepository shopRepo = new ShopRepository();
        Product product1 = new Product(1, "Баскетбольный мяч", 500);
        Product product2 = new Product(2, "Футбольный мяч", 800);
        Product product3 = new Product(3, "Теннисный мяч", 300);
        Product product4 = new Product(4, "Волейбольный мяч", 400);

        shopRepo.add(product1);
        shopRepo.add(product2);
        shopRepo.add(product3);

        shopRepo.add(product4);

        Product[] expected = {product1, product2, product3, product4};
        Product[] actual = shopRepo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGenerateExceptionAlreadyExists() {
        ShopRepository shopRepo = new ShopRepository();
        Product product1 = new Product(1, "Баскетбольный мяч", 500);
        Product product2 = new Product(2, "Футбольный мяч", 800);
        Product product3 = new Product(3, "Теннисный мяч", 300);
        Product product4 = new Product(3, "Бейсбольная бита", 600);

        shopRepo.add(product1);
        shopRepo.add(product2);
        shopRepo.add(product3);

        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            shopRepo.add(product4);
        });
    }
}
