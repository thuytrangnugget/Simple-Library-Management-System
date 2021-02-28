
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;


/**
 *
 * @author Thuy Trang nugget
 */
public class Manager {
    
    public static MyList<Book> bookList = new MyList<Book>();
    public static MyList<Reader> readerList = new MyList<Reader>();
    public static MyList<Lending> lendingList = new MyList<Lending>();

    static void inputLending() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    static void displayLending() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    static void sortLending() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public Manager() {
    }
    static void menu() {
        System.out.println("=========== WELCOME TO MY LIBRARY ===========");
        System.out.println("Book list:");
        System.out.println("1. Load data from file");
        System.out.println("2. Input & add to the end");
        System.out.println("3. Display data");
        System.out.println("4. Save book list to file");
        System.out.println("5. Search by bcode");
        System.out.println("6. Delete by bcode");
        System.out.println("7. Sort by bcode");
        System.out.println("8. Input & add to beginning");
        System.out.println("9. Add after position k");
        System.out.println("10. Delete position key");
        System.out.println("-------------------------");
        System.out.println("Reader list: ");
        System.out.println("11. Load data from file");
        System.out.println("12. Input & add to the end");
        System.out.println("13. Display data");
        System.out.println("14. Save reader list to file");
        System.out.println("15. Search by rcode");
        System.out.println("16. Delete by rcode");
        System.out.println("--------------------------");
        System.out.println("17. Input data");
        System.out.println("18. Display data");
        System.out.println("19. Sort by bcode + rcode");
        System.out.println("20. Exit");
    }
    
