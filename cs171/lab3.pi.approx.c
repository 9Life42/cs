#include <FPT.h>

//Approximation of pi

int main()
{
double keepAlive;
keepAlive=0;
while (keepAlive == 0){

  double n,x;

  cout << "Input an odd whole number for n: ";

  cin >> n;

  x=1;

  while (n > 2) {

    x=2+(pow(n, 2)/x);

    n=n-2;

  }

  x=1+(pow(n, 2)/x);

  x=4/x;

  cout << "Pi is about " << x << "\n";

}
}
