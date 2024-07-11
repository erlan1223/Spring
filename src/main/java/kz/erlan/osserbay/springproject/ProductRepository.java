package kz.erlan.osserbay.springproject;

import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {
    private List<Product> products = new ArrayList<>();

    public ProductRepository() {
        products.add(new Product(1, "IPhone 15", 700.0));
        products.add(new Product(2, "Huawei nova 11 ", 500.0));
        products.add(new Product(3, "Samsung Galaxy A54", 500.0));
        products.add(new Product(4, "Xiaomi 13 Pro", 700.0));
        products.add(new Product(5, "Asus Zenfore 10", 700.0));
    }

    public Optional<Product> findById(int id) {
        return products.stream().filter(product -> product.getId() == id).findFirst();
    }
}
