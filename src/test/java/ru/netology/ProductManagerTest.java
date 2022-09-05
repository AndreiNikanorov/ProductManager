package ru.netology;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

    public class ProductManagerTest {

        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);

        Product item1 = new Book(1, "Ангелы и демоны", 1000, "Дэн Браун");
        Product item2 = new Book(2, "СтрАдающее Средневековье", 123, "Сергей Зотов");
        Product item3 = new Smartphone(3, "Айфон", 64_000,"Apple");


        @BeforeEach
        public void setup() {
            manager.add(item1);
            manager.add(item2);
            manager.add(item3);
        }

        @Test
        public void ShouldViewAll() {
            Product[] actual = manager.getItems();
            Product[] expected = {item1, item2, item3};

            assertArrayEquals(expected, actual);
        }

        @Test
        public void ShouldDelete() {
            manager.del(2);

            Product[] actual = manager.getItems();
            Product[] expected = {item1, item3};

            assertArrayEquals(expected, actual);
        }

        @Test
        public void ShouldFindAll() {
            Product[] actual = manager.searchBy("А");
            Product[] expected = {item1, item2, item3};

            assertArrayEquals(expected, actual);
        }

        @Test
        public void ShouldFindNothing() {
            Product[] actual = manager.searchBy("ka");
            Product[] expected = {};

            assertArrayEquals(expected, actual);
        }

    }