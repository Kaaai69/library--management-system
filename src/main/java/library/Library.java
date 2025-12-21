import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private OperationLog operationLog;

    public Library() {
        this.books = new ArrayList<>();
        this.operationLog = new OperationLog();
    }

    public void addBook(Book book) {
        books.add(book);
        operationLog.addEntry(OperationLog.OperationType.ADD_BOOK,
                "Добавлена книга: " + book.getTitle());
    }

    public Book findBookById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    public List<Book> findBooksByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                result.add(book);
            }
        }
        return result;
    }

    public boolean borrowBook(int id) {
        Book book = findBookById(id);
        if (book != null && book.isAvailable()) {
            book.setAvailable(false);
            operationLog.addEntry(OperationLog.OperationType.BORROW,
                    "Выдана книга: " + book.getTitle());
            return true;
        }
        return false;
    }

    public boolean returnBook(int id) {
        Book book = findBookById(id);
        if (book != null && !book.isAvailable()) {
            book.setAvailable(true);
            operationLog.addEntry(OperationLog.OperationType.RETURN,
                    "Возвращена книга: " + book.getTitle());
            return true;
        }
        return false;
    }

    public List<Book> getAvailableBooks() {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.isAvailable()) {
                result.add(book);
            }
        }
        return result;
    }
