Projekt programowanie 
1. Zarządzanie książkami 

2. Importowanie bibliotek

Importowanie bibliotek Swing, AWT, i innych potrzebnych do interfejsu graficznego oraz zarządzania danymi.

Deklaracja klasy głównej

public class BookManagementApp:
Definicja zmiennych i komponentów GUI.
Konstruktor klasy ustawiający parametry okna i wypełniający przykładową listę książek.

Tworzenie interfejsu graficznego

Tworzenie głównego panelu JPanel.
Tworzenie i konfiguracja górnego panelu z polem wyszukiwania i przyciskami sortowania.
Dodawanie przycisków sortowania wg tytułu, autora, roku wydania, i gatunku.
Tworzenie tabeli JTable do wyświetlania książek z odpowiednim modelem DefaultTableModel.
Tworzenie dolnego panelu z przyciskami dodawania i usuwania książek.

Metody pomocnicze

updateTable(): Aktualizacja zawartości tabeli.
searchBooks(): Wyszukiwanie książek na podstawie zapytania.
addBook(): Dodawanie nowej książki do listy po wprowadzeniu danych przez użytkownika.
removeBook(): Usuwanie zaznaczonej książki z listy.

Metoda główna

main(String[] args): Uruchomienie aplikacji w oddzielnym wątku Swing.

Klasa Book

Definicja klasy reprezentującej książkę z polami: title, author, year, genre.
Konstruktor oraz metody dostępowe do pól klasy.

3. Instrukcje obsługi
- Java Development Kit (JDK)
Aplikacja jest napisana w języku Java, więc wymagane jest zainstalowanie JDK. Można pobrać JDK ze strony Oracle lub AdoptOpenJDK.
- IDE lub edytor tekstowy
Możesz użyć dowolnego zintegrowanego środowiska programistycznego (IDE) takiego jak IntelliJ IDEA, Eclipse, NetBeans lub edytora tekstowego z obsługą Javy, np. VS Code.

Kroki do uruchomienia aplikacji
-Skopiuj kod źródłowy z pliku BookManagementApp.java do swojego IDE lub edytora tekstowego.

Skonfiguruj projekt
Jeśli używasz IDE, utwórz nowy projekt Java i dodaj plik BookManagementApp.java do katalogu z kodem źródłowym.
Jeśli używasz edytora tekstowego, upewnij się, że masz odpowiednią strukturę katalogów i plików dla projektu Java.

Kompilacja
W IDE proces kompilacji i uruchamiania jest zazwyczaj automatyczny. Wystarczy kliknąć przycisk "Run" lub "Compile".
W przypadku używania edytora tekstowego i konsoli, przejdź do katalogu z plikiem BookManagementApp.java i uruchom polecenie kompilacji:
javac BookManagementApp.java

Uruchomienie aplikacji
Po skompilowaniu projektu, uruchom aplikację z IDE klikając przycisk "Run".
Jeśli korzystasz z konsoli, uruchom aplikację za pomocą poniższego polecenia:
java BookManagementApp

Dodatkowe informacje:
Brak dodatkowych bibliotek: Aplikacja nie wymaga dodatkowych bibliotek czy paczek poza standardowymi bibliotekami Javy (Swing, AWT).
Problemy z uruchomieniem: Upewnij się, że plik BookManagementApp.java znajduje się w katalogu, w którym uruchamiasz polecenia kompilacji i uruchamiania.