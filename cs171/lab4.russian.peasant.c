#include <FPT.h>

//Multiplication algorithm

int main()
{
double keepAlive=0;
while (keepAlive == 0){

  double x,y,remainder,sum;

  cout << "Input two whole numbers to multiply: ";

  cin >> x >> y;

  sum=0;

  while (x > 0) {

    remainder=fmod(x, 2);

    x=floor(x/2);

    if (remainder != 0) {

      sum=sum+y;

    }

    y=y+y;

  }

  cout << "The product is: " << sum << "\n";

}
}
