import java.io.File;
import java.util.Scanner;

public class MemberLogin {
    public boolean verifyLogin(String username, String password, String filepath){
        boolean found = false;
        String tempUsername = "";
        String tempPassword = "";

        try {
            Scanner x;
            x = new Scanner(new File(filepath));
            x.useDelimiter("[,\n]");

            while (x.hasNext()&& !found) {
                tempUsername = x.next();
                tempPassword = x.next();

                if (tempUsername.trim().equals(username.trim())&&tempPassword.trim().equals(password.trim())) {
                    found = true;
                }
            }
            x.close();
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }

        return found;
    }

    public int verifyLogin2(String username, String password, String filepath){
        boolean found = false;
        String tempUsername = "";
        String tempPassword = "";
        int count = 0;

        try {
            Scanner x;
            x = new Scanner(new File(filepath));
            x.useDelimiter("[,\n]");

            while (x.hasNext()&& !found) {
                tempUsername = x.next();
                tempPassword = x.next();

                if (tempUsername.trim().equals(username.trim())&&tempPassword.trim().equals(password.trim())) {
                    found = true;
                }
                count++;
            }
            x.close();
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }

        return count;
    }
}
