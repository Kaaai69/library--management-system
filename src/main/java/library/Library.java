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

        public enum OperationType {
            ADD_BOOK,
            BORROW,
            RETURN
        }
    }
}


=======
    
>>>>>>> 91a2bcf (Add Library class structure)
