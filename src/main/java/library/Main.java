public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        library.addBook(new Book(1, "Война и мир", "Л.Н. Толстой", 1869, "978-5-17-090335-2"));
        library.addBook(new Book(2, "Преступление и наказание", "Ф.М. Достоевский", 1866, "978-5-17-090336-9"));
        library.addBook(new Book(3, "Анна Каренина", "Л.Н. Толстой", 1877, "978-5-17-090337-6"));
        library.addBook(new Book(4, "Мастер и Маргарита", "М.А. Булгаков", 1967, "978-5-17-090338-3"));