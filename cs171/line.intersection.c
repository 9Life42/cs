#include <FPT.h>

// Find the intersection of two lines

int main()
{
G_init_graphics (601, 601);
char on = 0; while (on != 'q') {

	double p[2], x1, x2, y1, y2, x3, y3, x4, y4, m1, m2, x, y;

	G_wait_click(p);
    x1 = p[0];
    y1 = p[1];
    G_fill_circle(x1, y1, 2);

    G_wait_click(p);
    x2 = p[0];
    y2 = p[1];
    G_fill_circle(x2, y2, 2);

    G_line (x1, y1, x2, y2);

    G_wait_click(p);
    x3 = p[0];
    y3 = p[1];
    G_fill_circle(x3, y3, 2);

    G_wait_click(p);
    x4 = p[0];
    y4 = p[1];
    G_fill_circle(x4, y4, 2);

    G_line (x3, y3, x4, y4);

    m1 = (y1 - y2) / (x1 - x2);
    m2 = (y3 - y4) / (x3 - x4);

    x = (m1*x1 - m2*x3 - y1 + y3) / (m1 - m2);
    y = m1 * (x - x1) + y1;

    G_fill_circle(x, y, 2);
    
on = G_wait_key();
}
}
