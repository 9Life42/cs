#include <FPT.h>

// Draws a rotating cylinder movie

int main()
{
	double swidth, sheight ;
  swidth = 601 ;  sheight = 601 ;
  G_init_graphics (swidth, sheight);

  int res, numpoints;

 	double r, x[3], y[3], p, i, k;

 	k = 0;

 	res = 47;

 	p = M_PI / (res / 2);

  numpoints = 3;

 	while (true) {

		G_rgb(1, 1, 1);
   	G_clear();
		G_rgb(0, 0, 0);

    i = 0;

    while(i < res) {

      x[0] = 300;

      y[0] = 150;

      x[1] = 240 * cos((i + 1 + k/4) * p) + 300;

      y[1] = 80 * sin((i + 1 + k/4) * p) + 450;

      x[2] = 240 * cos((i + k/4) * p) + 300;

      y[2] = 80 * sin((i + k/4) * p) + 450;

      if (sin((i + 1 + k/4) * p) < -0.17 && sin((i + k/4) * p) < -0.17) {

        G_fill_polygon (x, y, numpoints);

      }

      i+=2;

    }

    i = 0;

    while (i < res) {

      x[0] = 300;

      y[0] = 450;

      x[1] = 240 * cos((i + 1 + k/4) * p) + 300;

      y[1] = 80 * sin((i + 1 + k/4) * p) + 450;

      x[2] = 240 * cos((i + k/4) * p) + 300;

      y[2] = 80 * sin((i + k/4) * p) + 450;

      G_fill_polygon (x, y, numpoints);

      i+=2;

    }

   	k++;

   	i = G_wait_key();

   	if (i == 'q') {

   		break;

   	}
    
  }
}