public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        library.addBook(new Book(1, "Война и мир", "Л.Н. Толстой", 1869, "978-5-17-090335-2"));
        library.addBook(new Book(2, "Преступление и наказание", "Ф.М. Достоевский", 1866, "978-5-17-090336-9"));
        library.addBook(new Book(3, "Анна Каренина", "Л.Н. Толстой", 1877, "978-5-17-090337-6"));
        library.addBook(new Book(4, "Мастер и Маргарита", "М.А. Булгаков", 1967, "978-5-17-090338-3"));
        System.out.println("=== Доступные книги в библиотеке ===");
        for (Book book : library.getAvailableBooks()) {
            System.out.println(book);
            System.out.println();
        }

        System.out.println("=== Поиск книг Л.Н. Толстого ===");
        for (Book book : library.findBooksByAuthor("Л.Н. Толстой")) {
            System.out.println(book.getTitle());
        }

        System.out.println("\n=== Выдача книг ===");
        boolean borrowed1 = library.borrowBook(1);
        System.out.println("Выдача книги ID 1: " + (borrowed1 ? "успешно" : "не удалось"));

        boolean borrowed2 = library.borrowBook(1);
        System.out.println("Повторная выдача книги ID 1: " + (borrowed2 ? "успешно" : "не удалось"));

        boolean borrowed3 = library.borrowBook(2);
        System.out.println("Выдача книги ID 2: " + (borrowed3 ? "успешно" : "не удалось"));

        System.out.println("\n=== Поиск по ID ===");
        Book foundBook = library.findBookById(3);
        if (foundBook != null) {
            System.out.println("Найдена книга: " + foundBook.getTitle());
        } else {
            System.out.println("Книга не найдена");
        }

        Book notFoundBook = library.findBookById(99);
        if (notFoundBook != null) {
            System.out.println("Найдена книга: " + notFoundBook.getTitle());
        } else {
            System.out.println("Книга с ID 99 не найдена");
        }

        System.out.println("\n=== Возврат книг ===");
        boolean returned1 = library.returnBook(1);
        System.out.println("Возврат книги ID 1: " + (returned1 ? "успешно" : "не удалось"));

        boolean returned2 = library.returnBook(2);
        System.out.println("Возврат книги ID 2: " + (returned2 ? "успешно" : "не удалось"));

        System.out.println("\n=== Доступные книги после операций ===");
        for (Book book : library.getAvailableBooks()) {
            System.out.println(book.getTitle() + " - " + (book.isAvailable() ? "Доступна" : "Выдана"));
        }

        System.out.println("\n=== Журнал операций ===");
        library.printOperationLog();
    }
}