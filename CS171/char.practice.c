#include <FPT.h>

//Characters

int main()
{
double keepAlive=0;
while (keepAlive == 0){

  int n;
  char name[100];

  cout << "Please enter your name: ";

  cin >> name;

  cout << "Good morning ";

  cout << name;

  cout << ", how are you today?\n";

  n=0;

  while (name[n] != '\0') {

    n += 1;

  }

  cout << "Your name is " << n << " letters long.\n";

}
}
