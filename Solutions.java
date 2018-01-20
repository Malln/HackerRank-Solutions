import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

  public TrieContact contact ;
    
  public static void main(String[] args) {
        Solution sol = new Solution();
        sol.contact = new TrieContact ();
        
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
      
        for(int a = 0; a < n; a++){
            String op = in.next();
            String contactName = in.next();
            if (op.equals("add"))
                sol.addContact(contactName);
            else if (op.equals("find"))
                sol.lookForContact(contactName);
        }
  }
   public  void addContact(String contactName){
         TrieContact root = this.contact ;
           for (int i=0;i<contactName.length(); i++){
               int index = contactName.charAt(i)-'a';
               TrieContact next =root.children[index];
               if (next == null) {
                     root.children[index] = new TrieContact();
                     root=root.children[index];
                   }
               else 
                    root=next ;
               root.count =root.count+1 ;
           }
          
        }
        
   public void lookForContact (String partialContactName){
          TrieContact root = this.contact ;
          int count=0 ;
           for (int i =0;i < partialContactName.length();i++){
               int index = partialContactName.charAt(i)-'a';
               TrieContact next =root.children[index];
               if (next == null) {
                   count=0 ;
                   break ;
               } 
               else
               {
                    root=next ;
                   // System.out.println("root element" + root.count);
                    count =root.count ;
               }
           }
                  System.out.println(count);
           }

}
class TrieContact {
    TrieContact children[] ;
    int count ;
    
    public TrieContact ()
    {
        children= new TrieContact[26];
        count= 0 ;
    }
}
