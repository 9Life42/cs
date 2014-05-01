#include<stdio.h>
#include<stdlib.h>
 
// constants
#define OP_EXIT 0
#define OP_ENQUEUE 1
#define OP_DEQUEUE 2
#define OP_PRINT 3
#define OP_UNDEFINED -1

typedef struct q {
 int value;
 struct q *next;
} queue;

// prototypes
int selection(void);
queue * enqueue(queue *);
//====> changed prototype, removed int *
queue * dequeue(queue *);

void print(queue *);
//=====> added prototype for queue
void clear(queue *);
