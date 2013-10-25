#include <FPT.h>

// Output how much p pennies are worth

int main()
{
  double p,d,q,i,n;

  cout << "How many pennies?";

  cin >> p;

  cout << p;

  if(p == 1){cout << " penny is worth";}
  else if(p == 0){cout << " pennies are worth nothing";}
  else {cout << " pennies are worth";}

  d=floor(p/100);

  p=p-d*100;

  q=floor(fmod(p,100)/25);

  p=p-q*25;

  i=floor(fmod(p,25)/10);

  p=p-i*10;

  n=floor(fmod(p,10)/5);

  p=p-n*5;

  if(d == 1) {cout << ", " << d <<" dollar";}
  else if (d > 0) {cout << ", " << d << " dollars";}

  if(q == 1) {cout << ", " << q <<" quarter";}
  else if (q > 0) {cout << ", " << q << " quarters";}

  if(i == 1) {cout << ", " << i <<" dime";}
  else if (i > 0) {cout << ", " << i << " dimes";}

  if(n == 1) {cout << ", " << n <<" nickel";}
  else if (n > 0) {cout << ", " << n << " nickels";}

  if(p == 1) {cout << ", " << p <<" cent";}
  else if (p > 0) {cout << ", " << p << " cents";}

  cout << ".\n";
}
