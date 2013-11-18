#include <FPT.h>

// Make this find the area of two polygons

double perimeter(double x[100], double y[100], int size) {

  double per = 0;

  int i = 1;

  while (i < size) {

    per += sqrt(pow((x[i] - x[i - 1]), 2) + pow((y[i] - y[i - 1]), 2));

    i++;

  }

  i--;

  per += sqrt(pow((x[0] - x[i]), 2) + pow((y[0] - y[i]), 2));

  return per;

}

int inputPolygon(double x[100], y[100]) {

  int n, i;

  cin >> n;

  i = 0;

  while (i < n) {

    cin >> x[i] >> y[i];

    i++;

  }

  return n;

}

int main()
{ double keepAlive = 0; while (keepAlive == 0) {

    double px[100], py[100], qx[100], qy[100];
    int psize, qsize;
    double pper, qper;

    px[0] = 500;
    py[0] = 100;

    px[1] = 500;
    py[1] = 300;

    px[2] = 400;
    py[2] = 400;

    px[3] = 100;
    py[3] = 300;

    px[4] = 200;
    py[4] = 100;

    psize = 5;

    qx[0] = 200;
    qy[0] = 500;

    qx[1] = 500;
    qy[1] = 0;

    qx[2] = 100;
    qy[2] = 100;

    qx[3] = 100;
    qy[3] = 500;

    qsize = 4;

    psize = inmutPolygon(px, py);
    qsize = inmutPolygon(qx, qy);

    cout << perimeter(px, py, psize) << "\n";

    cout << perimeter(qx, qy, qsize) << "\n";

    keepAlive++;

  }
}
