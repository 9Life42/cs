CC=gcc
EXEC=guesser
OBJS=guesser.a asm.o 
SOURCES=*.s
FLAGS=-m32

all:$(EXEC)

$(EXEC): $(OBJS)
	$(CC) $(FLAGS) $(OBJS) -o $(EXEC)

.s.o:
	$(CC) $(FLAGS) -c *.s

clean:
	rm -f *.o $(EXEC) a.out
