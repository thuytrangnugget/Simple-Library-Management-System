
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;



class Author {
    public String name;
    public BookList<Book> books =  new BookList<Book>();
    public Author() {}
    
    public boolean equals(Object node) {
        return name.equals(((Author) node).name);
    }
    
    public void display() {
        System.out.println(name);
        books.display();
    }
}

class Book implements Comparable<Book>{
    public String bcode;
    public String title;
    public Reader reader = null;
    public double price;
    //state = 0: not given to the reader
    //state = 1: still at reader, not given back
    //state = 2: given back to the library
    public int state;

    public Book() {
    }

    public Book(String bcode, String title, double price) {
        this.bcode = bcode;
        this.title = title;
        this.price = price;
        this.state = 0;
    }
    
    public boolean equals(Object node) {
        return title.equals(((Book) node).title);
    }

    @Override
    public String toString() {
        return "  *" + title + (reader != null ? " - checked out to " + reader.name : "") + "\n";
    }
    
    public int compareTo(Book t) {
        return this.bcode.compareTo(t.bcode);
    }

}

class Lending {
    public Author author = null;
    public Book book = null;
    public Lending() {}
    
    public boolean equals(Object node) {
        return book.title.equals(((Lending) node).book.title) && author.name.equals(((Lending) node).author.name);
    }

    @Override
    public String toString() {
        return "  *" + author.name + ", " + book.title + "\n";
    }
}


class Reader implements Comparable<Reader>{
    public String rcode;
    public String name;
    //Birth year
    public int byear;
    public BookList<Lending> books = new BookList<Lending>();

    public Reader() {
    }

    public Reader(String rcode, String name, int byear) {
        try {
            if (byear < 1900 || byear > 2010) {
                throw new NumberFormatException("Reader's birth year must be between 1900 and 2010");
            }
            this.rcode = rcode;
            this.name = name;
            this.byear = byear;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return;
        }
    }
    
    public boolean equals(Object node) {
        return name.equals(((Patron) node).name);
    }
    
    public void display() {
        if (!books.isEmpty()) {
            System.out.println(name + " has the following books:");
            books.display();
        } else {
            System.out.println(name + " has no books");
        }
    }
    
    public int compareTo(Reader r) {
        return this.rcode.compareTo(r.rcode);
    }
}



class AuthorList extends LinkedList<Author> {
    static final long serialVersionUID =  123;

    public AuthorList() {
        super();
    }
    
    public void display() {
        Object[] authors = toArray();
        for (int i = 0; i < authors.length; i++) {
            ((Author)authors[i]).display();
        }
    }
}



class BookList<T> extends LinkedList<T> {
    static final long serialVersionUID = 124;
    public BookList() {
        super();
    }
    public void display() {
        for (int i = 0; i < size(); i++)
            System.out.println(get(i));
    }
    
    void loadData() {}
    
    void inputToTail() {}
    
    void inputToHead() {}
    
    void saveToFile() {}
    
    void searchByBcode() {}
    
    void sortByBcode() {}
    
    void addAfterPositionK() {}
    
    void deletePositionK() {}
}



class ReaderList extends LinkedList<Reader> {
    static final long serialVersionUID = 125;
    public ReaderList() {
        super();
    }
    public void display() {
        for (java.util.Iterator it = iterator(); it.hasNext();) {
            ((Reader)it.next()).display();
        }
    }
    
    void loadDataFromFile() {}
    
    void inputToTail() {}
    
    void saveToFile() {}
    
    void searchByRcode() {}
    
    void deleteByRcode() {}
    
    void sortByRcode() {}
}


public class Library {
    private ArrayList<AuthorList> catalog = new ArrayList<AuthorList>('Z'+1); 
    private ArrayList<ReaderList> people = new ArrayList<ReaderList>('Z'+1);
    private String input;
    Scanner kb = new Scanner(System.in);

    public Library() {
        for (int i = 0; i <= 'Z'; i++) {
            catalog.add(i, new AuthorList());
            people.add(i, new ReaderList());
        }
    }
    
    private String getString(String msg) {
        System.out.println(msg + " ");
        System.out.flush();
        input = kb.nextLine();
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }
    
    private void status() {
    
    }
}
