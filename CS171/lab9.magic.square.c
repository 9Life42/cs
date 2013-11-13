#include <FPT.h>

// Test a magic square (no int is used twice and sum of rows, columns, diagonals the same)

int sum(int n)
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

    double r, c;

    cin >> r;

    c = r;

    double magic[r][c], i, k, square, sum, magic;

    magic = 0;

    square = r * c;

    sum = 0;

    i = 0;

    while (i < r) {

      k = 0;

      while (k < c) {

        sum += magic[r][c];

        k++;

      }

      i++;

    }

    if (sum != sum(square)) {

      magic++;

    }

  }
}
