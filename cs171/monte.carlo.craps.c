#include <FPT.h>

// Monte Carlo simulator for craps (sum of two die equal to 7 or 11?)

int main()
{ double keepAlive = 0; while (keepAlive == 0) {

    int i, d1, d2, c;

    i = 0;

    c = 0;

    while (i < 1000000) {

      d1 = floor(drand48() * 6) + 1;
      d2 = floor(drand48() * 6) + 1;

      if (d1 + d2 == 7 || d1 + d2 == 11) {

	c = c + 1;

      }

      i = i + 1;

    }

    cout << (c * 1.0)/i;

    cin >> keepAlive;
  }
}
