import java.util.Scanner;

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


public class Main {
    public static void main(String[] args) {
        // 메뉴 표시
        Drink[] menu = {
                new Espresso("Kenya Espresso", 3000),
                new Americano("Kenya Americano", 3000),
                new Latte("Kenya Latte", 3500),
                new Espresso("Ethiopia Espresso", 3500),
                new Americano("Ethiopia Americano", 3500),
                new Latte("Ethiopia Latte", 4000),
                new HotTea("Hot Earl Grey", 3500),
                new IceTea("Ice Earl Grey", 4000),
                new HotTea("Hot Chamomile", 4000),
                new IceTea("Ice Chamomile", 4500)
        };

        System.out.println("========MENU========");
        for (int i = 0; i < menu.length; i++) {
            System.out.println((i + 1) + ". " + menu[i]);
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("원하는 메뉴 번호를 선택하세요: ");
        int choice = scanner.nextInt();
        System.out.println("====================");

        // 주문 받은 메뉴 표기
        if (choice > 0 && choice <= menu.length) {
            Drink selectedDrink = menu[choice - 1];
            int lastPrice = selectedDrink.price;

            // 샷 추가 여부 확인
            System.out.print("샷을 추가하시겠습니까? (1: 예, 2: 아니요): ");
            int shot = scanner.nextInt();
            if (shot == 1) {
                lastPrice += 500; // 가격 추가
            }
            System.out.println("====================\n");

            System.out.println("주문 받은 메뉴: " + selectedDrink.name);
            selectedDrink.making();
            if (shot == 1) {
                System.out.println("샷을 추가하는 중입니다...");
            }
            System.out.println("주문하신 메뉴가 준비되었습니다!");
            System.out.println("가격은 " + lastPrice + "원 입니다");
        } else {
            System.out.println("잘못된 선택입니다. 프로그램을 종료합니다.");
        }

        scanner.close();
    }
}
