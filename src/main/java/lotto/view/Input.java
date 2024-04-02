package lotto.view;

import java.util.Scanner;

public class Input {

    private static final Scanner scanner = new Scanner(System.in);

    public static Long getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Long.parseLong(scanner.nextLine());
    }

    public static String getWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    public static int getBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }
}