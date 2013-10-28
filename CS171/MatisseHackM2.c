#include <FPT.h>

//A continued fraction of powers

int main()
{

  double x,n,i,pow,total;

  cout << "Input a number for x:  ";

  cin >> x;

  cout << "Input a positive whole number for n: ";

  cin >> n;

  i = 0;

  pow = 1;

  while (i < n) {

    pow = pow * x;

    i = i + 1;

  }

  total = 1;

  while (n > 0) {

    total = 1 + (pow/total);

    cout << pow << "  " << total << "\n";

    pow = pow/x;

    n = n - 1;

  }

  cout << total << "\n";

}
