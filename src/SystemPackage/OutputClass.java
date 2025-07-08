package SystemPackage;

public class OutputClass {


    /*--------COLORS--------*/
    public static final String Color_RESET = "\u001B[0m";
    public static final String Color_BLACK = "\u001B[30m";
    public static final String Color_RED = "\u001B[31m";
    public static final String Color_GREEN = "\u001B[32m";
    public static final String Color_YELLOW = "\u001B[33m";
    public static final String Color_BLUE = "\u001B[34m";
    public static final String Color_PURPLE = "\u001B[35m";
    public static final String Color_CYAN = "\u001B[36m";
    public static final String Color_WHITE = "\u001B[37m";

    /*--------Methods--------*/
    public static void printLogin() throws InterruptedException {
        /* -------- Title Of SystemPackage.Library -------- */
        System.out.println("*".repeat(49));
        System.out.println("* " + "\t".repeat(12) + "*");
        System.out.println("* " + "\t".repeat(5) + "Library" + "\t".repeat(6) + "*");
        System.out.println("* " + "\t".repeat(12) + "*");
        System.out.println("*".repeat(49));

        /* -------- Confirm Authentication -------- */
        System.out.println(Color_YELLOW + "*\t\t⚠️ Please Confirm Authentication ⚠️\t\t*" + Color_RESET);
        System.out.println("*".repeat(49));
        System.out.print("* Enter The Username: ");
        HelperClass.tempStringInput = HelperClass.cin.next();
        System.out.print("* Enter The Password: ");
        HelperClass.tempIntInput = HelperClass.cin.nextInt();

        /* -------- Check Authentication -------- */
        if (confirmAuthentication(HelperClass.tempStringInput, HelperClass.tempIntInput)) {
            System.out.println("*".repeat(49));
            System.out.println(Color_GREEN + "*" + "\t".repeat(3) + "Welcome Back To The System" + "\t".repeat(3) + "*" + Color_RESET);
            printLoading();

        } else {
            System.out.println("*".repeat(49));
            System.err.println("*" + "\t".repeat(3) + "Error username or Password\t\t\t*");
            Thread.sleep(1000);
            printLogin();
        }

    }

    public static boolean confirmAuthentication(String username, int pass) {
        return Library.admin.equals(username) && Library.password == pass;
    }

    public static void printLoading() throws InterruptedException {
        System.out.println("*".repeat(49));
        System.out.println(Color_BLUE + "*" + "\t".repeat(4) + "Loading The System" + "\t".repeat(4) + "*" + Color_RESET);

        Thread.sleep(700);

        System.out.println("* %27" + ".".repeat(10) + "\t".repeat(9) + "*");
        Thread.sleep(700);

        System.out.println("* %64" + ".".repeat(25) + "\t".repeat(5) + "*");

        Thread.sleep(700);

        System.out.println("* %99" + ".".repeat(41) + "\t*");

        Thread.sleep(2000);


        System.out.println(Color_GREEN + "*" + "\t".repeat(3) + "System Loaded Successfully" + "\t".repeat(3) + "*" + Color_RESET);
        System.out.println("*".repeat(49));
        Thread.sleep(500);
        printMainOperation();

    }

    public static void printMainOperation() throws InterruptedException {
        System.out.println("* Please Select The Operations Section:" + "\t".repeat(3) + "*");
        System.out.println("*  1) Manage Members." + "\t".repeat(7) + "*");
        System.out.println("*  2) Manage Items." + "\t".repeat(8) + "*");
        System.out.println("*  3) Loan and Return." + "\t".repeat(7) + "*");
        System.out.println("*  0) Exit" + "\t".repeat(10) + "*");

        Thread.sleep(500);
        System.out.print(Color_YELLOW + "*  Enter -->  " + Color_RESET);
        HelperClass.tempIntInput = HelperClass.cin.nextInt();
        Thread.sleep(1000);
        System.out.println("*".repeat(49));

        switch (HelperClass.tempIntInput) {
            case 1:
                manageMembers();
                break;
            case 2:
                manageItems();
                break;
            case 3:
                loanAndReturn();
                break;
            case 0:
                System.out.println("*".repeat(49));
                System.out.println(Color_YELLOW + "*\t\t  ⚠️ System is Shutting Down ⚠️\t\t\t*");
                System.out.println("* " + "\t".repeat(12) + "*");
                System.out.println("* " + "\t".repeat(12) + "*" + Color_RESET);
                Thread.sleep(1500);
                System.err.println("*".repeat(18) + " System End! " + "*".repeat(18));
                return;
            default:
                System.err.println("*\t\tInvalid input, Enter valid Section\t\t*");
                Thread.sleep(500);
                System.out.println("*".repeat(49));
                printMainOperation();
                break;
        }
    }

