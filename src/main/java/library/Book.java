public class Book {
    private final int id;
    private final String title;
    private final String author;
    private final int year;
    private final String isbn;
    private boolean available;

    public Book(int id, String title, String author, int year, String isbn) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
        this.isbn = isbn;
        this.available = true;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        String status = available ? "Доступна" : "Не доступна";
        return String.format("[ID: %d] \"%s\" — %s (%d)\nISBN: %s | Статус: %s",
                id, title, author, year, isbn, status);
    }
}