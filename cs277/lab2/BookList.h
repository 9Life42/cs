#include<stdio.h>
#include<stdlib.h>
#include<string.h>

#define MAX_INFO_LENGTH 100 
#define MAX_PRICE_LENGTH 10

typedef struct nextBook {
  char price[MAX_PRICE_LENGTH];
  char title[MAX_INFO_LENGTH];
  struct nextBook *next;
} Book;

void parseBook(char *info);
void listBook(char *title, char *price);
void searchBooks(char *title);
void printBooks(Book *books);
void freeBooks(Book *books);
