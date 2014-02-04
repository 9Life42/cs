#include <FPT.h>

//Average test scores

int main()
{
double keepAlive;
keepAlive=0;
while (keepAlive == 0){

  double x,t,c;

  x=0; t=0; c=0;

  cout << "Enter a score: ";

  cin >> x;

  while (x >= 0) {

    t=t+x;

    c=c+1;

    cout << "Enter another score or -1 to end: ";

    cin >> x;

  }

  cout << "The average is: " << t/c << "\n";

}
}
