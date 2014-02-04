// Alternating harmonic practice problem

double n,num,i,sign,den;

cin >> n;

i=1; num=0; sign=1;

while (i <= n) {
  
  num = num + sign/i;
  sign = -sign;
  i=i+2;
  
 }

i=2; den=0; sign=1;

while (i <= n) {
  
  den = den + sign/i;
  sign = -sign;
  i=i+2;
  
 }

 cout << num/den << "\n";

// Add X practice problem

char w[100], n[100];
int i, j;

cin >> w;

i=0; j=0;
while (w[i] != '\0') {

  n[j]=w[i];j=j+1;

  if (w[i]!='a'&&...) {c=c+1;}

  if (c==2) {n[j]='X'; j=j+1; c=0;}

  i=i+1;

 }

// Test score modes lab

int c[100],k,max;

k=0;

while (k<=100) {

  c[k]=0; k=k+1;

 }

cin >> k;

while ((k >= 0) && (k <= 100)) {

  c[k] = c[k] + 1;

  cin >> k;

 }

max=c[0];
k=1;

while(k <= 100) {

  if (c[k] > max) {max = c[k];}

  k=k+1;

 }

k=0;

while (k <= 100) {

  if (c[k] == max) { cout << k << "\n"; }

  k=k+1;

 }

// Pi approx. lab
// With an alternate version

double n;

cout << "enter a positive odd number";

cin >> n;

thing = 1;
// thing = -1;

while (n >= 3) {
// while (n >= 1) {

  thing=2+n*n/thing;
  n=n-2;

  // thing = n*n/(2+thing);
  // n = n - 2;

 }

pi=4/(1+1*1/thing);
// pi=4/(1+thing);
