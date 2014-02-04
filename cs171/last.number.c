#include <FPT.h>

//Does the last number ever show up again?

int main()
{
double keepAlive;
keepAlive=0;
while (keepAlive == 0){

  double x,c[100],counter;
  int a;


  x=1;
  counter=0;
  a=-1;

  while (x > 0) {

    a=a+1;

    c[a]=x;

    cout << "Input a number: ";

    cin >> x;

  }

  x=c[a];

  while (a > 0) {

    a=a-1;

    if (x == c[a]) {

      counter=counter+1;

    }

  }

  cout << "Your last number appeared " << counter << " other times.\n";

}
}
