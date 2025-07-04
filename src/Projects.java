import java.util.List;

public class Projects extends Item {

    /*--------Attributes--------*/
    private final String year;
    List<String> work_team;


    /*--------Constructors--------*/
    public Projects(int id, String address, int yearOfPublication, String specialization, List<String> work_team, String year) {
        super(id, address, yearOfPublication, specialization);
        this.work_team = work_team;
        this.year = year;
    }

    /*--------Setter and Getter--------*/
    public String getYear() {
        return year;
    }

    public static String setYear() {
        // We Have three Academic Year
        /*
         * Third Year
         * Fourth Year
         * Graduation
         */
        System.out.println("Please Choose the Academic Year");
        System.out.println(
                """
                        1) Third Year
                        2) Fourth Year
                        3) Graduation""");
        System.out.print("-->");
        int input = HelperClass.cin.nextInt();
        HelperClass.cin.nextLine();
        switch (input) {
            case 1 -> {
                return "Third Year";
            }

            case 2 -> {
                return "Fourth Year";
            }


            case 3 -> {
                return "Graduation";
            }

            default -> {
                System.err.println("Error Input...Enter Correct Academic Year!!!");
                return setYear();
            }

        }
    }

    @Override
    public void printItemDetails(Item item) {
        super.printItemDetails(item);
        Projects projects = (Projects) item;
        System.out.println("----------------------------");
        System.out.println("Academic Year: " + projects.getYear());
        System.out.println("Work Team They:");
        for (String name : work_team) {
            System.out.println("-> " + name);
        }
        System.out.println("----------------------------");
    }

    @Override
    public String getTypeItem() {
        return "Projects";
    }
}
