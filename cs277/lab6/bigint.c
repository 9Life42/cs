#include<stdlib.h>
#include "bigint.h"


///////------------- must implement ---------------------------//
// allocate memory for and initialize a new big_int
big_int * new_big_int(unsigned int i){ 
  return NULL;
}

// de-allocate big_int
void destroy_big_int(big_int *bi) {

}

// perform left shift operation:  bi = bi<<v
void big_int_shiftl(big_int *bi, int v) {


}

// perform arithmetic right shift operation: bi = bi>>v
void big_int_shiftr(big_int *bi , int v) {



}

// perform bitwise AND: bi1=bi1&bi2
void big_int_and(big_int *bi1, const big_int *bi2) {


}


// perform bitwise OR: bi1=bi1|bi2
void big_int_or(big_int *bi1, const big_int *bi2) {


}


// perform bitwise NOT: bi1=~bi1;
void big_int_not(big_int *bi1) {

}

// perform bitwise xor: bi1=bi1^bi2
void big_int_xor(big_int *bi1, const big_int *bi2) {


}

// perform addition: bi1=bi1+bi2;  
//  addition should handle overflow the same as a 32-bit unsigned int
//  when result exceeds the maximum value allowed by BIG_INT_BIT_WIDTH
void big_int_add(big_int *bi1, const big_int *bi2) {

}

//--------- extra credit #1  +10 Lab Points

// check for equality, returns 1 if bi1==bi2, otherwise 0
int big_int_equals(const big_int *bi1, const big_int *bi2) {
  return 0;
}


// returns 1 when bi1 > bi2, otherwise 0
int big_int_gt(const big_int *bi1, const big_int *bi2) {
  return 0;
}

// returns 1 when bi2 < bi1, otherwise 0
int big_int_lt(const big_int *bi1, const big_int *bi2) {
  return 0;
}


//------------ extra credit #2 +5 Lab Points

// returns a new big_int that contains the value represented by
//  the hex string read left-to-right as most significant byte to
//  least significant byte.  Returns NULL if byte string does not contain 
//  valid hexidecimal or beyond the range supported by big_int
big_int * parse_hex(const char *hex) {
  return NULL;
}


// saves the big_int value as a hexidecimal string printed 
//  left-to-right as most significant byte to least significant byte
void to_hex(const big_int *bi, char *hex) {


}

//--------------- extra credit #2 +5 Lab Points



// saves the big_int value as a decimal string printed 
//  left-to-right as most significant digit to least significant digit
void to_decimal(const big_int *bi, char *dec) {

}

// returns a new big_int that contains the value represented by
//  the decimal string read left-to-right as most significant digit to
//  least significant digit.  Returns NULL if byte string does not contain
//  valid decimal or is beyond the range supported by big_int

big_int * parse_decimal(const char *dec) {
  return NULL;
}


