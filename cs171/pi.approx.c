#include <FPT.h>

//Approximation of pi

int main()
{
double keepAlive;
keepAlive=0;
while (keepAlive == 0){

double n,i,j,x,y;

  cout << "How many factors? ";

  cin >> n;

  i=0; j=0; x=1; y=sqrt(2);

  while (i < n) {

    while (j < i) {

      y=sqrt(2+y);

      j=j+1;

    }

    x=x*(y/2);

    i=i+1;

  }

  cout << "about " << 2/x << "\n";

}
}
