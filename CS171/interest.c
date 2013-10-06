#include <FPT.h>

//x^n

int main()
{
double keepAlive;
keepAlive=0;
while (keepAlive == 0){

  double p,a,time,bank;

  time=0;

  p=1000;

  while (p <= 200000) {

    bank=bank+(p*.02/12);

    p=p+(p*.02/12)+400;

    time=time+1;

  }



  cout << floor(time/12) << " years and " << fmod(time, 12) << " months\n";

  cout << "Account: $" << p << " (with $" << bank << " from the bank)\n";

  keepAlive = 1;

}
}
