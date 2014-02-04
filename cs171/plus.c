#include <FPT.h>

// Nested Loop to output "+"s

int main()
{ double keepAlive=0; while (keepAlive == 0) {

    double c,n,r;

    cin >> n;

    r = n;

    while (r >= 0) {

      c = 1;

      while (c <= r) {

	cout << "+";

	c = c + 1;

      }

      cout << "\n";

      r = r - 1;

    }
  }
}
