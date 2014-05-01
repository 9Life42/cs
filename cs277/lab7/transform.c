#include"transform.h"

//-------------------- default transpose function -------------------//
void transpose(int *dest, int *source, int dims) {

  int i,j;

  for(i=0;i<dims;i++)
    for(j=0;j<dims;j++)
      dest[j*dims + i] = source[i*dims + j];
}

 
//---------------------- optimized transpose ---------------------//
void transpose_O(int *dest, int *source, int dims) {

  // put your code here
}
