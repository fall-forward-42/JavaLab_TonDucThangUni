package ex2;
import vn.edu.tdtu.*;


public class Program2 {
    public static void main(String[] args) {
        int a[] = {3,56,1,3,32,12,43,56,34,76,45,87,67,99};
        int b[] = {12,34,24,54,64};
        int c[] = ArrayHandler.merge(a,b);
        ArrayOutput.print(c);
        ArrayHandler.sort(c);
        ArrayOutput.print(c);
        ArrayOutput.write(c,"sortArray.txt");
    }
}
