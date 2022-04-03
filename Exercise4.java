/* Exercise 4 - Online Library
You have to implement a library using Java Class "Library"

Methods: addBook, issueBook, returnBook, showAvailableBooks
Properties: Array to store the available books,
Array to store the issued books */

package com.company;
import java.util.ArrayList;
import java.util.Scanner;

class Library{

    public int n;
    public int issuebookno;

    ArrayList<String> BooksName = new ArrayList<>();
    ArrayList<String> ReturnBook= new ArrayList<>();

    public void Bookno(){
        Scanner sc1 = new Scanner(System.in);
        System.out.println("How Many Book You Want to add : ");
        n = sc1.nextInt();
    }


    public void addBook(){

        Bookno();
        Scanner sc2 = new Scanner(System.in);

        System.out.println();

        for (int i=0;i<n;i++){
            System.out.print("Enter Book " + (i+1) + " Name : ");

            BooksName.add(i,sc2.nextLine());
        }
        System.out.println();
        System.out.println("Your Book is Add Sucufully.....");
        System.out.println("------------------------------------------------------------");

    }

    public void showAvailableBooks(){
        System.out.println("------------------------------------------------------------");
        System.out.println("Available Book is : ");

        for (int i=0;i<n;i++){

            System.out.println((i+1) + ". " + BooksName.get(i));
        }
        System.out.println("------------------------------------------------------------");
    }

    public void issueBook(){

        //for alredy book is issued
        if (BooksName.get(issuebookno) == null){
            System.out.println("This Book is Alredy Issued By any other person ");
        }

        //for Books issued
        Scanner sc3 = new Scanner(System.in);
        System.out.println("--------------------------------------------------------------");

        System.out.println("Enter Your Book Number (0 Not Allowed ) to be issued : `");
        issuebookno = sc3.nextInt();

        System.out.println();

        issuebookno -= 1;
        System.out.println( BooksName.get(issuebookno)  + " Has Issued Succufully");
        System.out.println("--------------------------------------------------------------");

        //System.out.println("issubook no is : " + issuebookno);

        for(int i=0;i<n;i++){

            if (i!= issuebookno){
                ReturnBook.add(i,null);
            }
            else {
                ReturnBook.add(i,BooksName.get(issuebookno));
            }

        }

//        //for show returning book
//        System.out.println("Your Returning Book is : ");
//        for (int i=0;i<n;i++){
//            System.out.println(ReturnBook.get(i));
//        }

        //for set the null value in this index
        BooksName.set(issuebookno,null);

    }

    //return book means book pachi apvi issued karya pachi
    public void returnBook(){

        Scanner sc4 = new Scanner(System.in);
        System.out.println("--------------------------------------------------------------");
        System.out.println();

        System.out.println("Enter Your Book Number to be return");
        int returnbookno = sc4.nextInt();

        returnbookno -= 1;

        BooksName.set(returnbookno,ReturnBook.get(returnbookno));

        System.out.println(ReturnBook.get(returnbookno) + " Return Succfully .......");

        System.out.println("--------------------------------------------------------------");

    }


    //for user input
    public void takeChoise(){

        Scanner sc5 =new Scanner(System.in);
        System.out.println(" 1. Add Book \t 2.Show Available Book \t 3.Issue Book \t 4.Return Book \t 5.Exit");

        for (int i=0;i<100;i++){

            System.out.print("Enter Your Choise : ");
            int take_UserInput = sc5.nextInt();

            if (take_UserInput == 1){
                addBook();
            }

            else if(take_UserInput == 2){
                showAvailableBooks();
            }

            else if (take_UserInput == 3){
                issueBook();
            }

            else if (take_UserInput == 4){
                returnBook();
            }

            else {
                break;
            }
        }
    }
}

public class Exercise4 {
    public static void main(String[] args) {

        Library L1 = new Library();
        L1.takeChoise();

    }
}

