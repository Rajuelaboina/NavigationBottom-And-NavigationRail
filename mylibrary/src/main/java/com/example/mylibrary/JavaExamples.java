package com.example.mylibrary;

public class JavaExamples {
    public static void main(String[] args){
        // String reverse
       /* String str = "welcome"; String reverse = "";
        char ch;
        for (int i = 0; i < str.length(); i++) {
              ch = str.charAt(i);
              reverse = ch+reverse;
        }
        System.out.println(reverse);*/


     /*  String str = "welcome";
       StringBuffer sb = new StringBuffer(str);
       // sb.reverse();
        System.out.println("this is String Reverse: "+sb.reverse());
        for (int i = str.length()-1; i >=0; i--) {
            System.out.print(str.charAt(i));
        }
        System.out.println();
        String strRev = "";
        for (int i = 0; i < str.length(); i++) {
            strRev = strRev+str.charAt(i);
        }
        System.out.print(strRev);*/

        // Anagram of String
        /*String str1 = "Bored";
        str1 = str1.toLowerCase();
        String str2 = "Robed";
        str2 = str2.toLowerCase();
        if(str1.length() == str2.length()){
            char[] ch1 = str1.toCharArray();
            char[] ch2 = str2.toCharArray();
            Arrays.sort(ch1);
            Arrays.sort(ch2);
            boolean b = Arrays.equals(ch1,ch1);
            if (b){
                System.out.println("this string is  anagram");
            }else {
                System.out.println("this string is not anagram");

            }
        }*/
        //--------- fibonacci series --------------
        /*int n1=0,n2 =1,n3;
        int num = 5;
         System.out.print(n1+" "+n2);
        for (int i = 0; i < num; i++) {
              n3 = n1+n2;
              System.out.print(" "+ n3);
              n1=n2;
              n2=n3;
        }*/
        // -------- palindrome -----------
        /*int num =131;
        int r,sum=0, temp;
        temp = num;
        while (num>0){
            r = num%10;
            sum = (sum*10)+r;
            num = num/10;
        }
        if (temp == sum){
            System.out.println("this is palindrome");
        }else {
            System.out.println("this is not palindrome");
        }*/
        // String duplicate char of count
       /* String str ="hello";
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'l'){
                count++;
            }
        }
        System.out.println("num of 'l' char = "+ count);*/

        // String Duplicates count
       /* String str = "welcome to java class";
        char[] ch = str.toCharArray();
        int count ;
        for (int i = 0; i < ch.length; i++) {
            count =1;
            for (int j = i+1; j < ch.length; j++) {
                if (ch[i]== ch[j] && ch[i] != ' '){
                    ch[j] = '0';
                    count++;
                }
            }
            if (count > 1 && ch[i] !='0'){
                System.out.println("count of duplicate char "+ch[i]+" = "+count);
            }
        }*/

        // -----------   Reverse String worlds ----------------

        /*String str = "welcome to java class";
        String[] strword = str.split(" ");
        String strReverse="";
        for (int i = strword.length-1; i >= 0 ; i--) {
            strReverse+=strword[i]+" ";
        }
        System.out.println(strReverse);*/
        // TotatCharacters of String
       /* String str = "Scaler by InterviewBit";
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' '){
                count++;
            }
        }
        System.out.println(count);
        System.out.println(3%5);*/
        /*String str = "abcde";
        System.out.println(str.substring(1,3));*/

        // Arrays  -----------------------------
        // max value
        /*int[] num = {100,20,30,40,50};
           int max = num[0];
        for (int i = 0; i < num.length; i++) {
             if (max < num[i])
                 max = num[i];
        }
        System.out.println(max);*/
        // duplicate Array
        /*int[] num = {1,2,3,4,2,3,5};
        for (int i = 0; i < num.length; i++) {
            for (int j = i; j < num.length; j++) {
                if (num[i] > num[j]) {
                    int temp = num[i];
                    num[i] = num[j];
                    num[j] = temp;


                }
            }
        }
        for (int a:num) {
              System.out.print(a);
        }
        System.out.println("");
        int b = 0;
        num[b] = num[0];
        for (int i = 0; i < num.length; i++) {
            if (num[b] != num[i]){
                b++;
                num[b] = num[i];
            }
        }
        for (int n:num) {
            System.out.print(n);
        }*/
        // array second max number
        /*int a[]={1,2,5,6,3,2};
         int temp;
        for (int i = 0; i < a.length; i++) {
            for (int j = i+1; j < a.length; j++) {
                     if (a[i] > a[j]){
                         temp = a[i];
                         a[i] = a[j];
                         a[j] = temp;
                     }
            }
        }
        System.out.println("Second Max : =  "+a[a.length-2]);*/

        // ========   Find the Missing Number ======
        int[] num = {1,2,3,4,6};
        int n = num.length;
        int[] newOne = new int[n+1];
        for (int i = 0; i < n-1; i++) {
            newOne[num[i]]++;
        }
        for (int i = 0; i <= n; i++) {
            if (newOne[i] == 0){
                System.out.println("missing num: "+i);
            }
        }
    }
}
