#include <FPT.h>

//Prime checker

int main()
{
double keepAlive;
keepAlive=0;
while (keepAlive == 0){

  double n,i,t;

  cout << "Input a number: ";

  cin >> n;

  i=floor(sqrt(n)+1);

  t=0;

  while ((i > 1)&&(t==0)) {

    if (fmod(n, i) == 0) {

      t=t+1;

    }

    i=i-1;

  }

  if (t == 0) {

    cout << "Prime\n";

  } else {

    cout << "Not prime\n";

  }

}
}