    static void writeBookFile(String filename, ArrayList<Book> b) {
        try {
            File f = new File(filename);
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (int i = 0; i < b.size(); i++) {
                oos.writeObject(b.get(i));
            }
            System.out.println("Save data to file " + filename + "successfully");
            oos.flush();
            oos.close();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
   static ArrayList<Book> readBookFromFile(String filename) {
        ArrayList<Book> book = new ArrayList<>();
        try {
            File f = new File(filename);
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            boolean cont = true;
            while (cont) {
                Book a = (Book) ois.readObject();
                if (a != null) {
                    book.add(a);
                } else {
                    cont = false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return book;
    }
    
    static void loadDataFromFile(String filename) throws Exception {
        try {
            String currentDir = System.getProperty("user.dir");
            currentDir = currentDir + filename;
            FileReader fr = new FileReader(currentDir);
            BufferedReader br = new BufferedReader(fr);
            String[] arr;
            String s, bcode, title;
            int quantity;
            double price;
            while (true) {
                s = br.readLine();
                if (s == null || s.trim().length() < 3) {
                    break;
                }
                arr = s.split("[|]");
                bcode = arr[0].trim();
                title = arr[1].trim();
                quantity = Integer.parseInt(arr[2].trim());
                price = Double.parseDouble(arr[3].trim());
                bookList.addLast(new Book(bcode, title, price, quantity));
            }
            fr.close();
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void saveBookFile(String filename) throws IOException {
        String currentDir = System.getProperty("user.dir");
        currentDir = currentDir + "";
        FileWriter fw = new FileWriter(currentDir);
        PrintWriter pw = new PrintWriter(fw);
        for (int i = 0; i < bookList.size(); i++) {
            pw.printf("%5s | %10s  | %3d  | %8.2f\r\n", bookList.get(i).bcode,
                    bookList.get(i).title, bookList.get(i).quantity, bookList.get(i).price);
        }
        pw.close();
        fw.close();
    }
    
    public static boolean checkExistBook(String bcode) {
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getBcode().equals(bcode)) {
                return true;
            }
        }
        return false;
    }
    
    static Book inputBook() {
        Book b = null;
        System.out.println("Enter bcode: ");
        String bcode = Validation.checkInputString();
        if (!checkExistBook(bcode)) {
            System.out.println("Enter book name: ");
            String title = Validation.checkInputString();
            System.out.println("Enter quantity: ");
            int quantity = Validation.checkInputInt();
            System.out.println("Enter price: ");
            double price = Validation.checkInputDouble();
            b = new Book(bcode, title, price, quantity);
            System.out.println("Add new book successfully!");
        } else {
            System.err.println("Bcode exist!");
        }
        return b;
    }
    
    static void inputAddtoEnd() {
        System.out.println("Enter bcode: ");
        String bcode = Validation.checkInputString();
        if (!checkExistBook(bcode)) {
            System.out.println("Enter book name: ");
            String title = Validation.checkInputString();
            System.out.println("Enter quantity: ");
            int quantity = Validation.checkInputInt();
            System.out.println("Enter price: ");
            double price = Validation.checkInputDouble();
            bookList.addLast(new Book(bcode, title, price, quantity));
            System.out.println("Add new book successfully!");
        } else {
            System.err.println("Bcode exist!");
        }
    }

    public static MyList<Book> getBookList() {
        return bookList;
    }

    public static void setBookList(MyList<Book> bookList) {
        Manager.bookList = bookList;
    }

    public static MyList<Reader> getReaderList() {
        return readerList;
    }

    public static void setReaderList(MyList<Reader> readerList) {
        Manager.readerList = readerList;
    }

    public static MyList<Lending> getLendingList() {
        return lendingList;
    }

    public static void setLendingList(MyList<Lending> lendingList) {
        Manager.lendingList = lendingList;
    }
    
    static void displayBookData() {
        MyList<Book> bookList = Manager.getBookList();
        if (bookList.isEmpty()) {
            System.err.println("List is empty!");
            return;
        }
        System.out.printf("%8s|%15s|%7d|%8.2f|%10.2f\n", "Bcode", "Title", "Quantity", "Price", "Value");
        System.out.println("----------------------------------------------");
        for (int i = 0; i < bookList.size(); i++) {
            Book b = bookList.get(i);
            System.out.printf("%8s|%15s|%7d|%8.2f|%10.2f\n", b.getBcode(), b.getTitle(), b.getQuantity(), b.getPrice(), b.getQuantity() * b.getPrice());
        }
    }
    
    public static int indexByBcode(String bcode) {
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getBcode().equals(bcode)) {
                return i;
            }
        }
        return -1;
    }
    
    static void searchByBcode(String bcode) {
        int position = indexByBcode(bcode);
        if (position != -1) {
            System.out.println("Found book with code " + bcode + " at index " + position);
        } else {
            System.out.println("Not found");
        }
    }
    
    public static void deleteBookByIndex(int index) {
        bookList.delIndex(index);
    }
    
    static void deleteByBcode(String bcode) {
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getBcode().equals(bcode)) {
                bookList.delIndex(i);
                System.out.println("Delete successful");
                return;
            }
        }
    }
    
    static void sortBookByBcode() {
        for (int i = 0; i < bookList.size() - 1; i++) {
            for (int j = i + 1; j < bookList.size(); j++) {
                if (bookList.get(i).getBcode().compareTo(bookList.get(j).getBcode()) > 0) {
                    Book temp = bookList.get(i);
                    bookList.set(i, bookList.get(j));
                    bookList.set(j, temp);
                }
            }

        }
        System.out.println("Sort success");
    }
    
    static void inputAddtoBeginning() {
        System.out.println("Enter bcode: ");
        String bcode = Validation.checkInputString();
        if (!checkExistBook(bcode)) {
            System.out.println("Enter book name: ");
            String title = Validation.checkInputString();
            System.out.println("Enter quantity: ");
            int quantity = Validation.checkInputInt();
            System.out.println("Enter price: ");
            double price = Validation.checkInputDouble();
            bookList.addFirst(new Book(bcode, title, price, quantity));
            System.out.println("Add new book successfully!");
        } else {
            System.err.println("Bcode exist!");
        }
    }
    
    public static void addProductIndex(Book book, int index) {
        if (index > bookList.size()) {
            System.err.println("Please try again");
        } else {
            bookList.addIndex(book, index);
            System.err.println("Add success");
        }
    }
    
    public static void deleteProductByIndex(int index) {
        bookList.delIndex(index);
    }
    
    static void loadReaderFromFile(String filename) throws Exception {
        String currentDir = System.getProperty("user.dir");
        currentDir = currentDir + filename;
        FileReader fr = new FileReader(currentDir);
        BufferedReader br = new BufferedReader(fr);
        String[] arr; 
        String s, rcode, name;
        int byear;
        while (true) {
            s = br.readLine();
            if (s == null || s.trim().length() < 3) {
                break;
            }
            arr = s.split("[|]");
            rcode = arr[0].trim();
            name = arr[1].trim();
            byear = Integer.parseInt(arr[2].trim());
            readerList.addLast(new Reader(rcode, name, byear));
        }
        fr.close();
        br.close();
    }
    
    public static boolean checkExistReader(String bcode) {
        for (int i = 0; i < readerList.size(); i++) {
            if (readerList.get(i).getRcode().equals(bcode)) {
                return true;
            }
        }
        return false;
    }
    
    static void inputAddReadertoEnd() {
        System.out.println("Enter rcode: ");
        String rcode = Validation.checkInputString();
        if (!checkExistReader(rcode)) {
            System.out.println("Enter reader name: ");
            String title = Validation.checkInputString();
            System.out.println("Enter birthyear: ");
            int price = Validation.checkInputInt();
            readerList.addLast(new Reader(rcode, title, price));
            System.out.println("Add new reader successfully!");
        } else {
            System.err.println("Reader exist!");
        }
    }
    
    static void displayReaderData() {
        MyList<Reader> readerList = Manager.getReaderList();
        if (bookList.isEmpty()) {
            System.err.println("List is empty!");
            return;
        }
        System.out.printf("%8s|%15s|%7d\n", "Rcode", "Name", "Birth year");
        System.out.println("----------------------------------------------");
        for (int i = 0; i < readerList.size(); i++) {
            Reader b = readerList.get(i);
            System.out.printf("%8s|%15s|%7d\n", b.getRcode(), b.getName(), b.getByear());
        }
    }
    
    public static void saveReaderFile(String filename) throws IOException {
        String currentDir = System.getProperty("user.dir");
        currentDir = currentDir + "";
        FileWriter fw = new FileWriter(currentDir);
        PrintWriter pw = new PrintWriter(fw);
        for (int i = 0; i < readerList.size(); i++) {
            pw.printf("%5s | %10s  | %3d ", readerList.get(i).rcode,
                    readerList.get(i).name, readerList.get(i).byear);
        }
        pw.close();
        fw.close();
    }
    
     public static int indexByRcode(String rcode) {
        for (int i = 0; i < readerList.size(); i++) {
            if (readerList.get(i).getRcode().equals(rcode)) {
                return i;
            }
        }
        return -1;
    }
    
    static void searchByRcode(String rcode) {
        int position = indexByBcode(rcode);
        if (position != -1) {
            System.out.println("Found reader with code " + rcode + " at index " + position);
        } else {
            System.out.println("Not found");
        }
    }
    
    public static void deleteReaderByIndex(int index) {
        readerList.delIndex(index);
    }
    
    static void deleteByRcode(String rcode) {
        for (int i = 0; i < readerList.size(); i++) {
            if (readerList.get(i).getRcode().equals(rcode)) {
                readerList.delIndex(i);
                System.out.println("Delete successful");
                return;
            }
        }
    }
    
    
}   