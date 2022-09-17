package com.abc.project2.ui;

import com.abc.project2.bean.Customer;
import com.abc.project2.service.CustomerList;
import com.abc.project2.util.CMUtility;

/**
 * @ClassName CustomerView
 * @Description 负责菜单的显示和处理用户操作
 **/
public class CustomerView {
    private CustomerList customerList = new CustomerList(10);

    public CustomerView() {
        Customer customer = new Customer("张安", '男', 18,
                "18618661298", "test@google.com");
        customerList.addCustomer(customer);
    }

    /**
     * @Description 显示《客户管理软件》主菜单
     */
    public void enterMainMenu() {
        boolean flag = true;
        while (flag) {
            System.out.println("---------------客户信息管理软件---------------");
            System.out.println("                1 添加客户");
            System.out.println("                2 修改客户");
            System.out.println("                3 删除客户");
            System.out.println("                4 客户列表");
            System.out.println("                5 退   出");
            System.out.print("     请选择(1-5)：");

            char menu = CMUtility.readMenuSelection();
            switch (menu) {
                case '1' -> addNewCustomer();
                case '2' -> modifyCustomer();
                case '3' -> deleteCustomer();
                case '4' -> listAllCustomers();
                case '5' -> {
                    System.out.println("确认是否退出(Y/N)？");
                    char isExit = CMUtility.readConfirmSelection();
                    if (isExit == 'Y') {
                        flag = false;
                    }
                }
            }
        }
    }

    /**
     * @Description 添加客户
     */
    private void addNewCustomer() {
        System.out.println("---------------添加客户---------------");
        System.out.print("姓名：");
        String name = CMUtility.readString(10);

        System.out.print("性别：");
        char gender = CMUtility.readChar();

        System.out.print("年龄：");
        int age = CMUtility.readInt();

        System.out.print("手机号：");
        String phone = CMUtility.readString(13);

        System.out.print("邮箱地址：");
        String email = CMUtility.readString(30);

        //创建对象，将上述信息填充到对象中
        Customer customer = new Customer(name, gender, age, phone, email);
        //添加到数组中
        boolean result = customerList.addCustomer(customer);
        if (result) {
            System.out.println("---------------添加完成---------------");
        } else {
            System.out.println("--------客户数量已满，无法继续添加-------");
        }

    }

    /**
     * @Description 修改客户
     */
    private void modifyCustomer() {
        System.out.println("---------------修改客户---------------");
        Customer customer;
        int number;

        for (; ; ) {
            System.out.print("请选择客户编号(-1退出)：");
            number = CMUtility.readInt();

            if (number == -1) {
                return;
            }

            customer = customerList.getCustomer(number - 1);
            if (customer == null) {
                System.out.println("无法找到指定客户！");
            } else {//找到相应客户，跳出循环，在下面的循环中修改客户信息
                break;
            }

        }

        //修改客户信息
        System.out.print("姓名(" + customer.getName() + ")：");
        String name = CMUtility.readString(10, customer.getName());

        System.out.print("性别(" + customer.getGender() + ")：");
        char gender = CMUtility.readChar(customer.getGender());

        System.out.print("年龄(" + customer.getAge() + ")：");
        int age = CMUtility.readInt(customer.getAge());

        System.out.print("手机号(" + customer.getPhone() + ")：");
        String phone = CMUtility.readString(13, customer.getPhone());

        System.out.print("邮箱(" + customer.getEmail() + ")：");
        String email = CMUtility.readString(30, customer.getEmail());

        Customer newCustomer = new Customer(name, gender, age, phone, email);
        boolean isReplaced = customerList.replaceCustomer(number - 1, newCustomer);
        if (isReplaced) {
            System.out.println("---------------修改成功---------------");
        } else {
            System.out.println("---------------修改失败---------------");
        }
    }

    /**
     * @Description 删除客户
     */
    private void deleteCustomer() {
        System.out.println("---------------删除客户---------------");
        int number;

        for (; ; ) {
            System.out.print("请选择待删除客户编号(-1退出)：");
            number = CMUtility.readInt();
            if (number == -1) {
                return;
            }
            Customer customer = customerList.getCustomer(number - 1);
            if (customer == null) {
                System.out.println("无法找到指定客户");
            } else {
                break;
            }
        }

        System.out.print("确认是否删除客户(Y/N)：");
        char isDelete = CMUtility.readConfirmSelection();
        if (isDelete == 'Y') {
            boolean result = customerList.deleteCustomer(number - 1);
            if (result) {
                System.out.println("--------------删除成功--------------");
            } else {
                System.out.println("--------------删除失败--------------");
            }
        } else {
            return;
        }
    }

    private void listAllCustomers() {
        System.out.println("---------------客户列表---------------");
        int total = customerList.getTotal();
        if (total == 0) {
            System.out.println("目前没有客户信息！");
        } else {
            System.out.println("编号\t\t姓名\t\t性别\t\t年龄\t\t电话\t\t\t邮箱");
            Customer[] custs = customerList.getAllCustomers();
            for (int i = 0; i < total; i++) {
                System.out.println((i + 1) + "\t\t" + custs[i].getName() + "\t\t" + custs[i].getGender() + "\t\t"
                        + custs[i].getAge() + "\t\t" + custs[i].getPhone() + "\t" + custs[i].getEmail());
            }
        }
        System.out.println("---------------打印结束---------------");
    }

    public static void main(String[] args) {
        CustomerView view = new CustomerView();
        view.enterMainMenu();
    }
}
