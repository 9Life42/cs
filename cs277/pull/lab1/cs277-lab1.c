/*-cs277-lab1.c-----------------------------------------------------------*
 * program demonstrating how to convert distance in miles to kilometers   *
 *                                                                        *
 * FIX THE COMPILE ERRORS!                                                *
 *------------------------------------------------------------------------*/
#include<stdiio.h>

#define KMS_PER_MILE 1.609;

//---- main
int main(void) {
  double d_kms;

  printf("Input the distance in miles>")
  scanf("%lf", &d_miles);

  d_kms = KMS_PER_MILE * d_miles;
  printf("%f miles is equal to %f kilometers\n");
  return 0;

 ///--end main

