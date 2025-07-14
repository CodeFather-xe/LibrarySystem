package SystemPackage;

import ItemsPackage.*;
import MemberPackage.Members;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static SystemPackage.HelperClass.*;
import static SystemPackage.OutputClass.*;

public class Library {
    /*--------Attributes--------*/
    final int maxBorrowTime = 7;
    static final int maxCurrentBorrowingsNumber = 3;
    static final String admin = "Admin";
    static final int password = 2025;
    static List<Members> members = new ArrayList<>();
    public static List<Item> items = new ArrayList<>();

    /*-------------------------------- Methods ----------------------------------------*/

    public static void addMember() {
        boolean check = false;
        while (!check) {
            System.out.println("*".repeat(49));
            System.out.print("* Enter Member's Name: ");
            tempStringInput = cin.next();
            tempIntInput = (int) (Math.random() * ((500 - 1)) + 1);
            for (Members x : members) {
                if (tempStringInput.equals(x.getName())) {
                    System.err.println("The Member Is Already Exists!");
                    System.err.println("Try Another Name");
                    break;
                } else if (tempIntInput == x.getMembershipNumber()) {
                    tempIntInput = (int) (Math.random() * ((500 - 1)) + 1);
                    break;
                }
            }
            check = true;
            System.out.println(Color_PURPLE + "* a New Member Has Add!!" + Color_RESET + "\t".repeat(6) + "*");

            System.out.println("* MemberShip ID: " + Color_GREEN + tempIntInput + Color_RESET + "\t".repeat(7) + "*");
            System.out.println("* Name: " + Color_GREEN + tempStringInput + Color_RESET + "\t".repeat(7) + "*");
        }
        members.add(new Members(tempIntInput, tempStringInput));
    }

    public static void deleteMember() {
        System.out.println("Enter Membership ID: ");
        tempIntInput = cin.nextInt();
        for (Members x : members) {
            if (tempIntInput == x.getMembershipNumber()) {
                members.remove(x);
                break;
            }
        }
        System.out.print(Color_GREEN + "Member Deleted Successfully " + Color_RESET);
    }

    /*---------------- Joelle's Method ----------------*/

    /* ----------------Question -1- --------------------*/
    public static void displayAllBooks() throws InterruptedException {
        boolean found = false;
        System.out.println("All the books we have in the library:");
        for (Item item : items) {
            if (item instanceof Books) {
                found = true;
                //                System.out.println(item.getTitle());
                // Ahmed Change the output to print All Information About the book
                item.printItemDetails(item);
            }
            // if(found=false)
            if (!found) System.err.println("No books found in the library");

        }
        System.out.println("*".repeat(49));
        OutputClass.manageItems();
    }

    /* --------------Question -2- ----------------------*/
    public static void displayMembersWithBorrow() {
        if (members.isEmpty())
            System.out.println(Color_RED + "*\t\tSorry, No Members to Display\t\t*" + Color_RESET);
        for (Members member : members) {
            System.out.println("*".repeat(20));
            System.out.println("Name: " + member.getName());
            System.out.println("Membership Number: " + member.getMembershipNumber());
            System.out.println("Current borrowings: " + member.getCurrentBorrowings());
            if (member.borrowItems.isEmpty()) {
                System.out.println("No Items Currently Borrowed");
            } else {
                System.out.println("Borrowed Items Are:");
                for (BorrowItem borrowItem : member.borrowItems) {
                    Item item = borrowItem.item;
                    System.out.println(
                            "---->"
                                    + item.getTypeItem()
                                    + " | ID: "
                                    + item.getId()
                                    + " | Title: "
                                    + item.getTitle());
                    System.out.println("Borrowed On: " + borrowItem.getDateBorrow());
                    System.out.println("Due on: " + borrowItem.getDateReturn());
                }
            }
            System.out.println("*".repeat(20));
        }
    }

