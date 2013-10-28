#include <FPT.h>

//Approximate cosine

int main()
{

  double x, n, i, pow, fac, sign, sum;

  cout << "What would you like to approximate the cosine of? ";

  cin >> x;

  cout << "Input a positive, even number for n: ";

  cin >> n;

  i = 0;

  sign = 1;

  pow = 1;

  fac = 1;

  sum = 0;

  while (i < n) {

    sum = sum + sign *(pow / fac);

    sign = sign * (-1);

    i = i + 2;

    pow = pow * x * x;

    fac = fac * (i-1) * i;

  }

  cout << sum << "\n";

}
