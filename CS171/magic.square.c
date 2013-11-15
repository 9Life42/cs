#include <FPT.h>

int main()
{

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

    cout << magic;
}
