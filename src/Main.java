import java.util.Scanner;

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
