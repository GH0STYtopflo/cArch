#include <stdio.h>

int main(void) {
    int n;

    printf("Please enter the value of n: ");
    scanf("%d", &n);

    if (n < 1) {
        printf("\e[31mInvalid value.\e[0m \n");
        return 1;
    }

    // return the first 2 sequence members early
    if (n == 2 || n == 1) return 1;

    int left = 1, right = 1;

    
    for (int i = 3; i <= n; i++) {      
        right += left;
        left = right - left;
    }

    char *suffix;

    if (n > 3) {
        suffix = "th";
    } else if (n == 3) {
        suffix = "rd";
    } else if (n == 2) {
        suffix = "nd";
    } else {
        suffix = "st";
    }
    
    printf("\e[32mThe %s element of the sequence is %d\e[0m\n", suffix, right);
    
    return 0;
}
