#include <FPT.h>

//s=1^3-2^3+3^3-...n^3

int main()
{
double keepAlive;
keepAlive=0;
while (keepAlive == 0){

  double n,s,i;

  cout << "Choose a positive whole number: ";

  cin >> n;

  i=2;

  s=1;

  cout << "1^3";

  while (i <= n) {

    if (fmod(i, 2) == 0) {

      cout << "-" << i << "^3";

      s=s-i*i*i;

    } else {

      cout << "+" << i << "^3";

      s=s+i*i*i;

    }

    i=i+1;

  }

  cout << "=" << s << "\n";

}
}
