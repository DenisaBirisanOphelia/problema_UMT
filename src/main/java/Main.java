import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public  static int checkPass(String pass)
    { int numberOfChanges=0;

        if (pass.length()<6)
        {
            numberOfChanges+=6-pass.length();
        }
        if (pass.length()>20)
        {
            numberOfChanges+=pass.length()-20;
        }

        //verific daca contine un lowercase
        Pattern pattern = Pattern.compile(".*[a-z].*");
        Matcher matcher = pattern.matcher(pass);
        if (!matcher.matches()) numberOfChanges++;

        //verific daca contine un uppercase
        Pattern pattern1 = Pattern.compile(".*[A-Z].*");
        Matcher matcher1 = pattern1.matcher(pass);
        if (!matcher1.matches()) numberOfChanges++;

        //verific daca contine un digit
        Pattern pattern2 = Pattern.compile(".*[0-9].*");
        Matcher matcher2 = pattern2.matcher(pass);
        if (!matcher2.matches()) numberOfChanges++;

        //verific daca matches 3 characters in a row=>not good
        Pattern pattern3 = Pattern.compile("(.)\\1{2}");
        Matcher matcher3 = pattern3.matcher(pass);
        if (matcher3.find()) numberOfChanges++;

        return numberOfChanges;
    }
    public static void main(String[] args)
    {
        String pass="12";
         int numberOfChangesCurrent=checkPass(pass);
        System.out.println("Nr schimbari necesare pentru a face parola Strong este:"+numberOfChangesCurrent);

    }
}
