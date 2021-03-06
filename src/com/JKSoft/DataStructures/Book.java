package com.JKSoft.DataStructures;

/**
 * Created by Jirka on 25.8.2016.
 * Tato třída je použita při deserializaci v GsonExample2_Deserializer
 *
 */
public class Book {
    private String [] authors;
    private String isbn10;
    private String isbn13;
    private String title;


    //  setters and getters
    public String[] getAuthors() {return authors;}
    public void setAuthors(String[] authors) {this.authors = authors;}
    public String getIsbn10() {return isbn10;}
    public void setIsbn10(String isbn10) {this.isbn10 = isbn10;}
    public String getIsbn13() {return isbn13;}
    public void setIsbn13(String isbn13) {this.isbn13 = isbn13;}
    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}

    // override to string
    @Override
    public String toString() {
        StringBuffer outBuff = new StringBuffer(100);
        outBuff.append(super.toString());
        outBuff.append("\n" + title);
        outBuff.append("\n\t[ISBN-10: " + isbn10 + "] [ISBN-13: " + isbn13 + "]");
        outBuff.append("\nWritten by:");
        for (String author : authors) {
            outBuff.append("\n\t>> " + author);
        }

        super.toString();

        return outBuff.toString();
    }
}