<<<<<<< HEAD
    public void printOperationLog() {
        operationLog.printLog();
    }

    public static class OperationLog {
        private List<LogEntry> entries;

        public OperationLog() {
            this.entries = new ArrayList<>();
        }

        public void addEntry(OperationType type, String description) {
            LogEntry entry = new LogEntry(type, description);
            entries.add(entry);
        }

        public List<LogEntry> getEntries() {
            return new ArrayList<>(entries);
        }

        public void printLog() {
            if (entries.isEmpty()) {
                System.out.println("Журнал операций пуст");
                return;
            }

            System.out.println("=== Журнал операций библиотеки ===");
            for (LogEntry entry : entries) {
                System.out.println(entry);
            }
            System.out.println("===================================");
        }

        public class LogEntry {
            private OperationType type;
            private LocalDateTime timestamp;
            private String description;

            public LogEntry(OperationType type, String description) {
                this.type = type;
                this.timestamp = LocalDateTime.now();
                this.description = description;
            }

            public OperationType getType() {
                return type;
            }

            public LocalDateTime getTimestamp() {
                return timestamp;
            }

            public String getDescription() {
                return description;
            }

            @Override
            public String toString() {
                return String.format("[%s] %s - %s",
                        timestamp.toString(), type, description);
            }
        }
`
        public enum OperationType {
            ADD_BOOK,
            BORROW,
            RETURN
        }
    }
}
public class Library {
    private List<Book> books;
    private OperationLog operationLog;

    public Library() {
        this.books = new ArrayList<>();
        this.operationLog = new OperationLog();
    }

    public void addBook(Book book) {
        books.add(book);
        operationLog.addEntry(OperationLog.OperationType.ADD_BOOK,
                "Добавлена книга: " + book.getTitle());
    }

    public Book findBookById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    public List<Book> findBooksByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                result.add(book);
            }
        }
        return result;
    }

    public boolean borrowBook(int id) {
        Book book = findBookById(id);
        if (book != null && book.isAvailable()) {
            book.setAvailable(false);
            operationLog.addEntry(OperationLog.OperationType.BORROW,
                    "Выдана книга: " + book.getTitle());
            return true;
        }
        return false;
    }

    public boolean returnBook(int id) {
        Book book = findBookById(id);
        if (book != null && !book.isAvailable()) {
            book.setAvailable(true);
            operationLog.addEntry(OperationLog.OperationType.RETURN,
                    "Возвращена книга: " + book.getTitle());
            return true;
        }
        return false;
    }

    public List<Book> getAvailableBooks() {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.isAvailable()) {
                result.add(book);
            }
        }
        return result;
    }

    public void printOperationLog() {
        operationLog.printLog();
    }

    public String getStatistics() {
        int totalBooks = books.size();
        int availableBooks = 0;

        for (Book book : books) {
            if (book.isAvailable()) {
                availableBooks++;
            }
        }

        int borrowedBooks = totalBooks - availableBooks;

        return String.format(
                "Общее количество книг: %d\nДоступно: %d\nВыдано: %d",
                totalBooks, availableBooks, borrowedBooks
        );
    }

    public static class OperationLog {
        private List<LogEntry> entries;

        public OperationLog() {
            this.entries = new ArrayList<>();
        }

        public void addEntry(OperationType type, String description) {
            LogEntry entry = new LogEntry(type, description);
            entries.add(entry);
        }

        public List<LogEntry> getEntries() {
            return new ArrayList<>(entries);
        }

        public void printLog() {
            if (entries.isEmpty()) {
                System.out.println("Журнал операций пуст");
                return;
            }

            System.out.println("=== Журнал операций библиотеки ===");
            for (LogEntry entry : entries) {
                System.out.println(entry);
            }
            System.out.println("===================================");
        }

        public class LogEntry {
            private OperationType type;
            private LocalDateTime timestamp;
            private String description;

            public LogEntry(OperationType type, String description) {
                this.type = type;
                this.timestamp = LocalDateTime.now();
                this.description = description;
            }

            public OperationType getType() {
                return type;
            }

            public LocalDateTime getTimestamp() {
                return timestamp;
            }

            public String getDescription() {
                return description;
            }

            @Override
            public String toString() {
                return String.format("[%s] %s - %s",
                        timestamp.toString(), type, description);
            }
        }

        public enum OperationType {
            ADD_BOOK,
            BORROW,
            RETURN
        }
    }
}
        ```java
public class Library {
    private List<Book> books;
    private OperationLog operationLog;

    public Library() {
        this.books = new ArrayList<>();
        this.operationLog = new OperationLog();
    }

    public void addBook(Book book) {
        books.add(book);
        operationLog.addEntry(OperationLog.OperationType.ADD_BOOK,
                "Добавлена книга: " + book.getTitle());
    }

    public boolean removeBook(int id) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId() == id) {
                Book removedBook = books.remove(i);
                operationLog.addEntry(OperationLog.OperationType.REMOVE,
                        "Удалена книга: " + removedBook.getTitle());
                return true;
            }
        }
        return false;
    }

    public Book findBookById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    public List<Book> findBooksByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                result.add(book);
            }
        }
        return result;
    }

    public boolean borrowBook(int id) {
        Book book = findBookById(id);
        if (book != null && book.isAvailable()) {
            book.setAvailable(false);
            operationLog.addEntry(OperationLog.OperationType.BORROW,
                    "Выдана книга: " + book.getTitle());
            return true;
        }
        return false;
    }

    public boolean returnBook(int id) {
        Book book = findBookById(id);
        if (book != null && !book.isAvailable()) {
            book.setAvailable(true);
            operationLog.addEntry(OperationLog.OperationType.RETURN,
                    "Возвращена книга: " + book.getTitle());
            return true;
        }
        return false;
    }

    public List<Book> getAvailableBooks() {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.isAvailable()) {
                result.add(book);
            }
        }
        return result;
    }

    public void printOperationLog() {
        operationLog.printLog();
    }

    public String getStatistics() {
        int totalBooks = books.size();
        int availableBooks = 0;

        for (Book book : books) {
            if (book.isAvailable()) {
                availableBooks++;
            }
        }

        int borrowedBooks = totalBooks - availableBooks;

        return String.format(
                "Общее количество книг: %d\nДоступно: %d\nВыдано: %d",
                totalBooks, availableBooks, borrowedBooks
        );
    }

    public static class OperationLog {
        private List<LogEntry> entries;

        public OperationLog() {
            this.entries = new ArrayList<>();
        }

        public void addEntry(OperationType type, String description) {
            LogEntry entry = new LogEntry(type, description);
            entries.add(entry);
        }

        public List<LogEntry> getEntries() {
            return new ArrayList<>(entries);
        }

        public void printLog() {
            if (entries.isEmpty()) {
                System.out.println("Журнал операций пуст");
                return;
            }

            System.out.println("=== Журнал операций библиотеки ===");
            for (LogEntry entry : entries) {
                System.out.println(entry);
            }
            System.out.println("===================================");
        }

        public class LogEntry {
            private OperationType type;
            private LocalDateTime timestamp;
            private String description;

            public LogEntry(OperationType type, String description) {
                this.type = type;
                this.timestamp = LocalDateTime.now();
                this.description = description;
            }

            public OperationType getType() {
                return type;
            }

            public LocalDateTime getTimestamp() {
                return timestamp;
            }

            public String getDescription() {
                return description;
            }

            @Override
            public String toString() {
                return String.format("[%s] %s - %s",
                        timestamp.toString(), type, description);
            }
        }

        public enum OperationType {
            ADD_BOOK,
            REMOVE,
            BORROW,
            RETURN
        }
    }
}

=======
    
>>>>>>> 91a2bcf (Add Library class structure)
