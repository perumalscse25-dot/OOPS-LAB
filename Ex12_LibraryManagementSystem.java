import java.util.ArrayList;
import java.util.Scanner;

// --------------------------------------------------
// Book Class
// --------------------------------------------------
class Book {
   private int bookId;
   private String title;
   private String author;
   private String category;
   private boolean available;

   // Constructor
   public Book(int bookId, String title, String author, String category) {
       this.bookId = bookId;
       this.title = title;
       this.author = author;
       this.category = category;
       this.available = true;
   }

   // Getter methods
   public int getBookId() {
       return bookId;
   }

   public String getTitle() {
       return title;
   }

   public String getAuthor() {
       return author;
   }

   public boolean isAvailable() {
       return available;
   }

   // Setter
   public void setAvailable(boolean available) {
       this.available = available;
   }

   // Display Book
   public void displayBook() {
       System.out.println("Book ID         : " + bookId);
       System.out.println("Title        : " + title);
       System.out.println("Author         : " + author);
       System.out.println("Category : " + category);
       System.out.println("Status       :" +
            (available ? "Available" : "Issued"));
       System.out.println("-------------------------------------");
   }
}

// --------------------------------------------------
// Abstract Person Class
// --------------------------------------------------
abstract class Person {
   protected int memberId;
   protected String name;
   protected String phone;

   public Person(int memberId, String name, String phone) {
       this.memberId = memberId;
       this.name = name;
       this.phone = phone;
   }

   abstract void displayDetails();

   public int getMemberId() {
       return memberId;
   }

   public String getName() {
       return name;
   }
}

// --------------------------------------------------
// StudentMember Class - Inheritance
// --------------------------------------------------
class StudentMember extends Person {
   private String department;
   private int issuedBooks;

   public StudentMember(int memberId, String name,
                   String phone, String department) {
       super(memberId, name, phone);
       this.department = department;
       this.issuedBooks = 0;
   }

   public int getIssuedBooks() {
       return issuedBooks;
   }

   public void increaseIssuedBooks() {
       issuedBooks++;
   }

   public void decreaseIssuedBooks() {
       if (issuedBooks > 0) {
           issuedBooks--;
       }
   }

   // Polymorphism - Method Overriding
   @Override
   void displayDetails() {
       System.out.println("Member ID : " + memberId);
       System.out.println("Name            : " + name);
       System.out.println("Phone          : " + phone);
       System.out.println("Department : " + department);
       System.out.println("Books Issued: " + issuedBooks);
       System.out.println("-------------------------------------");
   }
}

// --------------------------------------------------
// Interface
// --------------------------------------------------
interface LibraryOperations {
   void addBook();
   void registerMember();
   void displayBooks();
   void displayMembers();
   void searchBook();
   void issueBook();
   void returnBook();
}

// --------------------------------------------------
// Library Class
// --------------------------------------------------
class Library implements LibraryOperations {
   private ArrayList<Book> books = new ArrayList<>();
   private ArrayList<StudentMember> members = new ArrayList<>();
   private Scanner sc = new Scanner(System.in);

   // --------------------------------------------------
   // Add Book
   // --------------------------------------------------
   @Override
   public void addBook() {
      try {
         System.out.println("\n===== ADD BOOK =====");
         System.out.print("Enter Book ID: ");
         int id = Integer.parseInt(sc.nextLine());
         System.out.print("Enter Book Title: ");
         String title = sc.nextLine();
         System.out.print("Enter Author Name: ");
         String author = sc.nextLine();
         System.out.print("Enter Category: ");
         String category = sc.nextLine();
         books.add(new Book(id, title, author, category));
         System.out.println("Book added successfully!");
      } catch (Exception e) {
         System.out.println("Invalid input!");
      }
   }

   // --------------------------------------------------
   // Register Member
   // --------------------------------------------------
   @Override
   public void registerMember() {
      try {
         System.out.println("\n===== REGISTER MEMBER =====");
         System.out.print("Enter Member ID: ");
         int id = Integer.parseInt(sc.nextLine());
         System.out.print("Enter Member Name: ");
         String name = sc.nextLine();
         System.out.print("Enter Phone Number: ");
         String phone = sc.nextLine();
         System.out.print("Enter Department: ");
         String department = sc.nextLine();
         members.add(new StudentMember(id, name, phone, department));
         System.out.println("Member registered successfully!");
      } catch (Exception e) {
         System.out.println("Invalid input!");
      }
   }

   // --------------------------------------------------
   // Display Books
   // --------------------------------------------------
   @Override
   public void displayBooks() {
      System.out.println("\n========== BOOK LIST ==========");
      if (books.isEmpty()) {
         System.out.println("No books available.");
         return;
      }
      for (Book book : books) {
         book.displayBook();
      }
   }

   // --------------------------------------------------
   // Display Members
   // --------------------------------------------------
   @Override
   public void displayMembers() {
      System.out.println("\n========== MEMBER LIST ==========");
      if (members.isEmpty()) {
         System.out.println("No members registered.");
         return;
      }
      for (StudentMember member : members) {
         member.displayDetails();
      }
   }

