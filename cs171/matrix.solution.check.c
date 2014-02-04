#include <FPT.h>

// Check the solution for an array of 

int main()
{ double keepAlive = 0; while (keepAlive == 0) {

    int numeqns, numvars, c, r;

    double m[10][11], x[10], sum, wrong;

    wrong = 0;

    cin >> numeqns;
    cin >> numvars;

    r = 0;

    while (r < numeqns) {

      c = 0;

      while (c <= numvars) {

	cin >> m[r][c];

	c++;

      }

      r++;

    }

    c = 0;

    while (c < numvars) {

      cin >> x[c];

      c++;

    }

    r = 0;

    while (r < numeqns) {

      c = 0;

      sum = 0;

      while (c < numvars) {

	sum = sum + (m[r][c] * x[c]);

	c++;

      }

      if (sum != m[r][c]) {

	wrong++;

      }

      r++;

    }

    if (wrong > 0) {

      cout << "false\n";

    } else {

      cout << "true\n";

    }

    keepAlive = 1;

  }
}
