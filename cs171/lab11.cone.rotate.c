#include <FPT.h>

// Draws a rotating cone movie with one slice a different color

int main()
{
  double swidth, sheight ;
  swidth = 601 ;  sheight = 601 ;
  G_init_graphics (swidth, sheight);

  int res, numpoints;

  double r, x[3], y[3], p, i, k;

  k = 0;

  res = 47;

  p = (M_PI / (res / 2));

  numpoints = 3;

  while (true) {

    G_rgb(1, 1, 1);
    G_clear();
    G_rgb(0, 0, 0);

    i = 0;

    while(i < res) {

      x[1] = 240 * cos((i + 1 + k/4) * p) + 300;

      y[1] = 80 * sin((i + 1 + k/4) * p) + 450;

      x[2] = 240 * cos((i + k/4) * p) + 300;

      y[2] = 80 * sin((i + k/4) * p) + 450;

      x[0] = 300;

      y[0] = 450;

      G_fill_polygon (x, y, numpoints);

      i++;

      x[1] = 240 * cos((i + 1 + k/4) * p) + 300;

      y[1] = 80 * sin((i + 1 + k/4) * p) + 450;

      x[2] = 240 * cos((i + k/4) * p) + 300;

      y[2] = 80 * sin((i + k/4) * p) + 450;

      x[0] = 300;

      y[0] = 150;

      if (y[1] < 436 && y[2] < 436) {

        G_fill_polygon (x, y, numpoints);

      }

      i++;

    }

    G_rgb(1, 0, 0);

    x[1] = 240 * cos((1 + k/4) * p) + 300;

    y[1] = 80 * sin((1 + k/4) * p) + 450;

    x[2] = 240 * cos((k/4) * p) + 300;

    y[2] = 80 * sin((k/4) * p) + 450;

    x[0] = 300;

    y[0] = 450;

    G_fill_polygon (x, y, numpoints);
    
    if (y[1] < 436 && y[2] < 436) {

      x[0] = 300;

      y[0] = 150;

      G_fill_polygon (x, y, numpoints);

    }
    
    G_rgb(0, 0, 0);

    k++;

    i = G_wait_key();

    if (i == 'q') {

      break;

    }

  }
}