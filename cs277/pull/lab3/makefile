CC=gcc
EXEC=bitfun
OBJS=driver.o bitlib.o
SOURCES=*.c

all: $(EXEC)

$(EXEC): $(OBJS)
	$(CC) $(OBJS) -o $(EXEC)

.c.o:
	$(CC) -c *.c

clean:
	rm -f *.o $(EXEC) a.out
