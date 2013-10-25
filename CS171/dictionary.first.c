#include <FPT.h>

// Output the word that comes first in the dictionary

int main()
{
double keepAlive=0;
while (keepAlive == 0){

  int n;
  char a[100],b[100];

  cout << "Enter first word: ";

  cin >> a;

  cout << "Enter second word: ";

  cin >> b;

  n=0;

  while (a[n] == b[n] && a[n] != '\0' && b[n] != '\0') {

    n += 1;

  }

  if (a[n] < b[n]) {

    cout << a << " occurs first.\n";

  } else {

    cout << b << " occurss first.\n";

  }

}
}
