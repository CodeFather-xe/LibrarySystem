

public abstract class Item {

    /*--------Attributes--------*/
    private int id;
    private String title;
    private int yearOfPublication;
    private final String specialization;
    private boolean isBorrowing;
//    private String typeItem;


    /*--------Constructors--------*/
    public Item(int id, String title, int yearOfPublication, String specialization) {
        this.id = id;
        this.title = title;
        this.yearOfPublication = yearOfPublication;
        this.specialization = specialization;
    }


    /*--------Setter and Getter--------*/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(int yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public String getSpecialization() {
        return specialization;
    }


    public static String setSpecialization() {
        System.out.println("Please Choose the Specialization:");
        System.out.println(
                """
                        1) Basic Sciences
                        2) Intelligence
                        3) Software
                        4) Networks""");
        System.out.print("--> ");
        int input = HelperClass.cin.nextInt();
        HelperClass.cin.nextLine(); // consume newline

        switch (input) {
            case 1 -> {
                return "Basic Sciences";
            }
            case 2 -> {
                return "Intelligence";
            }
            case 3 -> {
                return "Software";
            }
            case 4 -> {
                return "Networks";
            }
            default -> {
                System.err.println("Invalid input. Enter a valid specialization!!.");
                return setSpecialization(); // recursive retry
            }
        }
    }

    public boolean isBorrowing() {
        return isBorrowing;
    }

    public void setBorrowing(boolean borrowing) {
        isBorrowing = borrowing;
    }

    public abstract String getTypeItem();
    public void printItemDetails(Item item) {
        System.out.println("*".repeat(49));
        System.out.println("*\tType: " + item.getTypeItem());
        System.out.println("*\tID: " + item.getId());
        System.out.println("*\tTitle: " + item.getTitle());
        System.out.println("*\tYear of Publication: " + item.getYearOfPublication());
        System.out.println("*\tSpecialization: " + item.getSpecialization());
    }

}
