#include "BookList.h"

int main(void) {

	Book * books = NULL;
	char read[STRING_LENGTH];
	int added = 0;

	if(fgets(read, STRING_LENGTH, stdin) == NULL) { return -1; }

	while(strcmp(read, "DONE_FILL\n") != 0) {

		if (strlen(read) > 1) {
			books = addBook(parseString(read), read, books, &added);
		}

		if(fgets(read, STRING_LENGTH, stdin) == NULL) { return -1; }
	}

	printf("Books added: %d\n", added);

	if(fgets(read, STRING_LENGTH, stdin) == NULL) { return -1; }

	while(strcmp(read, "DONE_SEARCH\n") != 0) {

		if (strlen(read) > 1) {
			parseString(read);
			printf("Results found for %s: %d\n", read, searchBooks(read, books));
		}

		if(fgets(read, STRING_LENGTH, stdin) == NULL) { return -1; }
	}

	printBooks(books);
	freeBooks(books);

	return 0;
}

double parseString(char * info) {
	char stringEnd = strlen(info) - 1;
	if (info[stringEnd] == '\n') {
		info[stringEnd] = '\0';
	}

	double price = 0;
	sscanf(info, "%lf  %[^\n]", &price, info);
	return price;
}

Book * addBook(double price, char * title, Book * books, int * added) {
	Book * head;

	Book * newBook = (Book *)malloc(sizeof(Book));
	if (newBook == NULL) { exit(-1); }

	newBook->price = price;
	strcpy(newBook->title, title);

	if (books == NULL) {
		*added += 1;
		return head = newBook;
	}

	if (bookCompare(newBook, books) < 0) {
		newBook->next = books;
		*added += 1;
		return head = newBook;
	}

	head = books;

	while (books->next != NULL && bookCompare(newBook, books->next) > 0) {
		books = books->next;
	}

	newBook->next = books->next;
	books->next = newBook;
	*added += 1;
	return head;
}

int bookCompare(Book * book1, Book * book2) {
	if (strcmp(book1->title, book2->title) == 0) {
		return (int)ceil((book1->price - book2->price));
	}
	return strcmp(book1->title, book2->title);
}

int searchBooks(char * title, Book * books) {
	int results = 0;

	while (books != NULL) {
		if(strcmp(title, books->title) == 0) {
			results += 1;
		}
		books = books->next;
	}

	return results;
}

void printBooks(Book * books) {

	while (books != NULL) {
		if (books->price < 10) {
			printf("%s", " ");
		}
		printf("%.2lf  %s\n", books->price, books->title);
		books = books->next;
	}
}

void freeBooks(Book * books) {
	Book * thisBook;
	while (books != NULL) {
		thisBook = books;
		books = books->next;
		free(thisBook);
	}
}
