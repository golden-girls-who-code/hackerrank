function minimumSwaps(arr) {
    // creating an object. Can edit objects with a const as long as I don't reassign the variable. Fun
    const touchedNodes = {};
    // using let to initialize reassignable variables. New declaration keyword helps with scope
    let currentSwaps = 0;
    let totalSwaps = 0;
    
    for (let i = 0; i < arr.length; ++i) {
        // if the node was touched, it's already in the right spot
        if (touchedNodes[i]) {
            continue;
        }
        
        // well, let's "touch" (check) the node to see if it's in the right spot
        touchedNodes[i] = true;
        let nextNode = arr[i] - 1;
        // if the node is not in the right spot...
        while (!touchedNodes[nextNode]) {
            // metaphorically move it to where it should be by incrementing the swap counter
            ++currentSwaps;
            // "touch" the number that was in my spot
            touchedNodes[nextNode] = true;
            // Now let's check if this one can just be moved to the spot I left vacant or a new spot
            nextNode = arr[nextNode] - 1;
        }

        // okay. We broke out of the while loop because all the nodes I touched have a spot
        // if we have swaps to account for
        if (currentSwaps >= 0) {
            //let's add them to the total number of swaps I've don't so far
            totalSwaps = totalSwaps + currentSwaps;
            //And reset the current swap count for my next round of swaps
            currentSwaps = 0;
        }
    };
    return totalSwaps;
}
