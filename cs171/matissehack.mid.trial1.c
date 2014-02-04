#include <FPT.h>

//Alternating harmonic fraction

int main()
{
double keepAlive=0;
while (keepAlive == 0){

  double n, c, odd, top, bottom;

  cout << "Choose an even value for n: ";

  cin >> n;

  c = 0;
  top = 0;
  bottom = 0;

  while (c*2 < n) {

    top = top + 1/(pow(-1, c)*(1+c*2));

    c = c+1;

  }

  c = 0;

  while (c*2 < n) {

    bottom = bottom + 1/(pow(-1, c)*(2+c*2));

    c = c + 1;

  }

cout << top << "\n" << bottom << "\n" << top/bottom << "\n";

}
}
