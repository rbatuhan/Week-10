import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("LibraryManagementSystem");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        //Author Adding
        Author author = new Author();
        author.setName("Fyodor Dostoyevski");
        author.setBirthday(LocalDate.ofEpochDay(1821-11-11));
        author.setCountry("Russian");
        entityManager.persist(author);

        //Publisher Adding
        Publisher publisher = new Publisher();
        publisher.setName("Hasan Ali");
        publisher.setAddress("İstanbul");
        publisher.setEstablishmentYear(2006);
        entityManager.persist(publisher);

        //Category Adding
        Category categoryHistory = new Category();
        categoryHistory.setName("Novel");
        categoryHistory.setDescription("book");
        entityManager.persist(categoryHistory);

        ArrayList<Category> categoryArrayList = new ArrayList<>();
        categoryArrayList.add(categoryHistory);

        //Book Adding
        Book book = new Book();
        book.setName("Suç ve Ceza");
        book.setAuthor(author);
        book.setPublisher(publisher);
        book.setCategoryList(categoryArrayList);
        book.setStock(100);
        book.setPublicationYear(2006);
        entityManager.persist(book);

        //BookBorrowing Adding
        BookBorrowing bookBorrowing = new BookBorrowing();
        bookBorrowing.setBorrowerName("Batuhan");
        bookBorrowing.setBorrowingDate(LocalDate.ofEpochDay(2024-02-13));
        bookBorrowing.setReturnDate(LocalDate.ofEpochDay(2024-02-16));
        bookBorrowing.setBook(book);
        entityManager.persist(bookBorrowing);

        System.out.println(book);

        transaction.commit();
    }
}