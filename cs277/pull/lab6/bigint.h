#define BIG_INT_BIT_WIDTH 4096 
 
typedef /*put your type definition here */ big_int;

// required functions
big_int * new_big_int(unsigned int);
void destroy_big_int(big_int *);
void big_int_shiftl(big_int *, int);
void big_int_shiftr(big_int *, int);
void big_int_and(big_int *, const big_int *);
void big_int_or(big_int *, const big_int *);
void big_int_not(big_int *);
void big_int_xor(big_int *, const big_int *);
void big_int_add(big_int *, const big_int *);

// extra credit pack #1
int big_int_equals(const big_int *, const big_int *);
int big_int_gt(const big_int *, const big_int *);
int big_int_lt(const big_int *, const big_int *);

// extra credit pack #2
void to_hex(const big_int *, char *);
big_int * parse_hex(const char *);

// extra credit pack #3
void to_decimal(const big_int *, char *);
big_int * parse_decimal(const char *);
