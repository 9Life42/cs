#include <FPT.h>

// Dice rolls stats

int main()
{ double keepAlive = 0; while (keepAlive == 0) {

    int i, r, dex[7];

    i = 0;

    while (i < 7) {

      dex[i] = 0;

      i++;

    }

    i = 0;

    while (i < 6000000) {

      //r = sqrt(4);
      //r = drand48();
      r = floor(drand48() * 6) + 1;

      dex[r]++;

      i++;
    }

      i = 1;

    while (i < 7) {

      cout << "i: " << dex[i] << "\n";

      i++;

    }

      cin >> keepAlive;
  }
}
