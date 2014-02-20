#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<math.h>

#define STRING_LENGTH 100

typedef struct nextBook {
	double price;
	char title[STRING_LENGTH];
	struct nextBook *next;
} Book;

double parseString(char * info);
Book * addBook(double price, char * title, Book * books, int * added);
int bookCompare(Book * book1, Book * book2);
int searchBooks(char * title, Book * books);
void printBooks(Book * books);
void freeBooks(Book * books);