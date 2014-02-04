#include <FPT.h>

// Test a magic square (no int is used twice and sum of rows, columns, diagonals the same)

int targetSum(int n)
{

  // Find what the total sum should be

  int sum = 0;

  while (n > 0)
    {
      sum += n;

      n--;

    }

  return sum;

}

int main()
{ double keepAlive = 0; while (keepAlive == 0) {

    int r, c;

    cin >> r;

    c = r;

    int magic[r][c], i, k, square, sum, iSum, isMagic;

    // cin values

    i = 0;

    while (i < r) {

      k = 0;

      while (k < c) {

        cin >> magic[i][k];

        k++;

      }

      i++;

    }

    isMagic = 0;

    square = r * c;

    // Make sure all entries sum to the correect number

    sum = 0;

    i = 0;

    while (i < r) {

      k = 0;

      while (k < c) {

        sum += magic[i][k];

        k++;

      }

      i++;

    }

    if (sum != targetSum(square)) {

      isMagic++;

    }

    iSum = sum/r;

    // Make sure each row sums to the correect number

    i = 0;

    while (i < r) {

      sum = 0;

      k = 0;

      while (k < c) {

        sum += magic[i][k];

        k++;

      }

      if (sum != iSum) {

        isMagic++;

      }

      i++;

    }

    // Make sure each column sums to the correect number

    sum = 0;

    i = 0;

    while (i < r) {

      sum = 0;

      k = 0;

      while (k < c) {

        sum += magic[k][i];

        k++;

      }

      if (sum != iSum) {

        isMagic++;

      }

      i++;

    }

    // Make sure the down diagonal sums to the correect number

    sum = 0;

    k = 0;

    while (k < c) {

      sum += magic[k][k];

      k++;

    }

    if (sum != iSum) {

      isMagic++;

    }

    // Make sure the up diagonal sums to the correect number

    sum = 0;

    k = 0;

    while (k < c) {

      sum += magic[r - k - 1][k];

      k++;

    }

    if (sum != iSum) {

      isMagic++;

    }

    // Test for errors

    cout << isMagic;

    if (isMagic == 0) {

      cout << "Magic!\n";

    } else {

      cout << "Nope...\n";

    }

    keepAlive++;

  }
}
