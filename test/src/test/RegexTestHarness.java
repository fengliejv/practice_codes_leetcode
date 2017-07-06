package test;


import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegexTestHarness {
	@SuppressWarnings({ "resource", "unused" })
	public static void main(String[] args){
      
		Scanner scanner = new Scanner(System.in);
        if (scanner == null) {
            System.err.println("No scannner.");
            System.exit(1);
        }
        while (true) {
        	System.out.println("\nEnter your regex: ");
            Pattern pattern = Pattern.compile(scanner.nextLine());
            System.out.println("Enter input string to search: ");
            Matcher matcher = pattern.matcher(scanner.nextLine());

            boolean found = false;
            while (matcher.find()) {
                System.out.println("I found the text\t" +matcher.group()+
                    "\tstarting at	index\t" +
                    +  matcher.start()+"\tand ending at index\t"+ matcher.end() );
                found = true;
            }
            if(!found){
               System.out.print("No match found.\n");
            }
        }
    }
}
