import java.io.IOException;

public class Box {
    
    private int getStrLen(String... strings){
        int len = Integer.MIN_VALUE;
        for (String str : strings){
            len = Math.max(str.length(), len);
        }
        return len;
    }

    private String padString(String str, int len) {
        StringBuilder sb = new StringBuilder(str);
        return sb.append(fill(' ', len - str.length())).toString();
    }

    private String fill(char ch, int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            sb.append(ch);
        }
        return sb.toString();
    }

    public void printBox(String... strings) {
        int maxBoxWidth = getStrLen(strings);
        String line = "+" + fill('-', maxBoxWidth + 2) + "+";
        System.out.println(line);
        for (String str : strings) {
            System.out.printf("| %s |%n", padString(str, maxBoxWidth));
        }
        System.out.println(line);
    }

    public void printTopLine(String... strings) {
        int maxBoxWidth = getStrLen(strings);
        String line = "+" + fill('-', maxBoxWidth + 2) + "+";
        System.out.println(line);
        for (String str : strings) {
            System.out.printf("%s %n", padString(str, maxBoxWidth));
        }
    }

    public void enterToContinue() {
        System.out.print("\nPress \"ENTER\" to continue...");
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
        clearConsole();
    }

    public void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            else {
                System.out.print("\033\143");
            }
        } catch (IOException | InterruptedException ex) {}
    }
}
