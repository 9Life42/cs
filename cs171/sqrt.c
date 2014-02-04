#include <FPT.h>

//Square root of x

int main()
{
double keepAlive;
keepAlive=0;
while (keepAlive == 0){

  double x,low,high,sqrt;

  cout << "Enter a number to root: ";

  cin >> x;

  sqrt=x; low=0; high=x+1;

  while (fabs((sqrt*sqrt)-x) > 0.00001) {

    sqrt=(low+high)/2;

    if ((sqrt*sqrt) > x) {

      high=sqrt;

    } else {

      low=sqrt;

    }
  }

 cout << "The root is: " << sqrt << "\n";

}
}
