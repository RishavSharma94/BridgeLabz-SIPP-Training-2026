class Book {
    String title;
    int publicationYear;

    Book(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }
}

class Author extends Book {
    String authorName;
    String bio;

    Author(String title, int publicationYear,
           String authorName, String bio) {

        super(title, publicationYear);
        this.authorName = authorName;
        this.bio = bio;
    }

    void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Publication Year: " + publicationYear);
        System.out.println("Author: " + authorName);
        System.out.println("Bio: " + bio);
    }
}

public class LibraryManagement {
    public static void main(String[] args) {

        Author author = new Author(
                "Java Programming",
                2024,
                "James Gosling",
                "Creator of Java");

        author.displayInfo();
    }
}