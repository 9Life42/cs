#include <FPT.h>

// Is each number greater than all successors combined?

int main()
{

  double num[100], x, sum, less;
  int n, i;

  cout << "Enter the numbers or -1 to end: ";

  cin >> x;

  n = 0;

  while (x >= 0) {

    num[n] = x;

    cin >> x;

    n = n + 1;

  }

  i = 0;

  sum = 0;

  while (i < n) {

    sum = sum + num[i];

    i = i + 1;

  }

  i = 0;

  less = 0;

  while (i < n) {

    sum = sum - num[i];

    if (num[i] <= sum) {

      less = less + 1;

      break;

    }

    i = i + 1;

  }

  if (less > 0) {

    cout << "No, " << num[i] << " is not greater than the successor(s)\n";

  } else {

    cout << "Yes, all numbers are greater than their successors\n";

  }

}
