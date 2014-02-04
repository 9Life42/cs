#include <FPT.h>

// Draw a line with circles on it

int main()
{

    double p[2], x1, x2, y1, y2, x3, y3, n, f, i, r;

    cout << "Enter number of slices: ";

    cin >> n;

    f = 1 / n;

    G_init_graphics (601, 601);
    char on = 0; while (on != 'q') {

    G_wait_click(p);
    x1 = p[0];
    y1 = p[1];

    G_fill_circle(x1, y1, 2);

    G_wait_click(p); 
    x2 = p[0];
    y2 = p[1];

    G_fill_circle(x2, y2, 2);

    G_line (x1, y1, x2, y2);

    G_display_image();
    // Forces buffer display

    r = sqrt(pow(x1 - x2, 2) + pow(y1 - y2, 2)) / (2 * n);

    i = 0;

    while(i <= n) {

        x3 = x1 + i * f * (x2 - x1);

        y3 = y1 + i * f * (y2 - y1);

        G_fill_circle(x3, y3, 2);

        G_circle(x3, y3, r);

        i++;

   }

on = G_wait_key(); }
}
