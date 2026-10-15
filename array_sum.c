#include <stdio.h>
#include <stdlib.h>

const int ARR_SIZE = 100;
const int RAND_RANGE = 1000;

void fill_random(int array[]) {
    for (int i = 0; i < ARR_SIZE; i++) {
        array[i] = rand() % RAND_RANGE;
    }
}

int sum(int array[]) {
    for (int i = 1; i < ARR_SIZE; i++) {
        // Use array index 0 as the accumulator. I could use a seperate variable as accumulator but I figured the curruent 
        // approach might save us 32 bits of memory.
        array[0] += array[i];
    }

    return array[0];
}

void print_arr(int array[]) {
    printf("array: \n");

    for (int i = 0; i < ARR_SIZE; i++) {
        printf(" %d ", array[i]);
    }

    printf("\n\n");
}

int main() {
    int array[ARR_SIZE];
    fill_random(array);

    print_arr(array);

    printf("\e[32mThe result is: %d\e[0m\n", sum(array));

    return 0;
}

