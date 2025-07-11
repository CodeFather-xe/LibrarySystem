package MemberPackage;

import ItemsPackage.BorrowItem;
import ItemsPackage.Item;

import java.util.ArrayList;
import java.util.List;

public class Members {

    /*--------Attributes--------*/
    private String name;
    private final int membershipNumber;
    private int CurrentBorrowings = 0;
    public List<BorrowItem> borrowItems = new ArrayList<>();

    /*--------Constructors--------*/
    public Members(int membershipNumber, String name) {
        this.name = name;
        this.membershipNumber = membershipNumber;
    }

    /*--------Setter and Getter--------*/
    public int getMembershipNumber() {
        return membershipNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getCurrentBorrowings() {
        return CurrentBorrowings;
    }

    public void setCurrentBorrowings() {
        ++CurrentBorrowings;
    }

    public void getALlInformation() {
        System.out.println("*".repeat(20));
        System.out.println("Name: " + this.getName());
        System.out.println("Membership Number: " + this.getMembershipNumber());
        System.out.println("Current borrowings: " + this.getCurrentBorrowings());
        if (this.borrowItems.isEmpty()) {
            System.out.println("No Items Currently Borrowed");
        } else {
            System.out.println("Borrowed Items Are:");
            for (BorrowItem borrowItem : this.borrowItems) {
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

public boolean hasBorrowedThisItem(Item item) {
    for (BorrowItem i : this.borrowItems) if (i.item.equals(item)) return true;
    return false;
}
}
