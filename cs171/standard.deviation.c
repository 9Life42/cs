#include <FPT.h>

//Average test scores with standard deviation

int main()
{
double keepAlive=0;
while (keepAlive == 0){

  double x,sum,c,mean,scores[100];
  int a=0;

  x=0; sum=0; c=0;

  cout << "Enter a score: ";

  cin >> x;

  while (x >= 0) {

    a += 1;

    scores[a] = x;

    sum=sum+x;

    c=c+1;

    cout << "Enter another score or -1 to end: ";

    cin >> x;

  }

  mean = sum/c;

  cout << "The average is: " << mean << "\n";

  sum = 0;

  while (a > 0) {

    sum += pow((mean - scores[a]), 2);

    a -= 1;

  }

  cout << "The standard deviation is: " << sqrt(sum / c) << "\n";

}
}