    public static void manageMembers() throws InterruptedException {
        System.out.println("*".repeat(15)
                + Color_PURPLE + " Manage The Members " + Color_RESET
                + "*".repeat(14));
        System.out.println("* Please Select The Operations :" + "\t".repeat(4) + "*");
        System.out.println("*  1) Add New Member" + "\t".repeat(7) + "*");
        System.out.println("*  2) Delete a Member" + "\t".repeat(7) + "*");
        System.out.println("*  3) Show All Members in System" + "\t".repeat(4) + "*");
        System.out.println("*  4) Show Members who Borrowed Artificial\t\t*\n" +
                "\t  intelligence Books" + "\t".repeat(6) + "*");
        System.out.println("*  5) Show Members who Late To Return Item \t\t*");
        System.out.println("*  6) Show Members who Borrow Specific Book\t\t*\n" +
                "\t  During Specific Date" + "\t".repeat(6) + "*");
        System.out.println("*  0) Go Back" + "\t".repeat(9) + "*");
        Thread.sleep(500);
        System.out.print(Color_YELLOW + "*  Enter -->  " + Color_RESET);
        HelperClass.tempIntInput = HelperClass.cin.nextInt();
        Thread.sleep(1000);
        System.out.println("*".repeat(49));

        switch (HelperClass.tempIntInput) {
            case 1:
                //TODO: AddMember()
                break;
            case 2:
                //TODO: DeleteMember()
                break;
            case 3:
                Library.displayMembersWithBorrow();
                break;
            case 0:
                printMainOperation();
                break;
            default:
                System.err.println("*\t  Invalid input, Enter valid Operation  \t*");
                Thread.sleep(500);
                System.out.println("*".repeat(49));
                manageMembers();
                break;
        }
    }

    public static void manageItems() throws InterruptedException {
        System.out.println("*".repeat(15)
                + Color_PURPLE + " Manage The Items " + Color_RESET
                + "*".repeat(16));
        System.out.println("* Please Select The Operations :" + "\t".repeat(4) + "*");
        System.out.println("*  1) Add New Book." + "\t".repeat(8) + "*");
        System.out.println("*  2) Add New Project." + "\t".repeat(7) + "*");
        System.out.println("*  3) Search for Item." + "\t".repeat(7) + "*");
        System.out.println("*  4) Show Project with specific Academic Year.\t*");
        System.out.println("*  5) Show All Books." + "\t".repeat(6) + "*");
        System.out.println("*  6) Show All Borrowed Books." + "\t".repeat(5) + "*");
        System.out.println("*  7) Show All Available Projects within"
                + "\t".repeat(2)
                + "*" + "\n*\t  a Specific Specialization"
                + "\t".repeat(5) + "*");
        System.out.println("*  0) Go Back." + "\t".repeat(9) + "*");

        Thread.sleep(500);
        System.out.print(Color_YELLOW + "*  Enter -->  " + Color_RESET);
        HelperClass.tempIntInput = HelperClass.cin.nextInt();
        System.out.println("*".repeat(49));
        Thread.sleep(500);
        switch (HelperClass.tempIntInput) {
            case 1:
                Library.addBook();
                break;
            case 2:
                Library.addProject();
                break;
            case 3:
                Library.searchItem();
                break;
            case 4:
                Library.showProjectByYear();
                break;
            case 5:
                Library.displayAllBooks();
                break;
            case 6:
//Show All Borrowed Books
                break;
            case 7:
                //Todo View All available Projects within Specific Specialization
                break;

            case 0:
                printMainOperation();
                break;
            default:
                System.err.println("*\t  Invalid input, Enter valid Operation  \t*");
                Thread.sleep(500);
                System.out.println("*".repeat(49));
                manageItems();
                break;
        }
        System.out.println("*".repeat(49));
    }

    public static void loanAndReturn() throws InterruptedException {
        System.out.println("*".repeat(13)
                + Color_PURPLE + " Loan And Return Items " + Color_RESET
                + "*".repeat(13));
        System.out.println("* Please Select The Operations :" + "\t".repeat(4) + "*");
        System.out.println("*  1) Loan an Item" + "\t".repeat(8) + "*");
        System.out.println("*  2) Return an Item" + "\t".repeat(7) + "*");
        System.out.println("*  0) Go Back" + "\t".repeat(9) + "*");
        Thread.sleep(500);
        System.out.print(Color_YELLOW + "*  Enter -->  " + Color_RESET);
        HelperClass.tempIntInput = HelperClass.cin.nextInt();
        Thread.sleep(1000);
        System.out.println("*".repeat(49));
        switch (HelperClass.tempIntInput) {
            case 1:
                Library.requestLoanItem();
                loanAndReturn();
                break;
            case 2:
                Library.returnItem();
                loanAndReturn();
                break;
            case 0:
                printMainOperation();
                break;
            default:
                System.err.println("*\t  Invalid input, Enter valid Operation  \t*");
                Thread.sleep(500);
                System.out.println("*".repeat(49));
                loanAndReturn();
                break;
        }
    }
}

