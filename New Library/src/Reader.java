
import java.util.LinkedList;


public class Reader implements Comparable<Reader>{
    public String rcode;
    public String name;
    //Birth year
    public int byear;

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
        return name.equals(((Reader) node).name);
    }
    
    public int compareTo(Reader r) {
        return this.rcode.compareTo(r.rcode);
    }

    public String getRcode() {
        return rcode;
    }

    public void setRcode(String rcode) {
        this.rcode = rcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getByear() {
        return byear;
    }

    public void setByear(int byear) {
        this.byear = byear;
    }
    
    
}



