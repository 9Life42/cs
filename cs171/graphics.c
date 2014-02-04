#include <FPT.h>

// Does a checker board.

int main()
{
   double swidth, sheight ;
   swidth = 601 ;  sheight = 601 ;
   G_init_graphics (swidth, sheight);

   int i, k;

   G_rgb(0, .5, 0);
   G_clear();

   i = 0;

   while (i < swidth) {

      k = 0;

      while (k < sheight){

         if (fmod(i + k, 20) == 0) {

            G_rgb(0, 1, 0);

         } else {

            G_rgb(1, 0, 0);

         }

         G_fill_rectangle(k, i, 10, 10);

        k += 10;

      }

      i += 10;
   }

   G_rgb(0, 0, 0);

   i = 0;

   while (i < swidth) {

      G_line(i, 0, i, 600);
      G_line(0, i, 600, i);

      i += 10;
   }

   i = G_wait_key();
   
}