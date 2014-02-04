#include <FPT.h>

// Multiply by only using addition

int main()
{
double keepAlive;
keepAlive=0;
while (keepAlive == 0){

  double x,y,z;

  cout << "Choose two numbers to multiply";

  cin >> x >> y;

  z=0;

  cout << "0\n";

  if (y >= 0){

  while (y > 0) {

    cout << "+" << x << "\n";

    z=z+x;

    y=y-1;

  }

  } else {

    while (y < 0) {

    cout << "-" << x << "\n";

    z=z-x;

    y=y+1;

  }
  }

  cout << "=" << z << "\n";

}
}
