#include <FPT.h>

int main()
{ double keepAlive = 0; while (keepAlive == 0) {

    double c,n,r,s;

    cin >> n;

    r = 0;

    while (r < n) {

      c = 0;

      while (c < n - r) {

	cout << " ";

	c = c + 1;

      }

      c = 0;

      while (c <= r * 2) {

	cout << "+";

	c = c + 1;

      }

      cout << "\n";

      r = r + 1;

    }
  }
}
