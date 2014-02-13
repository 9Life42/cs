#include "queue.h"


//------------------------------- main routine ------------------------//
int main(void) {

  int op;
  queue *first=NULL;

  do {
    op=selection();

    switch(op) {
      case OP_EXIT:
       puts("goodbye");
       break;
      case OP_ENQUEUE:
       first = enqueue(first); 
       break;
      case OP_DEQUEUE:
       ///====> added call to dequeue function
       first = dequeue(first);
        break;
      case OP_PRINT:
        print(first);
        break;
      default:
        puts("invalid operation");
        break;
    }
  }while(op != OP_EXIT);

  // ====> call to clear function
  clear(first);

  return 0;
}
//--end main



//--------------------------- selection ------------------------------//
// selection() prompts the user to choose an operation, it returns    //
//  an op code                                                        //
// [int] op_code selection()                                          //
//--------------------------------------------------------------------//
int selection() {

  int choice=OP_UNDEFINED;

  printf("\nPlease type:\n\t1 to add an element to the queue\n");
  printf("\t2 to remove an element from the queue\n");
  printf("\t3 to list the elements in the queue\n");
  printf("\t0 to exit the program\n");

  scanf("%d", &choice);
  return choice;
}

////=====> changed function to print dequeud value inside the dequeu function
////   this is analogous to our decision to scan the value inside of the enqueue
////    function
queue * dequeue(queue *list) {

  //====> changed name of *prev to *temp... prev is confusing :O
  queue *temp=list;

  //// ====> I changed this handle three cases:
   /// 1) list is empty which we already completed in class)
   //// 2) list has only one item and becomes empty at the end of the operation
   ///// 3) list has more than one item
  
  
  // ===> case 1, list is empty
  if (list == NULL) {
   //=====> print a nice message
   printf("\n---Queue is empty---\n");
    return NULL;
   }

  // ===> case 2, list becomes empty
  if (list->next == NULL) {
    printf("\n-----Dequeued: %d ----\n", list->value);
    free(list);
    return NULL;
  }

  
  do {
     //========> changed:
     // *v=list->value;
     //  if (prev->next == NULL) break;  
     //// to:
     if (temp->next->next == NULL) {
        printf("\n----Dequeued: %d----\n", temp->next->value);
        free(temp->next);
        temp->next=NULL;
     }
     temp=temp->next;
  } while(temp != NULL);
  
  return list;

}

void print(queue *node) {

  //====> changed print so that it prints in the order added
  /// old code: 
    // while(node != NULL) {
    // printf("%d\n", node->value);
     // node=node->next;
  //}
  //====> new code, is recursive... you may recognize this from the HW:
  if (node == NULL) {

     printf("--Queue-------\n");
     return;
  }
  print(node->next);
  printf("%d\n", node->value);
}

queue * enqueue(queue *list) {

  int val;
  queue *entry;
  
  puts("input an integer>");
  scanf("%d", &val);

  entry = (queue *)malloc(sizeof(queue));
  if (entry == NULL) exit;
  entry->value=val;
  entry->next=list;
   return entry;
  
}


//========> added clear functin to free memory
void clear(queue *q) {

   queue *to_free;

   while(q != NULL) {
     to_free = q;
     q=q->next;
     free(to_free);
   }

}
