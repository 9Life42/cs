#include <FPT.h>

// Make this find the area of two polygons

int inputPolygon(double x[], double y[]) {

  int n, i;

  cout << "How many sides? \n";

  cin >> n;

  i = 0;

  cout << "Give the x and y coordinates of each point consecutively. \n";

  while (i < n) {

    cin >> x[i] >> y[i];

    i++;

  }

  return n;

}

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

double area(double x[100], double y[100], int size) {

  double area, s, a, b, c;

  int i = 1;

  area = 0;

  while (i < size - 1) {

    a = sqrt(pow((x[i] - x[0]), 2) + pow((y[i] - y[0]), 2));

    b = sqrt(pow((x[i + 1] - x[i]), 2) + pow((y[i + 1] - y[1]), 2));

    c = sqrt(pow((x[0] - x[i + 1]), 2) + pow((y[0] - y[i + 1]), 2));

    s = (a + b + c) / 2;

    area += sqrt(s * (s - a) * (s - b) * (s - c));

    i++;

  }

  return area;

}

int main()
{

  double px[100], py[100], qx[100], qy[100];
  int psize, qsize;
  double pper, qper;

  // psize = inputPolygon(px, py);
  // qsize = inputPolygon(qx, qy);

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

  psize = inputPolygon(px, py);
  qsize = inputPolygon(qx, qy);

  cout << perimeter(px, py, psize) << "\n";
  cout << perimeter(qx, qy, qsize) << "\n";

  cout << area(px, py, psize) << "\n";
  cout << area(qx, qy, qsize) << "\n";

  // G_Wait_Key();

}
