class MenuItemTester {
    public static void main(String[] args) {

        MenuItem item1 = new Burger();
        MenuItem item2 = new Pizza();
        MenuItem item3 = new Soda();
        MenuItem item4 = new Juice();
        MenuItem item5 = new IceCream();
        MenuItem item6 = new Cake();

        item1.order();
        item2.order();
        item3.order();
        item4.order();
        item5.order();
        item6.order();
    }
}
