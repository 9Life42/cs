#include <FPT.h>

// Test a magic square (no int is used twice and sum of rows, columns, diagonals the same)

int targetSum(int n)
{

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

    int magic[r][c], i, k, square, sum, iSum, magic;

    magic = 0;

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

      magic++;

    }

    iSum = sum/3

    // Make sure each row sums to the correect number

    sum = 0;

    i = 0;

    while (i < r) {

      sum = 0;

      k = 0;

      while (k < c) {

        sum += magic[i][k];

        k++;

      }

      if (sum != iSum) {

        magic++;

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

        magic++;

      }

      i++;

    }

    sum = 0;

    k = 0;

    while (k < c) {

      sum += magic[k][k];

      k++;

    }

    if (sum != iSum) {

      magic++;

    }

    sum = 0;

    k = 0;

    while (k < c) {

      sum += magic[r - k][k];

      k++;

    }

    if (sum != iSum) {

      magic++;

    }

    if (magic == 0) {

      cout << "Magic!\n"

    } else {

      cout << "Nope...\n"

    }

    keepAlive++;

  }
}
