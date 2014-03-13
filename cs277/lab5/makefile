CC=gcc
EXEC=demo
OBJS=driver.o collection.o
SOURCES=*.c
FLAGS=-g

all: $(EXEC)

$(EXEC): $(OBJS)
	$(CC) $(FLAGS) $(OBJS) -o $(EXEC)

.c.o:
	$(CC) $(FLAGS) -c *.c

clean:
	rm -f *.o $(EXEC) a.out
