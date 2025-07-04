package MemberPackage;

import ItemsPackage.BorrowItem;

import java.util.ArrayList;
import java.util.List;

public class Members {

    /*--------Attributes--------*/
    private String name;
    private int membershipNumber;
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

    public void setMembershipNumber(int membershipNumber) {
        this.membershipNumber = membershipNumber;
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
        System.out.println("---------------------");
        System.out.println("name:" + name);
        System.out.println("membership number:" + membershipNumber);
        System.out.println("current borrowings:" + CurrentBorrowings);
        System.out.println("---------------------");
    }
}
