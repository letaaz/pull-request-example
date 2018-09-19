package car.tp4.dataBase;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Entity represents a Book
 */
@Entity
public class Book {
  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private long id;
  private String author;
  private String title;
  private String year;
  private int quantity;

  /**
   * Constructor of Book
   * @param author author of the book
   * @param title title of the book
   * @param year publication year of book
   * @param quantity quantity available of the book
   */
  public Book(String author, String title, String year, int quantity)
  {
    this.author = author;
    this.title = title;
    this.year = year;
    this.quantity = quantity;
  }

  /**
   * Constructor of Book
   * @param author author of the book
   * @param title title of the book
   * @param year publication year of the book
   */
//  public Book(String author, String title, String  year) {
//    this.author = author;
//    this.title = title;
//    this.year = year ;
//    this.quantity = 0;
//  }

  /**
   * Constructor of Book
   * @param author author of the book
   * @param title title of the book
   */
  public Book(String author, String title) {
    this.author = author;
    this.title = title;
    this.quantity = 1;
  }

  /**
   * Empty Constructor of the Book
   */
  public Book() {
  }

  /**
   * Get the author of the book
   * @return name of the author
   */
  public String getAuthor() {
    return author;
  }

  /**
   * Set the author name of the book
   * @param author author name
   */
  public void setAuthor(String author) {
    this.author = author;
  }

  /**
   * Get the title of the book
   * @return title of the book
   */
  public String getTitle() {
    return title;
  }

  /**
   * Set the title of the book
   * @param title title of the book
   */
  public void setTitle(String title) {
    this.title = title;
  }

  /**
   * Get publication year of the book
   * @return publication year
   */
  public String getYear() {
    return year;
  }

  /**
   * Set publication year of the book
   * @param year publication year
   */
  public void setYear(String year) {
    this.year = year;
  }

  /**
   * Get the quantity available of the book
   * @return the quantity of book available
   */
  public int getQuantity()
  {
    return this.quantity;
  }

  /**
   * Set the quantity of the book
   * @param quantity number of book available
   */
  public void setQuantity(int quantity)
  {
    this.quantity = quantity;
  }

  /**
   * Get the id of the book
   * @return id of book
   */
  public long getId() {
    return id;
  }

  /**
   * Set the id of the book
   * @param id must be unique
   */
  public void setId(long id) {
    this.id = id;
  }


  /**
   * Compare an object to the book
   * @param o an object to compare
   * @return true if o is equals to this Book
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Book book = (Book) o;

    if (id != book.id) return false;
    if (!author.equals(book.author)) return false;
    if (!year.equals(book.year)) return false;
    return title.equals(book.title);
  }

  @Override
  public int hashCode() {
    int result = (int) (id ^ (id >>> 32));
    result = 31 * result + author.hashCode();
    result = 31 * result + title.hashCode();
    return result;
  }

  /**
   * Returns the Book to String
   * @return informations of the book
   */
  @Override
  public String toString() {
    return "Book{" +
      "author='" + author + '\'' +
      ", title='" + title + '\'' +
      ", year='" + year + '\'' +
      '}';
  }
}
