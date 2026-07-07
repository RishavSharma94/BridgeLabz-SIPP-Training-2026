import java.util.*;
import java.util.stream.Collectors;

interface Borrowable {
    boolean borrowItem(Member member);
    boolean returnItem(Member member);
}

interface Reservable {
    boolean reserveItem(Member member);
    boolean cancelReservation(Member member);
}

abstract class Book {
    private String isbn;
    private String title;
    private String author;
    private boolean isReserved;

    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.isReserved = false;
    }

    public abstract void displayDetails();

    public String getIsbn() { return isbn; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isReserved() { return isReserved; }
    public void setReserved(boolean reserved) { isReserved = reserved; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return Objects.equals(isbn, book.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }
}

class PhysicalBook extends Book implements Borrowable, Reservable {
    private String shelfLocation;
    private boolean isBorrowed;

    public PhysicalBook(String isbn, String title, String author, String shelfLocation) {
        super(isbn, title, author);
        this.shelfLocation = shelfLocation;
        this.isBorrowed = false;
    }

    @Override
    public void displayDetails() {
        System.out.println("[Physical Book] Title: " + getTitle() + " | Author: " + getAuthor() +
                " | ISBN: " + getIsbn() + " | Location: " + shelfLocation +
                " | Status: " + (isBorrowed ? "Borrowed" : "Available"));
    }

    @Override
    public boolean borrowItem(Member member) {
        if (!isBorrowed && member.canBorrow()) {
            isBorrowed = true;
            member.incrementBorrowedCount();
            return true;
        }
        return false;
    }

    @Override
    public boolean returnItem(Member member) {
        if (isBorrowed) {
            isBorrowed = false;
            member.decrementBorrowedCount();
            return true;
        }
        return false;
    }

    @Override
    public boolean reserveItem(Member member) {
        if (!isReserved()) {
            setReserved(true);
            return true;
        }
        return false;
    }

    @Override
    public boolean cancelReservation(Member member) {
        if (isReserved()) {
            setReserved(false);
            return true;
        }
        return false;
    }
}

class EBook extends Book implements Borrowable {
    private double fileSizeMB;
    private int activeDownloads;

    public EBook(String isbn, String title, String author, double fileSizeMB) {
        super(isbn, title, author);
        this.fileSizeMB = fileSizeMB;
        this.activeDownloads = 0;
    }

    @Override
    public void displayDetails() {
        System.out.println("[E-Book] Title: " + getTitle() + " | Author: " + getAuthor() +
                " | ISBN: " + getIsbn() + " | Size: " + fileSizeMB + "MB" +
                " | Active Downloads: " + activeDownloads);
    }

    @Override
    public boolean borrowItem(Member member) {
        if (member.canBorrow()) {
            activeDownloads++;
            member.incrementBorrowedCount();
            return true;
        }
        return false;
    }

    @Override
    public boolean returnItem(Member member) {
        if (activeDownloads > 0) {
            activeDownloads--;
            member.decrementBorrowedCount();
            return true;
        }
        return false;
    }
}

class Member {
    private String memberId;
    private String name;
    private int maxBorrowLimit;
    private int currentBorrowedCount;

    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        this.maxBorrowLimit = 3;
        this.currentBorrowedCount = 0;
    }

    protected Member(String memberId, String name, int maxBorrowLimit) {
        this.memberId = memberId;
        this.name = name;
        this.maxBorrowLimit = maxBorrowLimit;
        this.currentBorrowedCount = 0;
    }

    public boolean canBorrow() {
        return currentBorrowedCount < maxBorrowLimit;
    }

    public void incrementBorrowedCount() { currentBorrowedCount++; }
    public void decrementBorrowedCount() { if (currentBorrowedCount > 0) currentBorrowedCount--; }

    public String getMemberId() { return memberId; }
    public String getName() { return name; }
    public int getMaxBorrowLimit() { return maxBorrowLimit; }
    public int getCurrentBorrowedCount() { return currentBorrowedCount; }
}

class PremiumMember extends Member {
    public PremiumMember(String memberId, String name) {
        super(memberId, name, 10);
    }
}

class LibraryEngine {
    private Map<String, Book> bookRegistry = new HashMap<>();
    private Map<String, Member> memberRegistry = new HashMap<>();
    private List<Book> bookList = new ArrayList<>();

    public void addBook(Book book) {
        if (!bookRegistry.containsKey(book.getIsbn())) {
            bookRegistry.put(book.getIsbn(), book);
            bookList.add(book);
        }
    }

    public void registerMember(Member member) {
        memberRegistry.put(member.getMemberId(), member);
    }

    public List<Book> searchByTitle(String query) {
        return bookList.stream()
                .filter(b -> b.getTitle().toLowerCase().contains(query.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Book> filterByAuthor(String author) {
        return bookList.stream()
                .filter(b -> b.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }

    public void sortByTitle() {
        bookList.sort(Comparator.comparing(Book::getTitle));
    }

    public void sortByAuthor() {
        bookList.sort(Comparator.comparing(Book::getAuthor));
    }

    public void displayAllBooks() {
        for (Book book : bookList) {
            book.displayDetails();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        LibraryEngine library = new LibraryEngine();

        PhysicalBook book1 = new PhysicalBook("978-1", "The Hobbit", "J.R.R. Tolkien", "Shelf A-1");
        PhysicalBook book2 = new PhysicalBook("978-2", "1984", "George Orwell", "Shelf B-4");
        EBook book3 = new EBook("978-3", "Digital Minimalism", "Cal Newport", 4.5);

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        Member regularMember = new Member("M001", "Rahul");
        PremiumMember premiumMember = new PremiumMember("P001", "Amit");
        library.registerMember(regularMember);
        library.registerMember(premiumMember);

        System.out.println("--- Library Catalog ---");
        library.displayAllBooks();

        System.out.println("\n--- Actions Processing ---");
        boolean res1 = book1.borrowItem(regularMember);
        System.out.println(regularMember.getName() + " borrowed 'The Hobbit': " + res1);

        boolean res2 = book1.reserveItem(premiumMember);
        System.out.println(premiumMember.getName() + " reserved 'The Hobbit': " + res2);

        System.out.println("\n--- Sorting Catalog by Title ---");
        library.sortByTitle();
        library.displayAllBooks();

        System.out.println("\n--- Filtering books by author 'George Orwell' ---");
        List<Book> filteredBooks = library.filterByAuthor("George Orwell");
        for (Book b : filteredBooks) {
            b.displayDetails();
        }
    }
}