import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

class UseDictionnary {

    private static String cleanWord(String word){
        word = word.toLowerCase();
        word = word.replaceAll("[^a-z]","");
        return word;
    }

    private static void loadLine(Trie dictionnary, String line) {
        //use a second Scanner to parse the content of each line
        Scanner scanner = new Scanner(line);
        scanner.useDelimiter(" ");

        while (scanner.hasNext()){
            String word = cleanWord(scanner.next());

            if (word.length() > 0){
                dictionnary.insertWord(word);
            }

        }
    }

    public static void main(String[] args){
        String dictionnaryPath = args[0];

        Trie dictionnary = new Trie();

        try {
            Scanner scanner = new Scanner(new File(dictionnaryPath));
            while (scanner.hasNextLine()){
                loadLine(dictionnary, scanner.nextLine());
            }
        }
        catch (FileNotFoundException e) {
            return;
        }
        System.out.println("Total number of words in text: "+ dictionnary.getTotalLength());
        System.out.println("Count of different words loaded: "+ dictionnary.getLength());

        while (true) {
            System.out.println("Type Q anytime you want to quit");

            System.out.println("Type a word: ");
            Scanner sc = new Scanner(System.in);
            String word = sc.next();

            if (word.equals("Q")){
                System.out.println("OK, bye!");
                return;
            }


            if (dictionnary.has(word)){
                System.out.println("Yup, " + word + " is in the dictionnary !");
            }
            else {
                System.out.println("Nope, " + word + " is not in the dictionnary !");
            }

        }
    }
}
