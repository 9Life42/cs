#include <FPT.h>

// Draws a bull's eye.

int main()
{

   double swidth, sheight ;
   swidth = 601 ;  sheight = 601 ;
   G_init_graphics (swidth, sheight);

   int r = 600;

   while (r > 0) {

      if (fmod(r, 20) == 0) {

            G_rgb(0, 0, 0);

         } else {

            G_rgb(1, 0, 0);

         }

      G_fill_circle(300, 300, r);

      r -= 10;

   }

   r = G_wait_key();

}