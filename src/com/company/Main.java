package com.company;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        FileReader fr = new FileReader("c.txt");
        Scanner scan = new Scanner(fr);
        FileWriter fw = new FileWriter("out_c.txt");

        int allBooks = scan.nextInt();
        int allLibs = scan.nextInt();
        int days = scan.nextInt();
        String values = scan.nextLine();
        values = scan.nextLine();

        ArrayList<Lib> libs = new ArrayList<>();

        //show the values of all books
        //        System.out.println(values);

        for (int i = 0; i < allLibs; i++) {
            libs.add(new Lib(
               scan.nextInt(),
               scan.nextInt(),
               scan.nextInt()
            ));
            libs.get(i).setId(i);
            ArrayList<Integer> bl = libs.get(i).getBooksList();
            for (int j = 0; j < libs.get(i).getBooks(); j++) {
                bl.add(scan.nextInt());
            }
        }

        System.out.println("libs before sorting= " + libs);

        Collections.sort(libs);
//
        System.out.println("libs after sorting= " + libs);

        int counter = 0;
        for (int i = 0; i < days; i++) {
            days -= libs.get(i).getDaysToScan();
            fw.write(libs.get(i).getId() + " ");
//            System.out.println("test1 = " + libs.get(i).getBooks());
//            System.out.println("test2 = " + libs.get(i).getDaysToScan());
            counter += libs.get(i).getDaysToScan();
            int amountOfBooksForScan = libs.get(i).getBooks()-counter;
            fw.write(String.valueOf(amountOfBooksForScan));
            fw.write("\n");
            for (int j = 0; j < amountOfBooksForScan; j++) {
                fw.write(libs.get(i).getBooksList().get(j) + " ");
            }
            fw.write("\n");
        }

//        int libs

    }
}

class Lib  implements Comparable{
 int id;
    int books;
    int daysToScan;
    int booksPerDay;
    ArrayList<Integer> booksList = new ArrayList<>();

    public Lib(int books, int daysToScan, int booksPerDay) {
        this.books = books;
        this.daysToScan = daysToScan;
        this.booksPerDay = booksPerDay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //    @Override
//    public int compareTo(Lib lib) {
//        if (this.daysToScan == lib.getDaysToScan()) {
//            return 0;
//        } else if (this.daysToScan > lib.daysToScan) {
//            return 1;
//        } else {
//            return -1;
//        }
//    }

    @Override
    public int compareTo(Object o) {
        if(!(o instanceof Lib)) return 0;
        Lib temp = (Lib) o;
        if(this.daysToScan > temp.daysToScan) return 1;
        else if(this.daysToScan < temp.daysToScan) return -1;
        else return 0;
    }

    public int getBooks() {
        return books;
    }

    public void setBooks(int books) {
        this.books = books;
    }

    public int getDaysToScan() {
        return daysToScan;
    }

    public void setDaysToScan(int daysToScan) {
        this.daysToScan = daysToScan;
    }

    public int getBooksPerDay() {
        return booksPerDay;
    }

    public void setBooksPerDay(int booksPerDay) {
        this.booksPerDay = booksPerDay;
    }

    public ArrayList<Integer> getBooksList() {
        return booksList;
    }

    public void setBooksList(ArrayList<Integer> booksList) {
        this.booksList = booksList;
    }

    @Override
    public String toString() {
        return "Lib{" +
                "books=" + books +
                ", daysToScan=" + daysToScan +
                ", booksPerDay=" + booksPerDay +
                ", booksList=" + booksList +
                '}';
    }
}
