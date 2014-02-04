#include <FPT.h>

//Is this a palindrome? YES or NO
//racecar, mom, a, wow

int main()
{double keepAlive=0; while (keepAlive == 0)
{

  int n,nn;
  char word[100],pal;

  cout << "Enter a word to see if it's a palindrome: ";

  cin >> word;

  n = 0;
  nn = 0;
  pal = 0;

  while (word[nn+1] != '\0') {

    nn++;

  }

  while (nn > n) {

    if (word[n] != word[nn]) {

      pal++;

    }

    n++;
    nn--;

  }

  if (pal > 0) {

    cout << "NO\n";

  } else {

    cout << "YES\n";

  }

}
}