    /*------------------ Question -3- -----------------*/
    // Ahmed Just Add Some Comments To Joelle AddBook Method
    public static void addBook() {
        System.out.println("Fill in these Information's About The Book You Want to Add!");

        // Book ID
        System.out.println("Book ID: ");
        int id = cin.nextInt();

        // Book mame
        System.out.println("Book name:");
        String title = cin.next();

        // Year of publication
        System.out.println("Year of publication: ");
        int year = cin.nextInt();

        // Number Of Pages
        System.out.println("Page count: ");
        int pages = cin.nextInt();
        cin.nextLine(); // clear newline

        // Publisher Name
        System.out.println("Publisher: ");
        String publisher = cin.nextLine();

        // Author Name
        System.out.println("author:");
        String author = cin.next();

        // Type Of Specialization
        String specialization = Item.setSpecialization();

        // Create book and adding it
        // Joelle edited the book constructor and added another constructor in the item class to match
        Books newBook = new Books(id, title, year, author, specialization, pages, publisher);
        items.add(newBook);
        System.out.println("Book added successfully!");
    }

    public static void addProject() {
        System.out.println("Fill in these information's about the project you want to add!");

        // Project ID
        System.out.println("Project ID: ");
        int id = cin.nextInt();
        cin.nextLine();

        // Project name
        System.out.println("Project name: ");
        String name = cin.nextLine();

        // Year of publication
        System.out.println("Year of publication: ");
        int publish_year = cin.nextInt();
        cin.nextLine();

        // Ahmed Add Specialization Section
        // Project Specialization
        System.out.println("Type Of Specialization: ");
        String specialization = Projects.setSpecialization();
        cin.nextLine();

        // Work team members
        System.out.println("Enter Your Work Team Members.\n \uD83D\uDD3AType 'Done' When Finished:");
        ArrayList<String> team = new ArrayList<>();
        while (true) {
            System.out.print("-> ");
            String member = cin.nextLine();
            if (member.equalsIgnoreCase("done")) {
                break;
            }
            if (!member.isBlank()) {
                team.add(member);
            }
        }
        String year = Projects.setYear();
        // Create new project and add it
        // Ahmed Edit Project Constructor To Add specialization
        Projects newProject = new Projects(id, name, publish_year, specialization, team, year);
        items.add(newProject);

        System.out.println("Project Added Successfully!");
    }

