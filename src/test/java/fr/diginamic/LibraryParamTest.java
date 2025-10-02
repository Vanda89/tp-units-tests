package fr.diginamic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class LibraryParamTest {

    @Mock
    ExternalBookService externalService;

    @InjectMocks
    Library library;

    @BeforeEach
    void setup() {
        library = new Library(externalService);
    }


    @Test
    void shouldReturnTrue_whenExternalBookIsAvailable() {
        when(externalService.isBookAvailable("Book1")).thenReturn(true);

        boolean result = library.checkExternalAvailability("Book1");

        assertTrue(result, "Book1 should be available");
        verify(externalService, times(1)).isBookAvailable("Book1");
    }

    @Test
    void shouldAddBook_whenExternalBookExists() {
        Book externalBook = new Book("Book2", "Author2");
        when(externalService.fetchBookDetails("Book2")).thenReturn(externalBook);

        library.importBookFromExternal("Book2");

        assertTrue(library.getLivres().contains(externalBook), "The book should be added to the library");
        verify(externalService, times(1)).fetchBookDetails("Book2");
    }

    @Test
    void shouldThrowException_whenExternalBookDoesNotExist() {
        when(externalService.fetchBookDetails("Book3")).thenReturn(null);

        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> library.importBookFromExternal("Book3"));

        assertEquals("Book not found in external service: Book3", exception.getMessage());        verify(externalService, times(1)).fetchBookDetails("Book3");
    }

    @Test
    void shouldVerifyMultipleExternalAvailabilityCalls() {
        when(externalService.isBookAvailable("Book1")).thenReturn(true);
        when(externalService.isBookAvailable("Book2")).thenReturn(false);

        assertTrue(library.checkExternalAvailability("Book1"));
        assertFalse(library.checkExternalAvailability("Book2"));

        verify(externalService, times(1)).isBookAvailable("Book1");
        verify(externalService, times(1)).isBookAvailable("Book2");
    }
}