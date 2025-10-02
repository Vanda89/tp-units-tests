package fr.diginamic;

public interface ExternalBookService {
    boolean isBookAvailable(String title);
    Book fetchBookDetails(String title);
}