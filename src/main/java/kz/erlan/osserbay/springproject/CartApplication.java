package kz.erlan.osserbay.springproject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.Scanner;

@SpringBootApplication
public class CartApplication {

    public static void main(String[] args) {
        SpringApplication.run(CartApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(CartService cartService) {
        return args -> {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("Введите команду (add, remove, show, exit):");
                String command = scanner.nextLine();
                if (command.equalsIgnoreCase("exit")) {
                    break;
                }

                switch (command.toLowerCase()) {
                    case "add":
                        System.out.println("Введите id продукта для добавления:");
                        int addId = scanner.nextInt();
                        scanner.nextLine();
                        cartService.addToCart(addId);
                        break;
                    case "remove":
                        System.out.println("Введите id продукта для удаления:");
                        int removeId = scanner.nextInt();
                        scanner.nextLine();
                        cartService.removeFromCart(removeId);
                        break;
                    case "show":
                        System.out.println("Содержимое корзины:");
                        cartService.displayCart();
                        break;
                    default:
                        System.out.println("Неверная команда.");
                        break;
                }
            }
            scanner.close();
        };
    }
}

