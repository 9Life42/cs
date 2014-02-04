#include <FPT.h>

//double x[13] = {175,225,225,300,225,225,250,200,150,175,175,100,175} ;
//double y[13] = {300,300,250,225,225,200,100,175,100,200,225,225,250} ;
//int n = 13 ;


double x[13] = {0.0} ;
double y[13] = {0.0} ;
int n = 1 ;

int size ;



void translate (double dx, double dy)
// NOTICE that translation is now with respect
// to the screen size
{
  int i ;

  i = 0 ;
  while (i < n) {
     x[i] = x[i] + dx*size ;
     y[i] = y[i] + dy*size ;
     i = i + 1 ;
  }

}




void scale (double sx, double sy)
{
  int i ;

  i = 0 ;
  while (i < n) {
     x[i] = sx * x[i] ;
     y[i] = sy * y[i] ;
     i = i + 1 ;
  }

}




void rotate (double degrees)
{
  double radians,c,s,t ;
  int i ;

  radians = degrees*M_PI/180.0 ;
  c = cos(radians) ;
  s = sin(radians) ;

  i = 0 ;
  while (i < n) {
      t    = x[i]*c - y[i]*s ;
      y[i] = y[i]*c + x[i]*s ;
      x[i] = t ;
      i = i + 1 ;
  }

}



//////////////////////////////////////////////////

void diagonal_line(double r)
{
   if (r < 0.5) {
     scale(0.5, 0.5) ;

   } else {
     scale(0.5, 0.5) ;
     translate(0.5, 0.5) ;
   }
}



void  filled_triangle (double r)
{
   if (r < 0.25) {
     scale(0.5, 0.5) ;

   } else if (r < 0.50) {
     scale(0.5, 0.5) ;
     translate(0.5, 0.0) ;

   } else if (r < 0.75) {
     scale(0.5, 0.5) ;
     translate(0.0, 0.5) ;

   } //else {
   //   scale(0.5, 0.5) ;
   //   rotate(180) ;
   //   translate(0.5, 0.5) ;
   // }
}




int main() 
{
 double j,r,q ;

 size = 600 ;
 G_init_graphics(size, size) ;
 G_rgb(0, 0, 0) ;
 G_clear() ;

 G_rgb(1.0, 0.0, 0.0) ;

 j = 0 ;
 while (j < 500000) {

   r = drand48() ;

   // diagonal_line(r) ;
     filled_triangle(r) ;

   G_point (x[0], y[0]) ;

   j=j+1 ;
 }

 q = G_wait_key() ;

}


