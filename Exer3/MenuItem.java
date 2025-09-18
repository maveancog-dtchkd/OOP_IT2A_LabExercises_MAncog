
public class MenuItem {
    String name;

    public MenuItem(String name) {
        this.name = name;
    }

    public void order() {
        System.out.println(" Ordering " + name + "...");
    }
}

class Food extends MenuItem {
    public Food(String name) {
        super(name);
    }
}

class Drink extends MenuItem {
    public Drink(String name) {
        super(name);
    }
}

class Dessert extends MenuItem {
    public Dessert(String name) {
        super(name);
    }
}

class Burger extends Food {
    public Burger() {
        super("Burger");
    }
}

class Pizza extends Food {
    public Pizza() {
        super("Pizza");
    }
}

class Soda extends Drink {
    public Soda() {
        super("Soda");
    }
}

class Juice extends Drink {
    public Juice() {
        super("Juice");
    }
}

class IceCream extends Dessert {
    public IceCream() {
        super("Ice Cream");
    }
}

class Cake extends Dessert {
    public Cake() {
        super("Cake");
    }
}
