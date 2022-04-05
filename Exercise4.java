/* 

Exercise 4 - Online Library
You have to implement a library using Java Class "Library"

Methods: addBook, issueBook, returnBook, showAvailableBooks
Properties: Array to store the available books,
Array to store the issued books

Solved the bug of :-
(1) Adding books multiple times in library
(1) issuing the same book multiple times
(2) returning the same book multiple times
(3) issuing book in empty library
(4) returning book in empty library

*/

package com.company;
import java.util.ArrayList;
import java.util.Scanner;

class Library
{

    public int n=0,a=0,j=0,q=0,flag=0,check=0;
    public int issuebookno;

    ArrayList<String> BooksName = new ArrayList<>();
    ArrayList<String> ReturnBook= new ArrayList<>();

    public void Bookno()
    {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("How Many Book You Want to add : ");
        n = sc1.nextInt();
    }

    public void addBook()
    {
        Bookno();
        Scanner sc2 = new Scanner(System.in);

        System.out.println();
        int i;
        
        if(q==0)
        {
            for (i=0;i<n;i++)
            {
               System.out.print("Enter Book " + (i+1) + " Name : ");
               BooksName.add(i,sc2.nextLine());
            }
            q++;
            j=n;
            a=n;
            check++;
        }
        else
        {
            for (i=a;i<a+n;i++)
            {
                System.out.print("Enter Book " + (i+1) + " Name : ");
                BooksName.add(i,sc2.nextLine());
                j=i;
                flag=1;
            }
        }
        System.out.println();
        System.out.println("Your Book is Added successfully.....");
        System.out.println("------------------------------------------------------------");
    }
    
    public void showAvailableBooks()
    {
        System.out.println("------------------------------------------------------------");
        System.out.println("Available Book is : ");
        if(flag==0) 
        {
            for (int i = 0; i < j; i++) 
            {
                System.out.println((i + 1) + ". " + BooksName.get(i));
            }
        }
        else
        {
            for (int i = 0; i <= j; i++) 
            {
                System.out.println((i + 1) + ". " + BooksName.get(i));
            }
        }
        
        System.out.println("------------------------------------------------------------");
    }

    public void issueBook()
    {
        if(check==0)
        {
            System.out.println("There are no Books in Library. Please ass some books in Library...");
        }
        else
        {
            //for Books issued
            Scanner sc3 = new Scanner(System.in);
            System.out.println("--------------------------------------------------------------");
            
            System.out.println("Enter Your Book Number (0 Not Allowed ) to be issued : `");
            issuebookno = sc3.nextInt();
            System.out.println();
            issuebookno -= 1;
            
            //for already book is issued
            if (BooksName.get(issuebookno) == null) 
            {
                System.out.println("This Book is Already Issued By any other person. Please Issue any other book... ");
            } 
            else 
            {
                System.out.println(BooksName.get(issuebookno) + " Has Issued Successfully");
                
                for (int i = 0; i <= j; i++) 
                {
                    if (i != issuebookno) 
                    {
                        ReturnBook.add(i, null);
                    } 
                    else
                    {
                        ReturnBook.add(i, BooksName.get(issuebookno));
                    }
                }
                
                BooksName.set(issuebookno, null);
            }
        }
            System.out.println("--------------------------------------------------------------");
    }

    public void returnBook()
    {

        if(check==0)
        {
            System.out.println("There are no Books in Library. Please ass some books in Library...");
        }
        else 
        {
            Scanner sc4 = new Scanner(System.in);
            System.out.println("--------------------------------------------------------------");
            System.out.println();
            
            System.out.println("Enter Your Book Number to be return");
            int returnbookno = sc4.nextInt();
            returnbookno -= 1;
            
            // for thebooks which are not returned
            if (BooksName.get(returnbookno) == null) 
            {
                BooksName.set(returnbookno, ReturnBook.get(returnbookno));

                System.out.println(ReturnBook.get(returnbookno) + " Return Successfully .......");
            } 
            else  // for the books which are already returned
            {
                System.out.println("Book is already returned. Please return any other book which is not available in Library...");
            }
        }
        System.out.println("--------------------------------------------------------------");

    }
    
    //for user input
    public void takeChoice()
    {
        Scanner sc5 =new Scanner(System.in);
        System.out.println(" 1. Add Book \t 2.Show Available Book \t 3.Issue Book \t 4.Return Book \t 5.Exit");
        System.out.print("Enter Your Choice : ");
        int take_UserInput = sc5.nextInt();

        switch(take_UserInput)
        {
            case 1:
                addBook();
                takeChoice();
                break;
            case 2:
                showAvailableBooks();
                takeChoice();
                break;
            case 3:
                issueBook();
                takeChoice();
                break;
            case 4:
                returnBook();
                takeChoice();
                break;
            default: 
                {
                    if (take_UserInput == 5) 
                    {
                        System.out.println("-------------------Thank's for using Library Management System------------------");
                        break;
                    } 
                    else 
                    {
                        System.out.println("Enter Valid Choice (1-5) ");
                        takeChoice();
                    }
                 }
        }
    }
}

public class Exercise4 
{
    public static void main(String[] args) 
    {
        Library L1 = new Library();
        System.out.println("----------------------Welcome To Library Management System----------------------");
        System.out.println();
        
        L1.takeChoice();

    }
}

