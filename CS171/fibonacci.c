#include <FPT.h>

//Numbers of the Fibonacci sequence

int main()
{
double keepAlive;
keepAlive=0;
while (keepAlive == 0){

  double n,f,first,second,c;

  cout << "How many numbers of the Fibonacci sequence do you want? ";

  cin >> n;

  if (n > 0) {

  first=1; second=0; c=0;
  
  while (c < n) {

    f=first+second;

    first=second;
    
    second=f;

    c=c+1;

  }
  } else if (n < 0) {

  first=0; second=1; c=0;
  
  while (c > n) {

    f=second-first;

    second=first;
    
    first=f;

    c=c-1;

  }
  } else {

    f=0;

  }

  cout << f << "\n";

}
}
