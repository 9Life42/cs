#include <FPT.h>

// Introduction to functions

int fac(int n)
{

  int product = 1;

  while (n > 0)
    {
      product *= n;

      n--;

    }

  return product;

}

int freedom(int friends, int invites)
{
  int choices;

  choices = (fac(friends) / (fac(invites) * fac(friends - invites)));

  return choices;

}

int main()
{

  int friends1, friends2, invites1, invites2, choices1, choices2;

  cout << "Person 1: ";

  cin >> friends1;

  cin >> invites1;

  cout << "Person 2: ";

  cin >> friends2;

  cin >> invites2;

  choices1 = freedom(friends1, invites1);

  choices2 = freedom(friends2, invites2);

  cout << choices1 << "\n";

  cout << choices2 << "\n";

  if (choices1 > choices2) {

    cout << "The first has more choices\n";

  } else {

    cout << "The second has more choices\n";

  }

}
