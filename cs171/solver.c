#include <FPT.h>

// solve bx+c=0 for x when given b and c

int main()
{
  double b,c,x;

  cout << "Please enter 'b' and 'c'\n";

  cin >> b >> c;

  x=-c/b;

  if ((b == 0)&&(c != 0)) {cout << "No solution\n";}

  else if ((b == 0)&&(c ==0)) {cout << "Anything works\n";}

  else {cout << x << "\n";}
}
