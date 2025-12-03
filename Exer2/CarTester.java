class CarTester {
    public static void main(String[] args) {
        Car c1 = new Car("Toyota", "Yellow", "KAW12345", "AB123", "Gasoline", 180, 2020, 25000);
        Car c2 = new Car("Honda", "Red", "SYA7890", "CD456", "Diesel", 200, 2019, 22000);
        Car c3 = new Car("Ford", "Blue", "AKO081206", "EF789", "Gasoline", 220, 2021, 30000);
        Car c4 = new Car("BMW", "Black", "CLA060888", "GH012", "Gasoline", 250, 2022, 55000);
        Car c5 = new Car("Mercedes", "White", "KTA101221", "IJ345", "Diesel", 240, 2021, 60000);
        Car c6 = new Car("Hyundai", "Silver", "YIE674523", "KL678", "Gasoline", 190, 2018, 20000);
        Car c7 = new Car("Kia", "Green", "WEW53576", "MN901", "Electric", 170, 2023, 35000);
        Car c8 = new Car("Audi", "Gray", "WYN12121", "OP234", "Gasoline", 260, 2022, 65000);
        Car c9 = new Car("Nissan", "Orange", "HAK3849", "QR567", "Diesel", 210, 2020, 28000);
        Car c10 = new Car("Chevrolet", "Brown", "DOG12365", "ST890", "Gasoline", 200, 2019, 27000);

        c1.displayInfo();
        c2.displayInfo();
        c3.displayInfo();
        c4.displayInfo();
        c5.displayInfo();
        c6.displayInfo();
        c7.displayInfo();
        c8.displayInfo();
        c9.displayInfo();
        c10.displayInfo();
    }
}
