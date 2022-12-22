import java.util.Scanner;
import java.util.StringTokenizer;
import java.lang.String;
import java.util.ArrayList;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("HELLO");
        System.out.println("Введите первую строку:");
        String first_str = input.nextLine();
        System.out.println("Введите строку разделителей:");
        String second_str = input.nextLine();
        System.out.println("Введите число для поиска:");
        String P = input.nextLine();


        String[] newString = new String[Count(first_str, second_str)];
        int count = 0;
        if (second_str.length() == 1) {
            newString = first_str.split(second_str);
            System.out.print("Split: ");
            for (String s : newString) {
                System.out.print(s + " ");
                count++;
            }

        } else {
            System.out.println("Tokenizer: ");
            StringTokenizer tokenizer = new StringTokenizer(first_str, second_str);
            for (int i = 0; tokenizer.hasMoreTokens(); i++) {
                newString[i] = tokenizer.nextToken();
                System.out.println(newString[i]);
                count++;
            }
        }

        System.out.println();


        first_str = String.join("", newString);
        String[] massCount2 = new String[first_str.length()];
        int count_mass = 0;
        System.out.println();
        char[] charstr = new char[first_str.length()];
        first_str.getChars(0, first_str.length(), charstr, 0);

        System.out.println("Числа из 2-ой с/с в 10-ой с/c: ");
        for(int i = 0; i < count; i++){
            try {
                int temp = 0;
                temp = Integer.parseInt(newString[i], 2);
                massCount2[count_mass] = newString[i];
                count_mass++;
                System.out.println(temp);
            } catch (NumberFormatException e) {
            }
        }


        ArrayList<String> strList = new ArrayList<String>();
        for(int i = 0; i < count; i++) {
            strList.add(newString[i]);
        }
        String Lexem= "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM1234567890";
        String[] array_token = new String[100];
        int token_size =0;
        System.out.println("Лексемы, состоящие из цифр и из символов латинского алфавита:");
        for (String g : strList) {
            boolean suit = true;
            for (int j = 0; j < g.length(); ++j) {
                if (Lexem.indexOf(g.charAt(j)) == -1) {
                    suit = false;
                    break;
                }
            }
            if (suit) {
                array_token[token_size++] = g;
                System.out.println(String.format("%s", g));
            }
        }
        System.out.println(" ");


        boolean flag = false;
        System.out.println();
        for (int i = 0; i < count; i++) {
            if (newString[i].equals(P)) {
                String x = "%s %s %s %d %s %d";
                System.out.println(String.format(x, "Число ", P, " занимает позицию с",(first_str.indexOf(P)+ 1),"по",(first_str.indexOf(P)+P.length())));
                flag = true;
            }
        }
        if (!flag) System.out.println("Элемента " + P + " среди лексем нет");


        Integer tmp = Integer.parseInt(P, 10);
        Integer x;
        x=tmp*tmp;
        System.out.println();
        System.out.println(String.format("Строка без последнего числа в 2 c/c: " + first_str.replace(massCount2[count_mass-1], "")));
        System.out.println (String.format("substring: " + first_str.substring(first_str.lastIndexOf(P))));
        //System.out.println("remove:");

        System.out.println();
        StringBuffer StrBuffer = new StringBuffer();
        StrBuffer.append(first_str);
        StrBuffer.insert(newString[0].length(), x.toString());
        System.out.println(String.format("квадрат P после первого элемента (insert): " + StrBuffer));
        StrBuffer.delete(1, 2);
        System.out.println (String.format("delete: " + StrBuffer));
        StrBuffer.reverse();
        System.out.println(String.format("reverse: " + StrBuffer));

        Collections.sort(strList, (s1, s2) -> s1.charAt(s1.length()-1) - s2.charAt(s2.length()-1));
        System.out.print("Отсортированная строка по последнему элементу: " + strList);
    }

    public static int Count(String str, String razdel) {
        String[] newString = new String[str.length()];
        StringTokenizer tokenizer = new StringTokenizer(str, razdel);
        int count = 0;
        for (int i = 0; tokenizer.hasMoreTokens(); i++) {
            newString[i] = tokenizer.nextToken();
            count++;
        }
        return count;
    }
}