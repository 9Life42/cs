#include <FPT.h>

// Draw a star

void star(double click[], double r)
{
	double p, i, x[3], y[3];
	
	p = 2 * M_PI / 5;

	x[0] = click[0];
	y[0] = click[1];

	i = 0;

	while (i < 5) {

		x[1] = r * sin(i * p) + click[0];
		y[1] = r * cos(i * p) + click[1];

		x[2] = r * sin((i + 2) * p) + click[0];
		y[2] = r * cos((i + 2) * p) + click[1];

	    G_fill_polygon(x, y, 3);
	    
	    i++;

	}

}

int main()
{
G_init_graphics (601, 601);
char on = 0; while (on != 'q') {
	
	double c[2], i, p;

	G_rgb(0, 0, 0);

	p = 2 * M_PI / 13;

	i = 0;

	while (i < 13) {

		c[0] = 100 * sin(i * p) + 300;
		c[1] = 100 * cos(i * p) + 300;

	    star(c, 20);
	    
	    i++;

	}

	G_wait_click(c);

	star(c, 20);

on = G_wait_key();
}
}
