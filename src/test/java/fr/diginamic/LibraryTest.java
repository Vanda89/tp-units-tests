package fr.diginamic;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {

    static Library library = new Library();

    @BeforeAll
    static void init() {
        System.out.println("Start campaign test");
    }

    @BeforeEach
    void setup() {
        System.out.println("Init library before each test");
        library = new Library();
        library.addBook(new Book("Book1", "Author1"));
    }

    @AfterEach
    void cleanUp() {
        System.out.println("End of a test");

    }

    @AfterAll
    static void cleanUpAll() {
        System.out.println("End of all tests");
    }

    @Test
    void shouldAddBook_whenNewBookIsAdded() {
        Book newBook = new Book("Book2", "Author2");
        library.addBook(newBook);

        assertTrue(library.getLivres().contains(newBook), "The book should be present in the library");
        assertEquals(2, library.getLivres().size(), "The size of the library needs to be 2");
    }

    @Test
    void shouldReturnTrue_whenBorrowingDisponibleBook() {
        boolean result = library.borrowBook("Book1");
        assertTrue(result, "The book should be borrowed");
        assertFalse(library.getLivres().get(0).isDisponible(), "The borrowed book should be undisponible");
    }

    @Test
    void shouldReturnFalse_whenBorrowingANonExistingBook() {
        boolean result = library.borrowBook("FakeBook");
        assertFalse(result, "Borrowing a non-existent book should fail");
    }

    @Test
    void shouldReturnFalse_whenBorrowingAlreadyBorrowedBook() {
        library.borrowBook("Book1");
        boolean result = library.borrowBook("Book1");
        assertFalse(result, "Borrowing a book already borrowed should fail");
    }




    @Test
    void shouldReturnTrue_whenReturningBorrowedBook() {
        library.borrowBook("Book1");
        boolean result = library.returnBook("Book1");

        assertTrue(result, "Returning a borrowed book should be successful");
        assertTrue(library.getLivres().get(0).isDisponible(), "The book should become disponible again");
    }

    @Test
    void shouldCountAvailableBooks_correctly() {
        library.addBook(new Book("Book2", "Author2"));
        library.addBook(new Book("Book3", "Author3"));
        library.borrowBook("Book2");

        assertEquals(2, library.countAvailableBooks(), "2 books should be disponible");
    }







}
