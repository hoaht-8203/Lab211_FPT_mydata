package fruitShop;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class FruitList extends ArrayList<Fruit> {
    public void test() {
        this.add(new Fruit("F01", "Coconut", 2, 10, "Vietnam"));
        this.add(new Fruit("F02", "Orange", 3, 10, "US"));
        this.add(new Fruit("F03", "Apple", 4, 10, "Thailand"));
        this.add(new Fruit("F04", "Grape", 6, 10, "France"));
    }

    public FruitList() {

    }

    public static List<Order> orderList = new ArrayList<>();

    public int searchId(String id) {
        for (Fruit fruit : this) {
            if (fruit.getFruitId().equalsIgnoreCase(id)) {
                return this.indexOf(fruit);
            }
        }

        return -1;
    }

    public boolean isDuplicateId(String id) {
        for (Fruit f : this) {
            if (f.getFruitId().equalsIgnoreCase(id)) return true;
        }

        return false;
    }

    public void printListAfterCeate(ArrayList<String> list) {
        System.out.println("------------- List fruit what are created -------------");
        System.out.printf("| %-10s | %-10s | %-10s | %-10s | %-10s |\n", "Fruit ID", "Fruit Name", "Price", "Quantity", "Origin");
        for (String id : list) {
            for (Fruit fruit : this) {
                if (fruit.getFruitId().equalsIgnoreCase(id)) {
                    System.out.printf("| %-10s | %-10s | $%-9.2f | %-10d | %-10s |\n", fruit.getFruitId(), fruit.getFruitName(), fruit.getPrice(), fruit.getQuantity(), fruit.getOrigin());
                }
            }
        }
        System.out.println("-------------------------------------------------------");
    }

    public int getChoiceFromMenuFruit() {
        System.out.println("------------- List of fruit -------------");
        System.out.printf("| %-10s | %-10s | %-10s | %-10s |\n", "Item", "Fruit Name", "Origin", "Price");

        for (Fruit fruit : this) {
            System.out.printf("| %-10s | %-10s | %-10s | $%-9.2f |\n", this.indexOf(fruit) + 1, fruit.getFruitName(), fruit.getOrigin(), fruit.getPrice());
        }
        System.out.println("-------------------------------------------------------");
        return Enter.get_int("Enter item you want: ", 1, this.size());
    }

    public void addFruit() {
        ArrayList<String> listId = new ArrayList<>();
        boolean isContinue = true;
        while (isContinue) {
            String fruitId;
            do {
                fruitId = Enter.get_str_nonBlank("Enter fruit ID: ");
            } while (isDuplicateId(fruitId));
            String fruitName = Enter.get_str_nonBlank("Enter fruit name: ");
            double price = Enter.get_price("Enter price: ", 0);
            int quantity = Enter.get_int("Enter quantity: ", 0);
            String origin = Enter.get_str_nonBlank("Enter origin: ");

            Fruit fruit = new Fruit(fruitId, fruitName, price, quantity, origin);
            this.add(fruit);
            listId.add(fruitId);
            System.out.println("Add fruit " + fruitId + " success!");

            isContinue = Enter.get_boolean("Do you want to continue (Y/N): ");
        }
        printListAfterCeate(listId);
    }

    public boolean checkFruitDuplicateInOrder(Fruit fruit, Hashtable<String, Integer> orderDraftList) {
        for (Map.Entry<String, Integer> entry : orderDraftList.entrySet()) {
            if (entry.getKey().equalsIgnoreCase(fruit.getFruitId())) {
                return true;
            }
        }

        return false;
    }

    public void updateQuantityFruit(String fruitId, int quantitySold) {
        for (Fruit fruit : this) {
            if (fruit.getFruitId().equalsIgnoreCase(fruitId)) {
                int oldQuantity = fruit.getQuantity();
                fruit.setQuantity(oldQuantity - quantitySold);
            }
        }
    }

    public void viewOrder() {
        if (orderList.isEmpty()) {
            System.out.println("List order is empty!");
        } else {
            System.out.println("------------- List Order -------------");
            for (Order order : orderList) {
                System.out.println("Customer: " + order.getCustomerName());
                System.out.printf("| %-10s | %-10s | %-10s | %-10s |\n", "Product", "Quanity", "Price", "Amount");
                int i = 1;
                for (OrderDetail orderDetail : order.getOrderDetails()) {
                    System.out.printf("|%d.%-8s | %-10d | %-10.2f | %-10.2f |\n",i ,orderDetail.getProduct(), orderDetail.getQuantity(), orderDetail.getPrice(), orderDetail.getAmount());
                    i++;
                }
                System.out.printf("TOTAL: %.2f\n", order.getTotal());
            }
            System.out.println("--------------------------------------");
        }
    }

    public void shopping() {
        if (this.isEmpty()) {
            System.out.println("List fruit is empty!");
        } else {
            boolean isContinue = false;
            Hashtable<String, Integer> orderDraftList = new Hashtable<>();
            while (!isContinue) {
                int item = getChoiceFromMenuFruit();
                Fruit fruit = this.get(item - 1);

                if (fruit.getQuantity() == 0) {
                    System.out.println("This fruit is sold out!");
                } else {
                    boolean isDuplicateFruit = checkFruitDuplicateInOrder(fruit, orderDraftList);

                    if (isDuplicateFruit) {
                        System.out.println("Fruit " + fruit.getFruitName() + " has selected in order!");
                        boolean isChangeQuantity = Enter.get_boolean("Do you want to change quantity (Y/N): ");

                        if (isChangeQuantity) {
                            int newQuantity = Enter.get_int("Please input new quantity: ", 0, fruit.getQuantity(), "This fruit just has " + fruit.getQuantity() + " item in the store!");

                            for (Map.Entry<String, Integer> entry : orderDraftList.entrySet()) {
                                if (entry.getKey().equalsIgnoreCase(fruit.getFruitId())) {
                                    entry.setValue(newQuantity);
                                    break;
                                }
                            }
                            System.out.println("Update success!");
                            isContinue = Enter.get_boolean("Do you want to order now (Y/N): ");
                        }
                    } else {
                        System.out.println("You are selected: " + fruit.getFruitName());
                        int quantity = Enter.get_int("Please input quantity: ", 0, fruit.getQuantity(), "This fruit just has " + fruit.getQuantity() + " item in the store!");

                        orderDraftList.put(fruit.getFruitId(), quantity);

                        isContinue = Enter.get_boolean("Do you want to order now (Y/N): ");
                    }
                }
            }

            List<OrderDetail> orderDetailList = new ArrayList<>();

            System.out.println("----------- Your Order -----------");
            System.out.printf("| %-10s | %-10s | %-10s | %-10s |\n", "Product", "Quantity", "Price", "Amount");
            double total = 0;
            for (Map.Entry<String, Integer> entry : orderDraftList.entrySet()) {
                int index = searchId(entry.getKey());
                Fruit fruit = this.get(index);
                System.out.printf("| %-10s | %-10d | %-10.2f | %-10.2f |\n", fruit.getFruitName(), entry.getValue(), fruit.getPrice(), entry.getValue() * fruit.getPrice());
                OrderDetail orderDetail = new OrderDetail(fruit.getFruitName(), entry.getValue(), fruit.getPrice());
                orderDetailList.add(orderDetail);
                total += entry.getValue() * fruit.getPrice();
                updateQuantityFruit(entry.getKey(), entry.getValue());
            }
            System.out.printf("TOTAL: %.2f\n", total);
            System.out.println("----------------------------------");

            String customerName = Enter.get_str_nonBlank("Enter your name: ");
            Order order = new Order(customerName, orderDetailList, total);
            orderList.add(order);
            System.out.println("Have a nice day!");
        }
    }
}
