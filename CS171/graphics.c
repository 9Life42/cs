#include <FPT.h>   

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

      G_line(i, 0, i, 600);
      G_line(0, i, 0, i);

      G_rgb(drand48(), drand48(), drand48());

      G_fill_rectangle(i, i, 10, 10);

      i += 20;
   }

   while (i < swidth) {
      G_rgb(0, 0, 0);

      G_line(i, 0, i, 600);
      G_line(0, i, 0, i);

      G_fill_rectangle(i, i, 10, 10);

      i += 10;
   }

   i = G_wait_key();
}