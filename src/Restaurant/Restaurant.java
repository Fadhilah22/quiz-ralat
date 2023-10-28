import java.util.ArrayList;
import java.util.Scanner;

public class Restaurant {
    public ArrayList<RegularMenu> regularMenuArray;
    public ArrayList<SpecialMenu> specialMenuArray;
    public Scanner scan;

    public Restaurant(){
        this.regularMenuArray = new ArrayList<RegularMenu>();
        this.specialMenuArray = new ArrayList<SpecialMenu>();
        this.scan = new Scanner(System.in);
    }

    public void addRegularMenu(String name, String code, int price){
        RegularMenu newMenu = new RegularMenu(name, code, price);
        regularMenuArray.add(newMenu);
    }

    public void addSpecialMenu(String name, String code, int price, int discount){
        SpecialMenu newMenu = new SpecialMenu(name, code, price, discount);
        specialMenuArray.add(newMenu);
    }

    public void optionAddRegularMenu(){
        String inputCode = new String();
        String inputName = new String();
        int inputPrice = 0;
        boolean notValid = true;

        // get code
        scan.nextLine();
        while(notValid){
            System.out.printf("Enter Menu Code [Rxxx] ");
            inputCode = scan.nextLine();
            if(inputCode.toCharArray()[0] == 'R'){
                if(inputCode.length() == 4){
                    int found = 0;
                    for(int i = 1; i<inputCode.length(); i++){
                        if(inputCode.toCharArray()[i] >= '0' && inputCode.toCharArray()[i] >= '9'){
                            found+=1;
                        }
                    }
                    for(RegularMenu menu : regularMenuArray){
                        if(menu.code.equals(inputCode)) {
                            System.out.println("Code already Exist");
                        }
                    }
                    if (found == 0) {
                        notValid = false;
                    }
                } else {
                    System.out.println("Code size exceeds maximum length (4)");
                }
            } else {
                System.out.println("Code doesnt start with valid character ('R')");
            }
        }

        notValid = true;

        // get name
        while(notValid){
            System.out.print("Enter Menu Name [5-20] ");
            // scan.nextLine();
            inputName = scan.nextLine();
            if(inputName.length() >= 5 && inputName.length() <= 20){
                notValid = false;
            }
        }

        notValid = true;

        // get price
        while(notValid){
            System.out.print("Enter Menu Price [5000 - 10000] ");
            // scan.nextLine();
            try{
                inputPrice = scan.nextInt();
            } catch (Exception e) {
                System.out.println("Must be numbers");
                scan.next();
            }
            if(inputPrice >= 5000 && inputPrice <= 100000){
                notValid = false;
            }
        }

        addRegularMenu(inputCode, inputName, inputPrice);
        System.out.println("Add Success!");
    }

    public void optionAddSpecialMenu(){
        String inputCode = new String();
        String inputName = new String();
        int inputPrice = 0;
        int inputDiscount = 0;
        boolean notValid = true;

        // get code
        scan.nextLine();
        while(notValid){
            System.out.printf("Enter Menu Code [Sxxx] ");
            inputCode = scan.nextLine();
            if(inputCode.toCharArray()[0] == 'S'){
                if(inputCode.length() == 4){
                    int found = 0;
                    for(int i = 1; i<inputCode.length(); i++){
                        if(inputCode.toCharArray()[i] >= '0' && inputCode.toCharArray()[i] >= '9'){
                            found+=1;
                        }
                    }
                    for(SpecialMenu menu : specialMenuArray){
                        if(menu.code.equals(inputCode)) {
                            System.out.println("Code already Exist");
                            found += 1;
                        }
                    }
                    if (found == 0) {
                        notValid = false;
                    }
                } else {
                    System.out.println("Code size exceeds maximum length (4)");
                }
            } else {
                System.out.println("Code doesnt start with valid character ('S')");
            }
        }

        notValid = true;

        // get name
        while(notValid){
            System.out.print("Enter Menu Name [5-20] ");
            // scan.nextLine();
            inputName = scan.nextLine();
            if(inputName.length() > 5 && inputName.length() < 20){
                notValid = false;
            }
        }

        notValid = true;

        // get price
        while(notValid){
            System.out.print("Enter Menu Price [5000 - 10000] ");
            // scan.nextLine();
            try{
                inputPrice = scan.nextInt();
            } catch (Exception e) {
                System.out.println("Must be numbers");
                scan.next();
            }
            if(inputPrice >= 5000 && inputPrice <= 100000){
                notValid = false;
            }
        }

        notValid = true;

        // get inputDiscount
        while(notValid){
            System.out.print("Enter Menu Discount [10 | 25 | 50] ");
            inputDiscount = scan.nextInt();
            if(inputDiscount == 10 || inputDiscount == 25 || inputDiscount == 50){
                notValid = false;
            } else {
                System.out.println("Discount invalid");
            }
        }

        addSpecialMenu(inputCode, inputName, inputPrice, inputDiscount);
        System.out.println("Add Success!");
    }

    public void removeRegular(String code){
        final String finalCode = code;
        regularMenuArray.removeIf(obj -> obj.code.equals(finalCode));
        System.out.println("Menu removed");
    }

