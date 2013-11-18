#include <FPT.h>

// Draws a bull's eye.

int main()
{

   double swidth, sheight ;
   swidth = 601 ;  sheight = 601 ;
   G_init_graphics (swidth, sheight);

   int r, i;

   r = 300;

   i = 0;

   double x, y, p;

   p = M_PI / 18;

   while (i < 36) {

      x = 300 * cos(i * p);

      y = 300 * sin(i * p);

      G_line(300, 300, 300 + x, 300 + y);

      i++;
   }

   while (r > 0) {

      // if (fmod(r, 20) == 0) {

      //       G_rgb(0, 0, 0);

      //    } else {

      //       G_rgb(1, 0, 0);

      //    }

      G_circle(300, 300, r);

      r -= 10;

   }

   r = G_wait_key();

}