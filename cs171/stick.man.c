#include <FPT.h>

// Falling stick man

// appropriate for a 600x600 window
double x[13] = {263,338,338,450,338,338,375,300,225,263,263,150,263} ;
double y[13] = {450,450,375,338,338,300,150,263,150,300,338,338,375} ;
int n = 13 ;


void translate (double dx, double dy)
{
  int i ;

  i = 0 ;
  while (i < n) {
    x[i] = x[i] + dx ;
    y[i] = y[i] + dy ;
    i = i + 1 ;
  }
}

void scale (double dx, double dy)
{
  int i ;

  i = 0 ;
  while (i < n) {
    x[i] = x[i] * dx ;
    y[i] = y[i] * dy ;
    i = i + 1 ;
  }
}

void rotate (double degrees)
{
  double radians, s, c, xx;

  radians = M_PI * (degrees / 180);
  s = sin(radians);
  c = cos(radians);

  int i ;

  i = 0 ;
  while (i < n) {
    xx = x[i] * c - y[i] * s ;
    y[i] = y[i] * c + x[i] * s ;
    x[i] = xx;
    i = i + 1 ;
  }
}

int main() 
{
  int q ;

  G_init_graphics(601, 601) ;

  while(q != 'q'){

    G_rgb(0,0,0) ;
    G_clear() ;

    G_rgb(0,0,1) ;
    G_fill_polygon(x,y,n) ;

    translate(-300, -300) ;
    scale(0.9, 0.9);
    rotate(18);
    translate(300, 300) ;

    q = G_wait_key() ;

  }

}

/*
Given x, y, B
find x1, y1
r = sqrt(x^2 + y^2)

tan(a) =  y / x
a = atan2(y, x)

x1 / r = cos(a + B)
x1 = r * cos(a + B)
x1 = r * (cos(a) * cos(B) - sin(a) * cos(B))
x1 = [r * cos(a)] * cos(B) - [r * sin(a)] * cos(B)
x1 = [x] * cos(B) - [y] * cos(B)

y1 = r * sin(a + B)
*/
