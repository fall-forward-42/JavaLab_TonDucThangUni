package ex4;

import org.apache.commons.io.FileUtils;
import org.apache.commons.validator.routines.UrlValidator;

import java.io.File;
import java.net.URL;
import java.util.Scanner;

public class Programe {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("please input the URL: ");
        String input = sc.nextLine();
        sc.close();

        UrlValidator validator = new UrlValidator(new String[] {"http","https"}, UrlValidator.ALLOW_ALL_SCHEMES);

        if(input.isEmpty()){
            System.out.println("please give URL to download files");
            return;
        }
        else if(!validator.isValid(input)){
            System.out.println("Invalid URL !");
            return;
        }
        try {
            File file = new File("file.html");
            URL url = new URL(input);
            FileUtils.copyURLToFile(url,file);
            System.out.println("Download files successfully !");

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
