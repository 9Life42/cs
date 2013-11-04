#include <FPT.h>

// Monte Carlo simulator: throw 25 pennies, probability of getting 10+ heads

int main()
{ double keepAlive = 0; while (keepAlive == 0) {

    int i, j, p, c, cc;

    i = 0;
    cc = 0;

    while (i < 1000000) {

      j = 0;
      c = 0;

      while (j < 25) {

	p = floor(drand48() *2);

	if (p == 0) {

	  c = c + 1;

	}

	j = j + 1;

      }

      if (c >= 10) {

	cc = cc + 1;

      }

      i = i + 1;

    }

    cout << (cc * 1.0)/i;

    cin >> keepAlive;
  }
}
