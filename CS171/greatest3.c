#include <FPT.h>

int main()
{
  double a,b,c;

  cout << "Input three numbers:";

  cin >> a >> b >> c;

  if((a >= b)&&(a >= c)){

    cout << a <<"\n";

  } else if ((b >= a)&&(b >= c)) {

    cout << b << "\n";

  } else {

    cout << c << "\n";

  }
}
