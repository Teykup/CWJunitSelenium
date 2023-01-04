package maven;

public class substring {
    public static void main(String[] args) {


        String a = "1-16 of over 1,000 results for \"Selenium\"";
        System.out.println(a.replaceAll("\\D", "").substring(3));

    }
}