    /*-----------------Question -4- ---------------*/
    public static void searchItem() {
        System.out.print(
                """
                        What Do You Want to Search by:
                        1) ID
                        2) Title
                        3) Specialization
                        """);
        System.out.print("--> ");
        int choice = cin.nextInt();
        cin.nextLine();
        switch (choice) {
            case 1 -> {
                System.out.print("Enter the ID: ");
                int id = cin.nextInt();
                boolean found = false;
                for (Item item : items) {
                    if (item.getId() == id) {
                        item.printItemDetails(item);
                        found = true;
                        break;
                    }
                }
                if (!found) System.err.println("Sorry! No item found with this ID.");
            }
            case 2 -> {
                System.out.print("Enter the Title: ");
                String title = cin.nextLine();
                boolean found = false;
                for (Item item : items) {
                    if (item.getTitle().equalsIgnoreCase(title)) {
                        item.printItemDetails(item);
                        found = true;
                    }
                }
                if (!found) System.err.println("Sorry! No item found with this title.");
            }
            case 3 -> {
                System.out.print("Sorry! Enter the Specialization: ");
                String specialization = cin.nextLine();
                boolean found = false;
                for (Item item : items) {
                    if (item.getSpecialization() != null
                            && item.getSpecialization().equalsIgnoreCase(specialization)) {
                        item.printItemDetails(item);
                        found = true;

                    }
                }
                if (!found) System.err.println("Sorry! No item found with this specialization.");
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
    public static void requestLoanItem() {
        System.out.println("* Please Enter Member's Name:");
        Members member = checkMember(cin.next(), members);
        if (member != null) {
            if (member.getCurrentBorrowings() < maxCurrentBorrowingsNumber) {
                System.out.print("Enter Item's ID: ");
                Item item = checkItem(cin.next(), items, "ID");
                if (item != null) {
                    if (!item.isBorrowing()) {
                        member.borrowItems.add(
                                new BorrowItem(LocalDate.now(), LocalDate.now().plusDays(7), item));
                        item.setBorrowing(true);
                        System.out.println("The Operation Was Successful.");
                        System.out.println(
                                "The Member has Until " + LocalDate.now().plusDays(7) + " to Return the Item.");

                    } else {
                        System.err.println("This Item is Already Borrowed by Another Member.");
                    }
                } else {
                    System.err.println("Item with the given ID not found.");
                }
                return;
            } else {
                System.err.println("The member already has 3 active loans.");
            }
        }
        System.err.println("Member not found in the system.");
    }

    /*------------ Question -6- ------------ */
    public static void returnItem() {
        System.out.println("Please Enter Member's Name:");
        Members member = checkMember(cin.next(), members);
        if (member != null) {
            System.out.print("Enter Item's ID: ");
            Item item = checkBorrowedItem(cin.nextInt(), member.borrowItems);
            if (item != null) {
                item.setBorrowing(false);
                System.out.println(
                        OutputClass.Color_GREEN
                                + "The Item Was Returned Successfully."
                                + Color_RESET);
            } else {
                System.out.println("Member didn't Borrowed this Item.");
            }
        } else {
            System.err.println("Member not found in the System.");
        }
    }

    /*------------ Question -7- ------------ */
    public static void showProjectByYear() {
        String year;
        System.out.println("Please Choose the Academic Year");
        System.out.println(
                """
                        1) Third Year
                        2) Fourth Year
                        3) Graduation""");
        System.out.print("-->");
        int input = cin.nextInt();
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
    public static void showAllMemberWithIntelligenceBook() {
        System.out.println("Members who borrowed Artificial Intelligence Books are:");
        for (Members member : members) {
            boolean hasAiBook = false;
            for (BorrowItem borrowItem : member.borrowItems) {
                if (borrowItem.item.getSpecialization().equals("Intelligence")
                        && borrowItem.item.isBorrowing()) {
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
    public static boolean hasOverdueItems( Members member) {
        for (BorrowItem b : member.borrowItems) {
            if (b.item.isBorrowing()) return true;
        }
        return false;
    }

    public static void printOverdueMembers() {
        for (Members member : members) {
            if (hasOverdueItems(member)) {
                System.out.println(" " + member.getName() + " has overdue items.");
            }
        }
    }

    /*----------------------*/

    /*------------ Question -10- ------------ */

    public static void printAllCurrentlyBorrowedBooks() {
        for (Members member : members) {
            for (BorrowItem borrowItem : member.borrowItems) {
                if (borrowItem.item.isBorrowing() && borrowItem.item instanceof Books) {
                    System.out.println(
                            "The Book " + borrowItem.item.getTitle() + " borrowed by " + member.getName());
                }
            }
        }
    }

    /*----------------------*/

    /*------------ Question -11- ------------ */
    public static void showAvailableProjectsByCategory() {
        System.out.print("Enter The Specialization Please: ");
        String specialization = cin.next();
        for (Item item : items) {
            if (item instanceof Projects && item.getSpecialization().equalsIgnoreCase(specialization)) {
                boolean isBorrowed = false;
                for (Members member : members)
                    if (member.hasBorrowedThisItem(item)) {
                        isBorrowed = true;
                        break;
                    }
                if (!isBorrowed) item.printItemDetails(item);
            }
        }
    }
    /*----------------------*/

    /*------------ Question -12- ------------ */
    //  public void membersWhoBorrowedBookInDateRange(String itemId, Date from, Date to) {
    //    for (Members member : members) {
    //      for (BorrowItem b : member.borrowItems) {
    //        if (b.item.getId().equals(itemId)) {
    //          Date lendDate = b.getLendDate();
    //          if (!lendDate.before(from) && !lendDate.after(to)) {
    //            System.out.println("" + member.getName());
    //            break;
    //          }
    //        }
    //      }
    //    }
    //  }

}
