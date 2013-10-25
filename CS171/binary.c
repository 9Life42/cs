#include <FPT.h>

//Output the binary representation of a number

int main()
{
double keepAlive=0;
while (keepAlive == 0){

  double x,remainder[100];
  int a;

  cout << "Input a number to convert to binary: ";

  cin >> x;

  a = -1;

  cout << "The binary is: ";

  do {

    a += 1;

    remainder[a] = fmod(x, 2);

    x = floor(x / 2);

  } while (x > 0);

 while (a >= 0) {

    cout << remainder[a];

    a -= 1;

  }

  cout << "\n";

}
}
