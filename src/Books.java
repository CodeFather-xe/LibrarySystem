public class Books extends Item {

    /*--------Attributes--------*/
    private String author;
    private int numberOfPages;
    private String publishingHouse;


    /*--------Constructors--------*/
    public Books(int id, String title, int year_of_publication, String author, String specialization, int numberOfPages, String publishingHouse) {
        super(id, title, year_of_publication, specialization);
        this.author = author;
        this.numberOfPages = numberOfPages;
        this.publishingHouse = publishingHouse;
    }


    /*--------Setter and Getter--------*/

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    @Override
    public void printItemDetails(Item item) {
        super.printItemDetails(item);
        Books book = (Books) item;
        System.out.println("*\tAuthor Name: " + book.getAuthor());
        System.out.println("*\tPublisher House: " + book.getPublishingHouse());
        System.out.println("*\tNumber Of Pages: " + book.getNumberOfPages());
        System.out.println("*".repeat(49));
    }

    @Override
    public String getTypeItem() {
        return "Book";
    }
}
