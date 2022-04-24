
//import statements

import com.tirth.library.Book;
import java.util.Scanner;
import java.io.Serializable;


// class declaration

public class Main_AddBook implements Serializable{
    public static void main(String[]args) throws Exception {
        // Scanner creation
        Scanner book_scan = new Scanner(System.in);
        // variable declarations
    String Title = "";
    String Author = "";
    Float Price = null;
    Integer Quantity= null;

        //try catch for data validation

        try {
            System.out.println("What is the Title (Ex.The Great Gatsby): ");
            Title = book_scan.nextLine();
            System.out.println("What is the authors name (Ex.F Scott Fitzgerald): ");
            Author = book_scan.nextLine();
            System.out.println("What is the Price (Ex.20.00): ");
            Price = book_scan.nextFloat();
            System.out.println("What is the Quantity (Ex.5): ");
            Quantity = book_scan.nextInt();
            Book book = new Book(Title, Author, Price, Quantity);
        }
        //Throws exception is invalid data type is entered

        catch (NumberFormatException E) {
            System.out.println(E.getMessage());
        }

    }
}