    public void deleteRegularMenu(){
        if(regularMenuArray.size() == 0){
            System.out.println("Menu is empty");
            return;
        }
        String inputCode = new String();
        boolean notValid = true;
        // get code
        scan.nextLine();
        while(notValid){
            System.out.printf("Enter Menu Code [Rxxx] ");
            inputCode = scan.nextLine();
            if(inputCode.toCharArray()[0] == 'R'){
                if(inputCode.length() == 4){
                    int found = 0;
                    for(int i = 1; i<inputCode.length(); i++){
                        if(inputCode.toCharArray()[i] >= '0' && inputCode.toCharArray()[i] >= '9'){
                            found+=1;
                        }
                    }
                    if (found == 0) {

                        int find = 0;
                        for(RegularMenu menu : regularMenuArray){
                            if(menu.code.equals(inputCode)) {
                                System.out.println("Menu Founded");
                                find+=1;
                                break;
                            }
                        }
                        if (find > 0) {
                            removeRegular(inputCode);
                            notValid = false;
                        }

                    }
                } else {
                    System.out.println("Code size exceeds maximum length (4)");
                }
            } else {
                System.out.println("Code doesnt start with valid character ('R')");
            }
        }
    }

    public void removeSpecial(String code){
        final String finalCode = code;
        specialMenuArray.removeIf(obj -> obj.code.equals(finalCode));
        System.out.println("Menu removed");
    }

    public void deleteSpecialMenu(){
        if(specialMenuArray.size() == 0){
            System.out.println("Menu is empty");
            return;
        }
        String inputCode = new String();
        boolean notValid = true;
        // get code
        scan.nextLine();
        while(notValid){
            System.out.printf("Enter Menu Code [Sxxx] ");
            inputCode = scan.nextLine();
            if(inputCode.toCharArray()[0] == 'S'){
                if(inputCode.length() == 4){
                    int found = 0;
                    for(int i = 1; i<inputCode.length(); i++){
                        if(inputCode.toCharArray()[i] >= '0' && inputCode.toCharArray()[i] >= '9'){
                            found+=1;
                        }
                    }
                    if (found == 0) {

                        int find = 0;
                        for(SpecialMenu menu : specialMenuArray){
                            if(menu.code.equals(inputCode)) {
                                System.out.println("Menu Founded");
                                find+=1;
                                break;
                            }
                        }
                        if (find > 0) {
                            removeSpecial(inputCode);
                            notValid = false;
                        }

                    }
                } else {
                    System.out.println("Code size exceeds maximum length (4)");
                }
            } else {
                System.out.println("Code doesnt start with valid character ('S')");
            }
        }
    }


    public void showMenu(){
        // prints regular menus
        System.out.println("==========[ Regular Menu ]==========");
        System.out.printf("%-5s%-2c%-10s%-2c%-15s%-2c%-10s\n",
                            "No", '|',
                            "Menu Code", '|',
                            "Menu Name", '|',
                            "Menu Price"
                        );
        for(int i = 0; i < regularMenuArray.size(); i++){
            if(regularMenuArray == null){
                System.out.println("Menu is empty");
                break;
            }
            System.out.printf("%-5d%-2c%-10s%-2c%-15s%-2c%d %c\n",
                                i+1, '|',
                                regularMenuArray.get(i).code, '|',
                                regularMenuArray.get(i).name, '|',
                                regularMenuArray.get(i).price, '%'
                            );
        }
        System.out.println();
        // prints special menus
        System.out.println("==========[ Special Menu ]==========");
        System.out.printf("%-5s%-2c%-10s%-2c%-15s%-2c%-13s%-2c%-10s\n",
                            "No", '|',
                            "Menu Code", '|',
                            "Menu Name", '|',
                            "Menu Price", '|',
                            "Menu Discount"
                        );
        for(int i = 0; i < specialMenuArray.size(); i++){
            if(regularMenuArray == null){
                System.out.println("Menu is empty");
                break;
            }
            System.out.printf("%-5d%-2c%-10s%-2c%-15s%-2c%-13d%-2c%d %c\n",
                                i+1, '|',
                                specialMenuArray.get(i).code, '|',
                                specialMenuArray.get(i).name, '|',
                                specialMenuArray.get(i).price, '|',
                                specialMenuArray.get(i).discount, '%'
                            );
        }
    }

    public void printMainMenu(){
        System.out.println("Family Restaurant");
        System.out.println("1. Add Regular Menu");
        System.out.println("2. Add Special Menu");
        System.out.println("3. Show Menu");
        System.out.println("4. Delete Regular Menu");
        System.out.println("5. Delete Special Menu");
        System.out.println("0. Exit");
        System.out.print("Enter option >> ");
    }

    // main program
    public void current(){
        int option;
        boolean isRunning = true;
        while(isRunning){
            printMainMenu();
            option = scan.nextInt();

            if(option == 1){
                optionAddRegularMenu();
            } else if (option == 2){
                optionAddSpecialMenu();
            } else if (option == 3) {
                showMenu();
            } else if (option == 4) {
                deleteRegularMenu();
            } else if (option == 5) {
                deleteSpecialMenu();
            } else if (option == 0) {
                System.exit(0);
            } else {
                System.out.println("Enter valid option!");
            }
        }
    }

    public static void main(String[] args) {
        Restaurant run = new Restaurant();
        run.current();
    }
}
