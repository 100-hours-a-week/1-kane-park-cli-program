// 음료 메뉴
class Drink {
    protected String name;
    protected int price;

    public Drink(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public void making() {
        System.out.println("예쁜 잔을 준비 중입니다...");
    }

    @Override
    public String toString() {
        return name + " - " + price;
    }
}

class Coffee extends Drink {
    public Coffee(String name, int price) {
        super(name, price);
    }

    public void making() {
        super.making();
        System.out.println("샷을 내리는 중입니다...");
    }
}

class Tea extends Drink {
    public Tea(String name, int price) {
        super(name, price);
    }

    public void making() {
        super.making();
        System.out.println("물을 끓이는 중입니다...");
    }
}

class Espresso extends Coffee {
    public Espresso(String name, int price) {
        super(name, price);
    }

    public void making() {
        super.making();
    }
}

class Americano extends Coffee {
    public Americano(String name, int price) {
        super(name, price);
    }

    public void making() {
        super.making();
        System.out.println("물을 추가하는 중입니다...");
    }
}

class Latte extends Coffee {
    public Latte(String name, int price) {
        super(name, price);
    }

    public void making() {
        super.making();
        System.out.println("우유를 추가하는 중입니다...");
    }
}

class HotTea extends Tea {
    public HotTea(String name, int price) {
        super(name, price);
    }

    public void making() {
        super.making();
        System.out.println("티백을 우려내는 중입니다...");
    }
}

class IceTea extends Tea {
    public IceTea(String name, int price) {
        super(name, price);
    }

    public void making() {
        super.making();
        System.out.println("얼음을 추가하는 중입니다...");
    }
}