#include <FPT.h>

// Boxes around right triangle

int main()
{
G_init_graphics (601, 601);
char on = 0; while (on != 'q') {
	G_rgb(1, 1, 1);
   	G_clear();
	G_rgb(0, 0, 0);

	double p[2], x1, x2, y1, y2, x3, y3, w, h, polyX[4], polyY[4];

    G_wait_click(p);
    x1 = p[0];
    y1 = p[1];

    G_fill_circle(x1, y1, 2);

    G_wait_click(p); 
    x2 = p[0];
    y2 = p[1];

    G_fill_circle(x2, y2, 2);

    x3 = x2;

    y3 = y1;

    h = y2 - y3;

    w = x3 - x1;

    G_fill_circle(x3, y3, 2);

	G_rgb(1, 1, 1);
    G_fill_triangle(x1, y1, x2, y2, x3, y3);
    G_rgb(0, 0, 0);

    G_fill_rectangle(x3, y3, h, h);

    G_fill_rectangle(x1, y3 - w, w, w);

    polyX[0] = x1;
    polyY[0] = y1;

    polyX[1] = x2;
    polyY[1] = y2;

    polyX[2] = x2 - h;
    polyY[2] = y2 + w;

    polyX[3] = x1 - h;
    polyY[3] = y1 + w;

    G_fill_polygon(polyX, polyY, 4);

on = G_wait_key();
}
}
