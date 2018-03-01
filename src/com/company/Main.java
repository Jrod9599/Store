package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Scanner scan = new Scanner(System.in);
	    boolean done = false;
        Products[] Cart = new Products[15];

        //Creating products and initializing them with name, description, and price
        //putting products in an Array of products
        //Creating new Vendor and initializing it with name and the previous Array of Products
        Products apple = new Products("apple", "is a fruit", 0.99);
        Products orange = new Products("orange", "is a fruit", .95);
        Products lemon = new Products("lemon", "is a fruit", 0.20);
        Products kiwi = new Products("kiwi", "is a fruit", .99);
        Products grapes = new Products("grapes","is a fruit", 5.00);
        Products[] ven1stuff = {apple, orange,lemon, kiwi, grapes};
        Vendor ven1 = new Vendor("ven1", ven1stuff);

        Products shirt = new Products( "shirt", "100% cotton", 5.00);
        Products jeans = new Products("jeans", "Denim", 20.00);
        Products shoes = new Products("shoes", "Hand-Crafted", 100.00);
        Products Hat = new Products("hat", "Atlanta Hawks", 15.00);
        Products Jacket = new Products("jacket", "Leather", 150.00);
        Products[] clothes = {shirt, jeans, shoes, Hat, Jacket};
        Vendor ven2 = new Vendor("ven2", clothes);

        Products ford = new Products("ford", "Mustang", 20000.00);
        Products toyota = new Products("toyota", "Camry", 15000.00);
        Products Cadillac = new Products("cadillac", "Deville", 5000.00);
        Products nissan= new Products ("nissan", "Altima", 17500.00);
        Products Honda= new Products ("honda", "Accord", 12500.00);
        Products[] cars = {ford, toyota, Cadillac, nissan,Honda};
        Vendor ven3 = new Vendor("ven3", cars);

        //Menu
        while(!done){
            System.out.println("1) View items from cart\n" +
                    "2) View available items\n" +
                    "3) add item\n" +
                    "4) remove item\n" +
                    "5) checkout\n" +
                    "6) exit");
            int choice = scan.nextInt();
            switch(choice){
                case 1:
                    viewCart(Cart);
                    break;
                case 2:
                    available(ven1, ven2, ven3);
                    break;
                case 3:
                    addtoCart(Cart,ven1,ven2,ven3, scan);
                    break;
                case 4:
                    //removeFromCart(Cart, ven1, ven2, ven3, scan);
                    break;
                case 5:
                    checkOut(Cart);
                    break;
                case 6:
                    done = true;
                    break;
                    default:
                        System.out.println("Invalid Option");
                        break;
            }
        }

    }

    public static void viewCart(Products[] cart){
        System.out.println("Items in cart: \n");
        for(int i = 0; i < cart.length; i++ ){
            if(cart[i] == null){
                break;
            }
            System.out.println(cart[i].getName() + ", " + cart[i].getPrice());
        }
    }

    public static void available(Vendor ven1, Vendor ven2, Vendor ven3){

        System.out.println("Products available for purchase: \n");
        for(int i = 0; i < ven1.available.length; i++){
            if(ven1.available[i].inCart == false)
                System.out.println(ven1.available[i].getName());
        }

        for(int i = 0; i < ven2.available.length; i++){
            if (ven2.available[i].inCart == false)
                System.out.println(ven2.available[i].getName());
        }
        for(int i = 0; i < ven3.available.length; i++){
            if (ven3.available[i].inCart == false)
                System.out.println(ven3.available[i].getName());
        }

    }

    public static void addtoCart(Products[] cart, Vendor ven1, Vendor ven2, Vendor ven3, Scanner scan){
        boolean found = false;
        System.out.println("Enter item: ");
        String choice = scan.next();
        choice = choice.toLowerCase();


        for(int i = 0; i < ven1.available.length; i++){
            if(choice.equals(ven1.available[i].getName())) {
                found = true;
                System.out.println("Found");
                if (ven1.available[i].inCart == false) {
                    for (int j = 0; j < cart.length; j++) {
                        if (cart[j] == null) {
                            cart[j] = ven1.available[i];
                            ven1.available[i].inCart = true;
                            break;
                        }
                    }
                }
                else
                    System.out.println("Item already in cart");
            }
        }
        if(found == false) {
            for (int i = 0; i < ven2.available.length; i++) {
                if (choice.equals(ven2.available[i].getName())) {
                    found = true;
                    System.out.println("Found");
                    if (ven2.available[i].inCart == false) {
                        for (int j = 0; j < cart.length; j++) {
                            if (cart[j] == null) {
                                cart[j] = ven2.available[i];
                                ven2.available[i].inCart = true;
                                break;
                            }
                        }
                    }
                    else
                        System.out.println("Item already in cart");
                }
            }
        }

        if(found == false) {
            for (int i = 0; i < ven3.available.length; i++) {
                if (choice.equals(ven3.available[i].getName())) {
                    found = true;
                    System.out.println("Found");
                    if (ven3.available[i].inCart == false) {
                        for (int j = 0; j < cart.length; j++) {
                            if (cart[j] == null) {
                                cart[j] = ven3.available[i];
                                ven3.available[i].inCart = true;
                                break;
                            }
                        }
                    }
                    else
                        System.out.println("Item already in cart");
                }
            }
        }
        if(!found)
            System.out.println("Item not found");

    }

    public static void removeFromCart(Products[] cart, Vendor ven1, Vendor ven2, Vendor ven3, Scanner scan){
        boolean found = false;
        System.out.println("Remove item: ");
        String choice = scan.next();
        choice = choice.toLowerCase();

        for(int i = 0; i < cart.length; i++){
            if(choice.equals(cart[i].getName())){
              found = true;
              System.out.println("Found");
              for(int j = i; j < cart.length; j++){
                  if(cart[j+1] != null)
                    cart[j] = cart[j+1];
                  else
                      cart[j] = null;
              }
                uncheckInCart(cart[i], ven1, ven2, ven3);
                break;
            }
            else
                System.out.println("Item is not in cart");
        }

        if(!found)
            System.out.println("Item not found");
    }

    public static void uncheckInCart(Products item, Vendor ven1, Vendor ven2, Vendor ven3){
        boolean found = false;

        for(int i = 0; i < ven1.available.length; i++) {
            if (item.getName().equals(ven1.available[i].getName())) {
                ven1.available[i].inCart = false;
                System.out.println("Item removed from cart");
                break;
            }
        }
        if(!found){
            for(int i = 0; i < ven2.available.length; i++) {
                if (item.getName().equals(ven2.available[i].getName())) {
                    ven2.available[i].inCart = false;
                    System.out.println("Item removed from cart");
                    break;
                }
            }
        }
        if(!found){
            for(int i = 0; i < ven3.available.length; i++) {
                if (item.getName().equals(ven3.available[i].getName())) {
                    ven3.available[i].inCart = false;
                    System.out.println("Item removed from cart");
                    break;
                }
            }
        }

    }
    public static void checkOut(Products[] cart){
        double sum = 0;
        for(int i = 0; i < cart.length; i++){
            if(cart[i] != null){
                System.out.println(cart[i].getName() + "\t" + cart[i].getPrice());
                sum += cart[i].getPrice();
            }
            else
                break;
        }
        System.out.println("Total: " + sum);
    }

}
