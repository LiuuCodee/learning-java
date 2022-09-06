public class FamilyAccount {
    public static void main(String[] args) {
        boolean isFlag = true;
        String details = "收支\t账户金额\t收支金额\t说明\n";
        //初始金额
        int balance = 0;

        while (isFlag) {
            System.out.println("----------家庭收支记账软件----------");
            System.out.println("            1 收支明细");
            System.out.println("            2 登记收入");
            System.out.println("            3 登记支出");
            System.out.println("            4 退   出");
            System.out.println("            请选择（1-4）：");

            char selection = Utility.readMenuSelection();
            switch (selection) {
                case '1':
                    System.out.println("1. 收支明细");
                    System.out.println("--------------------当前收支明细记录--------------------");
                    System.out.println(details);
                    System.out.println("--------------------家庭收支记账软件--------------------");
                    break;
                case '2':
                    System.out.print("本次收入金额：");
                    int income = Utility.readNumber();
                    System.out.print("本次收入说明：");
                    String incomeInfo = Utility.readString();

                    //处理 balance
                    balance += income;
                    details += ("收入\t" + balance + "\t\t" + income + "\t\t" + incomeInfo + "\n");

                    System.out.println("--------------------登记完成--------------------\n");
                    break;
                case '3':
                    System.out.print("本次支出金额：");
                    int payout = Utility.readNumber();
                    System.out.print("本次支出说明：");
                    String payoutInfo = Utility.readString();

                    //处理 balance
                    if (balance >= payout) {
                        balance -= payout;
                        details += ("支出\t" + balance + "\t\t" + payout + "\t\t" + payoutInfo + "\n");
                    } else {
                        System.out.println("支出超出账户额度，支付失败");
                    }

                    System.out.println("--------------------登记完成--------------------\n");
                    break;
                case '4':
                    System.out.println("确认是否退出(Y/N):");
                    char isExit = Utility.readConfirmSelection();
                    if (isExit == 'Y') {
                        isFlag = false;
                    }
                    break;
            }
        }
    }
}