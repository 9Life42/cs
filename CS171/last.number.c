#include <FPT.h>

//Does the first number ever show up again

int main()
{
double keepAlive;
keepAlive=0;
while (keepAlive == 0){

  double c[100],counter;
  int a,b;

  a=0;
  c[0]=1;
  counter=0;

  while (c[a] > 0) {

    cout << "Input a number: ";

    cin >> c[a];

    a=a+1;

  }

  b=a;
  a=a-1;

  while (a > 0) {

    if (c[b] ==c[a]) {

      counter=counter+1;

    }

  }

  cout << "Your last number appeared " << counter << " other times.\n";

}
}
