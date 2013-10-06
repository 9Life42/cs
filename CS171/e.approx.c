#include <FPT.h>

//Approximation of e

int main()
{
double keepAlive;
keepAlive=0;
while (keepAlive == 0){

  double n,i,s,e;

  cout << "How accurate do you want e? ";

  cin >> n;

  e=1;

  cout << e;

  while (n > 0){

  s=1;

  i=n;

  cout << "+1/" << n << "!";

  while (n > 0) {

    s=s*n;

    n=n-1;

  }

  n=i-1;

  e=e+(1/s);

  }

  cout << "= about " << e << "\n";

}
}
