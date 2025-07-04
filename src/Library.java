import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Library {
    /*--------Attributes--------*/
    final int maxBorrowTime = 7;
    final static int maxCurrentBorrowingsNumber = 3;
    static final String admin = "Admin";
    static final int password = 2025;
    static List<Members> members = new ArrayList<>();
    static List<Item> items = new ArrayList<>();

    /*-------------------------------- Methods ----------------------------------------*/

    /*---------------- Joelle's Method ----------------*/

    /* ----------------Question -1- --------------------*/
    static public void displayAllBooks() throws InterruptedException {
        boolean found = false;
        System.out.println("All the books we have in the library:");
        for (Item item : items) {
            if (item instanceof Books) {
                found = true;
//                System.out.println(item.getTitle());
                //Ahmed Change the output to print All Information About the book
                item.printItemDetails(item);
            }
            // if(found=false)
            if (!found)
                System.err.println("No books found in the library");
            System.out.println("*".repeat(49));
            OutputClass.manageItems();
        }
    }

    /* --------------Question -2- ----------------------*/
    static public void displayMembersWithBorrow() {
        if (members.isEmpty())
            System.out.println("sorry,no members to display");
        for (Members member : members) {
            System.out.println("---------------------");
            System.out.println("name:" + member.getName());
            System.out.println("membership number:" + member.getMembershipNumber());
            System.out.println("current borrowings:" + member.getCurrentBorrowings());
            if (member.borrowItems.isEmpty()) {
                System.out.println("no items currently borrowed");
            } else {
                System.out.println("borrowed items are:");
                for (BorrowItem borrowItem : member.borrowItems) {
                    Item item = borrowItem.item;
                    System.out.println("---->" + item.getTypeItem() + " | ID: " + item.getId() + " | title: " + item.getTitle());
                    System.out.println("borrowed on: " + borrowItem.getDateBorrow());
                    System.out.println("due on: " + borrowItem.getDateReturn());
                }
            }
            System.out.println("====================================\n");
        }
    }

    /*------------------ Question -3- -----------------*/
    //Ahmed Just Add Some Comments To Joelle AddBook Method
    static public void addBook() {
        System.out.println("Fill in these information's about the book you want to add!");

        // Book ID
        System.out.println("Book ID: ");
        int id = HelperClass.cin.nextInt();

        // Book mame
        System.out.println("Book name:");
        String title = HelperClass.cin.next();

        // Year of publication
        System.out.println("Year of publication: ");
        int year = HelperClass.cin.nextInt();

        // Number Of Pages
        System.out.println("Page count: ");
        int pages = HelperClass.cin.nextInt();
        HelperClass.cin.nextLine(); // clear newline

        // Publisher Name
        System.out.println("Publisher: ");
        String publisher = HelperClass.cin.nextLine();

        // Author Name
        System.out.println("author:");
        String author = HelperClass.cin.next();

        // Type Of Specialization
        String specialization = Item.setSpecialization();


        // Create book and adding it
        // Joelle edited the book constructor and added another constructor in the item class to match
        Books newBook = new Books(id, title, year, author, specialization, pages, publisher);
        items.add(newBook);
        System.out.println("Book added successfully!");
    }

    static public void addProject() {
        System.out.println("Fill in these information's about the project you want to add!");

        // Project ID
        System.out.println("Project ID: ");
        int id = HelperClass.cin.nextInt();
        HelperClass.cin.nextLine();

        // Project name
        System.out.println("Project name: ");
        String name = HelperClass.cin.nextLine();

        // Year of publication
        System.out.println("Year of publication: ");
        int publish_year = HelperClass.cin.nextInt();
        HelperClass.cin.nextLine();

        //Ahmed Add Specialization Section
        // Project Specialization
        System.out.println("Type Of Specialization: ");
        String specialization = Projects.setSpecialization();
        HelperClass.cin.nextLine();

        // Work team members
        System.out.println("Enter your work team members. Type 'done' when finished:");
        ArrayList<String> team = new ArrayList<>();
        while (true) {
            System.out.print("-> ");
            String member = HelperClass.cin.nextLine();
            if (member.equalsIgnoreCase("done")) {
                break;
            }
            if (!member.isBlank()) {
                team.add(member);
            }
        }

        String year = Projects.setYear();

        // Create new project and add it
        //Ahmed Edit Project Constructor To Add specialization
        Projects newProject = new Projects(id, name, publish_year, specialization, team, year);
        items.add(newProject);

        System.out.println("Project added successfully!");
    }


    /*-----------------Question -4- ---------------*/
    static public void searchItem() {
        System.out.println("""
                what do you want to Search by:
                1) ID
                2) Title
                3) Specialization
                """);
        System.out.print("--> ");
        int choice = HelperClass.cin.nextInt();
        HelperClass.cin.nextLine();

        switch (choice) {
            case 1 -> {
                System.out.print("Enter the ID: ");
                int id = HelperClass.cin.nextInt();
                boolean found = false;
                for (Item item : items) {
                    if (item.getId() == id) {
                        item.printItemDetails(item);
                        found = true;
                        break;
                    }
                }
                if (!found)
                    System.err.println("Sorry! No item found with this ID.");
            }
            case 2 -> {
                System.out.print("Enter the Title: ");
                String title = HelperClass.cin.nextLine();
                boolean found = false;
                for (Item item : items) {
                    if (item.getTitle().equalsIgnoreCase(title)) {
                        item.printItemDetails(item);
                        found = true;
                        break;
                    }
                }
                if (!found)
                    System.err.println("Sorry! No item found with this title.");
            }
            case 3 -> {
                System.out.print("Sorry! Enter the Specialization: ");
                String specialization = HelperClass.cin.nextLine();
                boolean found = false;
                for (Item item : items) {
                    if (item.getSpecialization() != null && item.getSpecialization().equalsIgnoreCase(specialization)) {
                        item.printItemDetails(item);
                        found = true;
                        break;
                    }
                }
                if (!found)
                    System.err.println("Sorry! No item found with this specialization.");
            }
            default -> {
                System.err.println("Sorry! Invalid choice.");
                searchItem();
            }
        }
    }

    /*----------------------*/


    /*---------------- Ahmed's Method ----------------*/

    /*------------ Question -5- ------------ */
    static public void requestLoanItem() {
        System.out.println("Please Enter Member's Name:");
        Members member = HelperClass.checkMember(HelperClass.cin.next(), members);
        if (member != null) {
            if (member.getCurrentBorrowings() < maxCurrentBorrowingsNumber) {
                System.out.print("Enter Item's ID: ");
                Item item = HelperClass.checkItem(HelperClass.cin.next(), items, "ID");
                if (item != null) {
                    if (!item.isBorrowing()) {
                        member.borrowItems.add(new BorrowItem(LocalDate.now(), LocalDate.now().plusDays(7), item));
                        item.setBorrowing(true);
                        System.out.println("The operation was successful.");
                        System.out.println("The member has until " + LocalDate.now().plusDays(7) + " to return the item.");

                    } else {
                        System.err.println("This item is already borrowed by another member.");
                    }
                    return;
                } else {
                    System.err.println("Item with the given ID not found.");
                }
            } else {
                System.err.println("The member already has 3 active loans.");
            }
        }
        System.err.println("Member not found in the system.");
    }


    /*------------ Question -6- ------------ */
    static public void returnItem() {
        System.out.println("Please Enter Member's Name:");
        Members member = HelperClass.checkMember(HelperClass.cin.next(), members);
        if (member != null) {
            System.out.print("Enter Item's ID: ");
            Item item = HelperClass.checkBorrowedItem(HelperClass.cin.nextInt(), member.borrowItems);
            if (item != null) {
                item.setBorrowing(false);
                System.out.println(OutputClass.Color_GREEN + "The Item Was Returned Successfully." + OutputClass.Color_RESET);
            } else {
                System.out.println("Member didn't Borrowed this Item.");
            }
        } else {
            System.err.println("Member not found in the system.");
        }
    }


    /*------------ Question -7- ------------ */
    static public void showProjectByYear() {
        String year;
        System.out.println("Please Choose the Academic Year");
        System.out.println(
                """
                        1) Third Year
                        2) Fourth Year
                        3) Graduation""");
        System.out.print("-->");
        int input = HelperClass.cin.nextInt();
        switch (input) {
            case 1:
                year = "Third Year";
                break;
            case 2:
                year = "Fourth Year";
                break;

            case 3:
                year = "Graduation";
                break;
            default:
                System.err.println("Error Input...Enter Correct Academic Year!!!");
                showProjectByYear();
                return;
        }
        for (Item item : items) {
            if (item instanceof Projects && ((Projects) item).getYear().equals(year)) {
                item.printItemDetails(item);
            }
        }
    }

    /*------------ Question -8- ------------ */
    static public void showAllMemberWithIntelligenceBook() {
        System.out.println("Members who borrowed artificial intelligence books are:");
        for (Members member : members) {
            boolean hasAiBook = false;
            for (BorrowItem borrowItem : member.borrowItems) {
                if (borrowItem.item.getSpecialization().equals("Intelligence") && borrowItem.item.isBorrowing()) {
                    hasAiBook = true;
                    break;
                }
            }
            if (hasAiBook) member.getALlInformation();
        }

    }


    /*----------------------*/


    /*---------------- Baraa's Method ----------------*/

    /*------------ Question -9- ------------ */
    static public boolean hasOverdueItems(Members member) {
        for (BorrowItem b : member.borrowItems) {
            if (b.item.isBorrowing()) return true;
        }
        return false;
    }

    static public void printOverdueMembers() {
        for (Members member : members) {
            if (hasOverdueItems(member)) {
                System.out.println(" " + member.getName() + " has overdue items.");
            }
        }
    }
    /*----------------------*/

}


