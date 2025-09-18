public class Transportation {
    String name;
    String description;

    public Transportation(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void move() {
        System.out.println(name + ": " + description);
    }
}

class AirTransport extends Transportation {
    public AirTransport(String name, String description) {
        super(name, description);
    }
}

class LandTransport extends Transportation {
    public LandTransport(String name, String description) {
        super(name, description);
    }
}

class WaterTransport extends Transportation {
    public WaterTransport(String name, String description) {
        super(name, description);
    }
}

class Helicopter extends AirTransport {
    public Helicopter() {
        super("Helicopter", " flies in the air.");
    }
}

class Airplane extends AirTransport {
    public Airplane() {
        super("Airplane", "flies in the sky.");
    }
}

class SpaceShuttle extends AirTransport {
    public SpaceShuttle() {
        super("Space Shuttle", "travels into outer space!");
    }
}

class Truck extends LandTransport {
    public Truck() {
        super("Truck", "carries heavy goods on land.");
    }
}

class SUV extends LandTransport {
    public SUV() {
        super("SUV", "is a versatile land transport.");
    }
}

class Tricycle extends LandTransport {
    public Tricycle() {
        super("Tricycle", "is a three-wheeled land transport.");
    }
}

class Motorcycle extends LandTransport {
    public Motorcycle() {
        super("Motorcycle", "is a two-wheeled land transport.");
    }
}

class Kariton extends LandTransport {
    public Kariton() {
        super("Kariton", "is pushed or pulled manually on land.");
    }
}

class Boat extends WaterTransport {
    public Boat() {
        super("Boat", "sails across rivers or seas.");
    }
}

class Submarine extends WaterTransport {
    public Submarine() {
        super("Submarine", "travels underwater.");
    }
}