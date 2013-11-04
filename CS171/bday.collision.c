#include <FPT.h>

// Monte Carlo simulator: throw 25 pennies, probability of getting 10+ heads

int main()
{ double keepAlive = 0; while (keepAlive == 0) {

    int n, i, j, k;

    cin >> n;

    double bday[n], counter, repeat;

    counter = 0;

    j = 0;

    while (j < 2000000) {

    i = 0;

    while (i < n) {

      bday[i]=floor(drand48() * 365) + 1;

      repeat = 0;

      k = 0;

      while (k < i) {

	if (bday[k] == bday[i]) {

	  repeat++;

	  break;

	}

	k++;

      }

      if (repeat == 1) {

	counter++;

	break;

      } else {

	i++;

      }

    }

    j++;

    }

   cout << counter / (j - 1) << "\n";

  }
}
