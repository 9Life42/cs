#include <FPT.h>

//Is this a palindrome? YES or NO
//racecar, mom, a, wow

int main()
{
double keepAlive=0;
while (keepAlive == 0){

  int n,nn;
  char word1[100],word2[100],concat[100];

  cout << "Enter two words: ";

  cin >> word1 >> word2;

  n=0;
  nn=0;

  while (n < 100 && word1[n] != '\0') {

    if (word1[n] >= 'A' && word1[n] <= 'Z') {

      concat[nn]=word1[n];

      nn++;

    }

    n++;

  }

  n=0;

  while (n < 100 && word2[n] != '\0') {

    if (word2[n] >= 'a' && word2[n] <= 'z') {

      concat[nn]=word2[n];

      nn++;

    }

    n++;

  }

  concat[nn]='\0';

  cout << concat << "\n";

}
}
