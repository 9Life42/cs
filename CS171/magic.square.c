

 #include <FPT.h>
 int main()
 {

 double m[100][100];
 int dimension,r,c; 

   cin >> dimension;

   r=0;

   while (r<dimension){

     c=0;

     while (c<dimension) {

       cout << r << "," << c << ":";
       cin >> m[r][c];
       cout <<"done";
       c++;

     }

     r++;

   }

   cout << dimension << "\n";

    r = 0;

    while (r<dimension) {

      c = 0;

      while (c<dimension) {

        cout << m[r][c] << " ";

        c++;

      }

      cout << "\n";

      r++;

    }

   }

