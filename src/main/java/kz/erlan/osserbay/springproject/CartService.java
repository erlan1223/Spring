package kz.erlan.osserbay.springproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CartService {
    private final Cart cart;

    @Autowired
    public CartService(Cart cart) {
        this.cart = cart;
    }

    public void addToCart(int productId) {
        cart.addProductById(productId);
    }

    public void removeFromCart(int productId) {
        cart.removeProductById(productId);
    }

    public void displayCart() {
        Map<Product, Integer> cartItems = cart.getCartItems();
        if (cartItems.isEmpty()) {
            System.out.println("Корзина пуста.");
        } else {
            cartItems.forEach((product, quantity) ->
                    System.out.println(product + " - Количество: " + quantity));
            System.out.println("Общая стоимость корзины: " + calculateTotalPrice(cartItems));
        }
    }

    private double calculateTotalPrice(Map<Product, Integer> cartItems) {
        double total = 0.0;
        for (Map.Entry<Product, Integer> entry : cartItems.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            total += product.getPrice() * quantity;
        }
        return total;
    }
}

