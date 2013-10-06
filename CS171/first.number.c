#include <FPT.h>

//Does the first number ever show up again

int main()
{
double keepAlive;
keepAlive=0;
while (keepAlive == 0){

  double x,y,counter;

  cout << "Input the number to look for: ";

  cin >> x;

  y=1;

  counter=0;

  while (y > 0) {

    cout << "Input another number: ";

    cin >> y;

    if (x == y) {

      counter=counter+1;

    }

  }

  cout << "Your first number appeared " << counter << " other times.\n";

}
}
