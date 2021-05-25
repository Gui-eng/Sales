/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sales;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Monica
 */
public class Sales {
    public static Scanner sc = new Scanner(System.in);
    public static String itemName, arrItemName [] = {};
    public static int itemPrice, itemQuantity, itemId = 0, sum = 0, day,
                      percentSum, weeklySum;
    public static float percent, newPercent;
    static boolean isDone = false;
    
    
    public static int[] arrDay;
    public static Integer arrPrice[] = {}, arrQuantity[] = {}, arritemId[] = {};
    public static Array itemss[];
    public Sales(int ItemID, String ItemName, int ItemPrice, int ItemQuantity){
            this.itemId = ItemID;
            this.itemName = ItemName;
            this.itemPrice = ItemPrice;
            this.itemQuantity = ItemQuantity;
        }
    //Main code
    public static void sales_init(){
        System.out.println("Please enter the following Information:");
        System.out.print("Item name: ");
        itemName = sc.next();
        addItemName();
        System.out.print("Price: ");
        itemPrice = sc.nextInt();
        
        System.out.print("Quantity: ");
        itemQuantity = sc.nextInt();
        addQuantity();
        itemId = itemId + 1;
        addId();
        itemPrice = itemPrice * itemQuantity;
        addPrice();
    }
    public static void weekly(){
       
        System.out.println("Please type and enter the day: [1]Monday [2]Tuesday"
                         + " [3]Wendsday [4]Thursday [5]Friday [6]Saturday."
                         + " [7]Sunday ");
        day = sc.nextInt();
        System.out.println("Please type and enter sales increase by percent. i.e.: 12");
        percent = sc.nextInt();
        newPercent = percent / 100;
        percentSum =  (int)(sum * newPercent);
        arrDay = new int[7];
        day--;
        if (day <= 0 || day > 7 ){
            System.out.println("Please enter a valid choice!");
            System.out.println("You only need to type and enter the number [N].");
            weekly();
        }else{
            arrDay[day] = sum;      
            for (int i = day + 1; i < 7; i++) {               
                    arrDay[i] = sum + percentSum;
                    sum = sum + percentSum;
            }
            for (int j = 0; j < day; j++) {
                    arrDay[j] = sum + percentSum;
                    sum = sum + percentSum;
            }
        }
         for (int i = 0; i < arrDay.length; i++) {
            int attr = arrDay[i];
            weeklySum = weeklySum + attr;
        }
         
         
        
    }
    public static void sum(){
    
        for (int i = 0; i < arritemId.length; i++) {
            int attr = arrPrice[i];
            sum = sum + attr;
        }
        System.out.println(sum + "(Php)");
    }
 
    public static void addId(){
        ArrayList<Integer> arrayListId = new ArrayList<Integer>
        (Arrays.asList(arritemId));
        arrayListId.add(itemId);
        arritemId = arrayListId.toArray(arritemId);
        System.out.println(Arrays.toString(arritemId));
    }
    public static void addPrice(){
        ArrayList<Integer> arrayListPrice = new ArrayList<Integer>
        (Arrays.asList(arrPrice));
        arrayListPrice.add(itemPrice);
        arrPrice = arrayListPrice.toArray(arrPrice);
        System.out.println(Arrays.toString(arrPrice));
    }
    public static void addQuantity(){
        ArrayList<Integer> arrayListQuantity = new ArrayList<Integer>
        (Arrays.asList(arrQuantity));
        arrayListQuantity.add(itemQuantity);
        arrQuantity = arrayListQuantity.toArray(arrQuantity);
        System.out.println(Arrays.toString(arrQuantity));
    }
    public static void addItemName(){
        ArrayList<String> arrayListItemName = new ArrayList<String>
        (Arrays.asList(arrItemName));
        arrayListItemName.add(itemName);
        arrItemName = arrayListItemName.toArray(arrItemName);
        System.out.println(Arrays.toString(arrItemName));
    }
    
    
    
    public static void main(String[] args) {
      new Sales_GUI().setVisible(true);
        
     }
}
    