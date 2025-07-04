import ItemsPackage.Books;
import SystemPackage.Library;
import SystemPackage.OutputClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {


    public static void main(String[] args) throws InterruptedException {

        start();
    }

    public static void start(){
        Library library = new Library();
        List<Books> sampleBooks = new ArrayList<>();
        sampleBooks.add(new Books(1, "Introduction to Algorithms", 2009, "Thomas H. Cormen", "Software", 1312, "MIT Press"));
        sampleBooks.add(new Books(2, "Artificial Intelligence: A Modern Approach", 2010, "Stuart Russell", "Intelligence", 1152, "Pearson"));
        sampleBooks.add(new Books(3, "Computer Networks", 2013, "Andrew S. Tanenbaum", "Networks", 960, "Pearson"));
        sampleBooks.add(new Books(4, "Modern Physics", 2005, "Kenneth S. Krane", "Basic Sciences", 784, "Wiley"));
        sampleBooks.add(new Books(5, "Deep Learning", 2016, "Ian Goodfellow", "Intelligence", 775, "MIT Press"));
        sampleBooks.add(new Books(6, "Clean Code", 2008, "Robert C. Martin", "Software", 464, "Prentice Hall"));
        sampleBooks.add(new Books(7, "Signals and Systems", 2011, "Alan V. Oppenheim", "Basic Sciences", 957, "Pearson"));
        sampleBooks.add(new Books(8, "Computer Networking: Principles, Protocols and Practice", 2014, "Olivier Bonaventure", "Networks", 602, "Saylor"));
        sampleBooks.add(new Books(9, "Operating Systems: Three Easy Pieces", 2014, "Remzi H. Arpaci-Dusseau", "Software", 710, "Arpaci-Dusseau ItemsPackage.Books"));
        sampleBooks.add(new Books(10, "Mathematical Methods in the Physical Sciences", 2004, "Mary L. Boas", "Basic Sciences", 864, "Wiley"));
        Library.items.addAll(sampleBooks);

        List<ItemsPackage.Projects> sampleProjects = new ArrayList<>();
        sampleProjects.add(new ItemsPackage.Projects(
                101, "Smart Traffic Control System", 2023, "Intelligence",
                Arrays.asList("Sara Ali", "Omar Khaled", "Lina Hassan"), "Graduation"
        ));
        sampleProjects.add(new ItemsPackage.Projects(
                102, "Compiler Construction", 2022, "Software",
                Arrays.asList("Rami Kassem", "Lama Fares"), "Fourth Year"
        ));
        sampleProjects.add(new ItemsPackage.Projects(
                103, "Network Packet Sniffer", 2023, "Networks",
                Arrays.asList("Ahmed Zaki", "Noor Hatem", "Ziad Adel"), "Graduation"
        ));
        sampleProjects.add(new ItemsPackage.Projects(
                104, "Mathematical Simulation of Chaos Systems", 2021, "Basic Sciences",
                Arrays.asList("Huda Nasser", "Mazen Rida"), "Third Year"
        ));
        sampleProjects.add(new ItemsPackage.Projects(
                105, "AI-based Chatbot", 2022, "Intelligence",
                Arrays.asList("Khaled Rami", "Nisreen Ahmad"), "Fourth Year"
        ));
        sampleProjects.add(new ItemsPackage.Projects(
                106, "Peer-to-Peer File Sharing App", 2023, "Networks",
                Arrays.asList("Tarek Sami", "Salma Majed", "Jad Karim"), "Graduation"
        ));
        sampleProjects.add(new ItemsPackage.Projects(
                107, "Code Analyzer Tool", 2021, "Software",
                Arrays.asList("Maya Nour", "Ali Saeed"), "Third Year"
        ));
        sampleProjects.add(new ItemsPackage.Projects(
                108, "Quantum Computing Simulator", 2022, "Basic Sciences",
                Arrays.asList("Samar Qassem", "Eyad Basel", "Reem Hani"), "Fourth Year"
        ));
        Library.items.addAll(sampleProjects);

    }
}