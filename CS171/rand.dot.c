#include <FPT.h>

// Randomly generate point in the square -1 < x < 1 and -1 < y < 1

int main()
{ double keepAlive = 0; while (keepAlive == 0) {

    double x, y, z, r, i, cyl, cone;

    i = 0;
    cyl = 0;
    cone = 0;

    while (i < 1000000) {

      x = (drand48() * 2) - 1;
      y = (drand48() * 2) - 1;
      z = (drand48() * 2);

      r = sqrt(x * x + y * y);

      if (r < 1) {

	cyl++;

	if(z / r > 2) {

	  cone++;

	}

      }

      i++;

    }

    cout << cyl/(i - 1) << "%\n";

    cout << M_PI/4 << "%\n";

    cout << cyl/cone << "\n";

    keepAlive = 1;

  }
}