   // --------------------------------------------------
   // Search Book
   // --------------------------------------------------
   @Override
   public void searchBook() {
      System.out.println("\n========== SEARCH BOOK ==========");
      System.out.print("Enter title or author to search: ");
      String keyword = sc.nextLine().toLowerCase();
      boolean found = false;
      for (Book book : books) {
         if (book.getTitle().toLowerCase().contains(keyword)
                 || book.getAuthor().toLowerCase().contains(keyword)) {
            book.displayBook();
            found = true;
         }
      }
      if (!found) {
         System.out.println("Book not found.");
      }
   }

   // --------------------------------------------------
   // Issue Book
   // --------------------------------------------------
   @Override
   public void issueBook() {
      try {
         System.out.println("\n========== ISSUE BOOK ==========");
         System.out.print("Enter Book ID: ");
         int bookId = Integer.parseInt(sc.nextLine());
         System.out.print("Enter Member ID: ");
         int memberId = Integer.parseInt(sc.nextLine());
         Book selectedBook = null;
         StudentMember selectedMember = null;

         // Search Book
         for (Book book : books) {
            if (book.getBookId() == bookId) {
               selectedBook = book;
               break;
            }
         }

         // Search Member
         for (StudentMember member : members) {
            if (member.getMemberId() == memberId) {
               selectedMember = member;
               break;
            }
         }

         if (selectedBook == null) {
            System.out.println("Book ID not found.");
            return;
         }
         if (selectedMember == null) {
            System.out.println("Member ID not found.");
            return;
         }
         if (!selectedBook.isAvailable()) {
            System.out.println("Book is already issued.");
            return;
         }
         // Maximum 3 books
         if (selectedMember.getIssuedBooks() >= 3) {
            System.out.println("Member cannot issue more than 3 books.");
            return;
         }

         selectedBook.setAvailable(false);
         selectedMember.increaseIssuedBooks();
         System.out.println("Book issued successfully!");
         System.out.println("Book : " + selectedBook.getTitle());
         System.out.println("Member : " + selectedMember.getName());
      } catch (Exception e) {
         System.out.println("Invalid input!");
      }
   }

   // --------------------------------------------------
   // Return Book
   // --------------------------------------------------
   @Override
   public void returnBook() {
      try {
         System.out.println("\n========== RETURN BOOK ==========");
         System.out.print("Enter Book ID: ");
         int bookId = Integer.parseInt(sc.nextLine());
         System.out.print("Enter Member ID: ");
         int memberId = Integer.parseInt(sc.nextLine());
         Book selectedBook = null;
         StudentMember selectedMember = null;

         // Search book
         for (Book book : books) {
            if (book.getBookId() == bookId) {
               selectedBook = book;
               break;
            }
         }

         // Search member
         for (StudentMember member : members) {
            if (member.getMemberId() == memberId) {
               selectedMember = member;
               break;
            }
         }

         if (selectedBook == null) {
            System.out.println("Book ID not found.");
            return;
         }
         if (selectedMember == null) {
            System.out.println("Member ID not found.");
            return;
         }
         if (selectedBook.isAvailable()) {
            System.out.println("This book has not been issued.");
            return;
         }

         selectedBook.setAvailable(true);
         selectedMember.decreaseIssuedBooks();
         System.out.println("Book returned successfully!");
         System.out.println("Book : " + selectedBook.getTitle());
         System.out.println("Member : " + selectedMember.getName());
      } catch (Exception e) {
         System.out.println("Invalid input!");
      }
   }
}

// --------------------------------------------------
// Main Class
// --------------------------------------------------
public class LibraryManagementSystem {

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      Library library = new Library();
      int choice = 0;

      System.out.println("======================================");
      System.out.println("       LIBRARY MANAGEMENT SYSTEM");
      System.out.println("======================================");

      do {
         System.out.println("\n----------- MENU -----------");
         System.out.println("1. Add Book");
         System.out.println("2. Register Member");
         System.out.println("3. Display Books");
         System.out.println("4. Display Members");
         System.out.println("5. Search Book");
         System.out.println("6. Issue Book");
         System.out.println("7. Return Book");
         System.out.println("8. Exit");
         System.out.println("----------------------------");

         try {
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
               case 1:
                  library.addBook();
                  break;
               case 2:
                  library.registerMember();
                  break;
               case 3:
                  library.displayBooks();
                  break;
               case 4:
                  library.displayMembers();
                  break;
               case 5:
                  library.searchBook();
                  break;
               case 6:
                  library.issueBook();
                  break;
               case 7:
                  library.returnBook();
                  break;
               case 8:
                  System.out.println("Thank you for using the Library Management System!");
                  break;
               default:
                  System.out.println("Invalid choice! Please try again.");
            }
         } catch (Exception e) {
            System.out.println("Please enter a valid number.");
         }
      } while (choice != 8);

      sc.close();
   }
}
