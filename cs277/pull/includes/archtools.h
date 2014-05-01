#ifndef _ARCH_TOOLS_H
#define _ARCH_TOOLS_H
#include<time.h>

#define RANDOM_M_SEED 1
#define RANDOM_M_NEXT 0


typedef struct stopwatch_t {
  clock_t started;
  clock_t stopped;
} *Stopwatch;

Stopwatch new_stopwatch();
void destroy_stopwatch(Stopwatch);
long stopwatch_milliseconds(Stopwatch);
long stopwatch_seconds(Stopwatch);
clock_t stopwatch_start(Stopwatch);
clock_t stopwatch_stop(Stopwatch);
void stopwatch_reset(Stopwatch);

int * random_ints(unsigned int, int, int);
#endif
