#include <FPT.h>

//x^n

int main()
{
double keepAlive;
keepAlive=0;
while (keepAlive == 0){

  double x,n,z;

  cout << "Choose a number and the integer to raise it to: ";

  cin >> x >> n;

  if ((n == 0)&&(x < 0)) {

    z=-1;

  } else {

    z=1;

  }

  if ((n <= 0)&&(x == 0)) {

    cout << "Undefined\n";

  } else if (n < 0) {

    while (n < 0) {

      z=z*x;

      n=n+1;

  }

    cout << "1/" << z << " = " << 1/z << "\n";

  } else {

    while (n > 0) {

      z=z*x;

      n=n-1;
    }

  cout << z << "\n";

  }
}
}
