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
  ii = 0;

  second = 1;

  while (ii < 100 && inn[i] != '\0') {

    if (inn[i] == 'a' || inn[i] == 'e' || inn[i] == 'i' || inn[i] == 'o' || inn[i] == 'u') {

      out[ii] = inn[i];

      i++;
      ii++;

    } else {

      out[ii] = inn[i];

      i++;
      ii++;

      second = -1 * second;

      if (second == 1) {

	out[ii] = 'X';
	ii++;

      }
    }
  }

  out[ii] = '\0';

  cout << out << "\n";
}
}
