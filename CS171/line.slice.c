#include <FPT.h>

// Draw a line with circles on it

int main()
{
double swidth, sheight ;
swidth = 601 ;  sheight = 601 ;
G_init_graphics (swidth, sheight);
char on = 0; while (on != 'q') {

    int n;
    double p[2], q[2], x1, x2, y1, y2;

    cout << "enter number of slices";

    cin > n;

    G_wait_click(p);  
    x1 = p[0] ; y1 = p[1];

    G_fill_circle(x1, y1, 2);

    G_wait_click(q);  
    x2 = q[0] ; y2 = q[1];

    G_fill_circle(x2, y2, 2);

    G_line (x1, y1, x2, y2);

    while(i < n) {

    G_fill_circle((x1 + x1 + x2) / 3, (y1 + y1 + y2) / 3, 2);

    G_circle((x1 + x1 + x2) / 3, (y1 + y1 + y2) / 3, 2);

   }

on = G_wait_key(); }
}
