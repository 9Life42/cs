
#include <FPT.h>
int main()
//things to do : make the checker of sums check against the same one four times before moving on... 
//also put in checker at end for checking the sum of each individual vertical row (if just one exists),against sum of each individual horizontal row, against the diagonal sum, etc...

{double m[100][100],w[10],x[10],check,equation,magicsquare,horizontalcheck, verticalcheck, diagonalcheck,horiztotal,verttotal,firstdiagonal,seconddiagonal,sumtotal;
//m[10][11] 10=number of rows, 11=number of columns. there should be one more column than row for the answer
  int dimension,simplearray,r,c,lastr,total; 
 


  //puts number identifying dimension of the square into dimension,working
  cin >> dimension;

  //zeros out w[total],x[total],working
  total=dimension-1;
  while (total>=0){
    w[total]=0;
     total=total-1;
   }

  total=dimension-1;

  while (total>=0){
    x[total]=0;
    total=total-1;
    }

  //puts the square into the array m[] & puts horizontal sums into array,getting stuck, not adding r the last time
  r=0;
  total=0;
  while (r<dimension){
    // cout << "I got here\n";
    c=0;
    horiztotal=0;
    while (c<dimension) {

      cout << r << "," << c << ":";
      cin >> m[r][c];
      cout <<"done";
      horiztotal=horiztotal+m[r][c];
      c++;

    }
    r++;
    w[total]=horiztotal;
    total++;
    // cout << r;  
  // cout <<" I GOT HERE!!\n";
  // cout << r;
  }
  total=total-1;
  check=0;
  //total is at (dimension-1) by this point
  //checks horizontal sums
  while (total>0){
    if(w[total]==w[total-1]){
      check++;
      }
    total=total-1;} 
  cout << "check";
  //if passes every test, horizontalcheck will turn into 1
  if (check==(dimension-1)){
      horizontalcheck++;}
    //vertical sums into an array 
  c=0;
  total=0;
  while (c<dimension){
    r=0;
    while (r<dimension){
      verttotal=verttotal+m[r][c];
      r++;}
    x[total]=verttotal;
    total++;
    c++;}
  //total should be 3
  //check vertical sums
  total=total-1;
  check=0;
  while (total>0){
    if (x[total]==x[total-1]){
      check++;}
      total=total-1;}
  //if passes every test, verticalcheck will turn into 1
  if (check==(dimension-1)){
    verticalcheck++;}
  //does first diagonal (starting with row 1 column 1)
  r=0;
  c=0;
  firstdiagonal=0;
  while ((c<dimension)&&(r<dimension)){
    firstdiagonal=firstdiagonal+m[r][c];
    r++;
    c++;}

  //does second diagonal (starting with row 1 column 5
  r=0;
  c=dimension-1;
  seconddiagonal=0;
  while ((c>=0)&&(r<dimension)){
    seconddiagonal=seconddiagonal+m[r][c];
    r++;
    c=c-1;}
  //if the two diagonals equal eachother, diagonalcheck=1
  diagonalcheck=0;
  if (firstdiagonal==seconddiagonal){
    diagonalcheck++;}

  //if all horizontal and vertical are the same (respectively), check to see if they are the same (across the board) and hten check with diagonal.
  magicsquare=0;

  if ((horizontalcheck==1)&&(verticalcheck==1)){
      if (diagonalcheck==horizontalcheck){
	magicsquare++;}
      }

  //magicsquare should equal 1 if it is a magicsquare

  if (magicsquare==1){
    cout << "yes\n";}

  else {
    cout << "no\n";}

}
