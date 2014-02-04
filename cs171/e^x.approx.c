#include <FPT.h>

// Approximation of e^x

int main()
{
double keepAlive;
keepAlive=0;
while (keepAlive == 0){

  double n,x,i,s,e;

  cout << "e to the what? ";

  cin >> x;

  cout << "How accurate do you want e" << x << "? ";

  cin >> n;

  e=1; i=1; s=1;

  while (i <= n) {

    s=s*i;

    e=e+(pow(x, i)/s);

    i=i+1;

  }

  /* cout << e;

  i=0;

  while (n > 0){

  s=1;

  i=n;

  while (n > 0) {

    s=s*n;

    n=n-1;

  }

  n=i;

  e=e+(pow(x,n)/s);

  cout << x << "^" << n << "/" << n << "!";

  n=n-1;

  }*/

  cout << "= about " << e << "\n";

}
}
