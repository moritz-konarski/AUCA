#include <stdio.h>
#include <stdint.h>

int main(int argc, char **argv) {

    // unsigned positive 15
    uint8_t a = 0b00001111;
    // singed negative 15 using 2's complement
    int8_t  b = 0b11110001;

    printf("a = %d and b = %d\n", a, b);

    return 0;
}
