import javax.swing.*; 
import javax.swing.table.DefaultTableModel; 
import java.awt.*; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import java.util.ArrayList; 
import java.util.Collections; 
import java.util.Comparator; 
import java.util.regex.Pattern; 
import java.util.regex.PatternSyntaxException; 

public class BookManagementApp extends JFrame {
    private ArrayList<Book> books = new ArrayList<>(); 
    private JTextField searchField; 
    private JTable table; 
    private DefaultTableModel model; 

    public BookManagementApp() {
        setTitle("Zarządzanie książkami"); 
        setSize(800, 400); 
        setDefaultCloseOperation(EXIT_ON_CLOSE); 

        // Przykładowe książki
        books.add(new Book("W pustyni i w puszczy", "Henryk Sienkiewicz", 1911, "Przygodowa"));
        books.add(new Book("Wiedźmin: Ostatnie życzenie", "Andrzej Sapkowski", 1993, "Fantasy"));
        books.add(new Book("Harry Potter i Kamień Filozoficzny", "J.K. Rowling", 1997, "Fantasy"));
        books.add(new Book("Duma i uprzedzenie", "Jane Austen", 1813, "Romans"));
        books.add(new Book("Mistrz i Małgorzata", "Michaił Bułhakow", 1967, "Klasyczna literatura rosyjska"));
        books.add(new Book("Władca Pierścieni: Drużyna Pierścienia", "J.R.R. Tolkien", 1954, "Fantasy"));
        books.add(new Book("1984", "George Orwell", 1949, "Dystopia"));
        books.add(new Book("Mały Książę", "Antoine de Saint-Exupéry", 1943, "Literatura dziecięca"));
        books.add(new Book("Zdążyć przed Panem Bogiem", "Gabriela Zapolska", 1901, "Dramat"));
        books.add(new Book("Zbrodnia i kara", "Fiodor Dostojewski", 1866, "Klasyczna literatura rosyjska"));
        books.add(new Book("Lśnienie", "Stephen King", 1977, "Horror"));
        books.add(new Book("Marsjanin", "Andy Weir", 2011, "Science Fiction"));
        books.add(new Book("Wzgórze psów", "Cormac McCarthy", 2005, "Postapokaliptyczna"));
        books.add(new Book("Harry Potter i Komnata Tajemnic", "J.K. Rowling", 1998, "Fantasy"));
        books.add(new Book("Mroczne Materie: Zorza Polarna", "Philip Pullman", 1995, "Fantasy"));
        books.add(new Book("Zaginiony symbol", "Dan Brown", 2009, "Thriller"));
        books.add(new Book("Dziennik Anne Frank", "Anne Frank", 1947, "Pamiętnik"));
        books.add(new Book("Cztery pory roku", "Stephen King", 1982, "Horror"));
        books.add(new Book("Wilk z Wall Street", "Jordan Belfort", 2007, "Biografia"));
        books.add(new Book("Rok 1984", "George Orwell", 1949, "Dystopia"));
        books.add(new Book("Sto lat samotności", "Gabriel Garcia Marquez", 1967, "Realizm magiczny"));
        books.add(new Book("Nieznośna lekkość bytu", "Milan Kundera", 1984, "Filozoficzna"));
        books.add(new Book("Harry Potter i Więzień Azkabanu", "J.K. Rowling", 1999, "Fantasy"));
        books.add(new Book("Mężczyźni są z Marsa, kobiety z Wenus", "John Gray", 1992, "Samopomoc"));
        books.add(new Book("Szklany zamek", "Jeannette Walls", 2005, "Biografia"));
        books.add(new Book("Pan Tadeusz", "Adam Mickiewicz", 1834, "Epos"));

   
        JPanel panel = new JPanel(new BorderLayout()); 

        // Panel dla przycisków i pola wyszukiwania
        JPanel topPanel = new JPanel(); 
        searchField = new JTextField(20); 
        JButton searchButton = new JButton("Szukaj"); 
        searchButton.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                searchBooks(); 
            }
        });
        topPanel.add(searchField); 
        topPanel.add(searchButton); 

        
        JButton sortByTitleButton = new JButton("Sortuj wg Tytułu");
        sortByTitleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Collections.sort(books, Comparator.comparing(Book::getTitle));
                updateTable(); 
            }
        });

        JButton sortByAuthorButton = new JButton("Sortuj wg Autora");
        sortByAuthorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Collections.sort(books, Comparator.comparing(Book::getAuthor)); 
                updateTable(); 
            }
        });
 
        JButton sortByYearButton = new JButton("Sortuj wg Roku");
        sortByYearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Collections.sort(books, Comparator.comparingInt(Book::getYear)); 
                updateTable(); 
            }
        });

        JButton sortByGenreButton = new JButton("Sortuj wg Gatunku");
        sortByGenreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Collections.sort(books, Comparator.comparing(Book::getGenre));
                updateTable();
            }
        });
        
        topPanel.add(sortByTitleButton);  
        topPanel.add(sortByAuthorButton); 
        topPanel.add(sortByYearButton);   
        topPanel.add(sortByGenreButton);  


        panel.add(topPanel, BorderLayout.NORTH);

       
        table = new JTable();
        model = new DefaultTableModel(new String[]{"Tytuł", "Autor", "Rok wydania", "Gatunek"}, 0); 
        table.setModel(model); 
        JScrollPane scrollPane = new JScrollPane(table); 
        panel.add(scrollPane, BorderLayout.CENTER); 


        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Dodaj książkę");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addBook(); 
            }
        });
        JButton removeButton = new JButton("Usuń książkę");
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeBook();  
            }
        });
        buttonPanel.add(addButton);  
        buttonPanel.add(removeButton); 
        panel.add(buttonPanel, BorderLayout.SOUTH);

        add(panel);

        updateTable();
    }

    private void updateTable() {
        model.setRowCount(0); 
        for (Book book : books) {
            model.addRow(new Object[]{book.getTitle(), book.getAuthor(), book.getYear(), book.getGenre()}); 
        }
    }

    private void searchBooks() {
        String query = searchField.getText().trim(); // Pobierz zapytanie z pola wyszukiwania
        ArrayList<Book> results = new ArrayList<>();

        if (!query.isEmpty()) {
            try {
                Pattern pattern = Pattern.compile(query, Pattern.CASE_INSENSITIVE); 
                for (Book book : books) {

                    if (pattern.matcher(book.getTitle()).find() || pattern.matcher(book.getAuthor()).find() ||
                            pattern.matcher(String.valueOf(book.getYear())).find() || pattern.matcher(book.getGenre()).find()) {
                        results.add(book); 
                    }
                }
            } catch (PatternSyntaxException e) {
                JOptionPane.showMessageDialog(this, "Błędne wyrażenie regularne.", "Błąd", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            results.addAll(books); 
        }

        model.setRowCount(0); 
        for (Book book : results) {
            model.addRow(new Object[]{book.getTitle(), book.getAuthor(), book.getYear(), book.getGenre()}); 
        }
    }

    // Metoda do dodawania książki
    private void addBook() {
        JTextField titleField = new JTextField(20);
        JTextField authorField = new JTextField(20);
        JTextField yearField = new JTextField(5);
        JTextField genreField = new JTextField(15);

        JPanel panel = new JPanel(new GridLayout(0, 2));
        panel.add(new JLabel("Tytuł:"));
        panel.add(titleField);
        panel.add(new JLabel("Autor:"));
        panel.add(authorField);
        panel.add(new JLabel("Rok wydania:"));
        panel.add(yearField);
        panel.add(new JLabel("Gatunek:"));
        panel.add(genreField);

        int result = JOptionPane.showConfirmDialog(this, panel, "Dodaj książkę", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            String title = titleField.getText().trim();
            String author = authorField.getText().trim();
            String yearText = yearField.getText().trim();
            String genre = genreField.getText().trim();

            if (!title.isEmpty() && !author.isEmpty() && !yearText.isEmpty() && !genre.isEmpty()) {
                try {
                    int year = Integer.parseInt(yearText); 
                    books.add(new Book(title, author, year, genre));
                    updateTable(); 
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Rok wydania musi być liczbą całkowitą.", "Błąd", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Wszystkie pola muszą być wypełnione.", "Błąd", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void removeBook() {
        int selectedRow = table.getSelectedRow(); 
        if (selectedRow != -1) {
            books.remove(selectedRow); 
            updateTable();
        } else {
            JOptionPane.showMessageDialog(this, "Wybierz książkę do usunięcia.", "Błąd", JOptionPane.ERROR_MESSAGE);
        }
    }
    // Główna metoda uruchamiająca aplikację
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BookManagementApp().setVisible(true);
            }
        });
    }
}

class Book {
    private String title;
    private String author;
    private int year;
    private String genre;

    public Book(String title, String author, int year, String genre) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.genre = genre;
    }
    // Metody dostępowe do pod klasy
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }
}
