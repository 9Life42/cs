#include <FPT.h>

//Insert 'X' after every second consonant

int main()
{ double keepAlive=0; while (keepAlive == 0)
{

  char inn[100], out[100];
  int i, ii, second;

  cout << "Enter a word: ";

  cin >> inn;

  i = 0;

  second = 1;

  while (i < 100 && inn[i] != '\0') {

    if (inn[i] == 'a' || inn[i] == 'e' || inn[i] == 'i' || inn[i] == 'o' || inn[i] == 'u') {

      out[i] = inn[i];

      i++;

    } else {

      out[i] = inn[i];

      i++;

      second = -1 * second;

      if (second == 1) {

	out[i] = 'X';

      }
    }
  }

  out[i] = '\0';

  cout << out << "\n";
}
}
