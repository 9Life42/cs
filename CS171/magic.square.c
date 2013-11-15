#include <FPT.h>

int main()
{

    int r, c;

    cin >> r;

    c = r;

    int magic[r][c], i, k;

    // cin values

    i = 0;

    while (i < r) {

      k = 0;

      while (k < c) {

        cin >> magic[i][k];

        k++;

      }

      i++;

    }

    cout << r << "\n";

    i = 0;

    while (i < r) {

      k = 0;

      while (k < c) {

        cout << magic[i][k] << " ";

        k++;

      }

      cout << "\n";

      i++;

    }
}

// #include <FPT.h>
// int main()
// {

// double m[100][100];
// int dimension,r,c; 

//   cin >> dimension;

//   r=0;

//   while (r<dimension){

//     c=0;

//     while (c<dimension) {

//       cout << r << "," << c << ":";
//       cin >> m[r][c];
//       cout <<"done";
//       c++;

//     }

//     r++;

//   }
// }

