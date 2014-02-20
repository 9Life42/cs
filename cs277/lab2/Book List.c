#include "BookList.h"

int main(void) {

	Book * books = NULL;
	char info[MAX_INFO_LENGTH];
	Book *temp;
	char read[MAX_INFO_LENGTH];

	if(fgets(read, MAX_INFO_LENGTH, stdin) == NULL) {
			return -1;
		}

	while(strcmp(read, "DONE_FILL") != 0) {
		if(fgets(read, MAX_INFO_LENGTH, stdin) == NULL) {
			return -1;
		}
	}

	while(strcmp(read, "DONE_SEARCH") != 0) {
		if(fgets(read, MAX_INFO_LENGTH, stdin) == NULL) {
			return -1;
		}

	}

	printBooks(books);
	freeBooks(books);

	return 0;
}

void parseBook(char *info) {

}

void listBook(char *title, char *price) {

}

void searchBooks(char *title) {
	
}

void printBooks(Book *books) {

}

void freeBooks(Book *books) {

}
