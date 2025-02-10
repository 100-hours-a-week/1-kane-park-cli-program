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
        return name + " - " + price + "원";
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
        Scanner scanner = new Scanner(System.in);

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

        boolean ordering = true;
        int totalPrice = 0;

        while (ordering) {
            System.out.println("========MENU========");
            for (int i = 0; i < menu.length; i++) {
                System.out.println((i + 1) + ". " + menu[i]);
            }
            System.out.print("원하는 메뉴 번호를 선택하세요: ");

            int choice;
            while (true) {
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                    if (choice > 0 && choice <= menu.length) break;
                    else System.out.println("올바른 번호를 입력하세요.");
                } catch (NumberFormatException e) {
                    System.out.println("숫자를 입력하세요.");
                }
            }

            Drink selectedDrink = menu[choice - 1];
            int resultPrice = selectedDrink.price;

            // 샷 추가 여부 확인
            System.out.print("샷을 추가하시겠습니까? (1: 예, 2: 아니요): ");
            int shot = Integer.parseInt(scanner.nextLine());
            if (shot == 1) resultPrice += 500;

            totalPrice += resultPrice;

            // 음료 제작을 별도 스레드에서 실행
            Thread makingThread = new Thread(() -> {
                System.out.println("\n====================");
                System.out.println("[주문 처리 중...]");
                System.out.println("주문 받은 메뉴: " + selectedDrink.name);
                selectedDrink.making();
                if (shot == 1) {
                    System.out.println("샷을 추가하는 중입니다...");
                }
                System.out.println("주문하신 메뉴가 준비되었습니다!");
                System.out.println("====================");
            });
            makingThread.start();

            // 추가 주문 여부 확인
            System.out.print("추가 주문을 하시겠습니까? (1: 예, 2: 아니요): ");
            int moreOrder = Integer.parseInt(scanner.nextLine());
            if (moreOrder != 1) {
                ordering = false;
            }

            try {
                makingThread.join(); // 음료 제작이 완료될 때까지 대기
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("총 주문 금액: " + totalPrice + "원");
        System.out.println("주문이 완료되었습니다.");
        scanner.close();
    }
}
