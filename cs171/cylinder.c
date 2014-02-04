#include <FPT.h>

// Draws a rotating cylinder movie

int main()
{
	double swidth, sheight ;
    swidth = 601 ;  sheight = 601 ;
    G_init_graphics (swidth, sheight);

    int x1, y1, x2, y2;

    int r, i, res;

   	double x, y, p, k;

   	k = 0;

   	res = 47;

   	p = M_PI / (res / 2);

   	while (true) {

		G_rgb(1, 1, 1);
   		G_clear();
		G_rgb(0, 0, 0);

   		i = 0;

   	while (i < res) {

      	x1 = 200 * cos((i + k/2) * p) + 300;

      	y1 = 100 * sin((i + k/2) * p) + 450;

      	x2 = 200 * cos(i * p) + 300;

      	y2 = 100 * sin(i * p) + 150;

      	G_line(x1, y1, x2, y2);

      	i++;
   	}

   	k++;

   	i = G_wait_key();

   	if (i == 'q') {

   		break;

   	}

   }

}