#include <FPT.h>

// Is the first or second half of a sequence of numbers greater?

int main()
{

  double num[100], x, sum1, sum2;
  int n, i, mid;

  cout << "Enter the scores or -1 to end: ";

  cin >> x;

  n = 0;

  while (x >= 0) {

    num[n] = x;

    cin >> x;

    n = n + 1;

  }

  n = n - 1;

  mid = n / 2;

  i = 0;

  sum1 = 0;

  sum2 = 0;

  while (i <= mid) {

    sum1 = sum1 + num[i];

    sum2 = sum2 + num[n-i];

    i = i + 1;

  }

  if (sum1 == sum2) {

    cout << "Both sums are equal\n";

  } else if (sum1 > sum2) {

    cout << "The first half has the greater sum, with " << sum1 << " vs only " << sum2 << "\n";

  } else {

cout << "The second half has the greater sum, with " << sum2 << " vs only " << sum1 << "\n";

  }

}
