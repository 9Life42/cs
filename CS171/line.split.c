#include <FPT.h>
using namespace std;

// Draws a line from two clicks and then a point one third of the way along

int main()
{
double swidth, sheight ;
swidth = 601 ;  sheight = 601 ;
G_init_graphics (swidth, sheight);
char on = 0; while (on != 'q') {

    int i;
    double p[2], q[2], x1, x2, y1, y2;

    G_wait_click(p);  
    x1 = p[0] ; y1 = p[1];

    G_fill_circle(x1, y1, 2);

    G_wait_click(q);  
    x2 = q[0] ; y2 = q[1];

    G_fill_circle(x2, y2, 2);

    G_line (x1, y1, x2, y2);

    G_fill_circle((x1 + x1 + x2) / 3, (y1 + y1 + y2) / 3, 2);

   	on = G_wait_key();
}
}