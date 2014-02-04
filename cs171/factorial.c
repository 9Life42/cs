#include <FPT.h>

//s=1*2*3*...*n

int main()
{
double keepAlive;
keepAlive=0;
while (keepAlive == 0){

  double n,s;

  cout << "Choose a positive whole number: ";

  cin >> n;

  s=1;

  while (n > 0) {

    cout << n;

    if (n > 1) {cout << "*";}

    s=s*n;

    n=n-1;

  }

  cout << "=" << s << "\n";

}
}
