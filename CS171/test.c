#include <FPT.h>

//Alternating harmonic fraction

int main()
{
double keepAlive=0;
while (keepAlive == 0){

double n,num,i,sign,den;

cin >> n;

i=1; num=0; sign=1;

while (i <= n) {
  
  num = num + sign/i;
  sign = -sign;
  i=i+2;
  
 }

i=2; den=0; sign=1;

while (i <= n) {
  
  den = den + sign/i;
  sign = -sign;
  i=i+2;
  
 }

 cout << num/den << "\n";

 }
}
