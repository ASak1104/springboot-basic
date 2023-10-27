package team.marco.vouchermanagementsystem.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import team.marco.vouchermanagementsystem.model.Voucher;
import team.marco.vouchermanagementsystem.service.VoucherService;
import team.marco.vouchermanagementsystem.util.Console;

@Controller
public class ConsoleVoucherController {
    private static final String INFO_DELIMINATOR = "\n";

    private final VoucherService voucherService;

    public ConsoleVoucherController(VoucherService voucherService) {
        this.voucherService = voucherService;
    }

    public void selectVoucher() {
        Console.print("""
                0: 고정 금액 할인 쿠폰
                1: % 할인 쿠폰""");

        int selected = Console.readInt();

        switch (selected) {
            case 0 -> createFixedAmountVoucher();
            case 1 -> createPercentDiscountVoucher();
            default -> throw new IllegalArgumentException("올바르지 않은 입력입니다.");
        }
    }

    public void voucherList() {
        List<String> vouchers = voucherService.getVouchersInfo()
                .stream()
                .map(Voucher::getInfo)
                .toList();
        String joinedString = String.join(INFO_DELIMINATOR, vouchers);

        if (!joinedString.isBlank()) {
            Console.print(joinedString);
        }

        Console.print("조회가 완료되었습니다.");
    }

    private void createPercentDiscountVoucher() {
        Console.print("할인율을 입력해 주세요.");

        int percent = Console.readInt();

        voucherService.createPercentDiscountVoucher(percent);
    }

    private void createFixedAmountVoucher() {
        Console.print("할인 금액을 입력해 주세요.");

        int amount = Console.readInt();

        voucherService.createFixedAmountVoucher(amount);
    }
}
