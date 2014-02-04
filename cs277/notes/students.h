#include<stdio.h>
#include<stdlib.h>
#include<string.h>

#define FINISHED "DONE"
#define MAX_NAME_LEN 50

typedef struct next_student {
  char username[MAX_NAME_LEN];
  int points;
  int submissions;
  struct next_student *next;
} student;

//----- function prototypes
student * create_student(char *name);
student * add_student(student *, student *);
void print_students(student *);
void destroy_students(student *);
int read_line(char *buff, int);


