package ru.netology;

public class ProductManager {
    private ProductRepository repo;

    public ProductManager(ProductRepository repo) {
        this.repo = repo;
    }

    public void add(Product item) {
        repo.save(item);
    }

    public void del(int id){
        repo.removeById(id);
    }

    public Product[] getItems() {
        Product[] items = repo.findAll();
        return items;
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product: repo.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length +1];
                for (int i = 0; i < result.length; i++){
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {
        return product.getName().contains(search);
    }



}