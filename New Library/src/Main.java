
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        while (true) {
            Manager.menu();
            int choice = Validation.checkInputIntLimit(1, 20);
            switch (choice) {
                case 1:
                    String filename = Validation.checkInputString();
                    try {
                        Manager.loadDataFromFile(filename);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    Manager.inputAddReadertoEnd();
                    break;
                case 3:
                    Manager.displayBookData();
                    break;
                case 4:
                    String name = Validation.checkInputString();
                    try {
                        Manager.saveBookFile(name);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 5:
                    String bcode = Validation.checkInputString();
                    Manager.searchByBcode(bcode);
                    break;
                case 6:
                    String code = Validation.checkInputString();
                    Manager.deleteByBcode(code);
                    break;
                case 7:
                    Manager.sortBookByBcode();
                    break;
                case 8:
                    Manager.inputAddtoBeginning();
                    break;
                case 9:
                    Book b = Manager.inputBook();
                    Manager.addProductIndex(b, choice);
                    break;
                case 10:
                    int idx = Validation.checkInputInt();
                    Manager.deleteBookByIndex(idx);
                    break;
                case 11:
                    String f = Validation.checkInputString();
                    try {
                        Manager.loadReaderFromFile(f);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 12:
                    Manager.inputAddReadertoEnd();
                    break;
                case 13:
                    Manager.displayReaderData();
                    break;
                case 14:
                    String n = Validation.checkInputString();
                    try {
                        Manager.saveReaderFile(n);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 15:
                    String rcode = Validation.checkInputString();
                    Manager.searchByRcode(rcode);
                    break;
                case 16:
                    String r = Validation.checkInputString();
                    Manager.deleteByRcode(r);
                    break;
                case 17:
                    try {
                        Manager.inputLending();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 18:
                    try {
                        Manager.displayLending();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 19:
                    //sort by B-code and Rcode
                    try {
                        Manager.sortLending();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 20:
                    System.out.println("Thank you for using our system!");
                    break;
            }
                    
        }
        
    }
    
}
