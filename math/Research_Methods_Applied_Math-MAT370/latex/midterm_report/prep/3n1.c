#include <stdio.h>

#define START  2
#define LIMIT 10

void collatz(long int n);

int main(int argc, char **argv){
    long int start = START, stop = LIMIT;
    switch (argc) {
        case 2:
            sscanf(argv[1], "%ld", &start);
            collatz(start);
            break;
        case 3:
            sscanf(argv[1], "%ld", &start);
            sscanf(argv[2], "%ld", &stop);
        case 1:
            for (int i = start; i <= stop; ++i) {
                collatz(i);
                if (i < stop) {
                    printf("-----------------------\n");
                }
            }
            break;
    }

    return 0;
}

void collatz(long int n) {
    printf("%ld\n", n);
    while (n > 1) {
        n = (n % 2 == 0) ? n / 2 : 3 * n + 1;
        printf("%ld\n", n);
    }
}
