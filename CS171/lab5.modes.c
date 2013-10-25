#include <FPT.h>

// Find all modes in a set of test scores (whole numbers 0 to 100)

int main()
{
double keepAlive=0;
while (keepAlive == 0){

  double max,scores[101];
  int n,x;

  n=0;

  while (n < 101) {

    scores[n]=0;

    n += 1;

  }

  cout << "Enter the scores: ";

  cin >> x;

  while (x >= 0) {

    scores[x] += 1;

    cin >> x;

  }

  n=0;
  max=0;

  while (n < 101) {

    if (scores[n] > max) {

      max = scores[n];

    }

    n += 1;

  }

  n=0;

  cout << "The modes are:";

  while (n < 101) {

    if (scores[n] == max) {

      cout << " " << n;

    }

    n += 1;

  }

  cout << "\n";

}
}
