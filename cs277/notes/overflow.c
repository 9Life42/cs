#include<stdio.h>

int overflowme(int *);

int main(void) {
  int i;
  printf("Entering overflow\n");
  overflowme(&i);
  printf("Finished overflow function\n");
}

int overflowme(int *ip) {

  int x;                // create a stack variable
  int *p=&x;            // save our location in the stack
  int i;                // to make our lives easier via for loop
  long int diff = 
     (unsigned long)ip-(unsigned long)&x; //compute delta between 
                                          // address known to be in 
                                          // callers stack frame and current
                                          //  stack frame

  // print it out for sanity, verify i,*p are t lower addresses than x
  printf("diff: %lu ip: %p x: %p p: %p i: %p\n", diff, ip, &x, &p, &i);


  // loop and overwrite the return address.  
   for(i=0;i<diff/4;i++) {
     printf("Writing location: %p\n", p+i);
     *(p+i)=0;
  }
}

