#include <FPT.h>

// solve ax^2+bx+c=0 for x when given a, b, and c

int main()
{
  double a,b,c,x,i,j,t,s;

  cout << "Please enter 'a,' 'b,' and 'c'\n";

  cin >> a >>  b >> c;

  if ((a == 0)&&(b == 0)&&(c ==0)) {cout << "Anything works\n";}

  else if ((a == 0)&&(b == 0)&&(c != 0)) {cout << "No solution\n";}

  else if ((a == 0)&&(b != 0)&&(c == 0)) {cout << "The solution is 0\n";}

  else if ((a != 0)&&(b == 0)&&(c == 0)) {cout << "The solution is 0\n";}

  else if (a == 0) {

    // then it's linear

    x=-c/b;

    cout << "Solution is: " <<  x << "\n";

  }

  else if ((b*b-4*a*c) < 0) {

    // then it's imaginary

    i=sqrt(fabs(b*b-4*a*c))/(2*a);

    j=-b/(2*a);

    cout << "No real solutions, but the imaginary solutions are " << j << "+" << i << "i" << " and " << j << "-" << i << "i" << "\n";

  }

  else {

    t=(-b+sqrt(b*b-4*a*c))/(2*a);

    s=(-b-sqrt(b*b-4*a*c))/(2*a);

    if (t == s) {

      cout << "The solution is " << t << "\n";

    } else {

      cout << "The solutions are " << t << " and " << s << "\n";

    }
  }
}
