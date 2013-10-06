#include <FPT.h>

//Range of scores

int main()
{
double keepAlive;
keepAlive=0;
while (keepAlive == 0){

  double x,max,min,c;

  cout << "Enter a score: ";

  cin >> x;

  max=x; min=x;

  while (x >= 0) {

    if (x < min) {min=x;}
    if (x > max) {max=x;}

    cout << "Enter another score or -1 to end: ";

    cin >> x;

  }

  cout << "The max is " << max << " and the min is " << min << "\n";

}
}
