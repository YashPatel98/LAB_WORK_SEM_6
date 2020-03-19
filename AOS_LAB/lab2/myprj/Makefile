all: compile out run clean
out :
	cc hello.o -o hello.out
	cc greet.o -o greet.out
compile :
	cc hello.c -c
	cc greet.c -c
run :
	@./hello.out
	@./greet.out
clean:
	@rm hello.o hello.out
	@rm greet.o greet.out
