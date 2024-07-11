package kz.erlan.osserbay.springproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
@Scope("prototype")
public class Cart {
    private final ProductRepository productRepository;
    private final Map<Product, Integer> cartItems = new HashMap<>();

    @Autowired
    public Cart(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProductById(int id) {
        Optional<Product> product = productRepository.findById(id);
        product.ifPresent(p -> cartItems.merge(p, 1, Integer::sum));
    }

    public void removeProductById(int id) {
        Optional<Product> product = productRepository.findById(id);
        product.ifPresent(p -> cartItems.computeIfPresent(p, (key, quantity) -> quantity > 1 ? quantity - 1 : null));
    }

    public Map<Product, Integer> getCartItems() {
        return cartItems;
    }
}
